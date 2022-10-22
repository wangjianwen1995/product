package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoPD;
import com.sxdl.sd.service.SdInfoPDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoPD信息")
@RestController
@RequestMapping( "/SdInfoPD")
public class SdInfoPDController{

// 新增单病种

 @Autowired
 private SdInfoPDService  sdInfoPDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoPD信息")
@PostMapping( "/insertSdInfoPD")

public ResultUtil insertSdInfoPD(@RequestBody  SdInfoPD sdInfoPD){

if(sdInfoPD==null){

 return ResultUtil.error ("没有SdInfoPD数据需要保存"  );}
try {

sdInfoPDService.insert ( sdInfoPD );
 return ResultUtil.success ("SdInfoPD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoPD 信息")
@PutMapping( "/updateSdInfoPD")

public ResultUtil updateSdInfoPD(@RequestBody  SdInfoPD sdInfoPD){

if(sdInfoPD==null){

 return ResultUtil.error ("没有SdInfoPD数据需要修改"  );}
try {

sdInfoPDService.update ( sdInfoPD );
 return ResultUtil.success ("SdInfoPD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoPD  byId = sdInfoPDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}