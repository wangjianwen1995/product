package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@ApiModel(value = "hm_nkvte", description = "内科VTE")
@Entity
@Data
@Table(name="hm_nkvte")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmnkvte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @ApiModelProperty(value = "评估时间")
    @Column(name = "pgsj")
    private String pgsj;

    @ApiModelProperty(value = "患者编号")
    @Column(name = "blh")
    private String blh;

    @ApiModelProperty(value = "床位号")
    @Column(name = "cwh")
    private String cwh;
    @ApiModelProperty(value = "入院科室名称")
    private String ry_codename;
    @ApiModelProperty(value = "出院科室名称")
    private String cy_codename;
    @ApiModelProperty(value = "住院次数")
    @Column(name = "zycs")
    private Integer zycs;

    @ApiModelProperty(value = "入院时间")
    @Column(name = "ry_time")
    private String ry_time;


    @ApiModelProperty(value = "出院时间")
    @Column(name = "cy_time")
    private String cy_time;

    @ApiModelProperty(value = "入院科室代码")
    @Column(name = "ry_code")
    private String ry_code;

    @ApiModelProperty(value = "出院科室代码")
    @Column(name = "cy_code")
    private String cy_code;

    @ApiModelProperty(value = "患者姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "患者住院号")
    @Column(name = "zyh")
    private String zyh;


    @ApiModelProperty(value = "病室")
    @Column(name = "bingshi")
    private String bingshi;

    @ApiModelProperty(value = "患者年龄")
    @Column(name = "age")
    private String age;

    @ApiModelProperty(value = "患者性别")
    @Column(name = "sex")
    private String sex;
    //患者入院诊断
    @ApiModelProperty(value = "入院诊断")
    @Column(name = "ryzd")
    private String ryzd;

    @ApiModelProperty(value = "危险因素")
    @Column(name = "wxys")
    private String wxys;

    @ApiModelProperty(value = "总分")
    @Column(name = "zf")
    private Integer zf;

    @ApiModelProperty(value = "护士签字")
    @Column(name = "hsqz")
    private String hsqz;

    @ApiModelProperty(value = "护士签字:中文")
    @Column(name = "hsqz_zh")
    private String hsqz_zh;

    @ApiModelProperty(value = "家属签字")
    @Column(name = "hzjsqz")
    private String hzjsqz;


    @ApiModelProperty(value = "措施")
    @Column(name = "cs")
    private String cs;

    @ApiModelProperty(value = "措施其他")
    @Column(name = "csqt")
    private String csqt;


    @ApiModelProperty(value = "风险等级")
    private String fxdj;

}
