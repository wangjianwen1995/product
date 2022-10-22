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
@Table(name = "VSCH0K")
@ApiModel(value = "VSCH0K", description = "病案中医信息表")
public class HpVsch0KEntity {


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

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="Ch0K01")
    @JsonProperty("Ch0K01")
    @ApiModelProperty(value = "病案号")
    private String Ch0K01;

    @Column(name="CH0K02")
    @JsonProperty("CH0K02")
    @ApiModelProperty(value = "门诊中医诊断（病名）名称")
    private String CH0K02;

    @Column(name="CH0K02ID")
    @JsonProperty("CH0K02ID")
    @ApiModelProperty(value = "门诊中医诊断（病名）ID名称")
    private String CH0K02ID;


    @Column(name="CH0K03")
    @JsonProperty("CH0K03")
    @ApiModelProperty(value = "门诊中医诊断（证侯）名称")
    private String CH0K03;

    @Column(name="CH0K03ID")
    @JsonProperty("CH0K03ID")
    @ApiModelProperty(value = "门诊中医诊断（证侯）编码")
    private String CH0K03ID;

    @Column(name="MZD_ZZ2")
    @JsonProperty("MZD_ZZ2")
    @ApiModelProperty(value = "门诊中医诊断（证侯）名称2")
    private String MZD_ZZ2;

    @Column(name="JBDM_ZZ2")
    @JsonProperty("JBDM_ZZ2")
    @ApiModelProperty(value = "门诊中医诊断（证侯）编码2")
    private String JBDM_ZZ2;

   /* @Column(name="CH0K04")
    @JsonProperty("CH0K04")
    @ApiModelProperty(value = "入院中医诊断（病名）名称")
    private String CH0K04;

    @Column(name="CH0K05")
    @JsonProperty("CH0K05")
    @ApiModelProperty(value = "入院中医诊断（证侯）名称")
    private String CH0K05;*/

    @Column(name="CH0K06")
    @JsonProperty("CH0K06")
    @ApiModelProperty(value = "出院中医诊断（病名）名称")
    private String CH0K06;

    @Column(name="CH0K06ID")
    @JsonProperty("CH0K06ID")
    @ApiModelProperty(value = "出院中医诊断（病名）ID编码")
    private String CH0K06ID;

    @Column(name="CH0K08")
    @JsonProperty("CH0K08")
    @ApiModelProperty(value = "中医转归  ||出院主要中医疾病出院情况（中医疾病诊断）")
    private String CH0K08;

   /* @Column(name="CH0K09")
    @JsonProperty("CH0K09")
    @ApiModelProperty(value = "辨证准确度")
    private String CH0K09;

    @Column(name="CH0K10")
    @JsonProperty("CH0K10")
    @ApiModelProperty(value = "治法准确度")
    private String CH0K10;

    @Column(name="CH0K11")
    @JsonProperty("CH0K11")
    @ApiModelProperty(value = "方药准确度")
    private String CH0K11;

    @Column(name="CH0K12")
    @JsonProperty("CH0K12")
    @ApiModelProperty(value = "门出中医诊断符合")
    private String CH0K12;

    @Column(name="CH0K13")
    @JsonProperty("CH0K13")
    @ApiModelProperty(value = "入出中医诊断符合")
    private String CH0K13;
*/

    @Column(name="CH0K16")
    @JsonProperty("CH0K16")
    @ApiModelProperty(value = "中医治法名称1")
    private String CH0K16;

    @Column(name="CH0K16ID")
    @JsonProperty("CH0K16ID")
    @ApiModelProperty(value = "中医治法编码1")
    private String CH0K16ID;

    @Column(name="ZZ_ZFMC2")
    @JsonProperty("ZZ_ZFMC2")
    @ApiModelProperty(value = "中医治法名称2")
    private String ZZ_ZFMC2;

    @Column(name="ZZ_ZFBM2")
    @JsonProperty("ZZ_ZFBM2")
    @ApiModelProperty(value = "中医治法编码2")
    private String ZZ_ZFBM2;

    @Column(name="ZZ_ZFMC3")
    @JsonProperty("ZZ_ZFMC3")
    @ApiModelProperty(value = "中医治法名称3")
    private String ZZ_ZFMC3;

    @Column(name="ZZ_ZFBM3")
    @JsonProperty("ZZ_ZFBM3")
    @ApiModelProperty(value = "中医治法编码3")
    private String ZZ_ZFBM3;

    @Column(name="ZZ_ZFMC4")
    @JsonProperty("ZZ_ZFMC4")
    @ApiModelProperty(value = "中医治法名称4")
    private String ZZ_ZFMC4;

    @Column(name="ZZ_ZFBM4")
    @JsonProperty("ZZ_ZFBM4")
    @ApiModelProperty(value = "中医治法编码4")
    private String ZZ_ZFBM4;


    @Column(name="ZZ_ZFMC5")
    @JsonProperty("ZZ_ZFMC5")
    @ApiModelProperty(value = "中医治法名称5")
    private String ZZ_ZFMC5;

    @Column(name="ZZ_ZFBM5")
    @JsonProperty("ZZ_ZFBM5")
    @ApiModelProperty(value = "中医治法编码5")
    private String ZZ_ZFBM5;


    @Column(name="ZZ_ZFMC6")
    @JsonProperty("ZZ_ZFMC6")
    @ApiModelProperty(value = "中医治法名称6")
    private String ZZ_ZFMC6;

    @Column(name="ZZ_ZFBM6")
    @JsonProperty("ZZ_ZFBM6")
    @ApiModelProperty(value = "中医治法编码6")
    private String ZZ_ZFBM6;


    @Column(name="ZZ_ZFMC7")
    @JsonProperty("ZZ_ZFMC7")
    @ApiModelProperty(value = "中医治法名称7")
    private String ZZ_ZFMC7;

    @Column(name="ZZ_ZFBM7")
    @JsonProperty("ZZ_ZFBM7")
    @ApiModelProperty(value = "中医治法编码7")
    private String ZZ_ZFBM7;


    @Column(name="Ch0KN1")
    @JsonProperty("Ch0KN1")
    @ApiModelProperty(value = "入院病情(主病)")
    private String Ch0KN1;

    @Column(name="Ch0KN2")
    @JsonProperty("Ch0KN2")
    @ApiModelProperty(value = "入院病情(主证)")
    private String Ch0KN2;

    @Column(name="Ch0KN3")
    @JsonProperty("Ch0KN3")
    @ApiModelProperty(value = "入院病情(中医兼证（证侯）) 出院主要中医证候入院病情（中医证候诊断）3")
    private String Ch0KN3;

    @Column(name="Ch0KN4")
    @JsonProperty("Ch0KN4")
    @ApiModelProperty(value = "入院病情(中医兼证（证侯）) 出院主要中医证候入院病情（中医证候诊断）2")
    private String Ch0KN4;

    @Column(name="ZZ_RYBQ4")
    @JsonProperty("ZZ_RYBQ4")
    @ApiModelProperty(value = "入院病情(中医兼证（证侯）) 出院主要中医证候入院病情（中医证候诊断）4")
    private String ZZ_RYBQ4;

    @Column(name="ZZ_RYBQ5")
    @JsonProperty("ZZ_RYBQ5")
    @ApiModelProperty(value = "入院病情(中医兼证（证侯）) 出院主要中医证候入院病情（中医证候诊断）5")
    private String ZZ_RYBQ5;

    @Column(name="ZZ_RYBQ6")
    @JsonProperty("ZZ_RYBQ6")
    @ApiModelProperty(value = "入院病情(中医兼证（证侯）) 出院主要中医证候入院病情（中医证候诊断）6")
    private String ZZ_RYBQ6;

    @Column(name="ZZ_RYBQ7")
    @JsonProperty("ZZ_RYBQ7")
    @ApiModelProperty(value = "入院病情(中医兼证（证侯）) 出院主要中医证候入院病情（中医证候诊断）7")
    private String ZZ_RYBQ7;

    @Column(name="CH0K07ID")
    @JsonProperty("CH0K07ID")
    @ApiModelProperty(value = "出院中医诊断（证侯）ID编码")
    private String CH0K07ID;

    @Column(name="CH0K14ID")
    @JsonProperty("CH0K14ID")
    @ApiModelProperty(value = "出院主要中医证候诊断编码（中医证候诊断）2")
    private String CH0K14ID;

    @Column(name="CH0K15ID")
    @JsonProperty("CH0K15ID")
    @ApiModelProperty(value = "出院主要中医证候诊断编码（中医证候诊断）3")
    private String CH0K15ID;


    @Column(name="ZZ_JBBM4")
    @JsonProperty("ZZ_JBBM4")
    @ApiModelProperty(value = "出院主要中医证候诊断编码（中医证候诊断）4")
    private String ZZ_JBBM4;


    @Column(name="ZZ_JBBM5")
    @JsonProperty("ZZ_JBBM5")
    @ApiModelProperty(value = "出院主要中医证候诊断编码（中医证候诊断）5")
    private String ZZ_JBBM5;


    @Column(name="ZZ_JBBM6")
    @JsonProperty("ZZ_JBBM6")
    @ApiModelProperty(value = "出院主要中医证候诊断编码（中医证候诊断）6")
    private String ZZ_JBBM6;


    @Column(name="ZZ_JBBM7")
    @JsonProperty("ZZ_JBBM7")
    @ApiModelProperty(value = "出院主要中医证候诊断编码（中医证候诊断）7")
    private String ZZ_JBBM7;

    @Column(name="CH0K07")
    @JsonProperty("CH0K07")
    @ApiModelProperty(value = "出院中医诊断（证侯）名称 1")
    private String CH0K07;

    @Column(name="CH0K14")
    @JsonProperty("CH0K14")
    @ApiModelProperty(value = "出院中医诊断（证侯）名称 2")
    private String CH0K14;

    @Column(name="CH0K15")
    @JsonProperty("CH0K15")
    @ApiModelProperty(value = "出院中医诊断（证侯）名称 3")
    private String CH0K15;

    @Column(name="ZZ4")
    @JsonProperty("ZZ4")
    @ApiModelProperty(value = "出院主要中医证候诊断名称（中医证候诊断）4")
    private String ZZ4;

    @Column(name="ZZ5")
    @JsonProperty("ZZ5")
    @ApiModelProperty(value = "出院主要中医证候诊断名称（中医证候诊断）5")
    private String ZZ5;

    @Column(name="ZZ6")
    @JsonProperty("ZZ6")
    @ApiModelProperty(value = "出院主要中医证候诊断名称（中医证候诊断）6")
    private String ZZ6;

    @Column(name="ZZ7")
    @JsonProperty("ZZ7")
    @ApiModelProperty(value = "出院主要中医证候诊断名称（中医证候诊断）7")
    private String ZZ7;

    @Column(name="ZZ_CYQK1")
    @JsonProperty("ZZ_CYQK1")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）1")
    private String ZZ_CYQK1;

    @Column(name="ZZ_CYQK2")
    @JsonProperty("ZZ_CYQK2")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）2")
    private String ZZ_CYQK2;


    @Column(name="ZZ_CYQK3")
    @JsonProperty("ZZ_CYQK3")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）3")
    private String ZZ_CYQK3;

    @Column(name="ZZ_CYQK4")
    @JsonProperty("ZZ_CYQK4")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）4")
    private String ZZ_CYQK4;


    @Column(name="ZZ_CYQK5")
    @JsonProperty("ZZ_CYQK5")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）5")
    private String ZZ_CYQK5;


    @Column(name="ZZ_CYQK6")
    @JsonProperty("ZZ_CYQK6")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）6")
    private String ZZ_CYQK6;


    @Column(name="ZZ_CYQK7")
    @JsonProperty("ZZ_CYQK7")
    @ApiModelProperty(value = "中医转归  ||出院主要中医证候出院情况（中医证候诊断）7")
    private String ZZ_CYQK7;





}
