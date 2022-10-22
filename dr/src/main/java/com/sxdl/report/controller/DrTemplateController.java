package com.sxdl.report.controller;


import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.entity.ConfigBean;
import com.sxdl.report.entity.DrTable;
import com.sxdl.report.entity.DrTemplate;
import com.sxdl.report.service.DrTableService;
import com.sxdl.report.service.DrTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "上报模板维护")
@RestController
@RequestMapping("/template")
public class DrTemplateController {

    @Autowired
    private DrTemplateService drTemplateService;

    @Autowired
    DrTableService drTableService;



    @Autowired
    ConfigBean configBean;
    @ApiOperation(value = "查询项目", notes = "配置文件中查询所有项目")
    @GetMapping("/findAllPorduct")
    public ResultUtil findAllPorduct() {
        try {
            return ResultUtil.success (JSONUtil.parseObj(configBean.toString()),"success");
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }





    @ApiOperation(value = "查询", notes = "查询所有模板信息")
    @GetMapping("/findAlldate")
    public ResultUtil  findAlldate() {
        try {
            DrTemplate template = new DrTemplate();
            List<DrTemplate> select = drTemplateService.select(template);
            return ResultUtil.success ( select );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    @ApiOperation(value = "查询", notes = "查询所有模板信息")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DrTemplate>> findAll(PageInfo pageInfo) {
        try {
            DrTemplate template = new DrTemplate();
            PageInfo<DrTemplate> list =drTemplateService.queryPageList(pageInfo,template);
            return ResultUtil.success ( list );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    @ApiOperation(value = "根据id获取模板", notes = "根据id获取模板")
    @GetMapping("/findById")
    public ResultUtil findById(@RequestParam(value = "id",required = true) Integer id) {
        try {
            DrTemplate byId = drTemplateService.findById(id);

            return ResultUtil.success (byId);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
    }


    @ApiOperation(value = "保存修改", notes = "保存修改接口信息")
    @PostMapping("/save")
    public ResultUtil insert(@RequestBody DrTemplate drTemplate) {
        if (drTemplate == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            String linkname="";
            if("3".equals(drTemplate.getTemplate_type())){ //单病种上报
                linkname="DRSD";
            }else {
                linkname="DRBA";
            }

            String issucc="";
            Integer id=drTemplate.getId();
            if("".equals(id) || null==id){//新增
                //判断是否有同名的数据库链接 1 有 2没有
                String drba = drTemplateService.linkIsExists(linkname);
                if("1".equals(drba)){
                    drTemplateService.insert(drTemplate);
                    return  ResultUtil.success("数据库链接已经存在,操作成功");
                }
                //重新创建数据库链接
                issucc = drTemplateService.creatLinkService(drTemplate);
                if("3".equals(issucc)){
                    return ResultUtil.error ( "保存失败，链接服务器创建失败！" );
                }else{
                    drTemplateService.insert(drTemplate);
                }
            }else{
                //修改页面
                DrTemplate oldTemp = drTemplateService.findById(id);
                boolean flag=false;
                if(!oldTemp.getDb_host().equals(drTemplate.getDb_host())
                        || !oldTemp.getDb_user().equals(drTemplate.getDb_user())
                        || !oldTemp.getDb_name().equals(drTemplate.getDb_name())
                        || !oldTemp.getDb_password().equals(drTemplate.getDb_password())
                ){
                    flag=true;
                }
                if(flag) {
                    //删除链接服务器
                    drTemplateService.delLinkService(linkname);
                    //重新创建数据库链接
                    issucc =drTemplateService.creatLinkService(drTemplate);

                }
                if("3".equals(issucc)){
                    //TODO   这里要不要返回....
                    drTemplateService.update(drTemplate);
                    ResultUtil.error ( "模板保存成功，但链接服务器创建失败，请检查链接服务器！" );
                }else{
                    drTemplateService.update(drTemplate);
                }
            }
            return  ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败:"+e.getMessage() );
        }
    }


    @ApiOperation(value="删除模板",notes="删除模板")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id",required = true) Integer id ){
        try{
            DrTable drTable = new DrTable();
            drTable.setTemplate_id(id);
            List<DrTable> select = drTableService.select(drTable);
            if(select.size()>0){
                return  ResultUtil.error("该模板下有表不允许删除");
            }else {
                drTemplateService.deleteById(id);
            }
            return ResultUtil.success("删除成功");
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }

    }





}
