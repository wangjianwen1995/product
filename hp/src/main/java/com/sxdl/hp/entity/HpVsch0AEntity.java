package com.sxdl.hp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Table(name = "VSCH0A")
@ApiModel(value = "VSCH0A", description = "病案患者基本信息表")
public class HpVsch0AEntity {

    @Id
    @Column(name="ID")
    @JsonProperty("ID")
    @KeySql(genId = UUIdGenId.class)
    @ApiModelProperty(value = "ID", position = 2)
    private String ID;

    @Column(name="STATUS")
    @JsonProperty("STATUS")
    @ApiModelProperty(value = "状态", position = 2)
    private String STATUS;

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度", position = 2)
    private String CHYear;
    @Column(name="CH0A00")
    @JsonProperty("CH0A00")
    @ApiModelProperty(value = "住院号", position = 2)
    private String CH0A00;
    @Column(name="CH0A01")
    @JsonProperty("CH0A01")
    @ApiModelProperty(value = "病案号", position = 2)
    private String CH0A01;
    @Column(name="CH0A02")
    @JsonProperty("CH0A02")
    @ApiModelProperty(value = "病人姓名", position = 2)
    private String CH0A02;
    @Column(name="CH0A03")
    @JsonProperty("CH0A03")
    @ApiModelProperty(value = "性别", position = 2)
    private Integer CH0A03;
    @Column(name="CH0A04")
    @JsonProperty("CH0A04")
    @ApiModelProperty(value = "出生日期", position = 2)
    private Date CH0A04;
    @Column(name="CH0A05")
    @JsonProperty("CH0A05")
    @ApiModelProperty(value = "身份证号", position = 2)
    private String CH0A05;
    @Column(name="CH0A06")
    @JsonProperty("CH0A06")
    @ApiModelProperty(value = "年龄", position = 2)
    private Integer CH0A06;
    @Column(name="CH0AA1")
    @JsonProperty("CH0AA1")
    @ApiModelProperty(value = "年龄单位", position = 2)
    private String CH0AA1;
    @Column(name="Ch0AN1")
    @JsonProperty("Ch0AN1")
    @ApiModelProperty(value = "年龄（月）", position = 2)
    private Double Ch0AN1;
    @Column(name="CH0A07")
    @JsonProperty("CH0A07")
    @ApiModelProperty(value = "婚姻状况", position = 2)
    private String CH0A07;
    @Column(name="CH0A08")
    @JsonProperty("CH0A08")
    @ApiModelProperty(value = "职业", position = 2)
    private String CH0A08;
    @Column(name="CH0A10")
    @JsonProperty("CH0A10")
    @ApiModelProperty(value = "民族", position = 2)
    private String CH0A10;
    @Column(name="HPCSD_sheng")
    @JsonProperty("HPCSD_sheng")
    @ApiModelProperty(value = "出生地省名称", position = 2)
    private String HPCSD_sheng;
    @Column(name="HPCSD_sheng_dm")
    @JsonProperty("HPCSD_sheng_dm")
    @ApiModelProperty(value = "出生地省区划代码", position = 2)
    private String HPCSD_sheng_dm;
    @Column(name="HPCSD_shi")
    @JsonProperty("HPCSD_shi")
    @ApiModelProperty(value = "出生地市名称", position = 2)
    private String HPCSD_shi;
    @Column(name="HPCSD_shi_dm")
    @JsonProperty("HPCSD_shi_dm")
    @ApiModelProperty(value = "出生地市区划代码", position = 2)
    private String HPCSD_shi_dm;
    @Column(name="HPCSD_xian")
    @JsonProperty("HPCSD_xian")
    @ApiModelProperty(value = "出生地县名称", position = 2)
    private String HPCSD_xian;
    @Column(name="HPCSD_xian_dm")
    @JsonProperty("HPCSD_xian_dm")
    @ApiModelProperty(value = "出生地县区划代码", position = 2)
    private String HPCSD_xian_dm;
    @Column(name="HPCSD_addr")
    @JsonProperty("HPCSD_addr")
    @ApiModelProperty(value = "出生地详细地址", position = 2)
    private String HPCSD_addr;
//    @Column(name="CH0AN7")
//    @JsonProperty("CH0AN7")
//    @ApiModelProperty(value = "出生地电话", position = 2)
//    private String CH0AN7;
//    @Column(name="CH0AN8")
//    @JsonProperty("CH0AN8")
//    @ApiModelProperty(value = "出生地邮编", position = 2)
//    private String CH0AN8;
    @Column(name="HPHK_sheng")
    @JsonProperty("HPHK_sheng")
    @ApiModelProperty(value = "户口地址省名称", position = 2)
    private String HPHK_sheng;
    @Column(name="HPHK_sheng_dm")
    @JsonProperty("HPHK_sheng_dm")
    @ApiModelProperty(value = "户口地址省区划代码", position = 2)
    private String HPHK_sheng_dm;
    @Column(name="HPHK_shi")
    @JsonProperty("HPHK_shi")
    @ApiModelProperty(value = "户口地址市名称", position = 2)
    private String HPHK_shi;
    @Column(name="HPHK_shi_dm")
    @JsonProperty("HPHK_shi_dm")
    @ApiModelProperty(value = "户口地址市区划代码", position = 2)
    private String HPHK_shi_dm;
    @Column(name="HPHK_xian")
    @JsonProperty("HPHK_xian")
    @ApiModelProperty(value = "户口地址县名称", position = 2)
    private String HPHK_xian;
    @Column(name="HPHK_xian_dm")
    @JsonProperty("HPHK_xian_dm")
    @ApiModelProperty(value = "户口地址县区划代码", position = 2)
    private String HPHK_xian_dm;
    @Column(name="HPHK_addr")
    @JsonProperty("HPHK_addr")
    @ApiModelProperty(value = "户口地址详细地址", position = 2)
    private String HPHK_addr;
    @Column(name="CH0A11")
    @JsonProperty("CH0A11")
    @ApiModelProperty(value = "户口电话", position = 2)
    private String CH0A11;
    @Column(name="CH0A14")
    @JsonProperty("CH0A14")
    @ApiModelProperty(value = "户口邮编", position = 2)
    private String CH0A14;
    @Column(name="CH0A15")
    @JsonProperty("CH0A15")
    @ApiModelProperty(value = "联系人姓名", position = 2)
    private String CH0A15;
    @Column(name="CH0A16")
    @JsonProperty("CH0A16")
    @ApiModelProperty(value = "关系", position = 2)
    private String CH0A16;
    @Column(name="HPLXR_sheng")
    @JsonProperty("HPLXR_sheng")
    @ApiModelProperty(value = "联系人省名称", position = 2)
    private String HPLXR_sheng;
    @Column(name="HPLXR_sheng_dm")
    @JsonProperty("HPLXR_sheng_dm")
    @ApiModelProperty(value = "联系人省区划代码", position = 2)
    private String HPLXR_sheng_dm;
    @Column(name="HPLXR_shi")
    @JsonProperty("HPLXR_shi")
    @ApiModelProperty(value = "联系人市名称", position = 2)
    private String HPLXR_shi;
    @Column(name="HPLXR_shi_dm")
    @JsonProperty("HPLXR_shi_dm")
    @ApiModelProperty(value = "联系人市区划代码", position = 2)
    private String HPLXR_shi_dm;
    @Column(name="HPLXR_xian")
    @JsonProperty("HPLXR_xian")
    @ApiModelProperty(value = "联系人县名称", position = 2)
    private String HPLXR_xian;
    @Column(name="HPLXR_xian_dm")
    @JsonProperty("HPLXR_xian_dm")
    @ApiModelProperty(value = "联系人县区划代码", position = 2)
    private String HPLXR_xian_dm;
    @Column(name="HPLXR_addr")
    @JsonProperty("HPLXR_addr")
    @ApiModelProperty(value = "联系人详细地址", position = 2)
    private String HPLXR_addr;
    @Column(name="CH0A19")
    @JsonProperty("CH0A19")
    @ApiModelProperty(value = "联系人电话", position = 2)
    private String CH0A19;


