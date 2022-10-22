package com.sxdl.product.dc.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.scheduled.SpringContextUtils;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcRequestAPI;
import com.sxdl.product.dc.entity.DcScheduleRule;
import lombok.SneakyThrows;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *  此类过期 其使用WebUtil
 * 改工具类
 * 功能一：通过soap方式远程调用web接口的数据
 * 功能二：将远程数据转成流，在流中直接解析xml类型数据
 * 功能三：动态的创建Controller、Dao、Entity 等java 和文件Sql
 *
 *
 */
@Deprecated
public class WebSopJavaReflex {

//    public static Document document;
//    public static List<String> list;

    public  static  final String ENTITYPATH="C:\\javaBean\\entity\\yg\\";
    public  static  final String DAOPATH="C:\\javaBean\\dao2\\";
    public  static  final String CONTROLLERPATH="C:\\javaBean\\controller\\";
    public  static  final String CREATETALBESQL="C:\\javaBean\\table.sql\\";

    public  static  final String LineBreak ="\r\n";
    public  static  final String Tab="\t";

    public static void creataAllFiles() throws  Exception{
        //1 获取properties 配置数据 告诉解析数据哪个节点，和实体的name
        List<String> properties = getPropert();
        for (String property : properties) {
            //2根据一个节点名称获取一个Document对象
            Document document = getDocument(property);
            //3 接续 Document 对象 获取 数据库表字段（entity属性值 ）
            Set<String> tableColumn = getTableColumn(document, property);
            // 4 拼接java类、和sql脚本 字符串
            String strEntity = strEntity(property, tableColumn);
            // 5 动态生成 C:\javaBean\entity\yg\XXXXentity.java
            createFileJavaBean(strEntity,ENTITYPATH,1,property);
            // 生成C:\javaBean\dao2\xxxxDao.java
            createFileJavaBean(strDao(property),DAOPATH,2,property);
            // 生成 C:\javaBean\controller\XXXController.java
            createFileJavaBean(strController(property),CONTROLLERPATH,3,property);
            //生成 C:\javaBean\table.sql脚本文件
            createFileJavaBean(strSqlTable(property,tableColumn),CREATETALBESQL,4,property);
        }
    }

    public static List<String> getPropert() throws  Exception{
        List<String> list = new ArrayList<>();
        InputStream resourceAsStream = WebSoapUtil.class.getClassLoader().getResourceAsStream("analysisXml.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        Enumeration<?> enumeration = properties.propertyNames();
        // 便利propertties 配置文件的中属性值
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = properties.getProperty(key);
            list.add(value);
            //  System.out.println("Key:" + key + ",Value:" + value);
        }
        return list;
    }


