package com.sxdl.cf.controller;


import com.sxdl.cf.entity.SysCustomerFormClassifyEntity;
import com.sxdl.cf.service.SysCustomerFormClassifyService;
import com.sxdl.cf.service.SysCustomerFormFactTableService;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "分类管理" )
@RestController
@RequestMapping("/dev/classify")
@RequiredArgsConstructor
public class SysCustomerFormClassifyController {
    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    

    private final SysCustomerFormClassifyService classifyService;

    private final SysCustomerFormFactTableService tableService;


    @ApiOperation(value = "查询分类列表")
    @GetMapping("/getClassifyList")
    public ResultUtil getClassifyList(  ){
        List<SysCustomerFormClassifyEntity> list = null;
        try {
            list = classifyService.getClassifyList();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( list);
    }

    @ApiOperation(value = "修改保存分类")
    @PostMapping("/saveClassify")
    public ResultUtil saveClassify(@RequestBody @Valid SysCustomerFormClassifyEntity classifyEntity, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultUtil.error (bindingResult.getFieldError().getDefaultMessage());
        }
        try {
            if(StringUtils.isEmpty(classifyEntity.getId())){
                classifyService.addClassify(classifyEntity);
            }else{
                classifyService.setClassify(classifyEntity);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    @ApiOperation(value = "删除分类")
    @GetMapping("/delClassify")
    public ResultUtil delClassify( @RequestParam(value = "id",required = true) String id ){
        try {
            if(tableService.existsTable(id)>0)
                return ResultUtil.error( "分类下有事实表,无法删除");
             classifyService.delClassify(id);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( DataUtil.SUCCESS_MASSAGE);
    }









}
