package com.sxdl.drplus.dto;

import com.sxdl.drplus.annotation.ValidKey;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SheduledDBO {
    @ApiModelProperty(value = "id")
    private Integer id;

    @NotNull(message = "平台名称不能为空")
    private String  pname;
    @NotNull(message = "偏移量不能为空")
    private Integer offset;
    @NotNull(message = "抽取天数不能为空")
    private Integer e_days;
    @NotNull(message = "调度表达式不能为空")
    private String  cron;

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
    @ApiModelProperty(value = " 是否开启自动上报 1 启用 0停用")
    private Integer is_autoreport;

    @ValidKey
    @ApiModelProperty(value = "验证码")
    private String key;
}
