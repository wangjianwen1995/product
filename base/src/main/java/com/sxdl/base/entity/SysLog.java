package com.sxdl.base.entity;

import com.sxdl.base.config.PrefixConfig;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Table(name = PrefixConfig.PREFIX+"sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;

    @ApiModelProperty(value = "级别", position = 2)
    private String level;

    @ApiModelProperty(value = "用户", position = 3)
    private Integer user_id;

    @ApiModelProperty(value = "操作", position = 4)
    private String operator;

    @ApiModelProperty(value = "内容", position = 5)
    private String content;

    @ApiModelProperty(value = "当前时间", position = 6)
    private String time;

    @ApiModelProperty(value = "用户名称", position = 7)
    private String name;

    @ApiModelProperty(value = "耗时", position = 8)
    private String use_time;

}