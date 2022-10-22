package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoICH;
import com.sxdl.sd.service.SdInfoICHService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoICH信息")
@RestController
@RequestMapping( "/SdInfoICH")
public class SdInfoICHController{

// 新增单病种

 @Autowired
 private SdInfoICHService  sdInfoICHService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoICH信息")
@PostMapping( "/insertSdInfoICH")

public ResultUtil insertSdInfoICH(@RequestBody  SdInfoICH sdInfoICH){

if(sdInfoICH==null){

 return ResultUtil.error ("没有SdInfoICH数据需要保存"  );}
try {

sdInfoICHService.insert ( sdInfoICH );
 return ResultUtil.success ("SdInfoICH数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoICH 信息")
@PutMapping( "/updateSdInfoICH")

public ResultUtil updateSdInfoICH(@RequestBody  SdInfoICH sdInfoICH){

if(sdInfoICH==null){

 return ResultUtil.error ("没有SdInfoICH数据需要修改"  );}
try {

sdInfoICHService.update ( sdInfoICH );
 return ResultUtil.success ("SdInfoICH数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoICH  byId = sdInfoICHService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}