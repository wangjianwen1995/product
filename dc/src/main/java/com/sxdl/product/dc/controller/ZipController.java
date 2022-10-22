package com.sxdl.product.dc.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.HpAreaZip;
import com.sxdl.product.dc.service.ZipService;
import com.sxdl.product.dc.util.DcApplicationRunnerImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zip")
public class ZipController {

    @Autowired
    private ZipService zipService;

    @ApiOperation(value = "查询所有省份信息不包含外籍")
    @GetMapping("/findAllProvince")
    public ResultUtil findAllProvince() throws Exception {
        List<HpAreaZip> collect = new ArrayList<>();
        //http://127.0.0.1:23305/zip/findAllProvince
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        collect = areaZipList.stream().filter(e -> "2".equals(e.getGrade().toString())).collect(Collectors.toList());
        return ResultUtil.success(collect);
    }

    @ApiOperation(value = "查询省份下面所有->市级信息")
    @GetMapping("/findCityByProId")
    public ResultUtil findCityByProId(@RequestParam(value = "parent_code", required = true) String parent_code) throws Exception {
//            List<HpAreaZip> areaZipList = (List<HpAreaZip>)HpApplicationRunnerImpl.contextMap.get("areaZip");
//            list = areaZipList.stream().filter(e -> "3".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        List<HpAreaZip> areaZipList = zipService.findCityByProId(parent_code);
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "查询市级下面所有->县级信息")
    @GetMapping("/findCountyByCityId")
    public ResultUtil findCountyByCityId(@RequestParam(value = "parent_code", required = true) String parent_code) throws Exception {
//        List<HpAreaZip> list = new ArrayList<>();
//            List<HpAreaZip> areaZipList = (List<HpAreaZip>)HpApplicationRunnerImpl.contextMap.get("areaZip");
//            list = areaZipList.stream().filter(e -> "4".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        List<HpAreaZip> areaZipList = zipService.findCountyByCityId(parent_code);
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "查询县级下面所有->乡镇信息")
    @GetMapping("/findTownByCouId")
    public ResultUtil findTownByCouId(@RequestParam(value = "parent_code", required = true) String parent_code) throws Exception {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        areaZipList = areaZipList.stream().filter(e -> "5".equals(e.getGrade().toString()) && parent_code.equals(e.getParent_code())).collect(Collectors.toList());
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "根据省code查询省份信息")
    @GetMapping("/findProvinceByCode")
    public ResultUtil findProvinceByCode(@RequestParam(value = "code", required = true) String code) throws Exception {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        areaZipList = areaZipList.stream().filter(e -> "2".equals(e.getGrade().toString()) && code.equals(e.getCode())).collect(Collectors.toList());
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "根据市code查询市级信息")
    @GetMapping("/findCountyByCode")
    public ResultUtil findCountyByCode(@RequestParam(value = "code", required = true) String code) throws Exception {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        areaZipList = areaZipList.stream().filter(e -> "4".equals(e.getGrade().toString()) && code.equals(e.getCode())).collect(Collectors.toList());
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "根据乡镇code查询乡镇信息")
    @GetMapping("/findTownByCode")
    public ResultUtil findTownByCode(@RequestParam(value = "code", required = true) String code) throws Exception {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        areaZipList = areaZipList.stream().filter(e -> "5".equals(e.getGrade().toString()) && code.equals(e.getCode())).collect(Collectors.toList());
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "根据县code查询县级信息")
    @GetMapping("/findCityByCode")
    public ResultUtil findCityByCode(@RequestParam(value = "code", required = true) String code) throws Exception {
        List<HpAreaZip> areaZipList = (List<HpAreaZip>) DcApplicationRunnerImpl.contextMap.get("areaZip");
        areaZipList = areaZipList.stream().filter(e -> "3".equals(e.getGrade().toString()) && code.equals(e.getShi_code())).collect(Collectors.toList());
        return ResultUtil.success(areaZipList);
    }

    @ApiOperation(value = "修改添加数据")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody HpAreaZip hpAreaZip) throws Exception {
        zipService.save(hpAreaZip);
        return ResultUtil.success("操作成功");
    }

    @ApiOperation(value = "修改状态")
    @PostMapping("/updateState")
    public ResultUtil updateState(@RequestParam(value = "id", required = true) Integer id,
                                  @RequestParam(value = "isoff", required = true) Integer isoff) throws Exception {
        zipService.updateState(id, isoff);
        return ResultUtil.success("操作成功");
    }
}
