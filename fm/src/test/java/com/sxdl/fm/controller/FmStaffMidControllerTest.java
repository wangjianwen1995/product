//package com.sxdl.fm.controller;
//
//import com.sxdl.fm.FmMainTest;
//import com.sxdl.fm.entity.FmStaffMid;
//import com.sxdl.fm.entity.HbiWlfks;
//import com.sxdl.fm.entity.HbiWlfys;
//import com.sxdl.fm.service.FmSecondHandlerService;
//import com.sxdl.fm.service.FmStaffMidService;
//import com.sxdl.fm.service.HbiWlfksService;
//import com.sxdl.fm.service.HbiWlfysService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.List;
//import java.util.Map;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//public class FmStaffMidControllerTest extends FmMainTest {
//
//    @Autowired
//    FmStaffMidService fmStaffMidService;
//    @Autowired
//    FmSecondHandlerService fmSecondHandlerService;
//    @Autowired
//    HbiWlfksService hbiWlfksService;
//    @Autowired
//    HbiWlfysService hbiWlfysService;
//    @Test
//    public void  testHbi() throws Exception{
//        List<HbiWlfks> all = hbiWlfksService.findAll();
//all.forEach(System.out::println);
//        List<HbiWlfys> all1 = hbiWlfysService.findAll();
//        all1.forEach(System.out::println);
//    }
//@Test
//public void testUpHbi() throws Exception {
//    mockMvc.perform(MockMvcRequestBuilders.get("/appUser/t")
//            .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
//            .andExpect(OK)//状态码200
//            .andDo(print());//结束后打印所有数据
//}
//
//    @Test
//    public void ttt() throws Exception {
//        List<FmStaffMid> all = fmStaffMidService.findAll();
//        System.out.println(all.size());
////        all.forEach(e -> {
////            e.setPwd(MD5Util.toMD5(e.getXm() + e.getGh()));
////            fmStaffMidService.update(e);
////        });
//        fmStaffMidService.insert(new FmStaffMid());
//        all = fmStaffMidService.findAll();
//        System.out.println(all.size());
//    }
//
//    @Test
//    public void t() throws Exception {
//        List<Map<String, Object>> maps = fmSecondHandlerService.selectWys();
//        maps.forEach(e -> {
//           e.forEach((k,v)->{
//               System.out.print(k+" "+v+" ");
//           });
//            System.out.println();
//        })  ;
//        maps = fmSecondHandlerService.selectWks();
//        maps.forEach(e -> {
//            e.forEach((k,v)->{
//                System.out.print(k+" "+v+" ");
//            });
//            System.out.println();
//        })  ;
//    }
//}
