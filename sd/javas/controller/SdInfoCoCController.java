package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCoC;
import com.sxdl.sd.service.SdInfoCoCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCoC信息")
@RestController
@RequestMapping( "/SdInfoCoC")
public class SdInfoCoCController{

// 新增单病种

 @Autowired
 private SdInfoCoCService  sdInfoCoCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCoC信息")
@PostMapping( "/insertSdInfoCoC")

public ResultUtil insertSdInfoCoC(@RequestBody  SdInfoCoC sdInfoCoC){

if(sdInfoCoC==null){

 return ResultUtil.error ("没有SdInfoCoC数据需要保存"  );}
try {

sdInfoCoCService.insert ( sdInfoCoC );
 return ResultUtil.success ("SdInfoCoC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCoC 信息")
@PutMapping( "/updateSdInfoCoC")

public ResultUtil updateSdInfoCoC(@RequestBody  SdInfoCoC sdInfoCoC){

if(sdInfoCoC==null){

 return ResultUtil.error ("没有SdInfoCoC数据需要修改"  );}
try {

sdInfoCoCService.update ( sdInfoCoC );
 return ResultUtil.success ("SdInfoCoC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCoC  byId = sdInfoCoCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}