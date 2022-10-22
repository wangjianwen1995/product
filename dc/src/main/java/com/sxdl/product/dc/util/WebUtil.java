package com.sxdl.product.dc.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.sxdl.product.dc.dao.dao1.DcColumnDao;
import com.sxdl.product.dc.dao.dao1.DcTableDao;
import com.sxdl.product.dc.entity.DcRequestAPI;
import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


///***
// *   院感系统 web接口  对接工具
// *
// *     contentType: application/soap+xml; charset=utf-8
// *
// *   请求：
// *
// *      <?xml version="1.0" encoding="utf-8"?>
// *          <soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
// *          <soap12:Body>
// *              <GetPatientRecords xmlns="http://tempuri.org/">
// *               <blh>string</blh>
// *              </GetPatientRecords>
// *              </soap12:Body>
// *          </soap12:Envelope>
// *
// *
// * <?xml version="1.0" encoding="utf-8"?>
// * <soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
// *   <soap12:Body>
// *     <ETL_HIS_YZXX xmlns="http://tempuri.org/">
// *       <startDate>dateTime</startDate>
// *       <endDate>dateTime</endDate>
// *     </ETL_HIS_YZXX>
// *   </soap12:Body>
// * </soap12:Envelope>
// *
// *
// * <?xml version="1.0" encoding="utf-8"?>
// * <soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
// *   <soap12:Body>
// *     <ETL_His_yzlb xmlns="http://tempuri.org/" />
// *   </soap12:Body>
// * </soap12:Envelope>
// *
// *
// */


@Deprecated
public class WebUtil {
    public static final String LineBreak = "\r\n";
    public static final String Tab = "\t";
    private static DcTableDao dcTableDao;
    private static com.sxdl.base.util.scheduled.SpringContextUtils SpringContextUtils;

