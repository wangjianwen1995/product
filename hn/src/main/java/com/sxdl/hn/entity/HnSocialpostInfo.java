package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "socialpost_info", description = "技术职称")
@Entity
@Data
@Table(name = "socialpost_info")
public class HnSocialpostInfo {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;
    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "结束时间")
    private String end_time;

    @ApiModelProperty(value = "兼职内容")
    private String content_post;

    @ApiModelProperty(value = "社会兼职url")
    private String post_path;

    @ApiModelProperty(value = "社会兼职url")
    private String post_name;

}
