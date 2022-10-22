package com.sxdl.product.dc.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.TreeUtils;
import com.sxdl.product.dc.entity.SysStandardKs;
import com.sxdl.product.dc.service.SysKsService;
import com.sxdl.product.dc.service.SysStandardKsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "国家标准科目信息管理")
@RestController
@RequestMapping("/sysStandardKs")
public class SysStandardKsController {


    @Autowired
    private SysStandardKsService sysStandardKsService;
    @Autowired
    private SysKsService sysKsService;

    @ApiOperation(value = "查询所有国家标准科目信息", notes = "查询所有国家标准科目信息")
    @GetMapping("/findAllSysStandard")
    @ResponseBody
    public ResultUtil findAllSysStandard() {
        try {
             List<SysStandardKs> standardKsList = sysStandardKsService.findAll ();
            //List<SysStandardKs> standardKsList = (List<SysStandardKs>) ApplicationRunnerImpl.contextMap.get ( "standardKsList" );
            //函数式编程处理父子关系
            if(standardKsList!=null &&standardKsList.size ()>0){
                List<SysStandardKs> tree = TreeUtils.tree ( standardKsList, SysStandardKs::getId, SysStandardKs::getParent_code, SysStandardKs::getChildren,
                        SysStandardKs::setChildren, null );
                //System.out.println (tree);
                return ResultUtil.success ( tree );
            }
            return ResultUtil.success ( "暂无数据" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    @ApiOperation(value = "根据国家标准科目信息id获取详细内容", notes = "根据国家标准科目信息id获取详细内容")
    @GetMapping("/findBySysStandardKsId")
    @ResponseBody
    public ResultUtil findBySysStandardKsId(@RequestBody SysStandardKs sysStandardKs) {

        try {
            //List<SysStandardKs> standardKsList = (List<SysStandardKs>) ApplicationRunnerImpl.contextMap.get ( "sysStandardKsDao" );
            List<SysStandardKs> standardKsList = sysStandardKsService.findAll ();

            standardKsList=standardKsList.stream ().filter ( e -> e != null && e.getId ().equals ( sysStandardKs.getId () ) ).collect ( Collectors.toList () );

            return ResultUtil.success ( standardKsList );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }

  /*  @ApiOperation(value = "保存修改", notes = "保存国家标准科目信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysStandardKs sysStandardKs ) {
        if (sysStandardKs == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Integer id=sysStandardKs.getId();
            if("".equals(id) || null==id){
                sysStandardKsService.insert(sysStandardKs);
            }else{
                sysStandardKsService.update(sysStandardKs);
            }
            return  ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }


    @ApiOperation(value="删除国家标准科目",notes="删除国家标准科目")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysStandardKs sysStandardKs ){
        try{
            List<SysStandardKs> standardKs = sysStandardKsService.select ( sysStandardKs );
            if(standardKs==null&&standardKs.size ()<=0){
                return ResultUtil.error ( "该国家标准科目不存在" );
            }
            SysKs sysKs=new SysKs ();
            sysKs.setStandard_ks_id ( sysStandardKs.getId () );
            List<SysKs> ksList = sysKsService.select ( sysKs );
            if(ksList!=null&&ksList.size ()>0){
                return ResultUtil.error ( "该国家标准科目已对照科室，删除失败" );
            }
            sysStandardKsService.deleteById(sysStandardKs.getId ());
            return ResultUtil.success("删除成功");
        }catch (Exception e){
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }

    }
*/


}
