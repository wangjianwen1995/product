package com.sxdl.report.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drColumn", description = "表字段管理")
@Entity
@Data
@Table(name = "dr_column")
public class DrColumn {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "字段名称", position = 2)
    @NotBlank(message = "字段名称不能为空")
    private String name;

    @ApiModelProperty(value = "字段英文名称", position = 2)
    @NotBlank(message = "字段英文名称不能为空")
    private String name_zh;

    @ApiModelProperty(value = "字段类型", position = 4)
    @NotBlank(message = "字段类型不能为空")
    private Integer column_type;

    @ApiModelProperty(value = "字段长度", position = 5)
    @NotBlank(message = "字段长度不能为空")
    private Integer size;

    @ApiModelProperty(value = "字段小数位数", position = 6)
    @NotBlank(message = "小数位数不能为空")
    private Integer scale;

    @ApiModelProperty(value = "关联table的ID", position = 7)
    @NotBlank(message = "关联table的ID不能为空")
    private Integer table_id;


}