    @Column(name="CH0A21")
    @JsonProperty("CH0A21")
    @ApiModelProperty(value = "入院科别", position = 2)
    private String CH0A21;
    @Column(name="CH0A24")
    @JsonProperty("CH0A24")
    @ApiModelProperty(value = "入院日期", position = 2)
    private Timestamp CH0A24;
    @Column(name="CH0A22")
    @JsonProperty("CH0A22")
    @ApiModelProperty(value = "转入科别", position = 2)
    private String CH0A22;

    @Column(name="CH0A23")
    @JsonProperty("CH0A23")
    @ApiModelProperty(value = "出院科别", position = 2)
    private String CH0A23;
    @Column(name="CH0A27")
    @JsonProperty("CH0A27")
    @ApiModelProperty(value = "出院日期", position = 2)
    private Timestamp CH0A27;
    @Column(name="CH0A29")
    @JsonProperty("CH0A29")
    @ApiModelProperty(value = "住院天数", position = 2)
    private Integer CH0A29;
    @Column(name="CH0A32")
    @JsonProperty("CH0A32")
    @ApiModelProperty(value = "主任医师", position = 2)
    private String CH0A32;
    @Column(name="CH0A32DM")
    @JsonProperty("CH0A32DM")
    @ApiModelProperty(value = "主任医师代码", position = 2)
    private String CH0A32DM;
    @Column(name="CH0A33")
    @JsonProperty("CH0A33")
    @ApiModelProperty(value = "主治医师", position = 2)
    private String CH0A33;
    @Column(name="CH0A33DM")
    @JsonProperty("CH0A33DM")
    @ApiModelProperty(value = "主治医师代码", position = 2)
    private String CH0A33DM;
    @Column(name="CH0A34")
    @JsonProperty("CH0A34")
    @ApiModelProperty(value = "住院医师", position = 2)
    private String CH0A34;
    @Column(name="CH0A34DM")
    @JsonProperty("CH0A34DM")
    @ApiModelProperty(value = "住院医师代码", position = 2)
    private String CH0A34DM;
    @Column(name="CH0AB1")
    @JsonProperty("CH0AB1")
    @ApiModelProperty(value = "科主任", position = 2)
    private String CH0AB1;
    @Column(name="CH0AB1DM")
    @JsonProperty("CH0AB1DM")
    @ApiModelProperty(value = "科主任代码", position = 2)
    private String CH0AB1DM;
    @Column(name="CH0AB2")
    @JsonProperty("CH0AB2")
    @ApiModelProperty(value = "进修医师", position = 2)
    private String CH0AB2;
    @Column(name="CH0AB2DM")
    @JsonProperty("CH0AB2DM")
    @ApiModelProperty(value = "进修医师代码", position = 2)
    private String CH0AB2DM;
    @Column(name="CH0AB4")
    @JsonProperty("CH0AB4")
    @ApiModelProperty(value = "实习医师", position = 2)
    private String CH0AB4;
    @Column(name="CH0AB4DM")
    @JsonProperty("CH0AB4DM")
    @ApiModelProperty(value = "实习医师代码", position = 2)
    private String CH0AB4DM;
    @Column(name="CH0AB5")
    @JsonProperty("CH0AB5")
    @ApiModelProperty(value = "质控医师", position = 2)
    private String CH0AB5;
    @Column(name="CH0AB5DM")
    @JsonProperty("CH0AB5DM")
    @ApiModelProperty(value = "质控医师代码", position = 2)
    private String CH0AB5DM;
    @Column(name="Ch0AND")
    @JsonProperty("Ch0AND")
    @ApiModelProperty(value = "责任护士", position = 2)
    private String Ch0AND;
    @Column(name="Ch0ANDDM")
    @JsonProperty("Ch0ANDDM")
    @ApiModelProperty(value = "责任护士代码", position = 2)
    private String Ch0ANDDM;
    @Column(name="CH0A69")
    @JsonProperty("CH0A69")
    @ApiModelProperty(value = "质控护士", position = 2)
    private String CH0A69;
    @Column(name="CH0A69DM")
    @JsonProperty("CH0A69DM")
    @ApiModelProperty(value = "质控护士代码", position = 2)
    private String CH0A69DM;
    @Column(name="CH0A45")
    @JsonProperty("CH0A45")
    @ApiModelProperty(value = "血型", position = 2)
    private String CH0A45;
    @Column(name="CH0AC5")
    @JsonProperty("CH0AC5")
    @ApiModelProperty(value = "RH", position = 2)
    private String CH0AC5;
    @Column(name="CH0A51")
    @JsonProperty("CH0A51")
    @ApiModelProperty(value = "病案质量", position = 2)
    private String CH0A51;
    @Column(name="CH0A52")
    @JsonProperty("CH0A52")
    @ApiModelProperty(value = "药物过敏标志", position = 2)
    private String CH0A52;
    @Column(name="CH0AAA")
    @JsonProperty("CH0AAA")
    @ApiModelProperty(value = "药物过敏名称", position = 2)
    private String CH0AAA;
    @Column(name="CH0A56")
    @JsonProperty("CH0A56")
    @ApiModelProperty(value = "入院途径", position = 2)
    private String CH0A56;
    @Column(name="CH0A59")
    @JsonProperty("CH0A59")
    @ApiModelProperty(value = "编码员", position = 2)
    private String CH0A59;
    @Column(name="CH0A59DM")
    @JsonProperty("CH0A59DM")
    @ApiModelProperty(value = "编码员", position = 2)
    private String CH0A59DM;
    @Column(name="CH0A60")
    @JsonProperty("CH0A60")
    @ApiModelProperty(value = "录入日期", position = 2)
    private String CH0A60;
    @Column(name="CH0A82")
    @JsonProperty("CH0A82")
    @ApiModelProperty(value = "医疗付款方式", position = 2)
    private String CH0A82;
    @Column(name="CH0AA2")
    @JsonProperty("CH0AA2")
    @ApiModelProperty(value = "国籍", position = 2)
    private String CH0AA2;
    @Column(name="CH0AA3")
    @JsonProperty("CH0AA3")
    @ApiModelProperty(value = "单位名称(工作单位及地址)", position = 2)
    private String CH0AA3;
    @Column(name="CH0AA4")
    @JsonProperty("CH0AA4")
    @ApiModelProperty(value = "单位邮编", position = 2)
    private String CH0AA4;
    @Column(name="CH0AA5")
    @JsonProperty("CH0AA5")
    @ApiModelProperty(value = "单位电话", position = 2)
    private String CH0AA5;
    @Column(name="CH0AB6")
    @JsonProperty("CH0AB6")
    @ApiModelProperty(value = "病案检查日期[质控日期]", position = 2)
    private Date CH0AB6;
    @Column(name="CH0A36")
    @JsonProperty("CH0A36")
    @ApiModelProperty(value = "门急诊诊断代码", position = 2)
    private String CH0A36;
    @Column(name="Ch0ASS")
    @JsonProperty("Ch0ASS")
    @ApiModelProperty(value = "损伤中毒外因", position = 2)
    private String Ch0ASS;
    @Column(name="CH0A79")
    @JsonProperty("CH0A79")
    @ApiModelProperty(value = "损伤中毒外因代码", position = 2)
    private String CH0A79;
    @Column(name="CH0AI1")
    @JsonProperty("CH0AI1")
    @ApiModelProperty(value = "病案状态", position = 2)
    private String CH0AI1;
    @Column(name="Ch0ABE")
    @JsonProperty("Ch0ABE")
    @ApiModelProperty(value = "录入员姓名", position = 2)
    private String Ch0ABE;
    @Column(name="CH0ABF")
    @JsonProperty("CH0ABF")
    @ApiModelProperty(value = "录入员工代码", position = 2)
    private String CH0ABF;
    @Column(name="Ch0AN2")
    @JsonProperty("Ch0AN2")
    @ApiModelProperty(value = "出生体重", position = 2)
    private Integer Ch0AN2;
    @Column(name="Ch0AN3")
    @JsonProperty("Ch0AN3")
    @ApiModelProperty(value = "入院体重", position = 2)
    private Integer Ch0AN3;
    @Column(name="HPXZZ_sheng")
    @JsonProperty("HPXZZ_sheng")
    @ApiModelProperty(value = "现住址省名称", position = 2)
    private String HPXZZ_sheng;
    @Column(name="HPXZZ_sheng_dm")
    @JsonProperty("HPXZZ_sheng_dm")
    @ApiModelProperty(value = "现住址省区划代码", position = 2)
    private String HPXZZ_sheng_dm;
    @Column(name="HPXZZ_shi")
    @JsonProperty("HPXZZ_shi")
    @ApiModelProperty(value = "现住址市名称", position = 2)
    private String HPXZZ_shi;
    @Column(name="HPXZZ_shi_dm")
    @JsonProperty("HPXZZ_shi_dm")
    @ApiModelProperty(value = "现住址市区划代码", position = 2)
    private String HPXZZ_shi_dm;
    @Column(name="HPXZZ_xian")
    @JsonProperty("HPXZZ_xian")
    @ApiModelProperty(value = "现住址县名称", position = 2)
    private String HPXZZ_xian;
    @Column(name="HPXZZ_xian_dm")
    @JsonProperty("HPXZZ_xian_dm")
    @ApiModelProperty(value = "现住址县区划代码", position = 2)
    private String HPXZZ_xian_dm;
    @Column(name="HPXZZ_addr")
    @JsonProperty("HPXZZ_addr")
    @ApiModelProperty(value = "现住址详细地址", position = 2)
    private String HPXZZ_addr;
    @Column(name="Ch0AN7")
    @JsonProperty("Ch0AN7")
    @ApiModelProperty(value = "现住址电话", position = 2)
    private String Ch0AN7;
    @Column(name="Ch0AN8")
    @JsonProperty("Ch0AN8")
    @ApiModelProperty(value = "现住址邮编", position = 2)
    private String Ch0AN8;
    @Column(name="Ch0ANA")
    @JsonProperty("Ch0ANA")
    @ApiModelProperty(value = "入院病房", position = 2)
    private String Ch0ANA;
    @Column(name="Ch0ANB")
    @JsonProperty("Ch0ANB")
    @ApiModelProperty(value = "出院病房", position = 2)
    private String Ch0ANB;
    @Column(name="Ch0ANC")
    @JsonProperty("Ch0ANC")
    @ApiModelProperty(value = "死亡患者尸检", position = 2)
    private String Ch0ANC;
    @Column(name="Ch0ANE")
    @JsonProperty("Ch0ANE")
    @ApiModelProperty(value = "离院方式", position = 2)
    private String Ch0ANE;
    @Column(name="Ch0ANF")
    @JsonProperty("Ch0ANF")
    @ApiModelProperty(value = "拟接收医疗机构名称", position = 2)
    private String Ch0ANF;
    @Column(name="Ch0ANF2")
    @JsonProperty("Ch0ANF2")
    @ApiModelProperty(value = "医嘱转社区卫生服务机构/乡镇卫生院,拟接收医疗机构名称", position = 2)
    private String Ch0ANF2;
    @Column(name="Ch0ANG")
    @JsonProperty("Ch0ANG")
    @ApiModelProperty(value = "是否有出院31天内再住院计划", position = 2)
    private Integer Ch0ANG;
    @Column(name="Ch0ANH")
    @JsonProperty("Ch0ANH")
    @ApiModelProperty(value = "目的", position = 2)
    private String Ch0ANH;
    @Column(name="Ch0ANI")
    @JsonProperty("Ch0ANI")
    @ApiModelProperty(value = "颅脑损伤患者昏述时间：入院前 天", position = 2)
    private Integer Ch0ANI;
    @Column(name="Ch0ANJ")
    @JsonProperty("Ch0ANJ")
    @ApiModelProperty(value = "颅脑损伤患者昏述时间：入院前 时", position = 2)
    private Integer Ch0ANJ;
    @Column(name="Ch0ANK")
    @JsonProperty("Ch0ANK")
    @ApiModelProperty(value = "颅脑损伤患者昏述时间：入院前 分", position = 2)
    private Integer Ch0ANK;
    @Column(name="Ch0ANL")
    @JsonProperty("Ch0ANL")
    @ApiModelProperty(value = "颅脑损伤患者昏述时间：入院前 天", position = 2)
    private Integer Ch0ANL;
    @Column(name="Ch0ANM")
    @JsonProperty("Ch0ANM")
    @ApiModelProperty(value = "颅脑损伤患者昏述时间：入院前 时", position = 2)
    private Integer Ch0ANM;
    @Column(name="Ch0ANN")
    @JsonProperty("Ch0ANN")
    @ApiModelProperty(value = "颅脑损伤患者昏述时间：入院前 分", position = 2)
    private Integer Ch0ANN;

