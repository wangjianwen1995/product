//package com.sxdl.base.controller;
//
//
//import com.github.pagehelper.PageInfo;
//import com.sxdl.base.entity.SysDept;
//import com.sxdl.base.service.SysDeptService;
//import com.sxdl.base.util.ResultUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Api(tags = "dept")
//@RestController
//@RequestMapping("/sysDept")
//public class SysDeptController {
//
//    @Autowired
//    private SysDeptService sysDeptService;
//
//    @ApiOperation(value = "根据dept的id获取详细内容", notes = "根据dept的id获取详细内容")
//    @GetMapping("/findBySysDeptId")
//    @ResponseBody
//    public ResultUtil findBySysDeptId(PageInfo pageInfo, @RequestParam(value = "id",required = true) Integer id) {
//
//        SysDept sysDept = new SysDept();
//        sysDept.setId ( id );
//
//        try {
//            PageInfo<List<SysDept>> list = sysDeptService.queryPageList(pageInfo,sysDept);
//            return ResultUtil.success (list);
//        } catch (Exception e) {
//            return ResultUtil.error ( e.getMessage () );
//        }
//    }
//
//    @ApiOperation(value = "保存修改", notes = "保存用户角色信息")
//    @PostMapping("/save")
//    @ResponseBody
//    public ResultUtil insert(@RequestBody SysDept sysDept ) {
//        if (sysDept == null) {
//            return ResultUtil.error ( "没有数据要保存" );
//        }
//        try {
//            Integer id=sysDept.getId();
//            if("".equals(id) || null==id){
//                sysDeptService.insert(sysDept);
//            }else{
//                sysDeptService.update(sysDept);
//            }
//            return  ResultUtil.success("操作成功");
//        } catch (Exception e) {
//            return ResultUtil.error ( "保存失败" );
//        }
//    }
//
//
//    @ApiOperation(value="删除",notes="删除")
//    @DeleteMapping("/delete")
//    @ResponseBody
//    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
//        try{
//            sysDeptService.deleteById(id);
//            return ResultUtil.success("删除成功");
//        }catch (Exception e){
//            return ResultUtil.error(e.getMessage());
//        }
//
//    }
//}
