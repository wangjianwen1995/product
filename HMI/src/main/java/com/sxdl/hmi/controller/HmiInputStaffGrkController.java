package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffGrkEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffGrkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "感染科人员录入")
@RestController
@RequestMapping("/inputStaffGrk")
public class HmiInputStaffGrkController {

    @Autowired
    private HmiInputStaffGrkService hmiInputStaffGrkService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询已录入的人员信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffGrkEntity entity = new HmiInputStaffGrkEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffGrkEntity> hmiGrk  = hmiInputStaffGrkService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiGrk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffGrkEntity hmiGrk ) {
        try {
            HmiInputStaffGrkEntity ex = new HmiInputStaffGrkEntity();
            ex.setYear(hmiGrk.getYear());
            ex.setMonth(hmiGrk.getMonth());
            List<HmiInputStaffGrkEntity> select = hmiInputStaffGrkService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiGrk.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiGrk.getYear());
            check.setMonth(hmiGrk.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiGrk.getId())){
                hmiInputStaffGrkService.insert(hmiGrk);
            }else{
                hmiInputStaffGrkService.update(hmiGrk);
            }

            //保存完成之后 同步审核表种的部分数据
            check.setGrgdhs_gr(hmiGrk.getGrgdhs());
            check.setGrgdys_gr(hmiGrk.getGrgdys());
            check.setGrzghs_gr(hmiGrk.getGrzghs());
            check.setGrzgys_gr(hmiGrk.getGrzgys());
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
            hmiInputStaffGrkService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
