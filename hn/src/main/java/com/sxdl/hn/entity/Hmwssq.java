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


@ApiModel(value = "hm_wssq", description = "围手术期护理评估单")
@Entity
@Data
@Table(name="hm_wssq")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmwssq implements Serializable {
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


    @ApiModelProperty(value = "拟手术名称")
    private String nssmc;

    @ApiModelProperty(value = "手术间")
    private String ssj;

    @ApiModelProperty(value = "电源")
    private String dy;

    @ApiModelProperty(value = "仪器设备")
    private String yqsb;

    @ApiModelProperty(value = "体位")
    private String tw;

    @ApiModelProperty(value = "物品")
    private String wp;
    @ApiModelProperty(value = "术前八项")
    private String sqbx;
    @ApiModelProperty(value = "防护措施")
    private String fhcs;
    @ApiModelProperty(value = "消毒隔离方法")
    private String xdglff;
    @ApiModelProperty(value = "术前用药")
    private String sqyy;
    @ApiModelProperty(value = "配合程度")
    private String phcd;
    @ApiModelProperty(value = "各类管道")
    private String glgd;
    @ApiModelProperty(value = "各类管道: 名称")
    private String glgd_mc;
    @ApiModelProperty(value = "通畅不通畅")
    private String glgd_tc;
    @ApiModelProperty(value = "导管标识")
    private String dgbs;
    @ApiModelProperty(value = "防导管滑脱措施")
    private String fdghtcs;

    @ApiModelProperty(value = "伤口渗血")
    private String sksx;
    @ApiModelProperty(value = "术中输血")
    private String szsx;

    @ApiModelProperty(value = "包扎")
    private String bz;

    @ApiModelProperty(value = "意识")
    private String ys;

    @ApiModelProperty(value = "生命体征")
    private String smtz;
    @ApiModelProperty(value = "评估人")
    private String pgr;

    @ApiModelProperty(value = "评估人:中文")
    private String pgr_zh;


    @ApiModelProperty(value = "病室")
    private String bingshi;



}
