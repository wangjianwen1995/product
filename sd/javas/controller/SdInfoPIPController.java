package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoPIP;
import com.sxdl.sd.service.SdInfoPIPService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoPIP信息")
@RestController
@RequestMapping( "/SdInfoPIP")
public class SdInfoPIPController{

// 新增单病种

 @Autowired
 private SdInfoPIPService  sdInfoPIPService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoPIP信息")
@PostMapping( "/insertSdInfoPIP")

public ResultUtil insertSdInfoPIP(@RequestBody  SdInfoPIP sdInfoPIP){

if(sdInfoPIP==null){

 return ResultUtil.error ("没有SdInfoPIP数据需要保存"  );}
try {

sdInfoPIPService.insert ( sdInfoPIP );
 return ResultUtil.success ("SdInfoPIP数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoPIP 信息")
@PutMapping( "/updateSdInfoPIP")

public ResultUtil updateSdInfoPIP(@RequestBody  SdInfoPIP sdInfoPIP){

if(sdInfoPIP==null){

 return ResultUtil.error ("没有SdInfoPIP数据需要修改"  );}
try {

sdInfoPIPService.update ( sdInfoPIP );
 return ResultUtil.success ("SdInfoPIP数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoPIP  byId = sdInfoPIPService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}