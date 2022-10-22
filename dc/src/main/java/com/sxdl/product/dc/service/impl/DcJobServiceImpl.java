package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.*;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.*;
import com.sxdl.product.dc.service.DcJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("dcJobService")
@Transactional
public class DcJobServiceImpl extends /*JpaCondition<DcJob>*/   BaseUUIDServiceImpl<DcJob> implements DcJobService {
    @Autowired
    private DcJobServiceImpl dcJobService;

    @Autowired
    private DcJobDao dcJobDao;


    @Autowired
    private DcHospitalDao dcHospitalDao;


    @Autowired
    private DcProcedureDao procedureDao;
    @Autowired
    private DcScheduleDao dcScheduleDao;
    @Autowired
    private DcRequestAPIDao requestAPIDao;
    @Autowired
    private DcTableDao dcTableDao;
    @Autowired
    private DcTransferDao dcTransferDao;
    @Autowired
    private DcVirtualTableDao dcVirtualTableDao;
    @Autowired
    private DcTableVsTableDao dcTableVsTableDao;

    @Autowired
    private DcColumnDao dcColumnDao;

    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcProductDao dcProductDao;
    @Autowired
    private DcScheduleConfigDao dcScheduleConfigDao;
    @Autowired
    private DcSingleConfigDao dcSingleConfigDao;

