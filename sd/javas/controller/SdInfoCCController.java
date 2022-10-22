package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCC;
import com.sxdl.sd.service.SdInfoCCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCC信息")
@RestController
@RequestMapping( "/SdInfoCC")
public class SdInfoCCController{

// 新增单病种

 @Autowired
 private SdInfoCCService  sdInfoCCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCC信息")
@PostMapping( "/insertSdInfoCC")

public ResultUtil insertSdInfoCC(@RequestBody  SdInfoCC sdInfoCC){

if(sdInfoCC==null){

 return ResultUtil.error ("没有SdInfoCC数据需要保存"  );}
try {

sdInfoCCService.insert ( sdInfoCC );
 return ResultUtil.success ("SdInfoCC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCC 信息")
@PutMapping( "/updateSdInfoCC")

public ResultUtil updateSdInfoCC(@RequestBody  SdInfoCC sdInfoCC){

if(sdInfoCC==null){

 return ResultUtil.error ("没有SdInfoCC数据需要修改"  );}
try {

sdInfoCCService.update ( sdInfoCC );
 return ResultUtil.success ("SdInfoCC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCC  byId = sdInfoCCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}