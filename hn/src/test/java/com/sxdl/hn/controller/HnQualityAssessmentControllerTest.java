package com.sxdl.hn.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.HnMainTest;
import com.sxdl.hn.entity.HnQualityAssessment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HnQualityAssessmentControllerTest extends HnMainTest {

    @Autowired
    private HnQualityAssessmentController assessmentController;

    @Test
    public void findHlbAssessment() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(15);
        ResultUtil hlbAssessment = assessmentController.findhzinfo(pageInfo, null, null);
        System.out.println(hlbAssessment);

    }


    @Test
    public void saveAssessment() {
        HnQualityAssessment assessment = new HnQualityAssessment();

        ResultUtil resultUtil = assessmentController.saveAssessment(assessment);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(15);
        ResultUtil hlbAssessment = assessmentController.findhzinfo(pageInfo, null, null);
        System.out.println(hlbAssessment);
    }
}