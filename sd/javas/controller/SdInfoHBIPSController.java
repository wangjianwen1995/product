package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoHBIPS;
import com.sxdl.sd.service.SdInfoHBIPSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoHBIPS信息")
@RestController
@RequestMapping( "/SdInfoHBIPS")
public class SdInfoHBIPSController{

// 新增单病种

 @Autowired
 private SdInfoHBIPSService  sdInfoHBIPSService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoHBIPS信息")
@PostMapping( "/insertSdInfoHBIPS")

public ResultUtil insertSdInfoHBIPS(@RequestBody  SdInfoHBIPS sdInfoHBIPS){

if(sdInfoHBIPS==null){

 return ResultUtil.error ("没有SdInfoHBIPS数据需要保存"  );}
try {

sdInfoHBIPSService.insert ( sdInfoHBIPS );
 return ResultUtil.success ("SdInfoHBIPS数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoHBIPS 信息")
@PutMapping( "/updateSdInfoHBIPS")

public ResultUtil updateSdInfoHBIPS(@RequestBody  SdInfoHBIPS sdInfoHBIPS){

if(sdInfoHBIPS==null){

 return ResultUtil.error ("没有SdInfoHBIPS数据需要修改"  );}
try {

sdInfoHBIPSService.update ( sdInfoHBIPS );
 return ResultUtil.success ("SdInfoHBIPS数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoHBIPS  byId = sdInfoHBIPSService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}