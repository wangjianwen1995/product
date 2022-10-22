package com.sxdl.hp.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.SpiderArea;
import com.sxdl.hp.entity.SpiderArea2;
import com.sxdl.hp.entity.SpiderZip;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Spider {
    String url = "https://www.ip138.com/post", urlBase = "https://www.ip138.com", code, tel, name, childcode, shengName, shengUrl, paentcode, paentcode2, paentcode3, elevel, ename, eid, paentcode4, shengs, shis, xians, shengc, shic, xianc, fulls;
    URLConnection conn;
    JsonNode rootNode, nameNode, idnode, levelnode, childnode;
    Iterator<JsonNode> elements, elements2, elements3;
    SpiderArea sa1, sa2, sa3, sa4, sa;

    public List<SpiderArea2> area2() throws Exception {
        List<SpiderArea2> list = new ArrayList<>();
        JSONArray root = JSONUtil.readJSONArray(new File("area.json"), CharsetUtil.defaultCharset());
        for (Object o : root) {
            JSONObject jo = (JSONObject) o;
            String code = jo.getStr("code");
            String name = jo.getStr("name");
            list.add(new SpiderArea2(name, 2, code, code, "0"));
            if (jo.containsKey("children")) {
                JSONArray children = jo.getJSONArray("children");
            }
        }
        return list;
    }

    //尝试使用新的方式解析json文件
    public List<SpiderArea> area() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<SpiderArea> list = new ArrayList<>();
        rootNode = mapper.readTree(new File("level4-mini.json"));
        sa1 = createData(list, rootNode, "0", "", "", "", "", "", "", "");//中国
        if (rootNode.has("children")) {
            childnode = rootNode.path("children");
            elements = childnode.elements();
            while (elements.hasNext()) {
                rootNode = elements.next();
                sa2 = createData(list, rootNode, sa1.getCode(), "", "", "", "", "", "", "");//山西省
                if (null == sa2) {
                    continue;
                }
                if (rootNode.has("children")) {
                    childnode = rootNode.path("children");
                    elements2 = childnode.elements();
                    while (elements2.hasNext()) {
                        rootNode = elements2.next();
                        sa3 = createData(list, rootNode, sa2.getCode(), sa2.getFullname(), sa2.getSheng(), "", "", sa2.getShengCode(), "", "");//太原市
                        if (null == sa3) {
                            continue;
                        }
                        if (rootNode.has("children")) {
                            childnode = rootNode.path("children");
                            elements3 = childnode.elements();
                            while (elements3.hasNext()) {
                                rootNode = elements3.next();
                                sa4 = createData(list, rootNode, sa3.getCode(), sa3.getFullname(), sa3.getSheng(), sa3.getShi(), "", sa3.getShengCode(), sa3.getShiCode(), "");//小店区
                                if (null == sa4) {
                                    continue;
                                }
                            }
                        }
                    }

                }
            }
        }
        list.forEach(System.out::println);
        System.out.println(list.size());
        return list;
    }

    public SpiderArea createData(List<SpiderArea> list, JsonNode rootNode, String parent, String fullname, String sheng, String shi, String xian, String shengCode, String shiCode, String xianCode) {
        eid = rootNode.path("id").asText();
        elevel = rootNode.path("level").asText();
        ename = rootNode.path("name").asText();
        fulls = fullname + ename;
        shengs = "";
        shis = "";
        xians = "";
        shengc = "";
        shic = "";
        xianc = "";
        if (elevel.equals("4")||elevel.equals("5")) {
            xians = ename;
            xianc = eid;
            shengs = sheng;
            shengc = shengCode;
            shis = shi;
            shic = shiCode;
        } else if (elevel.equals("3")) {
            if(sheng.equals("北京")||sheng.equals("天津")||sheng.equals("上海")||sheng.equals("重庆")){
                fulls=ename;
            }
            shengs = sheng;
            shengc = shengCode;
            shis = ename;
            shic = eid;

        } else if (elevel.equals("2")) {
            shengs = ename;
            shengc = eid;
        }else if(elevel.equals("1")){
            fulls="";
        }
        if (ename.equals("海外") || ename.contains("其他")|| ename.contains("其它")) {
            return null;
        }
        sa = new SpiderArea(ename, Integer.parseInt(elevel), eid, parent, fulls, shengs, shis, xians, shengc, shic, xianc);
        list.add(sa);
        return sa;
    }

    public List<SpiderZip> zipcode() throws IOException {
        Document document = Jsoup.parse(new URL(url), 20000);
        Element quanguo = document.getElementById("quanguo");
        Elements aTags = quanguo.getElementsByTag("a");
        List<SpiderZip> list = new ArrayList<>();
        for (Element e : aTags) {
            shengName = e.text();
            shengUrl = e.attr("href");
            try {
                conn = new URL(urlBase + shengUrl).openConnection();
                conn.addRequestProperty("Host", "www.ip138.com");
                conn.addRequestProperty("Referer", "https://www.ip138.com/post/");
                conn.addRequestProperty("Upgrade-Insecure-Requests", "1");
                conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3861.400 QQBrowser/10.7.4313.40");
                conn.setConnectTimeout(20000);
                Document detail = Jsoup.parse(conn.getInputStream(), "GBK", urlBase + shengUrl);
                Element table = detail.getElementsByTag("table").get(0);
                Elements trs = table.getElementsByAttributeValue("bgcolor", "#ffffff");
                for (int i = 0; i < trs.size(); i++) {
                    Elements tds = trs.get(i).getElementsByTag("td");
                    if (tds.size() == 4) {
                        name = tds.get(0).getElementsByTag("b").get(0).text();
                        childcode = tds.get(1).getElementsByTag("a").get(0).text();
                        tel = tds.get(2).getElementsByTag("a").get(0).text();
                        if (StringUtil.isEmpty(childcode)) {
                            childcode = code;
                        }
                        System.out.println(name + " " + childcode + " " + tel + " " + 2);
                        SpiderZip spiderZip = new SpiderZip(name, childcode, tel, 2);
                        list.add(spiderZip);
                        for (int j = i + 1; j < trs.size(); j++) {
                            Elements tdChilds = trs.get(j).getElementsByTag("td");
                            if (tdChilds.size() != 6) {
                                break;
                            } else {
                                name = tdChilds.get(0).text();
                                childcode = tdChilds.get(1).getElementsByTag("a").get(0).text();
                                tel = tdChilds.get(2).getElementsByTag("a").get(0).text();
                                if (StringUtil.isEmpty(childcode)) {
                                    childcode = code;
                                }
                                System.out.println(name + " " + childcode + " " + tel + " " + 3);
                                spiderZip = new SpiderZip(name, childcode, tel, 3);
                                list.add(spiderZip);
                                name = tdChilds.get(3).text();
                                if (StringUtil.isNotEmpty(name) && !name.equals(" ") && !name.equals("&nbsp;")) {
                                    childcode = tdChilds.get(4).getElementsByTag("a").get(0).text();
                                    tel = tdChilds.get(5).getElementsByTag("a").get(0).text();
                                    if (StringUtil.isEmpty(childcode)) {
                                        childcode = code;
                                    }
                                    System.out.println(name + " " + childcode + " " + tel + " " + 3);
                                    spiderZip = new SpiderZip(name, childcode, tel, 3);
                                    list.add(spiderZip);
                                }
                                i++;
                            }

                        }
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return list;
    }
}
