package com.sxdl.hp.controller;


import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.entity.HpBmVersion;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.service.HpBmVersionService;
import com.sxdl.hp.service.HpBzdmkService;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "编码版本")
@RestController
@RequestMapping("/bmversion")
public class HpBmVersionController {


    @Autowired
    HpBmVersionService hpBmVersionService;
    PageInfo queryPageList;
    @Autowired
    HpBzdmkService bzdmkService;

    @ApiOperation(value = "根据状态查询编码版本")
    @GetMapping("/findByCondition")
    public ResultUtil findByCondition(PageInfo pageInfo, String type, String status) throws Exception {
        HpBmVersion hpBmVersion = new HpBmVersion();
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        hpBmVersion.setHid(hpHospiatlInfo.getId());
        if (!"".equals(type)) {
            hpBmVersion.setType(type);
        }
        if (!"".equals(status)) {
            hpBmVersion.setIson(status);
        }
        queryPageList = hpBmVersionService.queryPageList(pageInfo, hpBmVersion);
        return ResultUtil.success(queryPageList);
    }

    @ApiOperation(value = "切换编码版本")
    @GetMapping("/save")
    public ResultUtil save(HpBmVersion hpBmVersion, HttpServletRequest request) throws Exception {
        HpHospiatlInfo hpHospiatlInfo = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
        if (StringUtil.isEmpty(hpHospiatlInfo.getId())) {
            return ResultUtil.error("医院信息未维护，请先维护医院信息");
        }
        hpBmVersion.setHid(hpHospiatlInfo.getId());
        String id = hpBmVersion.getId();
        if (null == id || id.equals("")) {//插入
            hpBmVersionService.updateVersion(hpBmVersion);
        }else{//更新
            hpBmVersionService.update(hpBmVersion);
        }
        Map<String, String> bmversions=hpHospiatlInfo.getBmVersion();
        if(CollUtil.isEmpty(bmversions)){
            bmversions=new HashMap<>();
            hpHospiatlInfo.setBmVersion(bmversions);
        }
        bmversions.put(hpBmVersion.getType(), hpBmVersion.getVersion());
        HpApplicationRunnerImpl.contextMap.put("hpHospiatlInfo", hpHospiatlInfo);
        //将标准代码库插入到永久临时表中
        bzdmkService.initBiaozuns();
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "删除编码版本")
    @GetMapping("/delete")
    public ResultUtil delete(HpBmVersion hpBmVersion) throws Exception {
        hpBmVersionService.delete(hpBmVersion);
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "查找版本字典")
    @GetMapping("/findZd")
    public ResultUtil findZd() throws Exception {
        //查询首页的所有字段库信息
        Map<Integer, List<SysDictVal>> baBmMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
        return ResultUtil.success(baBmMap);
    }
}
