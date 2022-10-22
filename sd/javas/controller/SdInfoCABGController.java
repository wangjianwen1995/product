package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoCABG;
import com.sxdl.sd.service.SdInfoCABGService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoCABG信息")
@RestController
@RequestMapping( "/SdInfoCABG")
public class SdInfoCABGController{

// 新增单病种

 @Autowired
 private SdInfoCABGService  sdInfoCABGService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoCABG信息")
@PostMapping( "/insertSdInfoCABG")

public ResultUtil insertSdInfoCABG(@RequestBody  SdInfoCABG sdInfoCABG){

if(sdInfoCABG==null){

 return ResultUtil.error ("没有SdInfoCABG数据需要保存"  );}
try {

sdInfoCABGService.insert ( sdInfoCABG );
 return ResultUtil.success ("SdInfoCABG数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoCABG 信息")
@PutMapping( "/updateSdInfoCABG")

public ResultUtil updateSdInfoCABG(@RequestBody  SdInfoCABG sdInfoCABG){

if(sdInfoCABG==null){

 return ResultUtil.error ("没有SdInfoCABG数据需要修改"  );}
try {

sdInfoCABGService.update ( sdInfoCABG );
 return ResultUtil.success ("SdInfoCABG数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoCABG  byId = sdInfoCABGService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}