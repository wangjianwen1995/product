package com.sxdl.report.util;

import java.util.HashMap;
import java.util.Map;

public class InitYml {
    static Map<String, Map> map = new HashMap<>();
    StringBuffer sb;

    static {
        Map<Integer, String> productname = new HashMap<>();
        productname.put(1, "国家平台");
        productname.put(2, "省平台");
        productname.put(3, "市平台");
        map.put("productname", productname);

        Map<Integer, String> template = new HashMap<>();
        template.put(1, "DRG医保上报");
        template.put(2, "医保上报");
        template.put(3, "单病种上报");
        template.put(4, "职工医保web上报");
        template.put(5, "DIP注册");
        template.put(6, "DIP上报");
        template.put(7, "DIP冲销");
        map.put("template", template);

        Map<Integer, Map<Integer, String>> listmaps = new HashMap<>();
        Map<Integer, String> listmaps1 = new HashMap<>();
        listmaps1.put(3, template.get(3));
        listmaps.put(1, listmaps1);

        Map<Integer, String> listmaps2 = new HashMap<>();
        listmaps2.put(1, template.get(1));
        listmaps2.put(4, template.get(4));
        listmaps2.put(5, template.get(5));
        listmaps2.put(6, template.get(6));
        listmaps2.put(7, template.get(7));
        listmaps.put(2, listmaps2);

        Map<Integer, String> listmaps3 = new HashMap<>();
        listmaps3.put(2, template.get(2));
        listmaps.put(3, listmaps3);
        map.put("listmaps", listmaps);
    }

    public static void main(String[] args) {
        InitYml initYml = new InitYml();
        System.out.println(initYml.toString());
    }
    Map m;
    String diff;
    @Override
    public String toString() {
        sb = new StringBuffer("productjson:\n");
        for (String k : map.keySet()) {
            sb.append("  ").append(k).append(": {");
            m = map.get(k);
            if (m.size() > 0) {
                for (Object kinner : m.keySet()) {
                    sb.append(kinner).append(": ");
                    diff = m.get(kinner).toString();
                    if (k.equals("listmaps")) {
                        if (diff.contains("=")) {
                            diff = diff.replace("=", ": ");
                        }
                    }
                    sb.append(diff).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("}\n");
        }
        return sb.toString();
    }
}
