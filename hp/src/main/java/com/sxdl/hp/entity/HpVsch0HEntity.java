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
@Table(name = "VSCH0H")
@ApiModel(value = "VSCH0H", description = "病案输血，输液信息表")
public class HpVsch0HEntity {

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="Ch0H01")
    @JsonProperty("Ch0H01")
    @ApiModelProperty(value = "病案号")
    private String Ch0H01;

    @Column(name="Ch0H02")
    @JsonProperty("Ch0H02")
    @ApiModelProperty(value = "输血量：红细胞")
    private Double Ch0H02;

    @Column(name="Ch0H03")
    @JsonProperty("Ch0H03")
    @ApiModelProperty(value = "输血量：血小板")
    private Double Ch0H03;

    @Column(name="Ch0H04")
    @JsonProperty("Ch0H04")
    @ApiModelProperty(value = "输血量：血浆")
    private Double Ch0H04;

    @Column(name="Ch0H05")
    @JsonProperty("Ch0H05")
    @ApiModelProperty(value = "输血量：全血")
    private Double Ch0H05;

    @Column(name="Ch0H06")
    @JsonProperty("Ch0H06")
    @ApiModelProperty(value = "输血量：其它")
    private Double Ch0H06;

    @Column(name="Ch0H07")
    @JsonProperty("Ch0H07")
    @ApiModelProperty(value = "输血量：自体回收")
    private Integer Ch0H07;

    @Column(name="Ch0H08")
    @JsonProperty("Ch0H08")
    @ApiModelProperty(value = "输血次数")
    private Integer Ch0H08;

    @Column(name="Ch0H09")
    @JsonProperty("Ch0H09")
    @ApiModelProperty(value = "输血反应次数")
    private Integer Ch0H09;

    @Column(name="Ch0H10")
    @JsonProperty("Ch0H10")
    @ApiModelProperty(value = "输液次数")
    private Integer Ch0H10;

    @Column(name="CH0HN1")
    @JsonProperty("CH0HN1")
    @ApiModelProperty(value = "输液反应次数")
    private String CH0HN1;


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
