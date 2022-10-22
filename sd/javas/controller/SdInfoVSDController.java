package com.sxdl.sd.controller;

import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.entity.SdInfoVSD;
import com.sxdl.sd.service.SdInfoVSDService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "SdInfoVSD信息")
@RestController
@RequestMapping( "/SdInfoVSD")
public class SdInfoVSDController{

// 新增单病种

 @Autowired
 private SdInfoVSDService  sdInfoVSDService;

@ApiOperation(value = " 新增 " , notes = " 新增SdInfoVSD信息")
@PostMapping( "/insertSdInfoVSD")

public ResultUtil insertSdInfoVSD(@RequestBody  SdInfoVSD sdInfoVSD){

if(sdInfoVSD==null){

 return ResultUtil.error ("没有SdInfoVSD数据需要保存"  );}
try {

sdInfoVSDService.insert ( sdInfoVSD );
 return ResultUtil.success ("SdInfoVSD数据信息保存成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

// 修改单病种

@ApiOperation(value = " 修改 ", notes = " 修改SdInfoVSD 信息")
@PutMapping( "/updateSdInfoVSD")

public ResultUtil updateSdInfoVSD(@RequestBody  SdInfoVSD sdInfoVSD){

if(sdInfoVSD==null){

 return ResultUtil.error ("没有SdInfoVSD数据需要修改"  );}
try {

sdInfoVSDService.update ( sdInfoVSD );
 return ResultUtil.success ("SdInfoVSD数据信息修改成功"  );
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

//查单个单病种信息

@ApiOperation(value = " 根据id查询单病种信息 ", notes = " 根据id查询单病种信息")
@GetMapping( "/findById")
@ResponseBody

public ResultUtil findById (@RequestParam (value = "id",required = true) Integer id){

try {

SdInfoVSD  byId = sdInfoVSDService.findById ( id );
 return ResultUtil.success (byId);
} catch (Exception e) {
return ResultUtil.error ( e.getMessage () );}
}

}