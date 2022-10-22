package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.controller.DcTableController;
import com.sxdl.product.dc.dao.dao1.*;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.DcProcedureService;
import com.sxdl.product.dc.service.DcScheduleConfigService;
import com.sxdl.product.dc.service.DcScheduleService;
import com.sxdl.product.dc.util.DirectLinkLibraryUtil;
import com.sxdl.product.dc.util.WebSoapUtil;
import com.sxdl.product.dc.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service("dcProcedureService")
@Transactional
public class DcProcedureServiceImpl extends BaseUUIDServiceImpl<DcProcedure> implements DcProcedureService {

    @Autowired
    DcProductDao dcProductDao;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private DcColumnDao dcColumnDao;
    @Autowired
    private DcProcedureDao dcProcedureDao;
    @Autowired
    private DcTableVsTableDao dcTableVsTableDao;
    @Autowired
    private DcVirtualTableDao dcVirtualTableDao;
    @Autowired
    private DcRequestAPIDao dcRequestAPIDao;
    @Autowired
    private DcTransferDao dcTransferDao;
    @Autowired
    private DcScheduleDao dcScheduleDao;
    @Autowired
    private DcScheduleService dcScheduleService;
    @Autowired
    private DcScheduleConfigService dcScheduleConfigService;

    @Autowired
    private DcTableController tableController;

    /**
     * 手工抽取直联库下的全部数据
     *
     * @param transferId 直联库id
     * @param start      开始
     * @param end        结束
     * @return 执行结果
     * @throws Exception
     */
    public String extractDateAll(String transferId, String start, String end,String bah) throws Exception {
        //设置默认值,昨天
        if (StrUtil.isEmpty(start)) {
            start = DateUtil.formatFromDate(DateUtil.yesterday());
        }
        //设置默认值,今天
        if (StrUtil.isEmpty(end)) {
            end = DateUtil.formatFromDate(new Date());
        }
        DcProcedure dcProcedure = new DcProcedure();
        dcProcedure.setTransfer_id(transferId);
        List<DcProcedure> dcProcedures = dcProcedureDao.select(dcProcedure);
        if (CollUtil.isEmpty(dcProcedures)) {
            return "该直联库下还没有配置字段映射!";
        }
        StringBuilder sb = new StringBuilder();
        String paras;
        for (DcProcedure dp : dcProcedures) {
            //如果是有时间范围参数的存储,传入参数
            paras="";
            if (1 == dp.getIsparam()) {
                dp.setStime(start);
                dp.setEtime(end);
                if("1".equals(dp.getSupport_single())){
                    dp.setBah(bah);
                }
                paras=start+", "+end;
            }
            if (StrUtil.isEmpty(dp.getName())) {
                dcProcedures.remove(dp);
                sb.append(dp.getId() + "该DcProcedure名称是空的,联系管理员查看!<br>");
                continue;
            }
            List<Map<String, Object>> s = extractDate(dp);
            if (CollUtil.isEmpty(s)) {
                if(2==dp.getProc_type() ){
                    sb.append( "●"+"自定义存储：" + dp.getName() + "执行成功!<br>");
                }else{
                    sb.append( dp.getId() + " " + dp.getName() + "该DcProcedure返回值是空的,联系管理员查看!<br>");
                }
                continue;
            }
            if (1 == dp.getIsparam()) {
                if("1".equals(dp.getSupport_single())){
                    paras+=","+bah;
                }
                sb.append("●"+dp.getName() +",参数是:"+paras+"; <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该存储过程执行结果:" + s.get(0)+"<br>");
            }else{
                sb.append("●"+dp.getName() +" 该存储过程执行结果:" + s.get(0)+"<br>");
            }
        }
        return sb.toString();
    }

