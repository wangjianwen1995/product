package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoHF;
import com.sxdl.sd.service.SdInfoHFService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoHF信息")
@RestController
@RequestMapping( "/SdInfoHF")
public class SdInfoHFController{

// 新增单病种

 @Autowired
 private SdInfoHFService  sdInfoHFService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoHF信息")
@PostMapping( "/insertSdInfoHF")

public ResultUtil insertSdInfoHF(@RequestBody  SdInfoHF sdInfoHF){

if(sdInfoHF==null){

 return ResultUtil.error ("没有SdInfoHF数据需要保存"  );}
try {

sdInfoHFService.insert ( sdInfoHF );
 return ResultUtil.success ("SdInfoHF数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoHF 信息")
@PutMapping( "/updateSdInfoHF")

public ResultUtil updateSdInfoHF(@RequestBody  SdInfoHF sdInfoHF){

if(sdInfoHF==null){

 return ResultUtil.error ("没有SdInfoHF数据需要修改"  );}
try {

sdInfoHFService.update ( sdInfoHF );
 return ResultUtil.success ("SdInfoHF数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoHF  byId = sdInfoHFService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}