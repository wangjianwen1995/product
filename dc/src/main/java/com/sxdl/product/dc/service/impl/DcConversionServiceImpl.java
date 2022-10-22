package com.sxdl.product.dc.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.base.util.StringUtil;
import com.sxdl.product.dc.dao.dao1.DcColumnDao;
import com.sxdl.product.dc.dao.dao1.DcConversionDao;
import com.sxdl.product.dc.dao.dao1.DcTableDao;
import com.sxdl.product.dc.dao.dao2.HandleDao;
import com.sxdl.product.dc.entity.DcColumn;
import com.sxdl.product.dc.entity.DcConversion;
import com.sxdl.product.dc.entity.DcTable;
import com.sxdl.product.dc.service.DcConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service("dcConversionService")
@Transactional
public class DcConversionServiceImpl extends BaseUUIDServiceImpl<DcConversion> implements DcConversionService {
    @Autowired
    private DcConversionDao dcConversionDao;
    @Autowired
    HandleDao handleDao;
    @Autowired
    DcTableDao dcTableDao;
    @Autowired
    DcColumnDao dcColumnDao;
    @Autowired
    DcColumnServiceImpl dcColumnService;


    @Override
    public void insertOrUpdate(DcConversion dcConversion) {
        // 1.生成sql

        String convert_sql = "";
        String max_column = dcConversion.getMax_column();
        String id_column = dcConversion.getId_column();
        String other_column = dcConversion.getOther_column();

        //2.保存table表
        DcTable dcTable = new DcTable();
        dcTable.setName(dcConversion.getTo_table());
        dcTable.setProduct_id(dcConversion.getProduct_id());
        dcTable.setType_id(6);
        dcTable.setIsexist("2");
        dcTable.setIs_public(1);
        dcTable.setName_zh(dcConversion.getFrom_table() + "行列转换表");
        // 信息值
        if (max_column.contains(",")) {
            dcTable = getSqlByList(dcConversion, convert_sql, dcTable);
        } else {
            dcTable = getSqlByOne(dcConversion, convert_sql, dcTable);
        }
        String id_other_column="";
        if (StringUtil.isNotEmpty(id_column) && id_column.trim().length() > 1) {
            id_other_column += id_column+ ",";
        }
        if (StringUtil.isNotEmpty(other_column) && other_column.trim().length() > 1) {
            id_other_column += other_column + ",";
        }
            // System.out.println(convert_sql);
        //生成更新表结构的sql

        //dcTableDao.insert(dcTable);
        DcTable table = dcTableDao.selectByNameAndProdectID(dcConversion.getTo_table(), dcConversion.getProduct_id());
        if (null == table) {
            dcTableDao.insertSelective(dcTable);
        } else {
            dcTable.setId(table.getId());
            dcTableDao.updateByPrimaryKey(dcTable);
        }

        //3.保存column表  upVirtualColumn
        insertColumn(dcConversion.getFrom_table(), dcConversion.getFor_column(), dcTable.getId(), dcConversion.getTo_table(), max_column,id_other_column);
        //4.保存dcConversion

        if (StringUtil.isNotEmpty(dcConversion.getId())) {
            dcConversionDao.updateByPrimaryKey(dcConversion);
        } else {
            dcConversion.setTo_table_id(dcTable.getId());
            dcConversionDao.insert(dcConversion);
        }
    }

