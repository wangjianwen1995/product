package com.sxdl.hp.service;

import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpVsch0PEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class HpVsch0PService extends BaseUUIDServiceImpl<HpVsch0PEntity> {

    public List<Map<String, Object>> findSFY(String year, String bah,String dcLink) {
        String sfysql = "select top 1 a.CH0M43 AS CH0A43,--门出诊断符合标志\n" +
                "a.CH0M44	AS CH0A44,--入出诊断符合标志\n" +
                "a.CH0MCD	AS CH0ACD,--手术前后诊断符合标志\n" +
                "a.CH0MC1	AS CH0AC1,--临床与病理诊断符合标志\n" +
                "a.CH0MC2   AS CH0AC2,--放射与病理诊断符合标志\n" +
                "a.CH0MQ6	AS CH0AQ6,--手术冰冻与石蜡病理\n" +
                "a.CH0M46	AS CH0A46,--抢救次数\n" +
                "a.CH0M47	AS CH0A47,--成功次数\n" +
                "a.CH0M20	AS CH0A20,--入院情况\n" +
                "a.CH0M30	as CH0A30,--确诊日期\n" +
                "a.CH0M54	as CH0A54,--有无医院感染\n" +
                "a.CH0M57	as CH0P57,--输血反应\n" +
                "a.CH0M58	as CH0P58,--输液反应\n" +
                "a.CH0M41	as CH0A41,--主诊断出院情况\n" +
                "b.* from " + dcLink + "vsch_PatientInfo a," + dcLink + "vsch_CH0P b where a.CH0M01=b.CH0P01 and b.CHYear='" +
                year + "' and b.CH0P01='" + bah + "' ";
        return selectSqlWithSQL(sfysql);
    }
}
