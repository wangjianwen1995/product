package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffNicuEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffNicuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "NICU人员录入")
@RestController
@RequestMapping("/inputStaffNicu")
public class HmiInputStaffNicuController {

    @Autowired
    private HmiInputStaffNicuService hmiInputStaffNicuService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询已录入的人员信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffNicuEntity entity = new HmiInputStaffNicuEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffNicuEntity> hmiNicu  = hmiInputStaffNicuService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiNicu);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffNicuEntity hmiNicu ) {
        try {
            HmiInputStaffNicuEntity ex = new HmiInputStaffNicuEntity();
            ex.setYear(hmiNicu.getYear());
            ex.setMonth(hmiNicu.getMonth());
            List<HmiInputStaffNicuEntity> select = hmiInputStaffNicuService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiNicu.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiNicu.getYear());
            check.setMonth(hmiNicu.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiNicu.getId())){
                hmiInputStaffNicuService.insert(hmiNicu);
            }else{
                hmiInputStaffNicuService.update(hmiNicu);
            }
            //保存完成之后 同步审核表种的部分数据
            check.setNicuhs_zz(hmiNicu.getNicuhs());
            check.setNicuys_zz(hmiNicu.getNicuys());
            check.setStatus(1);
            if(ListSelect==null || ListSelect.size()==0){
                hmiInputStaffCheckService.insert(check);
            }else{
                hmiInputStaffCheckService.update(check);
            }

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delById")
    public ResultUtil delColumnById(@RequestParam(value = "id",required = true) String id ) {
        try {
            hmiInputStaffNicuService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
