package com.sxdl.product.dc.util;


import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.sxdl.product.dc.entity.DcRequestAPI;
import org.apache.commons.lang3.StringEscapeUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.xpath.DefaultXPath;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 此类 整合所有通过webservice接口soap协议的方式访问请求数据，
 */

public class WebSoapUtil {


    public static final String LineBreak = "\r\n";
    public static final String Tab = "\t";
    public static final String XMLHEAD = "<?xml version=\"1.0\" encoding=\"utf8\"?><datacenter>";
    public static final String XMLEND = "</datacenter>";


    public static void main(String[] args) throws Exception {



        /*String strs= "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><VsCH_CH0CResponse xmlns=\"http://tempuri.org/\"><VsCH_CH0CResult><?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<reponse><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>1</CH0C02><CH0C03>I10.x00</CH0C03><CH0C03_MC>高血压病3级（极高危组）</CH0C03_MC><CH0C03_Desc>高血压病3级（极高危组）</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>2</CH0C02><CH0C03>I25.103</CH0C03><CH0C03_MC>冠状动脉粥样硬化性心脏病</CH0C03_MC><CH0C03_Desc>冠状动脉粥样硬化性心脏病</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>3</CH0C02><CH0C03>N39.000</CH0C03><CH0C03_MC>泌尿道感染</CH0C03_MC><CH0C03_Desc>泌尿道感染</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>4</CH0C02><CH0C03>I49.900</CH0C03><CH0C03_MC>心律失常</CH0C03_MC><CH0C03_Desc>心律失常</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>5</CH0C02><CH0C03>I70.806</CH0C03><CH0C03_MC>颈动脉硬化</CH0C03_MC><CH0C03_Desc>颈动脉硬化</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>6</CH0C02><CH0C03>E04.101</CH0C03><CH0C03_MC>甲状腺结节</CH0C03_MC><CH0C03_Desc>甲状腺结节</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>7</CH0C02><CH0C03>K76.000</CH0C03><CH0C03_MC>脂肪肝</CH0C03_MC><CH0C03_Desc>脂肪肝</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>8</CH0C02><CH0C03>I20.000</CH0C03><CH0C03_MC>不稳定性心绞痛</CH0C03_MC><CH0C03_Desc>不稳定性心绞痛</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C><VsCH_CH0C><CH0M01>8620055</CH0M01><CH0MZYCS>5</CH0MZYCS><CH0C02>9</CH0C02><CH0C03>I49.300</CH0C03><CH0C03_MC>室性早搏</CH0C03_MC><CH0C03_Desc>室性早搏</CH0C03_Desc><Ch0CN1>1</Ch0CN1><CH0C05></CH0C05></VsCH_CH0C></reponse>\n" +
                "</VsCH_CH0CResult></VsCH_CH0CResponse></soap:Body></soap:Envelope>";

        strs="";
        Document read=null;
        SAXReader reader = new SAXReader();
        String body=StringEscapeUtils.unescapeXml(new String(strs.getBytes("utf-8"),"utf-8"));
        body = body.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        if(!body.contains("VsCH_CH0C")){
        }
        body = subXMl(body,"VsCH_CH0C");

        InputStream inputStreamboy=  new ByteArrayInputStream(body.getBytes("utf-8"));
        read = reader.read(inputStreamboy);
        getXmlColumns(read,"VsCH_CH0C",null,null);*/
        抽取历史数据();
    }

