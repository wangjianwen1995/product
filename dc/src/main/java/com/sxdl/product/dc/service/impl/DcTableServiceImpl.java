package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.base.util.YmlUtil;
import com.sxdl.product.dc.controller.DcTableController;
import com.sxdl.product.dc.dao.dao1.DcColumnDao;
import com.sxdl.product.dc.dao.dao1.DcProductDao;
import com.sxdl.product.dc.dao.dao1.DcTableDao;
import com.sxdl.product.dc.dao.dao1.DcTransferDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.dbo.CreatTableDBO;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcProduct;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.entity.DcTransfer;
import com.sxdl.product.dc.service.DcTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dcTableService")
@Transactional
public class DcTableServiceImpl extends BaseUUIDServiceImpl<DcTable> implements DcTableService {

    @Autowired
    YmlUtil ymlUtil;
    @Autowired
    private DcTableDao tableDao;
    @Autowired
    private DcColumnDao columnDao;
    @Autowired
    private HandleDao handleDao;
    @Autowired
    private DcProductDao dcProductDao;
    @Autowired
    private DcTransferDao dcTransferDao;
    @Value("${spring.datasource.secondary.url}")
    private String url;

    @Autowired
    private DcTableController tableController;


    @Override
    public List<DcTable> findAll() {
        List<DcTable> dcTables = tableDao.selectAll();
        return dcTables;
    }

    @Override
    public List<DcTable> findAllByDcTable(DcTable dcTable) {
        return tableDao.select(dcTable);
    }

