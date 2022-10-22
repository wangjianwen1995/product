package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputBedEntity;
import com.sxdl.hmi.entity.HmiInputHosInfoEntity;
import com.sxdl.hmi.service.HmiInputBedService;
import com.sxdl.hmi.service.HmiInputHosInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "床位信息录入")
@RestController
@RequestMapping("/inputHosInfo")
public class HmiInputBedController {

    @Autowired
    private HmiInputHosInfoService hmiInputHosInfoService;


    @Autowired
    private HmiInputBedService hmiInputBedService;

/*    @Autowired
    private SysKsService sysKsService;*/


    @ApiOperation(value = "查询所有已录入床位信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputHosInfoEntity entity = new HmiInputHosInfoEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputHosInfoEntity> hmiHosInfo  = hmiInputHosInfoService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiHosInfo);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }


   /* @ApiOperation(value = "录入科室初始化", notes = "查询科室信息")
    @GetMapping("/findKs")
    public ResultUtil findKs() {
        try {
            SysKs ksEntity = new SysKs();
            //ksEntity.setIs_id(1);
            List<SysKs> ksList = sysKsService.select(ksEntity);
            return ResultUtil.success ( ksList );

        }catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }*/



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputHosInfoEntity hmiHosInfo ) {
        try {
            HmiInputHosInfoEntity hos = new HmiInputHosInfoEntity();
            hos.setYear(hmiHosInfo.getYear());
            hos.setMonth(hmiHosInfo.getMonth());
            List<HmiInputHosInfoEntity> select = hmiInputHosInfoService.select(hos);
            if(select.size()>0 && StringUtil.isEmpty(hmiHosInfo.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            if(StringUtil.isEmpty(hmiHosInfo.getId())){
                hmiInputHosInfoService.insert(hmiHosInfo);
                List<HmiInputBedEntity> ksInfo = hmiHosInfo.getKsInfo();
                ksInfo.forEach(e -> {
                    e.setYear(hmiHosInfo.getYear());
                    e.setMonth(hmiHosInfo.getMonth());
                    e.setHosid(hmiHosInfo.getId());
                    hmiInputBedService.insert(e);
                });

            }else{
                hmiInputHosInfoService.update(hmiHosInfo);
                List<HmiInputBedEntity> ksInfo = hmiHosInfo.getKsInfo();
                ksInfo.forEach(e -> {
                    e.setYear(hmiHosInfo.getYear());
                    e.setMonth(hmiHosInfo.getMonth());
                    hmiInputBedService.update(e);
                });
            }

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }


    @ApiOperation(value = "打开修改界面")
    @GetMapping("/toUpdate")
    public ResultUtil toUpdate(@RequestParam(value = "id",required = true) String id) {
        Map<String, Object> listPage = null;
        try {
            HmiInputHosInfoEntity hmiHosInfo  = hmiInputHosInfoService.findById(id);
            HmiInputBedEntity ksbed = new HmiInputBedEntity();
            ksbed.setHosid(hmiHosInfo.getId());
            List<HmiInputBedEntity> ksInfo = hmiInputBedService.select(ksbed);
            ksInfo = ksInfo.stream().sorted(Comparator.comparing(HmiInputBedEntity::getSjkfbed)).
                    collect(Collectors.toList());
            hmiHosInfo.setKsInfo(ksInfo);
            return ResultUtil.success ( hmiHosInfo );

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delById")
    public ResultUtil delColumnById(@RequestParam(value = "id",required = true) String id ) {
        try {
            hmiInputHosInfoService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
