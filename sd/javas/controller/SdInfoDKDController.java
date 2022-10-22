package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoDKD;
import com.sxdl.sd.service.SdInfoDKDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoDKD信息")
@RestController
@RequestMapping( "/SdInfoDKD")
public class SdInfoDKDController{

// 新增单病种

 @Autowired
 private SdInfoDKDService  sdInfoDKDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoDKD信息")
@PostMapping( "/insertSdInfoDKD")

public ResultUtil insertSdInfoDKD(@RequestBody  SdInfoDKD sdInfoDKD){

if(sdInfoDKD==null){

 return ResultUtil.error ("没有SdInfoDKD数据需要保存"  );}
try {

sdInfoDKDService.insert ( sdInfoDKD );
 return ResultUtil.success ("SdInfoDKD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoDKD 信息")
@PutMapping( "/updateSdInfoDKD")

public ResultUtil updateSdInfoDKD(@RequestBody  SdInfoDKD sdInfoDKD){

if(sdInfoDKD==null){

 return ResultUtil.error ("没有SdInfoDKD数据需要修改"  );}
try {

sdInfoDKDService.update ( sdInfoDKD );
 return ResultUtil.success ("SdInfoDKD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoDKD  byId = sdInfoDKDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}