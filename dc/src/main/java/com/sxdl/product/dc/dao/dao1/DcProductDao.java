package com.sxdl.product.dc.dao.dao1;

import com.sxdl.base.dao.BaseDao;
import com.sxdl.product.dc.entity.DcProduct;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DcProductDao extends BaseDao<DcProduct> {

    @Select(value="select * from dc_product where name like #{0}")
    List<DcProduct> getByName(String s);

    @Select(value=" SELECT  distinct a.name FROM sys.databases a, dc_product b WHERE UPPER(a.name) =UPPER(b.database_name ) \n" +
            " AND database_name is not null  and database_name  <>'' AND b.status = 1 \n" +
            " UNION SELECT distinct a.name FROM sys.databases a WHERE a.name in('dl_dc','dl_dc_base') ")
    List<String> getByDatabase();

    void deleteServerLink(String sql);
    @Select(value="select * from dc_product where id in (${ids})")
    List<DcProduct> selectBYIds(String ids);
}