package com.sxdl.hp.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 医院门诊日志信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hp_rz_mz")
public class HpRzMz {
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    //科室id
    private String ksid;
    //科室
    private String ks;
    //普通门诊
    private Integer ptmzrc;
    //专家门诊(副高以上)
    private Integer zjmzrc;
    //健康检查
    private Integer jkjcrc;
    //门诊手术
    private Integer mzssls;
    //会诊人次
    private Integer hzrc;
    //出诊人次
    private Integer czrc;
    //家庭病床诊疗人次
    private Integer jtbczlrc;
    //门诊抢救人次
    private Integer mzqjrc;
    //门诊抢救成功人次
    private Integer mzqjcgrc;
    //门诊抢救死亡人次
    private Integer mzqjswrc;
    //修改时间
    private String time;
}