package com.sxdl.hp.controller;


import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.GetDataFromApp;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpBzdmkEntity;
import com.sxdl.hp.service.HpVsch0AService;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "病案基础模块")
@RestController
@RequestMapping("/hpBase")
public class HpBaseController {
    @Autowired
    HpVsch0AService hpVsch0AService;

    @ApiOperation(value = "根据条件查询字典表值信息")
    @GetMapping("/findByFactor")
    public ResultUtil findByfactor(@RequestParam(value = "dict_id", defaultValue = "") Integer dict_id) throws Exception {
        List<SysDictVal> dcDitVals = GetDataFromApp.findDcDitVals(dict_id);
        return ResultUtil.success(dcDitVals);
    }


    @ApiOperation(value = "查询病案首页字段相关字典表,在全字段设置中配置字段下拉框内容使用")
    @GetMapping("/findWebName")
    public ResultUtil findWebName() throws Exception {
        List<SysDictTable> dcDitTableList = (List<SysDictTable>) HpApplicationRunnerImpl.contextMap.get("dcDitTableList");
        //筛选调其他不用的字典                                   病案首页字典
        dcDitTableList = dcDitTableList.stream().filter(e -> "病案首页字典".equals(e.getSource_content())).collect(Collectors.toList());
        return ResultUtil.success(dcDitTableList);
    }


    @ApiOperation(value = "查询所有的ICD代码")
    @GetMapping("/findICDByType")
    public ResultUtil findICDByType(@RequestParam(value = "name", defaultValue = "") String name,
                                    @RequestParam(value = "type", required = true) String type) throws Exception {
        List<HpBzdmkEntity> collect = new ArrayList<>();
        //可以替换大部分空白字符， 不限于空格 ,并且转大写
        String str = name.replaceAll("\\s*", "").toUpperCase();

        if ("JBICD".equals(type)) {
            type = "0";
        } else if ("SSICD".equals(type)) {
            type = "1";
        } else if ("BLICD".equals(type)) {
            type = "3";
        } else if ("SHICD".equals(type)) {
            type = "2";
        } else if ("ZYICD".equals(type)) {
            type = "4";
        }
        return hpVsch0AService.getDmkInfos(type, name);
    }
}
