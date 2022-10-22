package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoALL;
import com.sxdl.sd.service.SdInfoALLService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoALL信息")
@RestController
@RequestMapping( "/SdInfoALL")
public class SdInfoALLController{

// 新增单病种

 @Autowired
 private SdInfoALLService  sdInfoALLService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoALL信息")
@PostMapping( "/insertSdInfoALL")

public ResultUtil insertSdInfoALL(@RequestBody  SdInfoALL sdInfoALL){

if(sdInfoALL==null){

 return ResultUtil.error ("没有SdInfoALL数据需要保存"  );}
try {

sdInfoALLService.insert ( sdInfoALL );
 return ResultUtil.success ("SdInfoALL数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoALL 信息")
@PutMapping( "/updateSdInfoALL")

public ResultUtil updateSdInfoALL(@RequestBody  SdInfoALL sdInfoALL){

if(sdInfoALL==null){

 return ResultUtil.error ("没有SdInfoALL数据需要修改"  );}
try {

sdInfoALLService.update ( sdInfoALL );
 return ResultUtil.success ("SdInfoALL数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoALL  byId = sdInfoALLService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}