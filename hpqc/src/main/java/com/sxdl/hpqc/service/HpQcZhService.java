package com.sxdl.hpqc.service;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hpqc.dao.dao1.HpQcPfDao;
import com.sxdl.hpqc.dao.dao1.HpQcWzlDao;
import com.sxdl.hpqc.dao.dao1.HpQcZhDao;
import com.sxdl.hpqc.entity.HpQcZhEntity;
import com.sxdl.hpqc.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpQcZhService extends BaseUUIDServiceImpl<HpQcZhEntity> {

    @Autowired
    HpQcZhDao hpQcZhDao;
    @Autowired
    HpQcWzlDao hpQcWzlDao;
    @Autowired
    HpQcPfDao hpQcPfDao;

//    @Autowired
//    HpHospiatlInfoDao hospiatlInfoDao;
//
//    @Autowired
//    HpBmVersionDao hpBmVersionDao;


    public List<Map<String, Object>> selectByLeverOrName(String tablename, String lever, String name, Integer is_link) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from " + tablename);
        sb.append(" where 1=1 ");
        if (tablename.equals("hp_qm_zh") && StringUtil.isNotEmpty(lever)) {
            sb.append(" and lever=" + lever);
        }
        switch (is_link) {
            case 0:
                // 环节启用
                sb.append(" and link_on=1 ");
                break;
            case 1:
                //终末启用
                sb.append(" and is_on=1 ");
                break;
            case 2:
                //环节未启用
                sb.append(" and link_on=0 ");
                break;
            case 3:
                // 终末未启用
                sb.append(" and is_on=0 ");
                break;
        }
/*
        if (2 == is_link) {
            sb.append(" and is_on=1 ");
        } else {
            sb.append(" and link_on=1 ");
        }*/

        if (StringUtil.isNotEmpty(name)) {
            if (org.jsoup.internal.StringUtil.isNumeric(name)) {
                if (tablename.equals("hp_qm_wzl")) {
                    sb.append(" and  orderum='" + name + "'  order by message");
                }else{
                    sb.append(" and  ordernum='" + name + "'  order by message");
                }
            }else {
                sb.append(" and (sqls like '%" + name + "%' or message like '%" + name + "%') order by message");

            }
        }
        List<Map<String, Object>> mapList = hpQcZhDao.selectSqlWithSQL(sb.toString());
        return mapList;
    }


    public List<Map<String, Object>> selectByLeverOrName(String tablename, String lever, Integer is_link) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from " + tablename);
        sb.append(" where 1=1 ");
        if (tablename.equals("hp_qm_zh") && StringUtil.isNotEmpty(lever)) {
            sb.append(" and lever<=" + lever);
        }
        switch (is_link) {
            case 0:
                // 环节启用
                sb.append(" and link_on=1 ");
                break;
            case 1:
                //终末启用
                sb.append(" and is_on=1 ");
                break;
            case 2:
                //环节未启用
                sb.append(" and link_on=0 ");
                break;
            case 3:
                // 终末未启用
                sb.append(" and is_on=0 ");
                break;
        }
        List<Map<String, Object>> mapList = hpQcZhDao.selectSqlWithSQL(sb.toString());
        return mapList;
    }

    public Integer findSysMaxOrdernum(String column, String tablename) {
        return hpQcZhDao.findSysMaxOrdernum(column, tablename);
    }


    public PageInfo selectByType(PageInfo pageInfo, String tableName, String lever, String name, Integer is_link, String type) {
        String columnsSql = " *  ";
        String fromAndWhereSql = " from " + tableName + "  where classify_id in " + type;


        if (tableName.equals("hp_qm_zh") && StringUtil.isNotEmpty(lever)) {
            fromAndWhereSql += " and lever=" + lever;
        }
        if (2 == is_link) {
            fromAndWhereSql += " and is_on=1 ";
        } else {
            fromAndWhereSql += " and link_on=1 ";
        }
        if (StringUtil.isNotEmpty(name)) {
            if (org.jsoup.internal.StringUtil.isNumeric(name)) {
                fromAndWhereSql += " and  ordernum='" + name + "' ";
            } else {
                fromAndWhereSql += " and (sqls like '%" + name + "%' or message like '%" + name + "%')";
            }
        }

        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "classify_id,ordernum", pageInfo, false);
       // System.out.println(columnsSql);

        List<Map<String, Object>> maps = hpQcZhDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;

    }

    public void qualityByBah(String bah, String zxflag, String sdate, String edate, List<Map<String, Object>> pfmapList, List<Map<String, Object>> wzlmapList, List<Map<String, Object>> zdmapList, List<Map<String, Object>> zhmapList) {
        StringBuilder sb = null;
        if(CollUtil.isNotEmpty(pfmapList)){
            for (Map<String, Object> objectMap : pfmapList) {
                if(objectMap.containsKey("sqls")){
                    String stime = DataUtil.getDateTime();
                    try {
                        sb = new StringBuilder();

                    } catch (Exception e) {

                    }
                    String etime = DataUtil.getDateTime();
                    long dateSubSeconds = DataUtil.getDateSubSeconds(stime, etime);
                    if(dateSubSeconds>5){
                        System.out.println("警告!!!质控类型: ");
                    }
                }
            }
        }

    }
}
