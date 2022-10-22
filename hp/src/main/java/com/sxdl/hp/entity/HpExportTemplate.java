package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "hp_exporttemplate", description = "导出模板")
@Entity
@Data
@Table(name="hp_exporttemplate")
public class HpExportTemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @NotNull(message = "用户id不能为空")
    @ApiModelProperty(value = "用户id")
    private Integer user_id;

    @NotBlank(message = "模板名称不能为空")
    @ApiModelProperty(value = "模板名称")
    private String name;


    @ApiModelProperty(value = "是否为默认导出模板")
    private Integer is_default;



}
