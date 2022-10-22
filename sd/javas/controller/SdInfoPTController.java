package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoPT;
import com.sxdl.sd.service.SdInfoPTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoPT信息")
@RestController
@RequestMapping( "/SdInfoPT")
public class SdInfoPTController{

// 新增单病种

 @Autowired
 private SdInfoPTService  sdInfoPTService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoPT信息")
@PostMapping( "/insertSdInfoPT")

public ResultUtil insertSdInfoPT(@RequestBody  SdInfoPT sdInfoPT){

if(sdInfoPT==null){

 return ResultUtil.error ("没有SdInfoPT数据需要保存"  );}
try {

sdInfoPTService.insert ( sdInfoPT );
 return ResultUtil.success ("SdInfoPT数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoPT 信息")
@PutMapping( "/updateSdInfoPT")

public ResultUtil updateSdInfoPT(@RequestBody  SdInfoPT sdInfoPT){

if(sdInfoPT==null){

 return ResultUtil.error ("没有SdInfoPT数据需要修改"  );}
try {

sdInfoPTService.update ( sdInfoPT );
 return ResultUtil.success ("SdInfoPT数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoPT  byId = sdInfoPTService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}