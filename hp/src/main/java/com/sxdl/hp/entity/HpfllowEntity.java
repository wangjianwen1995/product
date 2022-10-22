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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@ApiModel(value = "dl_fllow", description = "雕龙附页表")
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "dl_fllow")
public class HpfllowEntity {

    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @JsonProperty("A_ID")
    @Column(name = "A_ID")
    private String A_ID;

    @Column(name = "CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度", position = 2)
    private String CHYear;

    @Column(name = "CH0A01")
    @JsonProperty("CH0A01")
    @ApiModelProperty(value = "病案号", position = 2)
    private String CH0A01;

/*    @Column(name="CH0A30")
    @ApiModelProperty(value = "确诊日期 日期" )
    @JsonProperty("CH0A30")
    private Date CH0A30;*/

/*
    @Column(name="CH0AN9")
    @ApiModelProperty(value = "联系人邮编,文本" )
    @JsonProperty("CH0AN9")
    private String CH0AN9;
*/

    @Column(name = "CH0A73")
    @ApiModelProperty(value = "入院前经外院诊治  下拉 1是 2")
    @JsonProperty("CH0A73")
    private Integer CH0A73;
/*

    @Column(name="CH0ANO")
    @ApiModelProperty(value = "入院病情  下拉: 1有 2临床未确定 3情况不明 4无   " )
    @JsonProperty("CH0ANO")
    private Integer CH0ANO;
*/


    @Column(name = "CH0A74")
    @ApiModelProperty(value = "住院期间病情：危重  1是 2否")
    @JsonProperty("CH0A74")
    private Integer CH0A74;

    @Column(name = "CH0A75")
    @ApiModelProperty(value = "住院期间病情：急症   1是 2否 ")
    @JsonProperty("CH0A75")
    private Integer CH0A75;

    @Column(name = "CH0A76")
    @ApiModelProperty(value = "住院期间病情：疑难  1是 2否")
    @JsonProperty("CH0A76")
    private Integer CH0A76;

    @Column(name = "CH0A31")
    @ApiModelProperty(value = "第几天确诊 数字输入")
    @JsonProperty("CH0A31")
    private Integer CH0A31;

    @Column(name = "CH0AC9")
    @ApiModelProperty(value = "出院诊断疑诊标志  1是 2否")
    @JsonProperty("CH0AC9")
    private Integer CH0AC9;

 /*   @Column(name="CH0A69DM")
    @ApiModelProperty(value = "质控护士代码,下拉人员数据" )
    @JsonProperty("CH0A69DM")
    private String CH0A69DM;*/

    @Column(name = "CH0AB3")
    @ApiModelProperty(value = "研究生实习医师,下拉人员数据")
    @JsonProperty("CH0AB3")
    private String CH0AB3;

    @Column(name = "CH0AB3DM")
    @ApiModelProperty(value = "研究生实习医师代码,下拉人员数据")
    @JsonProperty("CH0AB3DM")
    private String CH0AB3DM;

    @Column(name = "CH0ACG")
    @ApiModelProperty(value = "接诊医师,下拉人员数据")
    @JsonProperty("CH0ACG")
    private String CH0ACG;

    @Column(name = "CH0ACGDM")
    @ApiModelProperty(value = "接诊医师代码,下拉人员数据")
    @JsonProperty("CH0ACGDM")
    private String CH0ACGDM;

    @Column(name = "CH0ACH")
    @ApiModelProperty(value = "会诊医师,下拉人员数据")
    @JsonProperty("CH0ACH")
    private String CH0ACH;

