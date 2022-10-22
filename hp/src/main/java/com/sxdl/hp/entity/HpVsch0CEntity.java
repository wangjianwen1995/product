package com.sxdl.hp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VSCH0C")
@ApiModel(value = "VSCH0C", description = "病案诊断信息表")
public class HpVsch0CEntity {

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="CH0C01")
    @JsonProperty("CH0C01")
    @ApiModelProperty(value = "病案号")
    private String CH0C01;

    @Column(name="CH0C02")
    @JsonProperty("CH0C02")
    @ApiModelProperty(value = "出院次诊断顺序号")
    private Integer CH0C02;

    @Column(name="CH0C03")
    @JsonProperty("CH0C03")
    @ApiModelProperty(value = "出院次诊断")
    private String CH0C03;

    @Column(name="CH0C05")
    @JsonProperty("CH0C05")
    @ApiModelProperty(value = "转归（次诊断）")
    private String CH0C05;

    @Column(name="CH0C06")
    @JsonProperty("CH0C06")
    @ApiModelProperty(value = "并症标志 1.医院感染标志 2.并发症(中医)")
    private String CH0C06;

    @Column(name="CH0C11")
    @JsonProperty("CH0C11")
    @ApiModelProperty(value = "出院次诊断（ICD_10）")
    private String CH0C11;

    @Column(name="Ch0CN1")
    @JsonProperty("Ch0CN1")
    @ApiModelProperty(value = "入院病情")
    private String Ch0CN1;

    @Column(name="CH0C03_Desc")
    @JsonProperty("CH0C03_Desc")
    @ApiModelProperty(value = "出院次诊断名称")
    private String CH0C03_Desc;


    @Id
    @Column(name="ID")
    @JsonProperty("ID")
    @ApiModelProperty(value = "ID")
    @KeySql(genId = UUIdGenId.class)
    private String ID;

    @Column(name="A_ID")
    @JsonProperty("A_ID")
    @ApiModelProperty(value = "A_ID")
    private String A_ID;

    @Column(name="CYSJ")
    @ApiModelProperty(value = "出院日期" )
    @JsonProperty("CYSJ")
    private Date CYSJ;

}
