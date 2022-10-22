package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.hp.entity.HpfllowEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpFllowService extends BaseUUIDServiceImpl<HpfllowEntity> {

//    @Autowired
//    private HpDictMapService dictMapService;

    /**
     * 初始化查询院内附页表信息
     */
    public HpfllowEntity findDlfollowForInit(String year, String bah, String hiscode, String dclink)  {
        String sql = "select \n" +
                "CH0M30 AS CH0A30, --确诊日期\n" +
                "CH0MN9 AS CH0AN9, --联系人邮编\n" +
                "CH0M73 AS CH0A73, --入院前经外院诊治\n" +
                "CH0MNO AS CH0ANO, --入院病情\n" +
                "CH0M74 AS CH0A74, --住院期间病情：危重\n" +
                "Ch0M75 AS Ch0A75, --住院期间病情：急症\n" +
                "Ch0M76 AS Ch0A76, --住院期间病情：疑难\n" +
                "CH0M31 AS CH0A31, --第几天确诊\n" +
                "CH0MC9 AS CH0AC9, --出院诊断疑诊标志\n" +
                "CH0M69DM AS CH0A69DM, --质控护士代码\n" +
                "CH0MB3 AS CH0AB3, --研究生实习医师\n" +
                "CH0MB3DM AS CH0AB3DM, --研究生实习医师代码\n" +
                "CH0MCGDM AS CH0ACGDM, --接诊医师代码\n" +
                "CH0MCH AS CH0ACH, --会诊医师\n" +
                "CH0MCHDM AS CH0ACHDM, --会诊医师代码\n" +
                "CH0M43 AS CH0A43, --门出诊断符合标志\n" +
                "CH0M44 AS CH0A44, --入出诊断符合标志\n" +
                "CH0MCD AS CH0ACD, --手术前后诊断符合标志\n" +
                "CH0MC1 AS CH0AC1, --临床与病理诊断符合标志\n" +
                "CH0MC2 AS CH0AC2, --放射与病理诊断符合标志\n" +
                "CH0M46 AS CH0A46, --抢救次数\n" +
                "CH0M47 AS CH0A47, --成功次数\n" +
                "CH0M48 AS CH0A48, --随诊:1是 0 否\n" +
                "CH0M49 AS CH0A49, --随诊期限:一年/周/一月/\n" +
                "CH0MCE AS CH0ACE, --随诊期限单位\n" +
                "CH0M50 AS CH0A50, --示教病例\n" +
                "CH0M53 AS CH0A53, --手术标志\n" +
                "CH0M54 AS CH0A54, --医院感染\n" +
                "CH0M55 AS CH0A55, --治疗类别\n" +
                "CH0M57 AS CH0A57, --输血情况\n" +
                "CH0M58 AS CH0A58, --输液情况\n" +
                "CH0M62 AS CH0A62, --科研病例\n" +
                "CH0M63 AS CH0A63, --抢救方法\n" +
                "Ch0MJ4 AS Ch0AJ4, --三级护理天数\n" +
                "CH0M66 AS CH0A66, --特别护理天数\n" +
                "CH0M67 AS CH0A67, --一级护理天数\n" +
                "CH0M68 AS CH0A68, --二级护理天数\n" +
                "CH0M77 AS CH0A77, --肿瘤编码（ICD_M）\n" +
                "CH0M80 AS CH0A80, --归档号\n" +
                "CH0MB8 AS CH0AB8, --再转科别\n" +
                "CH0MB9 AS CH0AB9, --再转科别日期\n" +
                "CH0MC3 AS CH0AC3, --手术为本院第一例标志\n" +
                "CH0MCA AS CH0ACA, --治疗为本院第一例标志\n" +
                "CH0MCB AS CH0ACB, --检查为本院第一例标志\n" +
                "CH0MCC AS CH0ACC, --诊断为本院第一例标志\n" +
                "CH0MC4 AS CH0AC4, --外来患者标志\n" +
                "CH0MC6 AS CH0AC6, --HBsAg\n" +
                "CH0MC7 AS CH0AC7, --丙肝HCV-Ab\n" +
                "CH0MC8 AS CH0AC8, --HIV-Ab\n" +
                "CH0MD3 AS CH0AD3, --上级医师指导情况\n" +
                "CH0MF1 AS CH0AF1, --精神障碍分类代码\n" +
                "Ch0MH1 AS Ch0AH1, --抗生素使用\n" +
                "Ch0MH2 AS Ch0AH2, --使用目的\n" +
                "Ch0MH3 AS Ch0AH3, --使用方案\n" +
                "Ch0MH4 AS Ch0AH4, --使用时间\n" +
                "Ch0MH5 AS Ch0AH5, --合并症\n" +
                "Ch0MH6 AS Ch0AH6, --并发症\n" +
                "Ch0MH7 AS Ch0AH7, --传染病报告\n" +
                "CH0MCF AS CH0ACF, --服务半径\n" +
                "Ch0MBD AS Ch0ABD, --诊疗小组\n" +
                "Ch0MI2 AS Ch0AI2, --农村合作医疗救助对象\n" +
                "Ch0MI3 AS Ch0AI3, --临床路径\n" +
                "Ch0MCI AS Ch0ACI, --会诊次数\n" +
                "Ch0MH8 AS Ch0AH8, --呼吸机使用时间\n" +
                "Ch0MH9 AS Ch0AH9, --肿瘤分期(T)\n" +
                "Ch0MHA AS Ch0AHA, --肿瘤分期(N)\n" +
                "Ch0MHB AS Ch0AHB, --肿瘤分期(M)\n" +
                "Ch0MHC AS Ch0AHC, --日常生活能力评定(入院)\n" +
                "Ch0MHD AS Ch0AHD, --日常生活能力评定(出院)\n" +
                "CH0MQ1 AS CH0AQ1, --医院感染总次数\n" +
                "CH0MQ2 AS CH0AQ2, --过敏源\n" +
                "CH0MQ3 AS CH0AQ3, --最高诊断依据\n" +
                "CH0MQ4 AS CH0AQ4, --分化程度\n" +
                "CH0MQ6 AS CH0AQ6, --手术冰冻与石蜡病理\n" +
                "Ch0MHH AS Ch0AHH, --损伤中毒2\n" +
                "Ch0MHI AS Ch0AHI, --损伤中毒3\n" +
                "Ch0MSS AS Ch0ASS, --损伤中毒唯一码字段\n" +
                "CH0MCJ AS CH0ACJ, --医院自定义型病人来源\n" +
                "CH0MBarcode AS CH0ABarcode, --病人条码\n" +
                "CH0MHBL2 AS CH0AHBL2, --病理号2\n" +
                "CH0MHBL2_Desc AS CH0AHBL2_Desc, --病理诊断2 文本\n" +
                "CH0MHBLICD2 AS CH0AHBLICD2, --病理诊断编码2\n" +
                "ch0MCL AS ch0ACL, --病理诊断唯一码2\n" +
                "CH0MHBL3 AS CH0AHBL3, --病理号3\n" +
                "CH0MHBL3_Desc AS CH0AHBL3_Desc, --病理诊断3 文本\n" +
                "CH0MHBLICD3 AS CH0AHBLICD3, --病理诊断编码3\n" +
                "ch0MCM AS ch0ACM, --病理诊断唯一码3\n" +
                "CH0MHSSLX AS CH0AHSSLX, --手术患者类型\n" +
                "CH0MHDYL AS CH0AHDYL, --手术、治疗、检查、诊断为本院第一例\n" +
                "CH0MHweight2 AS CH0AHweight2, --新生儿体重2\n" +
                "CH0MHweight3 AS CH0AHweight3, --新生儿体重3\n" +
                "CH0MHweight4 AS CH0AHweight4, --新生儿体重4\n" +
                "CH0MHweight5 AS CH0AHweight5, --新生儿体重5\n" +
                "CH0MHBXKH AS CH0AHBXKH, --医疗保险手册卡号\n" +
                "CH0MAB AS CH0AAB --其他医疗机构转入名称\n" +
                "from " + dclink + "vsch_PatientInfo " +
                "where CHYear='" + year + "' and CH0M01='" + bah + "'";
        List<HpfllowEntity> list = selectListWithSQL(sql,HpfllowEntity.class);
        if(CollUtil.isEmpty(list)){
            return null;
        }else{
            return list.get(0);
        }
//        List<Map<String, Object>> maps = selectSqlWithSQL(sql);
//        Map<String, Object> map = null;
//        if (entitys.size() == 1) {
//            map = dictMapService.operationMappingDictData(maps.get(0), hiscode);
//        } else {
//            return null;
//        }
//        HpfllowEntity entity = JSON.parseObject(JSON.toJSONString(map), HpfllowEntity.class);
//        return entity;
    }

}
