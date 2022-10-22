package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSON;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsWt47CfnewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpVsWt47CfnewService extends BaseUUIDServiceImpl<HpVsWt47CfnewEntity> {
    @Autowired
    private HpDictMapService dictMapService;
    private String sql = "select \n" +
            "ChYear AS ChYear, --年度\n" +
            "WT4701 AS WT4701, --病案号\n" +
            "CF_BH AS CF_BH, --孕妇健康档案号\n" +
            "CF_JDSJ AS CF_JDSJ, --建档时间\n" +
            "CF_YC AS CF_YC, --孕次\n" +
            "CF_CC AS CF_CC, --产次\n" +
            "CF_YFZC AS CF_YFZC, --孕周\n" +
            "CF_GWYS AS CF_GWYS, --是否高危妊娠\n" +
            "CF_FMDD AS CF_FMDD, --分娩地点\n" +
            "CF_FMFS AS CF_FMFS, --分娩方式\n" +
            "CF_HYPL AS CF_HYPL, --产妇会阴破裂度（Ⅰ度、Ⅱ度、Ⅲ度）\n" +
            "CF_JCR AS CF_JCR, --接产人\n" +
            "CF_TB AS CF_TB, --胎别\n" +
            "CF_FMRQ AS CF_FMRQ, --分娩日期\n" +
            "FM_XB AS FM_XB, --胎儿性别\n" +
            "FM_XB2 AS FM_XB2, --\n" +
            "FM_XB3 AS FM_XB3, --\n" +
            "FM_XB4 AS FM_XB4, --\n" +
            "FM_XB5 AS FM_XB5, --\n" +
            "FM_Weight AS FM_Weight, --胎儿体重\n" +
            "FM_Weight2 AS FM_Weight2, --\n" +
            "FM_Weight3 AS FM_Weight3, --\n" +
            "FM_Weight4 AS FM_Weight4, --\n" +
            "FM_Weight5 AS FM_Weight5, --\n" +
            "FM_RSJJ AS FM_RSJJ, --妊娠结局\n" +
            "FM_RSJJ2 AS FM_RSJJ2, --\n" +
            "FM_RSJJ3 AS FM_RSJJ3, --\n" +
            "FM_RSJJ4 AS FM_RSJJ4, --\n" +
            "FM_RSJJ5 AS FM_RSJJ5, --\n" +
            "FM_PF AS FM_PF, --Apgar评分1\n" +
            "FM_PF2 AS FM_PF2, --Apgar评分2\n" +
            "FM_PF3 AS FM_PF3, --Apgar评分3\n" +
            "FM_PF4 AS FM_PF4, --\n" +
            "FM_PF5 AS FM_PF5, --\n" +
            "FM_CSRQ AS FM_CSRQ, --胎儿出生日期\n" +
            "FM_YYGR AS FM_YYGR, --是否医院感染\n" +
            "FM_SWRQ AS FM_SWRQ, --死亡日期\n" +
            "FM_SWYY AS FM_SWYY, --死亡原因\n" +
            "FM_CYQK AS FM_CYQK, --出院情况\n" +
            "CYRQ AS CYRQ, --入院日期\n" +
            "FM_CSYE AS FM_CSYE, --发生产伤的新生儿\n" +
            "FM_YDCS AS FM_YDCS, --发生产伤的阴道分娩\n" +
            "FM_MDSC AS FM_MDSC, --妊娠梅毒筛查\n" +
            "FM_CHCX AS FM_CHCX, --产后出血\n" +
            "FM_JBSC AS FM_JBSC, --新生儿疾病筛查\n" +
            "CF_YFTS AS CF_YFTS, --孕妇孕满天数\n" +
            "CF_ZFXM AS CF_ZFXM, --丈夫姓名\n" +
            "CF_ZFSFZ AS CF_ZFSFZ --丈夫身份证\n" +
            "from dcLinkvsch_WT47_CFNew \n" +
            "where CHYear='@@@' and WT4701='!!!'";

    /**
     * 初始化查询wt47表数据
     */
    public HpVsWt47CfnewEntity findWt47ForInit(String year, String bah, String hiscode, String dcLink)  {
        List<HpVsWt47CfnewEntity> list = selectListWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dcLink), HpVsWt47CfnewEntity.class);
        if(CollUtil.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
//        List<Map<String, Object>> maps = selectSqlWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dcLink));
//        if (null == maps || maps.size() == 0) {
//            return null;
//        }
//        Map<String, Object> map = dictMapService.operationMappingDictData(maps.get(0), hiscode);
//        return JSON.parseObject(JSON.toJSONString(map), HpVsWt47CfnewEntity.class);
    }
}
