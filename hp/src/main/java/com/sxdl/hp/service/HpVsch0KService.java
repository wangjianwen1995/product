package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsch0KEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpVsch0KService extends BaseUUIDServiceImpl<HpVsch0KEntity> {
    @Autowired
    private HpDictMapService dictMapService;

    private String sql = "select Ch0K01 AS Ch0K01, --病案号\n" +
            "            ChYear AS ChYear, --年度\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K02ID,'')) or ss.use_dm=upper(isnull(a.CH0K02ID,'')) or name =isnull(a.CH0K02,'') or ss.use_mc=isnull(a.CH0K02,'')) AS CH0K02, --门诊中医诊断（病名）\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K02ID,'')) or ss.use_dm=upper(isnull(a.CH0K02ID,'')) or name =isnull(a.CH0K02,'') or ss.use_mc=isnull(a.CH0K02,'')) as CH0K02ID, --门诊中医诊断（病名）ID\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K03ID,'')) or ss.use_dm=upper(isnull(a.CH0K03ID,'')) or name =isnull(a.CH0K03,'') or ss.use_mc=isnull(a.CH0K03,'')) AS CH0K03, --门诊中医诊断（证侯）\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K03ID,'')) or ss.use_dm=upper(isnull(a.CH0K03ID,'')) or name =isnull(a.CH0K03,'') or ss.use_mc=isnull(a.CH0K03,'')) as CH0K03ID, --门(急)诊中医证候诊断编码1\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.JBDM_ZZ2,'')) or ss.use_dm=upper(isnull(a.JBDM_ZZ2,'')) or name =isnull(a.MZD_ZZ2,'') or ss.use_mc=isnull(a.MZD_ZZ2,'')) AS MZD_ZZ2  , --门(急)诊中医证候诊断名称2 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.JBDM_ZZ2,'')) or ss.use_dm=upper(isnull(a.JBDM_ZZ2,'')) or name =isnull(a.MZD_ZZ2,'') or ss.use_mc=isnull(a.MZD_ZZ2,'')) as JBDM_ZZ2, --门(急)诊中医证候诊断编码2\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K06ID,'')) or ss.use_dm=upper(isnull(a.CH0K06ID,'')) or name =isnull(a.CH0K06,'') or ss.use_mc=isnull(a.CH0K06,'')) AS CH0K06, --出院中医诊断（病名）\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K06ID,'')) or ss.use_dm=upper(isnull(a.CH0K06ID,'')) or name =isnull(a.CH0K06,'') or ss.use_mc=isnull(a.CH0K06,'')) as CH0K06ID, --出院中医诊断（病名）ID\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K07ID,'')) or ss.use_dm=upper(isnull(a.CH0K07ID,'')) or name =isnull(a.CH0K07,'') or ss.use_mc=isnull(a.CH0K07,'')) AS CH0K07, --出院主要中医证候诊断名称1\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K07ID,'')) or ss.use_dm=upper(isnull(a.CH0K07ID,'')) or name =isnull(a.CH0K07,'') or ss.use_mc=isnull(a.CH0K07,'')) as CH0K07ID, --出院主要中医证候诊断编码 1\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K14ID,'')) or ss.use_dm=upper(isnull(a.CH0K14ID,'')) or name =isnull(a.CH0K14,'') or ss.use_mc=isnull(a.CH0K14,'')) as CH0K14 , --出院主要中医证候诊断名称2 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K14ID,'')) or ss.use_dm=upper(isnull(a.CH0K14ID,'')) or name =isnull(a.CH0K14,'') or ss.use_mc=isnull(a.CH0K14,'')) as CH0K14ID, --出院主要中医证候诊断编码2\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K15ID,'')) or ss.use_dm=upper(isnull(a.CH0K15ID,'')) or name =isnull(a.CH0K15,'') or ss.use_mc=isnull(a.CH0K15,'')) as CH0K15 , --出院主要中医证候诊断名称3 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K15ID,'')) or ss.use_dm=upper(isnull(a.CH0K15ID,'')) or name =isnull(a.CH0K15,'') or ss.use_mc=isnull(a.CH0K15,'')) as CH0K15ID, --出院主要中医证候诊断编码3\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM4,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM4,'')) or name =isnull(a.zz4,'') or ss.use_mc=isnull(a.zz4,'')) as zz4, --出院主要中医证候诊断名称4\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM4,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM4,'')) or name =isnull(a.zz4,'') or ss.use_mc=isnull(a.zz4,'')) as ZZ_JBBM4, --出院主要中医证候诊断编码4\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM5,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM5,'')) or name =isnull(a.zz5,'') or ss.use_mc=isnull(a.zz5,'')) as ZZ5 , --出院主要中医证候诊断名称5\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM5,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM5,'')) or name =isnull(a.zz5,'') or ss.use_mc=isnull(a.zz5,'')) as ZZ_JBBM5, --出院主要中医证候诊断编码5\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM6,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM6,'')) or name =isnull(a.zz6,'') or ss.use_mc=isnull(a.zz6,'')) as ZZ6 , --出院主要中医证候诊断名称6\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM6,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM6,'')) or name =isnull(a.zz6,'') or ss.use_mc=isnull(a.zz6,'')) as ZZ_JBBM6, --出院主要中医证候诊断编码6\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM7,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM7,'')) or name =isnull(a.zz7,'') or ss.use_mc=isnull(a.zz7,'')) as ZZ7 , --出院主要中医证候诊断名称7\n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_JBBM7,'')) or ss.use_dm=upper(isnull(a.ZZ_JBBM7,'')) or name =isnull(a.zz7,'') or ss.use_mc=isnull(a.zz7,'')) as ZZ_JBBM7, --出院主要中医证候诊断编码7\n" +
            "             CH0K08 AS CH0K08, --中医转归\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.CH0K16ID,'')) or ss.use_dm=upper(isnull(a.CH0K16ID,'')) or name =isnull(a.CH0K16,'') or ss.use_mc=isnull(a.CH0K16,'')) as CH0K16  ,  --中医治法1 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.CH0K16ID,'')) or ss.use_dm=upper(isnull(a.CH0K16ID,'')) or name =isnull(a.CH0K16,'') or ss.use_mc=isnull(a.CH0K16,'')) as CH0K16ID, --中医治法编码1\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM2,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM2,'')) or name =isnull(a.ZZ_ZFMC2,'') or ss.use_mc=isnull(a.ZZ_ZFMC2,'')) as ZZ_ZFMC2  ,  --中医治法2 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM2,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM2,'')) or name =isnull(a.ZZ_ZFMC2,'') or ss.use_mc=isnull(a.ZZ_ZFMC2,'')) as ZZ_ZFBM2, --中医治法编码2\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM3,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM3,'')) or name =isnull(a.ZZ_ZFMC3,'') or ss.use_mc=isnull(a.ZZ_ZFMC3,'')) as ZZ_ZFMC3  ,  --中医治法3 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM3,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM3,'')) or name =isnull(a.ZZ_ZFMC3,'') or ss.use_mc=isnull(a.ZZ_ZFMC3,'')) as ZZ_ZFBM3, --中医治法编码3\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM4,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM4,'')) or name =isnull(a.ZZ_ZFMC4,'') or ss.use_mc=isnull(a.ZZ_ZFMC4,'')) as ZZ_ZFMC4  ,  --中医治法4 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM4,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM4,'')) or name =isnull(a.ZZ_ZFMC4,'') or ss.use_mc=isnull(a.ZZ_ZFMC4,'')) as ZZ_ZFBM4, --中医治法编码4\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM5,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM5,'')) or name =isnull(a.ZZ_ZFMC5,'') or ss.use_mc=isnull(a.ZZ_ZFMC5,'')) as ZZ_ZFMC5  ,  --中医治法5 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM5,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM5,'')) or name =isnull(a.ZZ_ZFMC5,'') or ss.use_mc=isnull(a.ZZ_ZFMC5,'')) as ZZ_ZFBM5, --中医治法编码5\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM6,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM6,'')) or name =isnull(a.ZZ_ZFMC6,'') or ss.use_mc=isnull(a.ZZ_ZFMC6,'')) as ZZ_ZFMC6  ,  --中医治法6 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM6,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM6,'')) or name =isnull(a.ZZ_ZFMC6,'') or ss.use_mc=isnull(a.ZZ_ZFMC6,'')) as ZZ_ZFBM6, --中医治法编码6\n" +
            "            (select ss.name from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM7,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM7,'')) or name =isnull(a.ZZ_ZFMC7,'') or ss.use_mc=isnull(a.ZZ_ZFMC7,'')) as ZZ_ZFMC7  ,  --中医治法7 \n" +
            "            (select ss.code from hp_zybz ss where  code =upper(isnull(a.ZZ_ZFBM7,'')) or ss.use_dm=upper(isnull(a.ZZ_ZFBM7,'')) or name =isnull(a.ZZ_ZFMC7,'') or ss.use_mc=isnull(a.ZZ_ZFMC7,'')) as ZZ_ZFBM7, --中医治法编码7\n" +
            "            Ch0KN1 AS Ch0KN1, --入院病情(主病)\n" +
            "            Ch0KN2 AS Ch0KN2, --入院病情(主证) 1\n" +
            "            Ch0KN3 AS Ch0KN3, --出院主要中医证候入院病情（中医证候诊断）3\n" +
            "            Ch0KN4 AS Ch0KN4, --出院主要中医证候入院病情（中医证候诊断）2\n" +
            "            ZZ_RYBQ4 , --出院主要中医证候入院病情（中医证候诊断）4 \n" +
            "            ZZ_RYBQ5 , --出院主要中医证候入院病情（中医证候诊断）5 \n" +
            "            ZZ_RYBQ6 , --出院主要中医证候入院病情（中医证候诊断）6 \n" +
            "            ZZ_RYBQ7 , --出院主要中医证候入院病情（中医证候诊断）7 \n" +
            "            ZZ_CYQK1,  --中医转归  ||出院主要中医证候出院情况1 \n" +
            "            ZZ_CYQK2 , --中医转归  ||出院主要中医证候出院情况2  \n" +
            "            ZZ_CYQK3 , --中医转归  ||出院主要中医证候出院情况3  \n" +
            "            ZZ_CYQK4 , --中医转归  ||出院主要中医证候出院情况4  \n" +
            "            ZZ_CYQK5 , --中医转归  ||出院主要中医证候出院情况5  \n" +
            "            ZZ_CYQK6 , --中医转归  ||出院主要中医证候出院情况6  \n" +
            "            ZZ_CYQK7   --中医转归  ||出院主要中医证候出院情况7\n" +
            "from dcLinkvsch_CH0K a where CHYear='@@@' and CH0K01='!!!'";

    /**
     * 初始化查询k表数据
     */
    public HpVsch0KEntity findKForInit(String year, String bah, String hiscode, String dclink)  {
//        String mysql = sql.replace("@@@", year).replaceAll("dcLink", dclink).replace("!!!", bah);
        List<HpVsch0KEntity> list = selectListWithSQL(sql.replace("@@@", year).replaceAll("dcLink", dclink).replace("!!!", bah), HpVsch0KEntity.class);
if(CollUtil.isEmpty(list)){
    return null;
}else{
    return list.get(0);
}
        //        List<Map<String, Object>> maps = selectSqlWithSQL(mysql);
//        if (null == maps || maps.size() == 0) {
//            return null;
//        }
//        Map<String, Object> map = dictMapService.operationMappingDictData(maps.get(0), hiscode);
//        return JSON.parseObject(JSON.toJSONString(map), HpVsch0KEntity.class);
    }
}
