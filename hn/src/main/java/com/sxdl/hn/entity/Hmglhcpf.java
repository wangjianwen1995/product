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


@ApiModel(value = "hm_glhcpf", description = "管路脱出评分")
@Entity
@Data
@Table(name="hm_glhcpf")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmglhcpf implements Serializable {
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

    // 管路脱出评分 --------------------------------------

    @ApiModelProperty(value = "管路脱出  年 龄")
    private String gltc_ys1;
    @ApiModelProperty(value = "管路脱出 意识状态")
    private String gltc_ys2;
    @ApiModelProperty(value = "管路脱出 行为")
    private String gltc_ys3;
    @ApiModelProperty(value = "管路脱出 疼痛")
    private String gltc_ys4;
    @ApiModelProperty(value = "管路脱出 沟通")
    private String gltc_ys5;

    @ApiModelProperty(value = "管路脱出 Ⅰ类导管")
    private String gltc_ys6;
    @ApiModelProperty(value = "管路脱出 Ⅱ类导管")
    private String gltc_ys7;
    @ApiModelProperty(value = "管路脱出 Ⅲ类导管")
    private String gltc_ys8;


    @ApiModelProperty(value = "管路脱出 总分")
    private Integer gltc_zf;
    @ApiModelProperty(value = "管路脱出 措施")
    private String gltc_cs;
    @ApiModelProperty(value = "管路脱出 风险等级")
    private String gltc_fxdj;




}
