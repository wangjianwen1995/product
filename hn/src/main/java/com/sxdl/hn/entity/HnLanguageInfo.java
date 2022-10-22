package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "language_info", description = "外语能力")
@Entity
@Data
@Table(name = "language_info")

public class HnLanguageInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "外语种类")
    private String type;

    @ApiModelProperty(value = " 备注信息")
    private String remarks;

    @ApiModelProperty(value = "外语等级")
    private String language_level;

    @ApiModelProperty(value = "外语url")
    private String language_path;

    @ApiModelProperty(value = "文件名")
    private String language_name;

}
