package com.sxdl.hp.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "hp_rz_yj")
public class HpRzYj {//医院医技日志信息

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String ksid;//科室id
    private String ks;//科室
    private String xmid;//项目id
    private String xm;//项目
    private Integer zrc;//总人次
    private Integer mzrc;//门诊人次
    private Integer zyrc;//住院人次

    private String unit;//项目单位
    private Integer yxs;//阳性数
    private String time;//修改时间
    private Double zsr;//总收入
    private Double mzsr;//门诊收入
    private Double zysr;//住院收入
    private Integer gzjjs;//工作甲级熟
    private Integer gss;//工时数
}
