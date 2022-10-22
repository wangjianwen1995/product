package com.sxdl.hp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hp_mid_table")
@ApiModel(value = "hp_mid_table", description = "病案中间库表")
public class HpMidTableEntity implements Serializable {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private String id;

    @ApiModelProperty(value = "病历号/住院号", position = 2)
    private String blh;
    @ApiModelProperty(value = "病案号", position = 3)
    private String bah;
    @ApiModelProperty(value = "住院次数", position = 4)
    private String zycs;
    @ApiModelProperty(value = "患者姓名", position = 5)
    private String name;
    @ApiModelProperty(value = "患者性别", position = 6)
    private String xb;
    @ApiModelProperty(value = "出院科室", position = 7)
    private String cyks;
    @ApiModelProperty(value = "出院科室代码", position = 8)
    private String cyksdm;
    @ApiModelProperty(value = "住院医师", position = 9)
    private String zyys;
    @ApiModelProperty(value = "住院医师代码", position = 10)
    private String zyysdm;
    @ApiModelProperty(value = "出院日期", position = 11)
    private Date cyrq;
    @ApiModelProperty(value = "病例状态", position = 12)
    private Integer status;
    @ApiModelProperty(value = "归档时间", position = 13)
    private Date filetime;
    @ApiModelProperty(value = "接收人", position = 14)
    private String fileman;
    @ApiModelProperty(value = "归档天数", position = 15)
    private Integer fileday;
    @ApiModelProperty(value = "年度", position = 16)
    private Integer year;

    @Transient
    @ApiModelProperty(value = "操作人")
    private String user_name;

    @Transient
    @ApiModelProperty(value = "操作时间")
    private String time;

    @Transient
    @ApiModelProperty(value = "原因")
    private String reason;

    @Transient
    @ApiModelProperty(value = "主诊断")
    private String zzd;

    @Transient
    @ApiModelProperty(value = "主手术")
    private String zss;

    //FileService中需要根据个别字段判断相等,勿删勿改
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HpMidTableEntity that = (HpMidTableEntity) o;
        return Objects.equals(blh, that.blh) &&
                Objects.equals(zycs, that.zycs) &&
                Objects.equals(name, that.name) &&
                Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blh, bah, zycs, name, year);
    }
}
