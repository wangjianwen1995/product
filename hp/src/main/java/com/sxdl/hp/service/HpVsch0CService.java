package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.dao.dao1.HpVsch0CDao;
import com.sxdl.hp.entity.HpVsch0CEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HpVsch0CService extends BaseUUIDServiceImpl<HpVsch0CEntity> {

    @Autowired
    HpVsch0CDao hpVsch0CDao;
    private String sql = "select\n" +
            "CHYear AS CHYear, --年度\n" +
            "CH0C01 AS CH0C01, --病案号\n" +
            "CH0C02 AS CH0C02, --出院次诊断顺序号\n" +
            "CH0C03 AS CH0C03, --出院次诊断\n" +
            "CH0C05 AS CH0C05, --转归（次诊断）\n" +
            "CH0C06 AS CH0C06, --并症标志 1.医院感染标志 2.并发症(中医)\n" +
            "zdbz.code AS CH0C11, --出院次诊断（ICD_10）\n" +
            "Ch0CN1 AS Ch0CN1, --入院病情\n" +
            "zdbz.name AS CH0C03_Desc --出院次诊断名称\n" +
            "from dcLinkvsch_CH0C a " +
            "left join hp_zdbz zdbz on zdbz.code =upper(isnull(a.ch0c03,'')) or zdbz.use_dm=upper(isnull(a.ch0c03,'')) or zdbz.name=isnull(a.ch0c03_desc,'') or zdbz.use_mc=isnull(a.ch0c03_desc,'')\n" +
            "where CHYear='@@@' and CH0C01='!!!' ORDER BY ch0c01,ch0c02 asc";

    /**
     * 初始化查询c表数据
     */
    public List<HpVsch0CEntity> findCForInit(String year, String bah, String hiscode, String dclink) {
        List<HpVsch0CEntity> list = selectListWithSQL(sql.replace("@@@", year).replace("!!!", bah).replaceAll("dcLink", dclink), HpVsch0CEntity.class);
        if (CollUtil.isEmpty(list)) {
            return new ArrayList<>();
        }
//        List<HpVsch0CEntity> entitys = new ArrayList<>();
//        for (Map<String, Object> e : maps) {
//            e = dictMapService.operationMappingDictData(e, hiscode);
//            entitys.add(JSON.parseObject(JSON.toJSONString(e), HpVsch0CEntity.class));
//        }
        return list;
    }
}
