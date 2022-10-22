package com.sxdl.base.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysStaff;
import com.sxdl.base.service.SysStaffService;
import com.sxdl.base.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医院人员信息管理")
@RestController
@RequestMapping("/sysStaff")
public class SysStaffController {


    @Autowired
    private SysStaffService sysStaffService;

    @ApiOperation(value = "根据医院人员id,code获取人员详细内容", notes = "根据医院人员id,code获取人员详细内容")
    @GetMapping("/findByStaffId")
    @ResponseBody
    public ResultUtil findByStaffId(PageInfo pageInfo, Integer id,String code ) {

        SysStaff sysStaff = new SysStaff();
        if(id!= null && !id.equals ( "" ) && id >0){
            sysStaff.setId ( id );
        }
        if(code!= null && !code.equals ( "" ) ){
            sysStaff.setCode ( code );
        }

        try {
            PageInfo<List<SysStaff>> list = sysStaffService.queryPageList(pageInfo,sysStaff);
            return ResultUtil.success (list);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存菜单信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysStaff sysStaff ) {
        if (sysStaff == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=sysStaff.getId();
            if("".equals(id) || null==id){
                sysStaffService.insert(sysStaff);
            }else{
                sysStaffService.update(sysStaff);
            }
            return  ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }


    @ApiOperation(value="删除医院人员信息",notes="删除医院人员信息")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            sysStaffService.deleteById(id);
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
    }
}
