package com.sxdl.product.dc.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.HpBzdmkEntity;
import com.sxdl.product.dc.service.HpBzdmkService;
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

    @ApiOperation(value = "查询疾病编码", notes = "查询疾病编码包括:疾病,病理,中医,损伤")
    @GetMapping("/findICD")
    public ResultUtil findICD(String type, String name, String version) throws Exception {
        return hpBzdmkService.getDmkInfos(type, name, version);
    }


}
