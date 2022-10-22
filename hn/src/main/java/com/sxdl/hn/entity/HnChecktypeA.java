package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "checktype_a", description = "病人结果数据")
@Entity
@Data
@Table(name="checktype_a")
public class HnChecktypeA implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "病历号")
    private String blh;

    @ApiModelProperty(value = "住院号")
    private String zyh;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "得分")
    private Double care;

    @ApiModelProperty(value = "真实考核id")
    private Integer assessment_id;
}
