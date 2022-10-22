package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoOIT;
import com.sxdl.sd.service.SdInfoOITService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoOIT信息")
@RestController
@RequestMapping( "/SdInfoOIT")
public class SdInfoOITController{

// 新增单病种

 @Autowired
 private SdInfoOITService  sdInfoOITService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoOIT信息")
@PostMapping( "/insertSdInfoOIT")

public ResultUtil insertSdInfoOIT(@RequestBody  SdInfoOIT sdInfoOIT){

if(sdInfoOIT==null){

 return ResultUtil.error ("没有SdInfoOIT数据需要保存"  );}
try {

sdInfoOITService.insert ( sdInfoOIT );
 return ResultUtil.success ("SdInfoOIT数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoOIT 信息")
@PutMapping( "/updateSdInfoOIT")

public ResultUtil updateSdInfoOIT(@RequestBody  SdInfoOIT sdInfoOIT){

if(sdInfoOIT==null){

 return ResultUtil.error ("没有SdInfoOIT数据需要修改"  );}
try {

sdInfoOITService.update ( sdInfoOIT );
 return ResultUtil.success ("SdInfoOIT数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoOIT  byId = sdInfoOITService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}