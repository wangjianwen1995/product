package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcEtlLog;
import com.sxdl.product.dc.service.DcEtlLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(tags = ("etl日志反馈"))
@RestController
@RequestMapping("/etlLog")
public class DcEtlLogController {
    @Autowired
    private DcEtlLogService dcEtlLogService;


    @ApiOperation(value = "抽取日志", notes = "新增成功")
    @PostMapping("/insert")
    @ResponseBody
    public ResultUtil insert(@RequestBody DcEtlLog log) {
        try {
            dcEtlLogService.insert(log);
        } catch (Exception e) {
            ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("新增成功");
    }

    //查询所有错误日志
    @ApiOperation(value = "查询", notes = "查询所有etl日志信息")
    @GetMapping("/findAll")
    public ResultUtil findByAll(PageInfo pageInfo, @RequestParam(value = "startTime", defaultValue = "") String startTime,
                                @RequestParam(value = "endTime", defaultValue = "") String endTime,
                                @RequestParam(value = "status", defaultValue = "0") Integer status,
                                @RequestParam(value = "productId", defaultValue = "") String productId,
                                @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            pageInfo = dcEtlLogService.selectBySome(pageInfo, startTime, endTime, status, productId, name);
            return ResultUtil.success(pageInfo, "查询错误日志成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }


    //修改etl日志信息
    @ApiOperation(value = "修改", notes = "修改etl日志信息")
    @PutMapping("/update")
    public ResultUtil<DcEtlLog> updateHospital(@RequestBody DcEtlLog dcEtlLog) {
        try {
            dcEtlLog.setUpdateTime(DateUtil.formatFromDate2(new Date()));
            dcEtlLogService.update(dcEtlLog);
            return ResultUtil.success("修改etl日志信息成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }


    @ApiOperation(value = "查询", notes = "查询所有etl日志信息")
    @GetMapping("/findLog")
    public ResultUtil findLog(@RequestParam(value = "productId", defaultValue = "") String productId) {
        try {
            List<Map<String,Object>> list = new ArrayList();
            List<Map<String,Object>> list2 = new ArrayList();

            String sql = "select CONVERT(varchar(100), convert(datetime,start_time), 23) start_time,MAX(status) status from dc_etl_log a,dc_schedule_config b\n" +
                    "where a.exec_id=b.Job_id and b.Product_id='"+productId+"'\n" +
                    "group by CONVERT(varchar(100), convert(datetime,start_time), 23)\n" +
                    "order by CONVERT(varchar(100), convert(datetime,start_time), 23) desc ";
            List<Map<String, Object>> maps = dcEtlLogService.selectSqlWithSQL(sql);


            for (Map m:maps) {
                Map<String,Object> mapFirst= new HashMap<>();
                mapFirst.put("time","日期："+m.get("start_time"));
                mapFirst.put("status",m.get("status"));
                sql="select batch ,MAX(status) status from dc_etl_log  \n" +
                    "where CONVERT(varchar(100), convert(datetime,start_time), 23)='"+m.get("start_time")+"'  \n" +
                    "group by batch \n" +
                    "order by batch";
                List<Map<String, Object>> maps1 = dcEtlLogService.selectSqlWithSQL(sql);
                list2 = new ArrayList();
                for (Map ma:maps1) {
                    Map<String,Object> mapSecond= new HashMap<>();
                    mapSecond.put("batch","批次："+ma.get("batch"));
                    mapSecond.put("status",ma.get("status"));
                    sql="select * from dc_etl_log \n" +
                            "where CONVERT(varchar(100), convert(datetime,start_time), 23)='"+m.get("start_time")+"'  \n" +
                            " and batch='"+ma.get("batch")+"'";
                    List<Map<String, Object>> maps2 = dcEtlLogService.selectSqlWithSQL(sql);
                    mapSecond.put("data",maps2);
                    list2.add(mapSecond);

                }
                mapFirst.put("data",list2);
                list.add(mapFirst);
            }


            return ResultUtil.success(list);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }


}
