package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoESRD-HD;
import com.sxdl.sd.service.SdInfoESRD-HDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoESRD-HD信息")
@RestController
@RequestMapping( "/SdInfoESRD-HD")
public class SdInfoESRD-HDController{

// 新增单病种

 @Autowired
 private SdInfoESRD-HDService  sdInfoESRD-HDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoESRD-HD信息")
@PostMapping( "/insertSdInfoESRD-HD")

public ResultUtil insertSdInfoESRD-HD(@RequestBody  SdInfoESRD-HD sdInfoESRD-HD){

if(sdInfoESRD-HD==null){

 return ResultUtil.error ("没有SdInfoESRD-HD数据需要保存"  );}
try {

sdInfoESRD-HDService.insert ( sdInfoESRD-HD );
 return ResultUtil.success ("SdInfoESRD-HD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoESRD-HD 信息")
@PutMapping( "/updateSdInfoESRD-HD")

public ResultUtil updateSdInfoESRD-HD(@RequestBody  SdInfoESRD-HD sdInfoESRD-HD){

if(sdInfoESRD-HD==null){

 return ResultUtil.error ("没有SdInfoESRD-HD数据需要修改"  );}
try {

sdInfoESRD-HDService.update ( sdInfoESRD-HD );
 return ResultUtil.success ("SdInfoESRD-HD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoESRD-HD  byId = sdInfoESRD-HDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}