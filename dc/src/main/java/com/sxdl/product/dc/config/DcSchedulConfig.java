//package com.sxdl.product.dc.config;
//
//import com.sxdl.base.config.SchedulConfig;
//import com.sxdl.base.dao.dao1.SysLogDao;
//import com.sxdl.base.entity.SchedulEntity;
//import com.sxdl.base.util.StringUtil;
//import com.sxdl.product.dc.controller.DcProcedureController;
//import com.sxdl.product.dc.controller.DcRequestAPIController;
//import com.sxdl.product.dc.entity.DcEtlLog;
//import com.sxdl.product.dc.entity.DcSchedule;
//import com.sxdl.product.dc.service.DcEtlLogService;
//import com.sxdl.product.dc.service.DcScheduleService;
//import com.sxdl.product.dc.service.HandleSerice;
//import com.sxdl.product.dc.util.WebSoapUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@Configuration
//@EnableScheduling
//public class DcSchedulConfig extends SchedulConfig {
//
//    @Autowired
//    DcRequestAPIController dcRequestAPIController;
//    @Autowired
//    DcProcedureController dcProcedureController;
//    Map<Integer, List<DcSchedule>> map;
//    @Autowired
//    HttpServletRequest request;
//    private SchedulEntity schedulEntity;
//    @Autowired
//    private DcScheduleService dcScheduleService;
//    @Autowired
//    private SysLogDao sysLogDao;
//    @Autowired
//    private DcEtlLogService dcEtlLogService;
//    @Autowired
//    private HandleSerice handleSerice;
//    private DcSchedule dcSchedule;
//    private List<DcSchedule> dcSchedules, webs, todcs, fromdcs;
//    private String info, pname, startTime, endTime, resultS;
//    private String sql = "IF  EXISTS ( SELECT name FROM dbo.sysobjects WHERE id = object_id( '[@@@]' ) AND OBJECTPROPERTY( id, 'IsProcedure' ) = 1 )\n" +
//            "   select 1\n" +
//            "else\n" +
//            "   select 2 ";
//
//    public void run(SchedulEntity se) {
//        try {
//            if (null == se || null == se.getIsSys()) {
//                return;
//            }
//            if (se.getIsSys() == 0) {
//                info = se.getInfo();
//                dcSchedule = new DcSchedule();
//                dcSchedule.setStatus(1);//已经开启使用的
//                dcSchedule.setRule_id(Integer.parseInt(info));//本次调度相关的
//                dcSchedules = dcScheduleService.select(dcSchedule);
//                if (null == dcSchedules || dcSchedules.isEmpty()) {
////                System.out.println("没有找到,或者没有开启相关调度任务~");
//                    return;
//                }
//                dcSchedules.forEach(e -> {
//                    if (null == e.getOrdernum()) {
//                        e.setOrdernum(0);
//                    }
//                });
//                dcSchedules.sort(Comparator.comparing(DcSchedule::getOrdernum));
//                map = dcSchedules.stream().parallel().filter(e -> null != e && null != e.getType_id()).collect(Collectors.groupingBy(e -> e.getType_id()));
//                long s = System.currentTimeMillis(), e;
//                if (map.containsKey(1)) {
//                    webs = map.get(1);
//                    dcRequestAPIController.saveAutoEverySql(webs);
//                }
//                if (map.containsKey(2)) {
//                    todcs = map.get(2);
//                    for (DcSchedule ds : todcs) {
//                        if (exPro(ds)) continue;
//                    }
//                }
//                if (map.containsKey(3)) {
//                    fromdcs = map.get(3);
//                    for (DcSchedule ds : fromdcs) {
//                        if (exPro(ds)) continue;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    //执行存储过程前先查询是否存在,如果不存在则不处理
//    public boolean exPro(DcSchedule ds) throws Exception {
//
//        pname = ds.getProcedure_name();
//        resultS = handleSerice.selecsql(sql.replace("@@@", pname));
//        if (StringUtil.isEmpty(resultS) || resultS.equals("2")) {
//            return true;
//        }
//        Integer scope = ds.getScope();
//        if (null == scope || scope <= 0) {
//            scope = 1;
//        }
//        startTime = WebSoapUtil.getAutoStartTiem(10, scope);
//        endTime = WebSoapUtil.getAutoEndDateTime(10);
//        Integer param = ds.getParam();
//        String isyc = "";
//        long beginTime = System.currentTimeMillis(), end;
//        DcEtlLog etlLog = new DcEtlLog();
//        etlLog.setStartTime(beginTime + "");
//        etlLog.setScheduleId(ds.getId());
//        etlLog.setScheduleRuleId(ds.getRule_id());
//        etlLog.setScheduleRuleSffix(ds.getRule_suffix());
//        dcEtlLogService.insert(etlLog);
//
//        StringBuilder sb = new StringBuilder("exec ");
//        sb.append(ds.getProcedure_name()).append(" ");
//
//        switch (param) {
//            case 1:
//                //时间段
//                isyc = "该存储有参数，参数为时间段：" + startTime + "&" + endTime;
//                sb.append("'" + startTime).append("','").append(endTime + "'");
//                break;
//            case 2:
//                //
//                isyc = "该存储有参数，参数为单个参数：";
//                break;
//            case 3:
//                // 无参
//                isyc = "该存储无参数";
//                break;
//            default:
//                break;
//        }
//        try {
//            List<Map<String, Object>> s = handleSerice.selectSqlWithSQL(sb.toString());
//            etlLog.setStatus(2);
//            end = System.currentTimeMillis();
//            etlLog.setEndTime(end + "");
//            end -= beginTime;
//            etlLog.setDuration(end + "");
//            etlLog.setContent(s.toString());
//            dcEtlLogService.update(etlLog);
//        } catch (Exception e) {
//            etlLog.setStatus(3);
//            end = System.currentTimeMillis();
//            etlLog.setEndTime(end + "");
//            end -= beginTime;
//            etlLog.setDuration(end + "");
//            etlLog.setContent(ds.getName() + ",存储名称是: " + pname + "运行出错！错误原因：" + e.getCause() + ";" + isyc);
//            dcEtlLogService.update(etlLog);
//            return false;
//        }
//        return false;
//    }
//
//
//    //    @Scheduled(cron = "0 0/2 * * * ?")
//    public void everyfiveSenced() {
//        schedulEntity = new SchedulEntity();
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("5");
//        run(schedulEntity);
//    }
//
//    @Scheduled(cron = "0 0/30 * * * ?")
//    public void everyThirtyMinutes() {
//        schedulEntity = new SchedulEntity();
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("2");
//        run(schedulEntity);
//    }
//
//    @Scheduled(cron = "0 0 0 */1 * ?")
//    public void everyDay() {
//        schedulEntity = new SchedulEntity();
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("5");
//        run(schedulEntity);
//    }
//
//    @Scheduled(cron = "0 0 0 ? * MON")
//    public void everyWeek() {
//        schedulEntity = new SchedulEntity();
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("6");
//        run(schedulEntity);
//    }
//
//    @Scheduled(cron = "0 0 0 1 */1 ?")
//    public void everyMonth() {
//        schedulEntity = new SchedulEntity();
//        schedulEntity.setIsSys(0);
//        schedulEntity.setInfo("7");
//        run(schedulEntity);
//    }
//
//
////    public void saveAutoEveryJava3(DcSchedule dcSchedule) {
////        List<DcProcedure> dcProcedureList = dcProcedureService.findByScheduleId(dcSchedule.getId());
////        if (dcProcedureList.size() > 0 && dcProcedureList != null) {
////            if (dcProcedureList.size() > 1) {
////                List<DcProcedure> newdcProcedureList = reloadDcProcedure(dcProcedureList, dcSchedule.getType());
////                for (DcProcedure dcProcedure : newdcProcedureList) {
////                    if (dcProcedure.getIsparam().equals(1)) {
////                        handleParamAndExec(dcSchedule, dcProcedure);
////                    } else {
////                        handleDao.excuteCallProcedue(dcProcedure.getName());
////                    }
////                }
////            }
////        }
////    }
////
////    private List<DcProcedure> reloadDcProcedure(List<DcProcedure> dcProcedureList, String type) {
////        if (type.equals("transfer")) {
////            dcProcedureList = dcProcedureList.stream().filter(e -> null != e && !e.getType_id().equals(1)).collect(Collectors.toList());
////            return dcProcedureList;
////        }
////        return dcProcedureList;
////    }
////
////    private void handleParamAndExec(DcSchedule dcSchedule, DcProcedure dcProcedure) {
////        String param_unit = dcSchedule.getParam_unit();
////        Integer param = dcSchedule.getParam();
////        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        Date date = new Date();
////        Calendar instance = Calendar.getInstance();
////        instance.setTime(date);
////        switch (param_unit) {
////            case "分":
////                instance.add(Calendar.MINUTE, -param);
////                break;
////            case "天":
////                instance.add(Calendar.DAY_OF_YEAR, -param);
////                break;
////            case "周":
////                instance.add(Calendar.WEEK_OF_YEAR, -param);
////                break;
////            case "月":
////                instance.add(Calendar.MONTH, -param);
////                break;
////        }
////        String startTime = myFmt.format(instance.getTime());
////        String endTime = myFmt.format(date);
////        handleDao.excuteCallProcedueWithParams(dcProcedure.getName(), startTime, endTime);
////    }
//}
