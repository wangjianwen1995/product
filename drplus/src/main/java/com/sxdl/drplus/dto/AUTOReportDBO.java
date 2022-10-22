package com.sxdl.drplus.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AUTOReportDBO {
    @ApiModelProperty(value = " 平台id")
    @NotNull(message = "平台外键不能为空")
    private Integer id;

     //TODO 这里上报 需要在名称后面加 "上报"
    @NotNull(message = "平台名称不能为空")
    @ApiModelProperty(value = "平台名称 加上报")
    private String  name;

    @ApiModelProperty(value = "偏移量")
    @NotNull(message = "偏移量不能为空")
    private Integer offset2;

    @ApiModelProperty(value = "执行天数")
    @NotNull(message = "抽取天数不能为空")
    private Integer e_days2;

    @ApiModelProperty(value = "调度表达式")
    @NotNull(message = "调度表达式不能为空")
    private String  cron2;

    @ApiModelProperty(value = "操作开启状态")
    @NotNull(message = "开启状态不能为空")
    private Integer isopen2;


}
