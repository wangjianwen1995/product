package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "hp_rz_jz_qjyy")
public class HpRzJzYy {//医院急诊日志抢救原因信息
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String ksid;//科室id
    private String ks;//科室
    private Integer ynswrc;//院内死亡人次
    private Integer wzqjcgrc;//抢救成功人次
    private String wzqjyyid;//危重抢救原因字典id
    @Column(name="wzqjyyName")
    private String wzqjyyName;//危重抢救原因字典名称
    private String time;//修改时间
    private String rzjzid;//急诊日志id
}
