package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoAECOPD;
import com.sxdl.sd.service.SdInfoAECOPDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoAECOPD信息")
@RestController
@RequestMapping( "/SdInfoAECOPD")
public class SdInfoAECOPDController{

// 新增单病种

 @Autowired
 private SdInfoAECOPDService  sdInfoAECOPDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoAECOPD信息")
@PostMapping( "/insertSdInfoAECOPD")

public ResultUtil insertSdInfoAECOPD(@RequestBody  SdInfoAECOPD sdInfoAECOPD){

if(sdInfoAECOPD==null){

 return ResultUtil.error ("没有SdInfoAECOPD数据需要保存"  );}
try {

sdInfoAECOPDService.insert ( sdInfoAECOPD );
 return ResultUtil.success ("SdInfoAECOPD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoAECOPD 信息")
@PutMapping( "/updateSdInfoAECOPD")

public ResultUtil updateSdInfoAECOPD(@RequestBody  SdInfoAECOPD sdInfoAECOPD){

if(sdInfoAECOPD==null){

 return ResultUtil.error ("没有SdInfoAECOPD数据需要修改"  );}
try {

sdInfoAECOPDService.update ( sdInfoAECOPD );
 return ResultUtil.success ("SdInfoAECOPD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoAECOPD  byId = sdInfoAECOPDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}