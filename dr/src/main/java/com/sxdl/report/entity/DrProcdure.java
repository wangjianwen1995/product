package com.sxdl.report.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drProcdure", description = "模板对应存储信息")
@Entity
@Data
@Table(name = "dr_procdure")
public class DrProcdure {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "存储名称", position = 2)
    private String name;

    @ApiModelProperty(value = "存储中文名称", position = 3)
    private String name_zh;

    @ApiModelProperty(value = "存储内容", position = 4)
    private String content;

    @ApiModelProperty(value = "模板ID", position = 5)
    private Integer template_id;

    @ApiModelProperty(value = "是否视图", position = 6)
    private Integer is_view;


}

