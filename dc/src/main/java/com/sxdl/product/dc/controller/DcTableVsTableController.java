package com.sxdl.product.dc.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.entity.SysDictTable;
import com.sxdl.base.entity.SysDictVal;
import com.sxdl.base.util.ApplicationRunnerImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.product.dc.dao.dao1.DcScheduleConfigDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.*;
import com.sxdl.product.dc.service.impl.DcProcedureServiceImpl;
import com.sxdl.product.dc.service.impl.DcTableServiceImpl;
import com.sxdl.product.dc.service.impl.DcTableVsTableServiceImpl;
import com.sxdl.product.dc.util.WebUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "自定义表关系映射维护")
@RestController
@RequestMapping("/tableVsTable")
public class DcTableVsTableController {

    private final String successOrError = "";
    List<DcTable> fromtables;
    List<DcTableVsTable> tvts;
    @Autowired
    private DcTableVsTableServiceImpl tableVsTableService;
    @Autowired
    private DcTableService dcTableService;
    @Autowired
    private DcColumnService dcColumnService;
    @Autowired
    private DcVirtualTableService dcVirtualTableService;
    @Autowired
    private DcProcedureServiceImpl dcProcedureService;
    @Autowired
    private DcTransferService dcTransferService;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcProductService dcProductService;
    @Autowired
    private DcTableServiceImpl dcTableServiceImpl;
    @Autowired
    private YmlUtil ymlUtil;

    @Autowired
    private DcScheduleConfigDao dcScheduleConfigDao;

