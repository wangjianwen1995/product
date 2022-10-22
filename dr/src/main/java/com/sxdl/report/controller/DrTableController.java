package com.sxdl.report.controller;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.report.dao.dao1.DrDbzinfoDao;
import com.sxdl.report.dao.dao1.HandleDao;
import com.sxdl.report.entity.*;
import com.sxdl.report.service.DrColumnService;
import com.sxdl.report.service.DrReprotRecordService;
import com.sxdl.report.service.DrTableService;
import com.sxdl.report.service.DrTemplateService;
import com.sxdl.report.util.DataUtil;
import com.sxdl.report.util.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "模板表维护")
@RestController
@RequestMapping("/table")
public class DrTableController {

    DrReprotRecord repostData = null;
    String sTime = "";
    String eTime = "";
    String UUID = "";
    @Autowired
    private DrTableService drTableService;
    @Autowired
    private DrReprotRecordService drReprotRecordService;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DrDbzinfoDao drDbzinfoDao;
    @Autowired
    private DrColumnService drColumnService;

    //判断表名称是否修改过 2 没有修改修改表结构   3修改表了就直接创建新的数据表
    @Autowired
    private DrTemplateService drTemplateService;

    @ApiOperation(value = "查询", notes = "查询所有表信息")
    @GetMapping("/findAll")
    public ResultUtil<PageInfo<DrTable>> findAll(PageInfo pageInfo, @RequestParam(value = "name", defaultValue = "", required = false) String name) {
        try {
            DrTable table = new DrTable();
            table.setName(name);
            PageInfo<DrTable> list = drTableService.queryPageList(pageInfo, table);
            return ResultUtil.success(list);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "根据模板id获取表列表", notes = "根据模板id获取表列表")
    @GetMapping("/findByTempId")
    @ResponseBody
    public ResultUtil findByTempId(PageInfo pageInfo, @RequestParam(value = "id", required = true) Integer id) {
        DrTable table = new DrTable();
        table.setTemplate_id(id);

        try {
            List<DrDbzinfo> drDbzinfos = drDbzinfoDao.selectAll();
            PageInfo<DrTable> list = drTableService.queryPageList(pageInfo, table);
            list.getList().forEach(e -> {
                drDbzinfos.forEach(l -> {
                    if (e.getId() == l.getTableid()) {
                        e.setSid(l.getSid());
                        e.setSidname(l.getSidname());
                    }
                });
            });
            return ResultUtil.success(list);
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
    }

    @ApiOperation(value = "保存修改", notes = "保存表信息")
    @PostMapping("/save")
    @ResponseBody
    public ResultUtil insert(@RequestBody DrTable table) {
        if (table == null) {
            return ResultUtil.error("没有数据要保存");
        }
        try {
            Integer id = table.getId();
            if ("".equals(id) || null == id) {
                table.setName("r_" + table.getName());
                DrTable newTable = new DrTable();
                newTable.setName(table.getName());
                List<DrTable> drTableList = drTableService.select(newTable);
                if (drTableList.size() > 0) {
                    return ResultUtil.error("库中已经存在该表！");
                } else {
                    ///开始创建数据表
                    Integer tempID = table.getTemplate_id();
                    DrTemplate temp = drTemplateService.selectByKey(tempID);

                    //测试视图名存在不存在
                    Integer linkType = temp.getReport_source();
                    String linkName = "";
                    switch (linkType) {
                        case 1:
                            linkName = "DRBA";
                            break;
                        case 2:
                            linkName = "DRBA";
                            break;
                        case 3:
                            linkName = "DRSD";
                            break;

                    }
                    String dbName = temp.getDb_name();
                    String tableName = table.getName();
                    String viewName = table.getView_name();
                    String result = handleDao.execSelectSql(" select * into " + tableName + " from " + linkName + "." + dbName + ".dbo." + viewName + " where 1=0 ");
                    String result2 = handleDao.execSelectSql(" select *  ,CAST('' AS VARCHAR(200)) uuid into " + tableName + "_bak from " + linkName + "." + dbName + ".dbo." + viewName + " where 1=0 ");
                    DrColumn DrColumn = new DrColumn();
                    drTableService.insert(table);
                    List<Map<String, Object>> list = handleDao.findDbInfo("sp_columns " + tableName + "");
                    list.forEach(e -> {
                        DrColumn.setName(e.get("COLUMN_NAME").toString());
                        DrColumn.setName_zh(e.get("COLUMN_NAME").toString());
                        DrColumn.setColumn_type(Integer.parseInt(e.get("DATA_TYPE").toString()));
                        DrColumn.setSize(Integer.parseInt(e.get("LENGTH").toString()));
                        DrColumn.setScale(Integer.parseInt((e.get("SCALE") == null ? "0" : e.get("SCALE")).toString()));
                        DrColumn.setTable_id(table.getId());
                        drColumnService.insert(DrColumn);
                    });

                }
            } else { //修改数据
                DrTable newTable = new DrTable();
                newTable.setName(table.getName());
                List<DrTable> drTableList = drTableService.select(newTable);
                if (drTableList.size() > 0) {
                    drTableService.update(table);
                    return ResultUtil.success("修改成功！");

                } else {
                }
                return ResultUtil.error("操作失败: 数据库中没有找到该表");
            }
            return ResultUtil.success("操作成功");
        } catch (Exception e) {
            return ResultUtil.error("保存失败");
        }
    }

    @ApiOperation(value = "重构表", notes = "保存表信息")
    @PostMapping("/reconstructionTable")
    @ResponseBody
    public ResultUtil reconstructionTable(@RequestBody DrTable table) {
        try {
            ///开始创建数据表
            Integer tempID = table.getTemplate_id();
            DrTemplate temp = drTemplateService.selectByKey(tempID);
            //测试视图名存在不存在
            Integer linkType = temp.getReport_source();
            String linkName = "";
            switch (linkType) {
                case 1:
                    linkName = "DRBA";
                    break;
                case 2:
                    linkName = "DRBA";
                    break;
                case 3:
                    linkName = "DRSD";
                    break;

            }
            String dbName = temp.getDb_name();
            String tableName = table.getName();
            String viewName = table.getView_name();
            drDbzinfoDao.dropTable(tableName);
            drDbzinfoDao.dropTable(tableName + "_bak");
            String result = handleDao.execSelectSql(" select * into " + tableName + " from " + linkName + "." + dbName + ".dbo." + viewName + " where 1=0 ");
            String result2 = handleDao.execSelectSql(" select *  ,CAST('' AS VARCHAR(200)) uuid into " + tableName + "_bak from " + linkName + "." + dbName + ".dbo." + viewName + " where 1=0 ");
            DrColumn DrColumn = new DrColumn();
            List<Map<String, Object>> list = handleDao.findDbInfo("sp_columns " + tableName + "");
            //删除 字段表里面的数据
            Integer del = drColumnService.deleteByPid(table.getId());
            list.forEach(e -> {
                DrColumn.setName(e.get("COLUMN_NAME").toString());
                DrColumn.setName_zh(e.get("COLUMN_NAME").toString());
                DrColumn.setColumn_type(Integer.parseInt(e.get("DATA_TYPE").toString()));
                DrColumn.setSize(Integer.parseInt(e.get("LENGTH").toString()));
                DrColumn.setScale(Integer.parseInt((e.get("SCALE") == null ? "0" : e.get("SCALE")).toString()));
                DrColumn.setTable_id(table.getId());
                drColumnService.insert(DrColumn);
            });
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("重新创建表结构完成");
    }

    @ApiOperation(value = "删除表", notes = "删除表")
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultUtil delete(@RequestParam(value = "id", required = true) Integer id) {
        try {
            drTableService.delete(id);
            return ResultUtil.success("删除成功");
        } catch (Exception e) {
            return ResultUtil.error(e.getMessage());
        }

    }

    @ApiModelProperty(value = "手动上报", notes = "手动上报")
    @GetMapping("/ManualReport")
    @ResponseBody
    public synchronized ResultUtil ManualReport(@RequestParam("templateId") Integer templateId,
                                                @RequestParam("tableId") Integer tableId,
                                                @RequestParam(value = "statTime", required = true) String statTime,
                                                @RequestParam(value = "endTime", required = true) String endTime,
                                                @RequestParam(value = "no", required = false) String no) {

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DrTemplate template = drTemplateService.findById(templateId);
            DrTable table = drTableService.findById(tableId);

            String insertSql = "";
            if ("1".equals(template.getTemplate_type())) {//大同五院DRG医保上报
                //将数据抽取到 中间容器 表中(R_开头的数据表)
                int intDrg = drTableService.EtlDRG("1", table, statTime, endTime, no);
                //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
                List<LinkedHashMap> dataList = drTableService.execAllData(table.getName());
                if (dataList.size() <= 0) return ResultUtil.error("没有数据");


                for (LinkedHashMap map : dataList) {
                    try {
                        sTime = simpleDateFormat.format(new Date());
                        //上报之前先将原有数据组装到reprt表中和_bak表中
                        repostData = setReportData(templateId, template, table, map);
                        //平台返回数据开始上传数据**************************核心*******************************
                        LinkedHashMap<String, String> stringStringMap = drTableService.fileDRGTemplate(map, template, table.getPrimarykey());
                        eTime = simpleDateFormat.format(new Date());
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_content(stringStringMap.get("error"));
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        System.out.println("sql _bak: " + insertSql);
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    } catch (Exception e) {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        repostData.setUpload_end_time(sTime);
                        repostData.setResult_type("本地故障：500");
                        repostData.setResult_content("自动上报出错，请联系管理员:" + e.getMessage());
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    }
                }
            } else if ("2".equals(template.getTemplate_type())) {  //长治市医保上报
                //根据 前台选择的条件 将数据抽取 到中间容器中
                int intDrg = drTableService.EtlDRG("2", table, statTime, endTime, no);
                //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
                List<LinkedHashMap<String, Object>> dataList = drTableService.execAllData3(table.getName());
                if (dataList.size() < 0) return ResultUtil.error("没有数据");
                for (LinkedHashMap<String, Object> map : dataList) {
                    try {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        JSONObject jsonObject = JSONUtil.parseObj(map);
                        //向平台发送数据                         String map,           String hostUrl           ,String contentType,     String token,        String user_agent
                        net.sf.json.JSONObject jo = RequestUtil.sendOut2(jsonObject.toString(), template.getReport_url(), template.getReport_type(), template.getToken(), template.getObsolete_url());
                        eTime = simpleDateFormat.format(new Date());
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_type(jo.getString("code"));
                        repostData.setResult_content(jo.getString("message") + " -《分割》- " + jo.getString("data"));
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    } catch (Exception e) {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        repostData.setUpload_end_time(sTime);
                        repostData.setResult_type("本地故障：500");
                        repostData.setResult_content("自动上报出错，请联系管理员:" + e.getMessage());
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    }
                }

            } else if ("3".equals(template.getTemplate_type())) {//3 大同五院单病种上报
                //根据 前台选择的条件 将数据抽取 到中间容器中
                int intDrg = drTableService.EtlDRG("3", table, statTime, endTime, no);
                //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
                List<LinkedHashMap> dataList = drTableService.selectAllTableData(table.getName());
                if (dataList.size() <= 0) return ResultUtil.error("没有数据");
                for (LinkedHashMap map : dataList) {
                    try {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        JSONObject jsonObject = JSONUtil.parseObj(map);
                        //向平台发送数据
                        net.sf.json.JSONObject jo = RequestUtil.sentOutSd(jsonObject.toString(), template.getReport_url(), template.getReport_type());
                        eTime = simpleDateFormat.format(new Date());
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_type(jo.getString("code"));
                        repostData.setResult_content(jo.getString("message"));
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int str = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    } catch (Exception e) {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        repostData.setUpload_end_time(sTime);
                        repostData.setResult_type("本地故障：500");
                        repostData.setResult_content("手动上报出错，请联系管理员:" + e.getMessage());
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    }
                }
            } else if ("4".equals(template.getTemplate_type())) {//4 DRG医保web上报
                System.out.println("web上报开始");
                int intDrg = drTableService.EtlDRG("4", table, statTime, endTime, no);
                //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
                List<LinkedHashMap<String, Object>> dataList = drTableService.selectAllTableData2(table.getName());
                if (dataList.size() < 0) return ResultUtil.error("没有数据");
                for (LinkedHashMap<String, Object> map : dataList) {
                    try {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        //开始发送数据
                        String data = RequestUtil.requestData(map, template.getToken(), template.getObsolete_url(),
                                template.getReport_url(), template.getEncode(), template.getEnd_time());
                        eTime = simpleDateFormat.format(new Date());
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_content(data);
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int str = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    } catch (Exception e) {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        repostData.setUpload_end_time(sTime);
                        repostData.setResult_type("本地故障：500");
                        repostData.setResult_content("手动上报出错，请联系管理员:" + e.getMessage());
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    }
                }
            } else if ("5".equals(template.getTemplate_type()) || "6".equals(template.getTemplate_type())) {//5 DIP注册 6 DIP上报 7 DIP冲销
                //将试图数据放到容器表中(r_表)
                int intDrg = drTableService.EtlDRG("5", table, statTime, endTime, no);
                //获取中间容器中的所有数据（包括字段值为null的字段数据<本框架字段值为null就会少字段>）
                List<LinkedHashMap<String, Object>> dataList = drTableService.execAllData3(table.getName());
                //List<LinkedHashMap<String,Object>> dataList = drTableService.selectAllTableData2( table.getName() );
                if (dataList.size() < 1) return ResultUtil.error("没有数据");
                for (LinkedHashMap<String, Object> map : dataList) {
                    try {

                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        //开始发送数据
                        net.sf.json.JSONObject data = RequestUtil.sendOutPID(template.getTemplate_type(), template.getReport_url(),
                                template.getReport_type(),
                                template.getObsolete_url(), template.getToken(), template.getHost(), map);
                        System.out.println("返回值" + data.toString());
                        eTime = simpleDateFormat.format(new Date());
                        repostData.setUpload_end_time(eTime);
                        repostData.setResult_type(data.getString("CODE"));
                        repostData.setResult_content(data.toString());
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int str = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    } catch (Exception e) {
                        sTime = simpleDateFormat.format(new Date());
                        repostData = setReportData(templateId, template, table, map);
                        repostData.setUpload_end_time(sTime);
                        repostData.setResult_type("本地故障：500");
                        repostData.setResult_content("手动上报出错，请联系管理员:" + e.getMessage());
                        insertSql = " insert into " + table.getName() + "_bak select *,'" + UUID + "' from " + table.getName() + " where " + table.getPrimarykey() + "='" + map.get(table.getPrimarykey()) + "'";
                        int ss = handleDao.excuteSqlWithSQL(insertSql);
                        drReprotRecordService.insert(repostData);
                    }
                }

            } else if ("7".equals(template.getTemplate_type())) {
                try {

                    sTime = simpleDateFormat.format(new Date());
                    //开始发送数据
                    net.sf.json.JSONObject data = RequestUtil.sendOutPID7(template.getReport_url(),
                            template.getReport_type(),
                            template.getObsolete_url(), template.getToken(), template.getHost(), no);
                    System.out.println("冲销返回值" + data.toString());
                    eTime = simpleDateFormat.format(new Date());
                    repostData.setUpload_end_time(eTime);
                    repostData.setResult_type(data.getString("CODE"));
                    repostData.setResult_content(data.toString());
                    drReprotRecordService.insert(repostData);
                } catch (Exception e) {
                    sTime = simpleDateFormat.format(new Date());
                    repostData = setReportData7(templateId, template, table, no);
                    repostData.setUpload_end_time(sTime);
                    repostData.setResult_type("本地故障：500");
                    repostData.setResult_content("冲销异常，请联系管理员:" + e.getMessage());
                    drReprotRecordService.insert(repostData);
                }
            }
            return ResultUtil.success("上报数据完成，请查看详细日志.....");
        } catch (Exception e) {
            return ResultUtil.error("雕龙后台异常请联系管理员:" + e.getMessage());
        }

    }


    DrReprotRecord setReportData(Integer templateId, DrTemplate template, DrTable table, LinkedHashMap map) {
        repostData = new DrReprotRecord();
        UUID = java.util.UUID.randomUUID().toString();
        repostData.setTemplate_id(templateId);
        repostData.setProduct_id(template.getProduct_id());
        repostData.setPrimarykey(StringUtils.isEmpty(map.get(DataUtil.stringReplaces(table.getPrimarykey()))) ? null : map.get(DataUtil.stringReplaces(table.getPrimarykey())).toString());
        repostData.setUpload_start_time(sTime);
        repostData.setKs_code_ry(map.get(table.getKs_code_ry()) == null ? null : map.get(DataUtil.stringReplaces(table.getKs_code_ry())).toString());
        repostData.setKs_code_cy(map.get(table.getKs_code_cy()) == null ? null : map.get(DataUtil.stringReplaces(table.getKs_code_cy())).toString());
        repostData.setZyh(map.get(table.getZyh()) == null ? null : map.get(DataUtil.stringReplaces(table.getZyh())).toString());
        repostData.setSex(map.get(table.getSex()) == null ? null : map.get(DataUtil.stringReplaces(table.getSex())).toString());
        repostData.setPrimary_diagnosis(map.get(table.getPrimary_diagnosis()) == null ? null : map.get(DataUtil.stringReplaces(table.getPrimary_diagnosis())).toString());
        repostData.setAge(map.get(table.getAge()) == null ? null : map.get(DataUtil.stringReplaces(table.getAge())).toString());
        repostData.setQuerytime(map.get(table.getQuerytime()) == null ? null : map.get(DataUtil.stringReplaces(table.getQuerytime())).toString());
        repostData.setAge_unit(map.get(table.getAge_unit()) == null ? null : map.get(DataUtil.stringReplaces(table.getAge_unit())).toString());
        repostData.setZhxm(map.get(table.getZhxm()) == null ? null : map.get(DataUtil.stringReplaces(table.getZhxm())).toString());
        repostData.setUuid(UUID);
        return repostData;
    }

    DrReprotRecord setReportData7(Integer templateId, DrTemplate template, DrTable table, String keyString) {
        repostData = new DrReprotRecord();
        UUID = java.util.UUID.randomUUID().toString();
        repostData.setTemplate_id(templateId);
        repostData.setProduct_id(template.getProduct_id());
        repostData.setPrimarykey(keyString);
        repostData.setUpload_start_time(sTime);
        repostData.setUuid(UUID);
        return repostData;
    }


}
