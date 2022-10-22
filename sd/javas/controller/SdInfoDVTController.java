package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoDVT;
import com.sxdl.sd.service.SdInfoDVTService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoDVT信息")
@RestController
@RequestMapping( "/SdInfoDVT")
public class SdInfoDVTController{

// 新增单病种

 @Autowired
 private SdInfoDVTService  sdInfoDVTService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoDVT信息")
@PostMapping( "/insertSdInfoDVT")

public ResultUtil insertSdInfoDVT(@RequestBody  SdInfoDVT sdInfoDVT){

if(sdInfoDVT==null){

 return ResultUtil.error ("没有SdInfoDVT数据需要保存"  );}
try {

sdInfoDVTService.insert ( sdInfoDVT );
 return ResultUtil.success ("SdInfoDVT数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoDVT 信息")
@PutMapping( "/updateSdInfoDVT")

public ResultUtil updateSdInfoDVT(@RequestBody  SdInfoDVT sdInfoDVT){

if(sdInfoDVT==null){

 return ResultUtil.error ("没有SdInfoDVT数据需要修改"  );}
try {

sdInfoDVTService.update ( sdInfoDVT );
 return ResultUtil.success ("SdInfoDVT数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoDVT  byId = sdInfoDVTService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}