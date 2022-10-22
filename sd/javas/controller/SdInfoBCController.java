package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoBC;
import com.sxdl.sd.service.SdInfoBCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoBC信息")
@RestController
@RequestMapping( "/SdInfoBC")
public class SdInfoBCController{

// 新增单病种

 @Autowired
 private SdInfoBCService  sdInfoBCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoBC信息")
@PostMapping( "/insertSdInfoBC")

public ResultUtil insertSdInfoBC(@RequestBody  SdInfoBC sdInfoBC){

if(sdInfoBC==null){

 return ResultUtil.error ("没有SdInfoBC数据需要保存"  );}
try {

sdInfoBCService.insert ( sdInfoBC );
 return ResultUtil.success ("SdInfoBC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoBC 信息")
@PutMapping( "/updateSdInfoBC")

public ResultUtil updateSdInfoBC(@RequestBody  SdInfoBC sdInfoBC){

if(sdInfoBC==null){

 return ResultUtil.error ("没有SdInfoBC数据需要修改"  );}
try {

sdInfoBCService.update ( sdInfoBC );
 return ResultUtil.success ("SdInfoBC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoBC  byId = sdInfoBCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}