    @Column(name = "CH0ACHDM")
    @ApiModelProperty(value = "会诊医师代码,下拉人员数据")
    @JsonProperty("CH0ACHDM")
    private String CH0ACHDM;

/*    @Column(name="CH0A43")
    @ApiModelProperty(value = "门出诊断符合标志,1符合  2不符合  3不确定 0 未做" )
    @JsonProperty("CH0A43")
    private Integer CH0A43;*/

/*
    @Column(name="CH0A44")
    @ApiModelProperty(value = "入出诊断符合标志 ,1符合  2不符合  3不确定 0 未做 " )
    @JsonProperty("CH0A44")
    private Integer CH0A44;
*/

/*
    @Column(name="CH0ACD")
    @ApiModelProperty(value = "手术前后诊断符合标志 ,1符合  2不符合  3不确定 0 未做" )
    @JsonProperty("CH0ACD")
    private Integer CH0ACD;
*/

/*    @Column(name="CH0AC1")
    @ApiModelProperty(value = "临床与病理诊断符合标志,1符合  2不符合  3不确定 0 未做" )
    @JsonProperty("CH0AC1")
    private Integer CH0AC1;*/

/*    @Column(name="CH0AC2")
    @ApiModelProperty(value = "放射与病理诊断符合标志,1符合  2不符合  3不确定 0 未做" )
    @JsonProperty("CH0AC2")
    private Integer CH0AC2;*/

/*    @Column(name="CH0A46")
    @ApiModelProperty(value = "抢救次数,数字输入" )
    @JsonProperty("CH0A46")
    private Integer CH0A46;*/

/*    @Column(name="CH0A47")
    @ApiModelProperty(value = "成功次数,数字输入" )
    @JsonProperty("CH0A47")
    private Integer CH0A47;*/

    @Column(name = "CH0A48")
    @ApiModelProperty(value = "随诊:1是 2否")
    @JsonProperty("CH0A48")
    private Integer CH0A48;

    @Column(name = "CH0A49")
    @ApiModelProperty(value = "随诊期限,数字输入")
    @JsonProperty("CH0A49")
    private Integer CH0A49;

    @Column(name = "CH0ACE")
    @ApiModelProperty(value = "随诊期限单位,下拉:0天 1周 2月 3年 ")
    @JsonProperty("CH0ACE")
    private Integer CH0ACE;

    @Column(name = "CH0A50")
    @ApiModelProperty(value = "示教病例 1是 2否 ")
    @JsonProperty("CH0A50")
    private Integer CH0A50;

    @Column(name = "CH0A53")
    @ApiModelProperty(value = "手术标志 1有 2无 0未知")
    @JsonProperty("CH0A53")
    private Integer CH0A53;

/*    @Column(name="CH0A54")
    @ApiModelProperty(value = "医院感染   1有 2无 0未知")
    @JsonProperty("CH0A54")
    private Integer CH0A54;*/


    @Column(name = "CH0A57")
    @ApiModelProperty(value = "输血情况 0未输 1有 2无")
    @JsonProperty("CH0A57")
    private Integer CH0A57;

    @Column(name = "CH0A58")
    @ApiModelProperty(value = "输液情况 0未输 1有 2无")
    @JsonProperty("CH0A58")
    private Integer CH0A58;


    @Column(name = "CH0A62")
    @ApiModelProperty(value = "科研病例 1是 2否")
    @JsonProperty("CH0A62")
    private Integer CH0A62;

    @Column(name = "CH0A63")
    @ApiModelProperty(value = "抢救方法 1中医 2西医 3中西医 ")
    @JsonProperty("CH0A63")
    private Integer CH0A63;

/*
    @Column(name="Ch0AJ1")
    @ApiModelProperty(value = "特级护理天数(之前是 是否,小徐建议修改成天数,是否的没有用了)," )
    @JsonProperty("")
    private Integer Ch0AJ1;

    @Column(name="Ch0AJ2")
    @ApiModelProperty(value = "一级护理天数(之前是 是否,小徐建议修改成天数,是否的没有用了)," )
    @JsonProperty("")
    private Integer Ch0AJ2;

    @Column(name="Ch0AJ3")
    @ApiModelProperty(value = "二级护理天数(之前是 是否,小徐建议修改成天数,是否的没有用了)," )
    @JsonProperty("")
    private Integer Ch0AJ3;
*/

    @Column(name = "CH0A66")
    @ApiModelProperty(value = "特别护理天数")
    @JsonProperty("CH0A66")
    private Integer CH0A66;

    @Column(name = "CH0A67")
    @ApiModelProperty(value = "一级护理天数")
    @JsonProperty("CH0A67")
    private Integer CH0A67;

    @Column(name = "CH0A68")
    @ApiModelProperty(value = "二级护理天数")
    @JsonProperty("CH0A68")
    private Integer CH0A68;

    @Column(name = "Ch0AJ4")
    @ApiModelProperty(value = "三级护理天数(之前是 是否,小徐建议修改成天数,是否的没有用了),")
    @JsonProperty("Ch0AJ4")
    private Integer Ch0AJ4;