    @Override
    public void creatTC(CreatTableDBO dbo, DcTransfer tsf) {
        String dbname = "";       //数据库名
        String transfername = ""; //链接服务器名
        String fromType = "";     //数据库类型
        String productId = "";    //产品ID
        int isogeny = 0;          //是否同源 1是0否
        int isCreateInDc = 0;

        if (1 == dbo.getProduct_type()) {//源产品
            dbname = tsf.getDbname();
            transfername = tsf.getName();
            isogeny = tsf.getIsogeny();
            fromType = tsf.getFrom_type();
            productId = tsf.getResource_product_id();
        } else {
            dbname = tsf.getTo_dbname();
            transfername = tsf.getTo_name();
            isogeny = tsf.getTo_isogeny();
            fromType = tsf.getTo_type();
            productId = tsf.getProduct_id();
        }
        String etltype = tsf.getEtlp_type();
        if ("1".equals(etltype)) {
            isCreateInDc = 1;
        }
        String tcsql = "";
        String tableName = "";
        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(productId);
        String prefix = dcProduct.getPrefix();
        if (dbo.getName().contains(prefix)) {
            tableName = dbo.getName().substring(prefix.length(), dbo.getName().length());
        } else {
            tableName = dbo.getName();
        }

        //1 首先判断数据库类型，根据数据库类型的不同拼接不同的sql取字段及字段中文名

        String fromAfterSql = "";
        if (fromType.equals("SQLOLEDB")) {

            tcsql = "SELECT c.[name] AS filed,tp.[user_type_id] AS filedtype,c.[max_length] AS filelenth,c.precision as xprec,c.scale as xscale,c.column_id as ordernum,\n" +
                    "case when cast(ep.[value] as varchar(100)) is not null then cast(ep.[value] as varchar(100)) else c.[name] end AS name \n" +
                    "FROM " + transfername + "." + dbname + ".sys.tables AS t\n" +
                    "INNER JOIN " + transfername + "." + dbname + ".sys.columns\n" +
                    "AS c ON t.object_id = c.object_id\n" +
                    "LEFT JOIN " + transfername + "." + dbname + ".sys.extended_properties AS ep\n" +
                    "ON ep.major_id = c.object_id AND ep.minor_id = c.column_id \n" +
                    "LEFT JOIN " + transfername + "." + dbname + ".sys.types AS tp\n" +
                    "ON tp.user_type_id = c.user_type_id\n" +
                    "where t.name = '" + tableName + "';";
        } else if (fromType.equals("DB2OLEDB")) {
            //fromAfterSql = transfername+"."+dbname+".dbo."+tablename;
        } else {
            tcsql = "select * from openquery(" + transfername + ",'\n" +
                    "SELECT a.column_name as FILED,\n" +
                    "       nvl(b.comments,a.column_name) as NAME ,a.COLUMN_ID as ordernum \n" +
                    "  FROM user_tab_columns a, user_col_comments b\n" +
                    " WHERE a.TABLE_NAME = ''" + tableName + "''\n" +
                    "   and b.table_name = ''" + tableName + "''\n" +
                    "   and a.column_name = b.column_name\n" +
                    " order by  a.COLUMN_ID \n" +
                    "')";
        }
        List<Map<String, Object>> dbInfo = handleDao.findDbInfo(tcsql);


        String preTableName = prefix + tableName;
        //查询所选产品下有无该表，有则更新，无则插入
        List<DcTable> dcTableList = tableDao.selectByNameAndProdect(tableName, productId, "");
        //表不存在
        if (null == dcTableList || dcTableList.size() <= 0) {
            DcTable table = new DcTable();
            table.setName(tableName);
            table.setName_zh(dbo.getName_zh());
            if ("1".equals(etltype)) {
                table.setType_id(1);
            } else if ("2".equals(etltype)) {
                table.setType_id(2);
            } else if ("3".equals(etltype)) {
                table.setType_id(3);
            } else {
                table.setType_id(3);
            }

            table.setIs_public(1);
            table.setProduct_id(productId);
            table.setIsexist("0");
            tableDao.insertSelective(table);
            for (Map<String, Object> e : dbInfo) {
                String filed = "";
                String filedName = "";
                String filedType = "";
                String filedLen = "";
                String filedPrec = "";
                String filedScale = "";
                String ordernum = "";
                if (1 == isogeny) {
                    filed = ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString();
                    filedName = ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString();
                    filedType = ObjectUtil.isNotEmpty(e.get("TYPE")) ? e.get("TYPE").toString() : e.get("filedtype").toString();
                    filedLen = ObjectUtil.isNotEmpty(e.get("LENTH")) ? e.get("LENTH").toString() : e.get("filelenth").toString();
                    filedPrec = ObjectUtil.isNotEmpty(e.get("XPREC")) ? e.get("XPREC").toString() : e.get("xprec").toString();
                    filedScale = ObjectUtil.isNotEmpty(e.get("XSCALE")) ? e.get("XSCALE").toString() : e.get("xscale").toString();
                    ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();
                } else {
                    filed = ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString();
                    filedName = ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString();
                    ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();

                }


                DcColumn dcColumn = new DcColumn();
                dcColumn.setTable_id(table.getId());
                dcColumn.setTable_name(tableName);
                dcColumn.setColumn_name(filed);
                dcColumn.setColumn_name_zh(filedName);
                dcColumn.setOrdernum(Integer.parseInt(ordernum));
                if (1 == isogeny) {
                    switch (Integer.parseInt(filedType)) {
                        case 167:
                            dcColumn.setType_id(1);
                            dcColumn.setSize(Integer.parseInt(filedLen.equalsIgnoreCase("MAX") ? "8000" : filedLen));
                            dcColumn.setType("字符串");
                            break;
                        case 56:
                            dcColumn.setType_id(2);
                            dcColumn.setType("数字");
                            break;
                        case 40:
                            dcColumn.setType_id(3);
                            dcColumn.setType("日期");
                            break;
                        case 61:
                            dcColumn.setType_id(4);
                            dcColumn.setType("日期时间");
                            break;
                        case 108:
                            dcColumn.setType_id(5);
                            dcColumn.setSize(Integer.parseInt(filedPrec));
                            dcColumn.setScale(Integer.parseInt(filedScale));
                            dcColumn.setType("小数");
                            break;
                        case 60:
                            //money 类型
                            dcColumn.setType_id(5);
                            dcColumn.setSize(19);
                            dcColumn.setScale(4);
                            dcColumn.setType("小数");
                            break;
                        case 106:
                            dcColumn.setType_id(5);
                            dcColumn.setSize(Integer.parseInt(filedPrec));
                            dcColumn.setScale(Integer.parseInt(filedScale));
                            dcColumn.setType("小数");
                            break;
                        //TODO 讨论讨论
                        case 231:
                            dcColumn.setType_id(1);
                            dcColumn.setSize(Integer.parseInt(filedLen.equalsIgnoreCase("MAX") ? "8000" : filedLen) / 2);
                            dcColumn.setType("字符串");
                            break;
                        default:
                            dcColumn.setType_id(1);
                            dcColumn.setSize(255);
                            dcColumn.setType("字符串");
                    }
                } else {
                    dcColumn.setType_id(1);
                    dcColumn.setType("字符串");
                    dcColumn.setSize(5000);
                }
                columnDao.insertSelective(dcColumn);
            }


        } else {
            DcTable dcTable = dcTableList.get(0);

            //查询库中现有表的所有字段
            List<DcColumn> dcColumns = columnDao.selectByTableid(dcTable.getId());
            Map<String, String> mp = new HashMap();

            //循环现有字段
            for (DcColumn dc : dcColumns) {
                mp.put(dc.getColumn_name(), dc.getColumn_name_zh());
            }
            //更新或者新增字段信息
            if (dbInfo.size() > 0) {
                for (Map<String, Object> e : dbInfo) {
                    String filed = "";
                    String filedName = "";
                    String filedType = "";
                    String filedLen = "";
                    String filedPrec = "";
                    String filedScale = "";
                    String ordernum = "";
//                    if (fromType.equals("SQLOLEDB")) {
//                        ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();
//                    }
                    if (1 == isogeny) {
                        filed = ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString();
                        filedName = ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString();
                        filedType = ObjectUtil.isNotEmpty(e.get("TYPE")) ? e.get("TYPE").toString() : e.get("filedtype").toString();
                        filedLen = ObjectUtil.isNotEmpty(e.get("LENTH")) ? e.get("LENTH").toString() : e.get("filelenth").toString();
                        filedPrec = ObjectUtil.isNotEmpty(e.get("XPREC")) ? e.get("XPREC").toString() : e.get("xprec").toString();
                        filedScale = ObjectUtil.isNotEmpty(e.get("XSCALE")) ? e.get("XSCALE").toString() : e.get("xscale").toString();
                        ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();
                    } else {
                        filed = ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString();
                        filedName = ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString();
                        ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();

                    }
                    DcColumn dcColumn = new DcColumn();
                    dcColumn.setTable_id(dcTable.getId());
                    dcColumn.setTable_name(tableName);
                    dcColumn.setColumn_name(filed);
                    dcColumn.setColumn_name_zh(filedName);
                    dcColumn.setOrdernum(Integer.parseInt(ordernum));

                    if (1 == isogeny) {
                        switch (Integer.parseInt(filedType)) {
                            case 167:
                                dcColumn.setType_id(1);
                                dcColumn.setSize(Integer.parseInt(filedLen.equalsIgnoreCase("MAX") ? "8000" : filedLen));
                                dcColumn.setType("字符串");
                                break;
                            case 56:
                                dcColumn.setType_id(2);
                                dcColumn.setType("数字");
                                break;
                            case 40:
                                dcColumn.setType_id(3);
                                dcColumn.setType("日期");
                                break;
                            case 61:
                                dcColumn.setType_id(4);
                                dcColumn.setType("日期时间");
                                break;
                            case 108:
                                dcColumn.setType_id(5);
                                dcColumn.setSize(Integer.parseInt(filedPrec));
                                dcColumn.setScale(Integer.parseInt(filedScale));
                                dcColumn.setType("小数");
                                break;
                            case 60:
                                //money 类型
                                dcColumn.setType_id(5);
                                dcColumn.setSize(19);
                                dcColumn.setScale(4);
                                dcColumn.setType("小数");
                                break;
                            case 106:
                                dcColumn.setType_id(5);
                                dcColumn.setSize(Integer.parseInt(filedPrec));
                                dcColumn.setScale(Integer.parseInt(filedScale));
                                dcColumn.setType("小数");
                                break;
                            //TODO 讨论讨论
                            case 231:
                                dcColumn.setType_id(1);
                                dcColumn.setSize(Integer.parseInt(filedLen.equalsIgnoreCase("MAX") ? "8000" : filedLen) / 2);
                                dcColumn.setType("字符串");
                                break;
                            default:
                                dcColumn.setType_id(1);
                                dcColumn.setSize(255);
                                dcColumn.setType("字符串");
                        }
                    } else {
                        dcColumn.setType_id(1);
                        dcColumn.setType("字符串");
                        dcColumn.setSize(5000);
                    }


                    if (mp.keySet().contains(filed)) {
                        DcColumn  cl = columnDao.selectByTableidAndName(dcColumns.get(1).getTable_id(), filed);
                        dcColumn.setId(cl.getId());
                        columnDao.updateByPrimaryKey(dcColumn);

                    } else { //没有字段则进行插入操作
                        columnDao.insertSelective(dcColumn);
                    }
                }
            }
        }

        //如果参数为1，则代表需要在dc里创建
//        if(null!=dbo.getIscreateatdc() && 1==dbo.getIscreateatdc()){
        if (1 == isCreateInDc) {
            //再查询dc下有无该表，如果勾选了生成dc源表，则除了需要创建表结构外，还需要再dc里生成实体表
            List<DcTable> dcTableList2 = tableDao.selectByNameAndProdect(preTableName, "C9BA5D39-4CD0-4D6B-B03A-12766FC87D57", "");

            if (null == dcTableList2 || dcTableList2.size() <= 0) {
                DcTable table = new DcTable();
                table.setName(preTableName);
                table.setName_zh(prefix + dbo.getName_zh());
                table.setType_id(1);
                table.setIs_public(1);
                table.setProduct_id("C9BA5D39-4CD0-4D6B-B03A-12766FC87D57");
                table.setIsexist("0");
                tableDao.insertSelective(table);
                for (Map<String, Object> e : dbInfo) {
                    DcColumn dcColumn = new DcColumn();
                    dcColumn.setTable_id(table.getId());
                    dcColumn.setTable_name(preTableName);
                    dcColumn.setType_id(1);
                    dcColumn.setType("字符串");
                    dcColumn.setColumn_name(ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString());
                    dcColumn.setColumn_name_zh(ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString());
                    if (fromType.equals("SQLOLEDB")) {
                        dcColumn.setOrdernum(Integer.parseInt(ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString()));
                    }
                    dcColumn.setSize(5000);
                    columnDao.insertSelective(dcColumn);
                }
                //表结构存储完成之后，更新数据库
                tableController.renewDatabase(table.getId());
            } else {
                DcTable dcTable = dcTableList2.get(0);

                List<DcColumn> dcColumns = columnDao.selectByTableid(dcTable.getId());
                Map<String, String> mp = new HashMap();

                //循环现有字段
                for (DcColumn dc : dcColumns) {
                    mp.put(dc.getColumn_name(), dc.getColumn_name_zh());
                }
                //更新或者新增字段信息
                if (dbInfo.size() > 0) {
                    for (Map<String, Object> e : dbInfo) {
                        String filed = "";
                        String filedName = "";
                        String filedType = "";
                        String filedLen = "";
                        String filedPrec = "";
                        String filedScale = "";
                        String ordernum = "";


                        if (1 == isogeny) {
                            filed = ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString();
                            filedName = ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString();
                            filedType = ObjectUtil.isNotEmpty(e.get("TYPE")) ? e.get("TYPE").toString() : e.get("filedtype").toString();
                            filedLen = ObjectUtil.isNotEmpty(e.get("LENTH")) ? e.get("LENTH").toString() : e.get("filelenth").toString();
                            filedPrec = ObjectUtil.isNotEmpty(e.get("XPREC")) ? e.get("XPREC").toString() : e.get("xprec").toString();
                            filedScale = ObjectUtil.isNotEmpty(e.get("XSCALE")) ? e.get("XSCALE").toString() : e.get("xscale").toString();
                            ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();

                        } else {
                            filed = ObjectUtil.isNotEmpty(e.get("FILED")) ? e.get("FILED").toString() : e.get("filed").toString();
                            filedName = ObjectUtil.isNotEmpty(e.get("NAME")) ? e.get("NAME").toString() : e.get("name").toString();
                            ordernum = ObjectUtil.isNotEmpty(e.get("ORDERNUM")) ? e.get("ORDERNUM").toString() : e.get("ordernum").toString();
                        }
                        DcColumn dcColumn = new DcColumn();
                        dcColumn.setTable_id(dcTable.getId());
                        dcColumn.setTable_name(tableName);
                        dcColumn.setColumn_name(filed);
                        dcColumn.setColumn_name_zh(filedName);
                        dcColumn.setType_id(1);
                        dcColumn.setType("字符串");
                        dcColumn.setSize(5000);
                        dcColumn.setOrdernum(Integer.parseInt(ordernum));


                        if (mp.keySet().contains(filed)) {
                            DcColumn  cl = columnDao.selectByTableidAndName(dcColumns.get(1).getTable_id(), filed);
                            dcColumn.setId(cl.getId());
                            columnDao.updateByPrimaryKey(dcColumn);
                        } else { //没有字段则进行插入操作
                            columnDao.insertSelective(dcColumn);
                        }
                    }
                }
                dcTable.setName(preTableName);
                dcTable.setName_zh(prefix + dbo.getName_zh());
                tableDao.updateByPrimaryKey(dcTable);
                //表结构存储完成之后，更新数据库
                tableController.renewDatabase(dcTable.getId());
            }
        }
    }

