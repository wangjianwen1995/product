package com.sxdl.product.dc.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.sxdl.base.config.SchedulConfig;
import com.sxdl.base.entity.SchedulEntity;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.controller.DcProcedureController;
import com.sxdl.product.dc.dao.dao1.DcTableDao;
import com.sxdl.product.dc.dbo.ErrorLogDBO;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.*;
import com.sxdl.product.dc.service.impl.DcRequestAPIServiceImpl;
import com.sxdl.product.dc.util.WebSoapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
public class DcEtlSchedulConfig extends SchedulConfig {

    @Autowired
    DcRequestAPIServiceImpl dcRequestAPIService;
    @Autowired
    DcProcedureController dcProcedureController;
    Map<Integer, List<DcScheduleConfig>> map;
    @Autowired
    HttpServletRequest request;
    private SchedulEntity schedulEntity;
    @Autowired
    private DcScheduleConfigService dcScheduleConfigService;

    @Autowired
    DcProcedureService dcProcedureService;

    @Autowired
    DcWarningService dcWarningService;

    @Autowired
    private DcTableDao dcTableDao;

    @Autowired
    private DcEtlLogService dcEtlLogService;
    @Autowired
    private HandleSerice handleSerice;
    private DcScheduleConfig dcScheduleConfig;
    private List<DcScheduleConfig> dcScheduleConfigs, webs, todcs, fromdcs;
    private List<ErrorLogDBO> errList;
    private Integer batch;
    private Boolean issucc=true;
    private String info, pname, startTime, endTime, resultS;
    private String sql = "IF  EXISTS ( SELECT name FROM dbo.sysobjects WHERE id = object_id( '[@@@]' ) AND OBJECTPROPERTY( id, 'IsProcedure' ) = 1 )\n" +
            "   select 1\n" +
            "else\n" +
            "   select 2 ";

