package com.sxdl.report.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.entity.DrColumn;
import com.sxdl.report.service.DrColumnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "表字段维护")
@RestController
@RequestMapping("/column")
public class DrColumnController {

    @Autowired
    private DrColumnService drColumnService;

    @ApiOperation(value = "根据表id获取字段", notes = "根据表id获取字段")
    @GetMapping("/findByTableId")
    @ResponseBody
    public ResultUtil findByTableId(PageInfo pageInfo,@RequestParam(value = "id",required = true) Integer id,
                                    @RequestParam(value = "columnName",required = false) String columnName ) {

        DrColumn column = new DrColumn();
        column.setTable_id(id);
        if(columnName!=null && !columnName.equals("")){
            column.setName(columnName);
        }
        try {
            PageInfo<List<DrColumn>> list = drColumnService.queryPageList(pageInfo,column);
            return ResultUtil.success (list);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }






    @ApiOperation(value = "保存修改", notes = "保存表信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody DrColumn column) {
        if (column == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=column.getId();
            if("".equals(id) || null==id){
                drColumnService.insert(column);
            }else{
                drColumnService.update(column);
            }
            return  ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }


    @ApiOperation(value="删除表字段",notes="删除表字段")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            //TODO 删除之前判断字段规则是否为空
            drColumnService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }


}
