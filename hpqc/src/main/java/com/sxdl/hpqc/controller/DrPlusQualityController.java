package com.sxdl.hpqc.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hpqc.dbo.DrQualityDBO;
import com.sxdl.hpqc.service.DrPlusControlBzxService;
import com.sxdl.hpqc.service.DrPlusControlLjxService;
import com.sxdl.hpqc.service.DrPlusControlWzxService;
import com.sxdl.hpqc.util.DataUtil;
import com.sxdl.hpqc.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@Api(tags = "质控维护")
@RestController
@RequestMapping("/quality")
public class DrPlusQualityController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    public static final String LineBreak = "\r\n";
    @Autowired
    private DrPlusControlBzxService bzxService;

    @Autowired
    private DrPlusControlWzxService wzxService;

    @Autowired
    private DrPlusControlLjxService ljxService;


    /**
     * 50条为一页
     * @param type 1标准性  2完整性  3逻辑性
     * @param val
     * @return
     */
    @ApiOperation(value = "获取标准质控数据")
    @GetMapping("/getQualityData")
    public ResultUtil getQualityData(PageInfo pageInfo, @RequestParam(value = "type",required = true) Integer type,
                                     @RequestParam(value = "val",defaultValue = "") String val ,
                                     @RequestParam(value = "pid",required = true) Integer pid
    ) {
        PageInfo  listData = null ;
        try {
            if(1==type){
                listData = PageUtil.getPageInfoData(pageInfo, bzxService::getBzxData,pid,val);
            }else if(2==type){
                listData = PageUtil.getPageInfoData(pageInfo, wzxService::getWzxData,pid,val);
            }else if(3==type){
                listData = PageUtil.getPageInfoData(pageInfo, ljxService::getLjxData,pid,val);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getCause(), DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listData);
    }


    @ApiOperation("保存修改 质控标准 启用停用")
    @PostMapping(  "/saveQualityData")
    public ResultUtil saveQualityData(@RequestBody  @Valid DrQualityDBO qualityDBO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            if(1==qualityDBO.getType()){
                bzxService.saveQualityData(qualityDBO);
            }else if(2==qualityDBO.getType()){
                wzxService.saveQualityData(qualityDBO);
            }else if(3==qualityDBO.getType()){
                ljxService.saveQualityData(qualityDBO);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getCause(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     * 前端验证 如果当前平台质控调标准是启用状态下,不允许删除
     *   后台验证,如果有其他平台在使用,不能删除
     * @param id 质控标准id
     * @param type  1 标准 2完整 3逻辑
     * @return
     */
    @ApiOperation("删除质控数据")
    @DeleteMapping( "/delData")
    public ResultUtil delData(@RequestParam (value = "id" ,required = true) Integer id,
                              @RequestParam (value = "type" ,required = true) Integer type){

        try {
            if(1==type){
                bzxService.delData(id);
            }else if(2==type){
                wzxService.delData(id);
            }else if(3==type){
                ljxService.delData(id);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getCause(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }







}
