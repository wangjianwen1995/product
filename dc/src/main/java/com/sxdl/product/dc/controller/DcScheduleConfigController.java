package com.sxdl.product.dc.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.smallbun.screw.core.util.StringUtils;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.TreeUtils;
import com.sxdl.product.dc.dao.dao1.*;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Api(tags = "调度接口")
@RestController
@RequestMapping("/scheduleConfig")
public class DcScheduleConfigController {

    @Autowired
    private DcJobService dcJobService;

    @Autowired
    private DcTransferService dcTransferService;

    @Autowired
    private DcProcedureService dcProcedureService;

    @Autowired
    private DcScheduleConfigService dcScheduleConfigService;
    @Autowired
    private DcProductService dcProductService;
    @Autowired
    private DcTransferDao dcTransferDao;
    @Autowired
    private DcRequestAPIDao requestAPIDao;
    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private DcVirtualTableDao dcVirtualTableDao;
    @Autowired
    private DcTableVsTableDao dcTableVsTableDao;
    @Autowired
    private DcColumnDao dcColumnDao;
    @Autowired
    private DcHospitalDao dcHospitalDao;
    @Autowired
    private DcSingleConfigService dcSingleConfigService;

    @ApiOperation(value = "查询", notes = "查询配置好的调度信息")
    @GetMapping("/findpz")
    @ResponseBody
    public ResultUtil findAll(String id,String single_id) {//id:产品ID single_id:是否单抽标志
        try {
            if(StringUtil.isEmpty(single_id)){
                single_id="1";
            }
            List<DcScheduleConfig> select = dcScheduleConfigService.selectSort(id,single_id);
            List<DcScheduleConfig> tree = TreeUtils.tree(select, DcScheduleConfig::getJob_id, DcScheduleConfig::getParent_id, DcScheduleConfig::getChildren, DcScheduleConfig::setChildren, null);
            return ResultUtil.success(tree);

        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }




    @ApiOperation(value = "获取树结构", notes = "获取树结构")
    @GetMapping("/getTree")
    @ResponseBody
    public ResultUtil getNewTree(String flag) {
        try {

            List<DcScheduleConfig> data = dcScheduleConfigService.findData(flag);
            List<DcScheduleConfig> tree = TreeUtils.tree(data, DcScheduleConfig::getJob_id, DcScheduleConfig::getParent_id, DcScheduleConfig::getChildren, DcScheduleConfig::setChildren, null);
            tree = tree.stream().filter(e -> CollUtil.isNotEmpty(e.getChildren())).collect(Collectors.toList());
            return ResultUtil.success(tree);
        } catch (Exception e) {
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "新增", notes = "添加指标信息")
    @PostMapping("/insert")
    public ResultUtil insertHospital(@RequestBody Map<String, Object> map) {
        try {

            if(CollUtil.isEmpty(map)){
                return ResultUtil.error("参数异常！");
            }
            dcScheduleConfigService.insertOrupdate(map);
            return ResultUtil.success("保存成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "调度导出方案", notes = "导出调度配置相关")
    @GetMapping("/findByIds")
    @ResponseBody
    public ResultUtil findByIds(@RequestParam String ids) {
        Map<String, Object> map = new HashMap<>();
        try {
            if (StringUtil.isEmpty(ids)) {
                return ResultUtil.error("参数异常，请重新选择导出项目");
            }
            //1.项目信息
            List<DcProduct> dcProducts = dcProductService.selectByIds(ids);
            if (CollUtil.isEmpty(dcProducts)) {
                return ResultUtil.error("无导出项目");
            }
            map.put("dcProductList", dcProducts);
            //2.根据项目查找调度配置信息
            List<DcScheduleConfig> dcScheduleConfigs = dcScheduleConfigService.selectByProduct(ids);
            if (CollUtil.isEmpty(dcScheduleConfigs)) {
                return ResultUtil.error("调度配置无导出项目");
            }
            map.put("dcScheduleConfigs", dcScheduleConfigs);
            //3.根据调度信息查询工单信息、存储信息、web信息
            StringBuilder jobIds = new StringBuilder(" ");
            StringBuilder procedureIds = new StringBuilder(" ");
            StringBuilder webIds = new StringBuilder(" ");

            for (DcScheduleConfig dcScheduleConfig : dcScheduleConfigs) {
                switch (dcScheduleConfig.getType_id()) {
                    //拼接工单ids
                    case 0:
                        if(StringUtil.isNotEmpty(dcScheduleConfig.getJob_id())){
                            jobIds.append("'").append(dcScheduleConfig.getJob_id()).append("',");
                        }
                        break;
                    //拼接存储ids
                    case 2:
                        if(StringUtil.isNotEmpty(dcScheduleConfig.getProcedure_id())){
                            procedureIds.append("'").append(dcScheduleConfig.getProcedure_id()).append("',");
                        }
                        break;
                    //拼接web ids
                    case 1:
                        if(StringUtil.isNotEmpty(dcScheduleConfig.getProcedure_id())){
                            webIds.append("'").append(dcScheduleConfig.getProcedure_id()).append("',");
                        }
                        break;
                    default:
                        return ResultUtil.error("调度配置类型出错");
                }
            }
            //3.1工单信息
            System.out.println("开始导出工单信息~");
            String jobids = jobIds.toString();
            List<DcJob> dcJob = dcJobService.selectByIds(jobids.substring(0, jobIds.length() - 1));
            if (CollUtil.isEmpty(dcJob)) {
                return ResultUtil.error("配置工单无导出项目");
            }
            map.put("dcJobList", dcJob);
            //3.2存储信息
            System.out.println("开始导出存储信息~");
            String procedureids = procedureIds.toString().trim();
            List<DcProcedure> procedureList=new ArrayList<>();
            if(procedureids.trim().length()>1){
              procedureList = dcProcedureService.selectByIds(procedureids.substring(0, procedureids.length() - 1));
            }
            //3.2.1 获取对照映射相关信息
            //存放最终所有对照映射数据
            List<DcTableVsTable> dcTableVsTableList = new ArrayList<>();
            //存放最终所有对照映射表关联关系数据
            List<DcVirtualTable> dcVirtualTableList = new ArrayList<>();
            //存放所有数据表相关信息
            List<DcTable> dcTableList = new ArrayList<>();
            DcTableVsTable dcTableVsTable = new DcTableVsTable();
            DcVirtualTable dcVirtualTable = new DcVirtualTable();
            //存放table id  便于查询tableVStable 以及 table
            Set<String> tableSet = new HashSet<>();
            if (CollUtil.isNotEmpty(procedureList)) {
                for (DcProcedure e : procedureList) {
                    String from_table_id = e.getFrom_table_id();
                    if(from_table_id.contains(",")) {
                        String[] split = from_table_id.split(",");
                        for (String s : split) {
                            tableSet.add(s);
                        }
                    }else{
                        tableSet.add(from_table_id);
                    }
                    tableSet.add(e.getTo_table_id());
                    dcTableVsTable.setProcedure_id(e.getId());
                    //根据存储id获取相关对照映射集合
                    List<DcTableVsTable> tables = dcTableVsTableDao.select(dcTableVsTable);
                    //把此次集合加入最终list
                    dcTableVsTableList.addAll(tables);
                    //3.3.2 对照映射表关联关系数据
                    dcVirtualTable.setProcedure_id(e.getId());
                    List<DcVirtualTable> tableList = dcVirtualTableDao.select(dcVirtualTable);
                    dcVirtualTableList.addAll(tableList);
                }
            }
            /*if (CollUtil.isNotEmpty(dcTableVsTableList)) {
                //根据From_table_id 去重
                ArrayList<DcTableVsTable> from_table = dcTableVsTableList.stream().filter(e -> null != e.getFrom_table_id())
                        .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<DcTableVsTable>
                                (Comparator.comparing(DcTableVsTable::getFrom_table_id))), ArrayList::new));

                //根据to_table_id 去重
                ArrayList<DcTableVsTable> to_table = dcTableVsTableList.stream().filter(e -> null != e.getTo_table_id())
                        .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<DcTableVsTable>
                                (Comparator.comparing(DcTableVsTable::getTo_table_id))), ArrayList::new));
                if (CollUtil.isNotEmpty(from_table)) {
                    for (DcTableVsTable tableVsTable : from_table) {
                        tableSet.add(tableVsTable.getFrom_table_id());
                    }
                }
                if (CollUtil.isNotEmpty(to_table)) {
                    for (DcTableVsTable tableVsTable : to_table) {
                        tableSet.add(tableVsTable.getTo_table_id());
                    }
                }
            }*/

            map.put("dcProcedureList", procedureList);
            map.put("dcTableVsTableList", dcTableVsTableList);
            map.put("dcVirtualTableList", dcVirtualTableList);
            //3.3web信息
            System.out.println("开始导出web信息~");
            String webids = webIds.toString();
            List<DcRequestAPI> requestAPIList=new ArrayList<>();
            if(webids.trim().length()>1){
                requestAPIList = requestAPIDao.selectByIds(webids.substring(0, webids.length() - 1));
            }
            if (CollUtil.isEmpty(requestAPIList)) {
                requestAPIList = new ArrayList<>();
            } else {
                //3.3.1 根据web获取数据表信息
                String tag;
                String[] ss;
                for (DcRequestAPI api : requestAPIList) {
                    tag = api.getTag();
                    if (StrUtil.isNotEmpty(tag)) {
                        if (tag.contains(",")) {
                            ss = tag.split(",");
                            for (String e : ss) {
                                if (StrUtil.isNotEmpty(e)) {
                                    DcTable dcTable = dcTableDao.selectByName(e);
                                    if(null!=dcTable) tableSet.add(dcTable.getId());
                                }
                            }
                        } else {
                            DcTable dcTable = dcTableDao.selectByName(tag);
                            if(null!=dcTable) tableSet.add(dcTable.getId());
                        }
                    }
                }
            }
            map.put("dcRequestAPIList", requestAPIList);
            //4.链接服务器信息
            System.out.println("开始导出链接服务器信息~");
            List<DcTransfer> transferList = dcTransferDao.selectByIds(jobids.substring(0, jobIds.length() - 1));
            if (CollUtil.isEmpty(transferList)) {
                transferList = new ArrayList<>();
            }
            map.put("dcTransferList", transferList);
            //5.数据表信息
            System.out.println("开始导出数据表信息~");
            if (null != tableSet && tableSet.size() > 0) {
                for (String s : tableSet) {
                    dcTableList = getTableInfo(s, null, dcTableList, null);
                }
            }
            map.put("dcTableList", dcTableList);
            //6.医院信息
            System.out.println("开始导出医院信息~");
            List<DcHospital> dcHospital = dcHospitalDao.selectAll();
            if (CollUtil.isNotEmpty(dcHospital)) {
                map.put("dcHospital", dcHospital.get(0));
            } else{
                map.put("dcHospital", new DcHospital());
            }

            //7.根据项目查找单抽配置信息
            System.out.println("开始导出单抽配置信息~");
            List<DcSingleConfig> dcSingleConfigList = dcSingleConfigService.selectByProduct(ids);
            if (CollUtil.isEmpty(dcSingleConfigList)) {
                dcSingleConfigList = new ArrayList<>();
            }else{
                map.put("dcSingleConfigList", dcSingleConfigList);
            }

            JSONObject jsonObject = JSONUtil.parseObj(map);
            return ResultUtil.success(jsonObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询配置过的产品们", notes = "查询配置过的产品们")
    @GetMapping("/findPzProduct")
    @ResponseBody
    public ResultUtil findPzProduct() {
        try{
        List<DcScheduleConfig> pzProduct = dcScheduleConfigService.findPzProduct();

        return ResultUtil.success(pzProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    public List<DcTable> getTableInfo(String id, String name, List<DcTable> tabls, String productid) {
        DcTable dcTable = new DcTable();
        if (StrUtil.isNotEmpty(id)) {
            dcTable = dcTableDao.selectByPrimaryKey(id);
        } else if (StrUtil.isNotEmpty(name)) {
            dcTable = dcTableDao.selectByNameAndProdectID(name, productid);
        } else {
            return tabls;
        }
        dcTable.setDcColumnList(dcColumnDao.selectByTableid(dcTable.getId()));
        tabls.add(dcTable);
        return tabls;
    }

}
