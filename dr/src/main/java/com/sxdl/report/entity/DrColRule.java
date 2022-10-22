package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drColRule", description = "表字段规则管理")
@Entity
@Data
@Table(name = "dr_col_rule")
public class DrColRule {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "规则名称", position = 2)
    @NotBlank(message = "规则名称不能为空")
    private String name;

    @ApiModelProperty(value = "规则值", position = 2)
    @NotBlank(message = "规则值不能为空")
    private String val;

    @ApiModelProperty(value = "字段格式", position = 2)
    @NotBlank(message = "字段格式不能为空")
    private String format;

    @ApiModelProperty(value = "对应字段ID", position = 2)
    @NotBlank(message = "对应字段ID")
    private Integer column_id;


}
