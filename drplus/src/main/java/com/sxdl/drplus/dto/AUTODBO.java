package com.sxdl.drplus.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AUTODBO {
    @ApiModelProperty(value = " 平台id")
    @NotNull(message = "平台外键不能为空")
    private Integer id;

    @ApiModelProperty(value = "平台名称")
    @NotNull(message = "平台名称不能为空")
    private String  name;


    @ApiModelProperty(value = "偏移量")
    @NotNull(message = "偏移量不能为空")
    private Integer offset;

    @ApiModelProperty(value = "执行天数")
    @NotNull(message = "抽取天数不能为空")
    private Integer e_days;

    @ApiModelProperty(value = "调度表达式")
    @NotNull(message = "调度表达式不能为空")
    private String  cron;

    @ApiModelProperty(value = "操作总开关")
    @NotNull(message = "开启状态不能为空")
    private Integer isopen;

    @NotNull(message = "开启状态不能为空")
    @ApiModelProperty(value = " 是否开启自动抽取 1 启用 0停用")
    private Integer is_autoextract;

    @NotNull(message = "开启状态不能为空")
    @ApiModelProperty(value = " 是否开启自动编码转换 1 启用 0停用")
    private Integer is_autocode;

    @NotNull(message = "开启状态不能为空")
    @ApiModelProperty(value = " 是否开启自动审核 1 启用 0停用")
    private Integer is_autoreview;
    @NotNull(message = "开启状态不能为空")
    @ApiModelProperty(value = " 是否开启自动审核 1 启用 0停用")
    private Integer is_autoreport;


}