    public DcTable selectByName(String name) {
        return tableDao.selectByName(name);
    }

    @Override
    public void deleteWB(List<DcTable> dcTableList) {
        for (DcTable dcTable : dcTableList) {
            List<DcColumn> dcColumns = columnDao.selectByTableid(dcTable.getId());
            for (DcColumn dcColumn : dcColumns) {
                columnDao.delete(dcColumn);
            }
            tableDao.delete(dcTable);
        }
    }

    @Override
    public List<DcTable> selectByNameAndProdect(String name, String pid1, String pid2) {
        return tableDao.selectByNameAndProdect(name, pid1, pid2);
    }

    @Override
    public void updateWB(DcTable DcTable, List<DcColumn> dcColumnList) {
        List<DcTable> dcTableList = tableDao.selectByName2(DcTable.getName());
        //根据tableid 查找cloum表已经存在的字段
        for (DcTable dcTable : dcTableList) {
            List<DcColumn> dcColumns = columnDao.selectByTableid(dcTable.getId());
            if (dcColumns != null && dcColumns.size() > 0) {
                for (DcColumn dcColumn : dcColumns) {
                    columnDao.deleteByPrimaryKey(dcColumn);
                }
            }
            for (DcColumn dcColumn : dcColumnList) {
                dcColumn.setTable_id(dcTable.getId());
                columnDao.insertSelective(dcColumn);
            }

        }
    }

