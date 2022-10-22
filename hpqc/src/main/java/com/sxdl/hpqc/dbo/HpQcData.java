package com.sxdl.hpqc.dbo;

import lombok.Data;

@Data
public class HpQcData {

    private String id        ;           //id
    private String type       ;//病案号
    private String is_link      ;//患者姓名
    private String cykb      ;//出院科别
    private String cykb_name ;//出院科别
    private String cysj      ;//出院时间
    private String zyzd      ;//主要诊断icd
    private String zyzd_mc   ;//主要诊断
    private String zyss      ;//主要手术
    private String zyss_mc    ;//主要手术
    private String zyys       ;//住院医师
    private String bmy         ;//编码员
    private Double pfzf         ;//评分总分
    private String status       ;//状态  1：未质控  2：已质控
}
