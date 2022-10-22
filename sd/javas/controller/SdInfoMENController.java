package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoMEN;
import com.sxdl.sd.service.SdInfoMENService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoMEN信息")
@RestController
@RequestMapping( "/SdInfoMEN")
public class SdInfoMENController{

// 新增单病种

 @Autowired
 private SdInfoMENService  sdInfoMENService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoMEN信息")
@PostMapping( "/insertSdInfoMEN")

public ResultUtil insertSdInfoMEN(@RequestBody  SdInfoMEN sdInfoMEN){

if(sdInfoMEN==null){

 return ResultUtil.error ("没有SdInfoMEN数据需要保存"  );}
try {

sdInfoMENService.insert ( sdInfoMEN );
 return ResultUtil.success ("SdInfoMEN数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoMEN 信息")
@PutMapping( "/updateSdInfoMEN")

public ResultUtil updateSdInfoMEN(@RequestBody  SdInfoMEN sdInfoMEN){

if(sdInfoMEN==null){

 return ResultUtil.error ("没有SdInfoMEN数据需要修改"  );}
try {

sdInfoMENService.update ( sdInfoMEN );
 return ResultUtil.success ("SdInfoMEN数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoMEN  byId = sdInfoMENService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}