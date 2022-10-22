package com.sxdl.hpqc.controller;

import cn.hutool.json.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class HpQcControllerTest extends HpqcMainTest {

    @Test
    void quality() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/insertQuality")
                .param("sdate", "2021-05-01")
                .param("edate", "2021-05-31")
                //.param("flag", "d0881ac3-eede-4be9-ba40-18d5ab665f4b")
                .param("flag", "")
                //.param("column", "id")
                .param("column", "")
                // .param("bah", "1324385101")
                .param("bah", "")
                .param("zxflag", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }
// exec [p_zmzk_run] '2022-07-01','2022-07-01','2','id=''f97aa8f6-b79f-42c6-8e31-740dcbf8e568''','dl_merge.dbo.homepage'
    @Test
    void quality2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/insertQuality")
                .param("sdate", "2022-07-01")
                .param("edate", "2022-07-01")
                .param("flag", "f97aa8f6-b79f-42c6-8e31-740dcbf8e568")
               // .param("flag", "")
                .param("column", "id")
                //.param("column", "")
                 .param("bah", "63019205")
                //.param("bah", "")
                .param("zxflag", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void findQmRz() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findQmRz")
                /*  .param("sdate", "2022-01-01")
                  .param("edate", "2022-12-31")*/
                .param("pageNum", "1")
                .param("pageSize", "10")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }

    @Test
    void findOneType() throws Exception {
        //enddate = DateUtil.endOfDay(DateUtil.parse(enddate)).toString();
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findOneType")
                .param("type", "1")
                .param("lever", "")
                .param("pageNum", "1")
                .param("pageSize", "10")
                .param("is_link", "1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void findQmResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findQmResult")
                .param("sdate", "2019-01-28")
                .param("edate", "2019-01-28")
                .param("bah", "1324444501")
                .param("cykb", "0074")
                .param("is_link", "2")
                .param("pageNum", "1")
                .param("pageSize", "10")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    void findHomapage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findHomepage")
                .param("id", "1324385101")
                .param("zxflag", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    void findCompare() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findCompare")
                .param("bah", "1324385101")
                .param("zxflag", "2")
                .param("is_link", "2")
                /* .param("edate", "2018-05-31")
                 .param("pageNum", "1")
                 .param("pageSize", "10")*/
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    void updatepro() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/verify/linking/updatePro")
                //012 --评分终末 011 评分环节  112 完整终末 111完整环节 211 综合1环节 221 综合2环节 212 综合1终末  222 综合2终末
                .param("type", "1")
                .param("leve", "1")
                .param("link", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }


    @Test
    void getJson() throws Exception {
        String s = "\"xsetz\":0,\"lxr_shi_dm\":\"150900\",\"xx\":\"3\",\"ryq_t\":0,\"lxr_shi\":\"乌兰察布市\",\"bah\":\"1323029403\",\"jg_shi\":\"大同市\",\"sxys\":\"\",\"zkrq\":\"2018-12-27T16:00:00.000+00:00\",\"jg_sheng_dm\":\"山西省\",\"jbbm2\":\"\",\"jbbm1\":\"\",\"SHZYTS\":0,\"hy\":\"2\",\"zllb\":\"\",\"cybf\":\"1\",\"yzzy_jgmc\":\"\",\"ylfwf\":146.0,\"yysjdm\":\"140000\",\"id\":\"00022047-5701-43ab-ba55-b9bfcf3f3661\",\"wbyy\":\"镇癫痫药、镇静催眠药、抗帕金森病药和对精神有影响的药物的中毒及暴露于该类药物，不可归类在他处，意图不确定的\",\"yyclf\":225.0,\"csd_shi\":\"大同市\",\"SQZYTS\":0,\"lxr_xian_dm\":\"150902\",\"jg_all\":\"山西省大同市\",\"hkdz_shi_dm\":\"140200\",\"ZXFLAG\":\"2\",\"xzz_sheng_dm\":\"140000\",\"lyfs\":\"1\",\"yydsdm\":\"140100\",\"dh1\":\"13934741353\",\"csd_shi_dm\":\"140200\",\"cysj_S\":\"0\",\"zkys\":\"卜德永\",\"rh\":\"2\",\"ryq_xs\":0,\"xserytz\":0,\"hkdz_sheng\":\"山西省\",\"CFTS\":17,\"zy\":\"27\",\"yb2\":\"37000\",\"yyqxdm\":\"140109\",\"yb1\":\"37000\",\"ZYZD_CYQK\":\"1\",\"yb3\":\"030000\",\"bzyzsNl\":0.0,\"ryq_fz\":0,\"sslclj\":\"\",\"xzz_shi\":\"大同市\",\"rysj_S\":\"0\",\"lxr_sheng_dm\":\"150000\",\"zfje\":0.0,\"blh\":\"\",\"csd_xian_dm\":\"140227\",\"cysj\":\"2018-12-27T16:00:00.000+00:00\",\"cykb\":\"0052\",\"zzys\":\"卜德永\",\"blzdf\":669.0,\"jg_sheng\":\"山西省\",\"SSGS\":0,\"zrys\":\"高付升\",\"jkkh\":\"\",\"csd_sheng\":\"山西省\",\"zkkb\":\"\",\"hkdz_shi\":\"大同市\",\"gzdwjdz\":\"无\",\"hkdz_addr_all\":\"山西省大同市null马连渠乡武家村\",\"dwdh\":\"1234567\",\"ylfkfs\":\"7\",\"zrhs\":\"赫俊霞\",\"zdf\":35.0,\"csrq\":\"1953-10-07T16:00:00.000+00:00\",\"xy_rybq\":\"1\",\"bzsh\":\"\",\"dh\":\"13934741353\",\"xyf\":2781.41,\"zyzd_jbbm\":\"Z85.300\",\"bmy\":\"吕桃\",\"zyzd\":\"乳房恶性肿瘤个人史\",\"STATUS\":\"1\",\"lxr_addr_all\":\"内蒙古自治区乌兰察布市集宁区集宁区马连渠乡武家村\",\"md\":\"\",\"ryh_xs\":0,\"sfzjlx\":\"1\",\"xzz_sheng\":\"山西省\",\"bazl\":\"1\",\"zyys\":\"王帅\",\"jgmc\":\"xxxxx\",\"xzz_shi_dm\":\"140200\",\"zyzljs\":\"\",\"mz\":\"01\",\"ryh_fz\":0,\"jg_shi_dm\":\"140200\",\"jbbm\":\"C50.900\",\"gmyw\":\"\",\"zlczf\":126.5,\"hkdz_sheng_dm\":\"140000\",\"ywgm\":\"1\",\"nl\":65,\"ZDGS\":1,\"zzjgdm2\":\"xxxxx\",\"csd_sheng_dm\":\"140000\",\"xzz_addr\":\"马连渠乡武家村\",\"lxr_sheng\":\"内蒙古自治区\",\"zkhs\":\"王晓芳\",\"A_id\":\"7C7F1102-E0AF-430F-AEDB-F5462A92219F\",\"zzyjh\":\"1\",\"rytj\":\"2\",\"ryh_t\":0,\"zfy\":4568.76,\"zcyf\":227.85,\"csd_xian\":\"大同县\",\"mzzd_xyzd\":\"乳房恶性肿瘤\",\"zyzlsb\":\"\",\"zycs\":3,\"jxys\":\"\",\"zzjgdm\":\"xxxxx\",\"kzr\":\"高付升\",\"nldw\":\"1\",\"gj\":\"156\",\"csd_addr_all\":\"山西省大同市nullnull\",\"sjzy\":4,\"hlf\":68.0,\"hkdz_addr\":\"马连渠乡武家村\",\"ZYH\":\"13230294\",\"xb\":\"2\",\"rysj\":\"2018-12-23T16:00:00.000+00:00\",\"rykb\":\"0052\",\"yxxzdf\":290.0,\"lxrxm\":\"李树英\",\"gx\":\"3\",\"lxr_xian\":\"集宁区\",\"lxr_addr\":\"集宁区马连渠乡武家村\",\"sfzh\":\"152601195310083021\",\"xm\":\"赵栓梅\",\"is_link\":0,\"xzz_addr_all\":\"山西省大同市null马连渠乡武家村\",\"zyzd_jbbm_allc\":\"Z85.300\",\"rybf\":\"1\",\"username\":\"dl\"";
        mockMvc.perform(MockMvcRequestBuilders.get("/verify/linking/getJson")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void Qm() throws Exception {
        String s = "{\"xsetz\":0,\"lxr_shi_dm\":\"150900\",\"xx\":\"3\",\"ryq_t\":0,\"lxr_shi\":\"乌兰察布市\",\"bah\":\"1323029403\",\"jg_shi\":\"大同市\",\"sxys\":\"\",\"zkrq\":\"2018-12-27T16:00:00.000+00:00\",\"jg_sheng_dm\":\"山西省\",\"jbbm2\":\"\",\"jbbm1\":\"\",\"SHZYTS\":0,\"hy\":\"2\",\"zllb\":\"\",\"cybf\":\"1\",\"yzzy_jgmc\":\"\",\"ylfwf\":146.0,\"yysjdm\":\"140000\",\"id\":\"00022047-5701-43ab-ba55-b9bfcf3f3661\",\"wbyy\":\"镇癫痫药、镇静催眠药、抗帕金森病药和对精神有影响的药物的中毒及暴露于该类药物，不可归类在他处，意图不确定的\",\"yyclf\":225.0,\"csd_shi\":\"大同市\",\"SQZYTS\":0,\"lxr_xian_dm\":\"150902\",\"jg_all\":\"山西省大同市\",\"hkdz_shi_dm\":\"140200\",\"ZXFLAG\":\"2\",\"xzz_sheng_dm\":\"140000\",\"lyfs\":\"1\",\"yydsdm\":\"140100\",\"dh1\":\"13934741353\",\"csd_shi_dm\":\"140200\",\"cysj_S\":\"0\",\"zkys\":\"卜德永\",\"rh\":\"2\",\"ryq_xs\":0,\"xserytz\":0,\"hkdz_sheng\":\"山西省\",\"CFTS\":17,\"zy\":\"27\",\"yb2\":\"37000\",\"yyqxdm\":\"140109\",\"yb1\":\"37000\",\"ZYZD_CYQK\":\"1\",\"yb3\":\"030000\",\"bzyzsNl\":0.0,\"ryq_fz\":0,\"sslclj\":\"\",\"xzz_shi\":\"大同市\",\"rysj_S\":\"0\",\"lxr_sheng_dm\":\"150000\",\"zfje\":0.0,\"blh\":\"\",\"csd_xian_dm\":\"140227\",\"cysj\":\"2018-12-27T16:00:00.000+00:00\",\"cykb\":\"0052\",\"zzys\":\"卜德永\",\"blzdf\":669.0,\"jg_sheng\":\"山西省\",\"SSGS\":0,\"zrys\":\"高付升\",\"jkkh\":\"\",\"csd_sheng\":\"山西省\",\"zkkb\":\"\",\"hkdz_shi\":\"大同市\",\"gzdwjdz\":\"无\",\"hkdz_addr_all\":\"山西省大同市null马连渠乡武家村\",\"dwdh\":\"1234567\",\"ylfkfs\":\"7\",\"zrhs\":\"赫俊霞\",\"zdf\":35.0,\"csrq\":\"1953-10-07T16:00:00.000+00:00\",\"xy_rybq\":\"1\",\"bzsh\":\"\",\"dh\":\"13934741353\",\"xyf\":2781.41,\"zyzd_jbbm\":\"Z85.300\",\"bmy\":\"吕桃\",\"zyzd\":\"乳房恶性肿瘤个人史\",\"STATUS\":\"1\",\"lxr_addr_all\":\"内蒙古自治区乌兰察布市集宁区集宁区马连渠乡武家村\",\"md\":\"\",\"ryh_xs\":0,\"sfzjlx\":\"1\",\"xzz_sheng\":\"山西省\",\"bazl\":\"1\",\"zyys\":\"王帅\",\"jgmc\":\"xxxxx\",\"xzz_shi_dm\":\"140200\",\"zyzljs\":\"\",\"mz\":\"01\",\"ryh_fz\":0,\"jg_shi_dm\":\"140200\",\"jbbm\":\"C50.900\",\"gmyw\":\"\",\"zlczf\":126.5,\"hkdz_sheng_dm\":\"140000\",\"ywgm\":\"1\",\"nl\":65,\"ZDGS\":1,\"zzjgdm2\":\"xxxxx\",\"csd_sheng_dm\":\"140000\",\"xzz_addr\":\"马连渠乡武家村\",\"lxr_sheng\":\"内蒙古自治区\",\"zkhs\":\"王晓芳\",\"A_id\":\"7C7F1102-E0AF-430F-AEDB-F5462A92219F\",\"zzyjh\":\"1\",\"rytj\":\"2\",\"ryh_t\":0,\"zfy\":4568.76,\"zcyf\":227.85,\"csd_xian\":\"大同县\",\"mzzd_xyzd\":\"乳房恶性肿瘤\",\"zyzlsb\":\"\",\"zycs\":3,\"jxys\":\"\",\"zzjgdm\":\"xxxxx\",\"kzr\":\"高付升\",\"nldw\":\"1\",\"gj\":\"156\",\"csd_addr_all\":\"山西省大同市nullnull\",\"sjzy\":4,\"hlf\":68.0,\"hkdz_addr\":\"马连渠乡武家村\",\"ZYH\":\"13230294\",\"xb\":\"2\",\"rysj\":\"2018-12-23T16:00:00.000+00:00\",\"rykb\":\"0052\",\"yxxzdf\":290.0,\"lxrxm\":\"李树英\",\"gx\":\"3\",\"lxr_xian\":\"集宁区\",\"lxr_addr\":\"集宁区马连渠乡武家村\",\"sfzh\":\"152601195310083021\",\"xm\":\"赵栓梅\",\"is_link\":0,\"xzz_addr_all\":\"山西省大同市null马连渠乡武家村\",\"zyzd_jbbm_allc\":\"Z85.300\",\"rybf\":\"1\",\"username\":\"dl\"}";
        JSONObject j = new JSONObject();
        mockMvc.perform(MockMvcRequestBuilders.post("/verify/linking/Qm")
                .param("homepageQcLinkEntity", s)
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void getQualityData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/quality/getQualityData")
                /*  .param("sdate", "2022-01-01")
                  .param("edate", "2022-12-31")*/
                .param("type", "1")
                .param("val", "")
                .param("pid", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据

    }


    @Test
    void findQmNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findQmNumber")
                .param("sdate", "2021-06-01")//出院时间
                .param("edate", "2021-07-01")//出院时间
                .param("platform_on", "01")//平台
                .param("cykb", "")//出院科别
                .param("order", "")//排序字段
                .param("ascDesc", "true")//升序降序  true 升序
                .param("is_link", "2")// 默认值 2
                .param("classfiy_id", "1,2,3")//类别  完整1,2,3 标准5 评分6 组合4,7
                .param("pageNum", "1")
                .param("pageSize", "10")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void findQmByMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findQmByMessage")
                .param("sdate", "2021-06-01")
                .param("edate", "2021-07-01")
                .param("platform_on", "01")
                .param("cykb", "")
                .param("order", "")
                .param("ascDesc", "true")
                .param("is_link", "2")
                .param("classfiy_id", "1,2,3")
                .param("message", "出院主要中医证候7编码、入院病情、名称、出院情况")
                .param("pageNum", "1")
                .param("pageSize", "10")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void tjfxOne() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tjfx/tjfxOne")
                .param("sdate", "2021-06-01 00:00:00")
                .param("edate", "2021-07-01 23:59:59")
                .param("is_link", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }



    @Test
    void tjfxTwo() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tjfx/tjfxTwo")
                .param("sdate", "2021-06-01 00:00:00")
                .param("edate", "2021-07-01 23:59:59")
                .param("is_link", "2")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void findFz() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hp_qc/findFz")
                .param("bah", "70584601")
                .param("cysj", "2022-02-24 08:48:01")
                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void deletelog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/hp_qc/deleteLog")
                .param("id", "632CE793-84D0-4BB6-8E93-04AAE35CB5FA")

                .contentType(MediaType.APPLICATION_JSON_UTF8))//请求头类型
                .andExpect(OK)//状态码200
                .andDo(print());//结束后打印所有数据
    }

    @Test
    void sss() throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(1);
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
      
        map1.put("id","1");
        map1.put("xc","1");
        map1.put("vv","1");
        map2.put("id","1");
        map2.put("xc","1");
        map2.put("vv","1");
        mapList.add(map1);
        mapList.add(map2);

        PageList.getListPage1(pageInfo, mapList);
    }



/*
*
*
*
* //自动根据用户引入的分词库的jar来自动选择使用的引擎
TokenizerEngine engine = TokenizerUtil.createEngine();

//解析文本
String text = "这两个方法的区别在于返回值";
Result result = engine.parse(text);
//输出：这 两个 方法 的 区别 在于 返回 值
String resultStr = CollUtil.join((Iterator<Word>)result, " ");*/

}