package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;

@Data
@Table(name = "hp_rz_jz")
public class HpRzJz {//医院急诊日志信息
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String ksid;//科室id
    private String ks;//科室
    private Integer jzrc;//急诊人次
    private Integer lyrc;//离院人次
    private Integer rgcsrc;//入观察室人次
    private Integer ryrc;//入院人次
    private Integer swrc;//死亡人次
    private Integer yqswrc;//院前死亡人次
    private Integer ynswrc;//院内死亡人次
    private Integer wzqjrc;//危重抢救人次
    private Integer wzqjcgrc;//危重抢救成功人次
    private Integer cccs;//出车次数
    private String time;//修改时间
    //    private String wzqjyyid;//危重抢救原因字典id
    //private String wzqjyyName;//危重抢救原因字典名称
    @Transient
    private ArrayList<HpRzJzYy> yys;
}
