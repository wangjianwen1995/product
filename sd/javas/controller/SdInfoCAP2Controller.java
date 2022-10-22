package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCAP2;
import com.sxdl.sd.service.SdInfoCAP2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCAP2信息")
@RestController
@RequestMapping( "/SdInfoCAP2")
public class SdInfoCAP2Controller{

// 新增单病种

 @Autowired
 private SdInfoCAP2Service  sdInfoCAP2Service;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCAP2信息")
@PostMapping( "/insertSdInfoCAP2")

public ResultUtil insertSdInfoCAP2(@RequestBody  SdInfoCAP2 sdInfoCAP2){

if(sdInfoCAP2==null){

 return ResultUtil.error ("没有SdInfoCAP2数据需要保存"  );}
try {

sdInfoCAP2Service.insert ( sdInfoCAP2 );
 return ResultUtil.success ("SdInfoCAP2数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCAP2 信息")
@PutMapping( "/updateSdInfoCAP2")

public ResultUtil updateSdInfoCAP2(@RequestBody  SdInfoCAP2 sdInfoCAP2){

if(sdInfoCAP2==null){

 return ResultUtil.error ("没有SdInfoCAP2数据需要修改"  );}
try {

sdInfoCAP2Service.update ( sdInfoCAP2 );
 return ResultUtil.success ("SdInfoCAP2数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCAP2  byId = sdInfoCAP2Service.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}