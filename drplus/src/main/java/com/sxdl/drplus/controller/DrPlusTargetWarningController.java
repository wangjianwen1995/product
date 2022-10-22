package com.sxdl.drplus.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.entity.DrPlusTargetWarning;
import com.sxdl.drplus.service.DrPlusDataTypeService;
import com.sxdl.drplus.service.DrPlusTargetWarningService;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "指标预警")
@RestController
@RequestMapping("/target")
@RequiredArgsConstructor
public class DrPlusTargetWarningController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    private final DrPlusTargetWarningService targetService;


    private final DrPlusDataTypeService dataTypeService;

    @ApiOperation(value = "查询指标列表")
    @GetMapping("/getTargetList")
    public ResultUtil getTargetList(PageInfo pageInfo,
                                    @RequestParam(value = "pid",required = true) Integer pid ,
                                    @RequestParam(value = "val",defaultValue = "") String val){
        PageInfo list =null;
        try {
            list = PageUtil.getPageInfoData(pageInfo, targetService::getTargetList,pid,val);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }



    @ApiOperation(value = "新增,修改指标")
    @PostMapping("/saveTarget")
    public ResultUtil saveTarget(@RequestBody @Valid DrPlusTargetWarning targetWarning, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            Integer integer = targetService.saveSimple(targetWarning);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    @ApiOperation(value = "删除指标")
    @GetMapping("/delTarget")
    public ResultUtil delTarget(@RequestParam(value = "id",required = true) Integer id) {

        try {
            Integer integer = targetService.deleteById(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    @ApiOperation(value = "启停指标")
    @GetMapping("/enableTarget")
    public ResultUtil enableTarget(@RequestParam(value = "id",required = true) Integer id,
                                   @RequestParam(value = "OnOff",required = true) Integer OnOff) {

        try {
            targetService.enableTarget(id,OnOff);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "查询平台指标")
    @GetMapping("/getTargetResult")
    public ResultUtil getTargetResult( @RequestParam(value = "pid",required = true) Integer pid ,
                                    @RequestParam(value = "eid",required = true) Integer eid){
        List<LinkedHashMap<String, Object>> targetResult= null;
        try {
            targetResult = targetService.getTargetResult(pid, eid);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(targetResult );
    }



    @ApiOperation(value = "测试按钮")
    @PostMapping("/getTestTarget")
    public ResultUtil getTestTarget( @RequestBody Map<String ,Object> map  ){
        try {
            Integer pid  = (Integer) map.get("pid");
            Integer isuse  = (Integer) map.get("isuse");
            String usetable  =  map.get("usetable").toString();
            String sql= map.get("sql").toString();
            Integer integer = targetService.getTestTarget(pid,sql,isuse,usetable);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error("SQL脚本错误");
        }
        return  ResultUtil.success("测试成功" );
    }


    @ApiOperation(value = "上报数据差异对比:统计功能")
    @GetMapping("/getReportResultCount")
    public ResultUtil getReportResultCount(
                                      @RequestParam(value = "stime",required = true) String stime,
                                      @RequestParam(value = "etime",required = true) String etime) {

        List<LinkedHashMap<String,Object>> list = null;
        try {
             list = dataTypeService.getReportResult(stime,etime);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    /**
     *  以p1 为主判断p1 平台中 独有的数据
     *
     * @param p1 平台id
     * @param p2 平台id
     * @param stime  开始时间
     * @param etime  结束时间
     * @return
     */
    @ApiOperation(value = "上报数据差异对比:下钻明细1")
    @GetMapping("/drillDownDiff")
    public ResultUtil drillDownDiff(PageInfo pageInfo,@RequestParam(value = "p1",required = true) Integer p1,
                                    @RequestParam(value = "p2",required = true) Integer p2,
                                    @RequestParam(value = "stime",required = true) String stime,
                                    @RequestParam(value = "etime",required = true) String etime) {

        PageInfo pageInfo1 = null;
        try {
            PageUtil.setPageInfo(pageInfo);
            pageInfo1 = PageUtil.getPageInfo(dataTypeService.drillDownDiff(p1, p2, stime, etime), pageInfo);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(pageInfo1);
    }




}
