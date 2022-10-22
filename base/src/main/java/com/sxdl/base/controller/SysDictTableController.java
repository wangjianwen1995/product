package com.sxdl.base.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.service.SysDictTableService;
import com.sxdl.base.service.SysDictValService;
import com.sxdl.base.util.GetDataFromApp;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Api(tags = "字典表表名信息")
@RestController
@RequestMapping("/dt")
public class SysDictTableController {
    @Autowired
    private SysDictTableService dcDitTableService;
    @Autowired
    private SysDictValService dcDitValService;

    //查询所有字典表类型--分页
    @ApiOperation(value = "查询", notes = "查询字典表表名信息")
    @GetMapping("/findAll")
    public ResultUtil findAll(PageInfo pageInfo, String name ) {
        try {
            //拿缓存中的数据
            //List<DcDitTable> dcDitTableList = GetDataFromApp.findDcDitTables ();
            List<SysDictTable> dcDitTableList = GetDataFromApp.findDcDitTables ().stream ().filter ( e -> null != e && (e.getName ().contains ( name ) || e.getName_zh ().contains ( name )) ).collect ( Collectors.toList () );
            if (pageInfo == null || pageInfo.getPageNum ()==0||pageInfo.getPageSize ()==0) {
                return ResultUtil.success ( dcDitTableList );
            }
            //List<DcDitTable> dcDitTableList = GetDataFromApp.findDcDitTables ().stream ().filter ( e -> null != e && (e.getName ().equals ( dcDitTable.getName () ) || e.getName_zh ().contains ( dcDitTable.getName_zh () )) ).collect ( Collectors.toList () );
            Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), dcDitTableList );
            return ResultUtil.success ( listPage );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    //查询院内字典信息（病案系统中的临床路径名称，并发症名称以及医院感染名称字典的维护）
    @ApiOperation(value = "查询", notes = "查询字典表表名信息")
    @GetMapping("/findYnZd")
    public ResultUtil findYnZd() {
        try {
            List<SysDictTable> dcDitTableList = GetDataFromApp.findDcDitTables ().stream ().filter ( e -> null != e && e.getName().contains("yn_") ).collect ( Collectors.toList () );
            return ResultUtil.success ( dcDitTableList );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }



    //删除字典信息
    @ApiOperation(value = "删除", notes = "刪除字典表表名信息")
    @DeleteMapping("/delete")
    public ResultUtil deleteDT(@RequestBody SysDictTable dcDitTable) {
        try {
            /*Map<Integer, List<DcDitVal>> dvAllMap = (Map<Integer, List<DcDitVal>>) ApplicationRunnerImpl.contextMap.get ( "dvAllMap" );
            List<DcDitVal> dcDitVals = dvAllMap.get ( dcDitTable.getId () );*/
            List<SysDictVal> dcDitVals = GetDataFromApp.findDcDitVals (dcDitTable.getId ()  );
            if (dcDitVals != null && dcDitVals.size () > 0) {
                return ResultUtil.success ( dcDitTable.getName_zh () + "下有详细表数据不能删除" );
            }
            dcDitTableService.delete ( dcDitTable );
            dcDitTableService.updateAppDcDitTable ();
            return ResultUtil.success ( "刪除字典表表名信息成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "新增", notes = "新增字典表表名信息")
    @PostMapping("/insert")
    public ResultUtil insertDT(@RequestBody SysDictTable dcDitTable) {
        try {
            long count = GetDataFromApp.findDcDitTables ().stream ().filter ( e -> null != e && (e.getName ().equals ( dcDitTable.getName () ) ||
                    e.getName_zh ().equals ( dcDitTable.getName_zh () )) ).count ();
            if (count > 0) {
                return ResultUtil.success ( "本次录入的表名信息已存在，请更换" );
            }
            dcDitTableService.insertDT ( dcDitTable );
            //findDcDitTables().stream ().forEach (i-> System.out.println(i)  );
            return ResultUtil.success ( "新增字典表表名成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "修改", notes = "修改字典表表名信息")
    @PutMapping("/update")
    public ResultUtil updateDT(@RequestBody SysDictTable dcDitTable) {
        try {

            List<SysDictVal> dcDitVals = GetDataFromApp.findDcDitVals (dcDitTable.getId ()  );
            dcDitTableService.updateDT ( dcDitTable, dcDitVals );
            return ResultUtil.success ( "修改字典表表名信息成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


}