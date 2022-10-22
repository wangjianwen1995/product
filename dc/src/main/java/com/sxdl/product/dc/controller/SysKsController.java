package com.sxdl.product.dc.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysUserVsKs;
import com.sxdl.base.service.SysUserVsKsService;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.entity.SysKs;
import com.sxdl.product.dc.service.SysGroupKsService;
import com.sxdl.product.dc.service.SysKsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Api(tags = "科室管理")
@RestController
@RequestMapping("/sysKs")
public class SysKsController {


    @Autowired
    private SysKsService sysKsService;
    @Autowired
    private SysUserVsKsService sysUserVsKsService;
    @Autowired
    private SysGroupKsService sysGroupKsService;

    @ApiOperation(value = "根据科室获取菜单内容", notes = "根据科室获取菜单内容")
    @GetMapping("/findByKsId")
    @ResponseBody
    public ResultUtil findByKsId(PageInfo pageInfo, String name,String type) throws Exception{

            //List<SysKs> sysKsList = sysKsService.findAll();
            List<SysKs> sysKsList =sysKsService.selectBySome(name,type);
            if (null != name) {
                sysKsList = sysKsList.stream().filter(e -> e != null && null != e.getName() && null != e.getCode() && (e.getName().contains(name) || e.getCode().equals(name))).collect(Collectors.toList());
            }
          /*  sysKsList.stream().sorted
                    (Comparator.comparing(SysKs::getIs_on, Comparator.nullsLast(Integer::compareTo))).collect(Collectors.toList());*/
            sysKsList.sort(Comparator.comparing(SysKs::getIs_on).reversed());
            if (pageInfo == null || pageInfo.getPageNum() == 0 || pageInfo.getPageSize() == 0) {
                return ResultUtil.success(sysKsList);
            }
            Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), sysKsList);
            return ResultUtil.success(listPage);
    }

    @ApiOperation(value = "保存", notes = "保存科室信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody SysKs sysKs) {
        if (sysKs == null) {
            return ResultUtil.error("没有数据要保存");
        }
        SysKs sysKs1 = new SysKs();
        sysKs1.setCode(sysKs.getCode());
        try {
            List<SysKs> sysKsList = sysKsService.select(sysKs1);
            if (sysKsList != null && sysKsList.size() > 0) {
                return ResultUtil.error("该科室代码已存在");
            }
            //新增科室默认启用
            sysKs.setIs_on(1);
            sysKsService.insert(sysKs);
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "修改", notes = "科室信息")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody SysKs sysKs) {
        if (sysKs == null) {
            return ResultUtil.error("没有数据要修改");
        }
        SysKs sysKs1 = new SysKs();
        sysKs1.setCode(sysKs.getCode());
        try {
            List<SysKs> sysKsList = sysKsService.select(sysKs1);
            if (sysKsList == null || sysKsList.size() <= 0) {
                return ResultUtil.error("该科室代码不存在");
            }
            sysKsService.update(sysKs);
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询住院科室信息", notes = "查询科室信息")
    @GetMapping("/findKs")
    public ResultUtil findKs() {
        try {
            SysKs ksEntity = new SysKs();
            ksEntity.setIs_id(1);
            List<SysKs> ksList = sysKsService.select(ksEntity);
            ksList.stream().sorted(Comparator.comparing(SysKs::getName));
            return ResultUtil.success(ksList);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查询所有科室信息", notes = "查询所有科室信息")
    @GetMapping("/findAllKs")
    public ResultUtil findAllKs() {
        try {
            return ResultUtil.success(sysKsService.findAll());
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除科室信息", notes = "删除科室")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestBody SysKs sysKs) {
        try {
            List<SysKs> sysKsList = sysKsService.select(sysKs);
            if (sysKsList == null || sysKsList.size() <= 0) {
                return ResultUtil.error("科室不存在");
            }
            SysUserVsKs sysUserVsKs = new SysUserVsKs();
            sysUserVsKs.setKs_id(sysKs.getCode());
            List<SysUserVsKs> userVsKs = sysUserVsKsService.select(sysUserVsKs);
            if (userVsKs != null && userVsKs.size() > 0) {
                return ResultUtil.error("已有用户绑定此科室，不能删除");
            }
            sysKsService.delete(sysKs);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }

    }


    @ApiOperation(value = "科室停用启用", notes = "科室停用启用")
    @GetMapping("/startOrStop")
    @ResponseBody
    public ResultUtil startOrStop(Integer ksId) {
        try {
            SysKs sysKs = sysKsService.selectByKey(ksId);
            if (null != sysKs.getIs_on() && sysKs.getIs_on() == 1) {
                sysKs.setIs_on(0);
            } else {
                sysKs.setIs_on(1);
            }
            sysKsService.update(sysKs);
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

   /* @ApiOperation(value = "根据科室获取菜单内容", notes = "根据科室获取菜单内容")
    @GetMapping("/findByKsId")
    @ResponseBody
    public ResultUtil tesr(List<SysKs> dcsKsList) {
        try {
            List<SysKs> sysKsList = sysKsService.findAll();
            SysGroupKs sysGroupKs = new SysGroupKs();
            for (SysKs sysks : sysKsList) {
                //根据sys 科室查询组科室
                sysGroupKs.setCode(sysks.getCode());
                sysGroupKs.setName(sysks.getName());
                SysGroupKs groupKs = sysGroupKsService.selectOne(sysGroupKs);
                for (SysKs dcks : dcsKsList) {
                    // code name 都相同的跳出此次循环
                    if (dcks.getCode().equals(sysks.getCode()) && dcks.getName().equals(sysks.getName())) {
                        continue;
                    }
                    // code 相同 name不同 更新sys 以及组科室  的科室name
                    if (dcks.getCode().equals(sysks.getCode()) && !dcks.getName().equals(sysks.getName())) {
                        sysks.setName(dcks.getName());
                        sysKsService.update(sysks);
                        groupKs.setName(dcks.getName());
                        sysGroupKsService.update(groupKs);
                    }
                    // code 不相同 name相同 更新sys 以及组科室  的科室code
                    if (!dcks.getCode().equals(sysks.getCode()) && dcks.getName().equals(sysks.getName())) {
                        sysks.setCode(dcks.getCode());
                        sysKsService.update(sysks);
                        groupKs.setCode(dcks.getCode());
                        sysGroupKsService.update(groupKs);
                    }
                }
            }

            return ResultUtil.success(null);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }
*/


    @ApiOperation(value = "获取启用的住院科室", notes = "获取启用的住院科室")
    @GetMapping("/findZyKs")
    @ResponseBody
    public ResultUtil findZyKs(String name) {
        try {
            SysKs sysKs = new SysKs();
            sysKs.setIs_on(1);
            sysKs.setIs_id(1);
            List<SysKs> sysKsList = sysKsService.select(sysKs);
            if (StringUtil.isNotEmpty(name)) {
                if (null != sysKsList && sysKsList.size() > 0) {
                    sysKsList = sysKsList.stream().filter(e -> null != e && null != e.getCode() && null != e.getName() && (e.getName().contains(name) || e.getCode().contains(name))).collect(Collectors.toList());
                }
            }
            return ResultUtil.success(sysKsList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }



    @ApiOperation(value = "通用查询日志中使用的科室列表方法", notes = "通用查询日志中使用的科室列表方法")
    @GetMapping("/findRzKsByType")
    @ResponseBody
    public List<Map<String,Object>> findRzKsByType(int type){
        //type 1 住院,2 门诊,3 急诊,4 观察室,5 医技,6 手术操作
        String kssql;
        String sql = "select code,name from sys_ks where @@@@=1 and is_on=1 order by  name desc";

        if(1==type){
            kssql=sql.replace("@@@@","is_id");
        }else if(2==type){
            kssql=sql.replace("@@@@","is_od");
        }else if(3==type){
            kssql=sql.replace("@@@@","is_ed");
        }else if(4==type){
            kssql=sql.replace("@@@@","is_gcs");
        }else if(5==type){
            kssql=sql.replace("@@@@","is_yj");
        }else if(6==type){
            kssql=sql.replace("@@@@","is_opr");
        }else{
            kssql=sql.replace("@@@@","1!");
        }

        return sysKsService.selectSqlWithSQL(kssql);
    }

}
