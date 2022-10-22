package com.sxdl.hmi.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "人员录入审核")
@RestController
@RequestMapping("/inputStaffCheck")
public class HmiInputStaffCheckController {

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;




    @ApiOperation(value = "查询审核列表")
    @GetMapping("/findCheckList")
    public ResultUtil findColumnsByHeader(Integer year) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffCheckEntity entity = new HmiInputStaffCheckEntity();
            entity.setYear(year);
            List<HmiInputStaffCheckEntity> hmiCheck  = hmiInputStaffCheckService.select(entity);
            hmiCheck = hmiCheck.stream().sorted(Comparator.comparing(HmiInputStaffCheckEntity::getMonth)).
                    collect(Collectors.toList());
            Map<Integer,HmiInputStaffCheckEntity> map = new HashMap<>();
            hmiCheck.forEach(e -> {
                map.put(e.getMonth(),e);
            });
            return  ResultUtil.success(map);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }

    }



    @ApiOperation(value = "审核操作")
    @PostMapping("/check")
    public ResultUtil check( @RequestBody HmiInputStaffCheckEntity hmiCheck ) {
        try {
            if(StringUtil.isEmpty(hmiCheck.getId())){
                return  ResultUtil.success("没有上报数据，审核失败！！");
            }else{
                hmiCheck.setStatus(2);
                hmiInputStaffCheckService.update(hmiCheck);
            }

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("审核成功");
    }

    @ApiOperation(value = "进入审核界面")
    @GetMapping("/toCheck")
    public ResultUtil toCheck(@RequestParam(value = "id",required = true) String id ) {
        try {
            HmiInputStaffCheckEntity checkEntity = hmiInputStaffCheckService.findById(id);

            return ResultUtil.success(checkEntity);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }

    }

    @ApiOperation(value = "撤销审核")
    @GetMapping("/revokeCheck")
    public ResultUtil revokeCheck(@RequestParam(value = "id",required = true) String id ) {
        try {
            HmiInputStaffCheckEntity checkEntity = hmiInputStaffCheckService.findById(id);
            checkEntity.setStatus(1);
            hmiInputStaffCheckService.update(checkEntity);
            return ResultUtil.success("撤销审核成功！");
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }

    }







}
