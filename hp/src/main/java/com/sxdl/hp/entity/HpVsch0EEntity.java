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
import java.sql.Timestamp;
import java.util.Date;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VSCH0E")
@ApiModel(value = "VSCH0E", description = "病案手术信息表")
public class HpVsch0EEntity {

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="Ch0E01")
    @JsonProperty("Ch0E01")
    @ApiModelProperty(value = "病案号")
    private String Ch0E01;

    @Column(name="CH0E02")
    @JsonProperty("CH0E02")
    @ApiModelProperty(value = "术前诊断")
    private String CH0E02;

    @Column(name="CH0E03")
    @JsonProperty("CH0E03")
    @ApiModelProperty(value = "术后诊断")
    private String CH0E03;

    @Column(name="CH0E05")
    @JsonProperty("CH0E05")
    @ApiModelProperty(value = "手术编码（ICD_CM）")
    private String CH0E05;

    @Column(name="CH0E07")
    @JsonProperty("CH0E07")
    @ApiModelProperty(value = "手术顺序号")
    private Integer CH0E07;

    @Column(name="CH0E08")
    @JsonProperty("CH0E08")
    @ApiModelProperty(value = "手术名称编码")
    private String CH0E08;

    @Column(name="CH0E09")
    @JsonProperty("CH0E09")
    @ApiModelProperty(value = "手术医师")
    private String CH0E09;

    @Column(name="CH0E10")
    @JsonProperty("CH0E10")
    @ApiModelProperty(value = "麻醉方法")
    private String CH0E10;

    @Column(name="CH0E11")
    @JsonProperty("CH0E11")
    @ApiModelProperty(value = "手术日期(日期，不含时分秒)")
    private Timestamp CH0E11;

    @Column(name="CH0E12")
    @JsonProperty("CH0E12")
    @ApiModelProperty(value = "切口级别")
    private String CH0E12;

    @Column(name="CH0E13")
    @JsonProperty("CH0E13")
    @ApiModelProperty(value = "愈合情况")
    private String CH0E13;

    @Column(name="CH0E14")
    @JsonProperty("CH0E14")
    @ApiModelProperty(value = "手术助手Ⅰ")
    private String CH0E14;

    @Column(name="CH0E15")
    @JsonProperty("CH0E15")
    @ApiModelProperty(value = "手术助手Ⅱ")
    private String CH0E15;

    @Column(name="CH0E16")
    @JsonProperty("CH0E16")
    @ApiModelProperty(value = "麻醉医师")
    private String CH0E16;

    @Column(name="CH0E17")
    @JsonProperty("CH0E17")
    @ApiModelProperty(value = "手术统计标志")
    private String CH0E17;

    @Column(name="CH0E18")
    @JsonProperty("CH0E18")
    @ApiModelProperty(value = "术前住院天数")
    private String CH0E18;

    @Column(name="CH0E19")
    @JsonProperty("CH0E19")
    @ApiModelProperty(value = "手术并发症")
    private String CH0E19;

    @Column(name="Ch0E04")
    @JsonProperty("Ch0E04")
    @ApiModelProperty(value = "手术级别")
    private String Ch0E04;

    @Column(name="Ch0EE1")
    @JsonProperty("Ch0EE1")
    @ApiModelProperty(value = "是否手术（1.是，2.否）")
    private String Ch0EE1;

    @Column(name="CH0EE2")
    @JsonProperty("CH0EE2")
    @ApiModelProperty(value = "麻醉分级")
    private String CH0EE2;

    @Column(name="CH0EE3")
    @JsonProperty("CH0EE3")
    @ApiModelProperty(value = "手术持续时间(单位小时)")
    private Double CH0EE3;

    @Column(name="CH0EE4")
    @JsonProperty("CH0EE4")
    @ApiModelProperty(value = "手术部位")
    private String CH0EE4;

    @Column(name="CH0ESC00")
    @JsonProperty("CH0ESC00")
    @ApiModelProperty(value = "是否择期手术")
    private String CH0ESC00;

    @Column(name="CH0ESC01")
    @JsonProperty("CH0ESC01")
    @ApiModelProperty(value = "术前准备时间——天")
    private String CH0ESC01;

    @Column(name="CH0ESC02")
    @JsonProperty("CH0ESC02")
    @ApiModelProperty(value = "手术开始时间")
    private Date CH0ESC02;

    @Column(name="CH0ESC03")
    @JsonProperty("CH0ESC03")
    @ApiModelProperty(value = "手术结束时间")
    private Date CH0ESC03;

    @Column(name="CH0ESC04")
    @JsonProperty("CH0ESC04")
    @ApiModelProperty(value = "术前预防性抗菌药物给药时间")
    private Date CH0ESC04;

    @Column(name="CH0ESC05")
    @JsonProperty("CH0ESC05")
    @ApiModelProperty(value = "麻醉开始时间")
    private Date CH0ESC05;

    @Column(name="CH0ESC15")
    @JsonProperty("CH0ESC15")
    @ApiModelProperty(value = "麻醉结束时间")
    private Date CH0ESC15;

    @Column(name="CH0ESC06")
    @JsonProperty("CH0ESC06")
    @ApiModelProperty(value = "有无重返手术室手术计划")
    private String CH0ESC06;

    @Column(name="CH0ESC07")
    @JsonProperty("CH0ESC07")
    @ApiModelProperty(value = "重返手术室目的")
    private String CH0ESC07;

    @Column(name="CH0ESC08")
    @JsonProperty("CH0ESC08")
    @ApiModelProperty(value = "手术切口感染  有无")
    private String CH0ESC08;

    @Column(name="CH0ESC09")
    @JsonProperty("CH0ESC09")
    @ApiModelProperty(value = "手术切口感染")
    private String CH0ESC09;

    @Column(name="CH0ESC10")
    @JsonProperty("CH0ESC10")
    @ApiModelProperty(value = "手术并发症")
    private String CH0ESC10;

    @Column(name="CH0E05_Desc")
    @JsonProperty("CH0E05_Desc")
    @ApiModelProperty(value = "手术名称")
    private String CH0E05_Desc;

    @Column(name="CH0E09DM")
    @JsonProperty("CH0E09DM")
    @ApiModelProperty(value = "手术医师代码")
    private String CH0E09DM;

    @Column(name="CH0E14DM")
    @JsonProperty("CH0E14DM")
    @ApiModelProperty(value = "手术助手Ⅰ代码")
    private String CH0E14DM;

    @Column(name="CH0E15DM")
    @JsonProperty("CH0E15DM")
    @ApiModelProperty(value = "手术助手Ⅱ代码")
    private String CH0E15DM;

    @Column(name="CH0E16DM")
    @JsonProperty("CH0E16DM")
    @ApiModelProperty(value = "麻醉医师代码")
    private String CH0E16DM;

    @Column(name="CH0E20")
    @JsonProperty("CH0E20")
    @ApiModelProperty(value = "手术属性")
    private String CH0E20;

    @Column(name="CH0E11_SJ")
    @JsonProperty("CH0E11_SJ")
    @ApiModelProperty(value = "手术日期(时分秒)")
    private String CH0E11_SJ;


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
    /**
     * 切口清洁度,I 清洁手术 ;II 想对清洁手术;III 清洁-污染手术;  IV 污染切口
     */
    private Integer ssqkqjd;

    /**
     * 手术类别,1浅层组织手术;2深层组织手术;3器官手术;4腔隙手术
     */
    private Integer sslb;
    /**
     * 手术持续时间,T1 手术在3小时内完成;T2 完成手术,超过3小时
     */
    private Integer sscxsj;
    /**
     * 急诊手术,是否
     */
    private Integer sfjzss;
    /**
     * 手术风险评估
     */
    private Integer ssfxpg;



}
