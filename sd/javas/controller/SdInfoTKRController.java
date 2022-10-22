package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoTKR;
import com.sxdl.sd.service.SdInfoTKRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoTKR信息")
@RestController
@RequestMapping( "/SdInfoTKR")
public class SdInfoTKRController{

// 新增单病种

 @Autowired
 private SdInfoTKRService  sdInfoTKRService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoTKR信息")
@PostMapping( "/insertSdInfoTKR")

public ResultUtil insertSdInfoTKR(@RequestBody  SdInfoTKR sdInfoTKR){

if(sdInfoTKR==null){

 return ResultUtil.error ("没有SdInfoTKR数据需要保存"  );}
try {

sdInfoTKRService.insert ( sdInfoTKR );
 return ResultUtil.success ("SdInfoTKR数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoTKR 信息")
@PutMapping( "/updateSdInfoTKR")

public ResultUtil updateSdInfoTKR(@RequestBody  SdInfoTKR sdInfoTKR){

if(sdInfoTKR==null){

 return ResultUtil.error ("没有SdInfoTKR数据需要修改"  );}
try {

sdInfoTKRService.update ( sdInfoTKR );
 return ResultUtil.success ("SdInfoTKR数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoTKR  byId = sdInfoTKRService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}