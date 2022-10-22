package com.sxdl.product.dc.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sxdl.base.entity.SysLog;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.*;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.dbo.SqlserverDBType;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.DcEtlLogService;
import com.sxdl.product.dc.service.DcRequestAPIService;
import com.sxdl.product.dc.service.DcScheduleService;
import com.sxdl.product.dc.service.HandleSerice;
import com.sxdl.product.dc.util.WebPostUtil;
import com.sxdl.product.dc.util.WebSoapUtil;
import com.sxdl.product.dc.util.WeiNingDataParseUtil;
import org.dom4j.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("dcRequestAPIService")
@Transactional
public class DcRequestAPIServiceImpl extends BaseUUIDServiceImpl<DcRequestAPI> implements DcRequestAPIService {
    static String COLUMNSCRATCH = "] varchar(500) COLLATE Chinese_PRC_CI_AS  NULL,[";
    @Autowired
    HandleSerice handleSerice;
    @Autowired
    private DcEtlLogService dcEtlLogService;

    @Autowired
    DcJobDao dcJobDao;
    @Autowired
    WeiNingDataParseUtil weiNingDataParseUtil;
    String newTag;
    String[] wnPinfos = new String[]{"PatientInfo", "PatientInfo1", "PatientInfo2", "PatientInfo3", "PatientInfo4"};
    @Autowired
    private DcScheduleConfigDao dcScheduleConfigDao;
    @Autowired
    private DcScheduleDao dcScheduleDao;
    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private DcColumnDao dcColumnDao;
    @Autowired
    private DcRequestAPIDao dcRequestAPIDao;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcScheduleService dcScheduleService;

    /**
     * 同步卫宁数据dl_dc_base数据库中的表结构数据和dl_dc数据库中的事实表<br>
     * 1 在l_dc_base数据库中会建立或者新增 tname 表的表结构数据和字段结构数据;<br>
     * 2 在dl_dc数据库中会建立或者修改两个表,事实表tname,源数据表tname_temp<br>
     * 3 源数据表tname_temp和事实表tname字段一样,在事实表tname基础上增加了 optime 字段,存放每次抽取任务的时间,
     *
     * @param dcRequestAPI 接口类信息
     * @param tableColumns 表的字段列表
     * @param tname        表名称
     */
    public void synchronizationTalbe(DcRequestAPI dcRequestAPI, Set<String> tableColumns, String tname) {
        /*
        1 先处理dc_base中的表结构,判断是否有表结构数据,是否有表的字段结构数据
         */
        DcTable dcTable = new DcTable();
        dcTable.setName(tname);
        dcTable.setType_id(1);
        dcTable.setProduct_id("C9BA5D39-4CD0-4D6B-B03A-12766FC87D57");
        dcTable.setName_zh(dcRequestAPI.getName());
        List<DcTable> tables = dcTableDao.select(dcTable);

        if (tables.size() > 0) {  //表存在 ，判断是否有多出来的字段 有 添加字段
            DcColumn column = new DcColumn();
            String talbeId = tables.get(0).getId();
            column.setTable_id(talbeId);
            //将获取的 entity集合换成 字符串集合
            List<DcColumn> dcColumns = dcColumnDao.select(column);
            //将dc表中的字段放到dccolumnNames里面 对比 set集合 多出来的数据字段放到addColumn容器里面
            List<String> dccolumnNames = new ArrayList<>();
            //创建一个装载 新增字段的容器
            List<String> addCloumn = new ArrayList<>();
            for (DcColumn dcColumn : dcColumns) {
                dccolumnNames.add(dcColumn.getColumn_name());
            }
            for (String webColumn : tableColumns) {
                if (!dccolumnNames.contains(webColumn)) {
                    addCloumn.add(webColumn);
                }
            }
            // 存在新 增 字段 开始 添加
            if (addCloumn.size() > 0) {
                for (String webColumn : addCloumn) {
                    saveColumn(dcTable, webColumn);
                }
//                sqlText = WebSoapUtil.getSqlTextIsExists(dcRequestAPI.getTag(), addCloumn);
            }
        } else {  //没有表，则创建
            dcTableDao.insert(dcTable);
            if (tableColumns.size() > 0) {
                for (String colName : tableColumns) {
                    saveColumn(dcTable, colName);
                }
//                sqlText =  WebSoapUtil.getSqlTextNotExists(dcRequestAPI.getTag(),tableColumns);
            }
        }
        /*
        2 后处理dc中的事实表,判断是否有表,是否表的字段相符合
        会建立原始数据表(tname_temp)和具体的事实表(tname)
         */
        if ("1".equals(handleSerice.ifExistTable(tname))) {//有表
            List<String> tnameColumns = handleSerice.getColumns(tname);
            if (tnameColumns.size() > 0) {//有字段
                List<String> newadd = tableColumns.stream().filter(e -> !tnameColumns.contains(e)).collect(Collectors.toList());//新增的字段
                if (newadd.size() > 0) {//有新增
                    for (String s : newadd) {
                        handleSerice.addColumn(tname, s, SqlserverDBType.VARCHAR, null, null);
                        handleSerice.addColumn(tname + "_temp", s, SqlserverDBType.VARCHAR, null, null);
                    }
                }
            }
//                List<String> olddel = columns.stream().filter(e -> !tnameColumns.contains(e)).collect(Collectors.toList());//多出来的字段
        } else {
            //没事实表
            StringBuilder sbtemp = new StringBuilder(), sb = new StringBuilder("create table [" + tname + "] ([");
            String ifExistTable = handleSerice.ifExistTable(tname + "_temp");
            //没有原始数据表
            if ("0".equals(ifExistTable)) {
                sbtemp = new StringBuilder("create table [" + tname + "_temp] ([");
            }
            for (String s : tableColumns) {
                sb.append(s).append(COLUMNSCRATCH);
                //没有原始数据表
                if ("0".equals(ifExistTable)) {
                    sbtemp.append(s).append(COLUMNSCRATCH);
                }
            }
            String sql = sb.substring(0, sb.length() - 2) + ")", sqltemp = "";
            if ("0".equals(ifExistTable)) {//没有原始数据表
                sqltemp = sbtemp.append("optime" + COLUMNSCRATCH).substring(0, sbtemp.length() - 2) + ")";
            }
            System.out.println(sql + "\n" + sqltemp);
            handleSerice.selectSqlWithSQL(sql + "\n" + sqltemp);
        }
    }


