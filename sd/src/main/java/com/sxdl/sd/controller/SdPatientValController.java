package com.sxdl.sd.controller;

import com.sxdl.sd.service.SdPatientValService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psv")
public class SdPatientValController {

    @Autowired
    SdPatientValService sdPatientValService;


   /* @PutMapping("add")
    public ResultUtil add(List<String> list) {
        list.forEach ( e -> {
            System.out.println ( e );
        } );
        return ResultUtil.resultUtil ( "" );
    }

    @ApiOperation(value = "保存修改", notes = "保存修改单病种病人的值信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody Map<String, Object> map) {
        System.out.println ( map );
        if (null == map && map.size () <= 0) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        List<SdPatientVal> list = (List<SdPatientVal>) map.values ().stream ().collect ( Collectors.toList () ).get ( 0 );
        SdPatientInfo sdPatientInfo = (SdPatientInfo) map.values ().stream ().collect ( Collectors.toList () ).get ( 1 );

        try {
            sdPatientValService.insertOrUpdate ( list, sdPatientInfo );
            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( "保存失败" );
        }
    }

    @ApiOperation(value = "根据单病种id获取详细值内容", notes = "根据单病种id获取详细值内容")
    @GetMapping("/findBySdPatientAndSdInfoId")
    @ResponseBody
    public ResultUtil findBySdPatientAndSdInfoId(@RequestParam Integer sid, @RequestParam Integer pid) {
        SdPatientVal sdPatientVal = new SdPatientVal ();
        try {
            if (sid != null && !sid.equals ( "" ) && sid > 0) {
                sdPatientVal.setSd_info_id ( sid );
                sdPatientVal.setSd_patient_id ( pid );
            }
            List<SdPatientVal> patientVals = sdPatientValService.select ( sdPatientVal );
            return ResultUtil.success ( patientVals );
        } catch (Exception e) {
           return ResultUtil.error ("操作失败" );
        }
    }*/
}
