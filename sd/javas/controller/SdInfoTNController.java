package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoTN;
import com.sxdl.sd.service.SdInfoTNService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoTN信息")
@RestController
@RequestMapping( "/SdInfoTN")
public class SdInfoTNController{

// 新增单病种

 @Autowired
 private SdInfoTNService  sdInfoTNService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoTN信息")
@PostMapping( "/insertSdInfoTN")

public ResultUtil insertSdInfoTN(@RequestBody  SdInfoTN sdInfoTN){

if(sdInfoTN==null){

 return ResultUtil.error ("没有SdInfoTN数据需要保存"  );}
try {

sdInfoTNService.insert ( sdInfoTN );
 return ResultUtil.success ("SdInfoTN数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoTN 信息")
@PutMapping( "/updateSdInfoTN")

public ResultUtil updateSdInfoTN(@RequestBody  SdInfoTN sdInfoTN){

if(sdInfoTN==null){

 return ResultUtil.error ("没有SdInfoTN数据需要修改"  );}
try {

sdInfoTNService.update ( sdInfoTN );
 return ResultUtil.success ("SdInfoTN数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoTN  byId = sdInfoTNService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}