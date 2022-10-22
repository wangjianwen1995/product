package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoASD;
import com.sxdl.sd.service.SdInfoASDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoASD信息")
@RestController
@RequestMapping( "/SdInfoASD")
public class SdInfoASDController{

// 新增单病种

 @Autowired
 private SdInfoASDService  sdInfoASDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoASD信息")
@PostMapping( "/insertSdInfoASD")

public ResultUtil insertSdInfoASD(@RequestBody  SdInfoASD sdInfoASD){

if(sdInfoASD==null){

 return ResultUtil.error ("没有SdInfoASD数据需要保存"  );}
try {

sdInfoASDService.insert ( sdInfoASD );
 return ResultUtil.success ("SdInfoASD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoASD 信息")
@PutMapping( "/updateSdInfoASD")

public ResultUtil updateSdInfoASD(@RequestBody  SdInfoASD sdInfoASD){

if(sdInfoASD==null){

 return ResultUtil.error ("没有SdInfoASD数据需要修改"  );}
try {

sdInfoASDService.update ( sdInfoASD );
 return ResultUtil.success ("SdInfoASD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoASD  byId = sdInfoASDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}