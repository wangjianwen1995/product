package com.sxdl.product.dc.controller;


import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.SysGroupKs;
import com.sxdl.product.dc.entity.SysKs;
import com.sxdl.product.dc.service.SysGroupKsService;
import com.sxdl.product.dc.service.SysKsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医院科室组管理")
@RestController
@RequestMapping("/sysGroupKs")
public class SysGroupKsController {

    @Autowired
    private SysGroupKsService sysGroupKsService;
    @Autowired
    private SysKsService sysKsService;

    @ApiOperation(value = "根据医院科室组id获取详细内容", notes = "根据医院科室组id获取详细内容")
    @GetMapping("/findBySysGroupKsId")
    @ResponseBody
    public ResultUtil findBySysGroupKsId(Integer id) {

        try {
            if (id != null && !id.equals("") && id > 0) {
                SysGroupKs sysGroupKs = sysGroupKsService.findById(id);
                return ResultUtil.success(sysGroupKs);
            }
            List<SysGroupKs> sysGroupKsList = sysGroupKsService.findAll();
            return ResultUtil.success(sysGroupKsList);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据医院科室组id获取详细内容", notes = "根据医院科室组id获取详细内容")
    @GetMapping("/findAllBySysGroupKs")
    @ResponseBody
    public ResultUtil findAllBySysGroupKs() {

        try {
            List<SysGroupKs> sysGroupKsList = sysGroupKsService.findAll();

            if (null == sysGroupKsList || sysGroupKsList.size() <= 0) {
                List<SysKs> sysKs = sysKsService.findAll();

                sysKs.forEach(e -> {
                    SysGroupKs sysGroupKs = new SysGroupKs();
                    sysGroupKs.setCode(e.getCode());
                    sysGroupKs.setName(e.getName());
                    /*sysGroupKs.setParent_name(e.getName());
                    sysGroupKs.setParent_code(e.getCode());*/
                    sysGroupKsList.add(sysGroupKs);
                });
            }
     /*       sysGroupKsList.stream().sorted
                    (Comparator.comparing(SysGroupKs::getParent_code, Comparator.nullsLast(String::compareTo)).reversed()).collect(Collectors.toList());
            //sysGroupKsList.sort(Comparator.comparing(SysGroupKs::getParent_code));
           // Map<String, List<SysGroupKs>> listMap = sysGroupKsList.stream().filter(e->null!=e && null!=e.getParent_code() && !"".equals(e.getParent_code())) .collect(Collectors.groupingBy(e -> e.getParent_code()));
*/
            return ResultUtil.success(sysGroupKsList);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存医院科室组信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysGroupKs sysGroupKs) {
        if (sysGroupKs == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            SysGroupKs sysGroupKs1 = new SysGroupKs();
            sysGroupKs1.setCode(sysGroupKs.getCode());
            List<SysGroupKs> groupKs = sysGroupKsService.select(sysGroupKs1);
            if (null == groupKs || groupKs.size() <= 0) {
                sysGroupKsService.insert(sysGroupKs);
            } else {
                return  ResultUtil.success("该code 已存在请更换代码");
            }

            /*Integer id=sysGroupKs.getId();
            if("".equals(id) || null==id){
                sysGroupKsService.insert(sysGroupKs);
            }else{
                sysGroupKsService.update(sysGroupKs);
            }*//*
            SysKs sysKs = new SysKs();

            sysGroupKs.forEach(e -> {
               *//* groupKs.setCode(e.getParent_code());
                SysGroupKs groupKs1 = sysGroupKsService.selectOne(groupKs);
                e.setParent_name(e.getName());*//*
                Integer id = e.getId();
                if ("".equals(id) || null == id) {
                    sysGroupKsService.insert(e);
                } else {
                    sysGroupKsService.update(e);
                }
                sysKs.setCode(e.getCode());
                sysKs.setName(e.getName());
                SysKs ks = sysKsService.selectOne(sysKs);
                if (null != ks) {
                    ks.setGroup_ks_id(e.getParent_code());
                    ks.setGroup_ks_name(e.getParent_name());
                    sysKsService.update(ks);
                }
            });*/
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败"+e.getCause());
        }
    }

    /*private SysGroupKs setParentName(SysGroupKs sysGroupKs) {
        SysKs sysks=new SysKs();
        if(null==sysGroupKs.getParent_code()|| "".equals(sysGroupKs.getParent_code())){

        }
        SysGroupKs groupKs = new SysGroupKs();
        groupKs.setCode(e.getParent_code());
        SysGroupKs groupKs1 = sysGroupKsService.selectOne(groupKs);
        groupKs1.setParent_name(e.getName());
        sysGroupKsService.update(groupKs1);
    }*/

    @ApiOperation(value = "删除医院科室组", notes = "删除医院科室组")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysGroupKs sysGroupKs) {
        try {
            List<SysGroupKs> sysGroupKsList = sysGroupKsService.select(sysGroupKs);
            if (sysGroupKsList == null || sysGroupKsList.size() <= 0) {
                return ResultUtil.error("医院科室组不存在");
            }
            SysKs sysKs = new SysKs();
            sysKs.setGroup_ks_id(sysGroupKs.getCode());
            List<SysKs> ksList = sysKsService.select(sysKs);
            if (ksList != null && ksList.size() > 0) {
                return ResultUtil.error("该医院科室组有绑定科室，删除失败");
            }
            sysGroupKsService.delete(sysGroupKs);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }

    }


}
