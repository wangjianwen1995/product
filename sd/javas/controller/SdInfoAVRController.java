package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoAVR;
import com.sxdl.sd.service.SdInfoAVRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoAVR信息")
@RestController
@RequestMapping( "/SdInfoAVR")
public class SdInfoAVRController{

// 新增单病种

 @Autowired
 private SdInfoAVRService  sdInfoAVRService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoAVR信息")
@PostMapping( "/insertSdInfoAVR")

public ResultUtil insertSdInfoAVR(@RequestBody  SdInfoAVR sdInfoAVR){

if(sdInfoAVR==null){

 return ResultUtil.error ("没有SdInfoAVR数据需要保存"  );}
try {

sdInfoAVRService.insert ( sdInfoAVR );
 return ResultUtil.success ("SdInfoAVR数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoAVR 信息")
@PutMapping( "/updateSdInfoAVR")

public ResultUtil updateSdInfoAVR(@RequestBody  SdInfoAVR sdInfoAVR){

if(sdInfoAVR==null){

 return ResultUtil.error ("没有SdInfoAVR数据需要修改"  );}
try {

sdInfoAVRService.update ( sdInfoAVR );
 return ResultUtil.success ("SdInfoAVR数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoAVR  byId = sdInfoAVRService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}