    @Column(name="CH0A36_Desc")
    @JsonProperty("CH0A36_Desc")
    @ApiModelProperty(value = "门急诊断名称", position = 2)
    private String CH0A36_Desc;
    @Column(name="CH0A77")
    @JsonProperty("CH0A77")
    @ApiModelProperty(value = "病理诊断", position = 2)
    private String CH0A77;
    @Column(name="CH0AHBL1")
    @JsonProperty("CH0AHBL1")
    @ApiModelProperty(value = "病理号1", position = 2)
    private String CH0AHBL1;
    @Column(name="CH0AHBL1_Desc")
    @JsonProperty("CH0AHBL1_Desc")
    @ApiModelProperty(value = "病理诊断1 文本", position = 2)
    private String CH0AHBL1_Desc;
    @Column(name="ch0ACK")
    @JsonProperty("ch0ACK")
    @ApiModelProperty(value = "病理诊断名称", position = 2)
    private String ch0ACK;

    @Column(name="CH0AZYCS")
    @JsonProperty("CH0AZYCS")
    @ApiModelProperty(value = "病案次数", position = 2)
    private Integer CH0AZYCS;
    @Column(name="CH0AA6")
    @JsonProperty("CH0AA6")
    @ApiModelProperty(value = "修改人员", position = 2)
    private String CH0AA6;
    @Column(name="CH0AA6_DM")
    @JsonProperty("CH0AA6_DM")
    @ApiModelProperty(value = "修改人员代码", position = 2)
    private String CH0AA6_DM;
    @Column(name="CH0AA7")
    @JsonProperty("CH0AA7")
    @ApiModelProperty(value = "修改日期", position = 2)
    private String CH0AA7;
    @Column(name="CH0A70")
    @JsonProperty("CH0A70")
    @ApiModelProperty(value = "自制中药制剂", position = 2)
    private String CH0A70;
    @Column(name="CH0A71")
    @JsonProperty("CH0A71")
    @ApiModelProperty(value = "中医特色治疗", position = 2)
    private String CH0A71;
    @Column(name="Ch0ANQ")
    @JsonProperty("Ch0ANQ")
    @ApiModelProperty(value = "实施临床路径名称", position = 2)
    private String Ch0ANQ;
    @Column(name="Ch0ABA")
    @JsonProperty("Ch0ABA")
    @ApiModelProperty(value = "入院病区", position = 2)
    private String Ch0ABA;
    @Column(name="Ch0ABB")
    @JsonProperty("Ch0ABB")
    @ApiModelProperty(value = "转入病区", position = 2)
    private String Ch0ABB;
    @Column(name="Ch0ABC")
    @JsonProperty("Ch0ABC")
    @ApiModelProperty(value = "出院病区", position = 2)
    private String Ch0ABC;
    @Column(name="Ch0ANP")
    @JsonProperty("Ch0ANP")
    @ApiModelProperty(value = "治疗类别_中医", position = 2)
    private String Ch0ANP;

