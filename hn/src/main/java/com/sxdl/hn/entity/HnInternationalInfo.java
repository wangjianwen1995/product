package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "international_info", description = "出国短期学习、考察及参加国际学术活动等情况")
@Entity
@Data
@Table(name="international_info")

public class HnInternationalInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "id")
    private Integer pid;

    @ApiModelProperty(value = "id")
    private String time;

    @ApiModelProperty(value = "国家")
    private String country;

    @ApiModelProperty(value = "地点")
    private String place;

    @ApiModelProperty(value = "学习内容")
    private String learning_content;

    @ApiModelProperty(value = "单位")
    private String util;

    @ApiModelProperty(value = "url")
    private String international_path;
    @ApiModelProperty(value = "文件名称")
    private String international_name;

}
