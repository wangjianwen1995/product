package com.sxdl.fm.controller;

import com.sxdl.fm.service.FmSecondHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class Index {
    @Autowired
    FmSecondHandlerService fmSecondHandlerService;

//    @PostMapping("/upload")
//    public String up(MultipartFile ex, String time) {
//        String result;
//        try {
//            ExcelReader reader = ExcelUtil.getReader(ex.getInputStream(), 0);
//            List<List<Object>> list = reader.read(2);
//            StringBuilder sql;
//            if (null == list || list.size() == 0) {
//                return "error";
//            }
//            for (List<Object> ll : list) {
//                sql = new StringBuilder("INSERT INTO [dbo].[小小] ([序号], [科室], [编号], [取得资源名称], [姓名], [门诊人次], [收住院人次], [主刀], [一助]," +
//                        "[时间],[手术人数合计]) VALUES (");
//                sql.append(ll.get(0) + ",'" + ll.get(1) + "'," + ll.get(2) + ",'" + ll.get(3) + "','" + ll.get(4) + "'," + ll.get(5) + "," + ll.get(6) +
//                        "," + ll.get(7) + "," + ll.get(8) + ",'" + time + "','" + (Integer.parseInt(ll.get(7).toString())+ Integer.parseInt(ll.get(8).toString())) + "');");
//                fmSecondHandlerService.insertBySql(sql.toString());
//                System.out.println(sql.toString());
//            }
//            result = "上传成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//            result = "上传失败";
//        }
//        return result;
//    }
//
//    @GetMapping("d")
//    public String getData() {
//        List<Map<String, Object>> list = fMHandlerService.findDay();
//        return list.toString();
//    }
//
//    @GetMapping("w")
//    public String getWeek() {
//        List<Map<String, Object>> list = fMHandlerService.findWeek();
//        return list.toString();
//    }
}
