package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseServiceImpl;
import com.sxdl.hp.entity.HpTable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HpKsService extends BaseServiceImpl<HpTable> {
    static String sql = "select code as !!!!,name from sys_ks where @@@@=1 and is_on=1 order by  name desc";

    /**
     * 通用查询科室,返回值是map类型
     *
     * @param type 0 全部,1 住院,2 门诊,3 急诊,4 观察室,5 医技,6 手术操作
     * @param alis sys_ks表中code字段的别名
     * @return map
     */
    public Map<String, String> findMapKs(int type, String alis) {
        List<Map<String, Object>> kss = findKsByType(type, alis);
        if (CollUtil.isEmpty(kss)) {
            return null;
        }
        return kss.stream().collect(Collectors.toMap(e -> e.get("code") + "", e -> e.get("name") + ""));
    }

    /**
     * 通用查询科室列表方法,返回值是list类型
     *
     * @param type 0 全部,1 住院,2 门诊,3 急诊,4 观察室,5 医技,6 手术操作
     * @param alis 默认情况是code字段,也可以附加其他字段用于查询,可以给code字段附加别名
     *             例如,要附加床位数字段可以传 "code,bed"
     *                  要附加查询条件字段可以传 "code,code+dbo.getpym(name)+name cxtj+"
     * @return list
     */
    public List<Map<String, Object>> findKsByType(int type, String alis) {
        String kssql = sql.replace("!!!!", StrUtil.emptyToDefault(alis, "code"));
        if (1 == type) {
            kssql = kssql.replace("@@@@", "is_id");
        } else if (2 == type) {
            kssql = kssql.replace("@@@@", "is_od");
        } else if (3 == type) {
            kssql = kssql.replace("@@@@", "is_ed");
        } else if (4 == type) {
            kssql = kssql.replace("@@@@", "is_gcs");
        } else if (5 == type) {
            kssql = kssql.replace("@@@@", "is_yj");
        } else if (6 == type) {
            kssql = kssql.replace("@@@@", "is_opr");
        } else if (0 == type) {
            kssql = kssql.replace("@@@@", "1");
        } else {
            kssql = kssql.replace("@@@@", "1!");
        }
        List<Map<String, Object>> list = selectSqlWithSQL(kssql);
        return list;
    }
}