    @Column(name="CH0A55")
    @ApiModelProperty(value = "治疗类别 1中医 2中西医  3西医  ")
    @JsonProperty("CH0A55")
    private Integer CH0A55;

    @Column(name="Ch0ANR")
    @JsonProperty("Ch0ANR")
    @ApiModelProperty(value = "使用中医诊疗设备", position = 2)
    private String Ch0ANR;
    @Column(name="Ch0ANS")
    @JsonProperty("Ch0ANS")
    @ApiModelProperty(value = "使用中医诊疗技术", position = 2)
    private String Ch0ANS;
    @Column(name="Ch0ANT")
    @JsonProperty("Ch0ANT")
    @ApiModelProperty(value = "辨证施护", position = 2)
    private String Ch0ANT;
    @Column(name="CH0A81")
    @JsonProperty("CH0A81")
    @ApiModelProperty(value = "健康卡号()", position = 2)
    private String CH0A81;

    @Column(name="JG_sheng")
    @JsonProperty("JG_sheng")
    @ApiModelProperty(value = "籍贯省", position = 2)
    private String JG_sheng;

    @Column(name="JG_sheng_dm")
    @JsonProperty("JG_sheng_dm")
    @ApiModelProperty(value = "籍贯省代码", position = 2)
    private String JG_sheng_dm;

