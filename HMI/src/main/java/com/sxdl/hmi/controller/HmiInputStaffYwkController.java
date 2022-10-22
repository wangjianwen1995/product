package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffYwkEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffYwkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "医务科人员录入")
@RestController
@RequestMapping("/inputStaffYwk")
public class HmiInputStaffYwkController {

    @Autowired
    private HmiInputStaffYwkService hmiInputStaffYwkService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询所有已录入床位信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffYwkEntity entity = new HmiInputStaffYwkEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffYwkEntity> hmiYwk  = hmiInputStaffYwkService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiYwk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffYwkEntity hmiYwk ) {
        try {
            HmiInputStaffYwkEntity ex = new HmiInputStaffYwkEntity();
            ex.setYear(hmiYwk.getYear());
            ex.setMonth(hmiYwk.getMonth());
            List<HmiInputStaffYwkEntity> select = hmiInputStaffYwkService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiYwk.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiYwk.getYear());
            check.setMonth(hmiYwk.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiYwk.getId())){
                hmiInputStaffYwkService.insert(hmiYwk);
            }else{
                hmiInputStaffYwkService.update(hmiYwk);
            }

            //保存完成之后 同步审核表种的部分数据
            check.setCcuys_yw(hmiYwk.getCcuys());
            check.setGrgdys_yw(hmiYwk.getGrgdys());
            check.setGrzgys_yw(hmiYwk.getGrzgys());
            check.setIcuys_yw(hmiYwk.getIcuys());
            check.setJzgdys_yw(hmiYwk.getJzgdys());
            check.setJzzgys_yw(hmiYwk.getJzzgys());
            check.setKfs_yw(hmiYwk.getKfs());
            check.setKfys_yw(hmiYwk.getKfys());
            check.setMzys_yw(hmiYwk.getMzys());
            check.setNicuys_yw(hmiYwk.getNicuys());
            check.setRicuys_yw(hmiYwk.getRicuys());
            check.setZyys_yw(hmiYwk.getZyys());
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
            hmiInputStaffYwkService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
