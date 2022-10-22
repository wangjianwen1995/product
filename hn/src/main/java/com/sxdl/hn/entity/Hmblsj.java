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


@ApiModel(value = "hm_blsj", description = "护理不良事件")
@Entity
@Data
@Table(name="hm_blsj")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class Hmblsj implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    @ApiModelProperty(value = "报告时间")
    @Column(name = "bgsj")
    private String bgsj;
    @ApiModelProperty(value = "入院科室名称")
    private String ry_codename;
    @ApiModelProperty(value = "出院科室名称")
    private String cy_codename;
    @ApiModelProperty(value = "病室")
    private String bingshi;

    @ApiModelProperty(value = "患者编号")
    @Column(name = "blh")
    private String blh;
    @ApiModelProperty(value = "床位号")
    @Column(name = "cwh")
    private String cwh;
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


    @ApiModelProperty(value = "报告科室")
    private String bgks;
    @ApiModelProperty(value = "事件名称")
    private String  sjmc;
    @ApiModelProperty(value = "发生时间")
    private String  fssj;
    @ApiModelProperty(value = "发生地点")
    private String  fsdd;
    @ApiModelProperty(value = "当事人姓名")
    private String  dsrxm;
    @ApiModelProperty(value = "当事人职称")
    private String  dsszc;
    @ApiModelProperty(value = "当事人工龄")
    private String  dsrgl;
    @ApiModelProperty(value = "从事本专业年限")
    private String  csbzynx;
    @ApiModelProperty(value = "发现者")
    private String  fxz;
    @ApiModelProperty(value = "发生时身心状态")
    private String  sxzt;

    @ApiModelProperty(value = "发生时身心状态其它")
    private String  sxzt_qt;
    @ApiModelProperty(value = "发生时状况")
    private String  fsszk;
    @ApiModelProperty(value = "发生时状况(其他)")
    private String  fsszk_qt;

    @ApiModelProperty(value = "经过及处理")
    private String  jgjcl;

    @ApiModelProperty(value = "原因")
    private String  yy;

    @ApiModelProperty(value = "对患者生命造成的影响")
    private String  dhzsmzcyx;
    @ApiModelProperty(value = "对患者生命造成的影响(其他 )")
    private String  dhzsmzcyxqt;

    @ApiModelProperty(value = "事件级别")
    private String  sjjb;
    @ApiModelProperty(value = "家属知晓情况及其反应")
    private String  jszxqkjqfy;
    @ApiModelProperty(value = "家属知晓情况及其反应(其他)")
    private String  jszxqkjqfyqt;
    @ApiModelProperty(value = "整改意见")
    private String  zgyj;
    @ApiModelProperty(value = "填表人")
    private String  tbr;

    @ApiModelProperty(value = "填表人:中文")
    private String  tbr_zh;
    @ApiModelProperty(value = "护士长签字")
    private String  hszqz;
    @ApiModelProperty(value = "护士长签字:中文")
    private String  hszqz_zh;





}