    @Column(name="JG_shi")
    @JsonProperty("JG_shi")
    @ApiModelProperty(value = "籍贯市", position = 2)
    private String JG_shi;

    @Column(name="JG_shi_dm")
    @JsonProperty("JG_shi_dm")
    @ApiModelProperty(value = "籍贯市代码", position = 2)
    private String JG_shi_dm;

    @Column(name="ZXFLAG")
    @JsonProperty("ZXFLAG")
    @ApiModelProperty(value = "中西医标志 1:中医 2 西医", position = 2)
    private String ZXFLAG;

    @Column(name="ZZJGDM")
    @JsonProperty("ZZJGDM")
    @ApiModelProperty(value = "组织机构代码", position = 2)
    private String ZZJGDM;


    @Column(name="JGMC")
    @JsonProperty("JGMC")
    @ApiModelProperty(value = "组织机构名称", position = 2)
    private String JGMC;

    @Column(name="ZZJGDM2")
    @JsonProperty("ZZJGDM2")
    @ApiModelProperty(value = "组织机构代码16位", position = 2)
    private String ZZJGDM2;


    @Column(name="CH0AAB")
    @JsonProperty("CH0AAB")
    @ApiModelProperty(value = "其他医疗机构转入名称", position = 2)
    private String CH0AAB;