   /* @Override
    public void insertByJob(Map<String, Object> map) {
        String result = "";
        String hosID = "";
        Boolean hasHospital = false;


        *//*一、*********** 开始导入医院数据 ************//*
        DcHospital hospital = JSON.parseObject(JSON.toJSONString(map.get("dcHospital")), DcHospital.class);
        List<DcHospital> dcHospitals = dcHospitalDao.selectAll();
        if (null != dcHospitals && dcHospitals.size() > 0) {
            hosID = dcHospitals.get(0).getId();
            hasHospital = true;
        } else {
            dcHospitalDao.insert(hospital);
        }

        *//*一、*********** 开始导入工单数据 ************//*
        DcJob dcJob = JSON.parseObject(JSON.toJSONString(map.get("dcJobList")), DcJob.class);

        DcJob dcJob1 = dcJobDao.selectByPrimaryKey(dcJob.getId());
        if (null != dcJob1) return;
        //"该工单ID已存在！";
        dcJobDao.insert(dcJob);



        *//*三、*********** 开始导入直连库数据 ************//*
        //1.从文件中取出数据
        List<DcTransfer> transferList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcTransferList")), DcTransfer.class);
        //2.先判断是否存在流中的链接服务器，如果存在不保存，不存在则进行保存操作
        //步骤  3 需要的参数。
        String fromType = "";
        String name = "";
        String linkStr = "";
        String fromUrl = "";
        String username = "";
        String pwd = "";
        if (null != transferList && transferList.size() > 0) {
            for (DcTransfer dcTransfer : transferList) {
                DcTransfer dcTransfer1 = dcTransferDao.selectByPrimaryKey(dcTransfer.getId());
                if (null != dcTransfer1)  *//*如果存在，直接跳到下一次循环*//* continue;
                if (hasHospital) dcTransfer.setHospital_id(hosID);
                dcTransferDao.insert(dcTransfer);
                //3.创建链接服务器
            *//*if (dcTransfer.getIsogeny() != 1) {
                fromType = dcTransfer.getFrom_type();
                linkStr = dcTransfer.getLink_str();
                name = dcTransfer.getName();
                fromUrl = dcTransfer.getFrom_uri();
                username = dcTransfer.getFrom_username();
                pwd = dcTransfer.getFrom_pwd();
                String info = handleDao.findInfo(name, fromType, fromUrl, username, pwd, linkStr);
               if("3".equals(info)){
                   String link = url.split("//")[1];
                   fromUrl = link.split(":")[0];
                   handleDao.findInfo(name, "SQLOLEDB", fromUrl, dbusername, dbpassword, linkStr);
               }

            }*//*
            }
        }
        *//*四、*********** 开始导入WebService数据 ************//*
        //1.从文件中取出数据
        List<DcRequestAPI> requestAPIList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcRequestAPIList")), DcRequestAPI.class);

        //2.先判断是否存在，如果存在不保存，不存在则进行保存操作
        if (null != requestAPIList && requestAPIList.size() > 0) {
            for (DcRequestAPI dcRequestAPI : requestAPIList) {
                DcRequestAPI dcRequestAPI1 = requestAPIDao.selectByPrimaryKey(dcRequestAPI.getId());
                if (null != dcRequestAPI1)  *//*如果存在，直接跳到下一次循环*//* continue;
                if (hasHospital) dcRequestAPI.setHospital_id(hosID);
                requestAPIDao.insert(dcRequestAPI);
            }
        }
        *//*五、*********** 开始导入存储过程表及创建存储过程 ************//*
        //1.从文件中取出存储数据
        List<DcProcedure> procedureList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcProcedureList")), DcProcedure.class);
        //2.一个工单下有多个存储，遍历插入数据库
        if (null != procedureList && procedureList.size() > 0) {
            for (DcProcedure dcProcedure : procedureList) {
                //3.循环判断数据库中是否有该存储，有存储的话则不进行保存操作，直接进行下一次循环
                DcProcedure dcProcedure1 = procedureDao.selectByPrimaryKey(dcProcedure.getId());
                if (null != dcProcedure1)  *//*如果存在，直接跳到下一次循环*//* continue;
                //4.判断医院是否存在，若存在，则需要将数据流中的医院ID改为现在的医院ID
                if (hasHospital) dcProcedure.setHospital_id(hosID);
                procedureDao.insert(dcProcedure);
                //5.存储表保存完成之后，需要生成存储，执行生成存储的sql
                //5.1 判断存储是否存在，存在则删除
           *//* String sql = "if exists(select * from sys.procedures where name='" + dcProcedure.getName() + "')\n" +
                    "drop procedure dbo." + dcProcedure.getName() + " ";
            handleDao.excuteSqlWithSQL(sql);
            //5.2 生成存储过程
            String content = dcProcedure.getContent();
            handleDao.excuteSqlWithSQL(content);*//*
            }
        }
        *//*六、*********** 开始导入 表及创建表 ************//*
        StringBuilder sb = new StringBuilder();
        String isKey = "";
        String isExist = "";
        String existresult = "";
        //1.从数据中取出表数据及字段信息
        List<DcTable> dcTableList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcTableList")), DcTable.class);

        List<DcColumn> dcColumnList = new ArrayList<>();
        //2.循环判断表里是否有这个表的信息，有的话就跳过，没有再进行保存
        if (null != dcTableList && dcTableList.size() > 0 && null != dcColumnList && dcColumnList.size() > 0 ) {
            for (DcTable dcTable : dcTableList) {
                isKey = "";
                DcTable dcTable1 = dcTableDao.selectByPrimaryKey(dcTable.getId());
                if (null != dcTable1)  *//*如果存在，直接跳到下一次循环*//* continue;
                //2.1 先保存表数据
                dcTableDao.insert(dcTable);
                //2.2 再取出这个表对应的字段信息，进行保存
                dcColumnList = dcTable.getDcColumnList();
                for (DcColumn dcColumn : dcColumnList) {
                    dcColumnDao.insert(dcColumn);
                }

                sb.delete(0, sb.length());
                //3 判断表是否需要创建数据库  0代表不需要创建表，1代表需要创建表
                if (!"1".equals(dcTable.getIsexist())) continue;
                //3.1继续判断数据库中是否存在这个表，如果没有则进行建表操作
                isExist = "select 1  from sysObjects where Id=OBJECT_ID(N'" + dcTable.getName() + "') and xtype='U'\n";
                existresult = handleDao.execSelectSql(isExist);
                if (StringUtil.isEmpty(existresult) || !existresult.equals("1")) {
                    sb.append("create TABLE ").append(dcTable.getName()).append("( ");

                    for (DcColumn dc : dcColumnList) {
                        if (2 == dc.getType_id()) {  // 添加int类型的字段
                            if (dc.getColumn_name().equalsIgnoreCase("id")) {
                                isKey = dc.getColumn_name();
                                sb.append(dc.getColumn_name()).append("  int IDENTITY(1,1) NOT NULL, ");
                            } else {
                                sb.append(dc.getColumn_name()).append(" int null, ");
                            }

                        } else if (1 == dc.getType_id()) { // 添加String类型的字段

                            if (dc.getSize() >= 8000) {
                                sb.append(dc.getColumn_name()).append(" varchar(MAX)").append(" null, ");
                            } else {
                                if (dc.getColumn_name().equalsIgnoreCase("id")) {
                                    isKey = dc.getColumn_name();
                                    sb.append(dc.getColumn_name()).append("  varchar (" + dc.getSize() + ") default   newid() not null ,");
                                } else {
                                    sb.append(dc.getColumn_name()).append("  varchar (" + dc.getSize() + ")").append(" null, ");
                                }
                            }
                        } else if (3 == dc.getType_id()) { //日期
                            sb.append(dc.getColumn_name()).append(" date null, ");
                        } else if (4 == dc.getType_id()) {
                            sb.append(dc.getColumn_name()).append(" datetime null, ");
                        } else if (5 == dc.getType_id()) {
                            sb.append(dc.getColumn_name()).append(" decimal (" + dc.getSize() + ", " + dc.getScale() + ") null,");
                        }
                    }
                    if ("".equals(isKey) || null == isKey) {
                        sb.append(")");
                    } else {
                        sb.append(" CONSTRAINT PK_").append(dcTable.getName()).append(" PRIMARY KEY CLUSTERED  ( " + isKey + " ASC ) )");
                    }
                    System.out.println("iskey" + isKey);
                    handleDao.createNewTable(sb.toString());
                }
            }
        }
        *//*七、*********** 开始导入 调度信息 ************//*

        List<DcSchedule> dcScheduleList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcScheduleList")), DcSchedule.class);
        if (null != dcScheduleList && dcScheduleList.size() > 0) {
            for (DcSchedule dcSchedule : dcScheduleList) {
                DcSchedule dcSchedule1 = dcScheduleDao.selectByPrimaryKey(dcSchedule.getId());
                if (null != dcSchedule1)  *//*如果存在，直接跳到下一次循环*//* continue;
                dcScheduleDao.insert(dcSchedule);
            }
        }
        *//*八、*********** 开始 导入表关系 ************//*
        List<DcTableVsTable> dcTableVsTableList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcTableVsTableList")), DcTableVsTable.class);
        if (null != dcTableVsTableList && dcTableVsTableList.size() > 0) {
            for (DcTableVsTable dcTableVsTable : dcTableVsTableList) {
                DcTableVsTable dcTableVsTable1 = dcTableVsTableDao.selectByPrimaryKey(dcTableVsTable.getId());

                if (null != dcTableVsTable1)  *//*如果存在，直接跳到下一次循环*//* continue;
                dcTableVsTableDao.insert(dcTableVsTable);
            }
        }
        *//*九、*********** 开始 导入表关系 ************//*
        List<DcVirtualTable> dcVirtualTableList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcVirtualTableList")), DcVirtualTable.class);
        if (null != dcVirtualTableList && dcVirtualTableList.size() > 0) {
            for (DcVirtualTable dcVirtualTable : dcVirtualTableList) {
                dcVirtualTableDao.insert(dcVirtualTable);
            }
        }
        *//*十、*********** 开始 导入产品信息 ************//*
        List<DcProduct> dcProducts = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcProductList")), DcProduct.class);
        if (null != dcProducts && dcProducts.size() > 0) {
            for (DcProduct p : dcProducts) {
                DcProduct dcProduct = dcProductDao.selectByPrimaryKey(p.getId());
                if (null != dcProduct) continue;
                dcProductDao.insert(p);
            }
        }

    }*/

