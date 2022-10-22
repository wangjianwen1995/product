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

//旧版本,观察室日志
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "T_VsTJgcs")
public class HpRzOldGcs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @KeySql(genId = UUIdGenId.class)
    String id;
    //日期
    @Column(name = "TJgcsRQ")
    @JsonProperty(value = "TJgcsRQ")
    Date TJgcsRQ;

    //科别代码
    @Column(name = "TJgcsKB")
    @JsonProperty(value = "TJgcsKB")
    String TJgcsKB;

    //    观察室床位数
    @Column(name = "TJgcsGcsCWS")
    @JsonProperty(value = "TJgcsGcsCWS")
    Integer TJgcsGcsCWS;

    //原有病人数
    @Column(name = "TJgcsYYBRS")
    @JsonProperty(value = "TJgcsYYBRS")
    Integer TJgcsYYBRS;
    //入室病人数
    @Column(name = "TJgcsRSBRS")
    @JsonProperty(value = "TJgcsRSBRS")
    Integer TJgcsRSBRS;
    //出室病人数
    @Column(name = "TJgcsCSBRS")
    @JsonProperty(value = "TJgcsCSBRS")
    Integer TJgcsCSBRS;

    //  出室病人数其中：回家
    @Column(name = "TJgcsHJ")
    @JsonProperty(value = "TJgcsHJ")
    Integer TJgcsHJ;
    //  出室病人数其中：入院
    @Column(name = "TJgcsRY")
    @JsonProperty(value = "TJgcsRY")
    Integer TJgcsRY;
    //  出室病人数其中：转院
    @Column(name = "TJgcsZY")
    @JsonProperty(value = "TJgcsZY")
    Integer TJgcsZY;
    //  出室病人数其中：死亡
    @Column(name = "TJgcsSW")
    @JsonProperty(value = "TJgcsSW")
    Integer TJgcsSW;

    //留室病人数
    @Column(name = "TJgcsLSBRS")
    @JsonProperty(value = "TJgcsLSBRS")
    Integer TJgcsLSBRS;
    //抢救人数
    @Column(name = "TJgcsQJRS")
    @JsonProperty(value = "TJgcsQJRS")
    Integer TJgcsQJRS;
    //抢救成功人数
    @Column(name = "TJgcsQJCGRS")
    @JsonProperty(value = "TJgcsQJCGRS")
    Integer TJgcsQJCGRS;
    //出室病人占床天数
    @Column(name = "TJgcsCSBRZCTS")
    @JsonProperty(value = "TJgcsCSBRZCTS")
    Integer TJgcsCSBRZCTS;


    Integer biyear;
    Integer biquarter;
    Integer bimonth;
    Integer biweek;
    Date bidate;
    String ks;

}
