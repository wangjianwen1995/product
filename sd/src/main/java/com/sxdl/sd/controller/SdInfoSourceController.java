package com.sxdl.sd.controller;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.SysUserVsRoleService;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.dao.dao1.Handle1Dao;
import com.sxdl.sd.entity.SdInfo;
import com.sxdl.sd.entity.SdInfoSource;
import com.sxdl.sd.entity.SdPatientInfo;
import com.sxdl.sd.service.SdInfoService;
import com.sxdl.sd.service.SdInfoSourceService;
import com.sxdl.sd.service.SdPatientInfoService;
import com.sxdl.sd.util.SdApplicationRunnerImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sds")
public class SdInfoSourceController {

    @Autowired
    SdInfoService sdInfoService;

    @Autowired
    SdPatientInfoService sdPatientInfoService;

    @Autowired
    SysUserVsRoleService sysUserVsRoleService;

    @Autowired
    SdInfoSourceService sdInfoSourceService;

    @Autowired
    Handle1Dao handle1Daol;

    @ApiOperation(value = " 模糊查询病人 ", notes = " 模糊查询病人")
    @GetMapping("/finByName")
    @ResponseBody
    public ResultUtil finByName(PageInfo pageInfo,String name, String cdate, String edate) {
        Map<String, Object> map = new HashMap<> ();
        try {
            //List<SdInfoSource> sdInfoSources = sdInfoSourceService.finByName ( name, cdate, edate );
            List<Map<String,Object>> sdInfoSources =new ArrayList<>();
            if(name ==null || "".equals(name)){
                sdInfoSources =handle1Daol.selectSqlWithSQL("select name,caseId,cm_0_2_4_2,CM_0_1_1_1,main_ssname,other_ssname, main_jbname, other_jbname from sd_source where  CM_0_2_4_2 between '"+cdate+"' and '"+edate+"'");
            }else{
                sdInfoSources =handle1Daol.selectSqlWithSQL("select name,caseId,cm_0_2_4_2,CM_0_1_1_1,main_ssname,other_ssname, main_jbname, other_jbname  from sd_source where  ( name  like '%"+name+"%' or caseId like '%"+name+"%' )  and CM_0_2_4_2 between '"+cdate+"' and '"+edate+"'");
            }

            List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get ( "sdInfos" );
            sdInfos = sdInfos.stream ().filter ( e -> null != e && e.getIson ().equals ( 1 ) ).collect ( Collectors.toList () );
            map.put ( "sdInfos", sdInfos );
            if (pageInfo == null || pageInfo.getPageNum () == 0 || pageInfo.getPageSize () == 0) {
                map.put ( "sdInfoSources", sdInfoSources );
            }else{
                Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), sdInfoSources );
                map.put ( "sdInfoSources", listPage );
            }

            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ("查询失败" );
        }
    }


    @ApiOperation(value = "根据id查询", notes = "根据id查询")
    @GetMapping("/findByID")
    @ResponseBody
    public ResultUtil findByID(Integer sid, String patientCode) {
        //System.out.println ( sid );
        SdInfoSource sdInfoSource = new SdInfoSource ();
        sdInfoSource.setCaseId ( patientCode );
        List<SdInfoSource> sdInfoSourceList = sdInfoSourceService.select ( sdInfoSource );

            try {
            SdPatientInfo sdPatientInfo = sdPatientInfoService.selectOne ( sid, patientCode );
            if (null != sdPatientInfo) {
                return ResultUtil.success ( sdPatientInfo, "该病人已在单病种处理流程" );
            }
            SdPatientInfo sdPatientInfo1 = sdPatientInfoService.insertSome ( sdInfoSourceList, sid, patientCode );
            //System.out.println ( sdPatientInfo1 );
            return ResultUtil.success ( sdPatientInfo1 );
        } catch (Exception e) {
                return ResultUtil.error ("查询失败"+e.getMessage() );
        }
    }

}
