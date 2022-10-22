package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffIcuEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffIcuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "ICU人员录入")
@RestController
@RequestMapping("/inputStaffIcu")
public class HmiInputStaffIcuController {

    @Autowired
    private HmiInputStaffIcuService hmiInputStaffIcuService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询已录入的人员信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffIcuEntity entity = new HmiInputStaffIcuEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffIcuEntity> hmiIcu  = hmiInputStaffIcuService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiIcu);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffIcuEntity hmiIcu ) {
        try {
            HmiInputStaffIcuEntity ex = new HmiInputStaffIcuEntity();
            ex.setYear(hmiIcu.getYear());
            ex.setMonth(hmiIcu.getMonth());
            List<HmiInputStaffIcuEntity> select = hmiInputStaffIcuService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiIcu.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiIcu.getYear());
            check.setMonth(hmiIcu.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiIcu.getId())){
                hmiInputStaffIcuService.insert(hmiIcu);
            }else{
                hmiInputStaffIcuService.update(hmiIcu);
            }

            //保存完成之后 同步审核表种的部分数据
            check.setIcuhs_zz(hmiIcu.getIcuhs());
            check.setIcuys_zz(hmiIcu.getIcuys());
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
            hmiInputStaffIcuService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
