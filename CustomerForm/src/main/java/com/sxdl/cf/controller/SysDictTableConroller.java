package com.sxdl.cf.controller;

import com.sxdl.cf.config.CFRunner;
import com.sxdl.cf.dto.SqlQueryDBO;
import com.sxdl.cf.entity.SysDictTable;
import com.sxdl.cf.service.SysCustomerFormFieldTableService;
import com.sxdl.cf.util.DataUtil;
import com.sxdl.cf.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;


@Api(tags = "字典表表名信息")
@RestController(value = "sysDictTable")
@RequestMapping("/dev/dt")
@RequiredArgsConstructor
public class SysDictTableConroller {

    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private final SysCustomerFormFieldTableService fieldService;

    private final CFRunner cfRunner;
    //查询所有字典表类型
    @ApiOperation(value = "查询", notes = "查询字典表表名信息")
    @GetMapping("/findAll")
    public ResultUtil findAll( @RequestParam(name = "name" ,defaultValue = "",required = false) String name ) {
        List<SysDictTable> list = null;
        try {
            list = CFRunner.CFDT.stream()
                    .filter(f->(f.getId().toString()).equals(name)|| f.getName().contains(name) || f.getName_zh().contains(name))
                    .collect(Collectors.toList());
            //list = dictTableDao2.getDictByNameAndZh(name);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success ( list );
    }
    //刷新缓存
    @ApiOperation(value = "刷新字典表缓存" )
    @GetMapping("/refdt")
    public ResultUtil refdt() {
        try {
            cfRunner.ref();
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success ( DataUtil.SUCCESS_MASSAGE);
    }



    // 查询自定义sql 下拉框数据
    @ApiOperation(value = "查询sql")
    @PostMapping("/getDataBySql")
    public ResultUtil getDataBySql( @RequestBody SqlQueryDBO dataDBO ) {
        List<LinkedHashMap<String, Object>>  result = null;
        try {
            result = fieldService.getDataBysql(dataDBO);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(), DataUtil.ERROR_MASSAGE);
        }
        return ResultUtil.success ( result );
    }




}