package com.sxdl.hp.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sxdl.base.service.impl.BaseUUIDServiceImpl;
import com.sxdl.base.util.ResultUtil;
import com.sxdl.hp.dao.dao1.HpVsch0ADao;
import com.sxdl.hp.dao.dao1.HpVsch0BDao;
import com.sxdl.hp.entity.HpEtlConfig;
import com.sxdl.hp.entity.HpVsch0BEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HpVsch0BService extends BaseUUIDServiceImpl<HpVsch0BEntity> {
    private final String sql = "select \n" +
            "CHYear AS CHYear, --病案年度\n" +
            "CH0M01 AS CH0B01, --病案号\n" +
            "CH0M83 AS CH0B83, --住院总费用\n" +
            "CH0MP1 AS CH0BP1, --自付金额（子项）\n" +
            "CH0MP2 AS CH0BP2, --一般医疗服务费\n" +
            "CH0MP3 AS CH0BP3, --一般治疗操作费\n" +
            "CH0MP4 AS CH0BP4, --护理费\n" +
            "CH0MP5 AS CH0BP5, --一般医疗其他费用\n" +
            "CH0MP6 AS CH0BP6, --病理诊断费\n" +
            "CH0MP7 AS CH0BP7, --实验室诊断费\n" +
            "CH0MP8 AS CH0BP8, --影像学诊断费\n" +
            "CH0MP9 AS CH0BP9, --临床诊断项目费\n" +
            "CH0MPA AS CH0BPA, --非手术治疗项目费\n" +
            "CH0MPB AS CH0BPB, --临床物理治疗费（子项）\n" +
            "CH0MPC AS CH0BPC, --手术治疗费\n" +
            "CH0MPD AS CH0BPD, --麻醉费（子项）\n" +
            "CH0MPE AS CH0BPE, --手术费（子项）\n" +
            "CH0MPF AS CH0BPF, --康复费\n" +
            "CH0MPG AS CH0BPG, --中医治疗费\n" +
            "CH0MPH AS CH0BPH, --西药费\n" +
            "CH0MPI AS CH0BPI, --抗菌药物费用（子项）\n" +
            "CH0MPJ AS CH0BPJ, --中成药费\n" +
            "CH0MPK AS CH0BPK, --中草药费\n" +
            "CH0MPL AS CH0BPL, --血费\n" +
            "CH0MPM AS CH0BPM, --白蛋白类制品费\n" +
            "CH0MPN AS CH0BPN, --球蛋白类制品费\n" +
            "CH0MPO AS CH0BPO, --凝血因子类制品费\n" +
            "CH0MPP AS CH0BPP, --细胞因子类制品费\n" +
            "CH0MPQ AS CH0BPQ, --检查用一次性医用材料费\n" +
            "CH0MPR AS CH0BPR, --治疗用一次性医用材料费\n" +
            "CH0MPS AS CH0BPS, --手术用一次性医用材料费\n" +
            "CH0MPT AS CH0BPT, --其他费\n" +
            "Ch0MZ1 AS Ch0BZ1, --中医辨证论治费（子项）\n" +
            "Ch0MZ2 AS Ch0BZ2, --中医辨证论治会诊费（子项）\n" +
            "Ch0MZ3 AS Ch0BZ3, --中医诊断\n" +
            "Ch0MZ4 AS Ch0BZ4, --中医外治（子项）\n" +
            "Ch0MZ5 AS Ch0BZ5, --中医骨伤（子项）\n" +
            "Ch0MZ6 AS Ch0BZ6, --针刺与灸法（子项）\n" +
            "Ch0MZ7 AS Ch0BZ7, --中医推拿治疗（子项）\n" +
            "Ch0MZ8 AS Ch0BZ8, --中医肛肠治疗（子项）\n" +
            "Ch0MZ9 AS Ch0BZ9, --中医特殊治疗（子项）\n" +
            "Ch0MZA AS Ch0BZA, --中医其他\n" +
            "Ch0MZB AS Ch0BZB, --中药特殊调配加工（子项）\n" +
            "Ch0MZC AS Ch0BZC, --辨证施膳（子项）\n" +
            "Ch0MZD AS Ch0BZD --医疗机构中药制剂费（子项）\n" +
            "from dcLinkvsch_PatientInfo " +
            "where CHYear='@@@' and CH0M01='!!!'";
    @Value("{dcLink:}")
    String dcLink;
    @Autowired
    HpVsch0BDao hpVsch0BDao;
    @Autowired
    HpEtlConfigService hpEtlConfigService;
    @Autowired
    HpVsch0ADao hpVsch0ADao;

    /**
     * 初始化查询b表数据
     */
    public HpVsch0BEntity findBForInit(String year, String bah, String hiscode, String dcLink) {
        List<HpVsch0BEntity> maps = selectListWithSQL(sql.replaceAll("@@@", year).replace("!!!", bah).replaceAll("dcLink", dcLink), HpVsch0BEntity.class);
        if (CollUtil.isEmpty(maps)) {
            return null;
        } else {
            return maps.get(0);
        }
    }

    /**
     * 重抽费用
     * 包含3个流程,具体流程需要在dc中配置
     * 流程1:从his到dc; 流程2:从dc到接口; 流程3:从接口到b表,从接口到homepage表
     * 包含3中情况
     * 1 有start,有bah        录入/修改页面上的
     * 2 有start,有bah,有end  查询结果列表中的
     * 3 有start,有end        批量的
     */
    public ResultUtil updateHpFareInfo(String start, String end, String bah) {
        boolean flag=false;
        ResultUtil ru;
        if(StrUtil.isEmpty(start)){//开始时间异常
            return ResultUtil.error("开始时间是必填项,请检查参数!");
        }else{
            if(StrUtil.isNotEmpty(bah)){//病案号正常
                Integer rst = hpVsch0ADao.selectByShouGong(bah);
                if(rst>0){
                    return ResultUtil.error("当前病案数据是手工录入的,不支持重新抽取费用!");
                }
                if(StrUtil.isEmpty(end)) {
                    flag=true;
                    end =StrUtil.blankToDefault(end, start);
                }
            }else{
                if(StrUtil.isEmpty(end)) {
                    end =StrUtil.blankToDefault(end, start);
                }
            }
        }
        HpEtlConfig conf = hpEtlConfigService.findDefaultReloadFare();
        ru=hpEtlConfigService.exec(start, end, conf, bah);
        if(flag){
            return ResultUtil.success(findOne(bah), "操作成功!");
        }else{
            return ru;
        }
    }

    /**
     * 根据病案号查询费用信息,如果参数为空,返回空
     */
    public HpVsch0BEntity findOne(String zyh) {
        if (StrUtil.isNotEmpty(zyh)) {
            String sql = "select * from vsch0b where ch0b01='" + zyh + "'";
            return selectListWithSQL(sql, HpVsch0BEntity.class).get(0);
        } else {
            return null;
        }
    }
}