    @Column(name="CH0AA2_mc")
    @JsonProperty("CH0AA2_mc")
    @ApiModelProperty(value = "国籍名称", position = 2)
    private String CH0AA2_mc;

    @Column(name="CH0AA2_jp")
    @JsonProperty("CH0AA2_jp")
    @ApiModelProperty(value = "国籍名称拼音", position = 2)
    private String CH0AA2_jp;

    @Column(name="ZYH")
    @JsonProperty("ZYH")
    @ApiModelProperty(value = "住院号", position = 2)
    private String ZYH;

    @Column(name="CH0A21_mc")
    @JsonProperty("CH0A21_mc")
    @ApiModelProperty(value = "入院科室名称", position = 2)
    private String CH0A21_mc;

    @Column(name="CH0A23_mc")
    @JsonProperty("CH0A23_mc")
    @ApiModelProperty(value = "出院科室名称", position = 2)
    private String CH0A23_mc;

    @Column(name="isManual")
    @JsonProperty("isManual")
    @ApiModelProperty(value = "是否手工录入", position = 2)
    private String isManual;

    @Column(name="InputReason")
    @JsonProperty("InputReason")
    @ApiModelProperty(value = "手工录入的原因", position = 2)
    private String InputReason;

    @Column(name="CH0ABAH")
    @JsonProperty("CH0ABAH")
    @ApiModelProperty(value = "不带住院次数的病案号", position = 2)
    private String CH0ABAH;


    @Column(name="CH0AJZLSH")
    @JsonProperty("CH0AJZLSH")
    @ApiModelProperty(value = "就诊流水号", position = 2)
    private String CH0AJZLSH;

    @Column(name="CH0A05A")
    @JsonProperty("CH0A05A")
    @ApiModelProperty(value = "身份证件类型", position = 2)
    private String CH0A05A;



}
