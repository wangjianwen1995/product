package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffZykEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffZykService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "中医科人员录入")
@RestController
@RequestMapping("/inputStaffZyk")
public class HmiInputStaffZykController {

    @Autowired
    private HmiInputStaffZykService hmiInputStaffZykService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询所有已录入床位信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffZykEntity entity = new HmiInputStaffZykEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffZykEntity> hmiZyk  = hmiInputStaffZykService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiZyk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffZykEntity hmiZyk ) {
        try {
            HmiInputStaffZykEntity ex = new HmiInputStaffZykEntity();
            ex.setYear(hmiZyk.getYear());
            ex.setMonth(hmiZyk.getMonth());
            List<HmiInputStaffZykEntity> select = hmiInputStaffZykService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiZyk.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiZyk.getYear());
            check.setMonth(hmiZyk.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiZyk.getId())){
                hmiInputStaffZykService.insert(hmiZyk);
            }else{
                hmiInputStaffZykService.update(hmiZyk);
            }
            //保存完成之后 同步审核表种的部分数据
            check.setZyhs_zy(hmiZyk.getZyhs());
            check.setZyys_zy(hmiZyk.getZyys());
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
            hmiInputStaffZykService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