    @Column(name = "CH0A77_Desc")
    @ApiModelProperty(value = "肿瘤编码（ICD_M）,选择肿瘤编码库")
    @JsonProperty("CH0A77_Desc")
    private String CH0A77_Desc;

    @Column(name = "CH0A80")
    @ApiModelProperty(value = "归档号,文本(20个字符串)")
    @JsonProperty("CH0A80")
    private String CH0A80;
/*
    @Column(name="CH0AB8")
    @ApiModelProperty(value = "再转科别,下拉科室" )
    @JsonProperty("CH0AB8")
    private String CH0AB8;

    @Column(name="CH0AB9")
    @ApiModelProperty(value = "再转科别日期,日期时间(时分秒)" )
    @JsonProperty("CH0AB9")
    private Date CH0AB9;*/

    @Column(name = "CH0AC3")
    @ApiModelProperty(value = "手术为本院第一例标志 1是 2否")
    @JsonProperty("CH0AC3")
    private Integer CH0AC3;

    @Column(name = "CH0ACA")
    @ApiModelProperty(value = "治疗为本院第一例标志 1是 2否")
    @JsonProperty("CH0ACA")
    private Integer CH0ACA;

    @Column(name = "CH0ACB")
    @ApiModelProperty(value = "检查为本院第一例标志 1是 2否")
    @JsonProperty("CH0ACB")
    private Integer CH0ACB;

    @Column(name = "CH0ACC")
    @ApiModelProperty(value = "诊断为本院第一例标志 1是 2否")
    @JsonProperty("CH0ACC")
    private Integer CH0ACC;

    @Column(name = "CH0AC4")
    @ApiModelProperty(value = "外来患者标志  1是 2否")
    @JsonProperty("CH0AC4")
    private Integer CH0AC4;

    @Column(name = "CH0AC6")
    @ApiModelProperty(value = "HBsAg--(乙肝) ,0 未做 1阴性 2阳性")
    @JsonProperty("CH0AC6")
    private Integer CH0AC6;

    @Column(name = "CH0AC7")
    @ApiModelProperty(value = "丙肝HCV-Ab,0 未做 1阴性 2阳性")
    @JsonProperty("CH0AC7")
    private Integer CH0AC7;

    @Column(name = "CH0AC8")
    @ApiModelProperty(value = "HIV-Ab,0 未做 1阴性 2阳性")
    @JsonProperty("CH0AC8")
    private Integer CH0AC8;

    @Column(name = "CH0AD3")
    @ApiModelProperty(value = "上级医师指导情况 1好 2中 3差")
    @JsonProperty("CH0AD3")
    private Integer CH0AD3;

    @Column(name = "CH0AF1")
    @ApiModelProperty(value = "精神障碍分类代码,下拉精神障碍代码库(续姐导一下帮忙)")
    @JsonProperty("CH0AF1")
    private String CH0AF1;

    @Column(name = "CH0AF1_desc")
    @ApiModelProperty(value = "精神障碍名称")
    @JsonProperty("CH0AF1_desc")
    private String CH0AF1_desc;

    @Column(name = "Ch0AH1")
    @ApiModelProperty(value = "抗生素使用 0未知 1有 2无")
    @JsonProperty("Ch0AH1")
    private Integer Ch0AH1;

    @Column(name = "Ch0AH2")
    @ApiModelProperty(value = "抗生素使用目的 1预防  2治疗 ")
    @JsonProperty("Ch0AH2")
    private Integer Ch0AH2;

    @Column(name = "Ch0AH3")
    @ApiModelProperty(value = "抗生素使用方案 1单独用药 2联合用药")
    @JsonProperty("Ch0AH3")
    private Integer Ch0AH3;

    @Column(name = "Ch0AH4")
    @ApiModelProperty(value = "抗生素使用天数 ")
    @JsonProperty("Ch0AH4")
    private Integer Ch0AH4;

    @Column(name = "Ch0AH5")
    @ApiModelProperty(value = "合并症  0未知 1有 2无")
    @JsonProperty("Ch0AH5")
    private Integer Ch0AH5;

    @Column(name = "Ch0AH6")
    @ApiModelProperty(value = "并发症  0未知 1有 2无")
    @JsonProperty("Ch0AH6")
    private Integer Ch0AH6;
/*
    @Column(name="Ch0AH7")
    @ApiModelProperty(value = "传染病报告 1已报 2未报")
    @JsonProperty("Ch0AH7")
    private Integer Ch0AH7;*/

