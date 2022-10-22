package com.sxdl.product.dc.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateRange;
import cn.hutool.core.date.DateTime;
import cn.hutool.http.HtmlUtil;
import com.sxdl.base.util.DateUtil;
import com.sxdl.product.dc.service.HandleSerice;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class WeiNingDataParseUtil {
    public static String XMLHEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    //    /**
//     * 根据xml数据获取表结构,并根据情况创建或者更新表结构
//     *
//     * @param es xml的根节点
//     * @return 字段列表集合, 如果错误返回空列表
//     */
//    public Set<String> updateDDL(Element es) {
//        try {
//            Set<String> columns = getColumnsOfTable(es);
//            String tname = es.getName();
//            if ("1".equals(handleSerice.ifExistTable(tname))) {//有表
//                List<String> tnameColumns = handleSerice.getColumns(tname);
//                if (tnameColumns.size() > 0) {//有字段
//                    List<String> newadd = tnameColumns.stream().filter(e -> !columns.contains(e)).collect(Collectors.toList());//新增的字段
//                    if (newadd.size() > 0) {//有新增
//                        for (String s : newadd) {
//                            handleSerice.addColumn(tname, s, SqlserverDBType.VARCHAR, null, null);
//                            handleSerice.addColumn(tname + "_temp", s, SqlserverDBType.VARCHAR, null, null);
//                        }
//                    }
//                }
////                List<String> olddel = columns.stream().filter(e -> !tnameColumns.contains(e)).collect(Collectors.toList());//多出来的字段
//            } else {//没表
//                StringBuilder sb = new StringBuilder("create table [" + tname + "] ([");
//                StringBuilder sbtemp = new StringBuilder("create table [" + tname + "_temp] ([");
//                for (String s : columns) {
//                    sb.append(s).append(COLUMNSCRATCH);
//                    sbtemp.append(s).append(COLUMNSCRATCH);
//                }
//                String sql = sb.substring(0, sb.length() - 2) + ")";
//                String sqltemp = sbtemp.append("optime" + COLUMNSCRATCH).substring(0, sbtemp.length() - 2) + ")";
//                handleSerice.selectSqlWithSQL(sql);
//                handleSerice.selectSqlWithSQL(sqltemp);
//            }
//            return columns;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new TreeSet<>();
//        }
//    }
    public static String sucMsgSql = "SELECT @@ROWCOUNT AS 影响行数,'suc' as 状态,'执行成功!' as 信息";
    //    static String COLUMNSCRATCH = "] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL,[";
    @Autowired
    HandleSerice handleSerice;

    public static void main(String[] args) {
//        StringBuilder sb=new StringBuilder("123456789");
//        sb.replace(sb.indexOf("4"),sb.indexOf("4")+2,"abc");
//        System.out.println(sb);
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            StackTraceElement stackTraceElement = e.getStackTrace()[0];
            System.out.println(stackTraceElement.getClassName());
            System.out.println(stackTraceElement.getMethodName());
            System.out.println(stackTraceElement.getLineNumber());
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }


    }

    /**
     * 根据偏移单位和偏移量计算开始时间,然后根据偏移单位拆分成时间节点
     *
     * @param startTime 初始开始时间
     * @param EndTime   结束时间
     * @param rule      偏移单位
     * @param flag      是否开始结束同期抽取,是的话开始结束一样,否的话结束时间增加1偏移单位
     * @return 时间段的列表
     * @throws ParseException
     */
    public List<Map<String, String>> getSplicTimeParam(String startTime, String EndTime, String rule, boolean flag) throws ParseException {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        SimpleDateFormat myFmt = null;
        if (startTime.length() == 10 && EndTime.length() == 10) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd");
        } else if (startTime.length() == 19 && EndTime.length() == 19) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (startTime.length() == 23 && EndTime.length() == 23) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
        DateField dateField = DateField.DAY_OF_YEAR;
        if ("天".equals(rule)) {
            dateField = DateField.DAY_OF_YEAR;
        } else if ("时".equals(rule)) {
            dateField = DateField.HOUR;
        } else if ("周".equals(rule)) {
            dateField = DateField.WEEK_OF_YEAR;
        } else if ("分".equals(rule)) {
            dateField = DateField.MINUTE;
        } else if ("月".equals(rule)) {
            dateField = DateField.MONTH;
        } else if ("年".equals(rule)) {
            dateField = DateField.YEAR;
        }
        //根据开始和结束时间,偏移单位,默认偏移量是1拆分数据
        List<DateTime> dateTimes = CollUtil.newArrayList((Iterable<DateTime>) new DateRange(DateUtil.parse(startTime), DateUtil.parse(EndTime), dateField));
        if (flag) {
            //同参
            String time;
            for (DateTime dt : dateTimes) {
                map = new HashMap<>(2);
                time = dt.toString(myFmt);
                map.put("start", time);
                map.put("end", time);
                list.add(map);
            }
        } else {
            //异参
            for (int i = 0; i < dateTimes.size(); i++) {
                if (i == dateTimes.size() - 1) {
                    break;
                }
                map = new HashMap<>(2);
                map.put("start", dateTimes.get(i).toString(myFmt));
                map.put("end", dateTimes.get(i + 1).toString(myFmt));
                list.add(map);
            }
        }
        return list;
    }


    /**
     * 晋城检验信息
     * @param startTime
     * @param EndTime
     * @param rule
     * @param flag
     * @return
     * @throws ParseException
     */
    public List<String> getSplicTimeParamJc(String startTime, String EndTime, String rule, boolean flag,Integer timelong) throws ParseException {
        List<String> list = new ArrayList<>();
        Map<String, String> map;
        if (startTime.length() == 10 && EndTime.length() == 10 && "分".equals(rule)){
            startTime+=" 00:00:00";
            EndTime+=" 23:59:59";
        }


        SimpleDateFormat myFmt = null;
        if (startTime.length() == 10 && EndTime.length() == 10) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd");
        } else if (startTime.length() == 19 && EndTime.length() == 19) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (startTime.length() == 23 && EndTime.length() == 23) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
        DateField dateField = DateField.DAY_OF_YEAR;
        if ("天".equals(rule)) {
            dateField = DateField.DAY_OF_YEAR;
        } else if ("时".equals(rule)) {
            dateField = DateField.HOUR;
        } else if ("周".equals(rule)) {
            dateField = DateField.WEEK_OF_YEAR;
        } else if ("分".equals(rule)) {
            dateField = DateField.MINUTE;
        } else if ("月".equals(rule)) {
            dateField = DateField.MONTH;
        } else if ("年".equals(rule)) {
            dateField = DateField.YEAR;
        }
        //根据开始和结束时间,偏移单位,默认偏移量是1拆分数据
        List<DateTime> dateTimes = CollUtil.newArrayList((Iterable<DateTime>) new DateRange(DateUtil.parse(startTime), DateUtil.parse(EndTime), dateField,timelong));
        if (flag) {
            //同参
            String time;
            for (DateTime dt : dateTimes) {

                time = dt.toString(myFmt);
                list.add("startDate>" + time+ ";endDate>" + time);

            }
        } else {
            //异参
            for (int i = 0; i < dateTimes.size(); i++) {
                if (i == dateTimes.size() - 1) {
                    break;
                }
                list.add("startDate>" + dateTimes.get(i).toString(myFmt) + ";endDate>" + dateTimes.get(i + 1).toString(myFmt));
            }
        }
        return list;
    }


    /**
     * 获取每个表的字段列表
     *
     * @param es 根节点
     * @return 字段列表
     */
    public Set<String> getColumnsOfTable(Element es) {
        List<Element> elements = es.elements();
        if (elements.isEmpty()) {//是否有子节点
            return new TreeSet<>();
        }
        Set<String> columns = new TreeSet<>();//防止顺序问题引起错乱
        for (Element e : elements) {
            if (e.elements().isEmpty()) {//是否还有子节点,如果有则不添加为字段
                columns.add(e.getName().trim());//子节点的名称,就是字段名
            }
        }
        return columns;
    }

    /**
     * 根据xml数据获取表结构,并根据情况创建或者更新表数据
     *
     * @param bytes   处理好的数据
     * @param isparam 是否有参数
     */
    public String duelData(byte[] bytes, int isparam) throws DocumentException {
        Element rootElements = getRootElementFromXMLString(bytes);
        Set<String> colStrs = getColumnsOfTable(rootElements);
        if (CollUtil.isEmpty(colStrs)) {
            return "状态:suc;影响行数:0;信息:该表没数据";
        }
        List<Element> elements = rootElements.elements();
        StringBuilder sqlall = new StringBuilder("begin try\n");//开始拼接插入总数据表sql
        StringBuilder sbinsert = new StringBuilder("insert into [" + rootElements.getName() + "_temp] ");//插入原始表数据
        StringBuilder sbinsertData = new StringBuilder(" insert into [" + rootElements.getName() + "] ");//插入数据表数据
        StringBuilder cols = new StringBuilder("(");//字段名称列表
        String del = " delete from [" + rootElements.getName() + "]";

        if (1 == isparam) {//有参数,时间段
            del += " where jzh in (@@@@)\n";//删除数据表数据
        } else if (3 == isparam) {//无参数
        } else {//其他配置
            return "状态:suc;影响行数:0;信息:该方案配置的'是否有参数'字段有问题!";
        }
        sqlall.append(del);//先拼接删除数据表sql
        for (String s : colStrs) {//拼接字段名称
            cols.append("[" + s + "],");
        }
        sbinsert.append(cols).append("[optime]) values(");
        sbinsertData.append(cols.substring(0, cols.length() - 1)).append(") values(");
        String optime = DateUtil.now();//给原始表插入时用来标记抽取批次的数据
        int colsize = colStrs.size();
        String val;
        Set<String> jzhs = new HashSet<>();
        int rows = 0;
        for (int i = 0; i < elements.size(); i += colsize) {//循环所有数据,包含很多条数据
            rows++;
            StringBuilder insert = new StringBuilder(sbinsert);//用来装载插入原始表数据sql
            StringBuilder insertData = new StringBuilder(sbinsertData);//用来装载插入数据表数据sql
            List<Element> subs = ListUtil.sub(elements, i, i + colsize);//按照表字段长度截取每一张表的数据
            Iterator<String> iterator = colStrs.iterator();
            while (iterator.hasNext()) {//遍历字段的集合
                String key = iterator.next();
                for (Element e : subs) {//遍历每张表的数据
                    if (key.equals(e.getName().trim())) {//符合的字段
                        val = e.getTextTrim();
                        if (val.contains("/")) {//处理异常数据
                            val = val.replaceAll("/", "-");
                        }
                        if ("jzh".equals(key.toLowerCase())) {//装载数据的jzh,用来后期拼接的删除和插入依据
                            jzhs.add("'" + val + "'");
                        }
                        insert.append("'" + val + "',");
                        insertData.append("'" + val + "',");
                    }
                }
            }
            sqlall.append(insert + "'" + optime + "')").append("\n");
            sqlall.append(insertData.substring(0, insertData.length() - 1) + ")").append("\n");
        }
        int delidnex = sqlall.indexOf("(@@@@)");
        if (0 < delidnex) {//有时间段参数的
            StringBuilder jzhSb = new StringBuilder();
            if (CollUtil.isNotEmpty(jzhs)) {//当前的数据是空的,或者jzh字段丢失
                for (String s : jzhs) {//拼接jzh列表
                    jzhSb.append(s).append(",");
                }
                sqlall.replace(delidnex + 1, delidnex + 5, jzhSb.substring(0, jzhSb.length() - 1));
            }
        }
        sqlall.append(sucMsgSql.replace("@@ROWCOUNT", rows + ""));
        sqlall.append("\nend try\n" +
                "BEGIN catch\n" +
                "\tSELECT @@ROWCOUNT AS 影响行数,'err' as 状态,ERROR_MESSAGE()+'错误号: '+cast(ERROR_NUMBER() as varchar(255))+',严重性: '+cast(ERROR_SEVERITY() as varchar(255))+',错误状态号: '+cast(ERROR_STATE() as varchar(255))+',发生在第 '+cast(ERROR_LINE() as varchar(255))+' 行' as 信息\n" +
                "end catch");
        System.out.println(sqlall);
        Map<String, Object> maps = handleSerice.selectSqlWithSQL(sqlall.toString()).get(0);
        return "状态:" + maps.get("状态") + ";影响行数:" + maps.get("影响行数") + ";信息:" + maps.get("信息");
    }

    /**
     * 根据原始xml数据制作标准的xml字符串
     *
     * @param strXml 全部数据
     * @return 标准的xml字符串
     * @throws DocumentException
     */
    public byte[] getBytesFromFullXMLString(String strXml, String tagNode) throws UnsupportedEncodingException {
        String ahead = "<" + tagNode + ">";
        String end = "</" + tagNode + ">";
        strXml = HtmlUtil.unescape(strXml);
        if (strXml.contains(ahead) && strXml.contains(end)) {
            strXml = strXml.substring(strXml.indexOf(ahead), strXml.indexOf(end) + end.length());
            strXml = XMLHEADER + strXml;
            return strXml.getBytes("UTF-8");
        }
        return new byte[]{};
    }

    /**
     * 根据重新制作好的xml格式字符串解析成字段列表
     *
     * @param bytes 重新制作好的xml格式字符串
     * @return 字段列表
     * @throws DocumentException
     */
    public Map<String, Set<String>> getColumnsFromXMLString(byte[] bytes) throws DocumentException {
        Map<String, Set<String>> map = new HashMap<>();
        Element root = getRootElementFromXMLString(bytes);
        map.put(root.getName(), getColumnsOfTable(root));
        return map;
    }

    /**
     * 根据重新制作好的xml格式字符串解析Element根节点
     *
     * @param bytes 重新制作好的xml格式字符串
     * @return Element  根节点
     * @throws DocumentException
     */
    public Element getRootElementFromXMLString(byte[] bytes) throws DocumentException {
        Document doc = getRootDocumentFromXMLString(bytes);
        return doc.getRootElement();
    }

    /**
     * 根据重新制作好的xml格式字符串解析Element根节点
     *
     * @param bytes 重新制作好的xml格式字符串
     * @return Element  根节点
     * @throws DocumentException
     */
    public Document getRootDocumentFromXMLString(byte[] bytes) throws DocumentException {
        SAXReader reader = new SAXReader();
        //获取xml中根节点信息
        return reader.read(new ByteArrayInputStream(bytes));
    }
}
