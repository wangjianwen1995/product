package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffJzkEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffJzkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "急诊科人员录入")
@RestController
@RequestMapping("/inputStaffJzk")
public class HmiInputStaffJzkController {

    @Autowired
    private HmiInputStaffJzkService hmiInputStaffJzkService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询所有已录入床位信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffJzkEntity entity = new HmiInputStaffJzkEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffJzkEntity> hmiJzk  = hmiInputStaffJzkService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiJzk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffJzkEntity hmiJzk ) {
        try {
            HmiInputStaffJzkEntity ex = new HmiInputStaffJzkEntity();
            ex.setYear(hmiJzk.getYear());
            ex.setMonth(hmiJzk.getMonth());
            List<HmiInputStaffJzkEntity> select = hmiInputStaffJzkService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiJzk.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiJzk.getYear());
            check.setMonth(hmiJzk.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiJzk.getId())){
                hmiInputStaffJzkService.insert(hmiJzk);
            }else{
                hmiInputStaffJzkService.update(hmiJzk);
            }

            //保存完成之后 同步审核表种的部分数据
            check.setJzgdhs_jz(hmiJzk.getJzgdhs());
            check.setJzgdys_jz(hmiJzk.getJzgdys());
            check.setJzzghs_jz(hmiJzk.getJzzghs());
            check.setJzzgys_jz(hmiJzk.getJzzgys());
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
            hmiInputStaffJzkService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
