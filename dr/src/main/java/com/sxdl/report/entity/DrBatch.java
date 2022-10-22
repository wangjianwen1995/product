package com.sxdl.report.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drBatch", description = "上报批次信息")
@Entity
@Data
@Table(name = "dr_batch")
public class DrBatch {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "批次名称", position = 2)
    @NotBlank(message = "批次名称不能为空")
    private String name;

    @ApiModelProperty(value = "模板ID", position = 3)
    @NotBlank(message = "模板ID不能为空")
    private Integer template_id;

    @ApiModelProperty(value = "调度ID", position = 4)
    private Integer procdure_id;

    @ApiModelProperty(value = "调度名称", position = 5)
    private String procdure_name;

    @ApiModelProperty(value = "是否视图", position = 6)
    private Integer is_view;

    @ApiModelProperty(value = "视图名称", position = 7)
    private String view_name;

    @ApiModelProperty(value = "次数", position = 8)
    private Integer times;




}
