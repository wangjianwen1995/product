package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoSTEMI;
import com.sxdl.sd.service.SdInfoSTEMIService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoSTEMI信息")
@RestController
@RequestMapping( "/SdInfoSTEMI")
public class SdInfoSTEMIController{

// 新增单病种

 @Autowired
 private SdInfoSTEMIService  sdInfoSTEMIService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoSTEMI信息")
@PostMapping( "/insertSdInfoSTEMI")

public ResultUtil insertSdInfoSTEMI(@RequestBody  SdInfoSTEMI sdInfoSTEMI){

if(sdInfoSTEMI==null){

 return ResultUtil.error ("没有SdInfoSTEMI数据需要保存"  );}
try {

sdInfoSTEMIService.insert ( sdInfoSTEMI );
 return ResultUtil.success ("SdInfoSTEMI数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoSTEMI 信息")
@PutMapping( "/updateSdInfoSTEMI")

public ResultUtil updateSdInfoSTEMI(@RequestBody  SdInfoSTEMI sdInfoSTEMI){

if(sdInfoSTEMI==null){

 return ResultUtil.error ("没有SdInfoSTEMI数据需要修改"  );}
try {

sdInfoSTEMIService.update ( sdInfoSTEMI );
 return ResultUtil.success ("SdInfoSTEMI数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoSTEMI  byId = sdInfoSTEMIService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}