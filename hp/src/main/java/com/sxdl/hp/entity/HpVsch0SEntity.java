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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VSCH0S")
@ApiModel(value = "VSCH0S", description = "病案重症信息表")
public class HpVsch0SEntity {

    @Column(name="CHYEAR")
    @JsonProperty("CHYEAR")
    @ApiModelProperty(value = "病案年度")
    private String CHYEAR;

    @Column(name="CH0S01")
    @JsonProperty("CH0S01")
    @ApiModelProperty(value = "病案号")
    private String CH0S01;

    @Column(name="CH0S02")
    @JsonProperty("CH0S02")
    @ApiModelProperty(value = "序号")
    private Integer CH0S02;

    @Column(name="CH0S03")
    @JsonProperty("CH0S03")
    @ApiModelProperty(value = "ICU类型")
    private String CH0S03;

    @Column(name="CH0S04")
    @JsonProperty("CH0S04")
    @ApiModelProperty(value = "入住时间")
    private Date CH0S04;

    @Column(name="CH0S05")
    @JsonProperty("CH0S05")
    @ApiModelProperty(value = "转出时间")
    private Date CH0S05;

    @Column(name="CH0S06")
    @JsonProperty("CH0S06")
    @ApiModelProperty(value = "再次入住ICU计划 无有")
    private Integer CH0S06;

    @Column(name="CH0S07")
    @JsonProperty("CH0S07")
    @ApiModelProperty(value = "再次入住原因")
    private String CH0S07;

    @Column(name="CH0S08")
    @JsonProperty("CH0S08")
    @ApiModelProperty(value = "患者进监护室患者APACHE Ⅱ评分")
    private Integer CH0S08;


    @Id
    @JsonProperty("ID")
    @Column(name="ID")
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
