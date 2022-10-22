package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoRD;
import com.sxdl.sd.service.SdInfoRDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoRD信息")
@RestController
@RequestMapping( "/SdInfoRD")
public class SdInfoRDController{

// 新增单病种

 @Autowired
 private SdInfoRDService  sdInfoRDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoRD信息")
@PostMapping( "/insertSdInfoRD")

public ResultUtil insertSdInfoRD(@RequestBody  SdInfoRD sdInfoRD){

if(sdInfoRD==null){

 return ResultUtil.error ("没有SdInfoRD数据需要保存"  );}
try {

sdInfoRDService.insert ( sdInfoRD );
 return ResultUtil.success ("SdInfoRD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoRD 信息")
@PutMapping( "/updateSdInfoRD")

public ResultUtil updateSdInfoRD(@RequestBody  SdInfoRD sdInfoRD){

if(sdInfoRD==null){

 return ResultUtil.error ("没有SdInfoRD数据需要修改"  );}
try {

sdInfoRDService.update ( sdInfoRD );
 return ResultUtil.success ("SdInfoRD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoRD  byId = sdInfoRDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}