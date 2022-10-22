package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoSTK;
import com.sxdl.sd.service.SdInfoSTKService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoSTK信息")
@RestController
@RequestMapping( "/SdInfoSTK")
public class SdInfoSTKController{

// 新增单病种

 @Autowired
 private SdInfoSTKService  sdInfoSTKService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoSTK信息")
@PostMapping( "/insertSdInfoSTK")

public ResultUtil insertSdInfoSTK(@RequestBody  SdInfoSTK sdInfoSTK){

if(sdInfoSTK==null){

 return ResultUtil.error ("没有SdInfoSTK数据需要保存"  );}
try {

sdInfoSTKService.insert ( sdInfoSTK );
 return ResultUtil.success ("SdInfoSTK数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoSTK 信息")
@PutMapping( "/updateSdInfoSTK")

public ResultUtil updateSdInfoSTK(@RequestBody  SdInfoSTK sdInfoSTK){

if(sdInfoSTK==null){

 return ResultUtil.error ("没有SdInfoSTK数据需要修改"  );}
try {

sdInfoSTKService.update ( sdInfoSTK );
 return ResultUtil.success ("SdInfoSTK数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoSTK  byId = sdInfoSTKService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}