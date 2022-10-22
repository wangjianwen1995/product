package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCAC2;
import com.sxdl.sd.service.SdInfoCAC2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCAC2信息")
@RestController
@RequestMapping( "/SdInfoCAC2")
public class SdInfoCAC2Controller{

// 新增单病种

 @Autowired
 private SdInfoCAC2Service  sdInfoCAC2Service;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCAC2信息")
@PostMapping( "/insertSdInfoCAC2")

public ResultUtil insertSdInfoCAC2(@RequestBody  SdInfoCAC2 sdInfoCAC2){

if(sdInfoCAC2==null){

 return ResultUtil.error ("没有SdInfoCAC2数据需要保存"  );}
try {

sdInfoCAC2Service.insert ( sdInfoCAC2 );
 return ResultUtil.success ("SdInfoCAC2数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCAC2 信息")
@PutMapping( "/updateSdInfoCAC2")

public ResultUtil updateSdInfoCAC2(@RequestBody  SdInfoCAC2 sdInfoCAC2){

if(sdInfoCAC2==null){

 return ResultUtil.error ("没有SdInfoCAC2数据需要修改"  );}
try {

sdInfoCAC2Service.update ( sdInfoCAC2 );
 return ResultUtil.success ("SdInfoCAC2数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCAC2  byId = sdInfoCAC2Service.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}