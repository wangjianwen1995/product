package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsch0EEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpVsch0EService extends BaseUUIDServiceImpl<HpVsch0EEntity> {

    private String sql = "select\n" +
            "ChYear, --年度\n" +
            "Ch0E01, --病案号\n" +
            "CH0E02, --术前诊断\n" +
            "CH0E03, --术后诊断\n" +
            "ss.code AS CH0E05, --手术编码（ICD_CM）\n" +
            "CH0E07, --手术顺序号\n" +
            "CH0E08, --手术名称编码\n" +
            "CH0E09, --手术医师\n" +
            "CH0E10, --麻醉方法\n" +
            "CH0E11, --手术日期(日期，不含时分秒)\n" +
            "CH0E12, --切口级别\n" +
            "CH0E13, --愈合情况\n" +
            "CH0E14, --手术助手Ⅰ\n" +
            "CH0E15, --手术助手Ⅱ\n" +
            "CH0E16, --麻醉医师\n" +
            "CH0E17, --手术统计标志\n" +
            "CH0E18, --术前住院天数\n" +
            "CH0E19, --手术并发症\n" +
            //bz=3,执行院内标准,强制执行转换手术等级
            "isnull( ss.ssdj, '' ) AS Ch0E04, --手术级别\n" +
            "CH0EE2, --麻醉分级\n" +
            "CH0EE3, --手术持续时间(单位小时)\n" +
            "CH0EE4, --手术部位\n" +
            "CH0ESC00, --是否择期手术\n" +
            "CH0ESC01, --术前准备时间——天\n" +
            "CH0ESC02, --手术开始时间\n" +
            "CH0ESC03, --手术结束时间\n" +
            "CH0ESC04, --术前预防性抗菌药物给药时间\n" +
            "CH0ESC05, --麻醉开始时间\n" +
            "CH0ESC06, --有无重返手术室手术计划\n" +
            "CH0ESC07, --重返手术室目的\n" +
            "CH0ESC08, --手术切口感染  有无\n" +
            "CH0ESC09, --手术切口感染\n" +
            "CH0ESC10, --手术并发症\n" +
            "ss.name AS CH0E05_Desc, --手术名称\n" +
            "CH0E09DM, --手术医师代码\n" +
            "CH0E14DM, --手术助手Ⅰ代码\n" +
            "CH0E15DM, --手术助手Ⅱ代码\n" +
            "CH0E16DM, --麻醉医师代码\n" +
            "CH0E20, --手术属性\n" +
            "CH0E11_SJ --手术日期(时分秒)\n" +
            //hp_ssbz 临时表在系统启动时创建 HpApplicationRunnerImpl,中查看详情
            "from dcLinkvsch_CH0E a LEFT JOIN hp_ssbz ss ON ss.code = isnull( a.CH0E05, '' ) OR isnull( a.CH0E05, '' ) = ss.use_dm OR ss.name= ch0e05_desc OR ss.use_mc= CH0E05_Desc\n" +
            "where CHYear='@@@' and CH0E01='!!!' ORDER BY ch0e01,ch0e07 asc";
    @Autowired
    private HpDictMapService dictMapService;

    /**
     * 初始化查询e表数据
     */
    public List<HpVsch0EEntity> findEForInit(String year, String bah, String hiscode, String dclink)  {
//        String mysql = sql.replace("@@@", year).replaceAll("dcLink", dclink).replace("!!!", bah);
        return selectListWithSQL(sql.replace("@@@", year).replaceAll("dcLink", dclink).replace("!!!", bah),HpVsch0EEntity.class);
//        List<Map<String, Object>> maps = selectSqlWithSQL(mysql);
//        if (CollUtil.isEmpty(maps)) {
//            return null;
//        }
//        List<HpVsch0EEntity> entitys = new ArrayList<>();
//        for (Map<String, Object> e : maps) {
//            e = dictMapService.operationMappingDictData(e, hiscode);
//            entitys.add(JSON.parseObject(JSON.toJSONString(e), HpVsch0EEntity.class));
//        }
//        return entitys;
    }
}
