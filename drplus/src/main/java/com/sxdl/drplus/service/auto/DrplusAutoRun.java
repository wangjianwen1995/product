package com.sxdl.drplus.service.auto;

import com.sxdl.drplus.dto.DrQualityDBO;
import com.sxdl.drplus.entity.DrPlusExtractDetailed;
import com.sxdl.drplus.entity.DrPlusPlatformDetailed;
import com.sxdl.drplus.service.*;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DrplusAutoRun {

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private final DrPlusPlatformDetailedService sheduledService;

    private final DrPlusCenterTableService centerTableService;

    private final DrPlusExtractDetailedService extractDetailedService;

    private final DrPlusControlResultService resultService;

    private final DrPlusDataTypeService dataTypeService;

    private final DrplusSsicdMapService ssicdMapService;

    private final DrplusJbicdMapService jbicdMapService;

    private final DrPlusReportService reportService;




    @Transactional
    public void drplusScheduled(Integer pid,String startDate,String endDate  ){
        try {
            autoScheduled(pid , startDate , endDate  );
        } catch (Exception e) {
            logger.error("自动调度报错日志:"+e.getMessage());
        }
        return;
    }


    void autoScheduled(Integer pid ,String startDate ,String endDate ){
        DrPlusPlatformDetailed detailed = sheduledService.selectByKey(pid);
        Integer extract_id = null;
        if(1==detailed.getIs_autoextract()){
            //key  执行[抽取]
            extract_id = autoExtract(detailed, startDate, endDate);
        }
        if(1==detailed.getIs_autocode()){
            //key 执行编码转换
            autoCode(detailed,extract_id);
        }
        if(1==detailed.getIs_autoreview()){
            //key 执行[质控],[审核]
            autoReview( extract_id, detailed, "CQSJ" , startDate, endDate);
        }
        if(1==detailed.getIs_autoreport()){

            //key 执行[上报]
            autoReport(detailed.getId(), extract_id);
        }

    }

    void autoCode(DrPlusPlatformDetailed detailed,Integer extractId) {
        try {
            Integer leftSsId = detailed.getCurrent_ss_version_id();
            Integer rightSsId = detailed.getAsk_ss_version_id();
            Integer leftJbId = detailed.getCurrent_jb_version_id();
            Integer rightJbId = detailed.getAsk_jb_version_id();
            Integer pid = detailed.getId();


            if(ssicdMapService.getCount(leftSsId,rightSsId)>0   ){
                if(leftSsId!=rightSsId){
                    if(2==pid || 3==pid){
                        ssicdMapService.transformationICD3(pid,extractId,leftSsId,rightSsId);
                    }else if(5==pid){
                        ssicdMapService.transformationICD5(pid,extractId,leftSsId,rightSsId);
                    }else if(6==pid){
                        ssicdMapService.transformationICD6(pid,extractId,leftSsId,rightSsId);
                    }else if(7==pid){
                        ssicdMapService.transformationICD7(pid,extractId,leftSsId,rightSsId);
                    }else if(8==pid){
                        ssicdMapService.transformationICD8(pid,extractId,leftSsId,rightSsId);
                    }else if(9==pid){
                        ssicdMapService.transformationICD9(pid,extractId,leftSsId,rightSsId);
                    }else if(10==pid){
                        ssicdMapService.transformationICD10(pid,extractId,leftSsId,rightSsId);
                    }
                }
            }

            if(jbicdMapService.getCount(leftJbId,rightJbId)>0){
                if(leftJbId!=rightJbId){
                    if(2==pid || 3==pid){
                        jbicdMapService.transformationICD3(pid,extractId,leftJbId,rightJbId);
                    }else if(5==pid){
                        jbicdMapService.transformationICD5(pid,extractId,leftJbId,rightJbId);
                    }else if(6==pid){
                        jbicdMapService.transformationICD6(pid,extractId,leftJbId,rightJbId);
                    }else if(7==pid){
                        jbicdMapService.transformationICD7(pid,extractId,leftJbId,rightJbId);
                    }else if(8==pid){
                        jbicdMapService.transformationICD8(pid,extractId,leftJbId,rightJbId);
                    }else if(9==pid){
                        jbicdMapService.transformationICD9(pid,extractId,leftJbId,rightJbId);
                    }else if(10==pid){
                        jbicdMapService.transformationICD10(pid,extractId,leftJbId,rightJbId);
                    }
                }
            }

        } catch (Exception e) {
            logger.error("自动转码报错日志:"+e.getMessage());
        }
    }



    public void autoReport(Integer pid, Integer eid) {
        try {
            //key 准备重要字段
            String BAHCol =  centerTableService.getReportColumnByCol(pid,"PRIMAEYKEY");
            //key 第二步 准备数据-->将要上报的数据封装到集合中
            List<LinkedHashMap<String ,Object>> list =  reportService.getReadyReportData(pid, eid);
            //key 第三步 上报核心代码
            reportService.startReport(list,pid,0 ,BAHCol );
        } catch (Exception e) {
            logger.error("自动上报报错日志:"+e.getMessage());
        }
    }






    /**
     *  执行[质控],[审核]
     * @param extract_id
     * @param detailed
     * @param timeCol
     * @param startDate
     * @param endDate
     */
    void autoReview(Integer extract_id,DrPlusPlatformDetailed detailed,String timeCol ,String startDate,String endDate) {
        try {

            List<String> list = null;
            if(6==detailed.getId()||7==detailed.getId()){
                //质控数据
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableAdd(detailed.getId(), extract_id);
                resultService.qualityByListAdd(extract_id,detailed.getId(),drQualityDBOS);
                //审核 本次抽取 数据
                list = resultService.getPassDataAutoAdd(detailed.getId(),extract_id,  timeCol, startDate, endDate);
            }else if(10==detailed.getId()){
                //删除 整理数据
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOnetoMany10(detailed.getId(), extract_id);
                //插入数据
                resultService.qualityByListOnetoMany(extract_id,detailed.getId(),drQualityDBOS);
            }else if(15==detailed.getId()){
                //删除 整理数据
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTableOnetoMany15(detailed.getId(), extract_id);
                //插入数据
                resultService.qualityByListOnetoMany(extract_id,detailed.getId(),drQualityDBOS);
            }else{
                //质控数据
                List<DrQualityDBO> drQualityDBOS = resultService.truncateTable(detailed.getId(), extract_id);
                resultService.qualityByList(extract_id,detailed.getId(),drQualityDBOS);
                //审核 本次抽取 数据
                list = resultService.getPassDataAuto(detailed.getId(),extract_id,  timeCol, startDate, endDate);
            }
            for (String bah : list) {
                dataTypeService.startFirstReview(detailed.getId(),bah,"程序自动审核",1);
            }
        } catch (Exception e) {
            logger.error("自动质控+审核报错日志:"+e.getMessage());
        }

    }

    /**
     * 数据抽取核心方法
     * @param detailed
     * @param startDate
     * @param endDate
     */
    Integer autoExtract(DrPlusPlatformDetailed detailed,String startDate,String endDate){
        DrPlusExtractDetailed extractDetailed   = extractDetailedService.insertData(detailed.getId(),startDate,endDate,1,2);
        try {
            //创建一条新的抽取记录获取到 抽取id
            Integer successNum = 0;
            if(6==detailed.getId()||7==detailed.getId()){
                //1 拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd(extractDetailed.getId(),detailed.getId(),startDate,endDate,1);
            }else if(10==detailed.getId()){
                //  拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExecAdd10(extractDetailed.getId(),detailed.getId(),startDate,endDate,1);
            }else{
                //1 拼接好 insert intosql (这里注意处理 平台id 和抽取id 进度条问题)执行 这里是抽取数据核心方法
                centerTableService.createInsertIntoSqlAndExec(extractDetailed.getId(),detailed.getId(),startDate,endDate,1);
            }
            extractDetailedService.setConfig(extractDetailed.getId(),detailed.getId());
        } catch (Exception e) {
            logger.error("自动抽取报错日志: "+e);
            Integer update = extractDetailedService.updateSqlWithSQL("update drplus_extract_detailed set  state=-1 where id = "+detailed.getId());
        }
        return  extractDetailed.getId();
    }

}
