package com.sxdl.hp.controller;

import com.sxdl.hp.HpMainTest;
import com.sxdl.hp.dao.dao1.HpHomepageDao;
import com.sxdl.hp.dao.dao1.HpMidTableDao;
import com.sxdl.hp.entity.HomepageEntity;
import com.sxdl.hp.entity.HpVsch0AEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.StringUtils;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class HpMidTableTest extends HpMainTest {
    @Autowired
    private HpMidTableDao hpMidTableDao;


    @Autowired
    private HpHomepageDao hpHomepageDao;


    @Test
    public  void test(){

        try{
            HpVsch0AEntity entityA = new HpVsch0AEntity();
            entityA.setID("1111");
//            entityA.setCH0A04(null);
            HomepageEntity homepageEntity = new HomepageEntity();
            homepageEntity.setA_id("11111");
            homepageEntity.setZkrq(StringUtils.isEmpty(entityA.getCH0A04() ) ? null :entityA.getCH0A04());

            int insert = hpHomepageDao.insertSelective(homepageEntity);
            System.out.println("111");
        }catch (Exception e){
            e.getLocalizedMessage();
        }



    }
    @Disabled
    @Test
    public void findAll() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.post ( "/hp_mid/findAll" )//路径
                .param ( "strTime", "2021-02-01" )
                .param ( "endTime", "2021-03-01" )
                .param ( "blh", "" )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void hbi() throws Exception {
        mockMvc.perform ( MockMvcRequestBuilders.post ( "http://192.168.2.200:23306/accesstoken" )//路径
                .param ( "appsecret", "sxdl" )
                .contentType ( MediaType.APPLICATION_JSON_UTF8 ) )
                .andExpect(OK)
                .andDo(print());
    }



}
