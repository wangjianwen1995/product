package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCAP;
import com.sxdl.sd.service.SdInfoCAPService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCAP信息")
@RestController
@RequestMapping( "/SdInfoCAP")
public class SdInfoCAPController{

// 新增单病种

 @Autowired
 private SdInfoCAPService  sdInfoCAPService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCAP信息")
@PostMapping( "/insertSdInfoCAP")

public ResultUtil insertSdInfoCAP(@RequestBody  SdInfoCAP sdInfoCAP){

if(sdInfoCAP==null){

 return ResultUtil.error ("没有SdInfoCAP数据需要保存"  );}
try {

sdInfoCAPService.insert ( sdInfoCAP );
 return ResultUtil.success ("SdInfoCAP数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCAP 信息")
@PutMapping( "/updateSdInfoCAP")

public ResultUtil updateSdInfoCAP(@RequestBody  SdInfoCAP sdInfoCAP){

if(sdInfoCAP==null){

 return ResultUtil.error ("没有SdInfoCAP数据需要修改"  );}
try {

sdInfoCAPService.update ( sdInfoCAP );
 return ResultUtil.success ("SdInfoCAP数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCAP  byId = sdInfoCAPService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}