package com.sxdl.product.dc.service;

import com.sxdl.base.service.BaseService;
import com.sxdl.product.dc.dbo.SqlserverDBType;
import com.sxdl.product.dc.entity.DcHandle;

import java.util.List;

public interface HandleSerice extends BaseService<DcHandle> {
    String selecsql(String sql);
    /**
     * 查询当前sqlserver库中是否有表存在
     *
     * @param tname 表名
     * @return 1, 是;0否
     */
    String ifExistTable(String tname);

    /**
     * 查询当前sqlserver库中表的字段列表
     *
     * @param tname 表名
     * @return 字段列表, 永不为空
     */
    List<String> getColumns(String tname);

    /**
     * 增加字段
     *
     * @param tname 表名
     * @param cname 字段名
     * @param type  SqlserverDBType 枚举类,限定只有这几种类型
     * @param limit 限定条件,例如字符串 varchar(50)这里只要传括号内的值
     * @param defult 默认值,默认为 null
     * @return 是否成功
     */
    void addColumn(String tname, String cname, SqlserverDBType type, String limit, String defult);

    /**
     * 删除字段
     *
     * @param tname 表名
     * @param cname 字段名
     * @return 是否成功
     */
    void delColumn(String tname, String cname);

}
