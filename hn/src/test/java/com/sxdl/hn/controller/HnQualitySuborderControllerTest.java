package com.sxdl.hn.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.HnMainTest;
import com.sxdl.hn.entity.HnQualitySuborder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


//
//@SpringBootTest
//@AutoConfigureMockMvc
//@WebAppConfiguration
public class HnQualitySuborderControllerTest extends HnMainTest {

    @Autowired
    private HnQualitySuborderController suborderController;
    @Test
    public void findCategorySuborder() {
        ResultUtil categorySuborder = suborderController.findCategorySuborder();
        System.out.println(categorySuborder);
    }

    @Test
    public void findSuborderByCategoryid() {
        ResultUtil suborderByCategoryid = suborderController.findSuborderByCategoryid(1);
        System.out.println(suborderByCategoryid);
    }



    @Test
    public void updateSuborderCache() {
        HnQualitySuborder suborder = new HnQualitySuborder();
        suborder.setId(18);
        suborder.setName("特级护理");
        suborder.setCategory_id(1);
        ResultUtil resultUtil = suborderController.updateSuborderCache(suborder);
        ResultUtil categorySuborder = suborderController.findCategorySuborder();
        System.out.println(resultUtil);
        System.out.println(categorySuborder);


    }
    @Test
    public void delSuborderCache() {
        ResultUtil resultUtil = suborderController.delSuborderCache(17);
        ResultUtil categorySuborder = suborderController.findCategorySuborder();
        System.out.println(categorySuborder);

    }
}