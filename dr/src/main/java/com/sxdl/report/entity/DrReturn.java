package com.sxdl.report.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "drReturn", description = "平台返回信息")
@Entity
@Data
@Table(name = "dr_return")
public class DrReturn {

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "模板ID", position = 2)
    @NotBlank(message = "模板ID")
    private Integer template_id;

    @ApiModelProperty(value = "模板名称", position = 3)
    @NotBlank(message = "模板名称不能为空")
    private String template_name;

    @ApiModelProperty(value = "结果值", position = 5)
    private String result_type;

    @ApiModelProperty(value = "返回内容", position = 6)
    private String result_content;

    @ApiModelProperty(value = "系统上报时间", position = 7)
    private String result_time;



}
