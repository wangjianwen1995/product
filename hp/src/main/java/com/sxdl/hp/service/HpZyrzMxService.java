package com.sxdl.hp.service;

import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.hp.dao.dao1.HpZyrzMxDao;
import com.sxdl.hp.entity.HpZyrzMxEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpZyrzMxService extends BaseUUIDServiceImpl<HpZyrzMxEntity> {

    @Autowired
    private HpZyrzMxDao hpZyrzMxDao;

    public PageInfo selectBySome(PageInfo pageInfo, String type, String startTime,String endTime ,String bah, String tjks) {

        String columnsSql = " a.*";
        String fromAndWhereSql = " from hp_zyrz_mx a   where 1=1";
        if(StringUtil.isNotEmpty(type) ){
            fromAndWhereSql += " and a.type='" + type + "' ";
        }
        if (StringUtil.isNotEmpty(startTime) && StringUtil.isNotEmpty(endTime)) {
            fromAndWhereSql += " and convert(VARCHAR(10),a.tjsj,120) between '" + startTime + "' and '"+endTime+"' ";
        }
        if (StringUtil.isNotEmpty(tjks)) {
            fromAndWhereSql += " and a.tjks='" + tjks + "' ";
        }
        if (StringUtil.isNotEmpty(bah)) {
            fromAndWhereSql += " and (a.bah= '" + bah + "' or a.hz_xm like '%" + bah + "%' or a.zyh='"+bah+"')";
        }

        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.tjsj,bah", pageInfo, true);
        // System.out.println(columnsSql);

        List<Map<String, Object>> maps = hpZyrzMxDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }
}
