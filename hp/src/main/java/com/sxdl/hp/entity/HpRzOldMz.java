package com.sxdl.hp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
//旧版本,门诊日志
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "T_VsTjMz")
public class HpRzOldMz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(genId = UUIdGenId.class)
    String id;
    //日期
    @Column(name = "TJMZRQ")
    @JsonProperty(value = "TJMZRQ")
    Date TJMZRQ;
    //科别代码
    @Column(name = "TJMZKB")
    @JsonProperty(value = "TJMZKB")
    String TJMZKB;
    //    门诊人次
    @Column(name = "TJMZMZRC")
    @JsonProperty(value = "TJMZMZRC")
    Integer TJMZMZRC;
    //    急诊人次
    @Column(name = "TJMZJZRC")
    @JsonProperty(value = "TJMZJZRC")
    Integer TJMZJZRC;
    //    急诊抢救
    @Column(name = "TJMZJZQJ")
    @JsonProperty(value = "TJMZJZQJ")
    Integer TJMZJZQJ;
    //    急诊抢救失败
    @Column(name = "TJMZJZQJSB")
    @JsonProperty(value = "TJMZJZQJSB")
    Integer TJMZJZQJSB;
    //    单项健康检查数
    @Column(name = "TJMZDXJKJCS")
    @JsonProperty(value = "TJMZDXJKJCS")
    Integer TJMZDXJKJCS;
    //手术例数
    @Column(name = "TJMZSXLS")
    @JsonProperty(value = "TJMZSXLS")
    Integer TJMZSXLS;
    //会诊人次
    @Column(name = "TJMZHZRS")
    @JsonProperty(value = "TJMZHZRS")
    Integer TJMZHZRS;
    //出诊人次
    @Column(name = "TJMZCZRS")
    @JsonProperty(value = "TJMZCZRS")
    Integer TJMZCZRS;
    //专科人次
    @Column(name = "TJMZZKRS")
    @JsonProperty(value = "TJMZZKRS")
    Integer TJMZZKRS;
    //专家次数
    @Column(name = "TJMZZJCS")
    @JsonProperty(value = "TJMZZJCS")
    Integer TJMZZJCS;
    //门诊抢救
    @Column(name = "TJMZMZQJ")
    @JsonProperty(value = "TJMZMZQJ")
    Integer TJMZMZQJ;
    //抢救死亡人数
    @Column(name = "TJMZQJSW")
    @JsonProperty(value = "TJMZQJSW")
    Integer TJMZQJSW;
    //抢救成功人数
    @Column(name = "TJMZQJCG")
    @JsonProperty(value = "TJMZQJCG")
    Integer TJMZQJCG;
    //儿保人次数
    @Column(name = "TJMZEBRS")
    @JsonProperty(value = "TJMZEBRS")
    Integer TJMZEBRS;
    //急诊出车
    @Column(name = "TjmzJzcc")
    @JsonProperty(value = "TjmzJzcc")
    Integer TjmzJzcc;
    //急诊手术
    @Column(name = "TjmzJzss")
    @JsonProperty(value = "TjmzJzss")
    Integer TjmzJzss;
    //医师医士
    @Column(name = "TjmzYs")
    @JsonProperty(value = "TjmzYs")
    Integer TjmzYs;
    //主治医师
    @Column(name = "TjmzZzys")
    @JsonProperty(value = "TjmzZzys")
    Integer TjmzZzys;
    //主任医师
    @Column(name = "TjmzZrys")
    @JsonProperty(value = "TjmzZrys")
    Integer TjmzZrys;
    //副主任医师
    @Column(name = "TjmzFZrys")
    @JsonProperty(value = "TjmzFZrys")
    Integer TjmzFZrys;
    //门诊人次|收费
    @Column(name = "TjmzCbrs")
    @JsonProperty(value = "TjmzCbrs")
    Integer TjmzCbrs;
    //门诊工作日志类型
    @Column(name = "TjMzKind")
    @JsonProperty(value = "TjMzKind")
    Integer TjMzKind;
    //门诊人次|社区门诊
    @Column(name = "TjMzSQMZRC")
    @JsonProperty(value = "TjMzSQMZRC")
    Integer TjMzSQMZRC;
    //预约人数
    @Column(name = "TjMzYyrs")
    @JsonProperty(value = "TjMzYyrs")
    Integer TjMzYyrs;
    //留观人数
    @Column(name = "TJMZlgrs")
    @JsonProperty(value = "TJMZlgrs")
    Integer TJMZlgrs;

    Integer biyear;
    Integer biquarter;
    Integer bimonth;
    Integer biweek;
    Date bidate;
    String ks;

}