    @Override
    public void insertWB(DcTable dcTable, List<String> pid) {
        for (String protectId : pid) {
            if (protectId.equals(12)) {
                dcTable.setType_id(8);
                dcTable.setIs_public(2);
            }
            dcTable.setProduct_id(protectId);
            tableDao.insertSelective(dcTable);
            List<DcColumn> dcColumnList = dcTable.getDcColumnList();
            for (DcColumn dcColumn : dcColumnList) {
                dcColumn.setTable_id(dcTable.getId());
                columnDao.insertSelective(dcColumn);
            }
        }

    }

    @Override
    public List<DcTable> selectByName2(String name) {
        return tableDao.selectByName2(name);
    }

    public String saveByDB(DcTable dcTable) {
        DcTable dcTable1 = new DcTable();
        dcTable1.setProduct_id(dcTable.getProduct_id());
        dcTable1.setName(dcTable.getName());
        List<DcTable> dcTables = tableDao.select(dcTable1);
        if (null == dcTables || dcTables.size() <= 0) {
            tableDao.insert(dcTable);
        } else {
            return dcTable.getName_zh() + "表已在" + dcTable.getProductName() + "产品中存在，请勿重复添加";
        }
        String s = updateColumn(dcTable.getId(), "", url.split("=")[1], dcTable.getName());
        if(!"更新成功".equals(s)){
            tableDao.delete(dcTable);
        }
        return s;
    }