    public void synchronizationTalbejcjy(String tableName, Set<String> tableColumns, String tname) {
        /*
        1 先处理dc_base中的表结构,判断是否有表结构数据,是否有表的字段结构数据
         */
        DcTable dcTable = new DcTable();
        dcTable.setName(tname);
        dcTable.setType_id(1);
        dcTable.setProduct_id("C9BA5D39-4CD0-4D6B-B03A-12766FC87D57");
        dcTable.setName_zh(tableName);
        List<DcTable> tables = dcTableDao.select(dcTable);

        if (tables.size() > 0) {  //表存在 ，判断是否有多出来的字段 有 添加字段
            DcColumn column = new DcColumn();
            String talbeId = tables.get(0).getId();
            column.setTable_id(talbeId);
            //将获取的 entity集合换成 字符串集合
            List<DcColumn> dcColumns = dcColumnDao.select(column);
            //将dc表中的字段放到dccolumnNames里面 对比 set集合 多出来的数据字段放到addColumn容器里面
            List<String> dccolumnNames = new ArrayList<>();
            //创建一个装载 新增字段的容器
            List<String> addCloumn = new ArrayList<>();
            for (DcColumn dcColumn : dcColumns) {
                dccolumnNames.add(dcColumn.getColumn_name());
            }
            for (String webColumn : tableColumns) {
                if (!dccolumnNames.contains(webColumn)) {
                    addCloumn.add(webColumn);
                }
            }
            // 存在新 增 字段 开始 添加
            if (addCloumn.size() > 0) {
                for (String webColumn : addCloumn) {
                    saveColumn(dcTable, webColumn);
                }
//                sqlText = WebSoapUtil.getSqlTextIsExists(dcRequestAPI.getTag(), addCloumn);
            }
        } else {  //没有表，则创建
            dcTableDao.insert(dcTable);
            if (tableColumns.size() > 0) {
                for (String colName : tableColumns) {
                    saveColumn(dcTable, colName);
                }
//                sqlText =  WebSoapUtil.getSqlTextNotExists(dcRequestAPI.getTag(),tableColumns);
            }
        }
        /*
        2 后处理dc中的事实表,判断是否有表,是否表的字段相符合
        会建立原始数据表(tname_temp)和具体的事实表(tname)
         */
        if ("1".equals(handleSerice.ifExistTable(tname))) {//有表
            List<String> tnameColumns = handleSerice.getColumns(tname);
            if (tnameColumns.size() > 0) {//有字段
                List<String> newadd = tableColumns.stream().filter(e -> !tnameColumns.contains(e)).collect(Collectors.toList());//新增的字段
                if (newadd.size() > 0) {//有新增
                    for (String s : newadd) {
                        handleSerice.addColumn(tname, s, SqlserverDBType.VARCHAR, null, null);
                        handleSerice.addColumn(tname + "_temp", s, SqlserverDBType.VARCHAR, null, null);
                    }
                }
            }
//                List<String> olddel = columns.stream().filter(e -> !tnameColumns.contains(e)).collect(Collectors.toList());//多出来的字段
        } else {
            //没事实表
            StringBuilder sbtemp = new StringBuilder(), sb = new StringBuilder("create table [" + tname + "] ([");
            String ifExistTable = handleSerice.ifExistTable(tname + "_temp");
            //没有原始数据表
            if ("0".equals(ifExistTable)) {
                sbtemp = new StringBuilder("create table [" + tname + "_temp] ([");
            }
            for (String s : tableColumns) {
                sb.append(s).append(COLUMNSCRATCH);
                //没有原始数据表
                if ("0".equals(ifExistTable)) {
                    sbtemp.append(s).append(COLUMNSCRATCH);
                }
            }
            String sql = sb.substring(0, sb.length() - 2) + ")", sqltemp = "";
            if ("0".equals(ifExistTable)) {//没有原始数据表
                sqltemp = sbtemp.append("optime" + COLUMNSCRATCH).substring(0, sbtemp.length() - 2) + ")";
            }
            System.out.println(sql + "\n" + sqltemp);
            handleSerice.selectSqlWithSQL(sql + "\n" + sqltemp);
        }
    }

    /**
     * 保存单个字段
     *
     * @param dcTable 表信息,需要id和name
     * @param colName 字段名称和字段中文名
     */
    public void saveColumn(DcTable dcTable, String colName) {
        DcColumn addC = new DcColumn();
        addC.setTable_id(dcTable.getId());
        addC.setTable_name(dcTable.getName());
        addC.setColumn_name(colName);
        addC.setColumn_name_zh(colName);
        addC.setType_id(1);
        addC.setType("字符串");
        addC.setSize(5000);
        dcColumnDao.insert(addC);
    }

