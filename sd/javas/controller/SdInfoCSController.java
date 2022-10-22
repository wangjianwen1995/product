package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCS;
import com.sxdl.sd.service.SdInfoCSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCS信息")
@RestController
@RequestMapping( "/SdInfoCS")
public class SdInfoCSController{

// 新增单病种

 @Autowired
 private SdInfoCSService  sdInfoCSService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCS信息")
@PostMapping( "/insertSdInfoCS")

public ResultUtil insertSdInfoCS(@RequestBody  SdInfoCS sdInfoCS){

if(sdInfoCS==null){

 return ResultUtil.error ("没有SdInfoCS数据需要保存"  );}
try {

sdInfoCSService.insert ( sdInfoCS );
 return ResultUtil.success ("SdInfoCS数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCS 信息")
@PutMapping( "/updateSdInfoCS")

public ResultUtil updateSdInfoCS(@RequestBody  SdInfoCS sdInfoCS){

if(sdInfoCS==null){

 return ResultUtil.error ("没有SdInfoCS数据需要修改"  );}
try {

sdInfoCSService.update ( sdInfoCS );
 return ResultUtil.success ("SdInfoCS数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCS  byId = sdInfoCSService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}