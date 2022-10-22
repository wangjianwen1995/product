package com.sxdl.drplus.controller;


import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.PageList;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.drplus.dto.ReportDBO;
import com.sxdl.drplus.entity.*;
import com.sxdl.drplus.service.*;
import com.sxdl.drplus.util.DataUtil;
import com.sxdl.drplus.util.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "上报相关过期 第二期全部废除")
@RestController
@RequestMapping("/reportDeprecated")
@Deprecated
public class DrPlusReportControllerDeprecated {
    Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    public static final String LineBreak = "\r\n";
    @Autowired
    private DrPlusPlatformDetailedService detailedService;

    @Autowired
    private DrPlusCenterTableService tableService;

    @Autowired
    private DrPlusHistoryReportService historyReportService;

    @Autowired
    private DrPlusDataTypeService dataTypeService;

    @Autowired
    private DrPlusReportService reportProcessService;


    /**
     *  查询上报明细结果
     * @param pageInfo
     * @param pid
     * @param type  0 未上报 1 已上报  -1 上报失败
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
        Map<String, Object> listPage;
        try {
            //这里的数据必须是已经审核过的
            List<LinkedHashMap<String,Object>> list = tableService.getReportResult(pid,type,val,stime,etime);
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }





    /**
     * @param pageInfo
     * @param pid
     * @param stime    创建时间(近似 开始上报时间)
     * @param etime
     * @return
     */
    @ApiOperation(value = "查询上报明细结果-->历史统计版")
    @GetMapping("/getHistoryReportResult")
    public ResultUtil getHistoryReportResult(PageInfo pageInfo,
                                      @RequestParam(value = "pid",required = true) Integer pid,
                                      @RequestParam(value = "stime",required = true) String stime,
                                      @RequestParam(value = "etime",required = true) String etime) {
        Map<String, Object> listPage;
        try {
            List<DrPlusHistoryReport> list = historyReportService.getHistoryReportResult(pid,stime,etime);
            listPage = PageList.getListPage(pageInfo, list);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }

    /**
     *
     * @param pageInfo
     * @param pid
     * @param historyId
     * @param type  1 实际上报数  2 上报成功数  3 上报失败数
     * @param val
     * @return
     */
    @ApiOperation(value = "上报数据下钻")
    @GetMapping("/getHistoryReportResultdrillDown")
    public ResultUtil getHistoryReportResultdrillDown(PageInfo pageInfo,
                                                      @RequestParam(value = "pid",required = true) Integer pid,
                                                      @RequestParam(value = "historyId",required = true) Integer historyId,
                                                      @RequestParam(value = "type",required = true) Integer type,
                                                      @RequestParam(value = "val",defaultValue = "") String val) {
        Map<String, Object> listPage ;
        try {
            List<DrPlusReportProcessData> dataList = reportProcessService.getHistoryReportResultdrillDown(pid,historyId,type,val);
            listPage = PageList.getListPage(pageInfo, dataList);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(listPage);
    }


    /**
     *
     * @param PRIMAEYKEY   病案号 传入案例    '1111','2222','0111'    /'111'
     * @param pid
     * @param iswrite
     * @return
     */
    @ApiOperation(value = "撤销上报数据")
    @PostMapping("/startRevokeReport")
    public ResultUtil startRevokeReport( @RequestBody ReportDBO reportDBO) {
        try {
            String PRIMAEYKEY = reportDBO.getKey();
            Integer pid = reportDBO.getPid();
            Integer iswrite = reportDBO.getIswrite();
            String path_file = detailedService.getPlatformDetailedById(pid).getPath_file();
            String PRIMAEYKEYCol =  tableService.getReportColumnByCol(pid,"PRIMAEYKEY");
            reportProcessService.startRevokeReport(PRIMAEYKEY,pid,iswrite,PRIMAEYKEYCol, path_file);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }



    Integer should_num=0 ,actual_num=0,error_num = 0;


    /**
     *
     * key 注意 这里上报任何数据必须有 PRIMAEYKEY CYSJ NAME ZYH
     * @param pid
     * @param PRIMAEYKEY   病案号 传入案例    '1111','2222','0111'    /'111'
     * @param stime
     * @param etime
     * @param key iswrite 是否输出 报文
     * @return
     */
    @ApiOperation(value = "正式手动上报数据")
    @PostMapping("/getStartReport")
    public ResultUtil getStartReport(@RequestBody ReportDBO reportDBO) {
        try {
            Integer pid =reportDBO.getPid();
            Integer eid = reportDBO.getEid();
            String PRIMAEYKEY = reportDBO.getKey();
            String stime = reportDBO.getStime();
            String etime = reportDBO.getEtime();
            Integer iswrite = reportDBO.getIswrite();
            //key 第一步 开始创建 批次历史表   没有使劲段就使用 PRIMAEYKEY 字符串链接起来  例如: '1111','2222','0111'
            DrPlusHistoryReport historyReport = saveHistoryReport(pid,PRIMAEYKEY,stime,etime,eid);

            //key 准备重要字段
            String PRIMAEYKEYCol =  tableService.getReportColumnByCol(pid,"PRIMAEYKEY");
            String CYSJCol =  tableService.getReportColumnByCol(pid,"CYSJ");
            String NAMECol =  tableService.getReportColumnByCol(pid,"NAME");
            String ZYHCol =  tableService.getReportColumnByCol(pid,"ZYH");

            //key 第二步 准备数据-->将要上报的数据封装到集合中
            List<LinkedHashMap<String ,Object>> list = getReadyReportData(pid,PRIMAEYKEY ,stime,etime,eid);

            //key 第三步 上报核心代码
            startReport(list,pid,iswrite,historyReport.getId(),PRIMAEYKEYCol,CYSJCol,NAMECol,ZYHCol,historyReport.getId());
            //key 第四部 保存计数

            historyReport.setShould_num(should_num);
            historyReport.setActual_num(actual_num);
            historyReport.setError_num(error_num);
            Integer insert = historyReportService.insert(historyReport);
        } catch (Exception e) {
            logger.error(e+LineBreak);
            return  ResultUtil.error(e.getMessage(),DataUtil.ERROR_MASSAGE);
        }
        return  ResultUtil.success(DataUtil.SUCCESS_MASSAGE);
    }

    private List<LinkedHashMap<String, Object>> getReadyReportData(Integer pid, String PRIMAEYKEY, String stime, String etime,Integer eid) {
        String sql="";
        List<DrPlusCenterTable> cols = tableService.getReportColumn(pid);
        if(!StringUtils.isEmpty(eid)){
                sql = DataUtil.getPatientDataByEid(pid,eid,cols);
        }else {
            if(!"".equals(PRIMAEYKEY)){
                String keyCol =  "PRIMAEYKEY";
                if(6==pid||7==pid){
                    sql = DataUtil.getPatientDataByBahAdd(pid,keyCol,PRIMAEYKEY,cols);
                }else {
                    sql = DataUtil.getPatientDataByBah(pid,keyCol,PRIMAEYKEY,cols);
                }
            }else{
                String timeCol = "CQSJ";
                if(6==pid||7==pid){
                    sql = DataUtil.getPatientDataByTimeAdd(pid,timeCol,stime,etime,cols);
                }else {
                    sql = DataUtil.getPatientDataByTime(pid,timeCol,stime,etime,cols);
                }

            }
        }

        List<LinkedHashMap<String ,Object>> list = tableService.getPatientData(sql);
        return list;
    }



    // 保存上报批次数据
    private DrPlusHistoryReport saveHistoryReport(Integer pid, String PRIMAEYKEY, String stime, String etime,Integer eid) {
        DrPlusHistoryReport historyReport = new DrPlusHistoryReport();
        historyReport.setCreate_time( DataUtil.getDateTime());
        if(!"".equals(PRIMAEYKEY)){
            historyReport.setKeys("主键:"+PRIMAEYKEY);
        }else {
            historyReport.setUpload_time("从"+stime+"至"+etime);
        }
        historyReport.setDrplus_platform_detailed_id(pid);
        historyReportService.insert(historyReport);
        return historyReport;
    }

    @Transactional
    public void startReport(List<LinkedHashMap<String ,Object>> list ,Integer pid,Integer iswrite,Integer reportId
                            ,String PRIMAEYKEYCol,String CYSJCol,String NAMECol,String ZYHCol,Integer history_report_id)
    {
        //开始 写util上报类
        DrPlusPlatformDetailed platform = detailedService.getPlatformDetailedById(pid);
        String starttime="";
        should_num = 0; actual_num = 0; error_num =0;
        should_num = list.size();
        if(2==pid||3==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法 这里以后可以 通过if pid 走不同的上报方法
                coreMethod3( starttime, pid, map, platform, iswrite ,PRIMAEYKEYCol,CYSJCol,NAMECol,ZYHCol,history_report_id );
            }
        }
        if(6==pid ||7==pid){
            for (LinkedHashMap<String, Object> map : list) {
                //key 核心方法 这里以后可以 通过if pid 走不同的上报方法
                coreMethod6( starttime, pid, map, platform, iswrite ,PRIMAEYKEYCol,CYSJCol,NAMECol,ZYHCol,history_report_id );
            }
        }

        // 修改 上报 条数
        Integer update = historyReportService.updateSqlWithSQL("update drplus_history_report set should_num ="+should_num+" ,actual_num="+actual_num+",error_num = "+error_num+" where id = "+reportId);
        return;
    }

    //key 核心方法
    void coreMethod6(String starttime,Integer pid,LinkedHashMap<String, Object> map,DrPlusPlatformDetailed platform,Integer iswrite
                    ,String PRIMAEYKEYCol,String CYSJCol,String NAMECol,String ZYHCol,Integer history_report_id)
    {

        starttime = DataUtil.getDateTime();
        //key  保存 上报明细的历史数据 用来实上报数据 下钻使用
        reportProcessService.insertData(pid,history_report_id,map.get(PRIMAEYKEYCol).toString(),map.get(CYSJCol).toString()
                                           ,map.get(NAMECol).toString(),map.get(ZYHCol).toString() );
        DrPlusDataType dataType = dataTypeService.getDatabyBah(pid, map.get("PRIMAEYKEY").toString());
        dataType.setReprot_time(starttime);
        try {
            JSONObject jo = RequestUtil.sendOut2(JSONObject.fromObject(map).toString(),platform.getReport_url(),platform.getContent_type(),platform.getToken(),platform.getUseragent());
            if(iswrite==1){
                logger.info("输出报文:"+JSONObject.fromObject(map));
                logger.info("输出返回值:"+jo);
            }
            String code = jo.getString("code");
            String message = jo.getString("message");
            String data = jo.getString("data");
            dataType.setReprot_code(code);
            if("1".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeService.update(dataType);
                actual_num++;
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeService.update(dataType);
                error_num++;
            }
        }catch (Exception e){
            dataType.setReprot_code("-999");
            dataType.setReport_type(-1);
            dataType.setReport_content("系统上报异常:"+e.getMessage());
            Integer update = dataTypeService.update(dataType);
            error_num++;
        }
    }


    //TODO 这里上报数据 文件这块需要加强下  回馈信息这里需要获取数据判断是否 成功,把有效数据打印到log日志中去
    void coreMethod3(String starttime,Integer pid,LinkedHashMap<String, Object> map,DrPlusPlatformDetailed platform,Integer iswrite
            ,String PRIMAEYKEYCol,String CYSJCol,String NAMECol,String ZYHCol,Integer history_report_id)
    {

        starttime = DataUtil.getDateTime();
        //key  保存 上报明细的历史数据 用来实上报数据 下钻使用
        reportProcessService.insertData(pid,history_report_id,map.get(PRIMAEYKEYCol).toString(),map.get(CYSJCol).toString()
                ,map.get(NAMECol).toString(),map.get(ZYHCol).toString() );
        DrPlusDataType dataType = dataTypeService.getDatabyBah(pid, map.get(PRIMAEYKEYCol).toString());
        dataType.setReprot_time(starttime);
        try {
            //JSONObject jo = RequestUtil.sendOut2(JSONObject.fromObject(map).toString(),platform.getReport_url(),platform.getContent_type(),platform.getToken(),platform.getUseragent());
            LinkedHashMap<String, String> stringStringMap = reportProcessService.fileDRGTemplate(map, platform.getPath_file(),platform.getFile_header(),PRIMAEYKEYCol);

            if(iswrite==1){
                logger.info("输出报文:"+JSONObject.fromObject(map));
                logger.info("输出返回值:"+stringStringMap);
            }
            String code = stringStringMap.get("code");
            String message = stringStringMap.get("message");
            String data = stringStringMap.get("data");
            dataType.setReprot_code(code);
            if("1".equals(code)){
                dataType.setReport_type(1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeService.update(dataType);
                actual_num++;
            }else{
                dataType.setReport_type(-1);
                dataType.setReport_content(message+": "+data);
                Integer update = dataTypeService.update(dataType);
                error_num++;
            }
        }catch (Exception e){
            dataType.setReport_type(-1);
            dataType.setRevoke_content("系统上报异常:"+e.getMessage());
            Integer update = dataTypeService.update(dataType);
            error_num++;
        }
    }









}
