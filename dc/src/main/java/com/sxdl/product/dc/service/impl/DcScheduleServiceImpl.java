package com.sxdl.product.dc.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.product.dc.dao.dao1.DcHospitalDao;
import com.sxdl.product.dc.dao.dao1.DcProductDao;
import com.sxdl.product.dc.dao.dao1.DcScheduleDao;
import com.sxdl.product.dc.dao.dao1.DcScheduleRuleDao;
import com.sxdl.product.dc.entity.DcProcedure;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.entity.DcSchedule;
import com.sxdl.product.dc.entity.DcScheduleRule;
import com.sxdl.product.dc.service.DcScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("dcScheduleService")
@Transactional
public class DcScheduleServiceImpl extends BaseUUIDServiceImpl<DcSchedule> implements DcScheduleService {

    @Autowired
    private DcScheduleDao dcScheduleDao;
//    @Autowired
//    CronTaskRegistrar cronTaskRegistrar;

    @Autowired
    private DcScheduleRuleDao dcScheduleRuleDao;

    @Autowired
    private DcHospitalDao dcHospitalDao;

    @Autowired
    private DcProductDao dcProductDao;


    @Override
    public void updateStatus(DcSchedule dcSchedule, Map<Object, List<DcSchedule>> map, Integer isqy) {
        dcSchedule.setStatus(isqy);
        dcScheduleDao.updateByPrimaryKey(dcSchedule);
        System.out.println(dcSchedule.getStatus());
//        removeCronTaskBydcSchedule ( map, dcSchedule );
//        addCronTaskByDcSchedules ( map, dcSchedule );
    }

    @Override
    public void updateStatus1(DcSchedule dcSchedule, Map<Object, List<DcSchedule>> map) {
        int i = dcScheduleDao.updateByPrimaryKey(dcSchedule);
        //System.out.println ( dcSchedule.getStatus () );
        //removeCronTaskBydcSchedule ( map, dcSchedule );
//        addCronTaskByDcSchedules ( map, dcSchedule );
    }

    @Override
    public void updateSchedule(String scheduleid,Integer rule_id, String Procedure_id, Integer scope, String Hospital_id,
                                 String Product_id, String webName, String tag, String type, String Procedure_name) {
        DcSchedule dcSchedule = new DcSchedule();
        dcSchedule.setId(scheduleid);
        if (StrUtil.isNotEmpty(Procedure_id)) {
            dcSchedule.setProcedure_id(Procedure_id);
            dcSchedule = dcScheduleDao.selectOne(dcSchedule);
        }
        DcScheduleRule dcScheduleRule = dcScheduleRuleDao.selectByPrimaryKey(rule_id);

        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(Product_id);

        //DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(Hospital_id);
       // String name = dcHospital.getName() + dcProduct.getShort_name_zh() + dcProduct.getVersion() + webName + dcScheduleRule.getRemark();
        String name =dcProduct.getShort_name_zh() + dcProduct.getVersion() + webName + dcScheduleRule.getRemark();

        dcSchedule.setName(name);

        dcSchedule.setValue(dcScheduleRule.getValue());
        String createTiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dcSchedule.setTime(createTiem);
        dcSchedule.setRule_id(rule_id);
        dcSchedule.setStatus(1);
        dcSchedule.setRemark(dcScheduleRule.getRemark());
        dcSchedule.setType_id(1);
        dcSchedule.setType(type);
        /*dcSchedule.setType_id(type == "todc" ? 2 : type.contains("from") ? 3 : 1);
        dcSchedule.setType(type);*/
        dcSchedule.setRule_suffix(dcScheduleRule.getSuffix());
        dcSchedule.setTag(tag);
        dcSchedule.setParam(dcScheduleRule.getParam());
        dcSchedule.setParam_unit(dcScheduleRule.getParam_unit());
        dcSchedule.setScope(scope);
        dcSchedule.setOrdernum(dcSchedule.getOrdernum());
        dcSchedule.setProcedure_name(Procedure_name);
        dcSchedule.setProduct_id(Product_id);
        dcScheduleDao.updateByPrimaryKey(dcSchedule);
    }

