package com.sxdl.report.entity;


import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "productjson")
public class ConfigBean {
    JSONObject jsonObject, jall,jsonObjectlistmaps;
    JSONArray jsonArrayTemplate, jsonArrayProductname, jsonArraylistmapsInner;
    private Map<String, String> template;
    private Map<Integer, String> productname;
    private Map<String, Map<String, String>> listmaps;

    @Override
    public String toString() {
        jsonArrayTemplate = new JSONArray();
        jsonArrayProductname = new JSONArray();
        jsonObjectlistmaps = new JSONObject();
        jall = new JSONObject();//完整json
        jsonArrayTemplate = this.mapToJson(this.template, jsonArrayTemplate);//第一块
        jall.put("template", jsonArrayTemplate);
        jsonArrayProductname = this.mapToJson(this.productname, jsonArrayProductname);//第二块
        jall.put("productname", jsonArrayProductname);

        jsonObject = new JSONObject();
        for (Map.Entry<String, Map<String, String>> e : this.listmaps.entrySet()) {
            jsonArraylistmapsInner = new JSONArray();
            jsonArraylistmapsInner = this.mapToJson(e.getValue(), jsonArraylistmapsInner);
            jsonObjectlistmaps.put(e.getKey(), jsonArraylistmapsInner);
        }
        jall.put("listmaps", jsonObjectlistmaps);
        return jall.toString();
    }

    JSONArray mapToJson(Map map, JSONArray ja) {
        map.forEach((k,v)->{
            jsonObject = new JSONObject();
            jsonObject.put("key", k);
            jsonObject.put("val", v);
            ja.add(jsonObject);
        });
        return ja;
    }
}
