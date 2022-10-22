package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoGLI;
import com.sxdl.sd.service.SdInfoGLIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoGLI信息")
@RestController
@RequestMapping( "/SdInfoGLI")
public class SdInfoGLIController{

// 新增单病种

 @Autowired
 private SdInfoGLIService  sdInfoGLIService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoGLI信息")
@PostMapping( "/insertSdInfoGLI")

public ResultUtil insertSdInfoGLI(@RequestBody  SdInfoGLI sdInfoGLI){

if(sdInfoGLI==null){

 return ResultUtil.error ("没有SdInfoGLI数据需要保存"  );}
try {

sdInfoGLIService.insert ( sdInfoGLI );
 return ResultUtil.success ("SdInfoGLI数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoGLI 信息")
@PutMapping( "/updateSdInfoGLI")

public ResultUtil updateSdInfoGLI(@RequestBody  SdInfoGLI sdInfoGLI){

if(sdInfoGLI==null){

 return ResultUtil.error ("没有SdInfoGLI数据需要修改"  );}
try {

sdInfoGLIService.update ( sdInfoGLI );
 return ResultUtil.success ("SdInfoGLI数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoGLI  byId = sdInfoGLIService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}