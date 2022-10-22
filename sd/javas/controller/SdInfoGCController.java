package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoGC;
import com.sxdl.sd.service.SdInfoGCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoGC信息")
@RestController
@RequestMapping( "/SdInfoGC")
public class SdInfoGCController{

// 新增单病种

 @Autowired
 private SdInfoGCService  sdInfoGCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoGC信息")
@PostMapping( "/insertSdInfoGC")

public ResultUtil insertSdInfoGC(@RequestBody  SdInfoGC sdInfoGC){

if(sdInfoGC==null){

 return ResultUtil.error ("没有SdInfoGC数据需要保存"  );}
try {

sdInfoGCService.insert ( sdInfoGC );
 return ResultUtil.success ("SdInfoGC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoGC 信息")
@PutMapping( "/updateSdInfoGC")

public ResultUtil updateSdInfoGC(@RequestBody  SdInfoGC sdInfoGC){

if(sdInfoGC==null){

 return ResultUtil.error ("没有SdInfoGC数据需要修改"  );}
try {

sdInfoGCService.update ( sdInfoGC );
 return ResultUtil.success ("SdInfoGC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoGC  byId = sdInfoGCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}