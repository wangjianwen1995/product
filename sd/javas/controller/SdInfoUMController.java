package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoUM;
import com.sxdl.sd.service.SdInfoUMService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoUM信息")
@RestController
@RequestMapping( "/SdInfoUM")
public class SdInfoUMController{

// 新增单病种

 @Autowired
 private SdInfoUMService  sdInfoUMService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoUM信息")
@PostMapping( "/insertSdInfoUM")

public ResultUtil insertSdInfoUM(@RequestBody  SdInfoUM sdInfoUM){

if(sdInfoUM==null){

 return ResultUtil.error ("没有SdInfoUM数据需要保存"  );}
try {

sdInfoUMService.insert ( sdInfoUM );
 return ResultUtil.success ("SdInfoUM数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoUM 信息")
@PutMapping( "/updateSdInfoUM")

public ResultUtil updateSdInfoUM(@RequestBody  SdInfoUM sdInfoUM){

if(sdInfoUM==null){

 return ResultUtil.error ("没有SdInfoUM数据需要修改"  );}
try {

sdInfoUMService.update ( sdInfoUM );
 return ResultUtil.success ("SdInfoUM数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoUM  byId = sdInfoUMService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}