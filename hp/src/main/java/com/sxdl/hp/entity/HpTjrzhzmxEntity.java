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

@ApiModel(value = "hp_tjhzmx", description = "住院日志患者明细表")
@Entity
@Data
@Table(name="hp_tjhzmx")
public class HpTjrzhzmxEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "ID")
    @JsonProperty("ID")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String ID;

    @ApiModelProperty(value = "患者姓名")
    @JsonProperty("CH0A02")
    private String CH0A02;

    @ApiModelProperty(value = "患者性别")
    @JsonProperty("CH0A03")
    private String CH0A03;

    @ApiModelProperty(value = "入院科别")
    @JsonProperty("CH0A21")
    private String CH0A21;


    @ApiModelProperty(value = "出院科别")
    @JsonProperty("CH0A23")
    private String CH0A23;

    @ApiModelProperty(value = "入院科别名称")
    @JsonProperty("CH0A21_MC")
    private String CH0A21_MC;


    @ApiModelProperty(value = "出院科别名称")
    @JsonProperty("CH0A23_MC")
    private String CH0A23_MC;

    @ApiModelProperty(value = "入院时间")
    @JsonProperty("CH0A24")
    private String CH0A24;

    @ApiModelProperty(value = "出院时间")
    @JsonProperty("CH0A27")
    private String CH0A27;

    @ApiModelProperty(value = "入院病区")
    @JsonProperty("CH0ABA")
    private String CH0ABA;

    @ApiModelProperty(value = "出院病区")
    @JsonProperty("CH0ABC")
    private String CH0ABC;
    @ApiModelProperty(value = "住院医师")
    @JsonProperty("CH0A34")
    private String CH0A34;
    @ApiModelProperty(value = "病案年度")
    @JsonProperty("CHYear")
    private String CHYear;

    @ApiModelProperty(value = "病案号（带住院次数）")
    @JsonProperty("CH0A01")
    private String CH0A01;
    @ApiModelProperty(value = "住院天数")
    @JsonProperty("CH0A29")
    private Integer CH0A29;




}