    @Column(name = "CH0ACF")
    @ApiModelProperty(value = "服务半径 1本区 2本市  3 本省 4省外  ,根据医院行政区划和填写的病人情况自动判断")
    @JsonProperty("CH0ACF")
    private Integer CH0ACF;

    @Column(name = "Ch0A42")
    @ApiModelProperty(value = "诊断个数 , 数字(有几个诊断)")
    @JsonProperty("Ch0A42")
    private Integer Ch0A42;

    @Column(name = "Ch0A42_ss")
    @ApiModelProperty(value = "手术个数 , 数字(有几个手术)")
    @JsonProperty("Ch0A42_ss")
    private Integer Ch0A42_ss;

    @Column(name = "Ch0ABD")
    @ApiModelProperty(value = "诊疗小组,下拉病案上自己维护的小组")
    @JsonProperty("Ch0ABD")
    private String Ch0ABD;

    @Column(name = "Ch0AI2")
    @ApiModelProperty(value = "农村合作医疗救助对象 1是 2否")
    @JsonProperty("Ch0AI2")
    private Integer Ch0AI2;

    @Column(name = "Ch0AI3")
    @ApiModelProperty(value = "临床路径 1完成 2变异  3退出 4未入")
    @JsonProperty("Ch0AI3")
    private Integer Ch0AI3;


    @Column(name = "Ch0ACI")
    @ApiModelProperty(value = "会诊次数  数字输入")
    @JsonProperty("Ch0ACI")
    private Integer Ch0ACI;

    @Column(name = "Ch0AH8")
    @ApiModelProperty(value = "呼吸机使用天数 数字输入  ")
    @JsonProperty("Ch0AH8")
    private Integer Ch0AH8;

    @Column(name = "Ch0AH9")
    @ApiModelProperty(value = "肿瘤分期(T) 0 0期 1 I期 2 II期 3 III期  4 IV期   9不详   ")
    @JsonProperty("Ch0AH9")
    private Integer Ch0AH9;

    @Column(name = "Ch0AHA")
    @ApiModelProperty(value = "肿瘤分期(N) 0 0期 1 I期 2 II期 3 III期  4 IV期   9不详  ")
    @JsonProperty("Ch0AHA")
    private Integer Ch0AHA;

    @Column(name = "Ch0AHB")
    @ApiModelProperty(value = "肿瘤分期(M) 0 0期 1 I期 2 II期 3 III期  4 IV期   9不详  ")
    @JsonProperty("Ch0AHB")
    private Integer Ch0AHB;

    @Column(name = "Ch0AHC")
    @ApiModelProperty(value = "日常生活能力评定(入院) ,分值数字")
    @JsonProperty("Ch0AHC")
    private Integer Ch0AHC;

    @Column(name = "Ch0AHD")
    @ApiModelProperty(value = "日常生活能力评定(出院),分值数字")
    @JsonProperty("Ch0AHD")
    private Integer Ch0AHD;

    @Column(name = "CH0AQ1")
    @ApiModelProperty(value = "医院感染总次数,数字只能两位小于99")
    @JsonProperty("CH0AQ1")
    private Integer CH0AQ1;

    @Column(name = "CH0AQ2")
    @ApiModelProperty(value = "过敏源  ,下拉 01 镇静麻醉剂过敏 02 动物毛发过敏 03 抗生素过敏 04 柑橘类水果过敏 05 室内灰尘过敏 06鸡蛋过敏 07鱼及贝壳类食物过敏 08碘过敏 09牛奶的过敏 10带壳的果仁过敏 11花粉过敏 99 其他过敏")
    @JsonProperty("CH0AQ2")
    private String CH0AQ2;

    @Column(name = "CH0AQ3")
    @ApiModelProperty(value = "最高诊断依据 ,下拉 1 临床 2 X线、CT、超声波、内窥镜等 3 手术 4生化、免疫 5细胞学、血片 6 病理 8尸检(有病理) 9 不详 ")
    @JsonProperty("CH0AQ3")
    private String CH0AQ3;