    DcColumn dcColumn;
    String columnName;
    String columnNamezh;

    public String updateColumn(String tableid, String dbLinkName, String dbName, String tableName) {
        String getColumnSql;
        if (StrUtil.isEmpty(dbLinkName) && StrUtil.isEmpty(dbName)) {
            getColumnSql = "select c.name ,xtype,length,xprec,xscale,isnull(cast(ep.[value] as varchar(100)),c.name) AS namezh" +
                    " from dbo.syscolumns c " +
                    "LEFT JOIN sys.extended_properties AS ep on ep.major_id = c.id AND ep.minor_id = c.colid " +
                    "where  id in(select id from  sysobjects where xtype='u' and name='" + tableName + "')";
        } else {
            getColumnSql = "select c.name ,xtype,length,xprec,xscale,isnull(cast(ep.[value] as varchar(100)),c.name) AS namezh" +
                    " from " + dbLinkName + "." + dbName + ".dbo.syscolumns c " +
                    " LEFT JOIN " + dbLinkName + "." + dbName + ".sys.extended_properties AS ep on ep.major_id = c.id AND ep.minor_id = c.colid " +
                    " where  id in(select id from  " + dbLinkName + "." + dbName + ".dbo.sysobjects where xtype='u' and name='" + tableName + "')";
        }
        //事实表中字段
        List<Map<String, Object>> list = handleDao.selectSqlWithSQL(getColumnSql);
        if(CollUtil.isEmpty(list)) return "未找到字段信息，请确保数据表存在！";
        //dc_base中表结构
        List<String> columns = columnDao.selectColumByTableid(tableid);
        for (Map<String, Object> e : list) {
            dcColumn = new DcColumn();
            String length = e.get("length").toString();
            dcColumn.setColumn_name(e.get("name").toString().trim());
            dcColumn.setColumn_name_zh(e.get("namezh").toString().trim());

            switch (Integer.parseInt(e.get("xtype").toString())) {
                case 167:
                    dcColumn.setType_id(1);
                    dcColumn.setSize(Integer.parseInt(length.equalsIgnoreCase("MAX") ? "8000" : length));
                    dcColumn.setType("字符串");
                    break;
                case 56:
                    dcColumn.setType_id(2);
                    dcColumn.setType("数字");
                    break;
                case 40:
                    dcColumn.setType_id(3);
                    dcColumn.setType("日期");
                    break;
                case 61:
                    dcColumn.setType_id(4);
                    dcColumn.setType("日期时间");
                    break;
                case 108:
                    dcColumn.setType_id(5);
                    dcColumn.setSize(Integer.parseInt(e.get("xprec").toString()));
                    dcColumn.setScale(Integer.parseInt(e.get("xscale").toString()));
                    dcColumn.setType("小数");
                    break;
                case 60:
                    //money 类型
                    dcColumn.setType_id(5);
                    dcColumn.setSize(19);
                    dcColumn.setScale(4);
                    dcColumn.setType("小数");
                    break;
                case 106:
                    dcColumn.setType_id(5);
                    dcColumn.setSize(Integer.parseInt(e.get("xprec").toString()));
                    dcColumn.setScale(Integer.parseInt(e.get("xscale").toString()));
                    dcColumn.setType("小数");
                    break;
                //TODO 讨论讨论
                case 231:
                    dcColumn.setType_id(1);
                    dcColumn.setSize(Integer.parseInt(length.equalsIgnoreCase("MAX") ? "8000" : length));
                    dcColumn.setType("字符串");
                    break;
                default:
                    dcColumn.setType_id(1);
                    dcColumn.setSize(255);
                    dcColumn.setType("字符串");
            }
            dcColumn.setTable_id(tableid);
            dcColumn.setTable_name(tableName);
            //新增的字段
            columnName = e.get("name").toString().trim();
            columnNamezh = e.get("namezh").toString().trim();
            if (!columns.contains(columnName)) {
                columnDao.insert(dcColumn);
                //已有字段修改
            } else {

                DcColumn cl = columnDao.selectByTableidAndName(tableid, columnName);
                if (null != cl) {
                    dcColumn.setId(cl.getId());
                    columnDao.updateByPrimaryKey(dcColumn);
                }
            }
        }
        return "更新成功";
    }

