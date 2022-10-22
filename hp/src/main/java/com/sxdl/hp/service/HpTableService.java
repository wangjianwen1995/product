package com.sxdl.hp.service;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpTableDao;
import com.sxdl.hp.entity.HpBmVersion;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpHospiatlInfo;
import com.sxdl.hp.entity.HpTable;
import com.sxdl.hp.util.HpApplicationRunnerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class HpTableService extends BaseServiceImpl<HpTable> {
    private final String dydh = "',";
    private final String dh = ",";
    private final String dy = "'";
    private final String ykh = ")\n";
    @Autowired
    HpColumnService hpColumnService;
    private HpTable hpTable;
    private List<HpTable> list;
    @Autowired
    private HpTableDao tableDao;
    @Autowired
    private HpBmVersionService hpBmVersionService;
    private String tableName;
    private StringBuilder crsql, upsql, zsql;
    private HpBmVersion bmVersion;
    private List<HpBmVersion> bmVersions;
    private Map<String, String> bmVersionmap;
    private HpColumn hpColumn;
    private Map<String, Object> map;

    public List<String> getUseTableName(Integer userid)  {
        return tableDao.getUseTableName(userid);
    }

    public List<String> getUseTableName2(Integer userid)  {
        return tableDao.getUseTableName2(userid);
    }

    public Integer judgeEable(String sheng_code)  {
        return tableDao.judgeEable(sheng_code);
    }

    public Integer upEableType(String id, Integer type)  {
        return tableDao.upEableType(id, type);
    }

    public List<Map<String, String>> findtablename()  {
        return tableDao.findtablename();
    }

    /**
     * 查询医院所在省可用的附页信息
     *
     * @param hi 医院信息
     * @return
     */
    public ResultUtil selectEnables(HpHospiatlInfo hi)  {
        hpTable = new HpTable();
        hpTable.setSheng_code(hi.getSheng_code());
        hpTable.setIs_diaolong(0);
        hpTable.setIspage(1);
        hpTable.setIs_enable(1);
        list = tableDao.select(hpTable);
        if (list.size() <= 0) {
            return ResultUtil.error("附页信息表中没有对应省会附页配置项");
        } else {
            int size = list.stream().collect(Collectors.groupingBy(HpTable::getIs_equally))//按是否统一分组
                    .keySet().size();//分组是否重复
            if (size > 1) {
                return ResultUtil.error("数据异常,请联系管理员,查看Hptable表数据!");
            }
            int equal = list.get(0).getIs_equally();
            hi.setIsEqual(equal);//缓存数据
            List<HpColumn> columns;
            switch (equal) {
                case 1://中西医省附页统一
                    tableName = list.get(0).getName();
                    hi.setChinese_medicine(tableName);
                    hi.setWestern_medicine(tableName);
                    columns = ifExistAndCreate(tableName);
                    hi.setColumnsCM(columns);
                    hi.setColumnsWM(columns);
                    break;
                case 2://中西医不统一
                    for (HpTable e : list) {
                        tableName = e.getName();
                        columns = ifExistAndCreate(tableName);
                        if (e.getHomepage_type().equals(hi.getHomepage_type())) {
                            if (1 == hi.getHomepage_type()) { //中医
                                hi.setChinese_medicine(tableName);
                                hi.setColumnsCM(columns);
                            } else if (2 == hi.getHomepage_type()) { //西医
                                hi.setWestern_medicine(tableName);
                                hi.setColumnsWM(columns);
                            }
                        }
                    }
                    break;
            }
            bmVersion = new HpBmVersion();
            bmVersion.setIson("1");
            bmVersion.setHid(hi.getId());
            bmVersions = hpBmVersionService.select(bmVersion);

            if (null != bmVersions && !bmVersions.isEmpty()) {
                bmVersionmap = bmVersions.stream().collect(Collectors.toMap(HpBmVersion::getType, HpBmVersion::getVersion));
                hi.setBmVersion(bmVersionmap);
            }
            return ResultUtil.success(hi);
        }
    }

    /**
     * 根据表名判断表关系数据和实际表之间的对应
     * 如果存在实际表,则根据表关系中的数据,更新数据库实际表
     * 如果不存在实际表,则初始化实际表
     *
     * @param tableName return List<HpColumn>  关系表中该表的字段列表数据
     */
    public List<HpColumn> ifExistAndCreate(String tableName)  {
        zsql = new StringBuilder("if exists (select * from sysobjects where id = object_id(N'" + tableName + "') and OBJECTPROPERTY(id, N'IsUserTable') = 1) begin  ");
        crsql = new StringBuilder();
        upsql = new StringBuilder();
        hpColumn = new HpColumn();
        hpColumn.setTable_name(tableName);
        List<HpColumn> columns = hpColumnService.select(hpColumn);
//        columns=hpColumnService.findColumnByTableName(tableName);
        crsql.append("create table " + tableName + "  ( \n[ID] [varchar](50) NOT NULL default (newid()), \n[A_ID] [varchar](50) NULL, \n");
        for (HpColumn hpColumn : columns) {
            switch (hpColumn.getColumn_type()) {
                case 4:
                    crsql.append(" [" + hpColumn.getName() + "] [int] NULL, ");
                    break;
                case 12:
                    crsql.append("[" + hpColumn.getName() + "] [varchar](" + hpColumn.getSize() + ") NULL,");
                    break;
                case 11:
                    crsql.append("[" + hpColumn.getName() + "] [datetime] NULL,");
                    break;
                case 3:
                    crsql.append("[" + hpColumn.getName() + "] [decimal](" + hpColumn.getSize() + "," + hpColumn.getScale() + ") NULL,");
                    break;
                case -9:
                    crsql.append("[" + hpColumn.getName() + "] [date] NULL,");
                    break;
            }
            upsql.append("if not  exists(select * from syscolumns where id=object_id('" + tableName + "') and name='" + hpColumn.getName() + "') \n" +
                    "begin\nalter table " + tableName + " add " + hpColumn.getName() + " varchar(30) \nend \n");

        }
        crsql = new StringBuilder(crsql.substring(0, crsql.length() - 1));
        crsql.append(" CONSTRAINT [PK_" + tableName + Math.random() * 10000 + "] PRIMARY KEY CLUSTERED \n(  [ID] ASC  )WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY] ) ON [PRIMARY] \n");
        zsql.append(upsql);
        zsql.append("end \nelse begin ");
        zsql.append(crsql);
        zsql.append("end");
        hpColumnService.excuteSqlWithSQL(zsql.toString());
        return columns;
    }

//    public Map<String, Object> objectToMap(Object obj)  {
//        map = new HashMap();
//        for (Field f : obj.getClass().getDeclaredFields()) {
//            f.setAccessible(true);
//            if (!f.isAnnotationPresent(Transient.class) && !f.isAnnotationPresent(Id.class)) {
//                map.put(f.getName(), f.get(obj));
//            }
//        }
//        return map;
//    }

    /**
     * 获取省附页表名
     */
    public String getSfyTableName()  {
        if (StrUtil.isEmpty(tableName)) {
            HpHospiatlInfo hi = (HpHospiatlInfo) HpApplicationRunnerImpl.contextMap.get("hpHospiatlInfo");
            tableName = hi.getChinese_medicine();
            if (2 == hi.getHomepage_type()) {
                tableName = hi.getWestern_medicine();
            }
        }
        return tableName;
    }

    /**
     * 更新或插入省附页表
     *
     * @param hi   初始化后的医院信息
     * @param sfy  省附页数据
     * @param aid  A表id
     * @param cysj 出院时间
     * @
     */
    public Map<String, Object> mergeSFY(HpHospiatlInfo hi, Map<String, Object> sfy, String aid, Date cysj)  {
        tableName = getSfyTableName();
        List<HpColumn> colunms = new ArrayList<>();
        switch (hi.getIsEqual()) {
            case 1:
                colunms = hi.getColumnsCM();
                break;
            case 2:
                switch (hi.getHomepage_type()) {
                    case 1://中医
                        colunms = hi.getColumnsCM();
                        break;
                    case 2://西医
                        colunms = hi.getColumnsWM();
                        break;
                }
                break;
        }
        StringBuilder zsql = new StringBuilder("if (select count(*)  from ");
        zsql.append(tableName).append(" where A_ID='").append(aid).append("')>0\nbegin\nupdate ")
                .append(tableName).append(" set ");
        StringBuilder valsql = new StringBuilder("VALUES \n('" + aid + dydh);
        StringBuilder crsql = new StringBuilder("insert into ").append(tableName).append(" (A_ID,");
        StringBuilder upsql = new StringBuilder();
        sfy.remove("CYSJ");
        String name, val;
        int ctype = 0;//字段类型
        for (HpColumn c : colunms) {
            name = c.getName();
            if ("ID".equals(name)) {
                continue;
            }
            if ("CYSJ".equals(name)) {
                crsql.append(name).append(dh);
                val = "'" + DateUtil.formatFromDate(cysj) + "',";
            } else if (!sfy.containsKey(name)) {
                continue;
            } else if (null == sfy.get(name)) {
                continue;
            } else {
                val = sfy.get(name).toString();
                ctype = c.getColumn_type();
                crsql.append(name).append(dh);
                //先判断字段类型转换
                if (4 == ctype || 3 == ctype) {//4 int,3	decimal
                    val = StringUtil.isNotEmpty(val) ? val + "," : "0,";
                } else if (12 == ctype || 11 == ctype || -9 == ctype) {//varchar
                    val = StringUtil.isNotEmpty(val) ? dy + val + dydh : "null,";
                }
            }
            valsql.append(val);
            upsql.append(name).append("=").append(val);
        }
        crsql = new StringBuilder(crsql.substring(0, crsql.length() - 1));
        crsql.append(ykh);
        valsql = new StringBuilder(valsql.substring(0, valsql.length() - 1));
        valsql.append(ykh);
        upsql = new StringBuilder(upsql.substring(0, upsql.length() - 1));
        zsql.append(upsql).append(" where A_ID='").append(aid).append("'\nend\nelse\nbegin\n ")
                .append(crsql).append(valsql).append("end");
        tableDao.updateSqlWithSQL(zsql.toString());
        String sql = "select * from  " + tableName + " where A_ID='" + aid + "'";
        List<Map<String, Object>> mapList = tableDao.selectSqlWithSQL(sql);
        return null != mapList && mapList.size() > 0 ? mapList.get(0) : null;
    }
}
