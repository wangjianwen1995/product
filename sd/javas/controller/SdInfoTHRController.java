package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoTHR;
import com.sxdl.sd.service.SdInfoTHRService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoTHR信息")
@RestController
@RequestMapping( "/SdInfoTHR")
public class SdInfoTHRController{

// 新增单病种

 @Autowired
 private SdInfoTHRService  sdInfoTHRService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoTHR信息")
@PostMapping( "/insertSdInfoTHR")

public ResultUtil insertSdInfoTHR(@RequestBody  SdInfoTHR sdInfoTHR){

if(sdInfoTHR==null){

 return ResultUtil.error ("没有SdInfoTHR数据需要保存"  );}
try {

sdInfoTHRService.insert ( sdInfoTHR );
 return ResultUtil.success ("SdInfoTHR数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoTHR 信息")
@PutMapping( "/updateSdInfoTHR")

public ResultUtil updateSdInfoTHR(@RequestBody  SdInfoTHR sdInfoTHR){

if(sdInfoTHR==null){

 return ResultUtil.error ("没有SdInfoTHR数据需要修改"  );}
try {

sdInfoTHRService.update ( sdInfoTHR );
 return ResultUtil.success ("SdInfoTHR数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoTHR  byId = sdInfoTHRService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}