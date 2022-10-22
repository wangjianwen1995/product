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


@ApiModel(value = "hm_ddzcpf", description = "跌倒坠床评估")
@Entity
@Data
@Table(name="hm_ddzcpf")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmddzcpf implements Serializable {
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

    @ApiModelProperty(value = "责任护士")
    private String zrhs;

    @ApiModelProperty(value = "责任护士:中文")
    private String zrhs_zh;


    @ApiModelProperty(value = "病室")
    private String bingshi;


    // 跌倒评分 --------------------------------------
    @ApiModelProperty(value = "跌倒 因素 年龄")
    private String dd_ys1;
    @ApiModelProperty(value = "跌倒 因素 既往史")
    private String dd_ys2;
    @ApiModelProperty(value = "跌倒 因素 大小便")
    private String dd_ys3;
    @ApiModelProperty(value = "跌倒 因素 药物 ")
    private String dd_ys4;
    @ApiModelProperty(value = "跌倒 因素 患者护理设备")
    private String dd_ys5;
    @ApiModelProperty(value = "跌倒 因素 移动性（分值累加）")
    private String dd_ys6;

    @ApiModelProperty(value = "跌倒 因素 认知（分值累加）")
    private String dd_ys7;

    @ApiModelProperty(value = "跌倒 因素 特殊")
    private String dd_ys8;

    @ApiModelProperty(value = "跌倒 总分")
    private Integer dd_zf;
    @ApiModelProperty(value = "跌倒 措施")
    private String dd_cs;
    @ApiModelProperty(value = "跌倒 风险等级")
    private String dd_fxdj;




}
