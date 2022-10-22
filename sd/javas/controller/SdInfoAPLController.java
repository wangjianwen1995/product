package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoAPL;
import com.sxdl.sd.service.SdInfoAPLService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoAPL信息")
@RestController
@RequestMapping( "/SdInfoAPL")
public class SdInfoAPLController{

// 新增单病种

 @Autowired
 private SdInfoAPLService  sdInfoAPLService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoAPL信息")
@PostMapping( "/insertSdInfoAPL")

public ResultUtil insertSdInfoAPL(@RequestBody  SdInfoAPL sdInfoAPL){

if(sdInfoAPL==null){

 return ResultUtil.error ("没有SdInfoAPL数据需要保存"  );}
try {

sdInfoAPLService.insert ( sdInfoAPL );
 return ResultUtil.success ("SdInfoAPL数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoAPL 信息")
@PutMapping( "/updateSdInfoAPL")

public ResultUtil updateSdInfoAPL(@RequestBody  SdInfoAPL sdInfoAPL){

if(sdInfoAPL==null){

 return ResultUtil.error ("没有SdInfoAPL数据需要修改"  );}
try {

sdInfoAPLService.update ( sdInfoAPL );
 return ResultUtil.success ("SdInfoAPL数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoAPL  byId = sdInfoAPLService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}