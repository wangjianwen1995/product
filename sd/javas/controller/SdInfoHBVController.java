package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoHBV;
import com.sxdl.sd.service.SdInfoHBVService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoHBV信息")
@RestController
@RequestMapping( "/SdInfoHBV")
public class SdInfoHBVController{

// 新增单病种

 @Autowired
 private SdInfoHBVService  sdInfoHBVService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoHBV信息")
@PostMapping( "/insertSdInfoHBV")

public ResultUtil insertSdInfoHBV(@RequestBody  SdInfoHBV sdInfoHBV){

if(sdInfoHBV==null){

 return ResultUtil.error ("没有SdInfoHBV数据需要保存"  );}
try {

sdInfoHBVService.insert ( sdInfoHBV );
 return ResultUtil.success ("SdInfoHBV数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoHBV 信息")
@PutMapping( "/updateSdInfoHBV")

public ResultUtil updateSdInfoHBV(@RequestBody  SdInfoHBV sdInfoHBV){

if(sdInfoHBV==null){

 return ResultUtil.error ("没有SdInfoHBV数据需要修改"  );}
try {

sdInfoHBVService.update ( sdInfoHBV );
 return ResultUtil.success ("SdInfoHBV数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoHBV  byId = sdInfoHBVService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}