    /**
     * 同步数据库中的实际表的表结构到dl_dc_base的table&column表中
     *
     * @param dcTable
     * @return
     */
    public String insertOrUpdate(DcTable dcTable) {
        DcProduct dcProduct = dcProductDao.selectByPrimaryKey(dcTable.getProduct_id());
        if (null == dcProduct) {
            return "当前查询的表没有配置对应的产品,请重新配置!";
        }
        String dbLinkName = "";
        String dbName = dcProduct.getDatabase_name();
        if (StrUtil.isEmpty(dbName)) {
            return dcProduct.getName_zh() + ",当前查询的产品没有配置默认数据库,请重新配置!";
        }
        String url = ymlUtil.getYmlValue("spring.datasource.secondary.url");
        if (StrUtil.isEmpty(url) || !url.contains("=") || !url.contains("jdbc:")) {
            return "没有正确配置yml,请重新配置spring.datasource.secondary.url!";
        }
        String ymlDBname = url.split("=")[1];
        String name = dcTable.getName();
        //如果是加了前缀的表名称，需要先去掉前缀再去数据库中查询最新表结构
        if (name.contains(dcProduct.getPrefix())) {
            name = name.substring(dcProduct.getPrefix().length(), name.length());
        }
        //当前dl_dc数据库
        if (dbName.equals(ymlDBname)) {
            return updateColumn(dcTable.getId(), null, null, name);
        }
        DcTransfer dcTransfer = new DcTransfer();
        dcTransfer.setProduct_id(dcProduct.getId());
        List<DcTransfer> transferList = dcTransferDao.select(dcTransfer);
        if (null != transferList && transferList.size() > 0) {
            DcTransfer transfer = transferList.get(0);
            dbLinkName = transfer.getName();
            dbName = transfer.getDbname();
        }

        String sql = "select top 1 * from sys.databases where name='" + dbName + "'";
        List<Map<String, Object>> mapList = handleDao.selectSqlWithSQL(sql);
        if (null == mapList || mapList.size() <= 0) {
            return "数据库不存在，或者该数据库与dc数据库不在同一服务器上,跨服务器同步表字段请到工单下链接服务器处更新同步";
        }
        String result = updateColumn(dcTable.getId(), dbLinkName, dbName, name);
        return result;
    }


