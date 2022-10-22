package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputBqhsEntity;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffHlbEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffHlbService;
import com.sxdl.hmi.service.HmiInputStaffYqhsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "护理部人员录入")
@RestController
@RequestMapping("/inputStaffHlb")
public class HmiInputStaffHlbController {

    @Autowired
    private HmiInputStaffHlbService hmiInputStaffHlbService;

    @Autowired
    private HmiInputStaffYqhsService hmiInputStaffYqhsService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询所有已录入床位信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffHlbEntity entity =new HmiInputStaffHlbEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffHlbEntity> hmiHlb  = hmiInputStaffHlbService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiHlb);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffHlbEntity hmistaffHlb ) {
        try {
            HmiInputStaffHlbEntity hlE = new HmiInputStaffHlbEntity();
            hlE.setYear(hmistaffHlb.getYear());
            hlE.setMonth(hmistaffHlb.getMonth());
            List<HmiInputStaffHlbEntity> select = hmiInputStaffHlbService.select(hlE);
            if(select.size()>0 && StringUtil.isEmpty(hmistaffHlb.getId())) return ResultUtil.error("当前年度月份数据重复填写！");

            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmistaffHlb.getYear());
            check.setMonth(hmistaffHlb.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmistaffHlb.getId())){
                hmiInputStaffHlbService.insert(hmistaffHlb);
                List<HmiInputBqhsEntity> ksInfo = hmistaffHlb.getKsInfo();
                ksInfo.forEach(e -> {
                    e.setYear(hmistaffHlb.getYear());
                    e.setMonth(hmistaffHlb.getMonth());
                    e.setNurid(hmistaffHlb.getId());
                    hmiInputStaffYqhsService.insert(e);
                });
            }else{
                hmiInputStaffHlbService.update(hmistaffHlb);
                List<HmiInputBqhsEntity> ksInfo = hmistaffHlb.getKsInfo();
                ksInfo.forEach(e -> {
                    e.setYear(hmistaffHlb.getYear());
                    e.setMonth(hmistaffHlb.getMonth());
                    hmiInputStaffYqhsService.update(e);
                });
            }

            //保存完成之后 同步审核表种的部分数据
            check.setCcuhs_hl(hmistaffHlb.getCcuhs());
            check.setIcuhs_hl(hmistaffHlb.getIcuhs());
            check.setNicuhs_hl(hmistaffHlb.getNicuhs());
            check.setRicuhs_hl(hmistaffHlb.getRicuhs());
            check.setJzgdhs_hl(hmistaffHlb.getJzgdhs());
            check.setJzzghs_hl(hmistaffHlb.getJzzghs());
            check.setGrgdhs_hl(hmistaffHlb.getGrgdhs());
            check.setGrzghs_hl(hmistaffHlb.getGrzghs());
            check.setKfhs_hl(hmistaffHlb.getKfhs());
            check.setZyhs_hl(hmistaffHlb.getZyhs());
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



    @ApiOperation(value = "打开修改界面")
    @GetMapping("/toUpdateBqhs")
    public ResultUtil toUpdate(@RequestParam(value = "id",required = true) String id) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffHlbEntity hlE  = hmiInputStaffHlbService.findById(id);
            HmiInputBqhsEntity bqhs = new HmiInputBqhsEntity();
            bqhs.setNurid(hlE.getId());
            List<HmiInputBqhsEntity> ksInfo = hmiInputStaffYqhsService.select(bqhs);
            ksInfo = ksInfo.stream().sorted(Comparator.comparing(HmiInputBqhsEntity::getHsrs)).
                    collect(Collectors.toList());
            hlE.setKsInfo(ksInfo);
            return ResultUtil.success ( hlE );

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/delById")
    public ResultUtil delColumnById(@RequestParam(value = "id",required = true) String id ) {
        try {
            hmiInputStaffHlbService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
