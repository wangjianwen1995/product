package com.sxdl.hn.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.entity.HnAssessmentFeedback;
import com.sxdl.hn.entity.HnAssessmentQuestions;
import com.sxdl.hn.service.HnAssessmentFeedbackService;
import com.sxdl.hn.service.HnAssessmentQuestionsService;
import com.sxdl.hn.service.HnBaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "考核反馈反馈信息补录数据")
@RestController
@RequestMapping("/hnfeedBack")
public class HnAssessmentFeedbackController {


    @Autowired
    private HnAssessmentFeedbackService feedbackService;

    @Autowired
    private HnBaseService baseService;

    @Autowired
    private HnAssessmentQuestionsService assessmentQuestionsService;


    /**
     * 护理部反馈,时间段来反馈数据,如果有遗漏数据需要再次选择时间单独反馈
     * @param stime
     * @param etime
     * @return
     */
    @ApiOperation(value = "护理部一键反馈")
    @GetMapping("/oneClickFeedbackHlb")
    public ResultUtil oneClickFeedbackHlb(@RequestParam(value = "stime",required = true) String  stime,
                                          @RequestParam(value = "etime",required = true) String  etime
                                          ) {
        try {
            //查询这段时间内存护理部考核有问题的数据 (没有被反馈过的数据)
            List<HnAssessmentQuestions> questionsList =  assessmentQuestionsService.findHlbassessmentQuestions(stime,etime);
            if(questionsList.size()>0){
                // 1 将 科室分组，创建新的反馈集合  2 修改问题数据中的  questionsList.反馈id
                Integer integer  = feedbackService.startFeedbackHlb(questionsList,stime,etime);
            }
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("反馈完成");
    }



    @ApiOperation(value = "提示 信息 定位数据")
    @GetMapping("/findById")
    public ResultUtil findById(  @RequestParam(value = "id",required = true) Integer  id ) {

        HnAssessmentFeedback feedback = null;
        try {
            feedback = feedbackService.findById(id);
            List<SysUser> sysUsers = baseService.findAllNurse();
            //List<SysKs> allKs = baseService.findAllKs();
            Map<String, Object> maps = new HashMap<String,Object>();
            List<Map<String, Object>> kss  = feedbackService.selectSqlWithSQL("select * from sys_ks where is_on=1");
            for (Map<String, Object> stringObjectMap : kss) {
                maps.put((String)stringObjectMap.get("code"),stringObjectMap.get("name"));
            }
            if(!StringUtils.isEmpty(feedback)){
                List<HnAssessmentQuestions> list =  assessmentQuestionsService.findbybackId( feedback.getId());
                feedback.setQuestions(list);
                //回显护士名称
                for (SysUser l : sysUsers) {
                    if(feedback.getHead_nurse().equals(l.getCode())){
                        feedback.setHead_nurse_name(l.getName());
                    }
                }
                //回显科室
                for (String key : maps.keySet()) {
                    if(feedback.getAssessment_kscode().equals(key)){
                        feedback.setAssessment_kscode_name((String) maps.get(key));
                    }
                }

                /*for (SysKs l : allKs) {
                    if(feedback.getAssessment_kscode().equals(l.getCode())){
                        feedback.setAssessment_kscode_name(l.getName());
                    }
                }*/
            }else {
                return  ResultUtil.success(null);
            }
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(feedback);
    }



    @ApiOperation(value = "查询护理部 科室 反馈")
    @GetMapping("/findByHbl")
    public ResultUtil findByHbl(PageInfo pageInfo ,
                                @RequestParam(value = "fbstime",required = true) String  fbstime,
                                @RequestParam(value = "fbetime",required = true) String  fbetime,
                                @RequestParam(value = "kscode",required = false) String  kscode,
                                @RequestParam(value = "isadmin",required = true) String  isadmin,
                                @RequestParam(value = "allkscodes",required = true) String  allkscodes,
                                @RequestParam(value = "ishlb",required = true) Integer  ishlb) {
        List<HnAssessmentFeedback> list = new ArrayList<>();
        Map<String, Object> listPage = null;
        try {

            if(StringUtils.isEmpty(kscode)){
                if("1".equals(isadmin)){ //没有选择科室,管理人员查看全部科室数据
                    list = feedbackService.findByCanAllKs(fbstime,fbetime,ishlb);
                }else {//没有选择科室,科级人员查看  可看科室数据
                    list = feedbackService.findByCanseeKs(fbstime,fbetime,allkscodes,ishlb);
                }
            }else{
                list = feedbackService.findByKs(fbstime,fbetime,kscode,ishlb);
            }
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), list);
            List<HnAssessmentFeedback> list1 = (List<HnAssessmentFeedback>)listPage.get("list");

            List<SysUser> sysUsers = baseService.findAllNurse();
            //List<SysKs> allKs = baseService.findAllKs();
            Map<String, Object> maps = new HashMap<String,Object>();
            List<Map<String, Object>> kss  = feedbackService.selectSqlWithSQL("select * from sys_ks where is_on=1");
            for (Map<String, Object> stringObjectMap : kss) {
                maps.put((String)stringObjectMap.get("code"),stringObjectMap.get("name"));
            }
            if(!StringUtils.isEmpty(list1)){
                list1.forEach(e->{
                    List<HnAssessmentQuestions> list2 =  assessmentQuestionsService.findbybackId( e.getId());
                    e.setQuestions(list2);
                    //回显护士名称
                    sysUsers.forEach(l->{
                        if(!StringUtils.isEmpty(e.getHead_nurse())){
                            if(e.getHead_nurse().equals(l.getCode())){
                                e.setHead_nurse_name(l.getName());
                            }
                        }
                    });
                    //回显护理部名称
                    sysUsers.forEach(l->{
                        if(!StringUtils.isEmpty(e.getHlbcode())){
                            if(e.getHlbcode().equals(l.getCode())){
                                e.setHlbcode_namm(l.getName());
                            }
                        }
                    });

                    //回显科室
                    for (String key : maps.keySet()) {
                        if(!StringUtils.isEmpty(e.getAssessment_kscode())){
                            if(e.getAssessment_kscode().equals(key)){
                                e.setAssessment_kscode_name((String) maps.get(key));
                            }
                        }
                    }
                    //回显科室
                    /*allKs.forEach(l->{
                        if(!StringUtils.isEmpty(e.getAssessment_kscode())){
                            if(e.getAssessment_kscode().equals(l.getCode())){
                                e.setAssessment_kscode_name(l.getName());
                            }
                        }
                    });*/
                });
            }else {
                return  ResultUtil.success(null);
            }
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }


    @ApiOperation(value = "科室反馈")
    @GetMapping("/oneClickFeedbackKs")
    public ResultUtil oneClickFeedbackKs( @RequestParam(value = "stime",required = true) String  stime,
                                         @RequestParam(value = "etime",required = true) String  etime,
                                          @RequestParam(value = "kscode",required = true) String  kscode
                                           ) {
        PageInfo<HnAssessmentFeedback> page = null;
        try {
            //查询这段时间内存 科室自检 考核有问题的数据
            List<HnAssessmentQuestions> questionsList =  assessmentQuestionsService.findKsassessmentQuestions(stime,etime,kscode);
            Integer integer = 0;
            if(!StringUtils.isEmpty(questionsList)){
                if(questionsList.size()>0){
                    // 1 创建新的反馈一条数据  2 修改问题数据中的  questionsList.反馈id
                    integer  = feedbackService.startFeedbackKs(questionsList,stime,etime,kscode);
                }
            }
            if(integer.equals(0)){
                return  ResultUtil.error("此时间段内,没有需要反馈的问题");
            }
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("反馈成功");
    }



    @ApiOperation(value = "责任护士问题改进")
    @PostMapping("/hsMeasures")
    public  ResultUtil hsMeasures(@RequestBody Map<String,List<HnAssessmentQuestions>> mapQuestions){
        try {
            List<HnAssessmentQuestions> list = new ArrayList<>();
            if(mapQuestions.size()>0){
                list = mapQuestions.get(0);
            }else{
                return ResultUtil.error("没有修改的数据");
            }
            Integer integer = feedbackService.upateMeasuresHs(list);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }





    @ApiOperation(value = "科室护士长总结问题改进")
    @PostMapping("/ksMeasures")
    public  ResultUtil ksMeasures(@RequestBody HnAssessmentFeedback feedback){
        try {
            Integer integer = feedbackService.upateMeasures(feedback);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "删除 反馈信息")
    @GetMapping("/delFeedback")
    public  ResultUtil delFeedback(@RequestParam(value = "id",required = true) Integer  id){
        try {
            //1 先删除本次反馈记录,然后  2同时将 存在问题项的反馈id 置空
            Integer integer = feedbackService.delFeedback(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }

}