    /**
     * 执行手动抽取数据
     *
     * @param dcProcedure 存储信息
     * @return 执行结果
     * @throws Exception
     */
    public List<Map<String, Object>> extractDate(DcProcedure dcProcedure) throws Exception {
        String procedureName = dcProcedure.getName();
//        String to_table_id = dcProcedure.getTo_table_id();
//        DcTable byId = dcTableDao.selectByPrimaryKey(to_table_id);
//        String toTableName = "";
//        String to_product_id = dcProcedure.getTo_product_id();
//        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(to_product_id);
//        if (!"dc".equals(dcProduct.getShort_name())) {
//            DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
//            String dbname = dcTransfer.getDbname();
//            String transfername = dcTransfer.getName();
//            if (dcTransfer.getIsogeny() == 0) {
//                //是否同源 不同源更改表 名称 拼接链接服务器
//                toTableName = transfername + "." + dbname + ".dbo." + byId.getName();
//            } else {
//                toTableName = dbname + ".dbo." + byId.getName();
//            }
//        } else {
//            toTableName = byId.getName();
//        }
//        int Scount = handleDao.countSum(toTableName);
        if (1 == dcProcedure.getIsparam()) {
            String start = dcProcedure.getStime();
            String end = dcProcedure.getEtime();
            if("1".equals(dcProcedure.getSupport_single())){
                String bah = dcProcedure.getBah();
                return handleDao.excuteProcedueWithFourParams(procedureName, start, end,bah);
            }
            return handleDao.excuteProcedueWithParams(procedureName, start, end);
        } else {
            return handleDao.excuteProcedue(procedureName);
        }
    }

    @Override
    public void updateTable(DcProcedure dcProcedure) {
        dcProcedureDao.updateByPrimaryKeySelective(dcProcedure);
        DcTable dcTable = dcTableDao.selectByName(dcProcedure.getTable_mian_name());
        dcTable.setName_zh(dcProcedure.getTable_mian_name_zh());
        dcTableDao.insertSelective(dcTable);
    }

    @Override
    public List<DcProcedure> findByScheduleId(Integer Schedule_id) {
        return dcProcedureDao.findByScheduleId(Schedule_id);
    }

    @Override
    public void updateByPrimaryKeySelective(DcProcedure dcProcedure) {
        dcProcedureDao.updateByPrimaryKeySelective(dcProcedure);
    }


    /***
     * 原表到表准表的映射关系以及数据抽取的存储过程的处理保存
     * @param dcProcedure
     */
    @Override
    public void saveMappingTable(DcProcedure dcProcedure) {


        String stype = "";
        dcProcedure.setProduct_id(dcProcedure.getTo_product_id());
        DcProduct p = dcProductDao.selectByPrimaryKey(dcProcedure.getTo_product_id());
        if ("dc".equals(p.getShort_name())) {
            stype = "todc";
        } else {
            stype = "fromdc";
        }
        //设置处理前置sql
        String presql="";
        DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
        presql=dcProcedure.getPresql_qd()+" "+dcProcedure.getJoin_sql();

        String toTimeColumn="";
        if ("1".equals(dcTransfer.getEtlp_type())) {
            toTimeColumn =dcProcedure.getTime_column_name();
        }
        //如果不是抽取外部数据库，那么就需要根据TVT进行查找该时间字段对应的目标表字段
        else{
            //TVT流化 筛选时间字段不为空且有fromColumn是该时间字段的所有对照集合
            List<DcTableVsTable> collect = dcProcedure.getDcTableVsTables().stream().filter
                    (e -> StringUtil.isNotEmpty(dcProcedure.getTime_column_id()) && dcProcedure.getTime_column_id().equals(e.getFrom_table_column_id())).collect(Collectors.toList());
            //如果有对照关系，则去第一条对照关系，取其中的目标表字段
            if (null != collect && collect.size() > 0) toTimeColumn = collect.get(0).getTo_table_column();
        }
        dcProcedure.setTo_table_time_column(toTimeColumn);
        dcProcedure.setProc_type(1);
        if(dcTransfer.getFrom_type().toLowerCase().contains("oraoledb")){
            //如果有时间条件，则需要加上时间条件的限制
            if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                    presql+=" where To_CHAR("+dcProcedure.getTime_column_name()+",''YYYY-MM-DD'')" + " between ''@startDate''  and ''@endDate'' ";
                    if(StringUtil.isNotEmpty(dcProcedure.getWhere_sql().trim())) presql+="  and " + dcProcedure.getWhere_sql().replace("'", "''");
                    presql+=" ')";
            }
        }else{
            if (null != dcProcedure.getTime_column_name() && (!"".equals(dcProcedure.getTime_column_name()))) {
                    presql += " where CONVERT(varchar(100), case when isdate(convert(varchar," + dcProcedure.getTime_column_name() + ")) =1 then  cast (" + dcProcedure.getTime_column_name() + " as datetime) " +
                            "else convert(varchar(19)," + dcProcedure.getTime_column_name() + ") end , 23)  between  ''+@startDate+'' and  ''+@endDate+'' ";
                    if(StringUtil.isNotEmpty(dcProcedure.getWhere_sql().trim())) presql += "  and " + dcProcedure.getWhere_sql();
            }
        }