    @Override
    public void insertByJob(Map<String, Object> map) {
        String result = "";
        String hosID = "";
        Boolean hasHospital = false;

        /*一、*********** 开始导入医院数据 ************/
        DcHospital hospital = JSON.parseObject(JSON.toJSONString(map.get("dcHospital")), DcHospital.class);
        List<DcHospital> dcHospitals = dcHospitalDao.selectAll();
        if (null != dcHospitals && dcHospitals.size() > 0) {
            hosID = dcHospitals.get(0).getId();
            hasHospital = true;
        } else {
            dcHospitalDao.insert(hospital);
        }

        /*一、*********** 开始导入工单数据 ************/
        //DcJob dcJob = JSON.parseObject(JSON.toJSONString(map.get("dcJobList")), DcJob.class);
        List<DcJob> dcJobList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcJobList")), DcJob.class);
        DcJob dcJob = new DcJob();
        for (DcJob e : dcJobList) {
            dcJob = dcJobDao.selectByPrimaryKey(e.getId());
            if (null != dcJob)  /*如果存在，直接跳到下一次循环*/ continue;
            if (hasHospital) e.setHospital_id(hosID);
            dcJobDao.insert(e);
        }



        /*三、*********** 开始导入直连库数据 ************/
        //1.从文件中取出数据
        List<DcTransfer> transferList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcTransferList")), DcTransfer.class);
        //2.先判断是否存在流中的链接服务器，如果存在不保存，不存在则进行保存操作
        //步骤  3 需要的参数。
        String fromType = "";
        String name = "";
        String linkStr = "";
        String fromUrl = "";
        String username = "";
        String pwd = "";
        if (null != transferList && transferList.size() > 0) {
            for (DcTransfer dcTransfer : transferList) {
                DcTransfer dcTransfer1 = dcTransferDao.selectByPrimaryKey(dcTransfer.getId());
                if (null != dcTransfer1)  /*如果存在，直接跳到下一次循环*/ continue;
                if (hasHospital) dcTransfer.setHospital_id(hosID);
                dcTransferDao.insert(dcTransfer);
                //3.创建链接服务器
            /*if (dcTransfer.getIsogeny() != 1) {
                fromType = dcTransfer.getFrom_type();
                linkStr = dcTransfer.getLink_str();
                name = dcTransfer.getName();
                fromUrl = dcTransfer.getFrom_uri();
                username = dcTransfer.getFrom_username();
                pwd = dcTransfer.getFrom_pwd();
                String info = handleDao.findInfo(name, fromType, fromUrl, username, pwd, linkStr);
               if("3".equals(info)){
                   String link = url.split("//")[1];
                   fromUrl = link.split(":")[0];
                   handleDao.findInfo(name, "SQLOLEDB", fromUrl, dbusername, dbpassword, linkStr);
               }

            }*/
            }
        }
        /*四、*********** 开始导入WebService数据 ************/
        //1.从文件中取出数据
        List<DcRequestAPI> requestAPIList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcRequestAPIList")), DcRequestAPI.class);

        //2.先判断是否存在，如果存在不保存，不存在则进行保存操作
        if (null != requestAPIList && requestAPIList.size() > 0) {
            for (DcRequestAPI dcRequestAPI : requestAPIList) {
                DcRequestAPI dcRequestAPI1 = requestAPIDao.selectByPrimaryKey(dcRequestAPI.getId());
                if (null != dcRequestAPI1)  /*如果存在，直接跳到下一次循环*/ continue;
                if (hasHospital) dcRequestAPI.setHospital_id(hosID);
                requestAPIDao.insert(dcRequestAPI);
            }
        }
        /*五、*********** 开始导入存储过程表及创建存储过程 ************/
        //1.从文件中取出存储数据
        List<DcProcedure> procedureList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcProcedureList")), DcProcedure.class);
        //2.一个工单下有多个存储，遍历插入数据库
        if (null != procedureList && procedureList.size() > 0) {
            for (DcProcedure dcProcedure : procedureList) {
                //3.循环判断数据库中是否有该存储，有存储的话则不进行保存操作，直接进行下一次循环
                DcProcedure dcProcedure1 = procedureDao.selectByPrimaryKey(dcProcedure.getId());
                if (null != dcProcedure1)  /*如果存在，直接跳到下一次循环*/ continue;
                //4.判断医院是否存在，若存在，则需要将数据流中的医院ID改为现在的医院ID
                if (hasHospital) dcProcedure.setHospital_id(hosID);
                procedureDao.insert(dcProcedure);
                //5.存储表保存完成之后，需要生成存储，执行生成存储的sql
                //5.1 判断存储是否存在，存在则删除
           /* String sql = "if exists(select * from sys.procedures where name='" + dcProcedure.getName() + "')\n" +
                    "drop procedure dbo." + dcProcedure.getName() + " ";
            handleDao.excuteSqlWithSQL(sql);
            //5.2 生成存储过程
            String content = dcProcedure.getContent();
            handleDao.excuteSqlWithSQL(content);*/
            }
        }
        /*六、*********** 开始导入 表及创建表 ************/
        StringBuilder sb = new StringBuilder();
        String isKey = "";
        String isExist = "";
        String existresult = "";
        //1.从数据中取出表数据及字段信息
        List<DcTable> dcTableList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcTableList")), DcTable.class);

        List<DcColumn> dcColumnList = new ArrayList<>();
        //2.循环判断表里是否有这个表的信息，有的话就跳过，没有再进行保存
        if (null != dcTableList && dcTableList.size() > 0
               // && null != dcColumnList && dcColumnList.size() > 0
        ) {
            for (DcTable dcTable : dcTableList) {
                isKey = "";
                DcTable dcTable1 = dcTableDao.selectByPrimaryKey(dcTable.getId());
                if (null != dcTable1)  /*如果存在，直接跳到下一次循环*/ continue;
                //2.1 先保存表数据
                dcTableDao.insert(dcTable);
                //2.2 再取出这个表对应的字段信息，进行保存
                dcColumnList = dcTable.getDcColumnList();
                for (DcColumn dcColumn : dcColumnList) {
                    dcColumnDao.insert(dcColumn);
                }
                sb.delete(0, sb.length());
                //3 判断表是否需要创建数据库  0代表不需要创建表，1代表需要创建表
                if (!"1".equals(dcTable.getIsexist())) continue;
                //3.1继续判断数据库中是否存在这个表，如果没有则进行建表操作
                isExist = "select 1  from sysObjects where Id=OBJECT_ID(N'" + dcTable.getName() + "') and xtype='U'\n";
                existresult = handleDao.execSelectSql(isExist);
                if (StringUtil.isEmpty(existresult) || !existresult.equals("1")) {
                    sb.append("create TABLE ").append(dcTable.getName()).append("( ");
                    for (DcColumn dc : dcColumnList) {
                        dc=dc.toBuilder().build();
                        if (2 == dc.getType_id()) {  // 添加int类型的字段
                            if (dc.getColumn_name().equalsIgnoreCase("id")) {
                                isKey = dc.getColumn_name();
                                sb.append(dc.getColumn_name()).append("  int IDENTITY(1,1) NOT NULL, ");
                            } else {
                                sb.append(dc.getColumn_name()).append(" int null, ");
                            }

                        } else if (1 == dc.getType_id()) { // 添加String类型的字段
                            if (dc.getSize() >= 8000) {
                                sb.append(dc.getColumn_name()).append(" varchar(MAX)").append(" null, ");
                            } else {
                                if (dc.getColumn_name().equalsIgnoreCase("id")) {
                                    isKey = dc.getColumn_name();
                                    sb.append(dc.getColumn_name()).append("  varchar (" + dc.getSize() + ") default   newid() not null ,");
                                } else {
                                    sb.append(dc.getColumn_name()).append("  varchar (" + dc.getSize() + ")").append(" null, ");
                                }
                            }
                        } else if (3 == dc.getType_id()) { //日期
                            sb.append(dc.getColumn_name()).append(" date null, ");
                        } else if (4 == dc.getType_id()) {
                            sb.append(dc.getColumn_name()).append(" datetime null, ");
                        } else if (5 == dc.getType_id()) {
                            sb.append(dc.getColumn_name()).append(" decimal (" + dc.getSize() + ", " + dc.getScale() + ") null,");
                        }
                        // TODO  如果导出的字段类型为null  默认给字符串
                        else {
                            sb.append(dc.getColumn_name()).append(" varchar(MAX)").append(" null, ");
                        }
                    }
                    if ("".equals(isKey) || null == isKey) {
                        sb.append(")");
                    } else {
                        sb.append(" CONSTRAINT PK_").append(dcTable.getName()).append(" PRIMARY KEY CLUSTERED  ( " + isKey + " ASC ) )");
                    }
                    System.out.println("iskey" + isKey);
                    handleDao.createNewTable(sb.toString());
                }
            }
        }
        /*七、*********** 开始导入 调度信息 ************/

        List<DcScheduleConfig> dcScheduleConfigs = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcScheduleConfigs")), DcScheduleConfig.class);
        if (null != dcScheduleConfigs && dcScheduleConfigs.size() > 0) {
            DcScheduleConfig dsc = new DcScheduleConfig();
            for (DcScheduleConfig dcScheduleConfig : dcScheduleConfigs) {
                dsc.setProduct_id(dcScheduleConfig.getProduct_id());
                dsc.setJob_id(dcScheduleConfig.getJob_id());
                dsc.setIs_single(dcScheduleConfig.getIs_single());
                dcScheduleConfigDao.delete(dsc);
               /* DcScheduleConfig dcSchedule1 = dcScheduleConfigDao.selectByPrimaryKey(dcScheduleConfig.getId());
                if (null != dcSchedule1)  *//*如果存在，直接跳到下一次循环*//* continue;*/
                dcScheduleConfigDao.insert(dcScheduleConfig);
            }
        }
        /*八、*********** 开始 导入对照映射关系 ************/
        List<DcTableVsTable> dcTableVsTableList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcTableVsTableList")), DcTableVsTable.class);
        if (null != dcTableVsTableList && dcTableVsTableList.size() > 0) {
            for (DcTableVsTable dcTableVsTable : dcTableVsTableList) {
                DcTableVsTable dcTableVsTable1 = dcTableVsTableDao.selectByPrimaryKey(dcTableVsTable.getId());
                if (null != dcTableVsTable1)  /*如果存在，直接跳到下一次循环*/ continue;
                dcTableVsTableDao.insert(dcTableVsTable);
            }
        }
        /*九、*********** 开始 导入对照映射表关系 ************/
        List<DcVirtualTable> dcVirtualTableList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcVirtualTableList")), DcVirtualTable.class);
        if (null != dcVirtualTableList && dcVirtualTableList.size() > 0) {
            for (DcVirtualTable e : dcVirtualTableList) {
                DcVirtualTable dcVirtualTable = dcVirtualTableDao.selectByPrimaryKey(e.getId());
                if (null != dcVirtualTable) continue;
                dcVirtualTableDao.insert(e);
            }
        }
        /*十、*********** 开始 导入产品信息 ************/
        List<DcProduct> dcProducts = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcProductList")), DcProduct.class);
        if (null != dcProducts && dcProducts.size() > 0) {
            for (DcProduct p : dcProducts) {
                DcProduct dcProduct = dcProductDao.selectByPrimaryKey(p.getId());
                if (null != dcProduct) continue;
                dcProductDao.insert(p);
            }
        }
        //dcSingleConfigList
        /*十、*********** 开始导入 单抽信息 ************/

        List<DcSingleConfig> dcSingleConfigList = JSONObject.parseArray(JSONArray.toJSONString(map.get("dcSingleConfigList")), DcSingleConfig.class);
        if (null != dcSingleConfigList && dcSingleConfigList.size() > 0) {
            DcSingleConfig dsc=new DcSingleConfig();
            for (DcSingleConfig d : dcSingleConfigList) {
              /*DcSingleConfig dcSingleConfig = dcSingleConfigDao.selectByPrimaryKey(d.getId());
                if (null != dcSingleConfig)  *//*如果存在，直接跳到下一次循环*//* continue;*/
                dsc.setId(d.getId());
                dcSingleConfigDao.delete(dsc);
                dcSingleConfigDao.insert(d);
            }
        }

    }

