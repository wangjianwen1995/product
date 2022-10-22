package com.sxdl.hp.service;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.dao.dao1.HpColumnDao;
import com.sxdl.hp.entity.HpColumn;
import com.sxdl.hp.entity.HpTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@Transactional
public class HpColumnService extends BaseServiceImpl<HpColumn> {

    @Autowired
    private HpColumnDao hpColumnDao;

    public List<HpColumn> findDLPageByTableId()  {

        return hpColumnDao.findDLPageByTableId();
    }

    public List<LinkedHashMap<String, String>> findDLPageShow()  {
        List<LinkedHashMap<String, String>> dlPageShow = hpColumnDao.findDLPageShow();
        dlPageShow.forEach(e -> {
            if ("0".equals(e.get("is_show"))) {
                e.put("is_show", "");
            }
        });
        return dlPageShow;
    }

    public List<LinkedHashMap<String, String>> findBytableName(String tableName)  {
        List<LinkedHashMap<String, String>> dlPageShow = hpColumnDao.findBytableName(tableName);
        dlPageShow.forEach(e -> {
            if ("0".equals(e.get("is_show"))) {
                e.put("is_show", "");
            }
        });
        return dlPageShow;
    }

    public List<HpColumn> findColumnByTableName(String tableName)  {
        return hpColumnDao.findColumnByTableName(tableName);
    }


    public Integer updateIsShow(HpTable hpTable)  {
        List<HpColumn> hpColumns = hpTable.getHpColumns();
        for (HpColumn hpColumn : hpColumns) {
            int i = hpColumnDao.updateByPrimaryKey(hpColumn);
        }
        return 1;

    }

    public List<HpColumn> findColumnSettings(String name, String tableName)  {
        return hpColumnDao.findColumnSettingsAndTableName(name, tableName);
    }


    public List<HpColumn> findColumnSettings(String name)  {
        return hpColumnDao.findColumnSettings(name);
    }

    public void excuteSqlWithSQL(String sql)  {
        hpColumnDao.excuteSqlWithSQL(sql);
    }

    ;

    public List<HpColumn> findMappingColumn(String name)  {
        return hpColumnDao.findMappingColumn(name);
    }

    public List<HpColumn> findReportTempColumn(String name)  {
        return hpColumnDao.findReportTempColumn(name);
    }

    public Integer updateMappingEnable(String id, Integer is_hisenable)  {
        return hpColumnDao.updateMappingEnable(id, is_hisenable);
    }


    public List<HpColumn> findColumnsByHeader(String name, String tablename)  {
        return hpColumnDao.findColumnsByHeader(name, tablename);
    }

    public void updateAllProperties(HpColumn hpColumn)  {
        if (StringUtils.isEmpty(hpColumn.getId())) {
            int insert = hpColumnDao.insertSelective(hpColumn);
        } else {
            int i = hpColumnDao.updateByPrimaryKey(hpColumn);
        }
    }

    public void delColumnById(String id)  {
        int i = hpColumnDao.deleteByPrimaryKey(id);
    }

    /**
     * 高级查询中,字段设置中,查询右侧备选字段库列表
     *
     * @param name   省附页表名
     * @param userId 用户id
     */
    public List<HpColumn> findRightData(String name, Integer userId)  {
        String sql = "select * from hp_column where isnull(is_gjcx,'0')='1' " +
                "and id not in (select column_id from hp_query_template where user_id =" + userId + " ) " +
                "and isnull(is_show,0)=1 and table_name in ('homepage','vsch0c','vsch0e','vsch0h','dl_fllow'";
        if (StrUtil.isNotEmpty(name)) {
            sql += ",'" + name + "'";
        }
        sql += ")";
        return selectListWithSQL(sql, HpColumn.class);
    }

    /**
     * 高级查询中,字段设置中,查询右侧备选字段库列表
     *
     * @param userId 用户id
     */
    public List<HpColumn> findLeftData(Integer userId)  {
        String sql = "select a.*,b.xh from  hp_column a \n" +
                "left join hp_query_template b on a.id=b.column_id \n" +
                "where isnull(a.is_gjcx,'0')='1' and isnull(a.is_show,0)=1 and b.user_id =" + userId;
        return selectListWithSQL(sql, HpColumn.class);
    }
}
