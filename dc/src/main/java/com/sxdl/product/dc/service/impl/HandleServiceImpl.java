package com.sxdl.product.dc.service.impl;

import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.dbo.SqlserverDBType;
import com.sxdl.product.dc.entity.DcHandle;
import com.sxdl.product.dc.service.HandleSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class HandleServiceImpl extends BaseServiceImpl<DcHandle> implements HandleSerice {
    List<String> columns;
@Autowired
    HandleDao handleDao;

    @Override
    public String selecsql(String sql) {
        return handleDao.execSelectSql(sql);
    }

    @Override
    public String ifExistTable(String tname) {
        List<Map<String, Object>> maps = handleDao.selectSqlWithSQL("if object_id('" + tname + "') is not null select '1' as result else select '0' as result");
        return maps.get(0).get("result").toString();
    }

    @Override
    public List<String> getColumns(String tname) {
        List<Map<String, Object>> maps = handleDao.selectSqlWithSQL(" select column_name from information_schema.columns where table_name ='" + tname + "'");
        columns = new ArrayList<>();
        if (maps.size() > 0) {
            maps.forEach(e -> {
                columns.add(e.get("column_name").toString());
            });
        }
        return columns;
    }

    @Override
    public void addColumn(String tname, String cname, SqlserverDBType type, String limit, String defult) {
        if (StrUtil.isEmpty(defult)) {
            defult = type.getDefult();
        }
        if (StrUtil.isEmpty(limit)) {
            limit = type.getLimit();
        }
        switch (type) {
            case VARCHAR:
                limit=type.getType() +" ("+limit+") "+defult;
                break;
            case INT:
                limit=type.getType() +" "+defult;
                break;
            case NUMERIC:
                limit=type.getType() +" ("+limit+") "+defult;
                break;
            case DATETIME:
                limit=type.getType() +" "+defult;
                break;
        }
        String sql="ALTER TABLE ["+tname+"] ADD ["+cname+"] "+limit;
        System.out.println(sql);
        handleDao.selectSqlWithSQL(sql);
}

    @Override
    public void delColumn(String tname, String cname) {
        handleDao.selectSqlWithSQL("ALTER TABLE [" + tname + "] DROP COLUMN [" + cname + "]");
    }
}
