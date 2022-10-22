package com.sxdl.hp.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.entity.HpBzdmkEntity;
import com.sxdl.hp.service.HpBzdmkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "标准代码库信息")
@RestController
@RequestMapping("/bzdm")
public class HpBzdmkController {


    @Autowired
    HpBzdmkService hpBzdmkService;
    List<HpBzdmkEntity> hpBzdmkEntityList;

    @ApiOperation(value = "查询不同分类的不同版本标准代码库")
    @GetMapping("/findBySome")
    public ResultUtil findBySome(PageInfo pageInfo, @RequestParam(value = "type", required = true) String type,
                                 @RequestParam(value = "version", required = true) String version) throws Exception {
        HpBzdmkEntity hpBzdmkEntity = new HpBzdmkEntity();
        hpBzdmkEntity.setType(type);
        hpBzdmkEntity.setVersion(version);
        PageInfo pageInfo1 = hpBzdmkService.queryPageList(pageInfo, hpBzdmkEntity);
        return ResultUtil.success(hpBzdmkEntityList);
    }

    @GetMapping("findIcdOrZybz")
    public ResultUtil findIcdOrZybz(String name, PageInfo p, String kind, String type) throws Exception {
        return hpBzdmkService.findIcdOrZybz(name, p, kind, type);
    }
}
