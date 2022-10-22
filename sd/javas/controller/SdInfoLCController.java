package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoLC;
import com.sxdl.sd.service.SdInfoLCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoLC信息")
@RestController
@RequestMapping( "/SdInfoLC")
public class SdInfoLCController{

// 新增单病种

 @Autowired
 private SdInfoLCService  sdInfoLCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoLC信息")
@PostMapping( "/insertSdInfoLC")

public ResultUtil insertSdInfoLC(@RequestBody  SdInfoLC sdInfoLC){

if(sdInfoLC==null){

 return ResultUtil.error ("没有SdInfoLC数据需要保存"  );}
try {

sdInfoLCService.insert ( sdInfoLC );
 return ResultUtil.success ("SdInfoLC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoLC 信息")
@PutMapping( "/updateSdInfoLC")

public ResultUtil updateSdInfoLC(@RequestBody  SdInfoLC sdInfoLC){

if(sdInfoLC==null){

 return ResultUtil.error ("没有SdInfoLC数据需要修改"  );}
try {

sdInfoLCService.update ( sdInfoLC );
 return ResultUtil.success ("SdInfoLC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoLC  byId = sdInfoLCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}