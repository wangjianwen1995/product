package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageInfo;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.SQLPackageUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.*;
import com.sxdl.product.dc.dbo.KeyValueDBO;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcConversion;
import com.sxdl.product.dc.service.DcColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dcColumnService")
@Transactional
public class DcColumnServiceImpl extends BaseUUIDServiceImpl<DcColumn> implements DcColumnService {

    @Autowired
    private DcColumnDao columnDao;

    @Autowired
    private DcTableVsTableDao dcTableVsTableDao;
    @Autowired
    private DcVirtualTableDao dcVirtualTableDao;
    @Autowired
    private DcProcedureDao dcProcedureDao;
    @Autowired
    private DcConversionDao dcConversionDao;

    public DcColumn selectByTidName(String tableid, String columnName) {
        return columnDao.selectByTidName(tableid, columnName);
    }

    public List<DcColumn> selectByTableid(String tableid) {
        return columnDao.selectByTableid(tableid);
    }


    public String findtableAndcolName(String id) {
        return columnDao.findtableAndcolName(id);
    }

    public List<DcColumn> selectBySome(String tableid, String name) {
        return columnDao.selectBySome(tableid, name);
    }

    public PageInfo findMappingColumn(PageInfo pageInfo, String name) {
        String columnsSql = " a.* ";
        String fromAndWhereSql = " from dc_column a inner join dc_table b on a. table_id=b.id where a.is_dict=1 and  isnull(b.type_id,0)=1 and b.product_id='C9BA5D39-4CD0-4D6B-B03A-12766FC87D57'   ";
        if (StringUtil.isNotEmpty(name)) {
            fromAndWhereSql += "and (a.column_name='" + name + "' or a.column_name_zh='" + name + "')";
        }
        columnsSql = SQLPackageUtil.getPageSQL(columnsSql, fromAndWhereSql, "a.ordernum", pageInfo, false);
        System.out.println(columnsSql);
        List<Map<String, Object>> maps = columnDao.selectSqlWithSQL(columnsSql);
        pageInfo.setList(maps);
        pageInfo.setTotal(selectCountWithSQL(fromAndWhereSql));
        return pageInfo;
    }

    public Integer updateDictIsOn(String id, Integer is_on) {
        return columnDao.updateDictIsOn(id, is_on);
    }


    public ResultUtil deleteByList(List<DcColumn> dcColumnList) {
        Map<String, String> map = new HashMap<>();
        String msg = "删除成功";
        if (CollUtil.isEmpty(dcColumnList)) {
            msg = "参数为空";
            return ResultUtil.error(msg);
        }
        DcConversion dcConversion=new DcConversion();
        dcConversion.setFrom_table_id(dcColumnList.get(0).getTable_id());
        List<DcConversion> conversionList = dcConversionDao.select(dcConversion);
        if(CollUtil.isNotEmpty(conversionList)){
            map.put(conversionList.get(0).getFrom_table()+"该表有行转列配置，字段不允许删除","");
            return ResultUtil.error(map,"该表有行转列配置，字段不允许删除");
        }
        for (DcColumn dcColumn : dcColumnList) {
            List<KeyValueDBO> keyValueDBOS = dcTableVsTableDao.usedColumn(dcColumn.getId());
            if (keyValueDBOS.size() > 0) {
                for (KeyValueDBO keyValueDBO : keyValueDBOS) {
                    msg = dcColumn.getColumn_name() + "该字段已经在" + keyValueDBO.getValue() + "的字段映射中使用,处理后才可删除";
                    map.put(msg, keyValueDBO.getValue());
                }
            }
            keyValueDBOS = dcVirtualTableDao.usedColumn(dcColumn.getId());
            if (keyValueDBOS.size() > 0) {
                for (KeyValueDBO keyValueDBO : keyValueDBOS) {
                    msg = dcColumn.getColumn_name() + "该字段已经在" + keyValueDBO.getValue() + "的关联关系中使用,处理后才可删除";
                    map.put(msg, keyValueDBO.getValue());
                }
            }
            String colname = columnDao.findtableAndcolName(dcColumn.getId());
            keyValueDBOS = dcProcedureDao.usedColumn(colname);
            if (keyValueDBOS.size() > 0) {
                for (KeyValueDBO keyValueDBO : keyValueDBOS) {
                    msg = dcColumn.getColumn_name() + "该字段已经在" + keyValueDBO.getValue() + "的筛选条件中使用,处理后才可删除";
                    map.put(msg, keyValueDBO.getValue());
                }
            }
        }
        if (CollUtil.isNotEmpty(map)) {
            msg="有字段已使用，删除失败";
          return   ResultUtil.error(map,msg);
        }else{
            for (DcColumn dcColumn : dcColumnList) {
                columnDao.delete(dcColumn);
            }
            return ResultUtil.success(msg);
        }
    }

    public List<DcColumn> findReportTempColumn(String name)  {
        return columnDao.findReportTempColumn(name);
    }

    public Integer updateMappingEnable(String id, Integer is_hisenable){
        return columnDao.updateMappingEnable(id, is_hisenable);
    }

    public List<DcColumn> findMappingColumn(String name){
        return columnDao.findMappingColumn(name);
    }

}
