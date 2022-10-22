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
@Table(name = "VSCH0F")
@ApiModel(value = "VSCH0F", description = "死亡信息表")
public class HpVsch0FEntity {

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

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="Ch0F01")
    @JsonProperty("Ch0F01")
    @ApiModelProperty(value = "病案号")
    private String Ch0F01;

    @Column(name="Ch0F02")
    @JsonProperty("Ch0F02")
    @ApiModelProperty(value = "实施临床路径")
    private String Ch0F02;

    @Column(name="Ch0F05")
    @JsonProperty("Ch0F05")
    @ApiModelProperty(value = "临床路径病种名称")
    private String Ch0F05;

    @Column(name="Ch0F06")
    @JsonProperty("Ch0F06")
    @ApiModelProperty(value = "手术编码（ICD_CM）")
    private String Ch0F06;

    @Column(name="Ch0F07")
    @JsonProperty("Ch0F07")
    @ApiModelProperty(value = "单病种")
    private String Ch0F07;

    @Column(name="Ch0F08")
    @JsonProperty("Ch0F08")
    @ApiModelProperty(value = "危重病人")
    private String Ch0F08;

    @Column(name="Ch0F09")
    @JsonProperty("Ch0F09")
    @ApiModelProperty(value = "病例讨论")
    private String Ch0F09;

    @Column(name="CYSJ")
    @ApiModelProperty(value = "出院日期" )
    @JsonProperty("CYSJ")
    private Date CYSJ;

}
