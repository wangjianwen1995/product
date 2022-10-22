package com.sxdl.hpqc.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_control_wzx", description = "完整性质控维护(质控维护表)")
@Entity
@Data
@Table(name="drplus_control_wzx")
public class DrPlusControlWzx implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;
    @ApiModelProperty(value = "分类")
    private String classify;

    @ApiModelProperty(value = "质控sql")
    private String sql;

    @ApiModelProperty(value = "质控结果")
    private String result_message;

    @ApiModelProperty(value = "1 强制 2 提示")
    private Integer termlevel;

    @ApiModelProperty(value = "创建时间")
    private String create_time;


    @ApiModelProperty(value = "锚点字段")
    private String field_name;


    @ApiModelProperty(value = "所属表:分表操作时候需要标识  a b c d")
    private String belong;

    @ApiModelProperty(value = "1 启用 0 停用")
    private Integer isqy;


}
