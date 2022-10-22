package com.sxdl.hn.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.entity.Hmglhcpf;
import com.sxdl.hn.entity.HnQualitydetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.entity.Example;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class HnQualitydetailsControllerTest {


    @Autowired
    private HnQualitydetailsController detailsController;

    @Test
    public void findAllDetails() {
        ResultUtil allDetails = detailsController.findAllDetails(1);
        System.out.println(allDetails);
    }

    @Test
    public void saveDetails() {
       HnQualitydetails hnQualitydetails = new HnQualitydetails();
        /* hnQualitydetails.setName("掌握病情八知道");
        hnQualitydetails.setCode("0002");
        hnQualitydetails.setSuborder_id(1);
        hnQualitydetails.setType(-1);*/
       /* hnQualitydetails.setName("陪侍人管理有序、病房内无陪护");
        hnQualitydetails.setCode("00010001");
        hnQualitydetails.setScore(4.0);
        hnQualitydetails.setQualified_score(2.0);
        hnQualitydetails.setDeduction_comment("扣除分值-1，随便来");
        hnQualitydetails.setState(1);
        hnQualitydetails.setSuborder_id(1);
        hnQualitydetails.setPid(1);
        hnQualitydetails.setPcode("0001");
        hnQualitydetails.setType(1);*/
        hnQualitydetails.setId(8);
        hnQualitydetails.setName("既往史");
        hnQualitydetails.setCode("00020003");
        hnQualitydetails.setScore(5.0);
        hnQualitydetails.setQualified_score(3.0);
        hnQualitydetails.setDeduction_comment("扣除分值-1，这块扣分要扣的厉害点哦");
        hnQualitydetails.setState(1);
        hnQualitydetails.setSuborder_id(1);
        hnQualitydetails.setPid(5);
        hnQualitydetails.setPcode("0002");


        ResultUtil resultUtil = detailsController.saveDetails(hnQualitydetails);
        ResultUtil allDetails = detailsController.findAllDetails(1);
        System.out.println(resultUtil);
        System.out.println(allDetails);

    }

    @Test
    public void tes1(){

        Example example = new Example(Hmglhcpf.class);

        Example.Criteria criteria = example.createCriteria();

        Example.Criteria pgsj = criteria.andBetween("pgsj", "startTime", "endTime");

        if(criteria==pgsj){
            System.out.println("1111111");
        }else{
            System.out.println("222222");
        }
    }





}