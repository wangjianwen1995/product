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


@ApiModel(value = "hm_sssyc", description = "手术室压疮危险因素评估表")
@Entity
@Data
@Table(name="hm_sssyc")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmsssyc implements Serializable {
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
    @ApiModelProperty(value = "病室")
    private String bingshi;
    @ApiModelProperty(value = "拟手术名称")
    @Column(name = "nssmc")
    private String nssmc;

    @ApiModelProperty(value = "年龄")
    private String nl;

    @ApiModelProperty(value = "体质指数BMI")
    private String bmi;


    @ApiModelProperty(value = "受力点皮肤")
    private String sldpf;

    @ApiModelProperty(value = "手术体位")
    private String sstw;

    @ApiModelProperty(value = "预计术中施加的外力")
    private String yjszsjdwl;


    @ApiModelProperty(value = "预计手术时间")
    private String yjsssj;
    @ApiModelProperty(value = "特殊手术因素")
    private String tsyy;

    @ApiModelProperty(value = "特殊手术因素:其他情况")
    private Integer tsyy_qt;
    @ApiModelProperty(value = "评估人")
    private String pgr;

    @ApiModelProperty(value = "评估人:中文")
    private String pgr_zh;

    @ApiModelProperty(value = "总分")
    private Integer zf;
    @ApiModelProperty(value = "减少摩擦力、剪切力")
    private String ssmcl;

    @ApiModelProperty(value = "体位垫使用")
    private String twdsy;

    @ApiModelProperty(value = "体位垫使用:部位")
    private String twdsy_bw;

    @ApiModelProperty(value = "减压贴使用")
    private String jytsy;

    @ApiModelProperty(value = "减压贴使用:部位")
    private String jytsy_bw;

    @ApiModelProperty(value = "减压贴使用:部位")
    private String jytsy_qt;


    @ApiModelProperty(value = "充气手套")
    private String cqst;
    @ApiModelProperty(value = "充气手套:部位")
    private String cqst_bw;

    @ApiModelProperty(value = "保暖")
    private String bn;
    @ApiModelProperty(value = "消毒液浸湿消毒区域以外的皮肤")
    private String xdyqsxdqy;
    @ApiModelProperty(value = "消毒液浸湿消毒区域以外的皮肤:有")
    private String xdyqsxdqy_you;

    @ApiModelProperty(value = "保护眼角膜措施")
    private String bhyjmcs;
    @ApiModelProperty(value = "耳廓、眼眶受压")
    private String elyksy;
    @ApiModelProperty(value = "体位观察与护理")
    private String twgcyhl;
    @ApiModelProperty(value = "检查受压皮肤")
    private String jcsypf;


    @ApiModelProperty(value = "描述")
    private String ms;

}