    public ResultUtil saveApi(DcRequestAPI dcRequestAPI) throws Exception {
        //第一步：生成 调度规则dc_schedule
        Integer rule_id = dcRequestAPI.getRule_id();
        Integer scope = dcRequestAPI.getScope();
        String schedule_id;
        /*if(null==dcRequestAPI.getSchedule_id()){  //规则不存在开始创建规则 Schedule 表
            schedule_id = dcScheduleService.createSchedule(rule_id,scope,dcRequestAPI.getHospital_id(),dcRequestAPI.getProduct_id(),
                    dcRequestAPI.getName(),dcRequestAPI.getTag(),"webApi");
        }else {//规则存在开始  修改规则 Schedule 表
            schedule_id = dcScheduleService.updateSchedule(rule_id,dcRequestAPI.getSchedule_id(),scope,dcRequestAPI.getHospital_id(),
                    dcRequestAPI.getProduct_id(),dcRequestAPI.getName(),dcRequestAPI.getTag(),"webApi");
        }
        dcRequestAPI.setSchedule_id(schedule_id);*/
        //第二步：开始生成建表sql

        // 1 xml格式  2json 格式
        String agreetype = dcRequestAPI.getAgreetype();
        HttpResponse response = WebSoapUtil.getResponse(dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), dcRequestAPI.getReqbody(), dcRequestAPI.getSoapaction());
        //  数据是否规范 -1否
        Integer is_standard = dcRequestAPI.getIs_standard();
        //用来存放colums字段
        Set<String> tableColumns = null;
        //1是xml 2是json
        if ("1".equals(agreetype)) {
            Document xmlDocument = null;
            if (1 == is_standard) {//标准的
                xmlDocument = WebSoapUtil.getXmlDocument(response);
            } else if (9 == is_standard) {//卫宁首页数据
                Integer isMultiwall = dcRequestAPI.getIs_multiwall();
                newTag = "";
                String resultTAG;
                if (2 == isMultiwall) {
//                    List<Map<String, Set<String>>> list = weiNingDataParseUtil.parseWNShouyeColumns(body);
                    for (String s : wnPinfos) {
                        dcRequestAPI.setTag(s);
                        resultTAG = duelWNTbaleConstructor(dcRequestAPI, response.body(), s);
                        if (StrUtil.isNotEmpty(resultTAG)) {
                            newTag += resultTAG + ",";
                        }
                    }
                } else if (3 == isMultiwall || 4 == isMultiwall || 5 == isMultiwall) {
                    dcRequestAPI.setTag(dcRequestAPI.getAnalysis_node());
                    resultTAG = duelWNTbaleConstructor(dcRequestAPI, response.body(), dcRequestAPI.getAnalysis_node());
                    if (StrUtil.isNotEmpty(resultTAG)) {
                        newTag = resultTAG;
                    }
                }
                if (StrUtil.isEmpty(newTag)) {
                    return ResultUtil.error("节点解析异常,获取不到表名");
                }
                dcRequestAPI.setTag(newTag);
                saveOrupdateAPIAndSecedule(dcRequestAPI, rule_id, scope);
                return ResultUtil.success("操作成功");
            } else {//不标准的
                xmlDocument = WebSoapUtil.getXmlDocument(response, dcRequestAPI.getAnalysis_node());
            }
            tableColumns = WebSoapUtil.getXmlColumns(xmlDocument, dcRequestAPI.getAnalysis_node(), dcRequestAPI.getName_space(), dcRequestAPI.getName_space_url());
        } else if ("2".equals(agreetype)) {
            if (-1 == is_standard) {
                tableColumns = WebPostUtil.getJsonColumnsNOStandard(response);
            } else if (10 == is_standard) { //晋城检验信息

                Map<String, Set<String>> jsonColumns10 = WebPostUtil.getJsonColumns10(response, dcRequestAPI.getAnalysis_node(), dcRequestAPI.getName());

                for (String s : jsonColumns10.keySet()) {
                    Set<String> strings = jsonColumns10.get(s);
                    if(strings.isEmpty()) continue;
                    synchronizationTalbejcjy(s, jsonColumns10.get(s), s);
                }

                saveOrupdateAPIAndSecedule(dcRequestAPI, rule_id, scope);
                return ResultUtil.success("操作成功");
            } else {
                tableColumns = WebPostUtil.getJsonColumns(response, dcRequestAPI.getAnalysis_node());
            }
        }
        if (tableColumns.size() == 0) {
            return ResultUtil.error("字段获取失败，请检查接口");
        }
        //第三步生成建表sql后，同步 dctable、dcColumn 表
        synchronizationTalbe(dcRequestAPI, tableColumns, dcRequestAPI.getTag());
        saveOrupdateAPIAndSecedule(dcRequestAPI, rule_id, scope);
        return ResultUtil.success("操作成功");
    }

    /**
     * 统一处理卫宁的表结构数据
     *
     * @param dcRequestAPI 请求类信息
     * @param body         返回数据
     * @param s            截取的节点
     * @return
     * @throws Exception
     */
    public String duelWNTbaleConstructor(DcRequestAPI dcRequestAPI, String body, String s) throws Exception {
        //处理成标准的节点数据
        byte[] bytes = weiNingDataParseUtil.getBytesFromFullXMLString(body, s);
        if (bytes.length <= 0) {
            return null;
        }
        Map<String, Set<String>> columnsFromXMLString = weiNingDataParseUtil.getColumnsFromXMLString(bytes);
        String newTag = null;
        for (String ss : columnsFromXMLString.keySet()) {//其实只有一条信息
            synchronizationTalbe(dcRequestAPI, columnsFromXMLString.get(ss), ss);
            newTag = ss;
        }
        return newTag;
    }

    /**
     * 保存或者修改webapi数据以及相关的调度信息
     *
     * @param dcRequestAPI webapi信息
     * @param rule_id      调度id
     * @param scope        抽取范围
     */
    public void saveOrupdateAPIAndSecedule(DcRequestAPI dcRequestAPI, Integer rule_id, Integer scope) {
        String scheduleid;
        if (StrUtil.isEmpty(dcRequestAPI.getId())) {
            dcRequestAPI.setId(null);
//            scheduleid = dcScheduleService.createSchedule(null, rule_id, scope, dcRequestAPI.getHospital_id(),
//                    dcRequestAPI.getProduct_id(),
//                    dcRequestAPI.getName(), dcRequestAPI.getTag(), "webApi", "");
//            dcRequestAPI.setSchedule_id(scheduleid);
            insert(dcRequestAPI);
        } else {
            update(dcRequestAPI);
//            dcScheduleService.updateSchedule(dcRequestAPI.getSchedule_id(), rule_id, null, scope, dcRequestAPI.getHospital_id(),
//                    dcRequestAPI.getProduct_id(), dcRequestAPI.getName(), dcRequestAPI.getTag(), "webApi", "");
        }
    }

    /***
     * 手动抽取数据
     */
    public ResultUtil saveOneTable(DcRequestAPI dcRequestAPI) throws Exception {
//        String schedule_id = dcRequestAPI.getSchedule_id();
//        DcSchedule dcSchedule = dcScheduleDao.selectByPrimaryKey(schedule_id);
        String job_id = dcRequestAPI.getJob_id();
        DcJob dcJob = dcJobDao.selectByPrimaryKey(job_id);
        DcSchedule dcSchedule = new DcSchedule();
        dcSchedule.setParam_unit(dcJob.getParam_unit());
        dcSchedule.setParam(dcJob.getParam());

        if (1 == dcRequestAPI.getIsparam()) { //时间范围 类型的web接口

            if (9 == (dcRequestAPI.getIs_standard())) {//单独处理卫宁数据
                return autoWNDATAByParams(dcRequestAPI, dcSchedule);
            }
            //存放切割后的时间对
            List<String> splicTimeParam = weiNingDataParseUtil.getSplicTimeParamJc(dcRequestAPI.getStartTime(),
                    dcRequestAPI.getEndTime(), dcSchedule.getParam_unit(), false,dcSchedule.getParam());
            if (10 == (dcRequestAPI.getIs_standard())) {//单独处理晋城市检验信息


                System.out.println("-**- 开始");
                System.out.println("-**- 时间段"+splicTimeParam);
                return autoJCDATA(dcRequestAPI, splicTimeParam);

            }


            AutoData1(dcRequestAPI, splicTimeParam);
        } else if (3 == dcRequestAPI.getIsparam()) { //无参数类型的web接口\
            return AutoData2(dcRequestAPI);
        }
        return ResultUtil.success("抽取成功");
    }

    /**
     * 作业抽取数据---利用动态sql
     *
     * @param schedules 是根据规则分好组的 DcSchedule类的数据
     */
    public void saveAutoEverySql(List<DcSchedule> schedules) throws Exception {
        for (DcSchedule e : schedules) {
            //获取调度频率值
            Integer rate = e.getParam();
            //获取调度频率的单位（时、分、天、月....）
            String param_unit = e.getParam_unit();
            //获取抽取范围 时间单位固定是天  （抽取范围一定大于调度频率、而维度表【不需要时间范围的web接口】 不计算在内）
            Integer scope = 0;
            if (StrUtil.isNotEmpty(e.getScope().toString())) {
                scope = e.getScope();
            }
            DcRequestAPI api = new DcRequestAPI();
            api.setSchedule_id(e.getId());
            api.setProduct_id(e.getProduct_id());
            api.setTag(e.getTag());
            List<DcRequestAPI> apis = dcRequestAPIDao.select(api);//获取到webapi信息,应该是一条
            for (DcRequestAPI dcRequestAPI : apis) {
                if (1 == dcRequestAPI.getIsparam()) { //时间范围 类型的web接口
                    //开始时间
                    String start_node_value = WebSoapUtil.getAutoStartTiem(dcRequestAPI.getStart_node_value().length(), scope);
                    //结束时间
                    String end_node_value = WebSoapUtil.getAutoEndDateTime(dcRequestAPI.getEnd_node_value().length());
                    if (9 == (dcRequestAPI.getIs_standard())) {//单独处理卫宁数据
                        dcRequestAPI.setStartTime(start_node_value);
                        dcRequestAPI.setEndTime(end_node_value);
                        autoWNDATAByParams(dcRequestAPI, e);
                        continue;
                    }
                    List<String> timeList = WebSoapUtil.getSplicTimeParam(start_node_value, end_node_value, param_unit, rate);
                    AutoData1(dcRequestAPI, timeList);
                } else if (3 == dcRequestAPI.getIsparam()) { //无参数类型的web接口
                    AutoData2(dcRequestAPI);
                }
            }
        }
    }


    /**
     * 作业抽取数据---利用动态sql
     *
     * @param schedules 是根据规则分好组的 DcSchedule类的数据
     */
    public void saveAutoEverySql1(List<DcScheduleConfig> schedules) throws Exception {
        System.out.println("作业开始执行");
        int batch=0;
        String batchsql="select MAX(batch) batch from dc_etl_log \n" +
                "where convert(varchar,convert(datetime,start_time, 20),23) =convert(varchar,GETDATE(),23)";
        List<Map<String, Object>> maps = dcEtlLogService.selectSqlWithSQL(batchsql);
        if(null!=maps.get(0)){
            batch=Integer.parseInt(maps.get(0).get("batch").toString())+1;
        }else{
            batch=1;
        }
        for (DcScheduleConfig e : schedules) {
            long begin = System.currentTimeMillis(), end;
            String beginTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            DcEtlLog etlLog = new DcEtlLog();
            etlLog.setStartTime(beginTime);
            etlLog.setScheduleId(e.getId());
            etlLog.setScheduleRuleId(Integer.parseInt(e.getRule_id()));
            etlLog.setScheduleRuleSffix(e.getRule_suffix());
            etlLog.setExecId(e.getProcedure_id());
            etlLog.setEtlnum(0);
            etlLog.setInsnum(0);
            etlLog.setUpdanum(0);
            etlLog.setDelnum(0);
            etlLog.setStatus(2);
            etlLog.setBatch(batch);
            dcEtlLogService.insert(etlLog);

            try {
                //获取调度频率值
                Integer rate = e.getParam();
                //获取调度频率的单位（时、分、天、月....）
                String param_unit = e.getParam_unit();
                //获取抽取范围 时间单位固定是天  （抽取范围一定大于调度频率、而维度表【不需要时间范围的web接口】 不计算在内）
                Integer scope = 0;
                if (!StringUtil.isEmptyNumber(e.getScope())) {
                    scope = e.getScope();
                }
                DcRequestAPI api = new DcRequestAPI();
                //api.setSchedule_id(e.getProcedure_id());
                //api.setProduct_id(e.getProduct_id());
                api.setId(e.getProcedure_id());
                //api.setTag(e.getTag());
                List<DcRequestAPI> apis = dcRequestAPIDao.select(api);//获取到webapi信息,应该是一条
                for (DcRequestAPI dcRequestAPI : apis) {
                    if (1 == dcRequestAPI.getIsparam()) { //时间范围 类型的web接口
                        //开始时间
                        String start_node_value = WebSoapUtil.getAutoStartTiem(dcRequestAPI.getStart_node_value().length(), scope);
                        //结束时间
                        String end_node_value = WebSoapUtil.getAutoEndDateTime(dcRequestAPI.getEnd_node_value().length());
                        if (9 == (dcRequestAPI.getIs_standard())) {//单独处理卫宁数据
                            dcRequestAPI.setStartTime(start_node_value);
                            dcRequestAPI.setEndTime(end_node_value);
                            ResultUtil ru =autoWNDATAByParams1(dcRequestAPI, e);

                            end = System.currentTimeMillis();
                            String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                            etlLog.setEndTime(endTime);
                            end -= begin;
                            etlLog.setDuration(end + "");
                            etlLog.setContent("WEBSERVICE: " + e.getName() + ru.getMsg());
                            dcEtlLogService.update(etlLog);
                            continue;
                        }
                        List<String> splicTimeParam = weiNingDataParseUtil.getSplicTimeParamJc(start_node_value,
                                end_node_value, param_unit, false, rate);

                        //List<String> timeList = WebSoapUtil.getSplicTimeParam(start_node_value, end_node_value, param_unit, rate);
                        if (10 == (dcRequestAPI.getIs_standard())) {//单独处理晋城市检验信息
                            ResultUtil ru =autoJCDATA(dcRequestAPI, splicTimeParam);

                            end = System.currentTimeMillis();
                            String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                            etlLog.setEndTime(endTime);
                            end -= begin;
                            etlLog.setDuration(end + "");
                            etlLog.setContent("WEBSERVICE: " + e.getName() + ru.getMsg());
                            dcEtlLogService.update(etlLog);

                            continue;
                        }
                        AutoData1(dcRequestAPI, splicTimeParam);
                    } else if (3 == dcRequestAPI.getIsparam()) { //无参数类型的web接口
                        AutoData2(dcRequestAPI);
                    }

                    end = System.currentTimeMillis();
                    String endTime = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss");
                    etlLog.setEndTime(endTime);
                    end -= begin;
                    etlLog.setDuration(end + "");
                    etlLog.setContent("WEBSERVICE: " + e.getName() +" 抽取成功");
                    dcEtlLogService.update(etlLog);

                }
            }catch (Exception e1){
                etlLog.setStatus(3);
                etlLog.setContent("WEBSERVICE: " +  e.getName()  + "运行出错！返回消息:" + e1.getMessage());
                dcEtlLogService.update(etlLog);
            }
        }

        System.out.println("作业结束执行");
    }

    /**
     * 抽取数据类型 为 时间参数 or 单个参数的数据
     *
     * @param dcRequestAPI
     * @param timeList
     * @throws Exception
     */
    public void AutoData1(DcRequestAPI dcRequestAPI, List<String> timeList) throws Exception {
        List<LinkedHashMap<String, String>> listTypeTime = new ArrayList<>();
        List<LinkedHashMap<String, String>> listTypeBlh = new ArrayList<>();
        String sqlText = "";
        //获取最后的结束时间
        String endCondTime = WebSoapUtil.getKeyValues(timeList.get(timeList.size() - 1)).get("endDate");
        first:
        for (String param : timeList) {
            LinkedHashMap<String, String> keyValues = WebSoapUtil.getKeyValues(param);
            String startDate = keyValues.get("startDate");
            String endDate = keyValues.get("endDate");
            //是或结束条件
            int isEndCondition = 0;
            if (endDate.equals(endCondTime)) {
                isEndCondition = 1;
            }
            // 先删除数据
            String delsql = WebSoapUtil.delTableData(dcRequestAPI.getTag(), dcRequestAPI.getTag_time(), startDate, endDate, dcRequestAPI.getTag_null(), isEndCondition);
            handleDao.excuteSqlWithSQL(delsql);

            //请求协议为json 格式
            if ("2".equals(dcRequestAPI.getAgreetype())) {
                HttpResponse response = WebPostUtil.getAutoResponseOfTime(dcRequestAPI.getReqbody(), dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), dcRequestAPI.getStart_node_name(),
                        keyValues.get("startDate"), dcRequestAPI.getEnd_node_name(), keyValues.get("endDate"));
                System.out.println("****************response**********************");
                System.out.println(response);
                Set<String> setJsonColumns = null;
                if ("-1".equals(dcRequestAPI.getIs_standard().toString())) {
                    setJsonColumns = WebPostUtil.getJsonColumnsNOStandard(response);
                    if (setJsonColumns == null || setJsonColumns.size() == 0) {
                        continue first;
                    }
                    listTypeTime = WebPostUtil.getPostDataNoStandard(response, setJsonColumns);
                } else {

                    setJsonColumns = WebPostUtil.getJsonColumns(response, dcRequestAPI.getAnalysis_node());
                    System.out.println(setJsonColumns);
                    if (setJsonColumns == null || setJsonColumns.size() == 0) {
                        continue first;
                    }
                    listTypeTime = WebPostUtil.getPostData(response, setJsonColumns, dcRequestAPI.getAnalysis_node());
                    System.out.println(listTypeTime);
                }
                //同步数据库 和 dc_table表
                synchronizationTalbe(dcRequestAPI, setJsonColumns, dcRequestAPI.getTag());
            }
            //请求协议为xml 格式
            else if ("1".equals(dcRequestAPI.getAgreetype())) {
                Document xmlDocument = WebSoapUtil.getTableTimeDocument(dcRequestAPI.getIs_standard(), dcRequestAPI.getReqbody(),
                        dcRequestAPI.getAnalysis_node(), dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), dcRequestAPI.getStart_node_name(),
                        keyValues.get("startDate"), dcRequestAPI.getEnd_node_name(), keyValues.get("endDate"), dcRequestAPI.getSoapaction());

                if (null == xmlDocument) {
                    continue first;
                }
                Set<String> xmlColumns = WebSoapUtil.getXmlColumns(xmlDocument, dcRequestAPI.getAnalysis_node(), dcRequestAPI.getName_space(), dcRequestAPI.getName_space_url());
                System.out.println(xmlColumns);
                if (xmlColumns == null || xmlColumns.size() == 0) {
                    continue first;
                } else {
                    synchronizationTalbe(dcRequestAPI, xmlColumns, dcRequestAPI.getTag());
                }
                listTypeTime = WebSoapUtil.getAnalysisNode(xmlDocument, dcRequestAPI.getAnalysis_node(), dcRequestAPI.getName_space(), dcRequestAPI.getName_space_url());
            }

            if (listTypeTime.size() == 0) {
                continue first;
            }

            DcRequestAPI dd = new DcRequestAPI();
            dd.setWeb_id(dcRequestAPI.getId());
            //select 为 子接口 数据
            List<DcRequestAPI> select = select(dd);
            if (select.size() > 0) {  // 有外联 单个参数的接口处理
                second:
                for (DcRequestAPI dcRequest : select) {
                    if ("2".equals(dcRequest.getAgreetype())) {//1是xml 2是json
                        thrid:
                        for (LinkedHashMap<String, String> map : listTypeTime) {
                            String blhstr = map.get(dcRequest.getWeb_node());
                            HttpResponse response = WebPostUtil.getAutoResponseOfBlh(dcRequest.getReqbody(), dcRequest.getUrl(), dcRequest.getContenttype(),
                                    dcRequest.getSingle_node_value(), blhstr);
                            Set<String> setJsonColumns;
                            if ("-1".equals(dcRequest.getIs_standard().toString())) {
                                setJsonColumns = WebPostUtil.getJsonColumnsNOStandard(response);
                                if (setJsonColumns.size() == 0) {
                                    continue thrid;
                                }
                                listTypeBlh = WebPostUtil.getPostDataNoStandard(response, setJsonColumns);
                            } else {
                                setJsonColumns = WebPostUtil.getJsonColumns(response, dcRequest.getAnalysis_node());
                                if (setJsonColumns.size() == 0) {
                                    continue thrid;
                                }
                                listTypeBlh = WebPostUtil.getPostData(response, setJsonColumns, dcRequest.getAnalysis_node());
                            }
                            synchronizationTalbe(dcRequestAPI, setJsonColumns, dcRequestAPI.getTag());
                            blhsave(listTypeBlh, dcRequest);
                        }
                    } else if ("1".equals(dcRequest.getAgreetype())) {
                        four:
                        for (LinkedHashMap<String, String> map : listTypeTime) {
                            Document xmlDocument = WebSoapUtil.getTableBlhDocument(dcRequest.getIs_standard(), dcRequest.getReqbody(),
                                    dcRequest.getAnalysis_node(), dcRequest.getUrl(),
                                    dcRequest.getContenttype(), dcRequest.getSingle_node_name(),
                                    map.get(dcRequest.getWeb_node()), dcRequest.getSoapaction());
                            Set<String> xmlColumns = null;
                            if (xmlDocument != null) {
                                xmlColumns = WebSoapUtil.getXmlColumns(xmlDocument, dcRequest.getAnalysis_node(), dcRequest.getName_space(), dcRequest.getName_space_url());
                            } else {
                                xmlColumns = new HashSet<>();
                            }
                            if (xmlColumns.size() == 0) {
                                continue four;
                            } else {
                                synchronizationTalbe(dcRequestAPI, xmlColumns, dcRequestAPI.getTag());
                            }
                            listTypeBlh = WebSoapUtil.getAnalysisNode(xmlDocument, dcRequest.getAnalysis_node(), dcRequest.getName_space(), dcRequest.getName_space_url());
                            blhsave(listTypeBlh, dcRequest);
                        }
                    }
                }//
            }
            for (LinkedHashMap<String, String> stringStringLinkedHashMap : listTypeTime) {
                sqlText = WebSoapUtil.getInsertTableSqlDel(dcRequestAPI.getTag(), stringStringLinkedHashMap);
                System.out.println(sqlText);
                handleDao.excuteSqlWithSQL(sqlText);
            }
        }
    }

    public void blhsave(List<LinkedHashMap<String, String>> listTypeBlh, DcRequestAPI dcRequest) {
        String sqlText = "";
        String tag_blh = dcRequest.getTag_blh().trim();
        if (listTypeBlh.size() > 0) {
            LinkedHashMap<String, String> hashMap = listTypeBlh.get(0);
            String blh = hashMap.get(tag_blh);
            String s = WebSoapUtil.delTableData(dcRequest.getTag(), dcRequest.getTag_blh(), blh);
            handleDao.excuteSqlWithSQL(s);
            for (LinkedHashMap<String, String> stringStringLinkedHashMap : listTypeBlh) {
                sqlText = WebSoapUtil.getInsertTableSqlDel(dcRequest.getTag(), stringStringLinkedHashMap);
                handleDao.excuteSqlWithSQL(sqlText);
            }
        }
    }

    /**
     * 使用参数处理卫宁数据
     *
     * @param dcRequestAPI webapi信息
     * @param dcSchedule   调度信息
     * @return 统一的返回信息
     * @throws Exception
     */
    public ResultUtil autoWNDATAByParams(DcRequestAPI dcRequestAPI, DcSchedule dcSchedule) throws Exception {
        if ("application/x-www-form-urlencoded;charset=UTF-8".equals(dcRequestAPI.getContenttype())) {
            List<Map<String, String>> splicTimeParam = weiNingDataParseUtil.getSplicTimeParam(dcRequestAPI.getStartTime(),
                    dcRequestAPI.getEndTime(), dcSchedule.getParam_unit(), true);
            String resultmsg, sucNum, oldSucNum;
            Integer cnt = 0;
            boolean flag = dcRequestAPI.getTag().contains(",");
            JSONObject j = null, resultmap = new JSONObject(), child;
            for (Map<String, String> e : splicTimeParam) {
                dcRequestAPI.setReqbody("dtbeg=" + e.get("start") + "&dtend=" + e.get("end"));
                resultmsg = autoWNDATA(dcRequestAPI).getMsg();
                if (flag) {//处理一个接口多个表的数据
                    j = JSONUtil.parseObj(resultmsg);
                    for (String s : j.keySet()) {
                        if (resultmap.containsKey(s)) {
                            child = resultmap.getJSONObject(s);
                            child.putOpt("err", child.getStr("err") + j.getJSONObject(s).getStr("err"));
                            sucNum = child.getStr("suc");
                            //如果当天数据不是空的
                            if (j.getJSONObject(s).containsKey("suc")) {
                                oldSucNum = j.getJSONObject(s).getStr("suc");
                                if (NumberUtil.isNumber(oldSucNum) && NumberUtil.isNumber(sucNum)) {
                                    child.putOpt("suc", Integer.parseInt(sucNum) + Integer.parseInt(oldSucNum));
                                }
                            }
                            resultmap.putOpt(s, child);
                        } else {
                            resultmap.putOpt(s, j.getJSONObject(s));
                        }
                    }
                } else if (resultmsg.contains("suc")) {//一个接口一个表
                    cnt += Integer.parseInt(resultmsg.split(";")[1].split(":")[1]);
                }
            }
            String result = "";
            if (resultmap.size() > 0) {
                for (String s : resultmap.keySet()) {
                    child = resultmap.getJSONObject(s);
                    result += s + " : " + "状态:suc;影响行数:" + child.getStr("suc") + ";信息:执行成功!\n";
                    if (StrUtil.isNotEmpty(child.getStr("err"))) {
                        result += child.getStr("err") + "\n";
                    }
                }
            }
            if (null == j && resultmap.size() == 0 && cnt > 0) {//一个接口一个表返回值
                return ResultUtil.success("状态:suc;影响行数:" + cnt + ";信息:执行成功!");
            } else {//一个接口多个表返回值
                return ResultUtil.success(result);
            }
        }
        return ResultUtil.error("请将contentType配置成application/x-www-form-urlencoded;charset=UTF-8 类型的!");
    }

    /**
     * 单独处理晋城市检验信息 --上海卫宁
     *
     * @param dcRequestAPI
     * @param dcSchedule
     * @return
     * @throws Exception
     */
    public ResultUtil autoJCDATA(DcRequestAPI dcRequestAPI, List<String> timeList) throws Exception {


        List<LinkedHashMap<String, String>> listTypeBlh = new ArrayList<>();
        Map<String ,List<LinkedHashMap<String, String>>> resMap =  new HashMap<>();
        String sqlText = "";
        //获取最后的结束时间
        String endCondTime = WebSoapUtil.getKeyValues(timeList.get(timeList.size() - 1)).get("endDate");

        for (String param : timeList) {
            int i = 0;
            System.out.println(++i+""+param);
            LinkedHashMap<String, String> keyValues = WebSoapUtil.getKeyValues(param);
            String startDate = keyValues.get("startDate");
            String endDate = keyValues.get("endDate");
            //是或结束条件
            int isEndCondition = 0;
            if (endDate.equals(endCondTime)) {
                isEndCondition = 1;
            }
            // 先删除数据
            String delsql = WebSoapUtil.delTableJcjy(dcRequestAPI.getTag(), dcRequestAPI.getTag_time(), startDate, endDate, dcRequestAPI.getTag_null(), isEndCondition);
            handleDao.excuteSqlWithSQL(delsql);

            //请求协议为json 格式
            if ("2".equals(dcRequestAPI.getAgreetype())) {

                try{
                    HttpResponse response = WebPostUtil.getAutoResponseOfTime(dcRequestAPI.getReqbody(), dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), dcRequestAPI.getStart_node_name(),
                            keyValues.get("startDate"), dcRequestAPI.getEnd_node_name(), keyValues.get("endDate"));
                    System.out.println("****************response**********************");


                    Map<String,Set<String>> setJsonColumns = null;
                    if ("10".equals(dcRequestAPI.getIs_standard().toString())) {
                        setJsonColumns = WebPostUtil.getJsonColumns10(response,dcRequestAPI.getAnalysis_node(),dcRequestAPI.getTag());
                        if (setJsonColumns == null || setJsonColumns.size() == 0) {
                            continue;
                        }
                        System.out.println("-**- 拿到字段");
                        resMap = WebPostUtil.getPostData10(response, setJsonColumns,dcRequestAPI.getAnalysis_node(),dcRequestAPI.getTag());
                    }
                    //同步数据库 和 dc_table表
                    if(setJsonColumns.size()>1){
                        for (String s : setJsonColumns.keySet()) {
                            synchronizationTalbejcjy(s,setJsonColumns.get(s),s);
                        }
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }


            }
            //请求协议为xml 格式
            else if ("1".equals(dcRequestAPI.getAgreetype())) {
                return ResultUtil.error("配置错误");
            }

            if (timeList.size() == 0) {
                continue ;
            }

            System.out.println("----**********-------集合中一共数据条数"+resMap.size());
            DcRequestAPI dd = new DcRequestAPI();
            dd.setWeb_id(dcRequestAPI.getId());
            if(resMap.size()>1){
                for (String s : resMap.keySet()) {

                    for (LinkedHashMap<String, String> stringStringLinkedHashMap : resMap.get(s)) {

                        sqlText = WebSoapUtil.getInsertTableSqlDel(s, stringStringLinkedHashMap);

                        handleDao.excuteSqlWithSQL(sqlText);
                    }
                }
            }

        }
        System.out.println("-**- 结束");
        return ResultUtil.success("抽取成功");
    }

    /**
     * 使用参数处理卫宁数据
     *
     * @param dcRequestAPI     webapi信息
     * @param dcScheduleConfig 调度信息
     * @return 统一的返回信息
     * @throws Exception
     */
    public ResultUtil autoWNDATAByParams1(DcRequestAPI dcRequestAPI, DcScheduleConfig dcScheduleConfig) throws Exception {
        if ("application/x-www-form-urlencoded;charset=UTF-8".equals(dcRequestAPI.getContenttype())) {
            List<Map<String, String>> splicTimeParam = weiNingDataParseUtil.getSplicTimeParam(dcRequestAPI.getStartTime(), dcRequestAPI.getEndTime(), dcScheduleConfig.getParam_unit(), true);
            String resultmsg, sucNum, oldSucNum;
            Integer cnt = 0;
            boolean flag = dcRequestAPI.getTag().contains(",");
            JSONObject j = null, resultmap = new JSONObject(), child;
            for (Map<String, String> e : splicTimeParam) {
                dcRequestAPI.setReqbody("dtbeg=" + e.get("start") + "&dtend=" + e.get("end"));
                resultmsg = autoWNDATA(dcRequestAPI).getMsg();
                if (flag) {//处理一个接口多个表的数据
                    j = JSONUtil.parseObj(resultmsg);
                    for (String s : j.keySet()) {
                        if (resultmap.containsKey(s)) {
                            child = resultmap.getJSONObject(s);
                            child.putOpt("err", child.getStr("err") + j.getJSONObject(s).getStr("err"));
                            sucNum = child.getStr("suc");
                            //如果当天数据不是空的
                            if (j.getJSONObject(s).containsKey("suc")) {
                                oldSucNum = j.getJSONObject(s).getStr("suc");
                                if (NumberUtil.isNumber(oldSucNum) && NumberUtil.isNumber(sucNum)) {
                                    child.putOpt("suc", Integer.parseInt(sucNum) + Integer.parseInt(oldSucNum));
                                }
                            }
                            resultmap.putOpt(s, child);
                        } else {
                            resultmap.putOpt(s, j.getJSONObject(s));
                        }
                    }
                } else if (resultmsg.contains("suc")) {//一个接口一个表
                    cnt += Integer.parseInt(resultmsg.split(";")[1].split(":")[1]);
                }
            }
            String result = "";
            if (resultmap.size() > 0) {
                for (String s : resultmap.keySet()) {
                    child = resultmap.getJSONObject(s);
                    result += s + " : " + "状态:suc;影响行数:" + child.getStr("suc") + ";信息:执行成功!\n";
                    if (StrUtil.isNotEmpty(child.getStr("err"))) {
                        result += child.getStr("err") + "\n";
                    }
                }
            }
            if (null == j && resultmap.size() == 0 && cnt > 0) {//一个接口一个表返回值
                return ResultUtil.success("状态:suc;影响行数:" + cnt + ";信息:执行成功!");
            } else {//一个接口多个表返回值
                return ResultUtil.success(result);
            }
        }
        return ResultUtil.error("请将contentType配置成application/x-www-form-urlencoded;charset=UTF-8 类型的!");
    }

    /**
     * 单独处理卫宁的首页数据
     *
     * @param dcRequestAPI webapi信息
     * @return ResultUtil   处理信息
     * @throws Exception
     */
    public ResultUtil autoWNDATA(DcRequestAPI dcRequestAPI) throws Exception {
        String analysis_node = dcRequestAPI.getTag();
        if (StrUtil.isEmpty(analysis_node)) {
            return ResultUtil.error("解析节点不能为空");
        }
        String body = dcRequestAPI.getReqbody();
        HttpResponse response = WebSoapUtil.getResponse(dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), body, dcRequestAPI.getSoapaction());
        String condis = null;
        switch (dcRequestAPI.getIs_multiwall()) {
            case 2:
                condis = "JZH";
                break;
            case 3:
                condis = "No_Dept,DeptCode";
                break;
            case 4:
                condis = "JZH";
                break;
            case 5:
                condis = "cStaffCode,No_Staff";
                break;
        }
        byte[] bytes;
        String result = "";
        if (analysis_node.contains(",")) {
            String[] ss = analysis_node.split(",");
            Integer[] cnts = new Integer[ss.length];
            for (int i = 0; i < cnts.length; i++) {//初始化多表各自的总数
                cnts[i] = 0;
            }
            JSONObject j = new JSONObject();
            JSONObject child = new JSONObject();
            String err = "", s = "";
            for (int i = 0; i < ss.length; i++) {
                s = ss[i];
                //处理成标准的节点数据
                bytes = weiNingDataParseUtil.getBytesFromFullXMLString(response.body(), s);
                if (bytes.length <= 0) {
                    err = s + " 该解析节点, " + body + " 该时间段内 数据为空 \n";
                    child = new JSONObject();
                    child.putOpt("err", err);
                    j.putOpt(s, child);
                    return ResultUtil.success(j.toString());
                }
                switch (s) {
                    case "PatientInfo":
                        break;
                    case "PatientInfo1":
                        break;
                    case "PatientInfo2":
                        condis = "JZH,SXH,zxzd";
                        break;
                    case "PatientInfo3":
                        condis = "JZH,OPSID";
                        break;
                    case "PatientInfo4":
                        condis = "JZH,FYMC";
                        break;
                }
                synchronizationTalbe(dcRequestAPI, weiNingDataParseUtil.getColumnsOfTable(weiNingDataParseUtil.getRootElementFromXMLString(bytes)), s);
                result = weiNingDataParseUtil.duelData(bytes, dcRequestAPI.getIsparam());
                if (result.contains("suc")) {//执行成功!
                    cnts[i] += Integer.parseInt(result.split(";")[1].split(":")[1]);
                } else {//执行失败了
                    err += result + "\n";
                }
                child = new JSONObject();
                child.putOpt("err", err);
                child.putOpt("suc", cnts[i]);
                j.putOpt(s, child);
            }
            return ResultUtil.success(j.toString());
        } else {
            //处理成标准的节点数据
            bytes = weiNingDataParseUtil.getBytesFromFullXMLString(response.body(), analysis_node);
            if (bytes.length <= 0) {
                return ResultUtil.error(analysis_node + " 该解析节点数据为空 ");
            }
            synchronizationTalbe(dcRequestAPI, weiNingDataParseUtil.getColumnsOfTable(weiNingDataParseUtil.getRootElementFromXMLString(bytes)), analysis_node);
            result = weiNingDataParseUtil.duelData(bytes, dcRequestAPI.getIsparam());
        }
        return ResultUtil.success(result);
    }

    /**
     * 抽取数据类型为 无参的数据
     *
     * @param dcRequestAPI
     * @return
     * @throws Exception
     */
    public ResultUtil AutoData2(DcRequestAPI dcRequestAPI) throws Exception {
        Integer is_standard = dcRequestAPI.getIs_standard();
        if (is_standard == 9) {//卫宁首页接口数据
            return autoWNDATA(dcRequestAPI);
        }
        String sqlText = "";
        List<LinkedHashMap<String, String>> listNull = new ArrayList<>();
        //清理表数据
        String s = WebSoapUtil.delTableData(dcRequestAPI.getTag());
        handleDao.excuteSqlWithSQL(s);
        if ("2".equals(dcRequestAPI.getAgreetype())) {
            HttpResponse response = HttpRequest.post(dcRequestAPI.getUrl()).contentType(dcRequestAPI.getContenttype()).execute();
            Set<String> setJsonColumns = null;
            if ("-1".equals(dcRequestAPI.getIs_standard().toString())) {  //不规范的json数据
                setJsonColumns = WebPostUtil.getJsonColumnsNOStandard(response);
                listNull = WebPostUtil.getPostDataNoStandard(response, setJsonColumns);
            } else {
                setJsonColumns = WebPostUtil.getJsonColumns(response, dcRequestAPI.getAnalysis_node());
                listNull = WebPostUtil.getPostData(response, setJsonColumns, dcRequestAPI.getAnalysis_node());
            }
        } else if ("1".equals(dcRequestAPI.getAgreetype())) {
            listNull = WebSoapUtil.getTableDate(dcRequestAPI.getAgreetype(), dcRequestAPI.getIs_standard(), dcRequestAPI.getReqbody(), dcRequestAPI.getAnalysis_node(),
                    dcRequestAPI.getUrl(), dcRequestAPI.getContenttype(), dcRequestAPI.getName_space(), dcRequestAPI.getName_space_url(), dcRequestAPI.getSoapaction());
        }
        for (LinkedHashMap<String, String> stringStringLinkedHashMap : listNull) {
            sqlText = WebSoapUtil.getInsertTableSqlDel(dcRequestAPI.getTag(), stringStringLinkedHashMap);
            handleDao.excuteSqlWithSQL(sqlText);
        }
        return ResultUtil.success("抽取成功");
    }

    /**
     * 删除api和相关的内容
     *
     * @param id
     */
    public void deleteInfosById(String id) {
        DcRequestAPI api = findById(id);
        if (null == api) {
            return;
        }
        DcScheduleConfig schedule = new DcScheduleConfig();
        schedule.setProcedure_id(api.getId());
        schedule.setProduct_id(api.getProduct_id());
        dcScheduleConfigDao.delete(schedule);
        String tname = api.getTag();
        String tnamezh = api.getName();
        if (StrUtil.isNotEmpty(tname)) {
            DcTable t = new DcTable();
            DcColumn c = new DcColumn();
            if (tname.contains(",")) {
                for (String s : tname.split(",")) {
                    t = new DcTable();
                    t.setName(s);
                    t.setName_zh(tnamezh);
                    dcTableDao.delete(t);
                    c = new DcColumn();
                    c.setTable_name(s);
                    dcColumnDao.delete(c);
                }
            } else {
                t.setName(tname);
                t.setName_zh(tnamezh);
                dcTableDao.delete(t);
                c.setTable_name(tname);
                dcColumnDao.delete(c);
            }
        }
        deleteById(id);
    }
}
