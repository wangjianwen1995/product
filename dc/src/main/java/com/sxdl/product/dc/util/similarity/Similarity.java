//package com.sxdl.product.dc.util.similarity;
//
//import java.util.*;
//
//public class Similarity {
//    public static final String content1 = "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，而且特别的小，关键价格还贵";
//
//    public static final String content2 = "今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的";
//
//
//    public static void main(String[] args) {
////        String s1 = "1005200520102595938669110李峰男24岁164健康管理中心7706李玉芳2020-05-22 09:51:57";
////        String s2 = "1023200313103165949727000李峰男32岁3普外一科4473杨冬2020-05-24 15:53:43";
////        String s3 = "1005200520102595971022100李峰男24岁164健康管理中心7706李玉芳2020-05-22 09:51:57";
////        double score = CosineSimilarity.getSimilarity(s1, s2);
////        System.out.println("相似度：" + score);
////
////        score = CosineSimilarity.getSimilarity(s2, s3);
////        System.out.println("相似度：" + score);
////
////        score = CosineSimilarity.getSimilarity(s1, s3);
////        System.out.println("相似度：" + score);
//        Map<String, String> map = new HashMap();
//        map.put("0", "123");
//        map.put("1", "qwe");
//        map.put("2", "asd");
//        map.put("3", "zxc");
//        List<Map> list = new ArrayList();
//        list.add(map);
//
//        list.parallelStream().map(m -> {
//            Optional s = m.values().stream().reduce((acc, item) -> {
//                return acc.toString() + item;
//            });
//            map.put("restul", s.get().toString());
//            return map;
//        }).forEach(System.out::println);
//
//
//    }
//
//    public void compares(List<Map> list) {
////        List<Map> list2 = new ArrayList<>(list);
////
////        List<Map> list3 = list.parallelStream()
////                .map(map -> {
////                    Optional s = map.values().stream().reduce((acc, item) -> {
////                        return acc.toString() + item;
////                    });
////                    map.put("restul", s.get().toString());
////                    list2.parallelStream().map(map2 -> {
////                        Optional s2 = map2.values().stream().reduce((acc, item) -> {
////                            return acc.toString() + item;
////                        });
////                        map.clear();
////                        map.put("result", s2.get().toString());
////                        return map;
////                    })
////                            .filter(m -> Objects.equals(m.get("id"), map.get("id")))
////                            .findFirst().map(m -> {
////                        map.putAll(m);
////                        return map;
////                    }).orElse(null);
////                })
////                .filter(Objects::nonNull).collect(Collectors.toList());
//    }
//}
