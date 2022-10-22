package com.sxdl.drplus.controller;


import cn.hutool.http.HttpRequest;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dto.ReportDBO;
import com.sxdl.drplus.dto.RevokeDBO;
import com.sxdl.drplus.entity.DrPlusDataType;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.service.DrPlusCenterTableService;
import com.sxdl.drplus.service.DrPlusDataTypeService;
import com.sxdl.drplus.service.DrPlusPlatformDetailedService;
import com.sxdl.drplus.service.DrPlusReportService;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "上报相关")
@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class DrPlusReportController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    private final DrPlusPlatformDetailedService detailedService;
    private final DrPlusCenterTableService tableService;
    private final DrPlusReportService reportService;
    private final DrPlusDataTypeService dataTypeService;


    /**
     *  查询上报明细结果
     * @param pageInfo
     * @param pid
     * @param type  0 未上报 1 已上报  -1 上报失败  2已经撤销 -2 撤销失败  9全部
     * @param val
     * @param stime   时间是上报时间
     * @param etime
     * @return
     */
    @ApiOperation(value = "查询上报明细结果")
    @GetMapping("/getReportResult")
    public ResultUtil getReportResult(PageInfo pageInfo,
                                      @RequestParam(value = "pid",required = true) Integer pid,
                                      @RequestParam(value = "type",required = true) Integer type,
                                      @RequestParam(value = "val",defaultValue = "") String val,
                                      @RequestParam(value = "stime",required = true) String stime,
                                      @RequestParam(value = "etime",required = true) String etime) {
        PageInfo listPage;
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            //这里的数据必须是已经审核过的
            listPage = PageUtil.getPageInfoData(pageInfo, tableService::getReportResult,pid,type,val,stime,etime);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }


    /**
     * key 该方法失效, 对映的上报平台已经不存在,但保留该接口
     * @param reportDBO
     * @return
     */
    @Deprecated
    @ApiOperation(value = "(作废)撤销上报数据")
    @PostMapping("/startRevokeReport")
    public ResultUtil startRevokeReport( @RequestBody ReportDBO reportDBO) {
        try {
            String PRIMAEYKEY = reportDBO.getKey();
            Integer pid = reportDBO.getPid();
            Integer iswrite = reportDBO.getIswrite();
            String path_file = detailedService.getPlatformDetailedById(pid).getPath_file();
            String PRIMAEYKEYCol =  tableService.getReportColumnByCol(pid,"PRIMAEYKEY");
            reportService.startRevokeReport(PRIMAEYKEY,pid,iswrite,PRIMAEYKEYCol, path_file);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /**
     *  5平台
     * pid              平台代码
     * key	 	        唯一主键号
     * revoke_code      流水号
     *
     *
     * @param map
     * @return
     */

    @ApiOperation(value = "撤销上报数据(一)")
    @PostMapping("/revokeReportOne")
    public ResultUtil revokeReportOne( @RequestBody Map<String ,String> map) {
        try {
            Integer pid = Integer.parseInt(map.get("pid") );
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            String key = map.get("key");
            if (5==pid){
                DrPlusPlatformDetailed platform = detailedService.getPlatformDetailedById(pid );
                Map<String,Object> reMap = new HashMap<>();
                reMap.put("APP_ID",platform.getAppid());
                reMap.put("ORG_CODE",platform.getOrgcode());
                reMap.put("YLJGDM",platform.getOrgcode());
                reMap.put("QDLSH",map.get("revoke_code"));
                String requestBody= HttpRequest.post(platform.getObsolete_url())
                        .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                        .header("Accept", "application/json; charset=UTF-8").form(reMap).execute().body();
                JSONObject json =  JSONObject.fromObject(requestBody);
                DrPlusDataType dataType = dataTypeService.getDatabyBah(pid, key);
                String msg = json.getString("MESSAGE");
                if ("200".equals(json.getString("CODE") ) ){
                    dataType.setReport_type(2)
                    .setRevoke_time(DataUtil.getDateTime())
                    .setRevoke_content(msg);
                    Integer update = dataTypeService.update(dataType);
                }else if("201".equals(json.getString("CODE") ) ){
                    dataType.setReport_type(-2)
                    .setRevoke_time(DataUtil.getDateTime())
                    .setRevoke_content(msg);
                    Integer update = dataTypeService.update(dataType);
                    return  ResultUtil.error(json.getString("MESSAGE"),"撤销失败");
                }
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }


    /***
     *  pid
     *  eid
     * @param map
     * @return
     */
    @ApiOperation(value = "撤销上报数据(多)")
    @PostMapping("/revokeReportByEid")
    public ResultUtil revokeReportByEid( @RequestBody Map<String ,String> map) {
        try {
            Integer pid = Integer.parseInt(map.get("pid") );
            Integer eid = Integer.parseInt(map.get("eid") );

            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }


            if (5==pid){
                List<RevokeDBO> revokeCodes = dataTypeService.getRevokeCodes(pid, eid);
                for (RevokeDBO revokeCode : revokeCodes) {
                    DrPlusPlatformDetailed platform = detailedService.getPlatformDetailedById(pid );
                    Map<String,Object> reMap = new HashMap<>();
                    reMap.put("APP_ID",platform.getAppid());
                    reMap.put("ORG_CODE",platform.getOrgcode());
                    reMap.put("YLJGDM",platform.getOrgcode());
                    reMap.put("QDLSH",revokeCode.getRevoke_code());
                    String requestBody= HttpRequest.post(platform.getObsolete_url())
                            .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                            .header("Accept", "application/json; charset=UTF-8").form(reMap).execute().body();
                    JSONObject json =  JSONObject.fromObject(requestBody);
                    DrPlusDataType dataType = dataTypeService.getDatabyBah(pid, revokeCode.getRevoke_key());
                    String msg = json.getString("MESSAGE");
                    if ("200".equals(json.getString("CODE") ) ){
                        dataType.setReport_type(2)
                                .setRevoke_time(DataUtil.getDateTime())
                                .setRevoke_content(msg);
                        Integer update = dataTypeService.update(dataType);
                    }else if("201".equals(json.getString("CODE") ) ){
                        dataType.setReport_type(-2)
                                .setRevoke_time(DataUtil.getDateTime())
                                .setRevoke_content(msg);
                        Integer update = dataTypeService.update(dataType);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    @ApiOperation(value = "正式手动上报数据")
    @PostMapping("/getStartReport")
    public ResultUtil getStartReport(@RequestBody ReportDBO reportDBO) {
        try {
            Integer pid =reportDBO.getPid();
            Integer eid = reportDBO.getEid();
            Integer iswrite = reportDBO.getIswrite();

            DrPlusPlatformDetailed platform = detailedService.findById(pid);
            if(StringUtils.isEmpty(platform.getToken()) && ( pid ==10 || pid ==15)){
                return ResultUtil.error("您未签到不能上报数据");
            }

            //key  第一步 获取主键 上报时候的 名称 若没有则为 空字符串 也代表不上报该字段
            String PRIMAEYKEYCol = "";
            if( pid !=10 || pid !=15){
                PRIMAEYKEYCol  =  tableService.getReportColumnByCol(pid,"PRIMAEYKEY");
            }

            System.out.println("******第二步");
            //key 第二步 准备数据-->将要上报的数据封装到集合中 (里面一定有主键字段)
            List<LinkedHashMap<String ,Object>> list  = reportService.getReadyReportData(pid, eid);

            //key 第三步 上报核心代码
            System.out.println("******第三步");
            reportService.startReport(list,pid,iswrite ,PRIMAEYKEYCol );

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE );
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    /**
     R_URL       注册地址
     CLINET_IP	 注册认证机构IP
     ORG_CODE	 机构代码
     ORG_NAME	 机构名称
     ORG_TYPE	 参考数据字典：机构类型
     CONTACTS	 联系人
     ADDRESS	 机构地址
     PHONE	     联系电话
     REG_CODE	 注册码（金豆提供）
     * @return
     */
    @ApiOperation(value = "机构注册APP_ID")
    @PostMapping("/registerCode")
    public ResultUtil registerCode(@RequestBody Map<String,Object > map) {
        String APP_ID =null;
        try {
            String url = map.get("R_URL").toString();
            map.keySet().removeIf("R_URL"::equals);
            String requestBody= HttpRequest.post(url)
                    .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                    .header("Accept", "application/json; charset=UTF-8").form(map).execute().body();
            JSONObject json =  JSONObject.fromObject(requestBody);

            if ("200".equals(json.getString("CODE") ) ){
                APP_ID = json.getJSONObject("DATA").getString("APP_ID");
            }else if("400".equals(json.getString("CODE") ) ){
                return  ResultUtil.error(json.getString("MESSAGE"),"注册失败");
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success( APP_ID,DataUtil.SUCCESS_MASSAGE );
    }


    /**
     * 10 平台
     * @return
     */
    @ApiOperation(value = "平台签到")
    @PostMapping("/getSignIn")
    public ResultUtil getSignIn( @RequestParam(value = "pid",required = true) Integer pid) {
        try {

            DrPlusPlatformDetailed platform = detailedService.findById(pid);
            String report_url = platform.getReport_url();
            String reportname = platform.getReportname();
            //公钥
            String key = platform.getAppid();

            //key  准备数据--> signIn 中的签到数据
            JSONObject signInJson  = reportService.getSignIn(reportname,key,pid);

            String sign_no = reportService.startSignIn(signInJson,report_url,key,pid);
            //将数据放到缓存中
            if(StringUtils.isEmpty(sign_no))
                return  ResultUtil.error("获取签到编码为空,可以尝试再次签到或者签退");
            platform.setToken(sign_no); // 签到
            Integer integer = detailedService.saveSimple(platform);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error("由于省平台特殊原因问题,签到失败,可以尝试再次签到或者签退");
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }




    @ApiOperation(value = "平台签退")
    @PostMapping("/getSignOut")
    public ResultUtil getSignOut(@RequestParam(value = "pid",required = true) Integer pid) {
        try {
            DrPlusPlatformDetailed platform = detailedService.findById(pid);
            String key = platform.getAppid(); //公钥
            //key  准备数据--> signIn 中的签到数据
            JSONObject signOutJson  = reportService.getSignOut(platform.getToken(),platform.getReportname(),key,pid);
            //key 上报核心代码
            String sign_no = reportService.startSignOut(signOutJson,platform.getReport_url(),key);
            if(StringUtils.isEmpty(sign_no))
                return  ResultUtil.error("省平台返回签退时间为空,可能有误");
            platform.setToken(null);
            Integer integer = detailedService.saveSimple(platform);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error("由于省平台特殊原因问题,签退失败,可以尝试再次签到或者签退");
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }











}