    /**
     * @return 拼接web 接口 soap协议的头信息 --->字符串内容
     */
    public static String getWebSoapHeaderStr() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
        sb.append("  <soap12:Body>");
        return sb.toString();
    }

    /**
     * @param nodeName
     * @return 返回web接口soap协议的尾信息（时间类型入参）
     */
    public static String getWebSoapTailTimeParamStr(String nodeName, LinkedHashMap<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("<" + nodeName + " xmlns=\"http://tempuri.org/\">");
        params.forEach((k, v) -> sb.append("<" + k + ">" + v + "</" + k + ">"));
        sb.append("</" + nodeName + ">");
        sb.append("  </soap12:Body>");
        sb.append("</soap12:Envelope>");
        return sb.toString();
    }

    /**
     * @param nodeName
     * @param param
     * @return 返回web接口soap协议的尾信息（病历号/单个参数 类型入参）
     */
    public static String getWebSoapTailBlhParamStr(String nodeName, LinkedHashMap<String, String> param) {
        StringBuilder sb = new StringBuilder();
        sb.append("    <" + nodeName + " xmlns=\"http://tempuri.org/\">");
        param.forEach((k, v) -> sb.append("<" + k + ">" + v + "</" + k + ">"));
        sb.append("</" + nodeName + ">");
        sb.append("  </soap12:Body>");
        sb.append("</soap12:Envelope>");
        return sb.toString();
    }

    /**
     * @param nodeName
     * @return 返回web接口soap协议的尾信息（没有入参类型的）
     */
    public static String getWebSoapTailNoParamStr(String nodeName) {
        StringBuilder sb = new StringBuilder();
        if ("ETL_TDoctor_Info".equals(nodeName)) {
            sb.append("    <ETL_TDoctor xmlns=\"http://tempuri.org/\" />");
        } else if ("ETL_TDoctor_ks".equals(nodeName)) {
            sb.append("    <ETL_TDoctor_ks_Info xmlns=\"http://tempuri.org/\" />");
        } else {
            sb.append("    <" + nodeName + " xmlns=\"http://tempuri.org/\" />");
        }
        sb.append("  </soap12:Body>");
        sb.append("</soap12:Envelope>");
        return sb.toString();

    }

    /**
     * @param url         路径
     * @param contentType 类型
     * @param webSoapStr  soap协议的字符串
     */
    public static HttpResponse getResponse(String url, String contentType, String webSoapStr) throws Exception {
        HttpResponse response = HttpRequest.post(url).contentType(contentType).body(webSoapStr).execute();
        return response;
    }

    /***
     *
     * @param httpResponse
     * @return 请求web接口。返回document 对象
     * @throws Exception
     */
    public static Document getDocument(HttpResponse httpResponse) throws Exception {
        SAXReader reader = new SAXReader();
        InputStream inputStream = httpResponse.bodyStream();
        Document read = reader.read(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
        return read;
    }

    /**
     * @param document
     * @param strNode
     * @return 解析xml中的 特殊节点，返回建表字段
     */
    public static Set<String> getTableColumns(Document document, String strNode) {
        Set<String> set = new HashSet<>();  //避免字段重复
        try {
            List<Node> nodes = document.selectNodes("//" + strNode);
            if (nodes.size() == 0) {
                return set;
            }
            Element node = (Element) nodes.get(1);
            Iterator<Element> elenode = node.elementIterator();
            while (elenode.hasNext()) {
                Element next = elenode.next();
                //id 默认写死不需要  外部 提供
                set.add(next.getName());
                set.add("dcid");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }

    /**
     * 返回 响应相关数据
     *
     * @param response
     * @param dcRequestAPI
     * @return
     * @throws Exception
     */
    public static DcRequestAPI getResponseInfo(HttpResponse response, DcRequestAPI dcRequestAPI) throws Exception {
        // Map<String, List<String>> headers1 = response.headers();
        String cookies = response.getCookies().toString();
        String headers = response.headers().toString();
        String body = response.body();
        dcRequestAPI.setRespheader(headers);
        dcRequestAPI.setCookie(cookies);
        dcRequestAPI.setRespbody(body);
        return dcRequestAPI;

    }

    /**
     * @param params 格式要求: startDate>value1;endDate>value2
     * @return
     */
    public static LinkedHashMap<String, String> getKeyValues(String params) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String[] split = params.split(";");
        for (String str : split) {
            String[] ky = str.split(">");
            map.put(ky[0], ky[1]);
        }
        return map;
    }

    /***
     * 将时间范围根据规则切割开成 若干份数据 用于遍历 数据参数
     *
     * @param startTime  开始时间
     * @param EndTime    结束时间
     * @param rule        规则：月/日/周/时/分
     * @param timeLong     规则单位
     * @return
     * @throws ParseException
     */
    public static List<String> getSplicTimeParam(String startTime, String EndTime, String rule, Integer timeLong) throws ParseException {

        //重设 map集合的排序规则
        List<String> list = new ArrayList<>();
        //LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // 将要存入map中的开始结束时间
        String start = "";
        String end = "";
        boolean b = true;
        //SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Calendar instance = Calendar.getInstance();
        while (b) {
            if ("".equals(end)) {
                startDate = myFmt.parse(EndTime);
            } else {
                startDate = myFmt.parse(start);
            }
            instance.setTime(startDate);
            if ("天".equals(rule)) {
                instance.add(Calendar.DAY_OF_YEAR, -timeLong);
            } else if ("时".equals(rule)) {
                instance.add(Calendar.HOUR_OF_DAY, -timeLong);
            } else if ("月".equals(rule)) {
                instance.add(Calendar.MONTH, -timeLong);
            } else if ("周".equals(rule)) {
                instance.add(Calendar.WEEK_OF_YEAR, -timeLong);
            } else if ("分".equals(rule)) {
                instance.add(Calendar.MINUTE, -timeLong);
            }
            start = myFmt.format(instance.getTime());
            instance.setTime(startDate);
            end = myFmt.format(instance.getTime());
            ////startDate>value1;endDate>value2
            list.add("startDate>" + start + ";endDate>" + end);
            if (myFmt.parse(startTime).getTime() >= myFmt.parse(start).getTime()) {
                b = false;
            }
        }
        return list;
    }

    /**
     * @param tableName 需创 建表的名称
     * @param columns   建表的列名   （类型默认都是varchar(500) 除特殊字段）
     * @return 数据库中没有该表存在，创建该表
     */
    public static String getSqlTextNotExists(String tableName, Set<String> columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE [dbo].").append(tableName).append("(").append(LineBreak);
        sb.append(Tab).append("[dcid] [int] IDENTITY(1,1) NOT NULL,").append(LineBreak);
        for (String column : columns) {
            //对存放大数据的字段做特殊处理
            sb.append(Tab).append("[" + column + "] [VARCHAR](500)  NULL,").append(LineBreak);
          /*  if ("cWriteName".equals(column)) {
                sb.append(Tab).append("[" + column + "] [TEXT]  NULL,").append(LineBreak);
            } else {
                sb.append(Tab).append("[" + column + "] [VARCHAR](500)  NULL,").append(LineBreak);
            }*/
        }
        sb.append(Tab).append("CONSTRAINT [PK_").append(tableName).append("] PRIMARY KEY CLUSTERED ( [dcid] ASC )").append(LineBreak);
        sb.append(" WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]").append(LineBreak).append(LineBreak);
        return sb.toString();
    }

    /***
     *
     * @param tableName  需要添加字段的表名称
     * @param columnAdd  需要添加的 字段名称集
     */

    public static String getSqlTextIsExists(String tableName, List<String> columnAdd) {
        StringBuilder sb = new StringBuilder();
        for (String column : columnAdd) {
            sb.append("alter table " + tableName + " add " + column + " varchar(500) null").append(LineBreak);
        }
        return sb.toString();

    }

    /***
     *
     * @param response
     * @param tag
     * @return 解析xml数据
     * @throws Exception
     */

    public static List<LinkedHashMap<String, String>> getAnalysisNode(HttpResponse response, String tag) throws Exception {
        List<LinkedHashMap<String, String>> mapList = new ArrayList<>();
        Document document = getDocument(response);
        List<Node> nodes = document.selectNodes("//" + tag);
        Iterator<Node> iterator = nodes.iterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            Iterator<Element> elementIterator = element.elementIterator();
            while (elementIterator.hasNext()) {
                LinkedHashMap<String, String> columnMap = new LinkedHashMap<>();
                Element next = elementIterator.next();
                columnMap.put(next.getName(), next.getTextTrim());
                mapList.add(columnMap);

            }
        }
        return mapList;
    }

    /***
     *
     * @param tag
     * @param url
     * @param contentType
     * @return 获取 一个web接口中的数据 集合(isparam=3 没有参数类型的web接口)
     */
    public static List<LinkedHashMap<String, String>> getTableDate(String tag, String url, String contentType) throws Exception {
        StringBuilder sb = new StringBuilder();
        String webSoapHeaderStr = getWebSoapHeaderStr();
        String webSoapTailStr = getWebSoapTailNoParamStr(tag);
        String webString = sb.append(webSoapHeaderStr).append(webSoapTailStr).toString();
        HttpResponse response = getResponse(url, contentType, webString);
        List<LinkedHashMap<String, String>> mapList = getAnalysisNode(response, tag);
        return mapList;
    }

    /**
     * @param tag
     * @param url
     * @param contentType
     * @param params
     * @return 获取 一个web接口中的数据 集合(isparam = 1 时间范围参数类型 的web接口)
     * @throws Exception
     */
    public static List<LinkedHashMap<String, String>> getTableTimeDate(String tag, String url, String contentType, String params) throws Exception {
        StringBuilder sb = new StringBuilder();
        String webSoapHeaderStr = getWebSoapHeaderStr();
        LinkedHashMap<String, String> keyValues = getKeyValues(params);
        String webSoapTailStr = getWebSoapTailTimeParamStr(tag, keyValues);
        String webString = sb.append(webSoapHeaderStr).append(webSoapTailStr).toString();
        HttpResponse response = getResponse(url, contentType, webString);
        List<LinkedHashMap<String, String>> mapList = getAnalysisNode(response, tag);
        return mapList;

    }

    /***
     *
     * @param tag   接口标签(表名称)
     * @param url
     * @param contentType
     * @return 获取 一个web接口中的数据 集合(isparam = 2 单个参数类型 的web接口)
     * @throws Exception
     */
    public static List<LinkedHashMap<String, String>> getTableBlhDate(String tag, String url, String contentType, String paramStr) throws Exception {
        StringBuilder sb = new StringBuilder();
        String webSoapHeaderStr = getWebSoapHeaderStr();
        LinkedHashMap<String, String> keyValue = getKeyValues(paramStr);
        String webSoapTailStr = getWebSoapTailBlhParamStr(tag, keyValue);
        String webString = sb.append(webSoapHeaderStr).append(webSoapTailStr).toString();
        HttpResponse response = getResponse(url, contentType, webString);
        List<LinkedHashMap<String, String>> mapList = getAnalysisNode(response, tag);
        return mapList;
    }

    /**
     * @param tag 表名称
     * @param map 一条数据与字段
     * @return 根据集合 生成 select where 与 insert into table 的sql 可执行脚本
     */
    public static String getInsertTableSql(String tag, LinkedHashMap<String, String> map) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        map.forEach((k, v) -> {
            //  key = '我' and name = '132' and
            sb1.append(" ").append(k).append(" = ").append("'" + v + "'").append(" and ");
            // sql 拼接列名那块
            sb2.append(k).append(",");
            //sql拼接 values那块
            sb3.append("'" + v + "'").append(",");
        });
        sb1.insert(0, " IF NOT EXISTS( Select * From " + tag + " Where ");
        sb1.append(" 1 = 1)").append(LineBreak);
        sb1.append("BEGIN").append(LineBreak);
        sb1.append(Tab).append(" INSERT INTO " + tag + "(").append(LineBreak);
        sb2.deleteCharAt(sb2.length() - 1).append(" ) VALUES (");
        sb3.deleteCharAt(sb3.length() - 1).append(")");
        sb1.append(sb2).append(sb3).append(LineBreak);
        sb1.append("end").append(LineBreak);
        String sqlText = sb1.toString();
        return sqlText;
    }

    /**
     * @param tag 表名称
     * @param map 一条数据与字段
     * @return 根据集合 生成 select where 与 insert into table 的sql 可执行脚本
     */
    public static String getInsertTableSql2(String tag, Map map) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        /*map.forEach((k, v) ->{
            //  key = '我' and name = '132' and
            sb1.append(" ").append(k.toString()).append(" = ").append("'"+v.toString()+"'").append(" and ");
            // sql 拼接列名那块
            sb2.append(k.toString()).append(",");
            //sql拼接 values那块
            sb3.append("'"+v.toString()+"'").append(",");
        } );*/

        for (Object key : map.keySet()) {
            String k = key + "";
            String v = map.get(key) + "";
            sb1.append(" ").append(k).append(" = ").append("'" + v + "'").append(" and ");
            // sql 拼接列名那块
            sb2.append(k).append(",");
            //sql拼接 values那块
            sb3.append("'" + v + "'").append(",");
        }

       /* for(Map.Entry<Object,Object>  entry : map.entrySet()){
            String k = entry.getKey()+"";
            String v = entry.getValue()+"";
            sb1.append(" ").append(k).append(" = ").append("'"+v+"'").append(" and ");
            // sql 拼接列名那块
            sb2.append(k).append(",");
            //sql拼接 values那块
            sb3.append("'"+v+"'").append(",");
        }*/

        sb1.insert(0, " IF NOT EXISTS( Select * From " + tag + " Where ");
        sb1.append(" 1 = 1)").append(LineBreak);
        sb1.append("BEGIN").append(LineBreak);
        sb1.append(Tab).append(" INSERT INTO " + tag + "(").append(LineBreak);
        sb2.deleteCharAt(sb2.length() - 1).append(" ) VALUES (");
        sb3.deleteCharAt(sb3.length() - 1).append(")");
        sb1.append(sb2).append(sb3).append(LineBreak);
        sb1.append("end").append(LineBreak);
        String sqlText = sb1.toString();
        return sqlText;
    }

    /**
     * @return 生成作业的结束时间（当前调用时间）
     */
    public static String getAutoEndDateTime() {
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        String endTime = myFmt.format(date);
        return endTime;
    }

    /**
     * @param timeLong
     * @param paramunit
     * @return 生成作业的开始时间
     */
    public static String getAutoStartTiem(Integer timeLong, String paramunit) {
        //SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        if ("天".equals(paramunit)) {
            //instance.add(Calendar.DAY_OF_YEAR,-timeLong);
            instance.add(Calendar.DAY_OF_YEAR, -10);
        } else if ("时".equals(paramunit)) {
            instance.add(Calendar.HOUR_OF_DAY, -timeLong);
        } else if ("月".equals(paramunit)) {
            instance.add(Calendar.MONTH, -timeLong);
        } else if ("周".equals(paramunit)) {
            instance.add(Calendar.WEEK_OF_YEAR, -timeLong);
        } else if ("分".equals(paramunit)) {
            instance.add(Calendar.MINUTE, -timeLong);
        }
        String startTime = myFmt.format(instance.getTime());
        return startTime;
    }

    public static DcTableDao getDcTableDao() {
        DcTableDao bean = (DcTableDao) SpringContextUtils.getBean("dcTableDao");
        return bean;
    }

    public static DcColumnDao getDcColumnDao() {
        DcColumnDao bean = (DcColumnDao) SpringContextUtils.getBean("dcColumnDao");
        return bean;
    }

    public static void main(String[] args) throws Exception {
        String str = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<string xmlns=\"http://tempuri.org/\">&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;\n" +
                "&lt;root&gt;\n" +
                "&lt;Result&gt;&lt;Data&gt;&lt;yqid&gt;1&lt;/yqid&gt;&lt;yqName&gt;怀仁仁德综合医院(大同市第三人民医院怀仁分院)&lt;/yqName&gt;&lt;/Data&gt;&lt;/Result&gt;\n" +
                "&lt;/root&gt;\n" +
                "</string>";
        String decode = StringEscapeUtils.unescapeXml(str);
        int i = decode.indexOf("<root>");
        String str2 = decode.substring(i);
        String ss = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <string>" + str2;

        //System.out.println(ss);


    }


}

