    @Override
    public List<Map<String, Object>> selectBySome(String name, String stime, String etime, String type, String product_id) {
        StringBuilder sb = new StringBuilder();
        sb.append("select *  from dc_schedule where 1=1 ");
        if (null != name && !name.equals("")) {
            sb.append(" and name like '%" + name + "%'");
        }
        if (null != stime && !stime.equals("") && null != etime && !etime.equals("")) {
            sb.append(" and time between  '" + stime + "' and  '" + etime + " 23:59:59'");
        }
        if (null != type && !type.equals("")) {
            sb.append(" and type = '" + type + "' ");
        }
        if (null != product_id && !"".equals(product_id)) {
            sb.append(" and product_id = '" + product_id + "' ");
        }
        List<Map<String, Object>> mapList = dcScheduleDao.selectSqlWithSQL(sb.toString());
        return mapList;
    }


    @Override
    public String createSchedule(String Procedure_id, Integer rule_id, Integer scope, String Hospital_id, String Product_id,
                                 String webName, String tag, String type, String Procedure_name) {

        DcScheduleRule dcScheduleRule = dcScheduleRuleDao.selectByPrimaryKey(rule_id);
        DcSchedule dcSchedule_product = new DcSchedule();
        dcSchedule_product.setProduct_id(Product_id);
        List<DcSchedule> dcScheduleList = dcScheduleDao.select(dcSchedule_product);
        // DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(Hospital_id);
        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(Product_id);
        DcSchedule dcSchedule = new DcSchedule();

        //DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(Hospital_id);
        //String name = dcHospital.getName() + dcProduct.getShort_name_zh() + dcProduct.getVersion() + webName + dcScheduleRule.getRemark();
        String name =  dcProduct.getShort_name_zh() + dcProduct.getVersion() + webName + dcScheduleRule.getRemark();

        dcSchedule.setName(name);
        dcSchedule.setValue(dcScheduleRule.getValue());
        String createTiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dcSchedule.setTime(createTiem);
        dcSchedule.setRule_id(rule_id);
       /* dcSchedule.setBean_name("dataTask");
        dcSchedule.setMethod_name(type+dcScheduleRule.getSuffix());*/
        dcSchedule.setStatus(1);
        dcSchedule.setRemark(dcScheduleRule.getRemark());
        dcSchedule.setType_id(type == "todc" ? 2 : type.contains("from") ? 3 : 1);
        dcSchedule.setType(type);
        dcSchedule.setRule_suffix(dcScheduleRule.getSuffix());
        dcSchedule.setTag(tag);
        dcSchedule.setParam(dcScheduleRule.getParam());
        dcSchedule.setParam_unit(dcScheduleRule.getParam_unit());
        dcSchedule.setScope(scope);
        dcSchedule.setOrdernum(null == dcScheduleList || dcScheduleList.size() <= 0 ? 1 : dcScheduleList.size() + 1);
        dcSchedule.setProcedure_name(Procedure_name);
        dcSchedule.setProduct_id(Product_id);
        dcSchedule.setProcedure_id(Procedure_id);
        dcScheduleDao.insert(dcSchedule);
        return dcSchedule.getId();
    }


    @Override
    public String createSchedule(DcProcedure entity, String type) {
        DcScheduleRule dcScheduleRule = dcScheduleRuleDao.selectByPrimaryKey(entity.getRule_id());
        DcSchedule dcSchedule_product = new DcSchedule();
        dcSchedule_product.setProduct_id(entity.getProduct_id());
        List<DcSchedule> dcScheduleList = dcScheduleDao.select(dcSchedule_product);
        // DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(Hospital_id);
        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(entity.getProduct_id());
        DcSchedule dcSchedule = new DcSchedule();

        //DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(entity.getHospital_id());
        //String name = dcHospital.getName() + dcProduct.getShort_name_zh() + dcProduct.getVersion() + entity.getName() + dcScheduleRule.getRemark();
        String name =  dcProduct.getShort_name_zh() + dcProduct.getVersion() + entity.getName() + dcScheduleRule.getRemark();

        dcSchedule.setName(name);
        dcSchedule.setValue(dcScheduleRule.getValue());
        String createTiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dcSchedule.setTime(createTiem);
        dcSchedule.setRule_id(entity.getRule_id());
       /* dcSchedule.setBean_name("dataTask");
        dcSchedule.setMethod_name(type+dcScheduleRule.getSuffix());*/
        dcSchedule.setStatus(1);
        dcSchedule.setRemark(dcScheduleRule.getRemark());
        dcSchedule.setType_id(type == "todc" ? 2 : type.contains("from") ? 3 : 1);
        dcSchedule.setType(type);
        dcSchedule.setRule_suffix(dcScheduleRule.getSuffix());
        dcSchedule.setTag(entity.getTag());
        dcSchedule.setParam(dcScheduleRule.getParam());
        dcSchedule.setParam_unit(dcScheduleRule.getParam_unit());
        dcSchedule.setScope(entity.getScope());
        dcSchedule.setOrdernum(null == dcScheduleList || dcScheduleList.size() <= 0 ? 1 : dcScheduleList.size() + 1);
        dcSchedule.setProcedure_name(entity.getName());
        dcSchedule.setProduct_id(entity.getProduct_id());
        dcSchedule.setProcedure_id(entity.getId());
        dcScheduleDao.insert(dcSchedule);
        String id = dcSchedule.getId();
        return id;
    }

