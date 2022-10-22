package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.dao.BaseUUIDDao;
import com.sxdl.cf.dto.TableModelDBO;
import com.sxdl.cf.entity.SysCustomerFormFactTableEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysCustomerFormFactTableDao extends BaseUUIDDao<SysCustomerFormFactTableEntity> {


    @Select(" select count(1) from sys_cf_facttable where classify_id = '${id}'")
    Integer existsTable(String id);

    @Select(" select * from sys_cf_facttable where name like '%${val}%' or  label like '%${val}%' order by order_number")
    List<SysCustomerFormFactTableEntity> getDataofVal(String val);

    @Select(" select * from sys_cf_facttable where classify_id = '${classify_id}' and ( name like '%${val}%' or  label like '%${val}%' ) order by order_number")
    List<SysCustomerFormFactTableEntity> getDataOfClassify(String classify_id, String val);


    @Select(" select * from sys_cf_facttable where id='${id}' and  isnull(maintable_id,'')!='' ")
    SysCustomerFormFactTableEntity getTableByMaintable_id(String id);

    @Select(" select count(1) from [${name}]")
    Integer getCount(String name);


    /*
     获取表结构
     */
    @Select(" select a.name   ,b.name coltype," +
            " case when b.name='int' then 'int' " +
            "  when b.name='varchar' then 'varchar('+ convert(varchar,COLUMNPROPERTY(a.id,a.name,'PRECISION'))+')' " +
            "  when b.name='decimal' then 'decimal('+convert(varchar,COLUMNPROPERTY(a.id,a.name,'PRECISION'))+','+CONVERT(varchar,ISNULL(COLUMNPROPERTY(A.ID,A.NAME,'SCALE'),0))+')' else null end  as coltype2, " +
            " COLUMNPROPERTY(a.id,a.name,'PRECISION') as collen, " +
            "  CASE WHEN A.ISNULLABLE=1 THEN 1 ELSE 0 END as  ablenull,  " +
            " ISNULL(E.TEXT,'') defval, " +
            "  CASE WHEN EXISTS(SELECT 1 FROM SYSOBJECTS WHERE XTYPE='PK' AND PARENT_OBJ=A.ID AND NAME IN ( " +
            " SELECT NAME FROM SYSINDEXES WHERE INDID IN( " +
            " SELECT INDID FROM SYSINDEXKEYS WHERE ID = A.ID AND COLID=A.COLID))) THEN 1 ELSE 0 END as ismain " +
            " FROM syscolumns a " +
            " left join systypes b on a.xtype=b.xusertype " +
            " inner join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' " +
            " left join syscomments e on a.cdefault=e.id " +
            " left join sys.extended_properties g on a.id=g.major_id AND a.colid=g.minor_id " +
            " left join sys.extended_properties f on d.id=f.class and f.minor_id=0 " +
            " WHERE d.name='${tablename}' and  a.name !='id' ")
     List<TableModelDBO>  getTabelStructure(String tablename);
    


}
