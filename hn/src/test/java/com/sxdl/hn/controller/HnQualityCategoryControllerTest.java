package com.sxdl.hn.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.entity.HnQualityCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class HnQualityCategoryControllerTest {

    @Autowired
    private HnQualityCategoryController categoryController;

    @Test
    public void findAllcategory() {

        ResultUtil allcategory = categoryController.findAllcategory();
        System.out.println(allcategory.getT());

    }

    @Test
    public void updatecategory() {
        HnQualityCategory category = new HnQualityCategory();
        category.setName("专项小组考核");
        ResultUtil updatecategory = categoryController.updatecategory(category);
        System.out.println(updatecategory);

    }

    @Test
    public void delcategory() {

        ResultUtil delcategory = categoryController.delcategory(3);
        ResultUtil allcategory = categoryController.findAllcategory();
        System.out.println(allcategory);
    }
}