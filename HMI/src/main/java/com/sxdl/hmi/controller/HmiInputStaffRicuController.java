package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffRicuEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffRicuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "RICU人员录入")
@RestController
@RequestMapping("/inputStaffRicu")
public class HmiInputStaffRicuController {

    @Autowired
    private HmiInputStaffRicuService hmiInputStaffRicuService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询已录入的人员信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffRicuEntity entity = new HmiInputStaffRicuEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffRicuEntity> hmiRicu  = hmiInputStaffRicuService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiRicu);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffRicuEntity hmiRicu ) {
        try {
            HmiInputStaffRicuEntity ex = new HmiInputStaffRicuEntity();
            ex.setYear(hmiRicu.getYear());
            ex.setMonth(hmiRicu.getMonth());
            List<HmiInputStaffRicuEntity> select = hmiInputStaffRicuService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiRicu.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiRicu.getYear());
            check.setMonth(hmiRicu.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiRicu.getId())){
                hmiInputStaffRicuService.insert(hmiRicu);
            }else{
                hmiInputStaffRicuService.update(hmiRicu);
            }
            //保存完成之后 同步审核表种的部分数据
            check.setRicuhs_zz(hmiRicu.getRicuhs());
            check.setRicuys_zz(hmiRicu.getRicuys());
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
            hmiInputStaffRicuService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
