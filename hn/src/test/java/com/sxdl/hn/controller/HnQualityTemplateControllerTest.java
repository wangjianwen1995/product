package com.sxdl.hn.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.entity.HnQualityTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;



@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class HnQualityTemplateControllerTest {

    @Autowired
    private HnQualityTemplateController templateController;

    @Test
    public void findTemplateBySuborderId() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(15);
        ResultUtil templateBySuborderId = templateController.findTemplateBySuborderId(pageInfo,1);
        System.out.println(templateBySuborderId);

    }

    @Test
    public void saveTemplate() {
        HnQualityTemplate template = new  HnQualityTemplate();
        //template.setId(1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date());
        template.setName("第三季一级护理");
        template.setCreate_time(format1);
        template.setAssessor("201,205");
        template.setContent_code("0001,00010001,00010002,00010003,0002,00020001");
        template.setDetails_ids("1,2,3,4,5,6");
        template.setTotal_score(23.0);
        template.setQualified_score(15.0);
        template.setPass_rate(95.00);
        template.setChecktype("a");
        template.setScoring_type(1);
        template.setComment("检查方法:1、现场检查病人与考核护士相结合" +
                "2、住院期间因护理不当出现压疮、烫伤、坠床中的一项者，本次检查不得分。");
        template.setSuborder_id(1);
        template.setState(-1);
        ResultUtil resultUtil = templateController.saveTemplate(template);
        System.out.println(resultUtil);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(15);
        ResultUtil templateBySuborderId = templateController.findTemplateBySuborderId(pageInfo,1);
        System.out.println(templateBySuborderId);

    }

    @Test
    public void delTemplate() {
        ResultUtil resultUtil = templateController.delTemplate(2);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(15);
        ResultUtil templateBySuborderId = templateController.findTemplateBySuborderId(pageInfo,1);
        System.out.println(resultUtil);
        System.out.println(templateBySuborderId);

    }



    @Value("${personnelfiles}")
    private String personnelfiles;


    @Test
    public void uploadeFiles(){
        String s = personnelfiles + "pathUrl" + "\\";
        String createUrl = s.replaceAll("\\\\", "\\\\\\\\");
        System.out.println( createUrl);
    }

    @Autowired
    private HnHandleDao hnHandleDao;
    @Test
    public void ids(){
        String detailsIds = hnHandleDao.findDetailsIds("1,2,3,4,5,6");
        System.out.println(detailsIds);
    }

}