package com.sxdl.product.dc.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.entity.DcHospital;
import com.sxdl.product.dc.service.DcHospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "医院信息")
@RestController
@RequestMapping("/hospital")
public class DcHospitalController {
    List<DcHospital> hospitals;
    @Autowired
    private DcHospitalService dcHospitalService;

    /*
    @ApiOperation  含义说明(value = “接口说明”, httpMethod = “接口请求方式”, response =
    “接口返回参数类型”, notes = “接口发布说明”；其他参数可参考源码；
     */
    //查询所有医院
    @ApiOperation(value = "查询", notes = "查询医院所有信息")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DcHospital>> findAll(PageInfo pageInfo) {
        try {
            //List<DcHospital> dcHospital = (List<DcHospital>) ApplicationRunnerImpl.contextMap.get ( "dcHospitals" );
            DcHospital hospital = new DcHospital();
            PageInfo<DcHospital> list = dcHospitalService.queryPageList(pageInfo, hospital);
            return ResultUtil.success(list);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //根据name模糊查询信息
    /*
    占位符映射
    语法：@RequestMapping(value=”user/{userId}/{userName}”)
     */
    @ApiOperation(value = "根据name查询", notes = "根据医院名称模糊查询")
    @GetMapping("/findByName")
    public ResultUtil<PageInfo<DcHospital>> findByName(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            //hospitals = dcHospitalDao.getByName("%"+name+"%");
           /* hospitals = (List<DcHospital>) ApplicationRunnerImpl.contextMap.get ( "dcHospitals" );
            List<DcHospital> collect = hospitals.stream ().filter ( e -> e.getName ().contains ( name ) ).collect ( Collectors.toList () );*/
            DcHospital hospital = new DcHospital();
            hospital.setName(name);
            PageInfo<DcHospital> list = dcHospitalService.queryPageList(pageInfo, hospital);
            return ResultUtil.success(list);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //删除医院信息
    @ApiOperation(value = "删除", notes = "删除医院信息")
    @DeleteMapping("/delete")
    public ResultUtil<DcHospital> delete(@RequestBody DcHospital dcHospital) {

        try {
            //dcHospitalDao.deleteByPrimaryKey ( id );
            //hospitals = dcHospitalDao.selectAll ();

            dcHospitalService.delete(dcHospital);
            return ResultUtil.success("删除医院成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "添加医院信息")
    @PostMapping("/insert")
    public ResultUtil<DcHospital> insertHospital(@RequestBody DcHospital dcHospital) {
        try {
            //dcHospitalDao.insert ( dcHospital );
            dcHospitalService.insert(dcHospital);
            return ResultUtil.success("添加医院成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "修改", notes = "添修改医院信息")
    @PutMapping("/update")
    public ResultUtil<DcHospital> updateHospital(@RequestBody DcHospital dcHospital) {
        try {
            //dcHospitalDao.updateByPrimaryKeySelective ( dcHospital );
            dcHospitalService.update(dcHospital);
            return ResultUtil.success("修改医院成功");
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

}
