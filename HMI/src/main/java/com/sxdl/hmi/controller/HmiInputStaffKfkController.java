package com.sxdl.hmi.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hmi.entity.HmiInputStaffCheckEntity;
import com.sxdl.hmi.entity.HmiInputStaffKfkEntity;
import com.sxdl.hmi.service.HmiInputStaffCheckService;
import com.sxdl.hmi.service.HmiInputStaffKfkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "康复科人员录入")
@RestController
@RequestMapping("/inputStaffKfk")
public class HmiInputStaffKfkController {

    @Autowired
    private HmiInputStaffKfkService hmiInputStaffKfkService;

    @Autowired
    private HmiInputStaffCheckService hmiInputStaffCheckService;


    @ApiOperation(value = "查询所有信息")
    @GetMapping("/findAll")
    public ResultUtil findColumnsByHeader(PageInfo pageInfo,Integer year,Integer month) {
        Map<String, Object> listPage = null;
        try {
            HmiInputStaffKfkEntity entity = new HmiInputStaffKfkEntity();
            entity.setYear(year);
            entity.setMonth(month);
            List<HmiInputStaffKfkEntity> hmiKfk  = hmiInputStaffKfkService.select(entity);
            listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), hmiKfk);

        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success(listPage);
    }



    @ApiOperation(value = "添加，修改")
    @PostMapping("/insertOrUpdate")
    public ResultUtil updateColumnAllProperties( @RequestBody HmiInputStaffKfkEntity hmiKfk ) {
        try {
            HmiInputStaffKfkEntity ex = new HmiInputStaffKfkEntity();
            ex.setYear(hmiKfk.getYear());
            ex.setMonth(hmiKfk.getMonth());
            List<HmiInputStaffKfkEntity> select = hmiInputStaffKfkService.select(ex);
            if(select.size()>0 && StringUtil.isEmpty(hmiKfk.getId()))   return ResultUtil.error("当前年度月份数据重复填写！");
            HmiInputStaffCheckEntity check = new HmiInputStaffCheckEntity();
            check.setYear(hmiKfk.getYear());
            check.setMonth(hmiKfk.getMonth());
            List<HmiInputStaffCheckEntity> ListSelect = hmiInputStaffCheckService.select(check);
            if(ListSelect.size()>0 && ListSelect.get(0).getStatus()==2) return ResultUtil.error("当前年度月份数据已审核，禁止修改！");

            if(StringUtil.isEmpty(hmiKfk.getId())){
                hmiInputStaffKfkService.insert(hmiKfk);
            }else{
                hmiInputStaffKfkService.update(hmiKfk);
            }

            //保存完成之后 同步审核表种的部分数据
            check.setKfhs_kf(hmiKfk.getKfhs());
            check.setKfs_kf(hmiKfk.getKfs());
            check.setKfys_kf(hmiKfk.getKfys());
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
            hmiInputStaffKfkService.deleteById(id);
        } catch (Exception e) {
            return  ResultUtil.error(e.getMessage());
        }
        return  ResultUtil.success("操作成功");
    }







}
