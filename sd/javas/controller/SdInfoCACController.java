package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCAC;
import com.sxdl.sd.service.SdInfoCACService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCAC信息")
@RestController
@RequestMapping( "/SdInfoCAC")
public class SdInfoCACController{

// 新增单病种

 @Autowired
 private SdInfoCACService  sdInfoCACService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCAC信息")
@PostMapping( "/insertSdInfoCAC")

public ResultUtil insertSdInfoCAC(@RequestBody  SdInfoCAC sdInfoCAC){

if(sdInfoCAC==null){

 return ResultUtil.error ("没有SdInfoCAC数据需要保存"  );}
try {

sdInfoCACService.insert ( sdInfoCAC );
 return ResultUtil.success ("SdInfoCAC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCAC 信息")
@PutMapping( "/updateSdInfoCAC")

public ResultUtil updateSdInfoCAC(@RequestBody  SdInfoCAC sdInfoCAC){

if(sdInfoCAC==null){

 return ResultUtil.error ("没有SdInfoCAC数据需要修改"  );}
try {

sdInfoCACService.update ( sdInfoCAC );
 return ResultUtil.success ("SdInfoCAC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCAC  byId = sdInfoCACService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}