    /**
     * 对照映射之--自动对照
     * @param froms  来源表IDS
     * @param to     目标表ID
     * @return
     */
    @GetMapping("autoMap")
    public ResultUtil autoMap(String froms, String to) {
        try {
            //将来源表ID数组化，如果是多个，用“，”号分割
            String[] fromsArray = new String[]{froms};
            if (froms.contains(",")) {
                fromsArray = froms.split(",");
            }
            //查询来源表的所有信息
            String sql = "select * from dc_table where id in(";
            for (String s : fromsArray) {
                sql += "'" + s + "',";
            }
            sql = sql.substring(0, sql.length() - 1) + ") ";
            List<DcTable> tables = dcTableService.selectListWithSQL(sql, DcTable.class);

            //根据来源表，查询每个表的字段信息(封装到dcTable中)
            sql = "select * from dc_column where table_id='";
            fromtables = new ArrayList<>();
            if (tables.size() > 0) {
                for (DcTable t : tables) {
                    t.setDcColumnList(dcColumnService.selectListWithSQL(sql + t.getId() + "'", DcColumn.class));
                }
            }
            fromtables.addAll(tables);
            //查出目标表的表及字段信息
            DcTable totable = dcTableService.selectByKey(to);
            totable.setDcColumnList(dcColumnService.selectListWithSQL(sql + totable.getId() + "'", DcColumn.class));


            //  一、默认第一次，组装TVT, 根据来源表和目标表，双层循环嵌套，当来源表和目标表字段英文名或者中文名相同时，组装成一条数据，如若不同，则只组装
            //目标表部分，来源表部分组装空，显示到页面就是无操作。
            List<DcTableVsTable> tvts = new ArrayList<>();
            // totable.getDcColumnList().stream().filter(e -> !e.getColumn_name().equalsIgnoreCase("id")).forEach(c -> {
            totable.getDcColumnList().stream().filter(e -> null != e).forEach(c -> {
                DcTableVsTable tvt = new DcTableVsTable();
                tvt.setTo_table_id(totable.getId());
                //tvt.setTo_table_name(totable.getName());
                tvt.setDc_relation_replace_type_id(1);
                tvt.setTo_table_column_id(c.getId());
                tvt.setTo_table_column(c.getColumn_name());
                tvt.setOrdernum(null==c.getOrdernum()?0:c.getOrdernum());
                tvt.setTo_table_column_zh(c.getColumn_name_zh());
                tvt.setFrom_table_column_id("");
                tvt.setTo_table_column_type(getColumnType(c));
                tvts.add(tvt);
                for (DcTable dt : fromtables) {
                    for (DcColumn dc : dt.getDcColumnList()) {
                        if (dc.getColumn_name().equals(c.getColumn_name()) || dc.getColumn_name_zh().equals(c.getColumn_name_zh())) {
                            tvt.setFrom_table_id(dt.getId());
                            tvt.setFrom_table_column_id(dc.getId());
                            tvt.setFrom_table_column(dt.getName() + "." + dc.getColumn_name());
                            tvt.setFrom_table_column_zh(dc.getColumn_name_zh());
                        }
                    }
                }
            });

            // 二、根据目标表，查询已经做好对照关系的TVT列表。筛选出其中有除了无操作之外的其他已经对照的字段(如：自定义sql,字典对照，编码转化，格式化等)
            //循环第一步组装的TVT和第二组查询筛选过的TVT 进行一一匹配
            DcTableVsTable dcTableVsTable = new DcTableVsTable();
            dcTableVsTable.setTo_table_id(to);
            List<DcTableVsTable> vsTableList = tableVsTableService.select(dcTableVsTable);
            //筛选出有其他操作的字段或者是做过对照映射的字段
            List<DcTableVsTable> collect = vsTableList.stream().filter(e -> null != e &&( StringUtil.isNotEmpty(e.getFrom_table_column_id()) || StringUtil.isNotEmpty(e.getRelation_replace_sql())  )  ).collect(Collectors.toList());
            for (DcTableVsTable dt : tvts) {
                //if (StringUtil.isEmpty(dt.getFrom_table_column_id().trim()) && StringUtil.isEmpty(dt.getRelation_replace_sql())) {
                    for (DcTableVsTable dc : collect) {
                        if (dc.getTo_table_column_id().equals(dt.getTo_table_column_id()) /*&& StringUtil.isEmpty(dc.getFrom_table_column_id()) && StringUtil.isNotEmpty(dc.getRelation_replace_sql())*/) {
                            dt.setRelation_replace_sql(dc.getRelation_replace_sql());
                            dt.setDc_relation_replace_type_id(dc.getDc_relation_replace_type_id());
                            dt.setRelation_replace_table_id(dc.getRelation_replace_table_id());
                            dt.setFrom_table_id(dc.getFrom_table_id());
                            dt.setFrom_table_column_id(dc.getFrom_table_column_id());
                            dt.setFrom_table_column(dc.getFrom_table_column());
                            dt.setFrom_table_column_zh(dc.getFrom_table_column_zh());

                            //编码对照信息
                            dt.setIs_history(dc.getIs_history());
                            dt.setBm_type(dc.getBm_type());
                            dt.setDmormc(dc.getDmormc());
                            //字典对照信息
                            dt.setMap_code(dc.getMap_code());
                            dt.setMap_type(dc.getMap_type());
                            dt.setMap_code_name(dc.getMap_code_name());
                        }
                    }
                //}
            }

            //第三步循环  关联表的对照映射
            for (String t : fromsArray) {
                dcTableVsTable.setFrom_table_id(t);
                List<DcTableVsTable> tvTableList = vsTableList.stream().filter(e -> null != e && StringUtil.isNotEmpty(e.getFrom_table_id()) && e.getFrom_table_id().equals(t)).collect(Collectors.toList());

                if (null != vsTableList && vsTableList.size() > 0) {
                    for (DcTableVsTable dt : tvts) {
                        if (StringUtil.isEmpty(dt.getFrom_table_column_id())) {
                            for (DcTableVsTable dc : tvTableList) {
                                if (dc.getTo_table_column_id().equals(dt.getTo_table_column_id()) && StringUtil.isNotEmpty(dc.getFrom_table_column_id())) {
                                    dt.setFrom_table_id(dc.getFrom_table_id());
                                    String name = tables.stream().filter(e -> e.getId().equals(dc.getFrom_table_id())).collect(Collectors.toList()).get(0).getName();
                                    dt.setFrom_table_column_id(dc.getFrom_table_column_id());
                                    dt.setRelation_replace_sql(dc.getRelation_replace_sql());
                                    dt.setDc_relation_replace_type_id(dc.getDc_relation_replace_type_id());
                                    dt.setRelation_replace_table_id(dc.getRelation_replace_table_id());
                                    DcColumn dcColumn = dcColumnService.findById(dc.getFrom_table_column_id());
                                    dt.setFrom_table_column(name + "." + dcColumn.getColumn_name());
                                    dt.setFrom_table_column_zh(name + "." + dcColumn.getColumn_name_zh());
                                    //编码对照信息
                                    dt.setIs_history(dc.getIs_history());
                                    dt.setBm_type(dc.getBm_type());
                                    dt.setDmormc(dc.getDmormc());
                                    //字典对照信息
                                    dt.setMap_code(dc.getMap_code());
                                    dt.setMap_type(dc.getMap_type());
                                    dt.setMap_code_name(dc.getMap_code_name());
                                }
                            }
                        }
                    }
                }
            }
            //tvts.sort(Comparator.comparing(DcTableVsTable::getFrom_table_column_id));
            tvts.sort(Comparator.comparing(DcTableVsTable::getOrdernum));
            return ResultUtil.success(tvts);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据表id查询所有的字段", notes = "根据表id查询所有的字段")
    @GetMapping("/findByTableId")
    public ResultUtil findByTableId(/*PageInfo pageInfo,*/ @RequestParam(value = "tableid", defaultValue = "") String tableid) {
        try {
            List<DcTableVsTable> list = new ArrayList<>();
            DcTableVsTable dcTableVsTable = null;
            DcTable dcTable = dcTableService.findById(tableid);
            List<DcColumn> dcColumns = dcColumnService.selectByTableid(tableid);
            //dcColumns = dcColumns.stream().filter(e -> null != e && !"ID".equals(e.getColumn_name().toUpperCase())).collect(Collectors.toList());
            dcColumns = dcColumns.stream().filter(e -> null != e /*&& !"ID".equals(e.getColumn_name().toUpperCase())*/).collect(Collectors.toList());
            for (DcColumn dcColumn : dcColumns) {
                dcTableVsTable = new DcTableVsTable();
                dcTableVsTable.setTo_table_id(dcColumn.getTable_id());
                dcTableVsTable.setTo_table_column_id(dcColumn.getId());
                dcTableVsTable.setTo_table_column(dcColumn.getColumn_name());
                dcTableVsTable.setTo_table_column_zh(dcColumn.getColumn_name_zh());
                //dcTableVsTable.setTo_table_name(dcTable.getName());
                dcTableVsTable.setDc_relation_replace_type_id(1);
                dcTableVsTable.setTo_table_column_type(getColumnType(dcColumn));
                list.add(dcTableVsTable);
            }
          /*  //排序
            dcScheduleConfigs.sort(Comparator.comparing(DcScheduleConfig::getOrdernum));*/
            //Map<String, Object> listPage = PageList.getListPage ( pageInfo.getPageNum (), pageInfo.getPageSize (), list );

            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "根据多表id查询所有的字段", notes = "根据多表id查询所有的字段")
    @GetMapping("/findByTableIds/{tableids}")
    public ResultUtil findByTableIds(PageInfo pageInfo, @PathVariable String[] tableids) {
        try {

            List<DcTableVsTable> returnDate = new ArrayList<>();
            DcTableVsTable dcTableVsTable = null;
            for (String tableid : tableids) {
                DcTable table = dcTableService.findById(tableid);
                List<DcColumn> dcColumns = dcColumnService.selectByTableid(table.getId());
                for (DcColumn dcColumn : dcColumns) {
                    dcTableVsTable = new DcTableVsTable();
                    dcTableVsTable.setFrom_table_column_id(dcColumn.getId());
                    dcTableVsTable.setFrom_table_column(table.getName() + "." + dcColumn.getColumn_name());
                    dcTableVsTable.setFrom_table_id(dcColumn.getTable_id());
                    dcTableVsTable.setFrom_table_column_zh(table.getName_zh() + "." + dcColumn.getColumn_name_zh());
                    returnDate.add(dcTableVsTable);
                }
            }
            return ResultUtil.success(returnDate);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询字典表")
    @GetMapping("/findzdTable")
    public ResultUtil findzdTable() {
        try {
            List<SysDictTable> dcDitTableList2 = (List<SysDictTable>) ApplicationRunnerImpl.contextMap.get("dcDitTableList2");
            return ResultUtil.success(dcDitTableList2);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询所有的表映射关系", notes = "查询所有的表映射关系")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DcTableVsTable>> findAll(PageInfo pageInfo) {
        try {
            PageInfo<DcTableVsTable> list = tableVsTableService.queryPageList(pageInfo, new DcTableVsTable());
            return ResultUtil.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "保存表映射关系(到标准表)", notes = "保存表映射关系")
    @PostMapping("/save")
    public ResultUtil save(@RequestBody DcProcedure dcProcedure) {
        try {
            if ("10".equals(ymlUtil.getYmlValue("back_time"))) {
                if (StrUtil.isEmpty(dcProcedure.getContent())) {
                    return ResultUtil.error("请先测试");
                }
            }
//            if(null==dcProcedure.getRule_id()){
//                return ResultUtil.error("如果有参数,调度规则是必填项!");
//            }

            //System.out.println(dcProcedure.getContent());
            dcProcedureService.saveMappingTable(dcProcedure);
            //修改已经配置好的调度信息
            List<DcScheduleConfig> select = dcScheduleConfigDao.findAlreadyPz(dcProcedure.getId());
            if(CollUtil.isNotEmpty(select)){
                select.forEach(e -> {
                    e.setScope(dcProcedure.getScope());
                    dcScheduleConfigDao.updateByPrimaryKeySelective(e);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "保存表映射关系", notes = "保存表映射关系")
    @PostMapping("/saveWB")
    public ResultUtil saveWB(@RequestBody Map<String, DcProcedure> map) {
        try {
            List<DcProcedure> dcProcedures = new ArrayList<>();
            map.forEach((k, v) -> {
                dcProcedures.add(v);
            });
            dcProcedureService.saveMappingWBTable(dcProcedures);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("保存失败");
        }
        return ResultUtil.success("保存成功");
    }

    @ApiOperation(value = "查询所有的表映射关系", notes = "查询所有的表映射关系")
    @GetMapping("/findById")
    public ResultUtil findById(@RequestParam(value = "id", required = true) String id) {

        try {
            DcProcedure dcProcedure = dcProcedureService.findById(id);


            //获取insert into select字段
            DcTableVsTable dcTableVsTable = new DcTableVsTable();
            dcTableVsTable.setProcedure_id(id);
            List<DcTableVsTable> dcTableVsTableList = tableVsTableService.selectByPid(dcTableVsTable);
            List<String> dcTableVsTableId = new ArrayList<>();
            for (DcTableVsTable e : dcTableVsTableList) {
                dcTableVsTableId.add(e.getTo_table_column_id());
//                if (StringUtil.isNotEmpty(e.getTo_table_id())) {
//                    DcTable toTable = dcTableService.findById(e.getTo_table_id());
//                    if (null != toTable) {
//                        e.setTo_table_name(toTable.getName());
//                    }
//                }

//                if (StringUtil.isNotEmpty(e.getTo_table_column_id())) {
//                    DcColumn toColumn = dcColumnService.findById(e.getTo_table_column_id());
//                    if (null != toColumn) {
//                        e.setTo_table_column(toColumn.getColumn_name());
//                        e.setTo_table_column_zh(toColumn.getColumn_name_zh());
//                    }
//
//                }

                //来源表

//                if (StringUtil.isNotEmpty(e.getFrom_table_id()) && StringUtil.isNotEmpty(e.getFrom_table_column_id())) {
//                    DcTable fromTable = dcTableService.findById(e.getFrom_table_id());
//                    DcColumn fromColunm = dcColumnService.findById(e.getFrom_table_column_id());
//                    if (null != fromColunm) {
//                        e.setFrom_table_column(fromTable.getName() + "." + fromColunm.getColumn_name());
//                        e.setFrom_table_column_zh(fromTable.getName_zh() + "." + fromColunm.getColumn_name_zh());
//                    }
//
//                }
            }
            //获取 from table left join 数据
            DcVirtualTable dcVirtualTable = new DcVirtualTable();
            dcVirtualTable.setProcedure_id(id);
            List<DcVirtualTable> dcVirtualTableList = dcVirtualTableService.selectByPid(dcVirtualTable);
            List<DcTableVsTable> relations = null;
            List<DcTableVsTable> sons = null;
            DcTableVsTable vsTable = new DcTableVsTable();
            if (null != dcVirtualTableList && dcVirtualTableList.size() > 0) {
                for (DcVirtualTable e : dcVirtualTableList) {
                    relations = new ArrayList<>();
                    sons = new ArrayList<>();
                    DcTable dcTable = dcTableService.findById(e.getRelation_talbe_id());
                    List<DcColumn> dcColumns = dcColumnService.selectByTableid(e.getRelation_talbe_id());
                    if (null != dcColumns && dcColumns.size() > 0) {
                        for (DcColumn column : dcColumns) {
                            vsTable = new DcTableVsTable();
                            vsTable.setFrom_table_id(dcTable.getId());
                            vsTable.setFrom_table_column_id(column.getId());
                            vsTable.setFrom_table_column(dcTable.getName() + "." + column.getColumn_name());
                            vsTable.setFrom_table_column_zh(dcTable.getName_zh() + "." + column.getColumn_name_zh());
                            relations.add(vsTable);
                        }
                    }
                    DcTable sonTable = dcTableService.findById(e.getSon_table_id());
                    List<DcColumn> sonColumns = dcColumnService.selectByTableid(e.getSon_table_id());
                    if (null != sonColumns && sonColumns.size() > 0) {
                        for (DcColumn sonColumn : sonColumns) {
                            vsTable = new DcTableVsTable();
                            vsTable.setFrom_table_id(sonTable.getId());
                            vsTable.setFrom_table_column_id(sonColumn.getId());
                            vsTable.setFrom_table_column(sonTable.getName() + "." + sonColumn.getColumn_name());
                            vsTable.setFrom_table_column_zh(sonTable.getName_zh() + "." + sonColumn.getColumn_name_zh());
                            sons.add(vsTable);
                        }
                    }
                    e.setRelations(relations);
                    e.setSons(sons);
                }
            }
            String bztable = dcTableVsTableList.get(0).getTo_table_id();
            Set<String> set = new TreeSet<>();

            if (null != dcVirtualTableList && dcVirtualTableList.size() > 0) {
                for (DcVirtualTable e : dcVirtualTableList) {
                    if (StringUtil.isNotEmpty(e.getRelation_talbe_id()) && StringUtil.isNotEmpty(e.getSon_table_id())) {
                        set.add(e.getRelation_talbe_id());
                        set.add(e.getSon_table_id());
                    } else {
                        for (DcTableVsTable e1 : dcTableVsTableList) {
                            if (e1.getFrom_table_id() != null) {
                                set.add(e1.getFrom_table_id());
                            }
                        }
                    }
                }
            } else {
                for (DcTableVsTable e : dcTableVsTableList) {
                    if (e.getFrom_table_id() != null) {
                        set.add(e.getFrom_table_id());
                    }
                }
            }
            set.remove("");
            String[] ytable = set.stream().toArray(String[]::new);

          /*  Object[] objects = set.toArray();
            Integer[] ytable = new Integer[objects.length];
            for (int i = 0; i < objects.length; i++) {
                ytable[i] = (int) objects[i];//将Object对象数组转为整型数组（强制向下转型）
            }
            */
            //给原表的下拉框赋值
            dcProcedure.setYtable(ytable);
            //标准表下拉框中赋值
            dcProcedure.setBztable(bztable);
            //新增字段  更新回显
            String transfer_id = dcProcedure.getTransfer_id();
            DcTransfer dcTransfer = dcTransferService.findById(dcProcedure.getTransfer_id());
            DcTable dcTable = dcTableService.findById(bztable);
            DcProduct dcProduct = dcProductService.findById(dcProcedure.getProduct_id());

            if (dcProduct.getShort_name().contains("dc")) {
                dcTableServiceImpl.updateColumn(bztable, "", "", dcTable.getName());
            } else {
                //dcTableServiceImpl.updateColumn(bztable, dcTransfer.getName(), dcTransfer.getDbname(), dcTable.getName());
            }

            List<DcColumn> columns = dcColumnService.selectByTableid(bztable);
            if (null != columns && columns.size() > 0) {
                for (DcColumn column : columns) {
                    DcTableVsTable dcTableVsTable1 = new DcTableVsTable();
                    /*  if (!dcTableVsTableId.contains(column.getId()) && !column.getColumn_name().equalsIgnoreCase("id")) {*/
                    if (!dcTableVsTableId.contains(column.getId()) /*&& !column.getColumn_name().equalsIgnoreCase("id")*/) {
                        dcTableVsTable1.setProcedure_id(id);
                        dcTableVsTable1.setTo_table_id(bztable);
                        dcTableVsTable1.setTo_table_column_id(column.getId());
                        dcTableVsTable1.setTo_table_column(column.getColumn_name());
                        dcTableVsTable1.setTo_table_column_zh(column.getColumn_name_zh());
                        //dcTableVsTable1.setTo_table_name(column.getTable_name());
                        //dcTableVsTable1.setDc_relation_replace_type_id(0);
                        dcTableVsTable.setTo_table_column_type(getColumnType(column));
                        dcTableVsTableList.add(dcTableVsTable1);
                    }
                }
            }
//            if (null != dcTableVsTableList && dcTableVsTableList.size() > 0) {
//                dcTableVsTableList = dcTableVsTableList.stream().filter(e -> null != e && null != e.getTo_table_column() /*&& !e.getTo_table_column().equalsIgnoreCase("id")*/)
//                        .sorted(Comparator.comparing(DcTableVsTable::getTo_table_column_id, Comparator.nullsLast(String::compareTo))).collect(Collectors.toList());
//            }
            if (null != dcTableVsTableList && dcTableVsTableList.size() > 0) {
                dcTableVsTableList = dcTableVsTableList.stream().filter(e -> null != e /*&& null != e.getTo_table_column() && !e.getTo_table_column().equalsIgnoreCase("id")*/)
                        .sorted(Comparator.comparing(DcTableVsTable::getOrdernum, Comparator.nullsLast(Integer::compareTo))).collect(Collectors.toList());
            }

            dcProcedure.setDcTableVsTables(dcTableVsTableList);
            dcProcedure.setDcvirtualTables(dcVirtualTableList);
            return ResultUtil.success(dcProcedure);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "查询所有的表映射关系", notes = "查询所有的表映射关系")
    @GetMapping("/findWBById")
    public ResultUtil findWBById(@RequestParam(value = "id", required = true) String id) {
        System.out.println(id);
        try {
            DcProcedure dcProcedure = dcProcedureService.findById(id);
            if (dcProcedure.getType_id().equals(4)) {
                //获取字段对照表 --tvt
                DcTableVsTable dcTableVsTable = new DcTableVsTable();
                dcTableVsTable.setProcedure_id(id);
                List<DcTableVsTable> dcTableVsTableList = tableVsTableService.selectByPid(dcTableVsTable);
                //获取来源表和去向表
                DcTableVsTable dcTableVsTable1 = null;
                if (dcTableVsTableList != null && dcTableVsTableList.size() > 0) {
                    dcTableVsTable1 = dcTableVsTableList.get(dcTableVsTableList.size() - 1);
                }

                DcTable dcToTable = dcTableService.findById(dcTableVsTable1.getTo_table_id());
                DcTable dcFromTable = dcTableService.findById(dcTableVsTable1.getFrom_table_id());

                //根据存储名和 表类型查询hbi维表
                DcProcedure dcProcedure1 = new DcProcedure();
                dcProcedure1.setType_id(8);
                //ETL_Dc_ots_sys_staff_to_staff
                dcProcedure1.setName("ETL_Dc_otaw_" + dcFromTable.getName() + "_to_" + dcToTable.getName());
                DcProcedure dcHBIProcedure = dcProcedureService.findByToNameAndType(dcProcedure1);
                //获取insert into select字段

                dcTableVsTableList.forEach(e -> {
                    //去向表
                    DcTable toTable = dcTableService.findById(e.getTo_table_id());
                    //e.setTo_table_name(toTable.getName());
                    DcColumn toColumn = dcColumnService.findById(e.getTo_table_column_id());
                    e.setTo_table_column(toColumn.getColumn_name());
                    e.setTo_table_column_zh(toColumn.getColumn_name_zh());
                    //来源表
                    DcTable fromTable = dcTableService.findById(e.getFrom_table_id());
                    DcColumn fromColunm = dcColumnService.findById(e.getFrom_table_column_id());
                    e.setFrom_table_column(fromTable.getName() + "." + fromColunm.getColumn_name());
                    e.setFrom_table_column_zh(fromTable.getName_zh() + "." + fromColunm.getColumn_name_zh());
                });

                String bztable = dcTableVsTableList.get(0).getTo_table_id();
                Set<String> set = new TreeSet<>();
                dcTableVsTableList.forEach(e -> {
                    set.add(e.getFrom_table_id());
                });

                String[] ytable = set.stream().toArray(String[]::new);
                //给原表的下拉框赋值
                dcProcedure.setYtable(ytable);
                //标准表下拉框中赋值
                //String dataBaseSql = getHBIDataBaseSql(dcProcedure.getTo_product_id(), dcTableVsTable1.getTo_table_name());
                String dataBaseSql = getHBIDataBaseSql(dcProcedure.getTo_product_id(), dcProcedure.getTo_table_name());
                dcProcedure.setBztable(bztable);
                dcProcedure.setDcTableVsTables(dcTableVsTableList);
                //String hbiDataBaseSql = getHBIDataBaseSql(dcHBIProcedure.getTo_product_id(), dcTableVsTable1.getTo_table_name());
                String hbiDataBaseSql = getHBIDataBaseSql(dcHBIProcedure.getTo_product_id(), dcProcedure.getTo_table_name());
                //标准维表sql
                dcProcedure.setMap_sql("insert into " + dataBaseSql + dcProcedure.getMap_sql());
                //产品维表sql
                dcProcedure.setWhere_sql("insert into " + hbiDataBaseSql + dcProcedure.getMap_sql());
                //产品存储过程id
                dcProcedure.setJoin_sql(dcHBIProcedure.getId());
                return ResultUtil.success(dcProcedure);
            }
            return ResultUtil.success(dcProcedure);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    @ApiOperation(value = "测试", notes = "测试生成存储过程")
    @PutMapping("/testProc")
    public ResultUtil testProcedure(@RequestBody DcProcedure dcProcedure) {
        /*String content = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();*/
        String content = "";
        try {
            content = tableVsTableService.testProcedure(dcProcedure);
            //根据 来源的时间字段From_table_column_id 获取对照表的时间字段 用于去重
/*
            List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
            List<DcTableVsTable> collect = dcProcedure.getDcTableVsTables().stream().filter
                    (e -> dcProcedure.getTime_column_id().equals(e.getFrom_table_column_id())).collect(Collectors.toList());
            String toTimeColumn = "";
            String toTableName = "";
            if (null != collect && collect.size() > 0) {
                DcTableVsTable dcTableVsTable = collect.get(0);
                toTimeColumn = dcTableVsTable.getTo_table_column();
                toTableName = dcTableService.findById(dcTableVsTable.getTo_table_id()).getName();
            } else {
                toTableName = dcTableService.findById(dcTableVsTables.get(0).getTo_table_id()).getName();
            }

            // 解决跨服务器提交事务的问题
            String fbssw = "";
            //获取去向表的名称

            String to_product_id = dcProcedure.getTo_product_id();
            DcProduct dcProduct = dcProductService.findById(to_product_id);
            if (!"dc".equals(dcProduct.getShort_name())) {
                DcTransfer dcTransfer = dcTransferService.findById(dcProcedure.getTransfer_id());
                String dbname = dcTransfer.getDbname();
                String transfername = dcTransfer.getName();
                if (dcTransfer.getIsogeny() == 0) {
                    //是否同源 不同源更改表 名称 拼接链接服务器
                    toTableName = transfername + "." + dbname + ".dbo." + toTableName;
                    fbssw = "set xact_abort ON";
                } else {
                    toTableName = dbname + ".dbo." + toTableName;
                }

            }
            //开始创建存储过程
            sb2.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + dcProcedure.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + dcProcedure.getName() + "] end ").append(WebUtil.LineBreak);
            handleDao.excuteSqlWithSQL(sb2.toString());
//            sb.append ( "          DECLARE @sql VARCHAR(8000)" ).append ( WebUtil.LineBreak );
//            sb.append ( "set @sql=' create proc " + dcProcedure.getName () ).append ( WebUtil.LineBreak );
            sb.append("create proc " + dcProcedure.getName()).append(WebUtil.LineBreak);
            if (1 == dcProcedure.getIsparam()) {
                sb.append("@startDate varchar(10),  @endDate varchar(10)  ").append(WebUtil.LineBreak);
            }
            sb.append("as ").append(WebUtil.LineBreak);
            sb.append("begin").append(WebUtil.LineBreak);
            sb.append(fbssw).append(WebUtil.LineBreak);
            sb.append("begin tran mytran --开启事物").append(WebUtil.LineBreak);
            sb.append("begin try").append(WebUtil.LineBreak);
            // 开始核心抽取数据
            if (null != toTimeColumn && (!"".equals(toTimeColumn))) {
                sb.append(" delete from " + toTableName + " where " + toTimeColumn + " between @startDate and @endDate ").append(WebUtil.LineBreak).append(WebUtil.LineBreak);
            } else {
                sb.append(" truncate table " + toTableName).append(WebUtil.LineBreak).append(WebUtil.LineBreak);

            }
            sb.append(" " + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
            sb.append(" " + dcProcedure.getJoin_sql()).append(WebUtil.LineBreak);
            if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                sb.append(" where " + dcProcedure.getTime_column_name() + " between  @startDate and @endDate ").append(WebUtil.LineBreak);
            } else {
                sb.append(" where  1=1").append(WebUtil.LineBreak);

            }
            if (null != dcProcedure.getWhere_sql().trim().replace("\r\n", " ") && (!"".equals(dcProcedure.getWhere_sql().trim().replace("\r\n", " ")))) {
                sb.append("  and " + dcProcedure.getWhere_sql()).append(WebUtil.LineBreak);
            }
            sb.append("commit tran  --提交事物").append(WebUtil.LineBreak);
            sb.append("end try").append(WebUtil.LineBreak);
            sb.append("begin catch ").append(WebUtil.LineBreak);
            sb.append("SELECT ERROR_MESSAGE() AS    ErrorMessage   ,ERROR_SEVERITY()    AS    ErrorSeverity  ,ERROR_STATE()    AS    ErrorState  ").append(WebUtil.LineBreak);
            sb.append(" rollback tran  --事物回滚").append(WebUtil.LineBreak);
            sb.append("end catch").append(WebUtil.LineBreak);
            sb.append("end ");
            //sb.append ( " ' EXEC (@sql)     " ).append ( WebUtil.LineBreak );
            content = sb.toString();
             handleDao.excuteSqlWithSQL(content);
            //System.out.println("---"+content);*/
            int i = handleDao.excuteSqlWithSQL(content);
            return ResultUtil.success(content, "测试成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString(), content);
        }

    }

    @ApiOperation(value = "测试", notes = "测试生成存储过程")
    @PutMapping("/tesWBtProc")
    public ResultUtil testWBProcedure(@RequestBody Map<String, DcProcedure> map) {
        System.out.println(map);
        List<DcProcedure> dcProcedures = new ArrayList<>();
        map.forEach((k, v) -> {
            dcProcedures.add(v);
        });
        // System.out.println (list);
        Map<String, String> sqlMap = new HashMap<>();

        try {

            for (DcProcedure dcProcedure : dcProcedures) {
                String content = "";
                StringBuilder sb = new StringBuilder();
                //获取对照表 tvt
                List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
                DcTableVsTable dcTableVsTable = null;
                if (dcTableVsTables != null && dcTableVsTables.size() > 0) {
                    dcTableVsTable = dcTableVsTables.get(0);
                }
                //获取去向表的名称
                String toTableName = dcTableService.findById(dcTableVsTable.getTo_table_id()).getName();
                //获取  数据库名.框架名.表名
                //String dataBaseSql = getHBIDataBaseSql(dcProcedure.getTo_product_id(), dcTableVsTable.getTo_table_name());
                String dataBaseSql = getHBIDataBaseSql(dcProcedure.getTo_product_id(), dcProcedure.getTo_table_name());
                //开始创建存储过程
                sb.append("         if exists (select * from dbo.sysobjects where id = object_id(N'[dbo].[" + dcProcedure.getName() + "]') and OBJECTPROPERTY(id, N'IsProcedure') = 1) begin DROP procedure [dbo].[" + dcProcedure.getName() + "] end ").append(WebUtil.LineBreak);
                sb.append("          DECLARE @sql VARCHAR(8000)").append(WebUtil.LineBreak);
                sb.append("set @sql=' create proc " + dcProcedure.getName()).append(WebUtil.LineBreak);

                sb.append("as ").append(WebUtil.LineBreak);
                sb.append("begin").append(WebUtil.LineBreak);
                sb.append("begin tran mytran --开启事物").append(WebUtil.LineBreak);
                sb.append("begin try").append(WebUtil.LineBreak);
                sb.append("truncate table  " + dataBaseSql);
                sb.append(" insert into  " + dataBaseSql + dcProcedure.getMap_sql()).append(WebUtil.LineBreak);
                sb.append("commit tran  --提交事物").append(WebUtil.LineBreak);
                sb.append("end try").append(WebUtil.LineBreak);
                sb.append("begin catch ").append(WebUtil.LineBreak);
                sb.append(" rollback tran  --事物回滚").append(WebUtil.LineBreak);
                sb.append("end catch").append(WebUtil.LineBreak);
                sb.append("end '");
                sb.append("EXEC (@sql)     ").append(WebUtil.LineBreak);
                content = sb.toString();
                handleDao.excuteSqlWithSQL(content);
                sqlMap.put(dcProcedure.getName(), content);
            }

            return ResultUtil.success(sqlMap);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
    }

    //数据库名.框架名.表名
    private String getHBIDataBaseSql(String prodectId, String tableName) {
        DcProduct dcProduct = dcProductService.findById(prodectId);
        StringBuilder sb = new StringBuilder();
        sb.append(dcProduct.getDatabase_name() + ".dbo." + tableName);
        return sb.toString();
    }


    @ApiOperation(value = "删除", notes = "删除表映射信息")
    @DeleteMapping("/del")
    public ResultUtil delete(@RequestBody DcTableVsTable dcTableVsTable) {
        try {
            tableVsTableService.delete(dcTableVsTable);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.getCause().toString());
        }
        return ResultUtil.success("删除成功");
    }

    private String getColumnType(DcColumn dcColumn) {
        String type = "";
        if (null == dcColumn.getType_id()) {
            type = "[varchar(255)]";
        } else {
            switch (dcColumn.getType_id()) {
                case 1:
                    type = null != dcColumn.getSize() ? dcColumn.getSize() >= 8000 ? "[varchar(max)]" : "[varchar (" + dcColumn.getSize() + ")]" : "[varchar(255)]";
                    break;
                case 2:
                    type = "[int]";
                    break;
                case 3:
                    type = "[date]";
                    break;
                case 4:
                    type = "[datetime]";
                    break;
                case 5:
                    type = "[numeric(" + dcColumn.getSize() + ", " + dcColumn.getScale() + ")]";
                    break;
            }
        }
        return type;
    }


    @ApiOperation(value = "测试", notes = "测试生成存储过程")
    @PutMapping("/testProcPlus")
    public ResultUtil testProcPlus(@RequestBody DcProcedure dcProcedure) {
        String mapSQL = "";
        String presql_qd = "";
        String joinSQL = "";
        String targetJoinSQL = "";
        String whereSQL = "";



        //目标表名
        String toTableName = dcProcedure.getTo_table_name();
        //来源主表
        String fromMainTableName = dcProcedure.getTable_mian_name();
        //来源表名（可能是多个）
        String fromTableName = dcProcedure.getFrom_table_name();


        //取到链接信息
        String transfer_id = dcProcedure.getTransfer_id();
        DcTransfer dcTrans = dcTransferService.findById(transfer_id);

        String toTimeColumn="";
        if (!"1".equals(dcTrans.getEtlp_type()) && 1 == dcProcedure.getIsparam()) {
            //TVT流化 筛选时间字段不为空且有fromColumn是该时间字段的所有对照集合
            List<DcTableVsTable> collect = dcProcedure.getDcTableVsTables().stream().filter
                    (e -> StringUtil.isNotEmpty(dcProcedure.getTime_column_id()) && dcProcedure.getTime_column_id().equals(e.getFrom_table_column_id())).collect(Collectors.toList());
            //如果有对照关系，则去第一条对照关系，取其中的目标表字段
            if (null != collect && collect.size() > 0) toTimeColumn = collect.get(0).getTo_table_column();
            if(StringUtil.isEmpty(toTimeColumn)){
                return ResultUtil.error("时间参数未参与对照，生成删除语句将没有时间限制！！");
            }
        }

        //取到数据库类型
        String dbType = dcTrans.getFrom_type();
        //取到是否同源同库（1是2否）
        Integer istk = dcTrans.getTo_isogenytk();
        //取到是否同源（1是2否）
        Integer iso = dcTrans.getIsogeny();
        //去向产品数据库名称
        String toDBname = dcTrans.getTo_dbname();
        //链接服务器名称
        String linkName = dcTrans.getName();
        //ETLP类型
        String ETLPtype = dcTrans.getEtlp_type();
        //来源数据库名称
        String dbname = dcTrans.getDbname();
        String product_id = dcTrans.getResource_product_id();
        DcProduct product = dcProductService.findById(product_id);
        String prefix = product.getPrefix();

        //如果来源表是一个或者ETLP类型是1 时
        if ("1".equals(ETLPtype)) {
            //如果数据库是sqlserver时
            if ("SQLOLEDB".equals(dbType)) {
                presql_qd = "select " + fromMainTableName + ".*";
                if ("1".equals(istk)) {
                    mapSQL = "insert into " + toTableName +WebUtil.LineBreak
                            + " select " + fromMainTableName + ".*";
                } else {
                    mapSQL = "insert into " + toDBname + ".dbo." + toTableName +WebUtil.LineBreak+
                            "select " + fromMainTableName + ".*";
                }
            } else {
                mapSQL = "insert into " + toDBname + ".dbo." + toTableName +WebUtil.LineBreak+
                        " select * from " +
                        " openquery(" + linkName + "," + "'select " + fromMainTableName + ".*";
                presql_qd = " select * from openquery(" + linkName + "," + "'select " + fromMainTableName + ".*";
            }
        } else {
            List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
            String leftSql = "";
            String rightSql = "";
            int relationType = 0;
            String zdySql = "";
            String fromTableColumn = "";
            String toTableColumn = "";

            int index =1;
            for (DcTableVsTable tvt : dcTableVsTables) {
                if(index%5==0){
                    leftSql+=WebUtil.LineBreak;
                    rightSql+=WebUtil.LineBreak;
                }
                index++;
                if (null == tvt.getDc_relation_replace_type_id()) {
                    relationType=1;
                }else{
                    relationType = tvt.getDc_relation_replace_type_id();
                }

                zdySql = (StringUtil.isNotEmpty(tvt.getRelation_replace_sql()) ? tvt.getRelation_replace_sql() : "null");
                fromTableColumn = (StringUtil.isNotEmpty(tvt.getFrom_table_column()) ? tvt.getFrom_table_column() : "null");
                toTableColumn = tvt.getTo_table_column();

                if (relationType != 7) {
                    rightSql = rightSql + toTableColumn + ",";
                }

                //SQL替换
                if (relationType == 2) {
                    leftSql = leftSql + "(" + zdySql + ") AS " + toTableColumn + ",";
                    if(index%5!=0) leftSql+=WebUtil.LineBreak;
                }
                //空值替换
                else if (relationType == 3) {
                    leftSql = leftSql + "ISNULL(" + fromTableColumn + ",'" + zdySql + "') AS " + toTableColumn + ",";
                }
                //日期格式化
                else if (relationType == 4) {
                    switch (zdySql) {
                        case "520":
                            leftSql = leftSql + "REPLACE(REPLACE(CONVERT(varchar(100), " +
                                    "case when isdate(convert(varchar,"+fromTableColumn+")) =1 \n" +
                                    "then  cast ("+fromTableColumn+" as datetime) \n" +
                                    "else convert(varchar(19),"+fromTableColumn+") end " +
                                    " ,20) ,'-',''),':','') AS " + toTableColumn + ",";
                            break;
                        case "521":
                            leftSql = leftSql + "REPLACE(REPLACE(REPLACE(CONVERT(varchar(100), " +
                                    //"cast(" + fromTableColumn + " AS datetime)" +
                                    "case when isdate(convert(varchar,"+fromTableColumn+")) =1 \n" +
                                    "then  cast ("+fromTableColumn+" as datetime)  \n" +
                                    "else convert(varchar(19),"+fromTableColumn+") end " +
                                    ",20),'-',''),':',''),' ','') AS " + toTableColumn + ",";
                            break;
                        default:
                            leftSql = leftSql + "CONVERT(varchar(100), " +
                                    //"cast(" + fromTableColumn + " AS datetime)," +
                                    "case when isdate(convert(varchar,"+fromTableColumn+")) =1 \n" +
                                    "then  cast ("+fromTableColumn+" as datetime) \n" +
                                    "else convert(varchar(19),"+fromTableColumn+") end" +
                                    "," + zdySql + ") AS " + toTableColumn + ",";
                    }
                }
                //字典转化
                else if (relationType == 5) {
                    if(StringUtil.isEmpty(zdySql) || null ==tvt.getMap_type()){
                        return ResultUtil.error("字典对照未完成，未对照字段字段：【"+tvt.getTo_table_column()+"】");
                    }
                    DcColumn column = dcColumnService.findById(zdySql);
                    Integer dict_id = column.getDict_id();
                    String colName=column.getColumn_name();
                    if (1 == tvt.getMap_type()) {
                        leftSql = leftSql + "(select hp_key from  dl_merge..hp_dict_map a where a.his_code='" + tvt.getMap_code() +
                                "' and a.his_name='" + tvt.getMap_code_name() + "' and a.dict_talbe_id='" + dict_id + "' and hp_column_name= '"+colName+"'  and a.his_key=" + fromTableColumn +
                                ") AS " + toTableColumn + ",";
                    } else {
                        leftSql = leftSql + "(select his_key from  dl_merge..hp_dict_map a where a.his_code='" + tvt.getMap_code() +
                                "' and a.his_name='" + tvt.getMap_code_name() + "' and a.dict_talbe_id='" + dict_id + "' and hp_column_name= '"+colName+"'  and a.hp_key=" + fromTableColumn +
                                ") AS " + toTableColumn + ",";
                    }
                    if(index%5!=0) leftSql+=WebUtil.LineBreak;
                }
                //地址截取
                else if (relationType == 6) {
                    leftSql = leftSql + "dbo.getdz(" + fromTableColumn + ",'" + zdySql + "') AS " + toTableColumn + ",";
                }
                //自增主键
                else if (relationType == 7) {
                    System.out.println(1111);
                }
                //编码转化
                else if (relationType == 8) {
                    if(StringUtil.isEmpty(zdySql) || null ==tvt.getIs_history()){
                        return ResultUtil.error("编码转化未完成，未对照字段：【"+tvt.getTo_table_column()+"】");
                    }
                    String[] a1 = {"hp_history_iccm_dz", "hp_history_icd_dz", "hp_history_tumour_dz", "hp_history_sszd_dz", "hp_history_zybzf_dz"};
                    String[] a2 = {"hp_ICCMAutoDz", "hp_ICDAutoDz", "hp_TumourAutoDz", "hp_SSZDAutoDz", "hp_ZYBZFAutoDz"};
                    leftSql = leftSql + "isnull((select ";
                    //历史版本对照
                    if (1 == tvt.getIs_history()) {
                        leftSql += "report_";
                        leftSql += (1 == tvt.getDmormc() ? "dm" : "mc");
                        leftSql = leftSql + " from ";
                        leftSql += a1[tvt.getBm_type()];
                        leftSql += " where ";
                        leftSql += "use_";
                        leftSql += (1 == tvt.getDmormc() ? "dm" : "mc");
                        leftSql = leftSql + " =" + fromTableColumn;
                        leftSql = leftSql + " and report_version = " + zdySql;
                        leftSql = leftSql + " ), " + fromTableColumn + ") AS " + toTableColumn + ",";
                    } else {//标准对照
                        Map<Integer, List<SysDictVal>> bmMap = (Map<Integer, List<SysDictVal>>) ApplicationRunnerImpl.contextMap.get("baBmMap");
                        List<SysDictVal> sysDictVals = bmMap.get("89");
                        List<SysDictVal> sysDictVals1 = bmMap.get("88");
                        //eg:lc_2_0
                        String remark = "";
                        for (SysDictVal dv : sysDictVals) {
                            if (dv.getVal() == zdySql) remark = dv.getRemark();
                        }
                        leftSql = leftSql + remark;
                        leftSql += (1 == tvt.getDmormc() ? "dm" : "mc");
                        leftSql = leftSql + " from ";
                        leftSql += (1 == tvt.getIs_history() ? a1[tvt.getBm_type()] : a2[tvt.getBm_type()]);
                        leftSql += " where ";

                        for (SysDictVal dv : sysDictVals) {
                            if (dv.getVal().equals(tvt.getBm_type())) {
                                leftSql += dv.getRemark();
                            }
                        }

                        leftSql += (1 == tvt.getDmormc() ? "dm" : "mc");
                        leftSql = leftSql + " =" + fromTableColumn;
                        if (1 == tvt.getIs_history()) leftSql = leftSql + " and report_version = " + zdySql;
                        leftSql = leftSql + " ), " + fromTableColumn + ") AS " + toTableColumn + ",";
                    }
                    if(index%5!=0) leftSql+=WebUtil.LineBreak;
                }
                //无操作或者没选
                else {
                    leftSql = leftSql + fromTableColumn + " AS " + toTableColumn + ",";
                }
            }


            //TODO 截取最后一个逗号可能出错
            mapSQL = "insert into " + (!"1".equals(istk) ? toDBname + ".dbo." : "") + toTableName + " (" + rightSql.substring(0, rightSql.lastIndexOf(",")) + " ) " +WebUtil.LineBreak+
                    "select " + leftSql.substring(0, leftSql.lastIndexOf(","));
            presql_qd = "select " + leftSql.substring(0, leftSql.lastIndexOf(","));


        }

        List<DcVirtualTable> dcvirtualTables = dcProcedure.getDcvirtualTables();
        String pre = "";

        if (dbType.contains("OraOLEDB.Oracle")) {
            pre = "";
        } else {
            if (null != iso && iso == 1) {
                pre = dbname + ".dbo.";
            } else {
                pre = linkName + "." + dbname + ".dbo.";
            }
        }
        if(CollUtil.isNotEmpty(dcvirtualTables)){
            String relation_talbe_name= dcvirtualTables.get(0).getRelation_talbe_name();
            joinSQL = " from " + pre + relation_talbe_name + " " + relation_talbe_name+WebUtil.LineBreak;
            targetJoinSQL = " from " + prefix + relation_talbe_name + " " + relation_talbe_name+WebUtil.LineBreak;
            for (DcVirtualTable dv : dcvirtualTables) {
                String ownName = "";
                String ownColumn = "";
                if (StringUtil.isNotEmpty(dv.getSon_table_oname())) {
                    ownName = dv.getSon_table_oname();
                    ownColumn = ownName + "." + dv.getSon_column_name().split("\\.")[1];
                } else {
                    ownName = dv.getSon_table_name();
                    ownColumn = dv.getSon_column_name();
                }

                if (StringUtil.isNotEmpty(dv.getRelation_column_name()) || StringUtil.isNotEmpty(dv.getSon_column_name())) {
                    joinSQL = joinSQL + " left join " + pre + dv.getSon_table_name() + " " + ownName + " on " + dv.getRelation_column_name() + "=" + ownColumn;
                    targetJoinSQL = targetJoinSQL + " left join " + prefix + dv.getSon_table_name() + " " + ownName + " on " + dv.getRelation_column_name() + "=" + ownColumn;
                    if (StringUtil.isNotEmpty(dv.getSupplement_sql())) {
                        joinSQL = joinSQL + " and " + dv.getSupplement_sql();
                        targetJoinSQL = targetJoinSQL + " and " + dv.getSupplement_sql();
                    }
                    joinSQL+=WebUtil.LineBreak;
                    targetJoinSQL+=WebUtil.LineBreak;
                }
            }
        }else{
            joinSQL = " from " + pre + fromMainTableName + " " + fromMainTableName+WebUtil.LineBreak;;
            targetJoinSQL = " from " + prefix + fromMainTableName + " " + fromMainTableName+WebUtil.LineBreak;;
        }





        dcProcedure.setMap_sql(mapSQL);
        dcProcedure.setJoin_sql(joinSQL);
        dcProcedure.setPresql_qd(presql_qd);
        dcProcedure.setTarget_join_sql(targetJoinSQL);
        String content = tableVsTableService.testProcedure(dcProcedure);
        handleDao.excuteSqlWithSQL(content);
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("content",content);
        resultMap.put("mapSQL",mapSQL);
        resultMap.put("joinSQL",joinSQL);
        resultMap.put("presql_qd",presql_qd);
        resultMap.put("targetJoinSQL",targetJoinSQL);

        return ResultUtil.success(resultMap, "测试成功");
    }
}