package com.sxdl.base.controller;

import com.github.pagehelper.PageInfo;
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


@Api(tags = "字典表数据信息")
@RestController
@RequestMapping("/dv")
public class SysDictValController {
 /*   @Autowired
    private DcTransferService dcTransferService;

*/

    @Autowired
    private SysDictValService dcDitValService;
    @Autowired
    private SysDictTableService dcDitTableService;

    //根据表名查询字典表值信息
    @ApiOperation(value = "查询", notes = "根据条件查询字典表值信息")
    @GetMapping("/findByFactor")
    public ResultUtil findByfactor(PageInfo pageInfo, @RequestParam(value = "dict_id", defaultValue = "") Integer dict_id) {
        try {
            //System.out.println ( pageInfo );
            List<SysDictVal> dcDitVals = GetDataFromApp.findDcDitVals ( dict_id );
            if (pageInfo == null || pageInfo.getPageNum ()==0||pageInfo.getPageSize ()==0) {
                return ResultUtil.success ( dcDitVals );
            }
            Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), dcDitVals );
            return ResultUtil.success ( listPage );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }



    @ApiOperation(value = "新增", notes = "新增字典表")
    @PostMapping("/insert")
    public ResultUtil<SysDictVal> insertLink(@RequestBody SysDictVal dcDitVal) {
        try {
            //DcDitTable dcDitTable = dcDitTableService.findById ( dcDitVal.getDict_id () );
            List<SysDictVal> dcDitVals = GetDataFromApp.findDcDitVals ( dcDitVal.getDict_id () );
            if(dcDitVals!= null && dcDitVals.size ()>0){
                List<SysDictVal> dcDitValList = dcDitVals.stream ().filter ( e -> null != e && (e.getName ().equals ( dcDitVal.getName () )
                        || (e.getDict_id ().equals ( dcDitVal.getDict_id () ) && e.getVal ().equals ( dcDitVal.getVal () ))) ).collect ( Collectors.toList () );
                if (dcDitVal == null) {
                    return ResultUtil.error ( "没有数据要保存" );
                } else if (dcDitValList.size () > 0) {
                    return ResultUtil.error ( "字典表值重复" );
                }
            }

            dcDitValService.insertDV ( dcDitVal );
            return ResultUtil.success ( "新增字典表成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "修改", notes = "修改字典表")
    @PutMapping("/update")
    public ResultUtil<SysDictVal> updateLink(@RequestBody SysDictVal dcDitVal) {
        try {
            //System.out.println (dcDitVal);
            dcDitValService.updateByPrimaryKeySelective ( dcDitVal );
            return ResultUtil.success ( "修改字典表成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

}