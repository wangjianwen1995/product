package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoPA;
import com.sxdl.sd.service.SdInfoPAService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoPA信息")
@RestController
@RequestMapping( "/SdInfoPA")
public class SdInfoPAController{

// 新增单病种

 @Autowired
 private SdInfoPAService  sdInfoPAService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoPA信息")
@PostMapping( "/insertSdInfoPA")

public ResultUtil insertSdInfoPA(@RequestBody  SdInfoPA sdInfoPA){

if(sdInfoPA==null){

 return ResultUtil.error ("没有SdInfoPA数据需要保存"  );}
try {

sdInfoPAService.insert ( sdInfoPA );
 return ResultUtil.success ("SdInfoPA数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoPA 信息")
@PutMapping( "/updateSdInfoPA")

public ResultUtil updateSdInfoPA(@RequestBody  SdInfoPA sdInfoPA){

if(sdInfoPA==null){

 return ResultUtil.error ("没有SdInfoPA数据需要修改"  );}
try {

sdInfoPAService.update ( sdInfoPA );
 return ResultUtil.success ("SdInfoPA数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoPA  byId = sdInfoPAService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}