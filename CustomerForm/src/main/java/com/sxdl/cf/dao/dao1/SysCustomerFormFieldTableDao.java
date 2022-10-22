package com.sxdl.cf.dao.dao1;

import com.sxdl.cf.dao.BaseUUIDDao;
import com.sxdl.cf.entity.SysCustomerFormFieldTableEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysCustomerFormFieldTableDao extends BaseUUIDDao<SysCustomerFormFieldTableEntity> {


    @Select(" select * from sys_cf_fieldtable where facttable_id = '${pid}' and ( name like '%${val}%' or label like '%${val}%') order by id desc")
    List<SysCustomerFormFieldTableEntity> getFieldList(String pid, String val);

    @Select(" select distinct '['+a.name+'] 字段与表['+ b.name+']存在关联关系' as name" +
            " from sys_cf_fieldtable a " +
            " left join sys_cf_facttable b on a.facttable_id=b.id " +
            " where a.facttable_id='${id}' and isnull(a.associated_table_id,'')!='' and isnull(a.associated_table_id,'null')!='null' ")
    List<String> getChildByTableId(String id);

    @Select(" select distinct  '['+name +'] 字段与表 ['+ table_name+'] 存在关联关系' as name" +
            " from sys_cf_fieldtable  " +
            " where  isnull( associated_table_id,'')='${id}' ")
    List<String> getChildByAssociatedTableId(String id);

    @Delete(" delete from sys_cf_fieldtable where  facttable_id='${pid}'")
    Integer deletebyPid(String pid);

    @Select(" SELECT " +
            " '${resources}' table_name,   a.name ,a.name label,null [type] " +
            " ,0 is_mainfield,0 is_system, '${resourcesid}' facttable_id,1 is_null,1 is_edit" +
            " ,255 field_length,ROW_NUMBER() over( order by a.name) order_number " +
            " FROM (" +
            "      SELECT a.name FROM SYSCOLUMNS a left join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' WHERE d.name='${target}' " +
            "        except" +
            "      SELECT a.name FROM SYSCOLUMNS a left join sysobjects d on a.id=d.id and d.xtype='U' and d.name<>'dtproperties' WHERE d.name='${resources}' " +
            " ) a  ")
    List<SysCustomerFormFieldTableEntity> gettargetFields(String resources ,String resourcesid , String target   );


    @Select(" select MAX(order_number)+1 from sys_cf_fieldtable where facttable_id='${facttable_id}'")
    Integer getMaxNum(String facttable_id);
}