    /**
     * 通过远程连接获取 Document对象
     * @param strNodeName
     * @return
     * @throws Exception
     */
    public static Document getDocument (String strNodeName) throws  Exception{
        Document document=null;
        String url="http://172.180.100.18:10012/HospitalInfection.asmx";
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
        sb.append("  <soap12:Body>");

        //不同接口的入参不同
        if("ETL_TDoctor_Info".equals(strNodeName)){
            sb.append("    <ETL_TDoctor xmlns=\"http://tempuri.org/\" />");
        }else if("ETL_HIS_YZXX".equals(strNodeName)){
            sb.append("<ETL_HIS_YZXX xmlns=\"http://tempuri.org/\">");
            sb.append("<startDate>"+"2020-07-01"+"</startDate>");
            sb.append("<endDate>"+"2020-07-02"+"</endDate>");
            sb.append("</ETL_HIS_YZXX>");
        }
        sb.append("  </soap12:Body>");
        sb.append("</soap12:Envelope>");
        //String body = HttpRequest.post(url).contentType("application/soap+xml;charset=utf-8").body(sb.toString()).execute().body();
        // 正式环境使用
        //FileInputStream inputStream = (FileInputStream)HttpRequest.post(url).contentType("application/soap+xml;charset=utf-8").body(sb.toString()).execute().bodyStream();
        SAXReader reader = new SAXReader();
        //  Document document=reader.read(new BufferedReader(new InputStreamReader(getInputStream(), "UTF-8")));
        //本地测试使用
        if("ETL_TDoctor_Info".equals(strNodeName)){
            document=reader.read(new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\医务人员信息.xml")), "UTF-8")));
        }else if("ETL_HIS_YZXX".equals(strNodeName)) {
            document=reader.read(new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\ETL_HIS_YZXX.xml")), "UTF-8")));

        }
        return document;
    }


    /**
     *  获取到sql数据表中的字段名称  数据类型统一全部使用String---》varchar
     */
    public static Set<String> getTableColumn(Document document,String strNode){
        Set<String> set = new HashSet<>();
        try {
            List<Node> nodes = document.selectNodes("//"+strNode);
            if (nodes.size ()==0){
                return set;
            }
            Element node = (Element)nodes.get(1);
            Iterator<Element> elenode = node.elementIterator();
            while (elenode.hasNext()) {
                Element next = elenode.next();
                //id 默认写死不需要  外部 提供
                set.add(next.getName());
                if(!set.contains("dcid")){
                    set.add("dcid");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }





    /**
     *
     * @param  entityname  类名称
     * @return  拼接出来的实体类字符串
     *
     *
     */

    public static String strEntity(String entityname,Set<String> set){
        StringBuilder sb = new StringBuilder();
        sb.append("package com.sxdl.product.dc.entity.yg;").append(LineBreak);
        sb.append("import lombok.Data;").append(LineBreak);
        sb.append("import javax.persistence.Column;").append(LineBreak);
        sb.append("import javax.persistence.Id;").append(LineBreak);
        sb.append("import javax.persistence.Table;").append(LineBreak);
        sb.append("import javax.validation.constraints.NotBlank;").append(LineBreak);
        sb.append("@Data").append(LineBreak);
        sb.append("@Table(name = \""+entityname+"\")").append(LineBreak);
        sb.append("public class ").append(entityname).append(" {").append(LineBreak);
        sb.append(Tab).append("private static final long serialVersionUID = 1L;").append(LineBreak);
        sb.append(Tab).append("@Id").append(LineBreak);
        sb.append(Tab).append("@NotBlank()").append(LineBreak);
        sb.append(Tab).append("private Integer id;").append(LineBreak);
        for (String  column : set) {
            sb.append(Tab).append("@Column(name = \"").append(column).append("\")").append(LineBreak);
            sb.append(Tab).append("private String ").append(column).append(";").append(LineBreak);
        }
        sb.append(LineBreak).append("}");
        return sb.toString();
    }


    /**
     *
     * @param entityName 实体名称
     * @return   拼接好的dao字符串
     */
    public static  String strDao(String entityName){
        StringBuilder sb = new StringBuilder();
        sb.append("package com.sxdl.product.dc.dao.dao2;").append(LineBreak).append(LineBreak);
        sb.append("import com.sxdl.product.dc.dao.BaseDao;").append(LineBreak);
        sb.append("import com.sxdl.product.dc.entity.yg.").append(entityName).append(";").append(LineBreak);
        sb.append("public interface ").append(entityName).append("Dao extends BaseDao<").append(entityName).append("> {").append(LineBreak).append(LineBreak).append("}");
        return sb.toString();
    }


    /**
     * 拼接controller 字符串类
     * @param entityName
     * @return
     */
    public static String strController(String entityName){
        StringBuilder sb = new StringBuilder();
        sb.append("import com.sxdl.product.dc.dao.dao2.").append(entityName).append("Dao;").append(LineBreak);
        sb.append("import com.sxdl.product.dc.entity.yg.").append(entityName).append(";").append(LineBreak);
        sb.append("import com.sxdl.product.dc.util.ResultUtil;").append(LineBreak);
        sb.append("import io.swagger.annotations.Api;").append(LineBreak);
        sb.append("import io.swagger.annotations.ApiOperation;").append(LineBreak);
        sb.append("import org.springframework.beans.factory.annotation.Autowired;").append(LineBreak);
        sb.append("import org.springframework.web.bind.annotation.*;").append(LineBreak);
        sb.append("import java.util.ArrayList;").append(LineBreak).append(LineBreak);
        sb.append("import java.util.List;").append(LineBreak).append(LineBreak);
        sb.append("@Api(tags=\"").append(entityName).append("接口类型\")").append(LineBreak);
        sb.append("@RestController").append(LineBreak);
        sb.append("@RequestMapping(\"/").append(entityName).append("\")").append(LineBreak);
        sb.append("@ResponseBody").append(LineBreak);
        sb.append("public class ").append(entityName).append("Controller {").append(LineBreak).append(LineBreak);
        sb.append(Tab).append("@Autowired").append(LineBreak);
        sb.append(Tab).append("private ").append(entityName).append("Dao ").append(entityName.toLowerCase().replace("_","")+"Dao").append(";").append(LineBreak);
        sb.append(Tab).append("@GetMapping(\"/findAll\")").append(LineBreak);
        sb.append(Tab).append("public ResultUtil findAll(@RequestBody ").append(entityName).append(" ").append(entityName.toLowerCase()).append("){").append(LineBreak);
        sb.append(Tab).append ( Tab ).append("List<"+ entityName +"> list = new ArrayList<>();").append(LineBreak);
        sb.append(Tab).append(Tab).append("try{").append(LineBreak);
        sb.append(Tab).append(Tab).append(Tab).append("list = ").append(entityName.toLowerCase().replace("_","")+"Dao").append(".selectAll();").append(LineBreak);
        sb.append(Tab).append(Tab).append("}catch (Exception e){").append(LineBreak);
        sb.append(Tab).append(Tab).append(Tab).append(Tab).append("return ResultUtil.error(e.getMessage());").append(LineBreak);
        sb.append(Tab).append(Tab).append("}").append(LineBreak);
        sb.append(Tab).append(Tab).append("return ResultUtil.success(list);").append(LineBreak);
        sb.append(Tab).append("}").append(LineBreak);

        //保存方法
        sb.append(Tab).append(" @PostMapping(\"/insert\")").append(LineBreak);
        sb.append(Tab).append(" public ResultUtil  insert(@RequestBody  List  "+entityName.toLowerCase().replace("_","")+"){").append(LineBreak);
        sb.append(Tab).append(Tab).append("try {").append(LineBreak);
        sb.append ( Tab ).append ( Tab ).append ( "for (Object  o : "+ entityName.toLowerCase().replace("_","") +"){"  ).append ( LineBreak );
        sb.append(Tab).append(Tab).append(Tab).append(entityName.toLowerCase().replace("_","")+"Dao.insertSelective( ("+entityName+")o);").append(LineBreak);
        sb.append ( Tab ).append ( Tab ).append ( "}" ).append ( LineBreak );
        sb.append(Tab).append(Tab).append("}catch (Exception e){").append(LineBreak);
        sb.append(Tab).append(Tab).append(Tab).append(" ResultUtil.error(e.getMessage());").append(LineBreak);
        sb.append(Tab).append(Tab).append("}").append(LineBreak);
        sb.append(Tab).append(Tab).append("return ResultUtil.success(\"添加成功\");").append(LineBreak).append(LineBreak);
        sb.append(Tab).append("}").append ( LineBreak ).append ( LineBreak );
        sb.append("}");
        return sb.toString();
    }



    public static String strSqlTable(String tableName,Set<String> set){
        StringBuilder sb = new StringBuilder();
        sb.append("USE [dc]").append(LineBreak);
        sb.append("if exists (select * from sysobjects where id = object_id('").append(tableName).append("')) BEGIN");
        sb.append(Tab).append(" DROP TABLE ").append(tableName).append(" end").append(LineBreak);
        sb.append("CREATE TABLE [dbo].").append(tableName).append("(").append(LineBreak);
        sb.append(Tab).append("[id] [int] IDENTITY(1,1) NOT NULL,").append(LineBreak);
        for (String column : set) {
            //对存放大数据的字段做特殊处理
            if("cWriteName".equals(column)){
                sb.append(Tab).append("["+column+"] [TEXT]  NULL,").append(LineBreak);
            }else {
                sb.append(Tab).append("["+column+"] [VARCHAR](500)  NULL,").append(LineBreak);
            }
        }
        sb.append(Tab).append("CONSTRAINT [PK_").append(tableName).append("] PRIMARY KEY CLUSTERED ( [id] ASC )").append(LineBreak);
        sb.append(" WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]").append(LineBreak).append(LineBreak);
        return sb.toString();
    }



    /**
     * strJavaBean：需要打印的字符串
     * path：文件输出路径
     * type: 文件后缀类型
     * javaName：除sql之外，java类name  sql固定的文件名，数据采取追加的方式
     * 将拼接好的str字符串java类 输出到java文件中
     */

    public  static void createFileJavaBean(String strJavaBean,String path,Integer type,String javaName) throws  Exception{
        //path ="C:\javaBean\entity\yg\ETL_TDoctor_Info.java"

        FileOutputStream fileOutputStream;
        String javaFile = "";
        if(1==type){
            javaFile = path+javaName+".java";
        }else if(2==type){
            javaFile = path+javaName+"Dao.java";
        }else if(3==type){
            javaFile = path+javaName+"Controller.java";
        }else if(4==type){
            javaFile = path;
        }
        File file  =  new File(javaFile);

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        if(!file.exists()){
            file.createNewFile();
        }

        if(4==type){
            fileOutputStream =  new FileOutputStream(file,true);
        }else{
            fileOutputStream =  new FileOutputStream(file);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        bw.write(strJavaBean);
        bw.flush();
        bw.close();
    }


    /**
     *
     * 获取 某个接口的所有数据
     * @param strNode
     */
    public static List<Map<String,String>> getDataOneTable(Document document,String strNode,Set<String> columnName ){
        List<Map<String,String>> mapList = new ArrayList<>();

        try {
            List<Node> nodes = document.selectNodes("//"+strNode);
            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext()){
                Element element = (Element)iterator.next();
                Iterator<Element> elementIterator = element.elementIterator();
                while (elementIterator.hasNext()){
                    Map<String,String> map = new HashMap<>();
                    Element next = elementIterator.next();
                    map.put(next.getName(),next.getTextTrim());
                    mapList.add(map);
                    //System.out.println("名称："+next.getName()+" 值："+next.getTextTrim());

                }
            }
        }catch (Exception e){
            e.getMessage();
        }
        return  mapList;
    }



    /**
     *
     * @param strNodeName
     * @return
     * @throws Exception
     */
    /**
     *通过前端返回来的url个请求方式远程测试连接
     * @param strNodeName  节点名称
     * @param contentType  前端返回类型
     * @param params        参数
     * @return
     * @throws Exception
     */
    public static ResultUtil getResponse (int isparam,String url,String strNodeName, String contentType,Map<String,String> params) throws  Exception{
        //String url="http://172.180.100.18:10012/HospitalInfection.asmx";
        Document document=null;
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
        sb.append("  <soap12:Body>");
        if(3==isparam){//无参
            if("ETL_TDoctor_Info".equals ( strNodeName )){
                sb.append("    <ETL_TDoctor xmlns=\"http://tempuri.org/\" />");
            }else if ("ETL_TDoctor_ks".equals ( strNodeName )){
                sb.append("    <ETL_TDoctor_ks_Info xmlns=\"http://tempuri.org/\" />");
            }else {
                sb.append("    <"+strNodeName+" xmlns=\"http://tempuri.org/\" />");
            }
        }else if(1==isparam){  //有参 -->时间参数
            sb.append("<"+strNodeName+" xmlns=\"http://tempuri.org/\">");
            params.forEach((k, v) -> sb.append("<"+k+">"+v+"</"+k+">"));
            sb.append("</"+strNodeName+">");
        }else if(2==isparam){


            sb.append("<"+strNodeName+" xmlns=\"http://tempuri.org/\">");
            params.forEach((k, v) -> sb.append("<"+k+">"+v+"</"+k+">"));
            sb.append("</"+strNodeName+">");
        }
        sb.append("  </soap12:Body>");
        sb.append("</soap12:Envelope>");

        /*
         String body = HttpRequest.post(url).contentType("application/soap+xml;charset=utf-8").body(sb.toString()).execute().body();
            // System.out.println(body.substring(0,1000));
            FileInputStream inputStream = (FileInputStream)HttpRequest.post(url).contentType("application/soap+xml;charset=utf-8").body(sb.toString()).execute().bodyStream();


        * */
        InputStream inputStream = HttpRequest.post ( url ).contentType ( contentType ).body ( sb.toString () ).execute ().bodyStream ();
        // String body = HttpRequest.post ( url ).contentType ( contentType ).body ( sb.toString () ).execute ().body ();

        //FileInputStream inputStream = (FileInputStream)HttpRequest.post(url).contentType(contentType).body(sb.toString()).execute().bodyStream();
        SAXReader reader = new SAXReader();
        document=reader.read(new BufferedReader(new InputStreamReader(inputStream, "UTF-8")));
        HttpResponse response = HttpRequest.post(url).contentType(contentType).body(sb.toString()).execute();
        Map<String, Object> map  = new HashMap<>();
        if(response.getStatus()==200){
            map.put("response",response);
            map.put("document",document);
        }

        return  response.getStatus()==200?ResultUtil.success ( map ):ResultUtil.error(response.getStatus()+" 请求错误！");
    }

    /**
     *  抽取 blh web 接口的数据
     * @param blh
     * @param strNodeName
     * @return
     * @throws Exception
     */
    public static ResultUtil saveWebBLH (String blh,String strNodeName) throws  Exception{
        String url="http://172.180.100.18:10012/HospitalInfection.asmx";
        String contentType = "application/soap+xml;charset=utf-8";
        try {
            Document document=null;
            StringBuffer sb = new StringBuffer();
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            sb.append("<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">");
            sb.append("  <soap12:Body>");
            sb.append("<"+strNodeName+" xmlns=\"http://tempuri.org/\">");
            sb.append ( "   <blh>"+blh+"</blh>" );
            sb.append("</"+strNodeName+">");
            sb.append("  </soap12:Body>");
            sb.append("</soap12:Envelope>");
            InputStream inputStream = HttpRequest.post ( url ).contentType ( contentType ).body ( sb.toString () ).execute ().bodyStream ();
            SAXReader reader = new SAXReader();
            document=reader.read(new BufferedReader(new InputStreamReader(inputStream, "UTF-8")));
            List<Node> nodes = document.selectNodes("//"+strNodeName);
            Iterator<Node> iterator = nodes.iterator();
            List<Object>  list = new ArrayList<>();
            while (iterator.hasNext()){
                Class<?> aClass = WebSoapUtil.class.getClassLoader ().loadClass ( "com.sxdl.product.dc.entity.yg." + strNodeName );
                Object objclass = aClass.newInstance();
                Element element = (Element)iterator.next();
                Iterator<Element> elementIterator = element.elementIterator();
                while (elementIterator.hasNext()){
                    Element next = elementIterator.next();
                    //System.out.println("名称："+next.getName()+" 值："+next.getTextTrim());
                    String md =  next.getName().substring(0, 1).toUpperCase()+next.getName().substring(1);
                    Method method = aClass.getDeclaredMethod("set" + md, String.class);
                    method.setAccessible(true);
                    method.invoke(objclass,next.getTextTrim());
                }
                list.add(objclass);
            }

            Object bean1 = SpringContextUtils.getBean(strNodeName.substring(0, 1).toUpperCase() + strNodeName.substring(1) + "Controller");
            Method insert = bean1.getClass().getDeclaredMethod("insert", List.class);
            //Method insert = bean.getDeclaredMethod("insert", List.class);
            insert.invoke(bean1, list);
        }catch (Exception e){
            e.printStackTrace ();
            return ResultUtil.error ( e.getMessage () );
        }

        return  ResultUtil.success ( "数据保存成功" );
    }

    public static  HttpResponse getText(String url){
        HttpResponse execute = HttpRequest.post(url).execute();
        return execute;
    }

    /**
     *  返回 响应相关数据
     * @param response
     * @param dcRequestAPI
     * @return
     * @throws Exception
     */
    public static DcRequestAPI getResponseInfo(HttpResponse response, DcRequestAPI dcRequestAPI) throws  Exception{
        // Map<String, List<String>> headers1 = response.headers();
        String cookies = response.getCookies().toString();
        String headers = response.headers().toString();
        String body = response.body();
        dcRequestAPI.setRespheader(headers);
        dcRequestAPI.setCookie(cookies);
        dcRequestAPI.setRespbody(body);
        return  dcRequestAPI;

    }


    /**
     *
     * @param params 格式要求: startDate>value1;endDate>value2
     * @return
     */
    public static Map<String,String> getKeyValues(String params){
        Map<String,String> map = new LinkedHashMap<> ();
        String[] split = params.split(";");
        for (String str : split) {
            String[] ky = str.split(">");
            map.put(ky[0],ky[1]);
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
    public static Map<String,String > getSplicTimeParam(String startTime,String EndTime,String rule,Integer timeLong) throws ParseException {

        //重设 map集合的排序规则
        Map<String ,String > map = new TreeMap<String ,String >(
                new Comparator<String>(){
                    @SneakyThrows
                    @Override
                    public int compare(String o1, String o2) {
                        int result = 0;
                        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        if (format.parse(o1).getTime()>format.parse(o2).getTime()){
                            result=-1;
                        }else if(format.parse(o1).getTime()<format.parse(o2).getTime()){
                            result=1;
                        }else{
                            result=0;
                        }
                        return result;
                    }
                }


        );
        // 将要存入map中的开始结束时间
        String start="";
        String end="";
        boolean b=true;
        //SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd");
        Date startDate =null;
        Calendar instance = Calendar.getInstance();
        while(b){
            if("".equals(end)){
                startDate = myFmt.parse(EndTime);
            }else{
                startDate = myFmt.parse(start);
            }
            instance.setTime(startDate);
            if("天".equals(rule)){
                instance.add(Calendar.DAY_OF_YEAR,-timeLong);
            }else if("时".equals(rule)){
                instance.add(Calendar.HOUR_OF_DAY,-timeLong);
            }else if("月".equals(rule)){
                instance.add(Calendar.MONTH,-timeLong);
            }else if("周".equals(rule)){
                instance.add(Calendar.WEEK_OF_YEAR,-timeLong);
            }else if("分".equals(rule)){
                instance.add(Calendar.MINUTE,-timeLong);
            }
            start = myFmt.format(instance.getTime());
            instance.setTime(startDate);
            end =myFmt.format(instance.getTime());
            map.put(start,end);
            if(myFmt.parse(startTime).getTime()>=myFmt.parse(start).getTime()){
                b=false;
            }
        }
        return  map;
    }


    /***
     * 自动调度  -->每天作业任务自动调度 保存数据
     * @param jsonArray
     */
    public static void autoDispatch(JSONArray jsonArray){
        List<DcScheduleRule> dcScheduleRules = (List<DcScheduleRule>) ApplicationRunnerImpl.contextMap.get("dcScheduleRules");
        for (Object obj : jsonArray) {
            String rule_id = (String) ((JSONObject) obj).get("rule_id");
            DcScheduleRule dcScheduleRule = dcScheduleRules.stream().filter(e -> e.getId().equals(rule_id)).collect(Collectors.toList()).get(0);
            String rule = dcScheduleRule.getParam_unit();
            Integer timeLong = dcScheduleRule.getParam();
            SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            if("天".equals(rule)){
                instance.add(Calendar.DAY_OF_YEAR,-timeLong);
            }else if("时".equals(rule)){
                instance.add(Calendar.HOUR_OF_DAY,-timeLong);
            }else if("月".equals(rule)){
                instance.add(Calendar.MONTH,-timeLong);
            }else if("周".equals(rule)){
                instance.add(Calendar.WEEK_OF_YEAR,-timeLong);
            }else if("分".equals(rule)){
                instance.add(Calendar.MINUTE,-timeLong);
            }
            String startTime = myFmt.format(instance.getTime());
            String endTime = myFmt.format(date);
        }
    }



    /**
     *
     * @param tableName  需创 建表的名称
     * @param columns     建表的列名   （类型默认都是varchar(500) 除特殊字段）
     * @return   数据库中没有该表存在，创建该表
     */
    public static String getSqlTextNotExists(String tableName,Set<String> columns){
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE [dbo].").append(tableName).append("(").append(LineBreak);
        sb.append(Tab).append("[dcid] [int] IDENTITY(1,1) NOT NULL,").append(LineBreak);
        for (String column : columns) {
            //对存放大数据的字段做特殊处理
            if("cWriteName".equals(column)){
                sb.append(Tab).append("["+column+"] [TEXT]  NULL,").append(LineBreak);
            }else {
                sb.append(Tab).append("["+column+"] [VARCHAR](500)  NULL,").append(LineBreak);
            }
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

    public static String getSqlTextIsExists( String tableName, List<String> columnAdd){
        StringBuilder sb = new StringBuilder();
        for (String column : columnAdd) {
            sb.append("alter table "+tableName+" add "+column+" varchar(500) null").append(LineBreak);
        }
        return sb.toString();

    }

    /**
     *
     * @param beforeSql   之前拼接的sql脚本
     * @param tableName   建表名称
     * @param  columns   建表列名
     * @return   拼接最终sql建表语句脚本
     */
    public static String getSqlTextLast(String beforeSql,String tableName,Set<String> columns){
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE [dbo].").append(tableName).append("(").append(LineBreak);
        sb.append(Tab).append("[dcid] [int] IDENTITY(1,1) NOT NULL,").append(LineBreak);
        for (String column : columns) {
            //对存放大数据的字段做特殊处理
            if("cWriteName".equals(column)){
                sb.append(Tab).append("["+column+"] [TEXT]  NULL,").append(LineBreak);
            }else {
                sb.append(Tab).append("["+column+"] [VARCHAR](500)  NULL,").append(LineBreak);
            }
        }
        sb.append(Tab).append("CONSTRAINT [PK_").append(tableName).append("] PRIMARY KEY CLUSTERED ( [dcid] ASC )").append(LineBreak);
        sb.append(" WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]) ON [PRIMARY]").append(LineBreak).append(LineBreak);
        return sb.toString();
    }


    public static String isExistsDate(String tableName,String sTiem,String eTime,List<String> columns){
        return "";
    }




    public static void main(String[] args)  {


        List<DcColumn> dcTables = new ArrayList<>();
        DcColumn t1 = new DcColumn();


        t1.setColumn_name("11");

        t1.setTable_id("1");
        DcColumn t2 = new DcColumn();
        t2.setColumn_name("11");
        DcColumn t3  = new DcColumn();
        t3.setColumn_name("33");
        dcTables.add(t1);
        //dcTables.add(t2);
        dcTables.add(t3);

        List<String> list = new ArrayList<>();
        List<String> newt = new ArrayList<>();
        list.add("11");
        list.add("111");
        list.add("111");
        list.add("33");
        Object o = "11";
        System.out.println(dcTables.contains(o));


    }





}
