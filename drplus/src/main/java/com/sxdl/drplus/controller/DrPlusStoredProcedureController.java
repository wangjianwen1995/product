package com.sxdl.drplus.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.entity.DrPlusStoredProcedure;
import com.sxdl.drplus.service.DrPlusStoredProcedureService;
import com.sxdl.drplus.util.DataUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "外部存储过程接口")
@RestController
@RequestMapping("/storedProcedure")
public class DrPlusStoredProcedureController {
    public static final String LineBreak = "\r\n";
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private DrPlusStoredProcedureService storedProcedureService;

    @ApiOperation(value = "修改保存存储过程信息")
    @PostMapping("/saveStoredProcedure")
    public ResultUtil saveStoredProcedure(@RequestBody DrPlusStoredProcedure drPlusStoredProcedure) {
        List<String> list = new ArrayList<>();
        try {
            storedProcedureService.saveStoredProcedure(drPlusStoredProcedure);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    @ApiOperation(value = "获取类别信息")
    @GetMapping("/getStoredProcedureData")
    public ResultUtil getStoredProcedureData(@RequestParam(value = "pid",required = true) Integer pid,
                                             @RequestParam(value = "val",defaultValue ="") String val) {
        List<DrPlusStoredProcedure> list = new ArrayList<>();
        try {
            list = storedProcedureService.getStoredProcedureData(pid,val);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(list);
    }


    @ApiOperation(value = "删除一条存储过程信息")
    @GetMapping("/delStoredProcedureData")
    public ResultUtil delStoredProcedureData(@RequestParam(value = "id",required = true) Integer id) {
        try {
             storedProcedureService.delStoredProcedureData(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    @ApiOperation(value = "执行储存过程")
    @GetMapping("/execProc")
    public ResultUtil execProc(@RequestParam(value = "sql",required = true) String sql) {
        try {
            storedProcedureService.execProc(sql);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


}
