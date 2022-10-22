package com.sxdl.hpqc.dbo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class DrQualityDBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;


    @ApiModelProperty(value = "drplus_platform_detailed_id")
    private Integer drplus_platform_detailed_id;

    @NotNull(message = "分类不能为空")
    @ApiModelProperty(value = "分类")
    private String classify;
    @NotNull(message = "质控sql不能为空")
    @ApiModelProperty(value = "质控sql")
    private String sql;
    @NotNull(message = "质控结果不能为空")
    @ApiModelProperty(value = "质控结果")
    private String result_message;

    @NotNull(message = "质控强度不能为空")
    @ApiModelProperty(value = "1 强制 2 提示")
    private Integer termlevel;

    @ApiModelProperty(value = "创建时间")
    private String create_time;


    @ApiModelProperty(value = "锚点")
    private String field_name;


    @ApiModelProperty(value = "所属表:分表操作时候需要标识  a b c d")
    private String belong;


    @NotNull(message = "质控类型不能为空")
    @ApiModelProperty(value = "质控类型 1 标准 2完整 3逻辑")
    private Integer type;

    @ApiModelProperty(value = "启用停用")
    private Integer isqy;




}
