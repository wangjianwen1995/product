package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoTSCC;
import com.sxdl.sd.service.SdInfoTSCCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoTSCC信息")
@RestController
@RequestMapping( "/SdInfoTSCC")
public class SdInfoTSCCController{

// 新增单病种

 @Autowired
 private SdInfoTSCCService  sdInfoTSCCService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoTSCC信息")
@PostMapping( "/insertSdInfoTSCC")

public ResultUtil insertSdInfoTSCC(@RequestBody  SdInfoTSCC sdInfoTSCC){

if(sdInfoTSCC==null){

 return ResultUtil.error ("没有SdInfoTSCC数据需要保存"  );}
try {

sdInfoTSCCService.insert ( sdInfoTSCC );
 return ResultUtil.success ("SdInfoTSCC数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoTSCC 信息")
@PutMapping( "/updateSdInfoTSCC")

public ResultUtil updateSdInfoTSCC(@RequestBody  SdInfoTSCC sdInfoTSCC){

if(sdInfoTSCC==null){

 return ResultUtil.error ("没有SdInfoTSCC数据需要修改"  );}
try {

sdInfoTSCCService.update ( sdInfoTSCC );
 return ResultUtil.success ("SdInfoTSCC数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoTSCC  byId = sdInfoTSCCService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}