    @Override
    public List<DcJob> selectByIds(String substring) {
        return dcJobDao.selectByIds(substring);
    }

    public PageInfo selectBySome(PageInfo pageInfo, String job_name, String rule_id, String stime, String etime) {
//        String columnsSql = " a.*,b.name as hospitalName ";
        String columnsSql = " a.id,a.name,a.hospital_id,b.name as hospitalName,a.creat_time,a.type,c.name as typename,a.rule_id,d.name as rule_name,a.rule_suffix ";
//        String fromAndWhereSql = " from dc_job a left join dc_hospital b on a.hospital_id=b.id  where 1=1  ";
        String fromAndWhereSql = "from dc_job a  left join dc_hospital b on a.hospital_id=b.id left join dc_sys_dict_val c on a.type=c.val and c.dict_id='138'  left join dc_schedule_rule d on a.rule_id=d.id  where  1=1  ";

        if (StringUtil.isNotEmpty(job_name)) {
            fromAndWhereSql += " and a.name like '%" + job_name + "%'";
        }
        if (StringUtil.isNotEmpty(rule_id)) {
            fromAndWhereSql += " and a.rule_id ='" + rule_id + "'";
        }
        if (StringUtil.isNotEmpty(stime) && StringUtil.isNotEmpty(etime)) {
            fromAndWhereSql += " and a.creat_time between '" + stime + "' and '" + etime + "'";
        }
        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.creat_time", pageInfo, true);
        //System.out.println(columnsSql);

        List<Map<String, Object>> maps = dcJobDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }

    public String updateByJob(DcJob dcJob) {
        DcJob dcJob_Old = dcJobDao.selectByPrimaryKey(dcJob.getId());
        List<DcTransfer> transfers = dcTransferDao.selectByJobId(dcJob.getId());
        if (CollUtil.isNotEmpty(transfers)) {
            if (!dcJob.getType().equals(dcJob_Old.getType())) {
                return "该工单下已有链接服务器，不允许修改工单类型";
            }
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        dcJob.setUpdate_time(format);
        dcJobDao.updateByPrimaryKeySelective(dcJob);

        //修改已经配置好的调度信息
        List<DcScheduleConfig> select = dcScheduleConfigDao.findAlreadyPz(dcJob.getId());
        if(CollUtil.isNotEmpty(select)){
            select.forEach(e -> {
                e.setRule_id(dcJob.getRule_id());
                e.setParam(dcJob.getParam());
                e.setParam_unit(dcJob.getParam_unit());
                e.setRule_suffix(dcJob.getRule_suffix());
                dcScheduleConfigDao.updateByPrimaryKeySelective(e);
            });
        }


        return "修改成功";
    }
}
