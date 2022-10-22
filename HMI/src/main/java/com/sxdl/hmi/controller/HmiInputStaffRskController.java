package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffRskEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffRskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "人事科人员录入")
@RestController
@RequestMapping("/inputStaffRsk")
public class HmiInputStaffRskController {

    @Autowired
    private HmiInputStaffRskService hmiInputStaffRskService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询所有已录入人员信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffRskEntity entity = new HmiInputStaffRskEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffRskEntity> hmiRsk  = hmiInputStaffRskService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiRsk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffRskEntity hmiRsk ) {
        try {
            HmiInputStaffRskEntity ex = new HmiInputStaffRskEntity();
            ex.setYear(hmiRsk.getYear());
            ex.setMonth(hmiRsk.getMonth());
            List<HmiInputStaffRskEntity> select = hmiInputStaffRskService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiRsk.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiRsk.getYear());
            check.setMonth(hmiRsk.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiRsk.getId())){
                hmiInputStaffRskService.insert(hmiRsk);
            }else{
                hmiInputStaffRskService.update(hmiRsk);
            }
            //保存完成之后 同步审核表种的部分数据
            check.setJzgdhs_rs(hmiRsk.getJzgdhs());
            check.setJzgdys_rs(hmiRsk.getJzgdys());
            check.setJzzghs_rs(hmiRsk.getJzzghs());
            check.setJzzgys_rs(hmiRsk.getJzzgys());
            check.setIcuhs_rs(hmiRsk.getIcuhs());
            check.setIcuys_rs(hmiRsk.getIcuys());
            check.setCcuhs_rs(hmiRsk.getCcuhs());
            check.setCcuys_rs(hmiRsk.getCcuys());
            check.setRicuhs_rs(hmiRsk.getRicuhs());
            check.setRicuys_rs(hmiRsk.getRicuys());
            check.setNicuhs_rs(hmiRsk.getNicuhs());
            check.setNicuys_rs(hmiRsk.getNicuys());
            check.setMzys_rs(hmiRsk.getMzys());
            check.setZyhs_rs(hmiRsk.getZyhs());
            check.setZyys_rs(hmiRsk.getZyys());
            check.setKfhs_rs(hmiRsk.getKfhs());
            check.setKfs_rs(hmiRsk.getKfs());
            check.setKfys_rs(hmiRsk.getKfys());
            check.setGrgdhs_rs(hmiRsk.getGrgdhs());
            check.setGrgdys_rs(hmiRsk.getGrgdys());
            check.setGrzghs_rs(hmiRsk.getGrzghs());
            check.setGrzgys_rs(hmiRsk.getGrzgys());
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
            hmiInputStaffRskService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
