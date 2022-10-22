package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoESRD-PD;
import com.sxdl.sd.service.SdInfoESRD-PDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoESRD-PD信息")
@RestController
@RequestMapping( "/SdInfoESRD-PD")
public class SdInfoESRD-PDController{

// 新增单病种

 @Autowired
 private SdInfoESRD-PDService  sdInfoESRD-PDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoESRD-PD信息")
@PostMapping( "/insertSdInfoESRD-PD")

public ResultUtil insertSdInfoESRD-PD(@RequestBody  SdInfoESRD-PD sdInfoESRD-PD){

if(sdInfoESRD-PD==null){

 return ResultUtil.error ("没有SdInfoESRD-PD数据需要保存"  );}
try {

sdInfoESRD-PDService.insert ( sdInfoESRD-PD );
 return ResultUtil.success ("SdInfoESRD-PD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoESRD-PD 信息")
@PutMapping( "/updateSdInfoESRD-PD")

public ResultUtil updateSdInfoESRD-PD(@RequestBody  SdInfoESRD-PD sdInfoESRD-PD){

if(sdInfoESRD-PD==null){

 return ResultUtil.error ("没有SdInfoESRD-PD数据需要修改"  );}
try {

sdInfoESRD-PDService.update ( sdInfoESRD-PD );
 return ResultUtil.success ("SdInfoESRD-PD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoESRD-PD  byId = sdInfoESRD-PDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}