    @Override
    public String updateSchedule(DcProcedure entity, String type) {
        DcScheduleRule dcScheduleRule = dcScheduleRuleDao.selectByPrimaryKey(entity.getRule_id());
        DcSchedule dcSchedule_product = new DcSchedule();
        dcSchedule_product.setProduct_id(entity.getProduct_id());
        List<DcSchedule> dcScheduleList = dcScheduleDao.select(dcSchedule_product);
        // DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(Hospital_id);
        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(entity.getProduct_id());
        DcSchedule dcSchedule_procedureID = new DcSchedule();
        //dcSchedule_procedureID.setProcedure_id(entity.getSchedule_id());
        dcSchedule_procedureID.setProcedure_id(entity.getId());
        DcSchedule dcSchedule = dcScheduleDao.selectOne(dcSchedule_procedureID);

        //DcHospital dcHospital = dcHospitalDao.selectByPrimaryKey(entity.getHospital_id());
       // String name = dcHospital.getName() + dcProduct.getShort_name_zh() + dcProduct.getVersion() + entity.getName() + dcScheduleRule.getRemark();
        String name = dcProduct.getShort_name_zh() + dcProduct.getVersion() + entity.getName() + dcScheduleRule.getRemark();

        dcSchedule.setName(name);


        dcSchedule.setValue(dcScheduleRule.getValue());
        String createTiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        dcSchedule.setTime(createTiem);
        dcSchedule.setRule_id(entity.getRule_id());
//        dcSchedule.setBean_name("dataTask");
//        dcSchedule.setMethod_name(type+dcScheduleRule.getSuffix());
        dcSchedule.setStatus(1);
        dcSchedule.setRemark(dcScheduleRule.getRemark());
//        dcSchedule.setType_id(1);
        dcSchedule.setType(type);
        dcSchedule.setRule_suffix(dcScheduleRule.getSuffix());
        dcSchedule.setTag(entity.getTag());
        if(1==entity.getIsparam()){
            dcSchedule.setParam(dcScheduleRule.getParam());
            dcSchedule.setParam_unit(dcScheduleRule.getParam_unit());
            dcSchedule.setScope(entity.getScope());
        }else if(3==entity.getIsparam()){
            dcSchedule.setParam(3);
            dcSchedule.setParam_unit(null);
            dcSchedule.setScope(null);
        }
        //TODO 缺少单个参数的方法
//        dcSchedule.setOrdernum(dcSchedule.getOrdernum());
        dcSchedule.setProcedure_name(entity.getName());
        dcSchedule.setProduct_id(entity.getId());
        dcScheduleDao.updateByPrimaryKeySelective(dcSchedule);
        return dcSchedule.getId();

    }


//    //移除
//    private void removeCronTaskBydcSchedule(Map<Object, List<DcSchedule>> map, DcSchedule dcSchedule) {
//        SchedulingRunnable task = getSchedulingRunnable1 ( map, dcSchedule );
//        //System.out.println ( "移除前任务" + task );
//        if(task!=null){
//            //当前调度移除
//            cronTaskRegistrar.removeCronTask ( task );
//            System.out.println ("移除后"+cronTaskRegistrar);
//        }
//
//    }
//
//    //加入
//    private void addCronTaskByDcSchedules(Map<Object, List<DcSchedule>> map, DcSchedule dcSchedule) {
//        SchedulingRunnable task = getSchedulingRunnable ( map, dcSchedule );
//
//        List<DcSchedule> scheduleList = new ArrayList<> ();
//        if(map.size()>0){
//            List<DcSchedule> list = map.get ( dcSchedule.getRule_id () );
//            if (dcSchedule.getStatus () !=1) {
//                scheduleList = list.stream ().filter ( e -> !e.getId () .equals(dcSchedule.getId ())  ).collect ( Collectors.toList () );
//            } else {
//                list.add ( dcSchedule );
//                scheduleList.addAll ( list );
//            }
//        } else{
//            scheduleList.add(dcSchedule);
//        }
//        map.replace ( dcSchedule.getRule_id (), scheduleList );
//
//        map.forEach ( (key, val) -> {
//            System.out.println ( "缓存更新后" + val );
//
//        } );
//        if(task!=null){
//            cronTaskRegistrar.addCronTask ( task, dcSchedule.getValue () );
//        }
//
//        if(dcSchedule.getType().equals("webApi")){
//            ApplicationRunnerImpl.contextMap.put ( "webMap",map );
//        }else{
//            ApplicationRunnerImpl.contextMap.put ( "transferMap",map );
//        }
//
//
//        //System.out.println ( "添加" + task );
//    }
//
//    private SchedulingRunnable getSchedulingRunnable(Map<Object, List<DcSchedule>> map, DcSchedule dcSchedule) {
//        List<DcSchedule> dcScheduleList = new ArrayList<> ();
//
//        SchedulingRunnable task = null;
//        if (dcSchedule.getStatus () == 1) {
//            dcScheduleList.add ( dcSchedule );
//        }
//        if(map.size()>0){
//            for (Map.Entry<Object, List<DcSchedule>> entry : map.entrySet ()) {
//                List<DcSchedule> dcSchedules = entry.getValue ();
//                for (DcSchedule schedule : dcSchedules) {
//                    if (dcSchedule.getStatus () !=1) {
//                        if (schedule.getMethod_name ().equals ( dcSchedule.getMethod_name () ) && schedule.getBean_name ().equals ( dcSchedule.getBean_name () ) && !schedule.getId ().equals ( dcSchedule.getId () )) {
//                            dcScheduleList.add ( schedule );
//                        }
//                    } else {
//                        if (schedule.getMethod_name ().equals ( dcSchedule.getMethod_name () ) && schedule.getBean_name ().equals ( dcSchedule.getBean_name () )) {
//                            dcScheduleList.add ( schedule );
//                            //dcScheduleList.add ( dcSchedule );
//                        }
//                    }
//
//                }
//            }
//        }else{
//            dcScheduleList.add(dcSchedule) ;
//        }
//
//        JSONArray ja = new JSONArray ( dcScheduleList );
//        if(dcScheduleList.size()>0){
//            DcSchedule e = dcScheduleList.get ( 0 );
//            //项目启动后动态增加调度任务
//            //System.out.println ( "新的集合" + dcScheduleList );
//            task = new SchedulingRunnable ( e.getBean_name (), e.getMethod_name (), ja );
//            return task;
//        }
//        return null;
//    }
//
//
//    private SchedulingRunnable getSchedulingRunnable1(Map<Object, List<DcSchedule>> map, DcSchedule dcSchedule) {
//        List<DcSchedule> dcScheduleList = new ArrayList<> ();
//
//        SchedulingRunnable task = null;
//        if(map.isEmpty()){
//            return task;
//        }
//            for (Map.Entry<Object, List<DcSchedule>> entry : map.entrySet ()) {
//                List<DcSchedule> dcSchedules = entry.getValue ();
//                for (DcSchedule schedule : dcSchedules) {
//                    if (schedule.getMethod_name ().equals ( dcSchedule.getMethod_name () ) && schedule.getBean_name ().equals ( dcSchedule.getBean_name () )) {
//                        dcScheduleList.add ( schedule );
//                    }
//                }
//            }
//        JSONArray ja = new JSONArray ( dcScheduleList );
//        DcSchedule e = dcScheduleList.get ( 0 );
//        //项目启动后动态增加调度任务
//        //System.out.println ( "新的集合" + dcScheduleList );
//        task = new SchedulingRunnable ( e.getBean_name (), e.getMethod_name (), ja );
//        return task;
//    }


}
