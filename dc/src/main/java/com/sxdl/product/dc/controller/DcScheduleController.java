package com.sxdl.product.dc.controller;


import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.product.dc.dao.dao1.DcRequestAPIDao;
import com.sxdl.product.dc.dao.dao1.DcScheduleDao;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 */

@Api(tags = "调度接口")
@RestController
@RequestMapping("/schedule")
public class DcScheduleController {
    @Autowired
    private DcScheduleDao dcScheduleDao;
    @Autowired
    private DcRequestAPIDao dcRequestAPIDao;
    @Autowired
    private DcScheduleService dcScheduleService;
    @Autowired
    private DcRequestAPIService dcRequestAPIService;
    @Autowired
    private DcScheduleRuleService dcScheduleRuleService;
    @Autowired
    private DcProductService dcProductService;
    @Autowired
    private DcJobService dcJobService;
    @Autowired
    private DcHospitalService dcHospitalService;

//    @Autowired
//    CronTaskRegistrar cronTaskRegistrar;

    //任务列表展示
    @ApiOperation(value = "查询所有调度信息", notes = "查询所有调度信息")
    @GetMapping("/findAll")
    @ResponseBody
    public ResultUtil findAll(/*PageInfo pageInfo,*/ String name,String product_id, String stime,String type,String etime) {
        try {

          List<Map<String, Object>> dcScheduleList= dcScheduleService.selectBySome(name,stime,etime,type,product_id);
           /* if (pageInfo == null || pageInfo.getPageNum ()==0||pageInfo.getPageSize ()==0) {
                return ResultUtil.success ( dcScheduleList );
            }
            //List<DcDitTable> dcDitTableList = GetDataFromApp.findDcDitTables ().stream ().filter ( e -> null != e && (e.getName ().equals ( dcDitTable.getName () ) || e.getName_zh ().contains ( dcDitTable.getName_zh () )) ).collect ( Collectors.toList () );
            Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), dcScheduleList );

            return ResultUtil.success(listPage);*/
            return ResultUtil.success(dcScheduleList);
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }

   /*//保存接口信息
    @ApiOperation(value = "新建", notes = "新建调度任务信息")
    @PostMapping("/insert")
    @ResponseBody
    public ResultUtil insert(@RequestBody DcSchedule dcSchedule) {
        if (dcSchedule == null) {
            return ResultUtil.error ( "没有数据要保存" );
        }
        try {
            int i = dcScheduleDao.insertSelective ( dcSchedule );
        } catch (Exception e) {

            e.printStackTrace ();
            return ResultUtil.error ( "保存失败" );
        }
        return ResultUtil.success ( dcScheduleDao.selectAll (), "保存成功" );
    }*/

    /*//根据id查询调度详细信息
    @ApiOperation(value = "name或者time模糊查询", notes = "根据名称或者创建时间查询详细调度信息")
    @GetMapping("/findBySome")
    @ResponseBody
    public ResultUtil<PageInfo<DcSchedule>> findBySome(PageInfo pageInfo,  String name,String time ){
        try {
            DcSchedule dcSchedule=new DcSchedule ();
            dcSchedule.setName (name);
            PageInfo pageList = dcScheduleService.queryPageList ( pageInfo, dcSchedule );
            return ResultUtil.success ( pageList );
        } catch (Exception e) {
            e.printStackTrace ();
            return ResultUtil.error ( e.getMessage () );
        }
    }*/

    //修改调度信息
    @ApiOperation(value = "修改", notes = "修改调度信息")
    @PutMapping("/update")
    @ResponseBody
    public ResultUtil update(@RequestBody DcSchedule dcSchedule) {
        List<DcSchedule> dcSchedules;
        try {
            dcScheduleDao.updateByPrimaryKeySelective(dcSchedule);
            dcSchedules = dcScheduleDao.selectAll();

        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("修改成功");
        //return ResultUtil.success ( scheduleDao.selectAll (), "修改成功" );
    }

    //删除调度信息
    @ApiOperation(value = "删除", notes = "删除调度信息")
    @DeleteMapping("/del/{id}")
    @ResponseBody
    public ResultUtil delete(@PathVariable("id") String id) {
        try {
            dcScheduleDao.deleteByPrimaryKey(id);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("删除成功");
    }

/*    //绑定接口
    @ApiOperation(value = "已有任务绑定接口", notes = "调度绑定接口信息")
    @PutMapping("/updateRequestAPI/{id}/{schedule_ids}")
    @ResponseBody
    public ResultUtil updateRequestAPI(@PathVariable("id") Integer id, @PathVariable("schedule_ids") Integer sid) {
        try {
            //DcRequestAPI dcRequestAPI = dcRequestAPIDao.selectByPrimaryKey ( id );
            DcRequestAPI requestAPI = dcRequestAPIService.findById ( id );
            DcSchedule schedule = dcScheduleService.findById ( id );
            requestAPI.setSchedule_id ( sid );
            schedule.
            dcRequestAPIDao.updateByPrimaryKeySelective ( dcRequestAPI );
        } catch (Exception e) {
            return ResultUtil.error ( e.getMessage () );
        }
        return ResultUtil.success ( dcRequestAPIDao.selectRequestBySid ( sid ), "调度绑定接口成功" );
    }*/

    //生成调度接口绑定调度
    @ApiOperation(value = "调度中心根据接口生成任务", notes = "生成任务信息")
    @PutMapping("/updateScheduleRequestAPI/{requestApiId}/{roleId}")
    @ResponseBody
    public ResultUtil updateScheduleRequestAPI(@PathVariable("requestApiId") Integer requestApiId, @PathVariable("roleId") Integer roleId) {
        DcSchedule dcSchedule = new DcSchedule();
        try {
            //获取接口信息
            DcRequestAPI requestAPI = dcRequestAPIService.findById(requestApiId);
            //获取产品信息
            // List<DcProduct> dcProducts = (List<DcProduct>) ApplicationRunnerImpl.contextMap.get("dcProducts");
            DcProduct dcProducts = dcProductService.findById(requestAPI.getProduct_id());
            //获取医院信息
            DcHospital dcHospitals = dcHospitalService.findById(requestAPI.getHospital_id());
            //获取规则信息
            DcScheduleRule dcScheduleRule = dcScheduleRuleService.findById(roleId);
            System.out.println(dcScheduleRule);
            //dcSchedule.setName(dcHospitals.getShort_name() + dcProducts.getName() + dcProducts.getVersion() + requestAPI.getName() + dcScheduleRule.getName());
            dcSchedule.setName( dcProducts.getName() + dcProducts.getVersion() + requestAPI.getName() + dcScheduleRule.getName());
            dcSchedule.setValue(dcScheduleRule.getValue());
            dcSchedule.setStatus(-1);
            dcSchedule.setBean_name("dataTask");
            dcSchedule.setMethod_name(requestAPI.getType() + dcScheduleRule.getSuffix());
            dcSchedule.setRule_id(dcScheduleRule.getId());
            dcSchedule.setParam(dcScheduleRule.getParam());
            dcSchedule.setParam_unit(dcScheduleRule.getParam_unit());
            dcSchedule.setRemark(dcScheduleRule.getRemark());
            dcSchedule.setType(requestAPI.getType());
            dcSchedule.setType_id(requestAPI.getType_id());
            dcSchedule.setRule_suffix(dcScheduleRule.getSuffix());
            dcSchedule.setTag(requestAPI.getTag());
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dcSchedule.setTime(sdf.format(date));
            Integer insert = dcScheduleService.insert(dcSchedule);
            System.out.println(dcSchedule);
            if (insert > 0) {
                requestAPI.setSchedule_id(dcSchedule.getId());
                dcRequestAPIService.update(requestAPI);
            }
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(dcSchedule, "调度绑定接口成功");
    }
        @Autowired
        DcProcedureService dcProcedureService;
    /**
     * 直联库映射的存储过程中修改调度状态
     * @param procedureId   存储的id
     * @param isqy          状态
     * @return
     */
    @ApiOperation(value = "直联库映射的存储过程中修改调度状态", notes = "直联库映射的存储过程中修改调度状态")
    @GetMapping("/updateScheduleStatusByprocedure")
    @ResponseBody
    public ResultUtil updateScheduleStatusByprocedure(String procedureId, Integer isqy) {
        try{

            String sql="update s set status ="+isqy+" from dc_schedule s left join dc_procedure p on s.procedure_id=p.id where p.id='"+procedureId+"'";
//            DcSchedule schedule=new DcSchedule();
//            schedule.setProcedure_id(procedureId);
//            List<DcSchedule> list = dcScheduleService.select(schedule);
            int i = dcScheduleService.updateSqlWithSQL(sql);
           // System.out.println(i);
//            if(CollUtil.isNotEmpty(list)){
//                schedule=list.get(0);
//                schedule.setStatus(isqy);
//                dcScheduleService.update(schedule);
                return ResultUtil.success("修改成功!");
//            }else{
//                return ResultUtil.success("未查到相关数据");
//            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("更新失败");
        }
    }
    //启动或者关闭调度任务
    @ApiOperation(value = "调度中心页面启动任务", notes = "启动或者关闭调度任务")
    @GetMapping("/updateScheduleStatus")
    @ResponseBody
    public ResultUtil updateScheduleStatus(String dcScheduleId, Integer isqy) {
        try {
            //获取缓存里的调度
            DcSchedule dcSchedule = dcScheduleService.findById(dcScheduleId);

            Map<Object, List<DcSchedule>> map = null;
            if (dcSchedule.getType().equals("webApi")) {
                map = (Map<Object, List<DcSchedule>>) ApplicationRunnerImpl.contextMap.get("webMap");
            } else {
                map = (Map<Object, List<DcSchedule>>) ApplicationRunnerImpl.contextMap.get("transferMap");
            }
            dcScheduleService.updateStatus(dcSchedule, map, isqy);
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(null, "修改调度状态成功");
    }


    //启动或者关闭调度任务
    @ApiOperation(value = "调度中心页面启动任务", notes = "启动或者关闭调度任务")
    @PutMapping("/updateScheduleStatus1/{dcScheduleId}")
    @ResponseBody
    public ResultUtil updateScheduleStatus1(@PathVariable("dcScheduleId") Integer dcScheduleId) {
        try {
            //获取缓存里的调度
            DcSchedule dcSchedule = dcScheduleService.findById(dcScheduleId);
            if (dcSchedule.getStatus() == 1) {
                dcSchedule.setStatus(0);
                dcScheduleService.update(dcSchedule);
                return ResultUtil.success(null, "当前调度在此次任务执行完毕后停止");
            }
            dcSchedule.setStatus(1);
            dcScheduleService.update(dcSchedule);
            return ResultUtil.success(null, "当前调度任务在" + dcSchedule.getRemark());
        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //启动或者关闭调度任务
    @ApiOperation(value = "ceshi", notes = "测试")
    @PutMapping("/updateScheduleStatus1/{dcScheduleId}/{isqy}")
    @ResponseBody
    public ResultUtil updateScheduleStatus1(@PathVariable("dcScheduleId") Integer dcScheduleId, @PathVariable("isqy") Integer isqy) {
        try {
            //获取缓存里的调度
            Map<Object, List<DcSchedule>> map = (Map<Object, List<DcSchedule>>) ApplicationRunnerImpl.contextMap.get("webMap");

            DcSchedule dcSchedule = dcScheduleService.findById(dcScheduleId);
            dcSchedule.setStatus(isqy);
            dcScheduleService.updateStatus1(dcSchedule, map);

        } catch (Exception e) {
           e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success(null, "修改调度状态成功");
    }
}