    public void run(SchedulEntity se) {
        try {
            errList=new ArrayList<>();
            //每次进调度更新当前的批次信息   批次信息生成规则为每天重置1
            String batchsql="select MAX(batch) batch from dc_etl_log \n" +
                    "where convert(varchar,convert(datetime,start_time, 20),23) =convert(varchar,GETDATE(),23)";
            List<Map<String, Object>> maps = dcScheduleConfigService.selectSqlWithSQL(batchsql);
            if(null!=maps.get(0)){
                batch=Integer.parseInt(maps.get(0).get("batch").toString())+1;
            }else{
                batch=1;
            }

            if (null == se || null == se.getIsSys()) {
                return;
            }
            if (se.getIsSys() == 0) {
                //获取当前的调度规则
                info = se.getInfo();
                //查询当前时间应该执行的调度配置
                dcScheduleConfigs = dcScheduleConfigService.selectCanAutoRun(info);
                if (null == dcScheduleConfigs || dcScheduleConfigs.isEmpty()) {
                    System.out.println("没有找到相关调度任务~");
                    return;
                }
                //遍历配置 为序号是null的设置序号
                dcScheduleConfigs.forEach(e -> {
                    if (null == e.getOrdernum()) {
                        e.setOrdernum(0);
                    }
                });

                //去重
                dcScheduleConfigs = dcScheduleConfigs.stream().filter(e -> null != e && null != e.getType_id() && e.getType_id() != 0).collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<DcScheduleConfig>
                        (Comparator.comparing(DcScheduleConfig::getProcedure_id))), ArrayList::new));
                //排序
                dcScheduleConfigs.sort(Comparator.comparing(DcScheduleConfig::getOrdernum));
                //根据存储和web 分组
                map = dcScheduleConfigs.stream().parallel().filter(e -> null != e && null != e.getType_id() && e.getType_id() != 0).collect(Collectors.groupingBy(e -> e.getType_id()));
                long s = System.currentTimeMillis(), e;
                if (map.containsKey(1)) {
                    webs = map.get(1);
                    dcRequestAPIService.saveAutoEverySql1(webs);
                }
                if (map.containsKey(2)) {
                    todcs = map.get(2);
                    ErrorLogDBO list = new ErrorLogDBO();
                    for (DcScheduleConfig ds : todcs) {
                        //判断 当前存储有无前置存储
                        if(StringUtil.isNotEmpty(ds.getPrent_procedure_id())){
                            //如果有，判断先决条件是否已经执行并且成功
                            if (StringUtil.isNotEmpty(ds.getPrent_procedure_id())) {
                                Boolean is_exec = dcEtlLogService.selectByPro(ds.getPrent_procedure_id(),batch.toString());
                                if(!is_exec){
                                    list.setE(ds);
                                    errList.add(list);
                                    continue;
                                }else{
                                    //运行存储  有问题加入errList
                                    exPro(ds);
                                    if (!issucc){
                                        list.setE(ds);
                                        errList.add(list);
                                    }
                                }
                            }
                        }
                        else{
                            //直接运行当前存储
                            exPro(ds);
                            if (!issucc){
                                list=new ErrorLogDBO();
                                list.setE(ds);
                                errList.add(list);
                            }
                        }
                        //判断是否是循环的最后一次
                        if(todcs.size()-1==todcs.lastIndexOf(ds)){
                            System.out.println("执行完成！");
                            //重新执行下错误的存储 errList
                            Iterator<ErrorLogDBO> it = errList.iterator();
                            //for (ErrorLogDBO errorLogDBO : errList) {
                            while(it.hasNext()) {
                                ErrorLogDBO errorLogDBO = it.next();
                                ds=errorLogDBO.getE();
                                if(StringUtil.isNotEmpty(errorLogDBO.getE().getPrent_procedure_id())){
                                    //如果有，判断先决条件是否已经执行并且成功
                                    if (StringUtil.isNotEmpty(ds.getPrent_procedure_id())) {
                                        Boolean is_exec = dcEtlLogService.selectByPro(ds.getPrent_procedure_id(),batch.toString());
                                        if(is_exec){
                                            //执行存储  成功移除当前列表中的错误信息
                                            exPro(ds);
                                            if (issucc){
                                                it.remove();
                                                continue;
                                            }
                                        }
                                    }

                                }
                                else{
                                    //执行存储  成功移除当前列表中的错误信息
                                    exPro(ds);
                                    if (issucc){
                                        it.remove();
                                        continue;
                                    }
                                }
                            }
                        }
                        continue;
                    }

                }
                if (map.containsKey(3)) {
                    fromdcs = map.get(3);
                    for (DcScheduleConfig ds : fromdcs) {
                        if (exPro(ds)) continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //执行存储过程前先查询是否存在,如果不存在则不处理
    public boolean exPro(DcScheduleConfig ds) throws Exception {

        pname = ds.getProcedure_name();
        DcProcedure dp = dcProcedureService.findById(ds.getProcedure_id());
        resultS = handleSerice.selecsql(sql.replace("@@@", pname));
        if (StringUtil.isEmpty(resultS) || resultS.equals("2")) {
            issucc=false;
            return true;
        }


        Integer scope = ds.getScope();
        if (null == scope || scope <= 0) {
            scope = 1;
        }
        startTime = WebSoapUtil.getAutoStartTiem(10, scope);
        endTime = WebSoapUtil.getAutoEndDateTime(10);
        Integer param = dp.getIsparam();
        String isyc = "";

        long begin = System.currentTimeMillis(), end;
        String beginTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
        DcEtlLog etlLog = new DcEtlLog();
        etlLog.setStartTime(beginTime);
        etlLog.setScheduleId(ds.getId());
        etlLog.setScheduleRuleId(Integer.parseInt(ds.getRule_id()));
        etlLog.setScheduleRuleSffix(ds.getRule_suffix());
        etlLog.setExecId(ds.getProcedure_id());
        etlLog.setEtlnum(0);
        etlLog.setBatch(batch);
        dcEtlLogService.insert(etlLog);

        StringBuilder sb = new StringBuilder("exec ");
        sb.append(ds.getProcedure_name()).append(" ");

        switch (param) {
            case 1:
                //时间段
                isyc = "该存储有参数，参数为时间段：" + startTime + "&" + endTime;
                sb.append("'" + startTime).append("','").append(endTime + "'");
                break;
            case 2:
                //
                isyc = "该存储有参数，参数为单个参数：";
                break;
            case 3:
                // 无参
                isyc = "该存储无参数";
                break;
            default:
                break;
        }
        try {

            //判断存储是自定义存储，或者固定生成的dl_ks--sys_ks存储 跳过预警功能
            if(2==dp.getProc_type() || pname.contains("sys_ks")){
                List<Map<String, Object>> s = handleSerice.selectSqlWithSQL(sb.toString());

                end = System.currentTimeMillis();
                String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                etlLog.setEndTime(endTime);
                end -= begin;
                etlLog.setDuration(end + "");
                etlLog.setEtlnum(0);
                etlLog.setInsnum(0);//Integer.parseInt(maps.get(0).get("num").toString())
                etlLog.setUpdanum(0);//Integer.parseInt(maps.get(1).get("num").toString())
                etlLog.setDelnum(0);//Integer.parseInt(maps.get(2).get("num").toString())
                etlLog.setStatus(2);
                etlLog.setBatch(batch);
                etlLog.setContent("自定义存储: " + pname + "运行成功！");
                dcEtlLogService.update(etlLog);
                return true;
            }

            /*******预警功能开始***************************************************/
            //判断如果包含虚拟表，则加虚拟表的转化SQL
            String xnsql="";
            String[] split = dp.getFrom_table_id().split(",");
            DcTable dcTable = new DcTable();
            for (String id : split) {
                dcTable = dcTableDao.selectByPrimaryKey(id);
                //如果查询到的表类型是虚拟表，则需要去拼接虚拟表的转化sql
                if (dcTable.getType_id() == 6) xnsql+=dcTable.getConversion_sql();
            }
            //替换行转列中的时间参数
            if(StringUtil.isNotEmpty(xnsql)) xnsql = xnsql.replace("@startDate", "'"+startTime+"'").replace("@endDate", "'"+endTime+"'");
            //获取前置sql、替换时间参数
            String presql = dp.getPresql().replace("'+@startDate+'", startTime).replace("'+@endDate+'", endTime);

            if(presql.contains("update ")) presql=presql.substring(0,presql.indexOf("update"));
            if(presql.contains("UPDATE ")) presql=presql.substring(0,presql.indexOf("UPDATE"));
            //拼接执行前置sql可以查出的本次抽取数据总数
            String cpresql = xnsql+" select count(1) from ( " + presql + " ) a";
            int thisNum = Integer.parseInt(handleSerice.selecsql(cpresql));
            //System.out.println(pname + "----本次抽取数据----" + thisNum + "条");
            //查询抽取日志表，该存储上次执行时抽取数据数量
            String str = "select top 1 etl_num  from dc_etl_log where exec_id='" + dp.getId() + "'   order by start_time desc";
            int lastNum = Integer.parseInt(dcEtlLogService.selecsql(str));
            //System.out.println(pname + "----上次抽取数据----" + lastNum + "条");
            //判断预警条件，满足则进行预警操作
            DcWarning dw = new DcWarning();
            dw.setEtltime(DateUtil.format(new Date(), "yyyy-MM-dd"));
            dw.setExec_id(dp.getId());
            dw.setProduct_id(dp.getProduct_id());
            dw.setSchedule_id(dp.getSchedule_id());
            dw.setExec_name(pname);
            //1.本次抽取数据为0条
            if (thisNum == 0) {
                dw.setWarnmessage("抽取0条数据;原因可能为接口变动、网络中断、服务噐变更原因所致");
                dw.setWarnreason("抽取0数据");
                dw.setType(1);
            }
            //增幅超过20% 增长
            else if ((lastNum - thisNum) / thisNum > 0.2) {
                dw.setWarnmessage(pname + "抽取比较上次超过20%");
                dw.setWarnreason("数据增减幅度");
                dw.setType(2);
            }
            //增幅超过20% 负增长
            else if ((lastNum - thisNum) / thisNum < -0.2) {
                dw.setWarnmessage(pname + "抽取比较上次少于20%");
                dw.setWarnreason("数据增减幅度");
                dw.setType(2);
            }

            /*******预警功能结束**************************************************/

            //判断是否支持单抽，如果支持，拼接病案号和科室参数
            if(null!=dp.getSupport_single() && "1".equals(dp.getSupport_single())){
                sb.append(",''");
            }

            /*//执行抽取日志的对比sql  抽取多少条，删除多少条，更改多少条
            String[] fpk = dp.getFrom_table_pk().split(",");
            String[] tpk = dp.getTo_table_pk().split(",");
            String fid = "";
            String tid = "";
            for (String s : fpk) {
                fid = fid + s + "+";
            }
            for (String s : tpk) {
                tid = tid + s + "+";
            }
            fid = fid.substring(0, fid.length() - 1);
            tid = tid.substring(0, tid.length() - 1);

            String sqls = "with  etlTable as ( " +
                    presql +
                    " ), tarTable as ( " +
                    "select " + tid + " id from " + dp.getTo_table_name() + //TODO joinsql
                    " where " + dp.getTo_table_time_column() + " between '" + startTime + "' and '" + endTime + "' )";
            //拼接对比插入数据的sql
            sqls += " select COUNT(*) num from etlTable where  " +
                    fid + " in ( " +
                    "select " + fid + " from etlTable " +
                    " except " +
                    "select * from tarTable) ";
            sqls += " union all ";
            //拼接对比更新数据的sql
            sqls += " select COUNT(*) num  from (select * from etlTable " +
                    "except " +
                    "select * from " + dp.getTo_table_name() +
                    " where " + dp.getTo_table_time_column() +
                    " between '" + startTime + "' and '" + endTime + "' ) result" +
                    " where " + fid + " in ( select * from tarTable ) ";
            sqls += " union all ";
            //拼接对比删除数据的sql
            sqls += " select COUNT(*) num  from tarTable where id not in (select " + fid + " from etlTable ) ";
            //System.out.println(sqls);

             List<Map<String, Object>> maps = handleSerice.selectSqlWithSQL(sqls);*/



            //List<Map<String, Object>> s = handleSerice.selectSqlWithSQL(sb.toString());
            List<Map<String, Object>> s = handleSerice.selectSqlWithSQL(sb.toString());

            if (CollUtil.isNotEmpty(s)) {
                s.forEach(e -> {
                    if (e.containsKey("状态")) {
                        Object status = e.get("状态");
                        if ("err".equals(status.toString().toLowerCase())) {
                            issucc=false;
                            etlLog.setStatus(3);
                            //errList.add();
                            etlLog.setContent("存储名称是: " + pname + "运行出错！返回消息:" + s.toString());
                        }
                        else {
                            issucc=true;
                            etlLog.setStatus(2);
                            etlLog.setContent("存储名称是: " + pname + "运行完成，返回消息:" + s.toString());
                        }
                    } else {
                        etlLog.setStatus(2);
                        etlLog.setContent("存储名称是: " + pname + "运行完成，返回消息:" + s.toString());
                    }
                });
            } else {
                etlLog.setStatus(2);
                etlLog.setContent("存储名称是: " + pname + "运行完成，返回消息:" + s.toString());
            }



            if(issucc){
                if (null != dw) dcWarningService.insert(dw);
                //如果成功 查询本次抽取数据的实际条数，如果条数与预计不符 预警消息
                String sql="";
                if(StringUtil.isNotEmpty(dp.getTo_table_time_column())){
                    sql="select count(*) ts from "+dp.getTo_table_name()+" where " + dp.getTo_table_time_column() +
                            " between '" + startTime + "' and '" + endTime  +"'";
                }else{
                    sql="select count(*) ts from "+dp.getTo_table_name();
                }

                List<Map<String, Object>> maps1 = handleSerice.selectSqlWithSQL(sql);
                int ts = Integer.parseInt(maps1.get(0).get("ts").toString());
                if(thisNum!=ts){
                    dw = new DcWarning();
                    dw.setEtltime(DateUtil.format(new Date(), "yyyy-MM-dd"));
                    dw.setExec_id(dp.getId());
                    dw.setProduct_id(dp.getProduct_id());
                    dw.setSchedule_id(dp.getSchedule_id());
                    dw.setType(3);
                    dw.setExec_name(pname);
                    dw.setWarnreason("记录完整校验");
                    dw.setWarnmessage("预计抽取["+thisNum+"]条数据，实际抽取["+ts+"]条数据。");
                }
            }
            end = System.currentTimeMillis();
            String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            etlLog.setEndTime(endTime);
            end -= begin;
            etlLog.setDuration(end + "");
            etlLog.setEtlnum(thisNum);
            etlLog.setInsnum(0);//Integer.parseInt(maps.get(0).get("num").toString())
            etlLog.setUpdanum(0);//Integer.parseInt(maps.get(1).get("num").toString())
            etlLog.setDelnum(0);//Integer.parseInt(maps.get(2).get("num").toString())
            dcEtlLogService.update(etlLog);
        } catch (Exception e) {
            etlLog.setStatus(3);
            end = System.currentTimeMillis();
            String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            etlLog.setEndTime(endTime);
            end -= begin;
            etlLog.setDuration(end + "");
            etlLog.setContent("存储名称是: " + pname + "运行出错！错误原因：" + e.getCause() + ";" + isyc);
            dcEtlLogService.update(etlLog);
            return false;
        }
        return true;
    }


    //    @Scheduled(cron = "0 0/2 * * * ?")
//    public void everyfiveSenced() {
//        schedulEntity = new SchedulEntity();
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("5");
//        run(schedulEntity);
//    }

    @Scheduled(cron = "0 0/30 * * * ?")
    public void everyThirtyMinutes() {
        schedulEntity = new SchedulEntity();
        schedulEntity.setIsSys(0);
        schedulEntity.setInfo("2");
        run(schedulEntity);
    }

    @Scheduled(cron = "0 0 0 */1 * ?")
    public void everyDay() {
        schedulEntity = new SchedulEntity();
        schedulEntity.setIsSys(0);
        schedulEntity.setInfo("5");
        run(schedulEntity);
    }

    @Scheduled(cron = "0 0 0 ? * MON")
    public void everyWeek() {
        schedulEntity = new SchedulEntity();
        schedulEntity.setIsSys(0);
        schedulEntity.setInfo("6");
        run(schedulEntity);
    }

    @Scheduled(cron = "0 0 0 1 */1 ?")
    public void everyMonth() {
        schedulEntity = new SchedulEntity();
        schedulEntity.setIsSys(0);
        schedulEntity.setInfo("7");
        run(schedulEntity);
    }

}
