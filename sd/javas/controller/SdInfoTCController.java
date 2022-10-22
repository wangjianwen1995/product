package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoTC;
import com.sxdl.sd.service.SdInfoTCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoTC信息")
@RestController
@RequestMapping( "/SdInfoTC")
public class SdInfoTCController{

// 新增单病种

 @Autowired
 private SdInfoTCService  sdInfoTCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoTC信息")
@PostMapping( "/insertSdInfoTC")

public ResultUtil insertSdInfoTC(@RequestBody  SdInfoTC sdInfoTC){

if(sdInfoTC==null){

 return ResultUtil.error ("没有SdInfoTC数据需要保存"  );}
try {

sdInfoTCService.insert ( sdInfoTC );
 return ResultUtil.success ("SdInfoTC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoTC 信息")
@PutMapping( "/updateSdInfoTC")

public ResultUtil updateSdInfoTC(@RequestBody  SdInfoTC sdInfoTC){

if(sdInfoTC==null){

 return ResultUtil.error ("没有SdInfoTC数据需要修改"  );}
try {

sdInfoTCService.update ( sdInfoTC );
 return ResultUtil.success ("SdInfoTC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoTC  byId = sdInfoTCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}