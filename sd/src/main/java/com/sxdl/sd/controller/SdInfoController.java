package com.sxdl.sd.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.SysUserVsRoleService;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.sd.dao.dao1.Handle1Dao;
import com.sxdl.sd.entity.*;
import com.sxdl.sd.service.*;
import com.sxdl.sd.util.FileUtil;
import com.sxdl.sd.util.SdApplicationRunnerImpl;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sdi")
public class SdInfoController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    private Handle1Dao handle1Dao;

    @Autowired
    SdPatientValService sdPatientValService;

    @Autowired
    SdPatientInfoService sdPatientInfoService;

    @Autowired
    SysUserVsRoleService sysUserVsRoleService;

    @Autowired
    private SdInfoVSDService sdInfoVSDService;
    @Autowired
    private SdInfoASDService sdInfoASDService;
    @Autowired
    private SdInfoMVRService sdInfoMVRService;
    @Autowired
    private SdInfoAVRService sdInfoAVRService;
    @Autowired
    private SdInfoAFService sdInfoAFService;
    @Autowired
    private SdInfoCABGService sdInfoCABGService;
    @Autowired
    private SdInfoSTEMIService sdInfoSTEMIService;
    @Autowired
    private SdInfoHFService sdInfoHFService;
    @Autowired
    private SdInfoSTKService sdInfoSTKService;
    @Autowired
    private SdInfoTIAService sdInfoTIAService;
    @Autowired
    private SdInfoICHService sdInfoICHService;
    @Autowired
    private SdInfoMENService sdInfoMENService;
    @Autowired
    private SdInfoGLIService sdInfoGLIService;
    @Autowired
    private SdInfoPAService sdInfoPAService;
    @Autowired
    private SdInfoaSAHService sdInfoaSAHService;
    @Autowired
    private SdInfoCSEService sdInfoCSEService;
    @Autowired
    private SdInfoPDService sdInfoPDService;
    @Autowired
    private SdInfoCAPService sdInfoCAPService;
    @Autowired
    private SdInfoCAP2Service sdInfoCAP2Service;
    @Autowired
    private SdInfoAECOPDService sdInfoAECOPDService;
    @Autowired
    private SdInfoCACService sdInfoCACService;
    @Autowired
    private SdInfoTHRService sdInfoTHRService;
    @Autowired
    private SdInfoTKRService sdInfoTKRService;
    @Autowired
    private SdInfoCSService sdInfoCSService;
    @Autowired
    private SdInfoEPService sdInfoEPService;
    @Autowired
    private SdInfoLCService sdInfoLCService;
    @Autowired
    private SdInfoTCService sdInfoTCService;
    @Autowired
    private SdInfoBCService sdInfoBCService;
    @Autowired
    private SdInfoGCService sdInfoGCService;
    @Autowired
    private SdInfoPIPService sdInfoPIPService;
    @Autowired
    private SdInfoDVTService sdInfoDVTService;
    @Autowired
    private SdInfoHBIPSService sdInfoHBIPSService;
    @Autowired
    SdInfoSourceService sdInfoSourceService;
    @Autowired
    SdInfoColumnService sdInfoColumnService;
    @Autowired
    SdInfoCAC2Service sdInfoCAC2Service;
    @Autowired
    SdInfoDDHService sdInfoDDHService;
    @Autowired
    SdInfoUMService sdInfoUMService;
    @Autowired
    SdInfoCCService sdInfoCCService;
    @Autowired
    SdInfoCoCService sdInfoCoCService;
    @Autowired
    SdInfoDKDService sdInfoDKDService;
    @Autowired
    SdInfoESRD_HDService sdInfoESRD_HDService;
    @Autowired
    SdInfoESRD_PDService sdInfoESRD_PDService;
    @Autowired
    SdInfoTSCCService sdInfoTSCCService;
    @Autowired
    SdInfoPTService sdInfoPTService;
    @Autowired
    SdInfoPACGService sdInfoPACGService;
    @Autowired
    SdInfoOITService sdInfoOITService;
    @Autowired
    SdInfoHBVService sdInfoHBVService;
    @Autowired
    SdInfoTNService sdInfoTNService;
    @Autowired
    SdInfoAPLService sdInfoAPLService;
    @Autowired
    SdInfoALLService sdInfoALLService;
    @Autowired
    SdInfoSEPService sdInfoSEPService;
    @Autowired
    SdInfoRDService sdInfoRDService;
    @Autowired
    SdInfoVTEService sdInfoVTEService;
    @Autowired
    SdInfoAPTEService sdInfoAPTEService;

    @Autowired
    SdInfoARDSService sdInfoARDSService;
    @Autowired
    SdInfoEARService sdInfoEARService;

    @Autowired
    SdInfoSAPService sdInfoSAPService;


    @Autowired
    SdInfoService sdInfoService;



    @ApiOperation(value = " 单病种分类 ", notes = " 单病种分类")
    @GetMapping("/findAllSdByGid")
    @ResponseBody
    public ResultUtil findAllSdByGid(PageInfo pageInfo, Integer gid) {
        //System.out.println ( pageInfo );
        List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get ( "sdInfos" );
        try {
            //只有某一个单病种下面会展示病人list信息
            sdInfos = sdInfos.stream ().filter ( e -> e != null && e.getGroup_id ().equals ( gid ) ).collect ( Collectors.toList () );
            if (pageInfo == null || pageInfo.getPageNum () == 0 || pageInfo.getPageSize () == 0) {
                return ResultUtil.success ( sdInfos );
            }
            Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), sdInfos );
            return ResultUtil.success ( listPage );
        } catch (Exception e) {
            return ResultUtil.error ( "查询失败" );
        }
    }


    @ApiOperation(value = "查询单病种 ", notes = " 查询单病种")
    @GetMapping("/finByName")
    @ResponseBody
    public ResultUtil finByName(String name) {
        Map<String, Object> map = new HashMap<> ();
        try {
            List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get ( "sdInfos" );
            if (name != null && !"".equals ( name )) {
                sdInfos = sdInfos.stream ().filter ( e -> null != e && (e.getName_zh ().contains ( name ) || e.getName ().equals ( name )) ).collect ( Collectors.toList () );
            }
            return ResultUtil.success ( map );
        } catch (Exception e) {
            return ResultUtil.error ( "查询失败" );
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存修改单病种病人的值信息")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody Map<String, Object> map) {
       //System.out.println ( map );
        if (null == map && map.size () <= 0) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            Object id1 = map.get ( "id" );
            String ids = String.valueOf ( id1 );
            int id = Integer.parseInt ( ids );
            ObjectMapper objectMapper = new ObjectMapper ();
            objectMapper.configure ( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            Object object1 = map.get ( "sdPatientInfo" );
            SdPatientInfo sdPatientInfo = objectMapper.convertValue ( object1, SdPatientInfo.class );
            Object object = map.get ( "sdinfo" );
            //System.out.println ( object );
            switch (id) {
                case 1:
                    SdInfoSTEMI sdInfoSTEMI = objectMapper.convertValue ( object, SdInfoSTEMI.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSTEMIService.insertOrUpdate ( sdInfoSTEMI, sdPatientInfo );
                    }else{
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSTEMIService.update(sdInfoSTEMI);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSTEMI.setCM_0_2_4_2(format);
                            sdInfoSTEMIService.update(sdInfoSTEMI);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 2:
                    SdInfoHF sdInfoHF = objectMapper.convertValue ( object, SdInfoHF.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoHFService.insertOrUpdate ( sdInfoHF, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoHFService.update(sdInfoHF);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoHF.setCM_0_2_4_2(format);
                            sdInfoHFService.update(sdInfoHF);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 3:
                    SdInfoCABG sdInfoCABG = objectMapper.convertValue ( object, SdInfoCABG.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCABGService.insertOrUpdate ( sdInfoCABG, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCABGService.update(sdInfoCABG);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCABG.setCM_0_2_4_2(format);
                            sdInfoCABGService.update(sdInfoCABG);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 4:
                    SdInfoAF sdInfoAF = objectMapper.convertValue ( object, SdInfoAF.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAFService.insertOrUpdate ( sdInfoAF, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAFService.update(sdInfoAF);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAF.setCM_0_2_4_2(format);
                            sdInfoAFService.update(sdInfoAF);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 5:
                    SdInfoAVR sdInfoAVR = objectMapper.convertValue ( object, SdInfoAVR.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAVRService.insertOrUpdate ( sdInfoAVR, sdPatientInfo );
                    }else {
                       if (sdPatientInfo.getStatus()!=1) {
                           sdInfoAVRService.update(sdInfoAVR);
                       } else {
                           String format = sdPatientInfo.getCy_time();
                           sdInfoAVR.setCM_0_2_4_2(format);
                           sdInfoAVRService.update(sdInfoAVR);
                       }
                   }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 6:
                    SdInfoMVR sdInfoMVR = objectMapper.convertValue ( object, SdInfoMVR.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoMVRService.insertOrUpdate ( sdInfoMVR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoMVRService.update(sdInfoMVR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoMVR.setCM_0_2_4_2(format);
                            sdInfoMVRService.update(sdInfoMVR);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 7:
                    SdInfoASD sdInfoASD = objectMapper.convertValue ( object, SdInfoASD.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoASDService.insertOrUpdate ( sdInfoASD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoASDService.update(sdInfoASD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoASD.setCM_0_2_4_2(format);
                            sdInfoASDService.update(sdInfoASD);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 8:
                    SdInfoVSD sdInfoVSD = objectMapper.convertValue ( object, SdInfoVSD.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoVSDService.insertOrUpdate ( sdInfoVSD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoVSDService.update(sdInfoVSD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoVSD.setCM_0_2_4_2(format);
                            sdInfoVSDService.update(sdInfoVSD);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 9:
                    SdInfoSTK sdInfoSTK = objectMapper.convertValue ( object, SdInfoSTK.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSTKService.insertOrUpdate ( sdInfoSTK, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSTKService.update(sdInfoSTK);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSTK.setCM_0_2_4_2(format);
                            sdInfoSTKService.update(sdInfoSTK);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 10:
                    SdInfoTIA sdInfoTIA = objectMapper.convertValue ( object, SdInfoTIA.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTIAService.insertOrUpdate ( sdInfoTIA, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTIAService.update(sdInfoTIA);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTIA.setCM_0_2_4_2(format);
                            sdInfoTIAService.update(sdInfoTIA);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 11:
                    SdInfoICH sdInfoICH = objectMapper.convertValue ( object, SdInfoICH.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoICHService.insertOrUpdate ( sdInfoICH, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoICHService.update(sdInfoICH);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoICH.setCM_0_2_4_2(format);
                            sdInfoICHService.update(sdInfoICH);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 12:
                    SdInfoMEN sdInfoMEN = objectMapper.convertValue ( object, SdInfoMEN.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoMENService.insertOrUpdate ( sdInfoMEN, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoMENService.update(sdInfoMEN);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoMEN.setCM_0_2_4_2(format);
                            sdInfoMENService.update(sdInfoMEN);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 13:
                    SdInfoGLI sdInfoGLI = objectMapper.convertValue ( object, SdInfoGLI.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoGLIService.insertOrUpdate ( sdInfoGLI, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoGLIService.update(sdInfoGLI);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoGLI.setCM_0_2_4_2(format);
                            sdInfoGLIService.update(sdInfoGLI);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 14:
                    SdInfoPA sdInfoPA = objectMapper.convertValue ( object, SdInfoPA.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPAService.insertOrUpdate ( sdInfoPA, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPAService.update(sdInfoPA);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPA.setCM_0_2_4_2(format);
                            sdInfoPAService.update(sdInfoPA);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 15:
                    SdInfoaSAH sdInfoaSAH = objectMapper.convertValue ( object, SdInfoaSAH.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoaSAHService.insertOrUpdate ( sdInfoaSAH, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoaSAHService.update(sdInfoaSAH);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoaSAH.setCM_0_2_4_2(format);
                            sdInfoaSAHService.update(sdInfoaSAH);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 16:
                    SdInfoCSE sdInfoCSE = objectMapper.convertValue ( object, SdInfoCSE.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCSEService.insertOrUpdate ( sdInfoCSE, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCSEService.update(sdInfoCSE);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCSE.setCM_0_2_4_2(format);
                            sdInfoCSEService.update(sdInfoCSE);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 17:
                    SdInfoPD sdInfoPD = objectMapper.convertValue ( object, SdInfoPD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPDService.insertOrUpdate ( sdInfoPD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPDService.update(sdInfoPD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPD.setCM_0_2_4_2(format);
                            sdInfoPDService.update(sdInfoPD);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 18:
                    SdInfoCAP sdInfoCAP = objectMapper.convertValue ( object, SdInfoCAP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCAPService.insertOrUpdate ( sdInfoCAP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCAPService.update(sdInfoCAP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAP.setCM_0_2_4_2(format);
                            sdInfoCAPService.update(sdInfoCAP);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 19:
                    SdInfoCAP2 sdInfoCAP2 = objectMapper.convertValue ( object, SdInfoCAP2.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCAP2Service.insertOrUpdate ( sdInfoCAP2, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCAP2Service.update(sdInfoCAP2);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAP2.setCM_0_2_4_2(format);
                            sdInfoCAP2Service.update(sdInfoCAP2);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 20:
                    SdInfoAECOPD sdInfoAECOPD = objectMapper.convertValue ( object, SdInfoAECOPD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAECOPDService.insertOrUpdate ( sdInfoAECOPD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAECOPDService.update(sdInfoAECOPD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAECOPD.setCM_0_2_4_2(format);
                            sdInfoAECOPDService.update(sdInfoAECOPD);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 21:
                    SdInfoCAC sdInfoCAC = objectMapper.convertValue ( object, SdInfoCAC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCACService.insertOrUpdate ( sdInfoCAC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCACService.update(sdInfoCAC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAC.setCM_0_2_4_2(format);
                            sdInfoCACService.update(sdInfoCAC);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
               case 22:
                    SdInfoCAC2 sdInfoCAC2 = objectMapper.convertValue ( object, SdInfoCAC2.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoCAC2Service.insertOrUpdate ( sdInfoCAC2, sdPatientInfo );
                   } else {
                       if (sdPatientInfo.getStatus()!=1) {
                           sdInfoCAC2Service.update(sdInfoCAC2);
                       } else {
                           String format = sdPatientInfo.getCy_time();
                           sdInfoCAC2.setCM_0_2_4_2(format);
                           sdInfoCAC2Service.update(sdInfoCAC2);

                       }
                   }
                   handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                           "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                   break;
                case 23:
                    SdInfoTHR sdInfoTHR = objectMapper.convertValue ( object, SdInfoTHR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTHRService.insertOrUpdate ( sdInfoTHR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTHRService.update(sdInfoTHR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTHR.setCM_0_2_4_2(format);
                            sdInfoTHRService.update(sdInfoTHR);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 24:
                    SdInfoTKR sdInfoTKR = objectMapper.convertValue ( object, SdInfoTKR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTKRService.insertOrUpdate ( sdInfoTKR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTKRService.update(sdInfoTKR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTKR.setCM_0_2_4_2(format);
                            sdInfoTKRService.update(sdInfoTKR);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 25:
                    SdInfoDDH sdInfoDDH = objectMapper.convertValue ( object, SdInfoDDH.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoDDHService.insertOrUpdate ( sdInfoDDH, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoDDHService.update(sdInfoDDH);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoDDH.setCM_0_2_4_2(format);
                            sdInfoDDHService.update(sdInfoDDH);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 26:
                    SdInfoCS sdInfoCS = objectMapper.convertValue ( object, SdInfoCS.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCSService.insertOrUpdate ( sdInfoCS, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCSService.update(sdInfoCS);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCS.setCM_0_2_4_2(format);
                            sdInfoCSService.update(sdInfoCS);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 27:
                    SdInfoEP sdInfoEP = objectMapper.convertValue ( object, SdInfoEP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoEPService.insertOrUpdate ( sdInfoEP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoEPService.update(sdInfoEP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoEP.setCM_0_2_4_2(format);
                            sdInfoEPService.update(sdInfoEP);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 28:
                    SdInfoUM sdInfoUM =objectMapper.convertValue ( object, SdInfoUM.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoUMService.insertOrUpdate ( sdInfoUM, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoUMService.update(sdInfoUM);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoUM.setCM_0_2_4_2(format);
                            sdInfoUMService.update(sdInfoUM);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 29:
                    SdInfoLC sdInfoLC = objectMapper.convertValue ( object, SdInfoLC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoLCService.insertOrUpdate ( sdInfoLC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoLCService.update(sdInfoLC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoLC.setCM_0_2_4_2(format);
                            sdInfoLCService.update(sdInfoLC);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 30:
                    SdInfoTC sdInfoTC = objectMapper.convertValue ( object, SdInfoTC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTCService.insertOrUpdate ( sdInfoTC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTCService.update(sdInfoTC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTC.setCM_0_2_4_2(format);
                            sdInfoTCService.update(sdInfoTC);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 31:
                    SdInfoBC sdInfoBC = objectMapper.convertValue ( object, SdInfoBC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoBCService.insertOrUpdate ( sdInfoBC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoBCService.update(sdInfoBC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoBC.setCM_0_2_4_2(format);
                            sdInfoBCService.update(sdInfoBC);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 32:
                    SdInfoGC sdInfoGC = objectMapper.convertValue ( object, SdInfoGC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoGCService.insertOrUpdate ( sdInfoGC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoGCService.update(sdInfoGC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoGC.setCM_0_2_4_2(format);
                            sdInfoGCService.update(sdInfoGC);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
               case 33:
                    SdInfoCC sdInfoCC = objectMapper.convertValue ( object, SdInfoCC.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoCCService.insertOrUpdate ( sdInfoCC, sdPatientInfo );
                   } else {
                       if (sdPatientInfo.getStatus()!=1) {
                           sdInfoCCService.update(sdInfoCC);
                       } else {
                           String format = sdPatientInfo.getCy_time();
                           sdInfoCC.setCM_0_2_4_2(format);
                           sdInfoCCService.update(sdInfoCC);

                       }
                   }
                   handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                           "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                   break;
                case 34:
                    SdInfoCoC sdInfoCoC = objectMapper.convertValue ( object, SdInfoCoC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCoCService.insertOrUpdate ( sdInfoCoC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCoCService.update(sdInfoCoC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCoC.setCM_0_2_4_2(format);
                            sdInfoCoCService.update(sdInfoCoC);

                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
              case 35:
                    SdInfoDKD sdInfoDKD = objectMapper.convertValue ( object, SdInfoDKD.class );
                  if (StringUtils.isEmpty(map.get("log"))) {
                      sdInfoDKDService.insertOrUpdate ( sdInfoDKD, sdPatientInfo );
                  } else {
                      if (sdPatientInfo.getStatus()!=1) {
                          sdInfoDKDService.update(sdInfoDKD);
                      } else {
                          String format = sdPatientInfo.getCy_time();
                          sdInfoDKD.setCM_0_2_4_2(format);
                          sdInfoDKDService.update(sdInfoDKD);

                      }
                  }
                  handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                          "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                  break;
               case 36:
                    SdInfoESRD_HD sdInfoESRDHD = objectMapper.convertValue ( object, SdInfoESRD_HD.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoESRD_HDService.insertOrUpdate ( sdInfoESRDHD, sdPatientInfo );
                   } else {
                           sdInfoESRD_HDService.update(sdInfoESRDHD);
                   }
                   handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                           "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                   break;
               case 37:
                    SdInfoESRD_PD sdInfoESRDPD = objectMapper.convertValue ( object, SdInfoESRD_PD.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoESRD_PDService.insertOrUpdate ( sdInfoESRDPD, sdPatientInfo );
                   } else {
                           sdInfoESRD_PDService.update(sdInfoESRDPD);
                   }
                   handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                           "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                   break;
               case 38:
                    SdInfoTSCC sdInfoTSCC = objectMapper.convertValue ( object, SdInfoTSCC.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoTSCCService.insertOrUpdate ( sdInfoTSCC, sdPatientInfo );
                   } else {
                       if (sdPatientInfo.getStatus()!=1) {
                           sdInfoTSCCService.update(sdInfoTSCC);
                       } else {
                           String format = sdPatientInfo.getCy_time();
                           sdInfoTSCC.setCM_0_2_4_2(format);
                           sdInfoTSCCService.update(sdInfoTSCC);

                       }
                   }
                   handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                           "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                   break;
               case 39:
                    SdInfoPT sdInfoPT = objectMapper.convertValue ( object, SdInfoPT.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoPTService.insertOrUpdate ( sdInfoPT, sdPatientInfo );
                   } else {
                       if (sdPatientInfo.getStatus()!=1) {
                           sdInfoPTService.update(sdInfoPT);
                       } else {
                           String format = sdPatientInfo.getCy_time();
                           sdInfoPT.setCM_0_2_4_2(format);
                           sdInfoPTService.update(sdInfoPT);
                       }
                   }
                   handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                           "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                   break;
               case 40:
                    SdInfoOIT sdInfoOIT =objectMapper.convertValue ( object, SdInfoOIT.class );
                   if (StringUtils.isEmpty(map.get("log"))) {
                       sdInfoOITService.insertOrUpdate ( sdInfoOIT, sdPatientInfo );
                   } else {
                       if (sdPatientInfo.getStatus()!=1) {
                           sdInfoOITService.update(sdInfoOIT);
                       } else {
                           String format = sdPatientInfo.getCy_time();
                           sdInfoOIT.setCM_0_2_4_2(format);
                           sdInfoOITService.update(sdInfoOIT);

                       }
                   }
                   break;
              case 41:
                    SdInfoPACG sdInfoPACG = objectMapper.convertValue ( object, SdInfoPACG.class );
                  if (StringUtils.isEmpty(map.get("log"))) {
                      sdInfoPACGService.insertOrUpdate ( sdInfoPACG, sdPatientInfo );
                  } else {
                      if (sdPatientInfo.getStatus()!=1) {
                          sdInfoPACGService.update(sdInfoPACG);
                      } else {
                          String format = sdPatientInfo.getCy_time();
                          sdInfoPACG.setCM_0_2_4_2(format);
                          sdInfoPACGService.update(sdInfoPACG);
                      }
                  }
                  handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                          "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                  break;
                case 42:
                    SdInfoRD sdInfoRD = objectMapper.convertValue ( object, SdInfoRD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoRDService.insertOrUpdate ( sdInfoRD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoRDService.update(sdInfoRD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoRD.setCM_0_2_4_2(format);
                            sdInfoRDService.update(sdInfoRD);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 43:
                    SdInfoPIP sdInfoPIP = objectMapper.convertValue ( object, SdInfoPIP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPIPService.insertOrUpdate ( sdInfoPIP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPIPService.update(sdInfoPIP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPIP.setCM_0_2_4_2(format);
                            sdInfoPIPService.update(sdInfoPIP);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('46')  AND status=1");
                    break;
                case 44:
                    SdInfoDVT sdInfoDVT = objectMapper.convertValue ( object, SdInfoDVT.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoDVTService.insertOrUpdate ( sdInfoDVT, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoDVTService.update(sdInfoDVT);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoDVT.setCM_0_2_4_2(format);
                            sdInfoDVTService.update(sdInfoDVT);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('43','46')  AND status=1");
                    break;
                case 45:
                    SdInfoHBIPS sdInfoHBIPS = objectMapper.convertValue ( object, SdInfoHBIPS.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoHBIPSService.insertOrUpdate ( sdInfoHBIPS, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoHBIPSService.update(sdInfoHBIPS);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoHBIPS.setCM_0_2_4_2(format);
                            sdInfoHBIPSService.update(sdInfoHBIPS);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 46:
                    SdInfoVTE sdInfoVTE = objectMapper.convertValue ( object, SdInfoVTE.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoVTEService.insertOrUpdate ( sdInfoVTE, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoVTEService.update(sdInfoVTE);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoVTE.setCM_0_2_4_2(format);
                            sdInfoVTEService.update(sdInfoVTE);
                        }
                    }
                    break;
                case 47:
                    SdInfoSEP sdInfoSEP = objectMapper.convertValue ( object, SdInfoSEP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSEPService.insertOrUpdate ( sdInfoSEP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSEPService.update(sdInfoSEP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSEP.setCM_0_2_4_2(format);
                            sdInfoSEPService.update(sdInfoSEP);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 48:
                    SdInfoALL sdInfoALL = objectMapper.convertValue (  object, SdInfoALL.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoALLService.insertOrUpdate ( sdInfoALL, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoALLService.update(sdInfoALL);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoALL.setCM_0_2_4_2(format);
                            sdInfoALLService.update(sdInfoALL);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 49:
                    SdInfoAPL sdInfoAPL = objectMapper.convertValue (  object, SdInfoAPL.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAPLService.insertOrUpdate ( sdInfoAPL, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAPLService.update(sdInfoAPL);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAPL.setCM_0_2_4_2(format);
                            sdInfoAPLService.update(sdInfoAPL);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 50:
                    SdInfoTN sdInfoTN =objectMapper.convertValue ( object, SdInfoTN.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTNService.insertOrUpdate ( sdInfoTN, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTNService.update(sdInfoTN);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTN.setCM_0_2_4_2(format);
                            sdInfoTNService.update(sdInfoTN);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 51:
                    SdInfoHBV sdInfoHBV = objectMapper.convertValue ( object, SdInfoHBV.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoHBVService.insertOrUpdate ( sdInfoHBV, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoHBVService.update(sdInfoHBV);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoHBV.setCM_0_2_4_2(format);
                            sdInfoHBVService.update(sdInfoHBV);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 52:
                    SdInfoAPTE sdInfoAPTE = objectMapper.convertValue ( object, SdInfoAPTE.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAPTEService.insertOrUpdate ( sdInfoAPTE, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAPTEService.update(sdInfoAPTE);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAPTE.setCM_0_2_4_2(format);
                            sdInfoAPTEService.update(sdInfoAPTE);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 53:
                    SdInfoARDS sdInfoARDS = objectMapper.convertValue ( object, SdInfoARDS.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoARDSService.insertOrUpdate ( sdInfoARDS, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoARDSService.update(sdInfoARDS);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoARDS.setCM_0_2_4_2(format);
                            sdInfoARDSService.update(sdInfoARDS);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 54:
                    SdInfoEAR sdInfoEAR = objectMapper.convertValue ( object, SdInfoEAR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoEARService.insertOrUpdate ( sdInfoEAR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoEARService.update(sdInfoEAR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoEAR.setCM_0_2_4_2(format);
                            sdInfoEARService.update(sdInfoEAR);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
                case 55:
                    SdInfoSAP sdInfoSAP = objectMapper.convertValue ( object, SdInfoSAP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSAPService.insertOrUpdate ( sdInfoSAP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSAPService.update(sdInfoSAP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSAP.setCM_0_2_4_2(format);
                            sdInfoSAPService.update(sdInfoSAP);
                        }
                    }
                    handle1Dao.updateSqlWithSQL("UPDATE a SET a.status=-1,a.reject_reason='(管理员)作废,已上报' FROM dbo.sd_patient_info a " +
                            "WHERE patient_code = '"+sdPatientInfo.getPatient_code()+ "' AND sd_info_id IN('44','43','46')  AND status=1");
                    break;
            }
            return ResultUtil.success ( "操作成功" );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage());
        }
    }

    @ApiOperation(value = "根据id查询", notes = "根据id查询")
    @GetMapping("/findByID")
    @ResponseBody
    public ResultUtil findByID(Integer sid, String patientCode, String cysj) {
        SdInfoSource sdInfoSource = new SdInfoSource ();
        sdInfoSource.setCaseId ( patientCode );
        List<SdInfoSource> sdInfoSourceList = sdInfoSourceService.select ( sdInfoSource );
        Map<String, Object> map = new HashMap<> ();
        List list = new ArrayList ();
        SdPatientInfo sdPatientInfo = new SdPatientInfo ();
        sdPatientInfo.setPatient_code ( patientCode );
        sdPatientInfo.setSd_info_id ( sid );
        sdPatientInfo.setCy_time ( cysj );
        SdPatientInfo sdPatientInfo1 = sdPatientInfoService.selectOne ( sdPatientInfo );
        if (sdPatientInfo1!=null) {
            if(!sdPatientInfo1.getStatus ().equals ( 1 )){
                cysj = cysj.substring ( 0, 16 );
            }
        }

        try {
            if (sdInfoSourceList != null && sdInfoSourceList.size () > 0) {
                SdInfoSource sdInfoSource1 = sdInfoSourceList.get ( 0 );
                //I21.0前壁急性透壁性心肌梗死
                String main_jbcode = sdInfoSource1.getMain_jbcode ();
                String main_jbname = sdInfoSource1.getMain_jbname ();
                String main_sscode = sdInfoSource1.getMain_sscode ();
                String main_ssname = sdInfoSource1.getMain_ssname ();
                String other_jbcode = sdInfoSource1.getOther_jbcode ();
                String other_jbname = sdInfoSource1.getOther_jbname ();
                String second_code = sdInfoSource1.getSecond_code ();
                String other_sscode = sdInfoSource1.getOther_sscode ();
                String other_ssname = sdInfoSource1.getOther_ssname ();

                map.put ( "main_jbcode", main_jbcode + "" + main_jbname );
                map.put ( "other_jbcode", other_jbcode + "" + other_jbname );
                map.put ( "second_code", second_code );
                map.put ( "main_sscode", main_sscode + "" + main_ssname );
                map.put ( "other_sscode", other_sscode + "" + other_ssname );
            }
            SdInfoColumn sdInfoColumn = new SdInfoColumn ();
            switch (sid) {
                case 1:
                    SdInfoSTEMI sdInfoSTEMI = new SdInfoSTEMI ();
                    sdInfoSTEMI.setCaseId ( patientCode );
                    sdInfoSTEMI.setCM_0_2_4_2 ( cysj );
                    list = sdInfoSTEMIService.select ( sdInfoSTEMI );
                    break;
                case 2:
                    SdInfoHF sdInfoHF = new SdInfoHF ();
                    sdInfoHF.setCaseId ( patientCode );
                    sdInfoHF.setCM_0_2_4_2 ( cysj );
                    list = sdInfoHFService.select ( sdInfoHF );
                    break;
                case 3:
                    SdInfoCABG sdInfoCABG = new SdInfoCABG ();
                    sdInfoCABG.setCaseId ( patientCode );
                    sdInfoCABG.setCM_0_2_4_2 ( cysj );
                    list = sdInfoCABGService.select ( sdInfoCABG );
                    break;
                case 4:
                    SdInfoAF sdInfoAF = new SdInfoAF ();
                    sdInfoAF.setCaseId ( patientCode );
                    sdInfoAF.setCM_0_2_4_2 ( cysj );
                    list = sdInfoAFService.select ( sdInfoAF );
                    break;

                case 5:
                    SdInfoAVR sdInfoAVR = new SdInfoAVR ();
                    sdInfoAVR.setCaseId ( patientCode );
                    sdInfoAVR.setCM_0_2_4_2 ( cysj );
                    list = sdInfoAVRService.select ( sdInfoAVR );
                    break;

                case 6:
                    SdInfoMVR sdInfoMVR = new SdInfoMVR ();
                    sdInfoMVR.setCaseId ( patientCode );
                    sdInfoMVR.setCM_0_2_4_2 ( cysj );
                    list = sdInfoMVRService.select ( sdInfoMVR );
                    break;

                case 7:
                    SdInfoASD sdInfoASD = new SdInfoASD ();
                    sdInfoASD.setCaseId ( patientCode );
                    sdInfoASD.setCM_0_2_4_2 ( cysj );
                    list = sdInfoASDService.select ( sdInfoASD );
                    break;

                case 8:
                    SdInfoVSD sdInfoVSD = new SdInfoVSD ();
                    sdInfoVSD.setCaseId ( patientCode );
                    sdInfoVSD.setCM_0_2_4_2 ( cysj );
                    list = sdInfoVSDService.select ( sdInfoVSD );
                    break;

                case 9:
                    SdInfoSTK sdInfoSTK = new SdInfoSTK ();
                    sdInfoSTK.setCaseId ( patientCode );
                    sdInfoSTK.setCM_0_2_4_2 ( cysj );
                    list = sdInfoSTKService.select ( sdInfoSTK );
                    break;

                case 10:
                    SdInfoTIA sdInfoTIA = new SdInfoTIA ();
                    sdInfoTIA.setCaseId ( patientCode );
                    sdInfoTIA.setCM_0_2_4_2 ( cysj );
                    list = sdInfoTIAService.select ( sdInfoTIA );
                    break;

                case 11:
                    SdInfoICH sdInfoICH = new SdInfoICH ();
                    sdInfoICH.setCaseId ( patientCode );
                    sdInfoICH.setCM_0_2_4_2 ( cysj );
                    list = sdInfoICHService.select ( sdInfoICH );
                    break;

                case 12:
                    SdInfoMEN sdInfoMEN = new SdInfoMEN ();
                    sdInfoMEN.setCaseId ( patientCode );
                    sdInfoMEN.setCM_0_2_4_2 ( cysj );
                    list = sdInfoMENService.select ( sdInfoMEN );
                    break;

                case 13:
                    SdInfoGLI sdInfoGLI = new SdInfoGLI ();
                    sdInfoGLI.setCaseId ( patientCode );
                    sdInfoGLI.setCM_0_2_4_2 ( cysj );
                    list = sdInfoGLIService.select ( sdInfoGLI );
                    break;

                case 14:
                    SdInfoPA sdInfoPA = new SdInfoPA ();
                    sdInfoPA.setCaseId ( patientCode );
                    sdInfoPA.setCM_0_2_4_2 ( cysj );
                    list = sdInfoPAService.select ( sdInfoPA );
                    break;
                case 15:
                    SdInfoaSAH sdInfoaSAH = new SdInfoaSAH ();
                    sdInfoaSAH.setCaseId ( patientCode );
                    sdInfoaSAH.setCM_0_2_4_2 ( cysj );
                    list = sdInfoaSAHService.select ( sdInfoaSAH );
                    break;

                case 16:
                    SdInfoCSE sdInfoCSE = new SdInfoCSE ();
                    sdInfoCSE.setCaseId ( patientCode );
                    sdInfoCSE.setCM_0_2_4_2 ( cysj );
                    list = sdInfoCSEService.select ( sdInfoCSE );
                    break;

                case 17:
                    SdInfoPD sdInfoPD = new SdInfoPD ();
                    sdInfoPD.setCaseId ( patientCode );
                    sdInfoPD.setCM_0_2_4_2 ( cysj );
                    list = sdInfoPDService.select ( sdInfoPD );
                    break;

                case 18:
                    SdInfoCAP sdInfoCAP = new SdInfoCAP ();
                    sdInfoCAP.setCaseId ( patientCode );
                    sdInfoCAP.setCM_0_2_4_2 ( cysj );
                    list = sdInfoCAPService.select ( sdInfoCAP );
//                    sdInfoCAP.setCap_Adult_3_2_1("y");
                    break;


                case 19:
                    SdInfoCAP2 sdInfoCAP2 = new SdInfoCAP2 ();
                    sdInfoCAP2.setCaseId ( patientCode );
                    sdInfoCAP2.setCM_0_2_4_2 ( cysj );
                    list = sdInfoCAP2Service.select ( sdInfoCAP2 );
                    break;


                case 20:
                    SdInfoAECOPD sdInfoAECOPD = new SdInfoAECOPD ();
                    sdInfoAECOPD.setCaseId ( patientCode );
                    sdInfoAECOPD.setCM_0_2_4_2 ( cysj );
                    list = sdInfoAECOPDService.select ( sdInfoAECOPD );
                    break;

                case 21:
                    SdInfoCAC sdInfoCAC = new SdInfoCAC ();
                    sdInfoCAC.setCaseId ( patientCode );
                    sdInfoCAC.setCM_0_2_4_2 ( cysj );
                    list = sdInfoCACService.select ( sdInfoCAC );
                    break;


                case 23:
                    SdInfoTHR sdInfoTHR = new SdInfoTHR ();
                    sdInfoTHR.setCaseId ( patientCode );
                    sdInfoTHR.setCM_0_2_4_2 ( cysj );
                    list = sdInfoTHRService.select ( sdInfoTHR );
                    break;

                case 24:
                    SdInfoTKR sdInfoTKR = new SdInfoTKR ();
                    sdInfoTKR.setCaseId ( patientCode );
                    sdInfoTKR.setCM_0_2_4_2 ( cysj );
                    list = sdInfoTKRService.select ( sdInfoTKR );
                    break;

                case 26:
                    SdInfoCS sdInfoCS = new SdInfoCS ();
                    sdInfoCS.setCaseId ( patientCode );
                    sdInfoCS.setCM_0_2_4_2 ( cysj );
                    list = sdInfoCSService.select ( sdInfoCS );
                    break;

                case 27:
                    SdInfoEP sdInfoEP = new SdInfoEP ();
                    sdInfoEP.setCaseId ( patientCode );
                    sdInfoEP.setCM_0_2_4_2 ( cysj );
                    list = sdInfoEPService.select ( sdInfoEP );
                    break;


                case 29:
                    SdInfoLC sdInfoLC = new SdInfoLC ();
                    sdInfoLC.setCaseId ( patientCode );
                    sdInfoLC.setCM_0_2_4_2 ( cysj );
                    list = sdInfoLCService.select ( sdInfoLC );
                    break;

                case 30:
                    SdInfoTC sdInfoTC = new SdInfoTC ();
                    sdInfoTC.setCaseId ( patientCode );
                    sdInfoTC.setCM_0_2_4_2 ( cysj );
                    list = sdInfoTCService.select ( sdInfoTC );
                    break;


                case 31:
                    SdInfoBC sdInfoBC = new SdInfoBC ();
                    sdInfoBC.setCaseId ( patientCode );
                    sdInfoBC.setCM_0_2_4_2 ( cysj );
                    list = sdInfoBCService.select ( sdInfoBC );
                    break;

                case 32:
                    SdInfoGC sdInfoGC = new SdInfoGC ();
                    sdInfoGC.setCaseId ( patientCode );
                    sdInfoGC.setCM_0_2_4_2 ( cysj );
                    list = sdInfoGCService.select ( sdInfoGC );
                    break;

                case 43:
                    SdInfoPIP sdInfoPIP = new SdInfoPIP ();
                    sdInfoPIP.setCaseId ( patientCode );
                    sdInfoPIP.setCM_0_2_4_2 ( cysj );
                    list = sdInfoPIPService.select ( sdInfoPIP );
                    break;

                case 44:
                    SdInfoDVT sdInfoDVT = new SdInfoDVT ();
                    sdInfoDVT.setCaseId ( patientCode );
                    sdInfoDVT.setCM_0_2_4_2 ( cysj );
                    list = sdInfoDVTService.select ( sdInfoDVT );
                    break;

                case 45:
                    SdInfoHBIPS sdInfoHBIPS = new SdInfoHBIPS ();
                    sdInfoHBIPS.setCaseId ( patientCode );
                    sdInfoHBIPS.setCM_0_2_4_2 ( cysj );
                    list = sdInfoHBIPSService.select ( sdInfoHBIPS );
                    break;
                    //二次开放
               case 22:
                    SdInfoCAC2 sdInfoCAC2 = new SdInfoCAC2 ();
                    sdInfoCAC2.setCaseId ( patientCode );
                    sdInfoCAC2.setCM_0_2_4_2 ( cysj );
                     list = sdInfoCAC2Service.select ( sdInfoCAC2 ) ;
                    break;


                case 25:
                    SdInfoDDH sdInfoDDH = new SdInfoDDH ();
                    sdInfoDDH.setCaseId ( patientCode );
                    sdInfoDDH.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoDDHService.select ( sdInfoDDH );
                    break;

                 case 28:
                    SdInfoUM sdInfoUM = new SdInfoUM ();
                    sdInfoUM.setCaseId ( patientCode );
                    sdInfoUM.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoUMService.select ( sdInfoUM );
                    break;


                case 33:
                    SdInfoCC sdInfoCC = new SdInfoCC ();
                    sdInfoCC.setCaseId ( patientCode );
                    sdInfoCC.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoCCService.select ( sdInfoCC );
                    break;
                case 34:
                    SdInfoCoC sdInfoCoC = new SdInfoCoC ();
                    sdInfoCoC.setCaseId ( patientCode );
                    sdInfoCoC.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoCoCService.select ( sdInfoCoC );

                    break;
               case 35:
                     SdInfoDKD sdInfoDKD = new SdInfoDKD ();
                    sdInfoDKD.setCaseId ( patientCode );
                    sdInfoDKD.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoDKDService.select ( sdInfoDKD );

                    break;
                case 36:
                     SdInfoESRD_HD sdInfoESRD_HD = new SdInfoESRD_HD ();
                    sdInfoESRD_HD.setCaseId ( patientCode );
                    //sdInfoESRD_HD.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoESRD_HDService.select ( sdInfoESRD_HD);

                    break;
                case 37:
                     SdInfoESRD_PD sdInfoESRDPD = new SdInfoESRD_PD ();
                    sdInfoESRDPD.setCaseId ( patientCode );
                    //sdInfoESRDPD.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoESRD_PDService.select ( sdInfoESRDPD );
                    break;

                case 38:
                     SdInfoTSCC sdInfoTSCC = new SdInfoTSCC ();
                    sdInfoTSCC.setCaseId ( patientCode );
                    sdInfoTSCC.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoTSCCService.select ( sdInfoTSCC );

                    break;
                case 39:
                     SdInfoPT sdInfoPT = new SdInfoPT ();
                    sdInfoPT.setCaseId ( patientCode );
                    sdInfoPT.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoPTService.select ( sdInfoPT );
                    break;
                case 40:
                     SdInfoOIT sdInfoOIT = new SdInfoOIT ();
                    sdInfoOIT.setCaseId ( patientCode );
                    sdInfoOIT.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoOITService.select ( sdInfoOIT );

                    break;
                case 41:
                     SdInfoPACG sdInfoPACG = new SdInfoPACG ();
                    sdInfoPACG.setCaseId ( patientCode );
                    sdInfoPACG.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoPACGService.select ( sdInfoPACG );
                    break;

                case 42:
                     SdInfoRD sdInfoRD= new SdInfoRD ();
                    sdInfoRD.setCaseId ( patientCode );
                    sdInfoRD.setCM_0_2_4_2 ( cysj );
                     list =  sdInfoRDService.select ( sdInfoRD );
                    break;
                case 46:
                      SdInfoVTE sdInfoVTE = new SdInfoVTE ();
                    sdInfoVTE.setCaseId ( patientCode );
                    sdInfoVTE.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoVTEService.select ( sdInfoVTE );

                    break;
                case 47:
               SdInfoSEP sdInfoSEP = new SdInfoSEP ();
                    sdInfoSEP.setCaseId ( patientCode );
                    sdInfoSEP.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoSEPService.select ( sdInfoSEP );

                    break;
                case 48:
              SdInfoALL sdInfoALL = new SdInfoALL ();
                    sdInfoALL.setCaseId ( patientCode );
                    sdInfoALL.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoALLService.select ( sdInfoALL );

                    break;

                case 49:
                SdInfoAPL sdInfoAPL = new SdInfoAPL ();
                    sdInfoAPL.setCaseId ( patientCode );
                    sdInfoAPL.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoAPLService.select ( sdInfoAPL );break;
                case 50:
               SdInfoTN sdInfoTN = new SdInfoTN ();
                    sdInfoTN.setCaseId ( patientCode );
                    sdInfoTN.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoTNService.select ( sdInfoTN );
                     break;
                case 51:
                SdInfoHBV sdInfoHBV = new SdInfoHBV ();
                    sdInfoHBV.setCaseId ( patientCode );
                    sdInfoHBV.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoHBVService.select ( sdInfoHBV );
                    break;
                case 52:
                    SdInfoAPTE sdInfoAPTE = new SdInfoAPTE ();
                    sdInfoAPTE.setCaseId ( patientCode );
                    sdInfoAPTE.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoAPTEService.select ( sdInfoAPTE );
                    break;
                case 53:
                    SdInfoARDS sdInfoARDS = new SdInfoARDS ();
                    sdInfoARDS.setCaseId ( patientCode );
                    sdInfoARDS.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoARDSService.select ( sdInfoARDS );
                    break;
                case 54:
                    SdInfoEAR sdInfoEAR = new SdInfoEAR ();
                    sdInfoEAR.setCaseId ( patientCode );
                    sdInfoEAR.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoEARService.select ( sdInfoEAR );
                    break;
                case 55:
                    SdInfoSAP sdInfoSAP = new SdInfoSAP ();
                    sdInfoSAP.setCaseId ( patientCode );
                    sdInfoSAP.setCM_0_2_4_2 ( cysj );
                    list =  sdInfoSAPService.select ( sdInfoSAP );
                    break;
            }
            //System.out.println ( list );
            map.put ( "list", list );
            return ResultUtil.success ( map );
            //return ResultUtil.success ( list );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultUtil.error ( "查询失败" );
        }
    }

    @ApiOperation(value = "查询启用的单病种 ", notes = " 查询启用的单病种")
    @GetMapping("/finAll")
    @ResponseBody
    public ResultUtil finAll() {

        try {
            List<SdInfo> sdInfos = (List<SdInfo>) SdApplicationRunnerImpl.contextMap.get ( "sdInfos" );
            sdInfos = sdInfos.stream ().filter ( e -> null != e && e.getIson ().equals ( 1 ) ).collect ( Collectors.toList () );
            return ResultUtil.success ( sdInfos );
        } catch (Exception e) {
            return ResultUtil.error ( "查询失败" );
        }
    }

    @ApiOperation(value = "保存模板", notes = "保存特定单病种模板信息")
    @PutMapping("/updateTp")
    @ResponseBody
    public ResultUtil updateTp(@RequestBody Map<String, Object> map) {
        //System.out.println ( map );
        if (null == map && map.size () <= 0) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        String tpInfo ="";
        try {
            Object id1 = map.get ( "id" );
            String ids = String.valueOf ( id1 );
            int id = Integer.parseInt ( ids );
            ObjectMapper objectMapper = new ObjectMapper ();
            objectMapper.configure ( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false );
            Object object1 = map.get ( "sdPatientInfo" );
            SdPatientInfo sdPatientInfo = objectMapper.convertValue ( object1, SdPatientInfo.class );
            Object object = map.get ( "sdinfo" );
            //System.out.println ( object );
            switch (id) {
                case 1:
                    SdInfoSTEMI sdInfoSTEMI = objectMapper.convertValue ( object, SdInfoSTEMI.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSTEMIService.insertOrUpdate ( sdInfoSTEMI, sdPatientInfo );
                    }else{
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSTEMIService.update(sdInfoSTEMI);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSTEMI.setCM_0_2_4_2(format);
                            sdInfoSTEMIService.update(sdInfoSTEMI);
                            //参数：存储名称，模板名称，病种id, 数据id   exec ETL_TEMPLATE '测试名称2','2','387351'
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoSTEMI.getCaseId());

                        }
                    }
                    break;
                case 2:
                    SdInfoHF sdInfoHF = objectMapper.convertValue ( object, SdInfoHF.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoHFService.insertOrUpdate ( sdInfoHF, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoHFService.update(sdInfoHF);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoHF.setCM_0_2_4_2(format);
                            sdInfoHFService.update(sdInfoHF);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE",(String) map.get("tempname"),id+"",sdInfoHF.getCaseId());
                        }
                    }
                    break;
                case 3:
                    SdInfoCABG sdInfoCABG = objectMapper.convertValue ( object, SdInfoCABG.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCABGService.insertOrUpdate ( sdInfoCABG, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCABGService.update(sdInfoCABG);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCABG.setCM_0_2_4_2(format);
                            sdInfoCABGService.update(sdInfoCABG);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCABG.getCaseId());
                        }
                    }
                    break;
                case 4:
                    SdInfoAF sdInfoAF = objectMapper.convertValue ( object, SdInfoAF.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAFService.insertOrUpdate ( sdInfoAF, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAFService.update(sdInfoAF);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAF.setCM_0_2_4_2(format);
                            sdInfoAFService.update(sdInfoAF);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoAF.getCaseId());
                        }
                    }
                    break;
                case 5:
                    SdInfoAVR sdInfoAVR = objectMapper.convertValue ( object, SdInfoAVR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAVRService.insertOrUpdate ( sdInfoAVR, sdPatientInfo );
                    }else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAVRService.update(sdInfoAVR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAVR.setCM_0_2_4_2(format);
                            sdInfoAVRService.update(sdInfoAVR);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoAVR.getCaseId());
                        }
                    }

                    break;
                case 6:
                    SdInfoMVR sdInfoMVR = objectMapper.convertValue ( object, SdInfoMVR.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoMVRService.insertOrUpdate ( sdInfoMVR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoMVRService.update(sdInfoMVR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoMVR.setCM_0_2_4_2(format);
                            sdInfoMVRService.update(sdInfoMVR);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoMVR.getCaseId());
                        }
                    }
                    break;
                case 7:
                    SdInfoASD sdInfoASD = objectMapper.convertValue ( object, SdInfoASD.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoASDService.insertOrUpdate ( sdInfoASD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoASDService.update(sdInfoASD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoASD.setCM_0_2_4_2(format);
                            sdInfoASDService.update(sdInfoASD);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoASD.getCaseId());
                        }
                    }
                    break;
                case 8:
                    SdInfoVSD sdInfoVSD = objectMapper.convertValue ( object, SdInfoVSD.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoVSDService.insertOrUpdate ( sdInfoVSD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoVSDService.update(sdInfoVSD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoVSD.setCM_0_2_4_2(format);
                            sdInfoVSDService.update(sdInfoVSD);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoVSD.getCaseId());
                        }
                    }
                    break;
                case 9:
                    SdInfoSTK sdInfoSTK = objectMapper.convertValue ( object, SdInfoSTK.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSTKService.insertOrUpdate ( sdInfoSTK, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSTKService.update(sdInfoSTK);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSTK.setCM_0_2_4_2(format);
                            sdInfoSTKService.update(sdInfoSTK);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoSTK.getCaseId());
                        }
                    }
                    break;
                case 10:
                    SdInfoTIA sdInfoTIA = objectMapper.convertValue ( object, SdInfoTIA.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTIAService.insertOrUpdate ( sdInfoTIA, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTIAService.update(sdInfoTIA);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTIA.setCM_0_2_4_2(format);
                            sdInfoTIAService.update(sdInfoTIA);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoTIA.getCaseId());
                        }
                    }
                    break;
                case 11:
                    SdInfoICH sdInfoICH = objectMapper.convertValue ( object, SdInfoICH.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoICHService.insertOrUpdate ( sdInfoICH, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoICHService.update(sdInfoICH);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoICH.setCM_0_2_4_2(format);
                            sdInfoICHService.update(sdInfoICH);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoICH.getCaseId());
                        }
                    }
                    break;
                case 12:
                    SdInfoMEN sdInfoMEN = objectMapper.convertValue ( object, SdInfoMEN.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoMENService.insertOrUpdate ( sdInfoMEN, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoMENService.update(sdInfoMEN);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoMEN.setCM_0_2_4_2(format);
                            sdInfoMENService.update(sdInfoMEN);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoMEN.getCaseId());
                        }
                    }
                    break;
                case 13:
                    SdInfoGLI sdInfoGLI = objectMapper.convertValue ( object, SdInfoGLI.class );

                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoGLIService.insertOrUpdate ( sdInfoGLI, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoGLIService.update(sdInfoGLI);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoGLI.setCM_0_2_4_2(format);
                            sdInfoGLIService.update(sdInfoGLI);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoGLI.getCaseId());
                        }
                    }
                    break;
                case 14:
                    SdInfoPA sdInfoPA = objectMapper.convertValue ( object, SdInfoPA.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPAService.insertOrUpdate ( sdInfoPA, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPAService.update(sdInfoPA);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPA.setCM_0_2_4_2(format);
                            sdInfoPAService.update(sdInfoPA);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoPA.getCaseId());
                        }
                    }
                    break;
                case 15:
                    SdInfoaSAH sdInfoaSAH = objectMapper.convertValue ( object, SdInfoaSAH.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoaSAHService.insertOrUpdate ( sdInfoaSAH, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoaSAHService.update(sdInfoaSAH);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoaSAH.setCM_0_2_4_2(format);
                            sdInfoaSAHService.update(sdInfoaSAH);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoaSAH.getCaseId());
                        }
                    }
                    break;
                case 16:
                    SdInfoCSE sdInfoCSE = objectMapper.convertValue ( object, SdInfoCSE.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCSEService.insertOrUpdate ( sdInfoCSE, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCSEService.update(sdInfoCSE);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCSE.setCM_0_2_4_2(format);
                            sdInfoCSEService.update(sdInfoCSE);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCSE.getCaseId());
                        }
                    }
                    break;
                case 17:
                    SdInfoPD sdInfoPD = objectMapper.convertValue ( object, SdInfoPD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPDService.insertOrUpdate ( sdInfoPD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPDService.update(sdInfoPD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPD.setCM_0_2_4_2(format);
                            sdInfoPDService.update(sdInfoPD);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoPD.getCaseId());
                        }
                    }
                    break;
                case 18:
                    SdInfoCAP sdInfoCAP = objectMapper.convertValue ( object, SdInfoCAP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCAPService.insertOrUpdate ( sdInfoCAP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCAPService.update(sdInfoCAP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAP.setCM_0_2_4_2(format);
                            sdInfoCAPService.update(sdInfoCAP);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCAP.getCaseId());
                        }
                    }
                    break;
                case 19:
                    SdInfoCAP2 sdInfoCAP2 = objectMapper.convertValue ( object, SdInfoCAP2.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCAP2Service.insertOrUpdate ( sdInfoCAP2, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCAP2Service.update(sdInfoCAP2);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAP2.setCM_0_2_4_2(format);
                            sdInfoCAP2Service.update(sdInfoCAP2);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCAP2.getCaseId());
                        }
                    }
                    break;
                case 20:
                    SdInfoAECOPD sdInfoAECOPD = objectMapper.convertValue ( object, SdInfoAECOPD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAECOPDService.insertOrUpdate ( sdInfoAECOPD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAECOPDService.update(sdInfoAECOPD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAECOPD.setCM_0_2_4_2(format);
                            sdInfoAECOPDService.update(sdInfoAECOPD);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoAECOPD.getCaseId());
                        }
                    }
                    break;
                case 21:
                    SdInfoCAC sdInfoCAC = objectMapper.convertValue ( object, SdInfoCAC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCACService.insertOrUpdate ( sdInfoCAC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCACService.update(sdInfoCAC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAC.setCM_0_2_4_2(format);
                            sdInfoCACService.update(sdInfoCAC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCAC.getCaseId());
                        }
                    }
                    break;
                case 22:
                    SdInfoCAC2 sdInfoCAC2 = objectMapper.convertValue ( object, SdInfoCAC2.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCAC2Service.insertOrUpdate ( sdInfoCAC2, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCAC2Service.update(sdInfoCAC2);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCAC2.setCM_0_2_4_2(format);
                            sdInfoCAC2Service.update(sdInfoCAC2);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCAC2.getCaseId());
                        }
                    }
                    break;
                case 23:
                    SdInfoTHR sdInfoTHR = objectMapper.convertValue ( object, SdInfoTHR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTHRService.insertOrUpdate ( sdInfoTHR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTHRService.update(sdInfoTHR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTHR.setCM_0_2_4_2(format);
                            sdInfoTHRService.update(sdInfoTHR);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoTHR.getCaseId());
                        }
                    }
                    break;
                case 24:
                    SdInfoTKR sdInfoTKR = objectMapper.convertValue ( object, SdInfoTKR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTKRService.insertOrUpdate ( sdInfoTKR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTKRService.update(sdInfoTKR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTKR.setCM_0_2_4_2(format);
                            sdInfoTKRService.update(sdInfoTKR);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoTKR.getCaseId());
                        }
                    }
                    break;
                case 25:
                    SdInfoDDH sdInfoDDH = objectMapper.convertValue ( object, SdInfoDDH.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoDDHService.insertOrUpdate ( sdInfoDDH, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoDDHService.update(sdInfoDDH);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoDDH.setCM_0_2_4_2(format);
                            sdInfoDDHService.update(sdInfoDDH);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoDDH.getCaseId());
                        }
                    }
                    break;
                case 26:
                    SdInfoCS sdInfoCS = objectMapper.convertValue ( object, SdInfoCS.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCSService.insertOrUpdate ( sdInfoCS, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCSService.update(sdInfoCS);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCS.setCM_0_2_4_2(format);
                            sdInfoCSService.update(sdInfoCS);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCS.getCaseId());
                        }
                    }
                    break;
                case 27:
                    SdInfoEP sdInfoEP = objectMapper.convertValue ( object, SdInfoEP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoEPService.insertOrUpdate ( sdInfoEP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoEPService.update(sdInfoEP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoEP.setCM_0_2_4_2(format);
                            sdInfoEPService.update(sdInfoEP);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoEP.getCaseId());
                        }
                    }
                    break;
                case 28:
                    SdInfoUM sdInfoUM =objectMapper.convertValue ( object, SdInfoUM.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoUMService.insertOrUpdate ( sdInfoUM, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoUMService.update(sdInfoUM);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoUM.setCM_0_2_4_2(format);
                            sdInfoUMService.update(sdInfoUM);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoUM.getCaseId());
                        }
                    }
                    break;
                case 29:
                    SdInfoLC sdInfoLC = objectMapper.convertValue ( object, SdInfoLC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoLCService.insertOrUpdate ( sdInfoLC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoLCService.update(sdInfoLC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoLC.setCM_0_2_4_2(format);
                            sdInfoLCService.update(sdInfoLC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoLC.getCaseId());
                        }
                    }
                    break;
                case 30:
                    SdInfoTC sdInfoTC = objectMapper.convertValue ( object, SdInfoTC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTCService.insertOrUpdate ( sdInfoTC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTCService.update(sdInfoTC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTC.setCM_0_2_4_2(format);
                            sdInfoTCService.update(sdInfoTC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoTC.getCaseId());
                        }
                    }
                    break;

                case 31:
                    SdInfoBC sdInfoBC = objectMapper.convertValue ( object, SdInfoBC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoBCService.insertOrUpdate ( sdInfoBC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoBCService.update(sdInfoBC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoBC.setCM_0_2_4_2(format);
                            sdInfoBCService.update(sdInfoBC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoBC.getCaseId());
                        }
                    }
                    break;
                case 32:
                    SdInfoGC sdInfoGC = objectMapper.convertValue ( object, SdInfoGC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoGCService.insertOrUpdate ( sdInfoGC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoGCService.update(sdInfoGC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoGC.setCM_0_2_4_2(format);
                            sdInfoGCService.update(sdInfoGC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoGC.getCaseId());
                        }
                    }
                    break;

                case 33:
                    SdInfoCC sdInfoCC = objectMapper.convertValue ( object, SdInfoCC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCCService.insertOrUpdate ( sdInfoCC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCCService.update(sdInfoCC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCC.setCM_0_2_4_2(format);
                            sdInfoCCService.update(sdInfoCC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCC.getCaseId());
                        }
                    }
                    break;
                case 34:
                    SdInfoCoC sdInfoCoC = objectMapper.convertValue ( object, SdInfoCoC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoCoCService.insertOrUpdate ( sdInfoCoC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoCoCService.update(sdInfoCoC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoCoC.setCM_0_2_4_2(format);
                            sdInfoCoCService.update(sdInfoCoC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoCoC.getCaseId());
                        }
                    }
                    break;
                case 35:
                    SdInfoDKD sdInfoDKD = objectMapper.convertValue ( object, SdInfoDKD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoDKDService.insertOrUpdate ( sdInfoDKD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoDKDService.update(sdInfoDKD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoDKD.setCM_0_2_4_2(format);
                            sdInfoDKDService.update(sdInfoDKD);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoDKD.getCaseId());
                        }
                    }
                    break;
                case 36:
                    SdInfoESRD_HD sdInfoESRDHD = objectMapper.convertValue ( object, SdInfoESRD_HD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoESRD_HDService.insertOrUpdate ( sdInfoESRDHD, sdPatientInfo );
                    } else {
                        sdInfoESRD_HDService.update(sdInfoESRDHD);
                        tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoESRDHD.getCaseId());
                    }
                    break;
                case 37:
                    SdInfoESRD_PD sdInfoESRDPD = objectMapper.convertValue ( object, SdInfoESRD_PD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoESRD_PDService.insertOrUpdate ( sdInfoESRDPD, sdPatientInfo );
                    } else {
                        sdInfoESRD_PDService.update(sdInfoESRDPD);
                        tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoESRDPD.getCaseId());
                    }
                    break;
                case 38:
                    SdInfoTSCC sdInfoTSCC = objectMapper.convertValue ( object, SdInfoTSCC.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTSCCService.insertOrUpdate ( sdInfoTSCC, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTSCCService.update(sdInfoTSCC);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTSCC.setCM_0_2_4_2(format);
                            sdInfoTSCCService.update(sdInfoTSCC);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoTSCC.getCaseId());
                        }
                    }
                    break;
                case 39:
                    SdInfoPT sdInfoPT = objectMapper.convertValue ( object, SdInfoPT.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPTService.insertOrUpdate ( sdInfoPT, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPTService.update(sdInfoPT);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPT.setCM_0_2_4_2(format);
                            sdInfoPTService.update(sdInfoPT);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoPT.getCaseId());
                        }
                    }
                    break;
                case 40:
                    SdInfoOIT sdInfoOIT =objectMapper.convertValue ( object, SdInfoOIT.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoOITService.insertOrUpdate ( sdInfoOIT, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoOITService.update(sdInfoOIT);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoOIT.setCM_0_2_4_2(format);
                            sdInfoOITService.update(sdInfoOIT);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoOIT.getCaseId());
                        }
                    }
                    break;
                case 41:
                    SdInfoPACG sdInfoPACG = objectMapper.convertValue ( object, SdInfoPACG.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPACGService.insertOrUpdate ( sdInfoPACG, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPACGService.update(sdInfoPACG);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPACG.setCM_0_2_4_2(format);
                            sdInfoPACGService.update(sdInfoPACG);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoPACG.getCaseId());
                        }
                    }
                    break;

                case 42:
                    SdInfoRD sdInfoRD = objectMapper.convertValue ( object, SdInfoRD.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoRDService.insertOrUpdate ( sdInfoRD, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoRDService.update(sdInfoRD);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoRD.setCM_0_2_4_2(format);
                            sdInfoRDService.update(sdInfoRD);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoRD.getCaseId());
                        }
                    }
                    break;
                case 43:
                    SdInfoPIP sdInfoPIP = objectMapper.convertValue ( object, SdInfoPIP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoPIPService.insertOrUpdate ( sdInfoPIP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoPIPService.update(sdInfoPIP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoPIP.setCM_0_2_4_2(format);
                            sdInfoPIPService.update(sdInfoPIP);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoPIP.getCaseId());
                        }
                    }
                    break;
                case 44:
                    SdInfoDVT sdInfoDVT = objectMapper.convertValue ( object, SdInfoDVT.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoDVTService.insertOrUpdate ( sdInfoDVT, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoDVTService.update(sdInfoDVT);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoDVT.setCM_0_2_4_2(format);
                            sdInfoDVTService.update(sdInfoDVT);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoDVT.getCaseId());
                        }
                    }
                    break;
                case 45:
                    SdInfoHBIPS sdInfoHBIPS = objectMapper.convertValue ( object, SdInfoHBIPS.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoHBIPSService.insertOrUpdate ( sdInfoHBIPS, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoHBIPSService.update(sdInfoHBIPS);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoHBIPS.setCM_0_2_4_2(format);
                            sdInfoHBIPSService.update(sdInfoHBIPS);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoHBIPS.getCaseId());
                        }
                    }
                    break;
                case 46:
                    SdInfoVTE sdInfoVTE = objectMapper.convertValue ( object, SdInfoVTE.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoVTEService.insertOrUpdate ( sdInfoVTE, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoVTEService.update(sdInfoVTE);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoVTE.setCM_0_2_4_2(format);
                            sdInfoVTEService.update(sdInfoVTE);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoVTE.getCaseId());
                        }
                    }
                    break;
                case 47:
                    SdInfoSEP sdInfoSEP = objectMapper.convertValue ( object, SdInfoSEP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSEPService.insertOrUpdate ( sdInfoSEP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSEPService.update(sdInfoSEP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSEP.setCM_0_2_4_2(format);
                            sdInfoSEPService.update(sdInfoSEP);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoSEP.getCaseId());
                        }
                    }
                    break;
                case 48:
                    SdInfoALL sdInfoALL = objectMapper.convertValue (  object, SdInfoALL.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoALLService.insertOrUpdate ( sdInfoALL, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoALLService.update(sdInfoALL);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoALL.setCM_0_2_4_2(format);
                            sdInfoALLService.update(sdInfoALL);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoALL.getCaseId());
                        }
                    }
                    break;

                case 49:
                    SdInfoAPL sdInfoAPL = objectMapper.convertValue (  object, SdInfoAPL.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAPLService.insertOrUpdate ( sdInfoAPL, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAPLService.update(sdInfoAPL);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAPL.setCM_0_2_4_2(format);
                            sdInfoAPLService.update(sdInfoAPL);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoAPL.getCaseId());
                        }
                    }
                    break;
                case 50:
                    SdInfoTN sdInfoTN =objectMapper.convertValue ( object, SdInfoTN.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoTNService.insertOrUpdate ( sdInfoTN, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoTNService.update(sdInfoTN);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoTN.setCM_0_2_4_2(format);
                            sdInfoTNService.update(sdInfoTN);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoTN.getCaseId());
                        }
                    }
                    break;
                case 51:
                    SdInfoHBV sdInfoHBV = objectMapper.convertValue ( object, SdInfoHBV.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoHBVService.insertOrUpdate ( sdInfoHBV, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoHBVService.update(sdInfoHBV);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoHBV.setCM_0_2_4_2(format);
                            sdInfoHBVService.update(sdInfoHBV);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoHBV.getCaseId());
                        }
                    }
                    break;
                case 52:
                    SdInfoAPTE sdInfoAPTE = objectMapper.convertValue ( object, SdInfoAPTE.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoAPTEService.insertOrUpdate ( sdInfoAPTE, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoAPTEService.update(sdInfoAPTE);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoAPTE.setCM_0_2_4_2(format);
                            sdInfoAPTEService.update(sdInfoAPTE);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoAPTE.getCaseId());
                        }
                    }
                    break;
                case 53:
                    SdInfoARDS sdInfoARDS = objectMapper.convertValue ( object, SdInfoARDS.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoARDSService.insertOrUpdate ( sdInfoARDS, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoARDSService.update(sdInfoARDS);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoARDS.setCM_0_2_4_2(format);
                            sdInfoARDSService.update(sdInfoARDS);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoARDS.getCaseId());
                        }
                    }
                    break;
                case 54:
                    SdInfoEAR sdInfoEAR = objectMapper.convertValue ( object, SdInfoEAR.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoEARService.insertOrUpdate ( sdInfoEAR, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoEARService.update(sdInfoEAR);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoEAR.setCM_0_2_4_2(format);
                            sdInfoEARService.update(sdInfoEAR);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoEAR.getCaseId());
                        }
                    }
                    break;
                case 55:
                    SdInfoSAP sdInfoSAP = objectMapper.convertValue ( object, SdInfoSAP.class );
                    if (StringUtils.isEmpty(map.get("log"))) {
                        sdInfoSAPService.insertOrUpdate ( sdInfoSAP, sdPatientInfo );
                    } else {
                        if (sdPatientInfo.getStatus()!=1) {
                            sdInfoSAPService.update(sdInfoSAP);
                        } else {
                            String format = sdPatientInfo.getCy_time();
                            sdInfoSAP.setCM_0_2_4_2(format);
                            sdInfoSAPService.update(sdInfoSAP);
                            tpInfo = handle1Dao.excuteProcedueWithTpParams("ETL_TEMPLATE", (String) map.get("tempname"),id+"",sdInfoSAP.getCaseId());
                        }
                    }
                    break;
            }
            return ResultUtil.success ( "操作成功信息:" +tpInfo);
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage());
        }
    }
    @ApiOperation(value = "加载模板数据", notes = "加载模板数据")
    @GetMapping("/findByIDTp")
    @ResponseBody
    public ResultUtil findByIDTp(Integer sid, String patientCode, String cysj,String tempname) {
        SdInfoSource sdInfoSource = new SdInfoSource ();
        sdInfoSource.setCaseId ( patientCode );
        List<SdInfoSource> sdInfoSourceList = sdInfoSourceService.select ( sdInfoSource );
        Map<String, Object> map = new HashMap<> ();
        List list = new ArrayList ();
        SdPatientInfo sdPatientInfo = new SdPatientInfo ();
        sdPatientInfo.setPatient_code ( patientCode );
        sdPatientInfo.setSd_info_id ( sid );
        sdPatientInfo.setCy_time ( cysj );
        SdPatientInfo sdPatientInfo1 = sdPatientInfoService.selectOne ( sdPatientInfo );
        if (sdPatientInfo1!=null) {
            if(!sdPatientInfo1.getStatus ().equals ( 1 )){
                cysj = cysj.substring ( 0, 16 );
            }
        }

        try {
            if (sdInfoSourceList != null && sdInfoSourceList.size () > 0) {
                SdInfoSource sdInfoSource1 = sdInfoSourceList.get ( 0 );
                //I21.0前壁急性透壁性心肌梗死
                String main_jbcode = sdInfoSource1.getMain_jbcode ();
                String main_jbname = sdInfoSource1.getMain_jbname ();
                String main_sscode = sdInfoSource1.getMain_sscode ();
                String main_ssname = sdInfoSource1.getMain_ssname ();
                String other_jbcode = sdInfoSource1.getOther_jbcode ();
                String other_jbname = sdInfoSource1.getOther_jbname ();
                String second_code = sdInfoSource1.getSecond_code ();
                String other_sscode = sdInfoSource1.getOther_sscode ();
                String other_ssname = sdInfoSource1.getOther_ssname ();

                map.put ( "main_jbcode", main_jbcode + "" + main_jbname );
                map.put ( "other_jbcode", other_jbcode + "" + other_jbname );
                map.put ( "second_code", second_code );
                map.put ( "main_sscode", main_sscode + "" + main_ssname );
                map.put ( "other_sscode", other_sscode + "" + other_ssname );
            }
            SdInfoColumn sdInfoColumn = new SdInfoColumn ();
            switch (sid) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                    list =handle1Dao.excuteProcedueWithTpLoad("ETL_LOAD_TEMPLATE", patientCode,cysj,sid+"",tempname);
                    break;
            }
            map.put ( "list", list );
            return ResultUtil.success ( map );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultUtil.error ( "查询失败" );
        }
    }
    @ApiOperation(value = "显示模板信息", notes = "显示模板信息")
    @GetMapping("/findByTpNames")
    @ResponseBody
    public ResultUtil findByTpNames(Integer sid) {
        String str =  handle1Dao.selectSqlWithSQLStr("SELECT sd_info_tpname FROM dbo.sd_info_tp WHERE id ="+sid);
        try {
            List<Map<String,Object>> maps =handle1Dao.selectSqlWithSQL("SELECT tempname FROM "+str);
            return ResultUtil.success (maps,"success" );
        } catch (Exception e) {
            return ResultUtil.error ( "该病种无模板信息" );
        }

    }

    @ApiOperation(value = "查询所有单病种信息", notes = "查询所有单病种信息")
    @GetMapping("/findAll")
    @ResponseBody
    public ResultUtil findAll() {

        try {
            List<SdInfo> sdInfos = sdInfoService.findAllSd();
            //Map<String, Object> listPage = PageList.getListPage(pageInfo.getPageNum(), pageInfo.getPageSize(), sdInfos);
            return ResultUtil.success(sdInfos);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @GetMapping("/deleteByTpName")
    @ResponseBody
    public ResultUtil deleteByTpName(String tempname,Integer sid) {
        String str =  handle1Dao.selectSqlWithSQLStr("SELECT sd_info_tpname FROM dbo.sd_info_tp WHERE id ="+sid);
        try {
            int num=handle1Dao.deleteByTpName(str,tempname);
            return ResultUtil.success ("删除模板数据成功","success" );
        } catch (Exception e) {
            return ResultUtil.error ( "删除模板数据失败" );
        }
    }

    @ApiOperation(value = "查询所有单病种", notes = "查询所有单病种")
    @GetMapping("/findAllSdByJson")
    @ResponseBody
    public ResultUtil findAllSdByJson() {
        JSONObject jsonDate ;
        try {
            JSONObject json  = new JSONObject();
            jsonDate = FileUtil.getJsonDate("platform.json");
            jsonDate.put("listmaps",jsonDate);
            return ResultUtil.success(jsonDate.put("listmaps",json));
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }


}