    /**
     * 处理抽取历史数据 非格式化
     *
     * @param str
     * @param tag 解析节点
     * @return
     * @throws Exception
     */
    public static List<LinkedHashMap<String, String>> 抽取历史数据() throws Exception {
        String str = "";
        SAXReader reader = new SAXReader();
        String body = StringEscapeUtils.unescapeXml(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        body = body.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        body = body.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        body = subXMl(body, "VsCh_PatientInfo");
        InputStream inputStreamboy = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));
        Document read = reader.read(inputStreamboy);
        List<LinkedHashMap<String, String>> etl_his_yzxx = getAnalysisNode(read, "VsCh_PatientInfo", null, null);
        System.out.println(etl_his_yzxx);
        return etl_his_yzxx;
    }


    public static void test2() throws Exception {
        String str = "";
        Document read = null;
        SAXReader reader = new SAXReader();
        String body = StringEscapeUtils.unescapeXml(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        body = body.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        body = subXMl(body, "VsCh_PatientInfo");
        InputStream inputStreamboy = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        read = reader.read(inputStreamboy);
        List<LinkedHashMap<String, String>> data = getAnalysisNode(read, "VsCh_PatientInfo", null, null);
        System.out.println(data);

    }

    /**
     * 处理不规范的xml
     *
     * @param strXml
     * @param tagNode
     * @return
     */
    public static String subXMl(String strXml, String tagNode) {

        StringBuilder sb = new StringBuilder();
        int Start = strXml.substring(0, strXml.indexOf("</" + tagNode + ">")).lastIndexOf("<" + tagNode);
        int End = strXml.lastIndexOf("</" + tagNode + ">") + ("</" + tagNode + ">").length();
        String str = strXml.substring(Start, End);
        sb.append(XMLHEAD).append(str).append(XMLEND);
        return sb.toString();

    }


    public static void test() {
        try {
            File file = new File("D:\\111.xml");
            SAXReader reader = new SAXReader();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int len = 0;
            Vector<InputStream> vector = new Vector<>();
            byte[] strBytes = new byte[30000];
            InputStream inputStream = null;
            while (len != -1) {
                len = bufferedInputStream.read(strBytes);
                if (len == -1) {
                    break;
                }
                String xmls = StringEscapeUtils.unescapeXml(new String(strBytes, 0, len, StandardCharsets.UTF_8));
                if (xmls.contains("<?xml")) {
                    xmls = sectionHead(xmls, "Data");
                }
                if (-1 == len || len < 30000) {
                    xmls = sectionTail(xmls, "Data");
                }
                inputStream = new ByteArrayInputStream(xmls.getBytes(StandardCharsets.UTF_8));
                vector.add(inputStream);
                inputStream.close();
            }
            BufferedInputStream sis = new BufferedInputStream(new SequenceInputStream(vector.elements()));
            Document read = reader.read(sis);
            Set<String> data = getXmlColumns(read, "Data", null, null);
            List<LinkedHashMap<String, String>> data1 = getAnalysisNode(read, "Data", null, null);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /**
     * 获取需要时间入参的web接口请求体
     *
     * @param webBody        前端通过web接口说明文件，copy来的请求body
     * @param startNodeName  开始时间的节点名称
     * @param startNodeValue 开始时间的值（根据长度来判断是否有时分秒）
     * @param endNodeName    结束时间的节点名称
     * @param endNodeValue   结束时间的值（根据长度来判断是否有时分秒）
     * @return
     */
    public static String getRequestBodyOfTime(String webBody, String startNodeName, String startNodeValue, String endNodeName, String endNodeValue) {

      /*
        固定 时间长度可用
      String str = webBody;
        int i = str.indexOf(startNodeName)+startNodeName.length()+1;
        String oldStime = str.substring(i, i+startNodeValue.length());
        str = str.replace(oldStime, startNodeValue);
        int j = str.indexOf(endNodeName)+endNodeName.length()+1;
        String oldEtime = str.substring(j,j+endNodeValue.length());
        str = str.replace(oldEtime,endNodeValue);
        return str;
      */

        String str = webBody;
        String replaceStime = str.substring(str.indexOf(startNodeName) + startNodeName.length() + 1);
        replaceStime = replaceStime.substring(0, replaceStime.indexOf("<"));
        String replaceEtime = str.substring(str.indexOf(endNodeName) + endNodeName.length() + 1);
        replaceEtime = replaceEtime.substring(0, replaceEtime.indexOf("<"));
        str = str.replace(replaceStime, startNodeValue).replace(replaceEtime, endNodeValue);
        return str;


    }

    /**
     * 获取需要病历号/其它单个入参的web接口请求体
     *
     * @param webBody         前端通过web接口说明文件，copy来的请求body
     * @param singleNodeName  病历号/其它节点的名称
     * @param singleNodeValue 病历号/其它值
     * @return
     */
    public static String getRequestBodyOfSingle(String webBody, String singleNodeName, String singleNodeValue) {
        String str = webBody;
        String replaceStr = str.substring(str.indexOf(singleNodeName) + singleNodeName.length() + 1);
        replaceStr = replaceStr.substring(0, replaceStr.indexOf("<"));
        str = str.replace(replaceStr, singleNodeValue);
        return str;
    }


    /**
     * 发送请求 获取相应HttpResponse对象
     *
     * @param url         路径
     * @param contentType 类型
     * @param webSoapStr  soap协议的字符串
     */
    public static HttpResponse getResponse(String url, String contentType, String webSoapStr, String soapaction) throws Exception {
        HttpResponse response;
        if (StrUtil.isEmpty(soapaction)) {
            response = HttpRequest.post(url).contentType(contentType).body(webSoapStr).timeout(300000).execute();
        } else {
            response = HttpRequest.post(url).contentType(contentType).body(webSoapStr).timeout(300000).header("SOAPAction", soapaction).execute();
        }
        return response;
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
        String body = StringEscapeUtils.unescapeXml(response.body());
        body = new String(body.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        dcRequestAPI.setRespheader(headers);
        dcRequestAPI.setCookie(cookies);
        dcRequestAPI.setRespbody(body);
        return dcRequestAPI;

    }


    /***
     *
     *
     * 不需要转义的xml流
     * 2、这里报错代表测试解析时候xml不规范
     * @param httpResponse
     * @return 请求web接口。返回document 对象
     * @throws Exception
     */
    public static Document getXmlDocument(HttpResponse httpResponse) throws Exception {
        SAXReader reader = new SAXReader();
        InputStream inputStream = httpResponse.bodyStream();
        Document read = reader.read(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)));
        return read;
    }


    /**
     * 将不需要的节点删除 ，整理成规范的xml数据流
     *
     * @param httpResponse
     * @param analysisNode 解析的节点，同时这里代表需要截断字符串的标识
     * @return 请求web接口。返回document 对象
     * @throws Exception
     */
    public static Document getXmlDocument(HttpResponse httpResponse, String analysisNode) throws Exception {
        Document read = null;
        SAXReader reader = new SAXReader();
        String body = StringEscapeUtils.unescapeXml(new String(httpResponse.body().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        body = body.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        body = body.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        if (!body.contains(analysisNode)) {
            return read;
        }
        if (!body.contains("<" + analysisNode + ">")) {
            return read;
        }
        body = subXMl(body, analysisNode);
        InputStream inputStreamboy = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));
        read = reader.read(inputStreamboy);
        return read;
        //可能存在 字符串超长
        /* BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamboy);
        int len=0;
        Vector<InputStream> vector = new Vector<>();
       // Vector<InputStream> vector2 = new Vector<>();
        //Vector<InputStream> newvector = new Vector<>();
        byte[] strBytes = new byte[30000];
        InputStream inputStream=null;
        while (len!=-1){
            len=bufferedInputStream.read(strBytes);
            if(len==-1){
                break;
            }
            String xmls =  StringEscapeUtils.unescapeXml(new String(strBytes, 0, len, "UTF-8"));
            if(xmls.contains("<?xml")){
                xmls=sectionHead(xmls,analysisNode);
            }
            if(-1==len ||len<30000){
                xmls=sectionTail(xmls,analysisNode);
            }
            inputStream = new ByteArrayInputStream(xmls.getBytes("utf-8"));
            vector.add(inputStream);
            inputStream.close();
        }
        BufferedInputStream sis = new BufferedInputStream(new SequenceInputStream(vector.elements()));
       InputStreamReader inputStreamReader = new InputStreamReader(sis,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = "";
        while ((temp=bufferedReader.readLine())!=null) {

            String xmls = StringEscapeUtils.unescapeXml(new String(temp));
            xmls = xmls.replaceAll("&lt;", "<");
            xmls = xmls.replaceAll("&gt;", ">");
            inputStream = new ByteArrayInputStream(xmls.getBytes("utf-8"));
            vector2.add(inputStream);
            inputStream.close();
        }

        BufferedInputStream sis2 = new BufferedInputStream(new SequenceInputStream(vector2.elements()));

        byte[] bytes = new byte[55000];
        int n = -1;
        while ((n = sis2.read(bytes,0,bytes.length)) != -1) {
            String xmls =  StringEscapeUtils.unescapeXml(new String(bytes,0,n,"utf-8"));
            xmls = xmls.replaceAll("&lt;", "<");
            xmls = xmls.replaceAll("&gt;", ">");
            inputStream = new ByteArrayInputStream(xmls.getBytes("utf-8"));
            newvector.add(inputStream);
            inputStream.close();
        }
        BufferedInputStream newbis = new BufferedInputStream(new SequenceInputStream(newvector.elements()));
        Document read = reader.read(sis);
        inputStreamboy.close();
        bufferedInputStream.close();
        sis.close();
        return read;*/
    }


    /**
     * 1、解析xml中的 特殊节点，返回建表字段
     * 2、用来测试通过了set有数据表示xml规范
     *
     * @param document
     * @param analysisNode
     * @return
     */

    public static Set<String> getXmlColumns(Document document, String analysisNode, String name_space, String name_space_url) throws Exception {
        Set<String> set = new HashSet<>();  //避免字段重复
        List<Node> nodes;
        if (null == name_space || "".equals(name_space)) {
            nodes = document.selectNodes("//" + analysisNode);
        } else {  //处理有命名空间的xml
            DefaultXPath xpath = new DefaultXPath("//" + analysisNode);
            xpath.setNamespaceURIs(Collections.singletonMap(name_space, name_space_url));
            nodes = xpath.selectNodes(document);
        }

        if (nodes.size() == 0) {
            return set;
        }
        Element node;
        if (nodes.size() == 2) {///见到有这种情况 第一条数据有10个字段，第二条变成了20个字段，
            node = (Element) nodes.get(1);
        } else {
            node = (Element) nodes.get(0);
        }
        Iterator<Element> elenode = node.elementIterator();
        if (!elenode.hasNext()) {
            set.add(node.getName());
            return set;
        }
        while (elenode.hasNext()) {
            Element next = elenode.next();
            set.add(next.getName());

        }

        return set;
    }

    /***
     *
     * @param document
     * @param analysisNode    //解析的节点
     * @return 解析xml数据
     * @throws Exception
     */
    public static List<LinkedHashMap<String, String>> getAnalysisNode(Document document, String analysisNode, String name_space, String name_space_url) throws Exception {
        List<LinkedHashMap<String, String>> mapList = new ArrayList<>();
        List<Node> nodes;
        if (null == name_space || "".equals(name_space)) {
            nodes = document.selectNodes("//" + analysisNode);

        } else {
            DefaultXPath xpath = new DefaultXPath("//" + analysisNode);
            xpath.setNamespaceURIs(Collections.singletonMap(name_space, name_space_url));
            nodes = xpath.selectNodes(document);
        }
        /*
        存在名称空间的问题
        DefaultXPath xpath = new DefaultXPath("//" + analysisNode);
        xpath.setNamespaceURIs(Collections.singletonMap("ns2", "http://util.dc.product.sxdl.com/"));

        List<Node> nodes = xpath.selectNodes(document);
        //没有 命名空间
        List<Node> nodes = document.selectNodes("//" + analysisNode);*/
        Iterator<Node> iterator = nodes.iterator();
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            Iterator<Element> elementIterator = element.elementIterator();
            LinkedHashMap<String, String> columnMap = new LinkedHashMap<>();


            while (elementIterator.hasNext()) {
                Element next = elementIterator.next();
                columnMap.put(next.getName(), next.getTextTrim().replaceAll("'", "‘"));
            }
            mapList.add(columnMap);
        }
        return mapList;
    }


    /**
     * @param tableName 需创 建表的名称
     * @param columns   建表的列名   （类型默认都是varchar(5000) 除特殊字段）
     * @return 数据库中没有该表存在，创建该表
     */
    public static String getSqlTextNotExists(String tableName, Set<String> columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE [dbo].").append(tableName).append("(").append(LineBreak);
        for (String column : columns) {
            sb.append(Tab).append("[" + column + "] [VARCHAR](5000)  NULL,").append(LineBreak);
        }
        sb.append(")");
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
            sb.append("  IF COL_LENGTH('" + tableName + "', '" + column + "') IS NULL  alter table " + tableName + " add " + column + " varchar(5000) null").append(LineBreak);
        }
        return sb.toString();

    }


    /**
     * 获取 一个web接口中的数据 集合(isparam=3 没有参数类型的web接口)
     *
     * @param agreeType     1 xml  2json 类型
     * @param isStandard    是否规范的xml -1不 1规范的
     * @param webReqestBody 请求体
     * @param analysisNode  解析节点
     * @param url           路径
     * @param contentType   contentType
     * @return
     * @throws Exception
     */

    public static List<LinkedHashMap<String, String>> getTableDate(String agreeType, Integer isStandard, String webReqestBody,
                                                                   String analysisNode, String url, String contentType,
                                                                   String namespace, String nameSpaceUrl, String soapaction) throws Exception {

        List<LinkedHashMap<String, String>> mapList = null;
        HttpResponse response = getResponse(url, contentType, webReqestBody, soapaction);
        Document xmlDocument = null;
        if (-1 == isStandard) { // 不规范的xml
            xmlDocument = getXmlDocument(response, analysisNode);
        } else {
            xmlDocument = getXmlDocument(response);
        }
        mapList = getAnalysisNode(xmlDocument, analysisNode, namespace, nameSpaceUrl);
        return mapList;
    }


    /**
     * 获取 一个web接口中的数据 集合(isparam=1 时间参数类型的web接口)
     *
     * @param agreeType      1 xml  2json 类型
     * @param isStandard     是否规范的xml 0不 1规范的
     * @param webReqestBody  请求体
     * @param analysisNode   解析节点
     * @param url            路径
     * @param contentType    contentType
     * @param startNodeName  开始时间的节点名
     * @param startNodeValue 开始时间
     * @param endNodeName    结束时间的节点名
     * @param endNodeValue   结束时间
     * @return
     * @throws Exception
     */
    public static List<LinkedHashMap<String, String>> getTableTimeDate(String agreeType, Integer isStandard, String webReqestBody,
                                                                       String analysisNode, String url, String contentType,
                                                                       String startNodeName, String startNodeValue, String endNodeName, String endNodeValue, String name_space, String name_space_url
            , String soapaction) throws Exception {
        List<LinkedHashMap<String, String>> mapList = null;
        String requestBodyOfTime = getRequestBodyOfTime(webReqestBody, startNodeName, startNodeValue, endNodeName, endNodeValue);
        HttpResponse response = getResponse(url, contentType, requestBodyOfTime, soapaction);
        Document xmlDocument = null;
        if (-1 == isStandard) { // 不规范的xml
            xmlDocument = getXmlDocument(response, analysisNode);
        } else {
            xmlDocument = getXmlDocument(response);
        }
        mapList = getAnalysisNode(xmlDocument, analysisNode, name_space, name_space_url);
        return mapList;

    }


    /**
     * 获取 一个web接口中的数据 集合(isparam=1 时间参数类型的web接口)
     *
     * @param isStandard     是否规范的xml 0不 1规范的
     * @param webReqestBody  请求体
     * @param analysisNode   解析节点
     * @param url            路径
     * @param contentType    contentType
     * @param startNodeName  开始时间的节点名
     * @param startNodeValue 开始时间
     * @param endNodeName    结束时间的节点名
     * @param endNodeValue   结束时间
     * @throws Exception
     */
    public static Document getTableTimeDocument(Integer isStandard, String webReqestBody,
                                                String analysisNode, String url, String contentType,
                                                String startNodeName, String startNodeValue, String endNodeName,
                                                String endNodeValue, String soapaction) throws Exception {
        List<LinkedHashMap<String, String>> mapList = null;
        String requestBodyOfTime = getRequestBodyOfTime(webReqestBody, startNodeName, startNodeValue, endNodeName, endNodeValue);
        HttpResponse response = getResponse(url, contentType, requestBodyOfTime, soapaction);
        Document xmlDocument = null;
        if (-1 == isStandard) { // 不规范的xml
            xmlDocument = getXmlDocument(response, analysisNode);
        } else {
            xmlDocument = getXmlDocument(response);
        }
        return xmlDocument;

    }


    /**
     * 获取 一个web接口中的数据 集合(isparam = 2 单个参数类型 的web接口)
     *
     * @param agreeType       1 xml  2json 类型
     * @param isStandard      是否规范的xml 0不 1规范的
     * @param webReqestBody   请求体
     * @param analysisNode    解析节点
     * @param url             路径
     * @param contentType     contentType
     * @param singleNodeName  病例号节点名称
     * @param singleNodeValue 病例号
     * @return
     * @throws Exception
     */
    public static List<LinkedHashMap<String, String>> getTableBlhDate(String agreeType, Integer isStandard, String webReqestBody,
                                                                      String analysisNode, String url, String contentType,
                                                                      String singleNodeName, String singleNodeValue, String name_space,
                                                                      String name_space_url, String soapaction) throws Exception {
        List<LinkedHashMap<String, String>> mapList = null;
        String requestBodyOfSingle = getRequestBodyOfSingle(webReqestBody, singleNodeName, singleNodeValue);
        HttpResponse response = getResponse(url, contentType, requestBodyOfSingle, soapaction);
        Document xmlDocument = null;
        if (-1 == isStandard) { // 不规范的xml
            xmlDocument = getXmlDocument(response, analysisNode);
        } else {
            xmlDocument = getXmlDocument(response);
        }
        mapList = getAnalysisNode(xmlDocument, analysisNode, name_space, name_space_url);
        return mapList;
    }

    /**
     * 获取 一个web接口中的数据 集合(isparam = 2 单个参数类型 的web接口)
     *
     * @param isStandard      是否规范的xml 0不 1规范的
     * @param webReqestBody   请求体
     * @param analysisNode    解析节点
     * @param url             路径
     * @param contentType     contentType
     * @param singleNodeName  病例号节点名称
     * @param singleNodeValue 病例号
     * @throws Exception
     */
    public static Document getTableBlhDocument(Integer isStandard, String webReqestBody,
                                               String analysisNode, String url, String contentType,
                                               String singleNodeName, String singleNodeValue, String soapaction) throws Exception {
        List<LinkedHashMap<String, String>> mapList = null;
        String requestBodyOfSingle = getRequestBodyOfSingle(webReqestBody, singleNodeName, singleNodeValue);
        HttpResponse response = getResponse(url, contentType, requestBodyOfSingle, soapaction);
        Document xmlDocument = null;
        if (-1 == isStandard) { // 不规范的xml
            xmlDocument = getXmlDocument(response, analysisNode);
        } else {
            xmlDocument = getXmlDocument(response);
        }

        return xmlDocument;
    }


    /**
     * 往表中插入数据并且先删除一段时间范围内的数据
     *
     * @param tag 表名称
     * @param map 一条数据与字段
     * @return 根据集合 生成 select where 与 insert into table 的sql 可执行脚本
     */
    public static String getInsertTableSqlDel(String tag, LinkedHashMap<String, String> map) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        map.forEach((k, v) -> {
            // sql 拼接列名那块
            sb2.append(k).append(",");
            //sql拼接 values那块
            sb3.append("'" + v + "'").append(",");
        });
        sb1.append(Tab).append(" INSERT INTO " + tag + "(").append(LineBreak);
        sb2.deleteCharAt(sb2.length() - 1).append(" ) VALUES (");
        sb3.deleteCharAt(sb3.length() - 1).append(")");
        sb1.append(sb2).append(sb3).append(LineBreak);
        String sqlText = sb1.toString();
        return sqlText;
    }


    public static String delTableData(String tag, String timeColumn, String stime, String etime, String tag_null, int isEndCondition) {
        StringBuilder sb = new StringBuilder();
        //sb.append(" delete from "+tag+" where "+timeColumn+" between '"+stime+"' and '"+etime+"' ");
        if (isEndCondition == 1) {
            if (tag_null == null || "".equals(tag_null)) {
                sb.append(" delete from " + tag + " where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "' ");

            } else {
                sb.append(" delete from " + tag + " where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "'" +
                        " or isnull(" + tag_null + ",'')='' or isnull(" + tag_null + ",'null')='null' ");
            }
        } else {
            if (tag_null == null || "".equals(tag_null)) {
                sb.append(" delete from " + tag + " where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) < '" + etime + "' ");

            } else {
                sb.append(" delete from " + tag + " where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) < '" + etime + "'" +
                        " or isnull(" + tag_null + ",'')='' or isnull(" + tag_null + ",'null')='null' ");
            }

        }


        return sb.toString();
    }

    public static String delTableJcjy(String tag, String timeColumn, String stime, String etime, String tag_null, int isEndCondition) {
        StringBuilder sb = new StringBuilder();
        if (tag_null == null || "".equals(tag_null)) {
            sb.append(" delete from " + tag + " where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "' ");

        } else {
            sb.append(" delete from " + tag + " where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "'" +
                    " or isnull(" + tag_null + ",'')='' or isnull(" + tag_null + ",'null')='null' ");
        }
        sb.append(" delete from resultdetail  where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "' ");
        sb.append(" if Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'wswresultdetail') and xtype='U') delete from wswresultdetail   where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "' ");
        sb.append(" if Exists(select top 1 * from sysObjects where Id=OBJECT_ID(N'antiresultdetail') and xtype='U')  delete from antiresultdetail   where convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) >= '" + stime + "' and convert(varchar(10),cast(convert(varchar(19)," + timeColumn + ",120) as datetime),120) <= '" + etime + "' ");

        return sb.toString();
    }


    public static String delTableData(String tag, String idColumn, String idValue) {
        String str = " delete from " + tag + " where " + idColumn + " ='" + idValue + "' ";
        return str;
    }

    public static String delTableData(String tag) {
        String str = " truncate table " + tag;
        return str;
    }


    /**
     * 生成作业的开始时间
     *
     * @param TimeLength 时间长度来判断生成什么类型的时间
     * @param timeLong   时间范围 （需要抽取多少天前的数据）
     * @return
     */
    public static String getAutoStartTiem(int TimeLength, Integer timeLong) {
        SimpleDateFormat myFmt = null;
        if (TimeLength == 10) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd");
        } else if (TimeLength == 19) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (TimeLength == 23) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DAY_OF_YEAR, -timeLong);
        String startTime = myFmt.format(instance.getTime());
        return startTime;
    }


    /**
     * @param TimeLength 时间长度来判断生成什么类型的时间
     * @return 生成作业的结束时间（当前调用时间）
     */

    public static String getAutoEndDateTime(int TimeLength) {
        SimpleDateFormat myFmt = null;
        if (TimeLength == 10) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd");
        } else if (TimeLength == 19) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (TimeLength == 23) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        String endTime = myFmt.format(date);
        return endTime;
    }


    /***
     * 将给定的时间范围，根据频率 来拆分成若干份
     * ex: 2020-01-01 2020-01-03   频率：1（天）  拆分成三天
     *
     * @param startTime  开始时间
     * @param EndTime    结束时间
     * @param rule       频率单位：月/天/周/时/分
     * @param timeLong   频率
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
        SimpleDateFormat myFmt = null;
        if (startTime.length() == 10 && EndTime.length() == 10) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd");
        } else if (startTime.length() == 19 && EndTime.length() == 19) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        } else if (startTime.length() == 23 && EndTime.length() == 23) {
            myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }

        Date startDate = null;
        Calendar instance = Calendar.getInstance();
        while (b) {
            /*if ("".equals(end)) {
                startDate = myFmt.parse(EndTime);
            } else {
                startDate = myFmt.parse(start);
            }*/
            if ("".equals(start)) {
                startDate = myFmt.parse(startTime);
            }
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
            instance.setTime(startDate);
            start = myFmt.format(instance.getTime());
            if ("".equals(end)) {
                startDate = myFmt.parse(EndTime);
            }
            instance.setTime(startDate);
            end = myFmt.format(instance.getTime());
            ////startDate>value1;endDate>value2
            list.add("startDate>" + start + ";endDate>" + end);
            if (myFmt.parse(startTime).getTime() >= myFmt.parse(start).getTime()) {
                b = false;
            }
        }
        if (list.size() > 1) {
            Collections.reverse(list);
        }
        return list;
    }


    /**
     * @param params 格式要求: startDate大于value1;endDate大于value2
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


    /**
     * 处理头部信息
     *
     * @param webStr
     * @param sectionStr
     * @return
     */
    public static String sectionHead(String webStr, String sectionStr) {
        StringBuilder sb = new StringBuilder();
        String str = webStr;
        int i = str.indexOf(sectionStr) - 1;
        str = str.substring(i);
        StringBuilder append = sb.append(XMLHEAD).append(str);
        return append.toString();
    }

    /**
     * 处理尾部信息
     *
     * @param webStr
     * @param sectionStr
     * @return
     */
    public static String sectionTail(String webStr, String sectionStr) {
        String str = webStr;
        int j = str.lastIndexOf(sectionStr) + sectionStr.length() + 1;
        str = str.substring(0, j);
        str += "</datacenter>";
        return str;

    }


}