    @Column(name = "CH0AQ4")
    @ApiModelProperty(value = "分化程度 ,下拉 1 高分化 2中分化 3低分化 4未分化 9 未确定")
    @JsonProperty("CH0AQ4")
    private String CH0AQ4;

/*    @Column(name="CH0AQ6")
    @ApiModelProperty(value = "手术冰冻与石蜡病理 ,1符合  2不符合  3不确定 0 未做" )
    @JsonProperty("CH0AQ6")
    private Integer CH0AQ6;*/

    @Column(name = "Ch0AHH")
    @ApiModelProperty(value = "损伤中毒2 下拉 损伤中毒代码库(主表有)")
    @JsonProperty("Ch0AHH")
    private String Ch0AHH;

    @Column(name = "Ch0AHH_desc")
    @ApiModelProperty(value = "损伤中毒2  名称")
    @JsonProperty("Ch0AHH_desc")
    private String Ch0AHH_desc;

    @Column(name = "Ch0AHI")
    @ApiModelProperty(value = "损伤中毒3  下拉 损伤中毒代码库(主表有)")
    @JsonProperty("Ch0AHI")
    private String Ch0AHI;

    @Column(name = "Ch0AHI_desc")
    @ApiModelProperty(value = "损伤中毒3 名称")
    @JsonProperty("Ch0AHI_desc")
    private String Ch0AHI_desc;


    @Column(name = "CH0ABarcode")
    @ApiModelProperty(value = "病人条码,自己录")
    @JsonProperty("CH0ABarcode")
    private String CH0ABarcode;

    @Column(name = "CH0AHBL2")
    @ApiModelProperty(value = "病理号2 输入框20")
    @JsonProperty("CH0AHBL2")
    private String CH0AHBL2;

    @Column(name = "CH0AHBL2_Desc")
    @ApiModelProperty(value = "病理诊断2 名称 下拉 病理诊断")
    @JsonProperty("CH0AHBL2_Desc")
    private String CH0AHBL2_Desc;

    @Column(name = "CH0AHBLICD2")
    @ApiModelProperty(value = "病理诊断编码2 下拉 病理诊断")
    @JsonProperty("CH0AHBLICD2")
    private String CH0AHBLICD2;
/*
    @Column(name="ch0ACL")
    @ApiModelProperty(value = "病理诊断唯一码2  下拉 病理诊断 uuid" )
    @JsonProperty("ch0ACL")
    private String ch0ACL;*/

    @Column(name = "CH0AHBL3")
    @ApiModelProperty(value = "病理号3")
    @JsonProperty("CH0AHBL3")
    private String CH0AHBL3;

    @Column(name = "CH0AHBL3_Desc")
    @ApiModelProperty(value = "病理诊断3 名称 下拉 病理诊断")
    @JsonProperty("CH0AHBL3_Desc")
    private String CH0AHBL3_Desc;

    @Column(name = "CH0AHBLICD3")
    @ApiModelProperty(value = "病理诊断编码3 下拉 病理诊断")
    @JsonProperty("CH0AHBLICD3")
    private String CH0AHBLICD3;

/*    @Column(name="ch0ACM")
    @ApiModelProperty(value = "病理诊断唯一码3 下拉 病理诊断 uuid" )
    @JsonProperty("ch0ACM")
    private String ch0ACM;*/

    @Column(name = "CH0AHSSLX")
    @ApiModelProperty(value = "手术患者类型 0非手术患者  1急诊 2择期")
    @JsonProperty("CH0AHSSLX")
    private Integer CH0AHSSLX;

  /*  @Column(name="CH0AHDYL")
    @ApiModelProperty(value = "手术、治疗、检查、诊断为本院第一例 1是 2否" )
    @JsonProperty("CH0AHDYL")
    private Integer CH0AHDYL;*/
/*
    @Column(name="CH0AHweight2")
    @ApiModelProperty(value = "新生儿体重2,数字4位g" )
    @JsonProperty("CH0AHweight2")
    private String CH0AHweight2;

    @Column(name="CH0AHweight3")
    @ApiModelProperty(value = "新生儿体重3,数字4位g" )
    @JsonProperty("CH0AHweight3")
    private String CH0AHweight3;

    @Column(name="CH0AHweight4")
    @ApiModelProperty(value = "新生儿体重4,数字4位g" )
    @JsonProperty("CH0AHweight4")
    private String CH0AHweight4;

    @Column(name="CH0AHweight5")
    @ApiModelProperty(value = "新生儿体重5,数字4位g" )
    @JsonProperty("CH0AHweight5")
    private String CH0AHweight5;*/