        if(StringUtil.isNotEmpty(presql)) {
            dcProcedure.setPresql(presql);
        }
        if (null == dcProcedure.getId()) {
            //获取主表名称  同时查询出原表的调度规则
            //dcProcedure.setIsparam(1);
            //TODO 暂时性的让页面设置tag
          /*  if(dcProcedure.getTable_mian_name().equals("dl_dc")){
                dcProcedure.setTag("1");
            }*/
            dcProcedure.setTag(dcProcedure.getTable_mian_name());
            dcProcedureDao.insertSelective(dcProcedure);

            //获取 insert  into select * 的关系 保存用于回显
            List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
            if (null != dcTableVsTables) {
//                dcTableVsTables.forEach(E -> {
//                    E.setProcedure_id(dcProcedure.getId());
//                    dcTableVsTableDao.insertSelective(E);
//                });
                for (int i = 0; i < dcTableVsTables.size(); i++) {
                    dcTableVsTables.get(i).setProcedure_id(dcProcedure.getId());
                    dcTableVsTables.get(i).setOrdernum(i);
                    dcTableVsTableDao.insertSelective(dcTableVsTables.get(i));
                }
            }
            //获取 left join 的关系  保存用于回显
            List<DcVirtualTable> dcvirtualTables = dcProcedure.getDcvirtualTables();

            if (null != dcvirtualTables) {
                for (DcVirtualTable dcvirtualTable : dcvirtualTables) {
                    dcvirtualTable.setProcedure_id(dcProcedure.getId());
                    dcVirtualTableDao.insertSelective(dcvirtualTable);
                }
            }
        } else {
            dcProcedure.setTag(dcProcedure.getTable_mian_name());
            //dcProcedure.setIsparam(1);
            dcProcedureDao.updateByPrimaryKey(dcProcedure);
            List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
            if (null != dcTableVsTables) {
                DcTableVsTable dcTableVsTable = new DcTableVsTable();
                dcTableVsTable.setProcedure_id(dcProcedure.getId());
                dcTableVsTableDao.delete(dcTableVsTable);
//                dcTableVsTables.forEach(e -> {
//                    e.setProcedure_id(dcProcedure.getId());
//                    dcTableVsTableDao.insertSelective(e);
//                });
                for (int i = 0; i < dcTableVsTables.size(); i++) {
                    dcTableVsTables.get(i).setProcedure_id(dcProcedure.getId());
                    dcTableVsTables.get(i).setOrdernum(i);
                    dcTableVsTableDao.insertSelective(dcTableVsTables.get(i));
                }
            }
            List<DcVirtualTable> dcvirtualTables = dcProcedure.getDcvirtualTables();

            if (null != dcvirtualTables) {
                DcVirtualTable dcVirtualTable = new DcVirtualTable();
                dcVirtualTable.setProcedure_id(dcProcedure.getId());
                dcVirtualTableDao.delete(dcVirtualTable);
                dcvirtualTables.forEach(e -> {
                            e.setProcedure_id(dcProcedure.getId());
                            dcVirtualTableDao.insertSelective(e);
                        }
                );
            }
        }

    }

    @Override
    public void saveMappingWBTable(List<DcProcedure> dcProcedures) {
        for (DcProcedure dcProcedure : dcProcedures) {
            String schedule_id = null;
            String table_mian_name = dcProcedure.getTable_mian_name();
            DcRequestAPI dcRequestAPI = new DcRequestAPI();
            dcRequestAPI.setTag(table_mian_name);
            List<DcRequestAPI> select = dcRequestAPIDao.select(dcRequestAPI);
            if (select.size() > 0) {
                schedule_id = select.get(0).getSchedule_id();
            } else {
                DcProcedure dcProcedure1 = new DcProcedure();
                dcProcedure1.setTag(table_mian_name);
                List<DcProcedure> select1 = dcProcedureDao.select(dcProcedure1);
                schedule_id = select1.get(0).getSchedule_id();
            }
            if (null == dcProcedure.getId()) {
                dcProcedure.setSchedule_id(schedule_id);
                dcProcedure.setIsparam(3);
                dcProcedureDao.insertSelective(dcProcedure);
                if (dcProcedure.getType_id().equals(4)) {
                    List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
                    if (null != dcTableVsTables) {
                        dcTableVsTables.forEach(E -> {
                            E.setProcedure_id(dcProcedure.getId());
                            dcTableVsTableDao.insertSelective(E);
                        });
                    }
                }
            } else {
                dcProcedure.setSchedule_id(schedule_id);
                dcProcedure.setIsparam(3);
                dcProcedureDao.updateByPrimaryKey(dcProcedure);
                if (dcProcedure.getType_id().equals(4)) {
                    List<DcTableVsTable> dcTableVsTables = dcProcedure.getDcTableVsTables();
                    if (null != dcTableVsTables) {
                        dcTableVsTables.forEach(e -> {
                            dcTableVsTableDao.updateByPrimaryKey(e);
                        });
                    }
                }
            }
        }
    }

    @Override
    public List<DcProcedure> findByName(String str) {
        return dcProcedureDao.findByName(str);
    }

    @Override
    public void saveTableColumn(String product_id, String transfername, String dbname, String tableName, String tableName_zh, String fromType, Integer iscreateatdc,String etltype) {
        // 更新 table columns 表
        //DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(dcProcedure.getTransfer_id());
        //String sqlcolums = handleDao.execSelectSql("select stuff((SELECT ','+ convert(varchar(5000),name)    FROM SYSCOLUMNS WHERE ID=OBJECT_ID('" + tableName + "' ) for xml path('')),1,1,'')");
        String tableColumssql = DirectLinkLibraryUtil.getTableColums(transfername, dbname, tableName, fromType);
        String sqlcolums = handleDao.execSelectSql(tableColumssql);
        List<String> lists = Arrays.asList(sqlcolums.split(","));
        List<String> listColumns = new ArrayList<>();
        listColumns.addAll(lists);

        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(product_id);
        String prefix = dcProduct.getPrefix();
        String preTableName=prefix+tableName;

        //查询所选产品下有无该表，有则更新，无则插入
        List<DcTable> dcTableList = dcTableDao.selectByNameAndProdect(tableName, product_id, "");
                //表不存在
        if (null == dcTableList || dcTableList.size() <= 0) {
            DcTable table = new DcTable();
            table.setName(tableName);
            table.setName_zh(tableName_zh);
            if("1".equals(etltype)){
                table.setType_id(1);
            }else if("2".equals(etltype)){
                table.setType_id(2);
            }else if("3".equals(etltype)){
                table.setType_id(3);
            }
            //设置表类型为视图
            table.setType_id(7);

            table.setIs_public(1);
            table.setProduct_id(product_id);
            table.setIsexist("0");
            dcTableDao.insertSelective(table);
            listColumns.forEach(col -> {
                DcColumn dcColumn = new DcColumn();
                dcColumn.setTable_id(table.getId());
                dcColumn.setTable_name(tableName);
                dcColumn.setType_id(1);
                dcColumn.setType("字符串");
                dcColumn.setColumn_name(col);
                dcColumn.setColumn_name_zh(col);
                dcColumn.setSize(5000);
                dcColumnDao.insertSelective(dcColumn);
            });
        }
        //表存在
        else {
            DcTable dcTable = dcTableList.get(0);

            //查询库中现有表的所有字段
            List<DcColumn> dcColumns = dcColumnDao.selectByTableid(dcTable.getId());
            //循环现有字段，将前端传来的字段集合中的所有现有字段移除
            for (DcColumn dc : dcColumns) {
                listColumns.remove(dc.getColumn_name());
            }

            //如果集合还有数据表示有新增字段
            if (listColumns.size() > 0) {
                listColumns.forEach(col -> {
                    DcColumn dcCol = new DcColumn();
                    dcCol.setTable_id(dcTable.getId());
                    dcCol.setTable_name(tableName);
                    dcCol.setColumn_name(col);
                    dcCol.setColumn_name_zh(col);
                    dcCol.setType_id(1);
                    dcCol.setType("字符串");
                    dcCol.setSize(5000);
                    dcColumnDao.insertSelective(dcCol);
                });
            }

            dcTable.setName(tableName);
            dcTable.setName_zh(tableName_zh);
            dcTableDao.updateByPrimaryKey(dcTable);
        }


        //如果参数为1，则代表需要在dc里创建
        if(null!=iscreateatdc && 1==iscreateatdc){
            //再查询dc下有无该表，如果勾选了生成dc源表，则除了需要创建表结构外，还需要再dc里生成实体表
            List<DcTable> dcTableList2 = dcTableDao.selectByNameAndProdect(preTableName, "C9BA5D39-4CD0-4D6B-B03A-12766FC87D57", "");

            if (null == dcTableList2 || dcTableList2.size() <= 0){
                DcTable table = new DcTable();
                table.setName(preTableName);
                table.setName_zh(prefix+tableName_zh);
                table.setType_id(1);
                table.setIs_public(1);
                table.setProduct_id("C9BA5D39-4CD0-4D6B-B03A-12766FC87D57");
                table.setIsexist("0");
                dcTableDao.insertSelective(table);
                listColumns.forEach(col -> {
                    DcColumn dcColumn = new DcColumn();
                    dcColumn.setTable_id(table.getId());
                    dcColumn.setTable_name(preTableName);
                    dcColumn.setType_id(1);
                    dcColumn.setType("字符串");
                    dcColumn.setColumn_name(col);
                    dcColumn.setColumn_name_zh(col);
                    dcColumn.setSize(5000);
                    dcColumnDao.insertSelective(dcColumn);
                });
                //表结构存储完成之后，更新数据库
                tableController.renewDatabase(table.getId());
            }else{
                DcTable dcTable = dcTableList2.get(0);

                List<DcColumn> dcColumns = dcColumnDao.selectByTableid(dcTable.getId());
                for (DcColumn dc : dcColumns) {
                    listColumns.remove(dc.getColumn_name());
                }

                //集合有数据表示有新增字段
                if (listColumns.size() > 0) {
                    listColumns.forEach(col -> {
                        DcColumn dcCol = new DcColumn();
                        dcCol.setTable_id(dcTable.getId());
                        dcCol.setTable_name(preTableName);
                        dcCol.setColumn_name(col);
                        dcCol.setColumn_name_zh(col);
                        dcCol.setType_id(1);
                        dcCol.setType("字符串");
                        dcCol.setSize(5000);
                        dcColumnDao.insertSelective(dcCol);
                    });
                }

                dcTable.setName(tableName);
                dcTable.setName_zh(tableName_zh);
                dcTableDao.updateByPrimaryKey(dcTable);
                //表结构存储完成之后，更新数据库
                tableController.renewDatabase(dcTable.getId());
            }
        }
    }

    @Override
    public DcProcedure findByToNameAndType(DcProcedure dcProcedure) {
        List<DcProcedure> dcProcedureList = dcProcedureDao.select(dcProcedure);
        return dcProcedureList != null && dcProcedureList.size() > 0 ? dcProcedureList.get(0) : null;
    }


    /**
     * 直连库自动抽取数据 第一步:抽取原表数据
     *
     * @param jsonArray
     */
    @Override
    public void saveAutoEverySql(JSONArray jsonArray) throws Exception {
        for (Object obj : jsonArray) {
            //String rule_id =  ((JSONObject) obj).get("rule_id").toString();
            String startTime = "";
            String endTime = "";

            //获取调度频率值
            Integer rate = Integer.parseInt(((JSONObject) obj).get("param").toString());
            //获取调度频率的单位（时、分、天、月....）
            String param_unit = ((JSONObject) obj).get("param_unit").toString();
            //获取抽取范围 时间单位固定是天  （抽取范围一定大于调度频率、而维度表【不需要时间范围的web接口】 不计算在内）
            Integer scope = Integer.parseInt(((JSONObject) obj).get("scope").toString());
            Integer rule_id = Integer.parseInt(((JSONObject) obj).get("rule_id").toString());

            List<DcProcedure> listProcs = findByScheduleId(rule_id);
            for (DcProcedure proc : listProcs) {

                String sqlProcText = "";
                String procname = proc.getName();
                Integer isparam = proc.getIsparam();
                String tablename = proc.getTable_mian_name();
                String columnname = proc.getTime_column_name();
                Integer timeLenth = proc.getTiem_length();
                DcTransfer dcTransfer = dcTransferDao.selectByPrimaryKey(proc.getTransfer_id());
                String dbname = dcTransfer.getDbname();
                String transfername = dcTransfer.getName();
                String fromType = dcTransfer.getFrom_type();
                String tableColumssql = DirectLinkLibraryUtil.getTableColums(transfername, dbname, tablename, fromType);
                String tableColums = handleDao.execSelectSql(tableColumssql);

                String columsAndType = null;
                String selectColumns = null;
                if (fromType.equals("SQLOLEDB")) {
                    tableColumssql = DirectLinkLibraryUtil.getTableColums(transfername, dbname, tablename, fromType);
                    tableColums = handleDao.execSelectSql(tableColumssql);
                    columsAndType = DirectLinkLibraryUtil.getColumsAndType(transfername, dbname, tablename);
                    selectColumns = handleDao.execSelectSql(columsAndType);
                    if (3 == isparam) { //获取不带参数的存储过程sql脚本
                        sqlProcText = DirectLinkLibraryUtil.getProc(transfername, dbname, procname, tablename, tableColums, selectColumns);
                    } else if (1 == isparam) {//获取带参数(时间范围)的存储过程sql脚本
                        sqlProcText = DirectLinkLibraryUtil.getProcParam(transfername, dbname, procname, tablename, columnname, timeLenth, tableColums, selectColumns);
                    }
                } else if (fromType.equals("DB2OLEDB")) {
                    columsAndType = DirectLinkLibraryUtil.getColumsAndTypeOfDB2(transfername, dbname, tablename);
                    selectColumns = handleDao.execSelectSql(columsAndType);
                    tableColumssql = DirectLinkLibraryUtil.getTableColumsOfDB2(transfername, dbname, tablename);
                    tableColums = handleDao.execSelectSql(tableColumssql);
                    if (3 == isparam) { //获取不带参数的存储过程sql脚本
                        sqlProcText = DirectLinkLibraryUtil.getProcOfDB2(transfername, dbname, procname, tablename, tableColums, selectColumns);
                    } else if (1 == isparam) {//获取带参数(时间范围)的存储过程sql脚本
                        sqlProcText = DirectLinkLibraryUtil.getProcParamOfDB2(transfername, dbname, procname, tablename, columnname, timeLenth, tableColums, selectColumns);
                    }
                } else {
                    columsAndType = DirectLinkLibraryUtil.getColumsAndTypeOfOracle(transfername, dbname, tablename);
                    selectColumns = handleDao.execSelectSql(columsAndType);
                    tableColumssql = DirectLinkLibraryUtil.getTableColumsOfOrcale(transfername, dbname, tablename);
                    tableColums = handleDao.execSelectSql(tableColumssql);
                    if (3 == isparam) { //获取不带参数的存储过程sql脚本
                        sqlProcText = DirectLinkLibraryUtil.getProcOfOracle(transfername, dbname, procname, tablename, tableColums, selectColumns);
                    } else if (1 == isparam) {//获取带参数(时间范围)的存储过程sql脚本
                        sqlProcText = DirectLinkLibraryUtil.getProcParamOfCracle(transfername, dbname, procname, tablename, columnname, timeLenth, tableColums, selectColumns);
                    }
                }
                handleDao.excuteSqlWithSQL(sqlProcText);
                //保存 table  columns 表
                //saveTableColumn(proc.getProduct_id(), proc.getTable_mian_name(), proc.getTable_mian_name_zh());
                //saveTableColumn(proc.getProduct_id(), transfername, dbname, proc.getTable_mian_name(), proc.getTable_mian_name_zh(), fromType,0);
                String name = "";
                if (3 == proc.getIsparam()) {//无参数
                    name = proc.getName();
                    handleDao.excuteCallProcedue(name);
                } else if (1 == proc.getIsparam()) { //时间范围参数胡
                    startTime = WebSoapUtil.getAutoStartTiem(10, scope);
                    //结束时间
                    endTime = WebSoapUtil.getAutoEndDateTime(10);
                    List<String> splicTimeParam = WebSoapUtil.getSplicTimeParam(startTime, endTime, param_unit, rate);
                    for (String param : splicTimeParam) {
                        LinkedHashMap<String, String> keyValues = WebSoapUtil.getKeyValues(param);
                        handleDao.excuteCallProcedueWithParams(proc.getName(), keyValues.get("startDate"), keyValues.get("endDate"));
                    }
                }
            }
        }
    }

    @Override
    public List<DcProcedure> selectByIds(String substring) {
        return dcProcedureDao.selectByIds(substring);
    }
    /**
     * 调度到 维表
     *
     * @param jsonArray
     */
    @Override
    public void saveAutoEverySql2(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            String s_id = ((JSONObject) obj).get("id").toString();
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setSchedule_id(s_id);
            dcProcedure.setType_id(4);
            List<DcProcedure> byScheduleId = dcProcedureDao.select(dcProcedure);
            if (byScheduleId.size() > 0) {
                for (DcProcedure procedure : byScheduleId) {
                    String procedureName = procedure.getName();
                    handleDao.excuteCallProcedue(procedureName);
                }
            }
            //由于担心缓存问题重新赋值
            dcProcedure = new DcProcedure();
            dcProcedure.setSchedule_id(s_id);
            dcProcedure.setType_id(8);
            if (byScheduleId.size() > 0) {
                byScheduleId = dcProcedureDao.select(dcProcedure);
                for (DcProcedure procedure : byScheduleId) {
                    String procedureName = procedure.getName();
                    handleDao.excuteCallProcedue(procedureName);
                }
            }
        }
    }

    /**
     * 调度到 标准表 type= 2
     *
     * @param jsonArray
     */
    @Override
    public void saveAutoEverySql3(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            String startTime = "";
            String endTime = "";

            //获取调度频率值
            //获取调度频率的单位（时、分、天、月....）
            //获取抽取范围 时间单位固定是天  （抽取范围一定大于调度频率、而维度表【不需要时间范围的web接口】 不计算在内）
//                Integer scope =  Integer.parseInt(((JSONObject) obj).get("scope").toString());
            Integer scope = 0;
            if (null != String.valueOf(((JSONObject) obj).get("scope")) && !"".equals(String.valueOf(((JSONObject) obj).get("scope"))) && !"null".equals(String.valueOf(((JSONObject) obj).get("scope")))) {
                scope = Integer.parseInt(String.valueOf(((JSONObject) obj).get("scope")));
            }
            startTime = WebSoapUtil.getAutoStartTiem(10, scope);
            endTime = WebSoapUtil.getAutoEndDateTime(10);
//                Integer s_id =  Integer.parseInt(((JSONObject) obj).get("id").toString());
            String s_id = String.valueOf(((JSONObject) obj).get("id"));
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setSchedule_id(s_id);
            dcProcedure.setType_id(2);
            List<DcProcedure> byScheduleId = dcProcedureDao.select(dcProcedure);
            if (byScheduleId.size() > 0) {
                for (DcProcedure procedure : byScheduleId) {
                    String procedureName = procedure.getName();
                    if (1 == procedure.getIsparam()) {//时间参数的存储过程
                        handleDao.excuteCallProcedueWithParams(procedureName, startTime, endTime);
                    } else if (3 == procedure.getIsparam()) {//无参的存储过程
                        handleDao.excuteCallProcedue(procedureName);
                    }
                }
            }
        }
    }

    /**
     * 调度到 产品表   type= 3
     *
     * @param jsonArray
     */
    public void saveAutoEverySql4(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            String startTime = "";
            String endTime = "";
            //获取调度频率值
            //获取调度频率的单位（时、分、天、月....）
            //获取抽取范围 时间单位固定是天  （抽取范围一定大于调度频率、而维度表【不需要时间范围的web接口】 不计算在内）
//            Integer scope =  Integer.parseInt(((JSONObject) obj).get("scope").toString());
            Integer scope = 0;
            if (null != String.valueOf(((JSONObject) obj).get("scope")) && !"".equals(String.valueOf(((JSONObject) obj).get("scope"))) && !"null".equals(String.valueOf(((JSONObject) obj).get("scope")))) {
                scope = Integer.parseInt(String.valueOf(((JSONObject) obj).get("scope")));
            }
            startTime = WebSoapUtil.getAutoStartTiem(10, scope);
            endTime = WebSoapUtil.getAutoEndDateTime(10);
            String s_id = ((JSONObject) obj).get("id").toString();
            DcProcedure dcProcedure = new DcProcedure();
            dcProcedure.setSchedule_id(s_id);
            dcProcedure.setType_id(3);
            List<DcProcedure> byScheduleId = dcProcedureDao.select(dcProcedure);
            if (byScheduleId.size() > 0) {
                for (DcProcedure procedure : byScheduleId) {
                    String procedureName = procedure.getName();
                    if (1 == procedure.getIsparam()) {//时间参数的存储过程
                        handleDao.excuteCallProcedueWithParams(procedureName, startTime, endTime);
                    } else if (3 == procedure.getIsparam()) {//无参的存储过程
                        handleDao.excuteCallProcedue(procedureName);
                    }
                }
            }
        }
    }


    public List<KeyValueDBO> usedColumn(String colname) {
        return dcProcedureDao.usedColumn("%" + colname + "%");

    }

    public void deleteByProce(DcProcedure dcProcedure) {
        DcTableVsTable dcTableVsTable = new DcTableVsTable();
        DcVirtualTable dcVirtualTable = new DcVirtualTable();
        DcScheduleConfig dcScheduleConfig = new DcScheduleConfig();

        //删除tableVStable
        dcTableVsTable.setProcedure_id(dcProcedure.getId());
        dcTableVsTableDao.delete(dcTableVsTable);
        //删除 virtualtable
        dcVirtualTable.setProcedure_id(dcProcedure.getId());
        // List<DcVirtualTable> tableList = dcVirtualTableDao.select(dcVirtualTable);
        dcVirtualTableDao.delete(dcVirtualTable);
        //9.调度
        dcScheduleConfig.setProcedure_id(dcProcedure.getId());
        dcScheduleConfigService.delete(dcScheduleConfig);
        //删除存储过程
        String sql = "if exists(select * from sys.procedures where name='" + dcProcedure.getName() + "')\n" +
                "drop procedure dbo.[" + dcProcedure.getName() + "] ";
        handleDao.excuteSqlWithSQL(sql);
        dcProcedureDao.delete(dcProcedure);
    }
}
