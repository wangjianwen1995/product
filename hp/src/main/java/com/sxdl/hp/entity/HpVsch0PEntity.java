package com.sxdl.hp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "VSCH0P")
@ApiModel(value = "VSCH0P", description = "省附页信息表")
public class HpVsch0PEntity {

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="CH0P01")
    @JsonProperty("CH0P01")
    @ApiModelProperty(value = "病案号")
    private String CH0P01;

    @Column(name="CH0P04")
    @JsonProperty("CH0P04")
    @ApiModelProperty(value = "实施临床路径")
    private String CH0P04;

    @Column(name="CH0P05")
    @JsonProperty("CH0P05")
    @ApiModelProperty(value = "临床路径病种名称")
    private String CH0P05;

    @Column(name="CH0E05")
    @JsonProperty("CH0E05")
    @ApiModelProperty(value = "手术编码（ICD_CM）")
    private String CH0E05;

    @Column(name="CH0P06")
    @JsonProperty("CH0P06")
    @ApiModelProperty(value = "单病种")
    private String CH0P06;

    @Column(name="CH0P07")
    @JsonProperty("CH0P07")
    @ApiModelProperty(value = "危重病人")
    private String CH0P07;

    @Column(name="CH0P08")
    @JsonProperty("CH0P08")
    @ApiModelProperty(value = "病例讨论")
    private String CH0P08;

    @Column(name="CH0P09")
    @JsonProperty("CH0P09")
    @ApiModelProperty(value = "住院患者压疮")
    private String CH0P09;

    @Column(name="CH0P10")
    @JsonProperty("CH0P10")
    @ApiModelProperty(value = "术中异物遗留")
    private String CH0P10;

    @Column(name="CH0P11")
    @JsonProperty("CH0P11")
    @ApiModelProperty(value = "医源性气胸")
    private String CH0P11;

    @Column(name="CH0P12")
    @JsonProperty("CH0P12")
    @ApiModelProperty(value = "医源性意外穿刺伤")
    private String CH0P12;

    @Column(name="CH0P13")
    @JsonProperty("CH0P13")
    @ApiModelProperty(value = "医源性意外撕裂伤")
    private String CH0P13;

    @Column(name="CH0P14")
    @JsonProperty("CH0P14")
    @ApiModelProperty(value = "新生儿产伤")
    private String CH0P14;

    @Column(name="CH0P15")
    @JsonProperty("CH0P15")
    @ApiModelProperty(value = "医院内坠床")
    private String CH0P15;

    @Column(name="CH0E17")
    @JsonProperty("CH0E17")
    @ApiModelProperty(value = "手术统计标志")
    private String CH0E17;

    @Column(name="CH0P16")
    @JsonProperty("CH0P16")
    @ApiModelProperty(value = "医院内跌倒")
    private String CH0P16;

    @Column(name="CH0P17")
    @JsonProperty("CH0P17")
    @ApiModelProperty(value = "阴道分娩产妇产伤")
    private String CH0P17;

    @Column(name="CH0P18")
    @JsonProperty("CH0P18")
    @ApiModelProperty(value = "手术及麻醉并发症")
    private String CH0P18;

    @Column(name="CH0P19")
    @JsonProperty("CH0P19")
    @ApiModelProperty(value = "并发症名称")
    private String CH0P19;


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