    @Column(name = "CH0AHBXKH")
    @ApiModelProperty(value = "医疗保险手册卡号 录入")
    @JsonProperty("CH0AHBXKH")
    private String CH0AHBXKH;

//    @Column(name="CH0AAB")
//    @ApiModelProperty(value = "其他医疗机构转入名称  输入汉" )
//    @JsonProperty("CH0AAB")
//    private String CH0AAB;

/*

    @Column(name="CH0ASevere")
    @ApiModelProperty(value = "患者入住重症监护病房" )
    @JsonProperty("CH0ASevere")
    private String CH0ASevere;

*/

    @Column(name = "CH0A35")
    @JsonProperty("CH0A35")
    @ApiModelProperty(value = "门诊医师", position = 2)
    private String CH0A35;

    @Column(name = "CH0A35DM")
    @JsonProperty("CH0A35DM")
    @ApiModelProperty(value = "门诊医师代码", position = 2)
    private String CH0A35DM;

/*
    @Column(name="CH0A20")
    @JsonProperty("CH0A20")
    @ApiModelProperty(value = "入院情况", position = 2)
    private String CH0A20;
*/

    @Column(name = "CH0AB7")
    @JsonProperty("CH0AB7")
    @ApiModelProperty(value = "转科日期", position = 2)
    private java.util.Date CH0AB7;


    @Column(name = "CH0A37")
    @JsonProperty("CH0A37")
    @ApiModelProperty(value = "入院诊断代码", position = 2)
    private String CH0A37;

    @Column(name = "CH0A37_Desc")
    @JsonProperty("CH0A37_Desc")
    @ApiModelProperty(value = "入院诊断名称", position = 2)
    private String CH0A37_Desc;


    @Column(name = "CH0A64")
    @JsonProperty("CH0A64")
    @ApiModelProperty(value = "入院诊断（ICD_10）", position = 2)
    private String CH0A64;

    /*  @Column(name="CH0A41")
      @JsonProperty("CH0A41")
      @ApiModelProperty(value = "转归（西医主诊断）", position = 2)
      private String CH0A41;
  */
/*

    @Column(name="CH0A41_desc")
    @JsonProperty("CH0A41_desc")
    @ApiModelProperty(value = "转归（西医主诊断）", position = 2)
    private String CH0A41_desc;
*/
    @Column(name = "CYSJ")
    @ApiModelProperty(value = "出院日期")
    @JsonProperty("CYSJ")
    private Date CYSJ;

    @Column(name = "jcf")
    @ApiModelProperty(value = "检查费")
    @JsonProperty("jcf")
    private Double jcf;
    @Column(name = "hyf")
    @ApiModelProperty(value = "化验费")
    @JsonProperty("hyf")
    private Double hyf;
    @Column(name = "cause_death")
    @ApiModelProperty(value = "直接死亡原因")
    @JsonProperty("cause_death")
    private String cause_death;

    @Column(name = "CH0MDD")
    @ApiModelProperty(value = "不足28天年龄（天）")
    @JsonProperty("CH0MDD")
    private String CH0MDD;

    @Column(name = "CH0MHBLICD2_MC")
    @ApiModelProperty(value = "病理诊断编码2名称")
    @JsonProperty("CH0MHBLICD2_MC")
    private String CH0MHBLICD2_MC;

    @Column(name = "CH0MHBLICD3_MC")
    @ApiModelProperty(value = "病理诊断编码2名称")
    @JsonProperty("CH0MHBLICD3_MC")
    private String CH0MHBLICD3_MC;

    @Column(name = "CH0MCJ")
    @ApiModelProperty(value = "医院自定义型病人来源")
    @JsonProperty("CH0MCJ")
    private String CH0MCJ;


    @Column(name = "CH0MJS03")
    @ApiModelProperty(value = "是否日间手术病例")
    @JsonProperty("CH0MJS03")
    private String CH0MJS03;


    @Column(name = "unplan2ndOperation")
    @ApiModelProperty(value = "非计划再次手术")
    @JsonProperty("unplan2ndOperation")
    private String unplan2ndOperation;

    @Column(name = "unplan2ndHospitalization")
    @ApiModelProperty(value = "非计划再次住院")
    @JsonProperty("unplan2ndHospitalization")
    private String unplan2ndHospitalization;

}
