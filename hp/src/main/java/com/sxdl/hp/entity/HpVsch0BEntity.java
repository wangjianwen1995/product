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
import java.util.Date;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VSCH0B")
@ApiModel(value = "VSCH0B", description = "病案患者费用表")
public class HpVsch0BEntity {

    @Column(name="CHYear")
    @JsonProperty("CHYear")
    @ApiModelProperty(value = "病案年度")
    private String CHYear;

    @Column(name="CH0B01")
    @JsonProperty("CH0B01")
    @ApiModelProperty(value = "病案号")
    private String CH0B01;

    @Column(name="CH0B83")
    @JsonProperty("CH0B83")
    @ApiModelProperty(value = "住院总费用")
    private Double CH0B83;

    @Column(name="CH0BP1")
    @JsonProperty("CH0BP1")
    @ApiModelProperty(value = "自付金额（子项）")
    private Double CH0BP1;

    @Column(name="CH0BP2")
    @JsonProperty("CH0BP2")
    @ApiModelProperty(value = "一般医疗服务费")
    private Double CH0BP2;

    @Column(name="CH0BP3")
    @JsonProperty("CH0BP3")
    @ApiModelProperty(value = "一般治疗操作费")
    private Double CH0BP3;
    @Column(name="CH0BP4")
    @JsonProperty("CH0BP4")
    @ApiModelProperty(value = "护理费")
    private Double CH0BP4;
    @Column(name="CH0BP5")
    @JsonProperty("CH0BP5")
    @ApiModelProperty(value = "一般医疗其他费用")
    private Double CH0BP5;
    @Column(name="CH0BP6")
    @JsonProperty("CH0BP6")
    @ApiModelProperty(value = "病理诊断费")
    private Double CH0BP6;
    @Column(name="CH0BP7")
    @JsonProperty("CH0BP7")
    @ApiModelProperty(value = "实验室诊断费")
    private Double CH0BP7;
    @Column(name="CH0BP8")
    @JsonProperty("CH0BP8")
    @ApiModelProperty(value = "影像学诊断费")
    private Double CH0BP8;
    @Column(name="CH0BP9")
    @JsonProperty("CH0BP9")
    @ApiModelProperty(value = "临床诊断项目费")
    private Double CH0BP9;
    @Column(name="CH0BPA")
    @JsonProperty("CH0BPA")
    @ApiModelProperty(value = "非手术治疗项目费")
    private Double CH0BPA;
    @Column(name="CH0BPB")
    @JsonProperty("CH0BPB")
    @ApiModelProperty(value = "临床物理治疗费（子项）")
    private Double CH0BPB;
    @Column(name="CH0BPC")
    @JsonProperty("CH0BPC")
    @ApiModelProperty(value = "手术治疗费")
    private Double CH0BPC;
    @Column(name="CH0BPD")
    @JsonProperty("CH0BPD")
    @ApiModelProperty(value = "麻醉费（子项）")
    private Double CH0BPD;
    @Column(name="CH0BPE")
    @JsonProperty("CH0BPE")
    @ApiModelProperty(value = "手术费（子项）")
    private Double CH0BPE;
    @Column(name="CH0BPF")
    @JsonProperty("CH0BPF")
    @ApiModelProperty(value = "康复费")
    private Double CH0BPF;
    @Column(name="CH0BPG")
    @JsonProperty("CH0BPG")
    @ApiModelProperty(value = "中医治疗费")
    private Double CH0BPG;
    @Column(name="CH0BPH")
    @JsonProperty("CH0BPH")
    @ApiModelProperty(value = "西药费")
    private Double CH0BPH;
    @Column(name="CH0BPI")
    @JsonProperty("CH0BPI")
    @ApiModelProperty(value = "抗菌药物费用（子项）")
    private Double CH0BPI;
    @Column(name="CH0BPJ")
    @JsonProperty("CH0BPJ")
    @ApiModelProperty(value = "中成药费")
    private Double CH0BPJ;
    @Column(name="CH0BPK")
    @JsonProperty("CH0BPK")
    @ApiModelProperty(value = "中草药费")
    private Double CH0BPK;
    @Column(name="CH0BPL")
    @JsonProperty("CH0BPL")
    @ApiModelProperty(value = "抗菌药物费用（子项）")
    private Double CH0BPL;
    @Column(name="CH0BPM")
    @JsonProperty("CH0BPM")
    @ApiModelProperty(value = "白蛋白类制品费")
    private Double CH0BPM;
    @Column(name="CH0BPN")
    @JsonProperty("CH0BPN")
    @ApiModelProperty(value = "球蛋白类制品费")
    private Double CH0BPN;
    @Column(name="CH0BPO")
    @JsonProperty("CH0BPO")
    @ApiModelProperty(value = "凝血因子类制品费")
    private Double CH0BPO;
    @Column(name="CH0BPP")
    @JsonProperty("CH0BPP")
    @ApiModelProperty(value = "细胞因子类制品费")
    private Double CH0BPP;
    @Column(name="CH0BPQ")
    @JsonProperty("CH0BPQ")
    @ApiModelProperty(value = "检查用一次性医用材料费")
    private Double CH0BPQ;
    @Column(name="CH0BPR")
    @JsonProperty("CH0BPR")
    @ApiModelProperty(value = "治疗用一次性医用材料费")
    private Double CH0BPR;
    @Column(name="CH0BPS")
    @JsonProperty("CH0BPS")
    @ApiModelProperty(value = "手术用一次性医用材料费")
    private Double CH0BPS;
    @Column(name="CH0BPT")
    @JsonProperty("CH0BPT")
    @ApiModelProperty(value = "其他费")
    private Double CH0BPT;
    @Column(name="Ch0BZ1")
    @JsonProperty("Ch0BZ1")
    @ApiModelProperty(value = "中医辨证论治费（子项）")
    private Double Ch0BZ1;
    @Column(name="Ch0BZ2")
    @JsonProperty("Ch0BZ2")
    @ApiModelProperty(value = "中医辨证论治会诊费（子项）")
    private Double Ch0BZ2;
    @Column(name="Ch0BZ3")
    @JsonProperty("Ch0BZ3")
    @ApiModelProperty(value = "中医诊断")
    private Double Ch0BZ3;
    @Column(name="Ch0BZ4")
    @JsonProperty("Ch0BZ4")
    @ApiModelProperty(value = "中医外治（子项）")
    private Double Ch0BZ4;
    @Column(name="Ch0BZ5")
    @JsonProperty("Ch0BZ5")
    @ApiModelProperty(value = "中医骨伤（子项）")
    private Double Ch0BZ5;
    @Column(name="Ch0BZ6")
    @JsonProperty("Ch0BZ6")
    @ApiModelProperty(value = "针刺与灸法（子项）")
    private Double Ch0BZ6;
    @Column(name="Ch0BZ7")
    @JsonProperty("Ch0BZ7")
    @ApiModelProperty(value = "中医推拿治疗（子项）")
    private Double Ch0BZ7;
    @Column(name="Ch0BZ8")
    @JsonProperty("Ch0BZ8")
    @ApiModelProperty(value = "中医肛肠治疗（子项）")
    private Double Ch0BZ8;
    @Column(name="Ch0BZ9")
    @JsonProperty("Ch0BZ9")
    @ApiModelProperty(value = "中医特殊治疗（子项）")
    private Double Ch0BZ9;
    @Column(name="Ch0BZA")
    @JsonProperty("Ch0BZA")
    @ApiModelProperty(value = "中医其他")
    private Double Ch0BZA;
    @Column(name="Ch0BZB")
    @JsonProperty("Ch0BZB")
    @ApiModelProperty(value = "中药特殊调配加工（子项）")
    private Double Ch0BZB;
    @Column(name="Ch0BZC")
    @JsonProperty("Ch0BZC")
    @ApiModelProperty(value = "辨证施膳（子项）")
    private Double Ch0BZC;
    @Column(name="Ch0BZD")
    @JsonProperty("Ch0BZD")
    @ApiModelProperty(value = "医疗机构中药制剂费（子项）")
    private Double Ch0BZD;

    @Id
    @Column(name="ID")
    @JsonProperty("ID")
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

}