    private DcTable getSqlByList(DcConversion dcConversion, String convert_sql, DcTable dcTable) {
        String id_column = dcConversion.getId_column();
        String other_column = dcConversion.getOther_column();
        String maxColumn = "";
        String max_column = dcConversion.getMax_column();
        String[] split = max_column.trim().split(",");
        List<String> list = new ArrayList<>();
        list = Arrays.asList(split);
        //行转列sql
        convert_sql = dcConversion.getRelation_scope_sql() + "\n" +
                " declare  @event varchar(max)='',@sql varchar(max)='',@queryexp varchar(max)=''\n" +
                "   if object_id('tempdb..#hbTab') is not null\n" +
                "     drop table #hbtab\n" +
                "  select  ";
        if (StringUtil.isNotEmpty(id_column) && id_column.trim().length() > 1) {
            id_column += ",";
        }
        if (StringUtil.isNotEmpty(other_column) && other_column.trim().length() > 1) {
            id_column += other_column + ",";
        }
        if (CollUtil.isNotEmpty(list)) {
            maxColumn = list.get(0);
            convert_sql += id_column + "'" + maxColumn + "'+'_'+convert(VARCHAR," + dcConversion.getFor_column() + ") as [t_key]," + maxColumn + " as t_value into #hbtab  from #dcTempConvert \n";
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    convert_sql += " insert into #hbtab select " + id_column + "'" + list.get(i) + "'+'_'+convert(VARCHAR," + dcConversion.getFor_column() + ") as [t_key]," + list.get(i) + " as t_value  from #dcTempConvert \n";
                }
            }
        }
        convert_sql += " select @event=@event+',['+[t_key]+']'  from (select distinct [t_key] from #hbtab ) a order by [t_key]\n" +
                "  select @queryexp=@queryexp+',max(['+[t_key]+']) as '+'['+[t_key]+']'  from (select distinct [t_key] from #hbtab) a order by [t_key]\n" +
                "select  @queryexp=right(@queryexp,len(@queryexp)-1)\n" +
                "select  @event=right(@event,len(@event)-1)" +
                "set @sql= 'if exists(select * from tempdb..sysobjects where id=object_id(''tempdb.." + dcConversion.getTo_table() + " ''))\n" +
                "BEGIN\n" +
                "DROP TABLE " + dcConversion.getTo_table() + "\n" +
                "end\n" +
                "select ";
        convert_sql += id_column + "'+@queryexp+' into " + dcConversion.getTo_table() + " from( select " + id_column + "'+@event +'from #hbtab a\n" +
                "pivot (max(t_value) for t_key in('+@event+')\n" +
                ") as pv ) b group by " + id_column.substring(0, id_column.length() - 1) + "'\n" +
                "print @sql\n" +
                " exec(@sql)";
        String update_sql = "exec [upVirtualColumn] '" + dcConversion.getFrom_table() + "','" + dcConversion.getTo_table() + "','" + dcConversion.getFor_column() + "','" + dcConversion.getMax_column() + "'";
        dcTable.setConversion_sql(convert_sql.toString());
        dcTable.setUpdate_sql(update_sql);
        return dcTable;

    }

    private DcTable getSqlByOne(DcConversion dcConversion, String convert_sql, DcTable dcTable) {
        convert_sql = "DECLARE @column varchar(max),@sql varchar(max) \n" +
                "SELECT @column= stuff( ( SELECT distinct ',[' + " + dcConversion.getFor_column() + " + ']' FROM " + dcConversion.getFrom_table() + " FOR xml path ( '' ) ), 1, 1, '' ) \n" +
                "if(len(@column)>1)\n" +
                "begin \n" + dcConversion.getRelation_scope_sql() + "\n" +
                     /*"select 主页从表.* into #a from HIS_病案主页从表 主页从表 inner join  HIS_病案主页 病案主页   \n" +
                     "ON 病案主页.病人id=主页从表.病人id and 病案主页.主页ID=主页从表.主页ID  where 病案主页.出院日期 between '''+@startDate+''' and ''' +@endDate+'''\n" +*/
                "set @sql= 'if exists(select * from tempdb..sysobjects where id=object_id(''tempdb.." + dcConversion.getTo_table() + " ''))\n" +
                "BEGIN\n" +
                "DROP TABLE " + dcConversion.getTo_table() + "\n" +
                "end\n" +
                "select ";
        if (StringUtil.isNotEmpty(dcConversion.getId_column()) && dcConversion.getId_column().trim().length() > 1) {
            convert_sql += dcConversion.getId_column() + ",";
        }
        if (StringUtil.isNotEmpty(dcConversion.getOther_column()) && dcConversion.getOther_column().trim().length() > 1) {
            convert_sql += dcConversion.getOther_column() + ",";
        }
        convert_sql += "'+@column+' INTO " + dcConversion.getTo_table() + " from #dcTempConvert\n" +
                "pivot\n" +
                "(\n" +
                "    max(" + dcConversion.getMax_column() + ")    /* 指定作为转换的列的值 的列名*/\n" +
                "    for " + dcConversion.getFor_column() + "      /*  -- 指定要转换的列的列名*/\n" +
                "    in(' +@column+')    \n" +
                ")a'\n" +
                "end  \n" +
                "exec (@sql) ";
        String update_sql = "exec [upVirtualColumn] '" + dcConversion.getFrom_table() + "','" + dcConversion.getTo_table() + "','" + dcConversion.getFor_column() + "','" + dcConversion.getMax_column() + "'";
        dcTable.setConversion_sql(convert_sql.toString());
        dcTable.setUpdate_sql(update_sql);
        return dcTable;
    }

    @Override
    public ResultUtil deleteByDcConversion(String table_id) {
        DcConversion dcConversion = new DcConversion();
        dcConversion.setFrom_table_id(table_id);
        dcConversion = dcConversionDao.selectOne(dcConversion);
        List<DcColumn> columns = dcColumnDao.selectByTableid(dcConversion.getTo_table_id());
        ResultUtil resultUtil = dcColumnService.deleteByList(columns);
        if ("error".equals(resultUtil.getState())) {
            return resultUtil;
        }
        dcTableDao.deleteByTableId(dcConversion.getTo_table_id(), dcConversion.getProduct_id());
        dcConversionDao.delete(dcConversion);
        return resultUtil;
    }


    private void insertColumn(String ftable_name, String fcolumns, String ttable_id, String ttable_name, String maxColumn,String id_other_column) {
        String column;
        //查询from表的转换的列的所有值
        //List<String> columns = dcTableDao.selectBySome(ftable_name, fcolumns);
        String sql = "  ";
        if (maxColumn.contains(",")) {
            String[] s = maxColumn.split(",");
            for (int i = 0; i < s.length; i++) {
                sql += "SELECT  distinct '" + s[i] + "_'+rtrim(ltrim(convert(varchar," + fcolumns + "))) name   FROM " + ftable_name + " union all ";
            }
        } else {
            sql = "SELECT  distinct rtrim(ltrim(convert(varchar," + fcolumns + "))) name   FROM " + ftable_name;
        }
        if (sql.length() > 10 && sql.endsWith("union all ")) {
            sql = sql.substring(0, sql.lastIndexOf("union all "));
        }
        if (StringUtil.isNotEmpty(id_other_column) && id_other_column.trim().length() > 1) {
            if (id_other_column.contains(",")) {
                String[] split = id_other_column.split(",");
                for (String s : split) {
                    sql += " union all select '" + s + "'";
                }
            } else {
                sql += " union all select '" + id_other_column + "'";
            }
        }
      /*  if (StringUtil.isNotEmpty(id_other_column) && id_other_column.trim().length() > 1 && id_other_column.endsWith(",")) {
            id_other_column = id_other_column.substring(0, id_other_column.lastIndexOf(","));

            sql += " union all select " + id_other_column;*/

       /* if (sql.length() > 10 && sql.endsWith("union all ")) {
            sql = sql.substring(0, sql.lastIndexOf("union all "));
        }*/
            List<Map<String, Object>> mapList = handleDao.selectSqlWithSQL(sql);
            //查询dc_column中 ttable_id的字段
            List<String> colum = dcColumnDao.selectColumByTableid(ttable_id);
            if (CollUtil.isNotEmpty(mapList)) {
                DcColumn dcColumn = new DcColumn();
                dcColumn.setTable_id(ttable_id);
                dcColumn.setTable_name(ttable_name);
                dcColumn.setType_id(1);
                dcColumn.setType("字符串");
                dcColumn.setSize(2000);
                for (Map<String, Object> e : mapList) {
                    column = e.get("name").toString().trim();
                    //dc_column中还没有 ttable的字段
                    if (CollUtil.isEmpty(colum) || !colum.contains(column)) {
                        dcColumn.setId(null);
                        dcColumn.setColumn_name(column);
                        dcColumn.setColumn_name_zh(column);
                        dcColumnDao.insert(dcColumn);
                    }
                }
            }
        }
}
