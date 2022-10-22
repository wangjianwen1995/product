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


@ApiModel(value = "hm_zlnlpf", description = "自理能力")
@Entity
@Data
@Table(name="hm_zlnlpf")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmzlnlpf implements Serializable {
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


    //自理能力（Barthel指数评定量表） --------------------------------------
    @ApiModelProperty(value = "自理能力 因素 进  食")
    private String zlnl_ys1;
    @ApiModelProperty(value = "自理能力 因素 洗  澡")
    private String zlnl_ys2;
    @ApiModelProperty(value = "自理能力 因素 修  饰")
    private String zlnl_ys3;
    @ApiModelProperty(value = "自理能力 因素 穿  衣")
    private String zlnl_ys4;
    @ApiModelProperty(value = "自理能力 因素 控制大便")
    private String zlnl_ys5;
    @ApiModelProperty(value = "自理能力 因素 控制小便")
    private String zlnl_ys6;
    @ApiModelProperty(value = "自理能力 因素 如  厕")
    private String zlnl_ys7;
    @ApiModelProperty(value = "自理能力 因素 床椅转移")
    private String zlnl_ys8;
    @ApiModelProperty(value = "自理能力 因素 平地行走")
    private String zlnl_ys9;
    @ApiModelProperty(value = "自理能力 因素 上下楼梯")
    private String zlnl_ys10;
    @ApiModelProperty(value = "自理能力 总分")
    private Integer zlnl_zf;

    @ApiModelProperty(value = "自理能力 措施")
    private String zlnl_hlcs;

    @ApiModelProperty(value = "自理能力 风险等级")
    private String zlnl_fxdj;




}
