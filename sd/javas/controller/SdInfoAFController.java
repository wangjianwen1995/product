package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoAF;
import com.sxdl.sd.service.SdInfoAFService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoAF信息")
@RestController
@RequestMapping( "/SdInfoAF")
public class SdInfoAFController{

// 新增单病种

 @Autowired
 private SdInfoAFService  sdInfoAFService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoAF信息")
@PostMapping( "/insertSdInfoAF")

public ResultUtil insertSdInfoAF(@RequestBody  SdInfoAF sdInfoAF){

if(sdInfoAF==null){

 return ResultUtil.error ("没有SdInfoAF数据需要保存"  );}
try {

sdInfoAFService.insert ( sdInfoAF );
 return ResultUtil.success ("SdInfoAF数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoAF 信息")
@PutMapping( "/updateSdInfoAF")

public ResultUtil updateSdInfoAF(@RequestBody  SdInfoAF sdInfoAF){

if(sdInfoAF==null){

 return ResultUtil.error ("没有SdInfoAF数据需要修改"  );}
try {

sdInfoAFService.update ( sdInfoAF );
 return ResultUtil.success ("SdInfoAF数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoAF  byId = sdInfoAFService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}