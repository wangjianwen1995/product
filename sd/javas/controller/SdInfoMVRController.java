package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoMVR;
import com.sxdl.sd.service.SdInfoMVRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoMVR信息")
@RestController
@RequestMapping( "/SdInfoMVR")
public class SdInfoMVRController{

// 新增单病种

 @Autowired
 private SdInfoMVRService  sdInfoMVRService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoMVR信息")
@PostMapping( "/insertSdInfoMVR")

public ResultUtil insertSdInfoMVR(@RequestBody  SdInfoMVR sdInfoMVR){

if(sdInfoMVR==null){

 return ResultUtil.error ("没有SdInfoMVR数据需要保存"  );}
try {

sdInfoMVRService.insert ( sdInfoMVR );
 return ResultUtil.success ("SdInfoMVR数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoMVR 信息")
@PutMapping( "/updateSdInfoMVR")

public ResultUtil updateSdInfoMVR(@RequestBody  SdInfoMVR sdInfoMVR){

if(sdInfoMVR==null){

 return ResultUtil.error ("没有SdInfoMVR数据需要修改"  );}
try {

sdInfoMVRService.update ( sdInfoMVR );
 return ResultUtil.success ("SdInfoMVR数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoMVR  byId = sdInfoMVRService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}