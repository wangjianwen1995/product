package com.sxdl.hpqc.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.hpqc.dbo.DrQualityDBO;
import com.sxdl.hpqc.entity.DrPlusControlResult;
import com.sxdl.hpqc.service.DrPlusControlResultService;
import com.sxdl.hpqc.service.DrPlusDataTypeService;
import com.sxdl.hpqc.util.DataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Api(tags = "质控 审核")
@RestController
@RequestMapping("/qualityStart")
public class DrPlusQualityResultController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";

    @Autowired
    private DrPlusControlResultService resultService;


    @Autowired
    private DrPlusDataTypeService dataTypeService;

    @ApiOperation(value = "批量数据质控根据批次")
    @GetMapping("/qualityByList")
    public ResultUtil qualityByList(@RequestParam(value = "extract_id",required = true) Integer extract_id,
                                    @RequestParam(value = "pid",required = true) Integer pid) {

        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            if(6==pid||7==pid){
                //删除 整理数据
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableAdd(pid, extract_id);
                //插入数据
                resultService.qualityByListAdd(extract_id,pid,drQualityDBOS);
            }else if(10==pid){
                //删除 整理数据
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOnetoMany(pid, extract_id);
                //插入数据
                resultService.qualityByListOnetoMany(extract_id,pid,drQualityDBOS);
            }else {
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTable(pid, extract_id);
                resultService.qualityByList(extract_id,pid,drQualityDBOS);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "整组数据质控")
    @GetMapping("/qualityByOne")
    public ResultUtil qualityByOne(@RequestParam(value = "extract_id",required = true) Integer extract_id,
                                   @RequestParam(value = "pid",required = true) Integer pid,
                                   @RequestParam(value = "PRIMAEYKEY",required = true) String PRIMAEYKEY) {

        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            if(6==pid||7==pid){
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOneAdd(pid, PRIMAEYKEY);
                resultService.qualityByOneAdd(pid,extract_id,PRIMAEYKEY,drQualityDBOS);
            }else{
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOne(pid, PRIMAEYKEY);
                resultService.qualityByOne(pid,extract_id,PRIMAEYKEY,drQualityDBOS);
            }

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "单个质控信息回显")
    @GetMapping("/getQualityResultOneInfo")
    public ResultUtil getQualityResultOneInfo(@RequestParam(value = "pid",required = true) Integer pid,
                                              @RequestParam(value = "PRIMAEYKEY",required = true) String PRIMAEYKEY) {
        Map<Integer, List<DrPlusControlResult>> map ;
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            List<DrPlusControlResult> results = resultService.getQualityResultOneInfo(pid, PRIMAEYKEY);
            if(results.size()<1)
                return  ResultUtil.success(null);
            map = results.stream().collect(Collectors.groupingBy(e -> e.getType()));
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(map);
    }
}
