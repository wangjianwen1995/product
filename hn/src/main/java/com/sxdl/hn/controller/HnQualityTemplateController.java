package com.sxdl.hn.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hn.dao.dao1.HnHandleDao;
import com.sxdl.hn.dto.TemplateDBO;
import com.sxdl.hn.entity.HnQualityAssessment;
import com.sxdl.hn.entity.HnQualityTemplate;
import com.sxdl.hn.service.HnQualityAssessmentService;
import com.sxdl.hn.service.HnQualityTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "质量考核模板 核心 ")
@RestController
@RequestMapping("/template")
public class HnQualityTemplateController {

    @Autowired
    private HnQualityTemplateService templateService;

    @Autowired
    private HnHandleDao hnHandleDao;

    @Autowired
    private HnQualityAssessmentService assessmentService;

    @ApiOperation(value = "根据 类目下的亚目查询模板")
    @GetMapping("/findTemplateBySuborderId")
    public ResultUtil findTemplateBySuborderId(PageInfo pageInfo, @RequestParam(value = "suborder_id",required = true) Integer suborder_id) {
        PageInfo<HnQualityTemplate> hnQualityTemplatePageInfo=null;
        try {
            HnQualityTemplate hnQualityTemplate = new HnQualityTemplate();
            hnQualityTemplate.setSuborder_id(suborder_id);
            hnQualityTemplatePageInfo = templateService.queryPageListBuffer(pageInfo, hnQualityTemplate,"create_time",null,null);
        }catch (Exception e){
            return  ResultUtil.success(e.getMessage());
        }
        return  ResultUtil.success(hnQualityTemplatePageInfo);
    }


    @ApiOperation(value = "根据 模板id查询")
    @GetMapping("/findTemplateByid")
    public ResultUtil findTemplateByid(@RequestParam(value = "id",required = true) Integer id) {
        HnQualityTemplate hnQualityTemplate = null;
        try {
            hnQualityTemplate = templateService.selectByKey(id);
            String suborderName = hnHandleDao.getSuborderName(hnQualityTemplate.getSuborder_id());
            hnQualityTemplate.setSuborder_name(suborderName);
        }catch (Exception e){
            return  ResultUtil.success(e.getMessage());
        }
        return  ResultUtil.success(hnQualityTemplate);
    }



    @ApiOperation(value = "保存修改模板 启用的模板才需要更新缓存")
    @PostMapping("/saveTemplate")
    public ResultUtil saveTemplate(@RequestBody HnQualityTemplate hnQualityTemplate){
        try{
            if(StringUtils.isEmpty( hnQualityTemplate.getId())){ //新增
                Integer insert = templateService.insert(hnQualityTemplate);
            }else{//修改
                //查询模板是否 在考核中已经使用
                List<HnQualityAssessment> byTemplateId = assessmentService.findByTemplateId(hnQualityTemplate.getId());
                if(hnQualityTemplate.getState().equals(1)){ //启用的模板才需要更新缓存
                    if(byTemplateId.size()<=0){
                        //数据持久化  更新缓存中的数据
                        Integer updateCache = templateService.updateCache(hnQualityTemplate);
                    }else{
                        StringBuilder sb = new StringBuilder();
                        sb.append("此模板在 考核时间: "+byTemplateId.get(0).getTime()+" id:"+byTemplateId.get(0).getId()+"  已经使用,请新增模板或删除考核记录");
                        return  ResultUtil.error(sb.toString());
                    }
                }else{
                    if(byTemplateId.size()<=0){
                        //数据持久化  更新缓存中的数据
                        Integer update = templateService.update(hnQualityTemplate);
                    }else{
                        StringBuilder sb = new StringBuilder();
                        sb.append("此模板在 考核时间: "+byTemplateId.get(0).getTime()+" id:"+byTemplateId.get(0).getId()+"  已经使用,请新增模板或删除考核记录");
                        return  ResultUtil.error(sb.toString());
                    }

                }
            }
        }catch (Exception e){
            return  ResultUtil.success(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }



    @ApiOperation(value = "修改模板中的 细目ids 总分值 右侧的保存按钮")
    @PostMapping("/updateTemplatedDetails")
    public ResultUtil updateTemplatedDetails(@RequestBody TemplateDBO templateDBO){
        try{

            HnQualityTemplate hnQualityTemplate = templateService.selectByKey(templateDBO.getId());
            hnQualityTemplate.setTotal_score(templateDBO.getTotal_score());
            if(!"".equals(templateDBO.getDetails_ids())){
                String showIds = hnHandleDao.findDetailsIds(templateDBO.getDetails_ids());
                hnQualityTemplate.setShow_ids(showIds);
            }
            hnQualityTemplate.setDetails_ids(templateDBO.getDetails_ids());
            //查询模板是否 在考核中已经使用
            List<HnQualityAssessment> byTemplateId = assessmentService.findByTemplateId(hnQualityTemplate.getId());
            if(hnQualityTemplate.getState().equals(1)){ //启用的模板 才需要更新缓存
                if(byTemplateId.size()<=0){
                    //数据持久化  更新缓存中的数据
                    Integer updateCache = templateService.updateCache(hnQualityTemplate);
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append("此模板在 考核时间: "+byTemplateId.get(0).getTime()+" id:"+byTemplateId.get(0).getId()+"  已经使用,请新增模板或删除考核记录");
                    return  ResultUtil.error(sb.toString());
                }
              }else{ // 没启用的模板  不更新缓存
                if(byTemplateId.size()<=0){ //判断该模板是否被使用过 ,使用了不能修改 不能删除
                    Integer update = templateService.update(hnQualityTemplate);
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append("此模板在 考核时间: "+byTemplateId.get(0).getTime()+" id:"+byTemplateId.get(0).getId()+"  已经使用,请新增模板或删除考核记录");
                    return  ResultUtil.error(sb.toString());
                }

            }
        }catch (Exception e){
            return  ResultUtil.success(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除模板并且更新缓存")
    @GetMapping("/delTemplate")
    public ResultUtil delTemplate( @RequestParam(value = "template_id",required = true) Integer template_id){
        try{
            //查询模板是否 在考核中已经使用
            List<HnQualityAssessment> byTemplateId = assessmentService.findByTemplateId(template_id);
            if(byTemplateId.size()<=0){
                //数据持久化  更新缓存中的数据
                Integer integer = templateService.delCache(template_id);
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append("此模板在 考核时间: "+byTemplateId.get(0).getTime()+" id:"+byTemplateId.get(0).getId()+"  已经使用,请新增模板或删除考核记录");
                return  ResultUtil.error(sb.toString());
            }
        }catch (Exception e){
            return  ResultUtil.success(e.getMessage());
        }
        return ResultUtil.success("操作成功");
    }





    @ApiOperation(value = "启用模板并且更新缓存")
    @PostMapping("/enableTemplateState")
    public ResultUtil enableTemplateState(@RequestBody HnQualityTemplate hnQualityTemplate){
        try {
            //启用一个模板，同事关闭这个亚目下面的其他模板，并且更新缓存
            Integer integer = templateService.enableTemplateState(hnQualityTemplate);
        }catch (Exception e){
            return  ResultUtil.success(e.getMessage());
        }
        return ResultUtil.success("已启用模板");
    }






}
