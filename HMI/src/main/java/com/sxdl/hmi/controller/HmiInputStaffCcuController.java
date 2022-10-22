package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCcuEntity;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.service.HmiInputStaffCcuService;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "CCU人员录入")
@RestController
@RequestMapping("/inputStaffCcu")
public class HmiInputStaffCcuController {

    @Autowired
    private HmiInputStaffCcuService hmiInputStaffCcuService;


    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;




    @ApiOperation(value = "查询已录入的人员信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffCcuEntity entity = new HmiInputStaffCcuEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffCcuEntity> hmiCcu  = hmiInputStaffCcuService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiCcu);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffCcuEntity hmiCcu ) {
        try {
            HmiInputStaffCcuEntity ex = new HmiInputStaffCcuEntity();
            ex.setYear(hmiCcu.getYear());
            ex.setMonth(hmiCcu.getMonth());
            List<HmiInputStaffCcuEntity> select = hmiInputStaffCcuService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiCcu.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiCcu.getYear());
            check.setMonth(hmiCcu.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiCcu.getId())){
                hmiInputStaffCcuService.insert(hmiCcu);
            }else{
                hmiInputStaffCcuService.update(hmiCcu);
            }

            //保存完成之后 同步审核表种的部分数据
            check.setCcuhs_zz(hmiCcu.getCcuhs());
            check.setCcuys_zz(hmiCcu.getCcuys());
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
            hmiInputStaffCcuService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
