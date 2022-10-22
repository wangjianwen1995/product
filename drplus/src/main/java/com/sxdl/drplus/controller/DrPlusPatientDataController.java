package com.sxdl.drplus.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dto.PatientDataDBO;
import com.sxdl.drplus.entity.DrPlusHistoryUpdate;
import com.sxdl.drplus.service.DrPlusCenterTableService;
import com.sxdl.drplus.service.DrPlusHistoryUpdateService;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "患者信息接口")
@RestController
@RequestMapping("/patient")
public class DrPlusPatientDataController {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    @Autowired
    private DrPlusCenterTableService dateService;
    @Autowired
    private DrPlusHistoryUpdateService historyUpdateService;


    /**
     *
     * @param pageInfo
     * @param pid
     * @param timeColumn
     * @param type  0 未审 1 已审 -1 审核未通过  3已上报  -3 上报失败  2 未上报   9全部
     * @param stime
     * @param etime
     * @return
     */
    @ApiOperation(value = "根据平台id 查询患者信息列表")
    @GetMapping("/getPatientByPlatformId")
    public ResultUtil getPatientByPlatformId(PageInfo pageInfo, @RequestParam(value = "pid",required = true) Integer pid,
                                             @RequestParam(value = "timeColumn",required = true) String timeColumn,
                                             @RequestParam(value = "type", defaultValue = "9") Integer type,
                                             @RequestParam(value = "stime",required = true) String stime,
                                             @RequestParam(value = "etime",required = true) String etime,
                                             @RequestParam(value = "val",defaultValue = "") String val
    ) {
        PageInfo pageInfo1 = null;
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
          /*
            key  处理 不能分页 统计的 方案
            PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize(),false);
            List<LinkedHashMap> data = dateService.getPatientByPlatformId(pid, timeColumn, stime, etime, type, val);
            PageInfo list = new PageInfo( data);
            list.setPageSize(pageInfo.getPageSize());
            list.setPageNum(pageInfo.getPageNum());
            list.setTotal(dateService.getPatientByPlatformIdCount(pid, timeColumn, stime, etime, type, val));
            listPage= list;*/


           /* List<LinkedHashMap> dataList = dateService.getPatientByPlatformId(pid, timeColumn, stime, etime, type, val);
            resultCollect =  dataList.stream().skip((pageInfo.getPageNum() - 1) * pageInfo.getPageSize()).limit(pageInfo.getPageSize()).collect(Collectors.toList());
*/
            PageUtil.setPageInfo(pageInfo);
            List<LinkedHashMap> patientByPlatformId = dateService.getPatientByPlatformId(pid, timeColumn, stime, etime, type, val);
            pageInfo1 = PageUtil.getPageInfo(patientByPlatformId, pageInfo);

        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(pageInfo1);
    }


    @ApiOperation(value = "查看单个患者的信息")
    @GetMapping("/getPatientOne")
    public ResultUtil getPatientOne(@RequestParam(value = "pid",required = true) Integer pid,
                                    @RequestParam(value = "PRIMAEYKEY",required = true) String PRIMAEYKEY) {
        Map<String,Object> map = null;
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            if(6==pid){
                map = dateService.getPatientOneAdd6(pid,PRIMAEYKEY);
            }else if(7==pid) {
                map = dateService.getPatientOneAdd7(pid,PRIMAEYKEY);
            }else if(10==pid){
                map = dateService.getPatientOneAdd10(pid,PRIMAEYKEY);
            }else if(15==pid){
                map = dateService.getPatientOneAdd15(pid,PRIMAEYKEY);
            }else{
                map = dateService.getPatientOne(pid,PRIMAEYKEY);
            }
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(map);
    }


    /**
     *  1 修改患者数据
     *  2 修改留痕
     *  3 重新 单个质控
     * @param patientDataDBO
     * @return
     */
    @ApiOperation("修改,保存历史记录+自动质控")
    @PostMapping("/savePatient")
    public ResultUtil savePatient(@RequestBody PatientDataDBO patientDataDBO){
        try {

           /* if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }*/
            dateService.saveAllData(patientDataDBO);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    @ApiOperation(value = "查看单个患者的修改历史信息")
    @GetMapping("/getPatientOneHistoryUpdate")
    public ResultUtil getPatientOneHistoryUpdate(@RequestParam(value = "pid",required = true) Integer pid,
                                    @RequestParam(value = "bah",required = true) String bah) {

        List<DrPlusHistoryUpdate> historyUpdates;
        try {
            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            historyUpdates = historyUpdateService.getPatientOneHistoryUpdate(pid,bah);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(historyUpdates);
    }


    /**
     * 提供给病案系统直接修改病案页面数据方案
     * @param pid
     * @param eid
     * @param PRIMAEYKEY
     * @return
     */
    @ApiOperation("重新抽取一个病人+自动质控")
    @GetMapping("/saveOnePatient")
    public ResultUtil saveOnePatient( @RequestParam(value = "pid") Integer pid,
                                      @RequestParam(value = "eid") Integer eid,
                                      @RequestParam(value = "PRIMAEYKEY") String PRIMAEYKEY){
        try {

            if(pid==11){
                pid = 6;
            }else if(pid==12){
                pid = 7;
            }
            dateService.saveOnePatient(pid,eid,PRIMAEYKEY);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }











}
