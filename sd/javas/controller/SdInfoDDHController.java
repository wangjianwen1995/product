package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoDDH;
import com.sxdl.sd.service.SdInfoDDHService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoDDH信息")
@RestController
@RequestMapping( "/SdInfoDDH")
public class SdInfoDDHController{

// 新增单病种

 @Autowired
 private SdInfoDDHService  sdInfoDDHService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoDDH信息")
@PostMapping( "/insertSdInfoDDH")

public ResultUtil insertSdInfoDDH(@RequestBody  SdInfoDDH sdInfoDDH){

if(sdInfoDDH==null){

 return ResultUtil.error ("没有SdInfoDDH数据需要保存"  );}
try {

sdInfoDDHService.insert ( sdInfoDDH );
 return ResultUtil.success ("SdInfoDDH数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoDDH 信息")
@PutMapping( "/updateSdInfoDDH")

public ResultUtil updateSdInfoDDH(@RequestBody  SdInfoDDH sdInfoDDH){

if(sdInfoDDH==null){

 return ResultUtil.error ("没有SdInfoDDH数据需要修改"  );}
try {

sdInfoDDHService.update ( sdInfoDDH );
 return ResultUtil.success ("SdInfoDDH数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoDDH  byId = sdInfoDDHService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}