    public PageInfo selectBySome(PageInfo pageInfo, String name, String name_zh, String product_id, Integer type_id) {
        String columnsSql = " a.*,b.name_zh as productName ";
        String fromAndWhereSql = " from dc_table a left join dc_product b on a.product_id=b.id  where 1=1  ";

        if (StringUtil.isNotEmpty(product_id)) {
            fromAndWhereSql += " and a.product_id='" + product_id + "'";
        }
        if (StringUtil.isNotEmpty(name)) {
            fromAndWhereSql += " and a.name like '%" + name + "%'";
        }
        if (StringUtil.isNotEmpty(name_zh)) {
            fromAndWhereSql += " and a.name_zh like '%" + name_zh + "%'";
        }
        if (type_id > 0) {
            fromAndWhereSql += " and a.type_id=" + type_id;
        }
        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.type_id", pageInfo, false);
        //System.out.println(columnsSql);

        List<Map<String, Object>> maps = tableDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }

    public PageInfo selectBySome(PageInfo pageInfo, String product_id, String type_id) {
        String columnsSql = " * ";
        String fromAndWhereSql = " from dc_table  where 1=1  ";

        if (StringUtil.isNotEmpty(product_id)) {
            fromAndWhereSql += " and product_id='" + product_id + "'";
        }
        if (StringUtil.isNotEmpty(type_id)) {
            fromAndWhereSql += " and type_id in (" + type_id + ")";
        }
        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "name", pageInfo, false);
        //System.out.println(columnsSql);

        List<Map<String, Object>> maps = tableDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }


    public void deleteByTableId(DcTable dcTable) {
        String productName = dcTable.getProductName();
        if ("山西雕龙大数据采集平台".equals(productName)) {
            String sql = " if exists(select * from tempdb..sysobjects where id=object_id('tempdb.." + dcTable.getName() + "'))\n" +
                    "BEGIN DROP TABLE " + dcTable.getName() + " end";
            System.out.println(sql);
            handleDao.execSelectSql(sql);
        }
        tableDao.delete(dcTable);
    }
}
