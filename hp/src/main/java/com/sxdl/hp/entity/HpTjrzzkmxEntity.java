package com.sxdl.hp.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_tjzkmx", description = "住院日志患者转科明细表")
@Entity
@Data
@Table(name="hp_tjzkmx")
public class HpTjrzzkmxEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    @Id
    @JsonProperty("ID")
    @KeySql(genId = UUIdGenId.class)
    private String ID;

    @ApiModelProperty(value = "转科日期")
    @JsonProperty("ZKRQ")
    private String ZKRQ;

    @ApiModelProperty(value = "患者姓名")
    @JsonProperty("ZKHZXM")
    private String ZKHZXM;

    @ApiModelProperty(value = "患者性别")
    @JsonProperty("ZKHZXB")
    private String ZKHZXB;


    @ApiModelProperty(value = "转出科室")
    @JsonProperty("ZCKS")
    private String ZCKS;

    @ApiModelProperty(value = "转入科室")
    @JsonProperty("ZRKS")
    private String ZRKS;

    @ApiModelProperty(value = "转出科室名称")
    @JsonProperty("ZCKS_MC")
    private String ZCKS_MC;

    @ApiModelProperty(value = "转入科室名称")
    @JsonProperty("ZRKS_MC")
    private String ZRKS_MC;

    @ApiModelProperty(value = "转出医师")
    @JsonProperty("ZCYS")
    private String ZCYS;

    @ApiModelProperty(value = "转入医师")
    @JsonProperty("ZRYS")
    private String ZRYS;

    @ApiModelProperty(value = "转出床位")
    @JsonProperty("ZCCW")
    private String ZCCW;
    @ApiModelProperty(value = "转入床位")
    @JsonProperty("ZRCW")
    private String ZRCW;
    @ApiModelProperty(value = "病案年度")
    @JsonProperty("CHYear")
    private String CHYear;

    @ApiModelProperty(value = "病案号（带住院次数）")
    @JsonProperty("CH0A01")
    private String CH0A01;





}
