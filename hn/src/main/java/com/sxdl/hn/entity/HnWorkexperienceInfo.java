package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "workexperience_info", description = "工作经历")
@Entity
@Data
@Table(name = "workexperience_info")
public class HnWorkexperienceInfo {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "time")
    private String time;

    @ApiModelProperty(value = "原任何职")
    private String workpost_old;

    @ApiModelProperty(value = "原工作单位")
    private String workunit_old;

    @ApiModelProperty(value = "现任何职 ")
    private String workpost_now;

    @ApiModelProperty(value = "现工作单位")
    private String workunit_now;

    @ApiModelProperty(value = "url")
    private String work_path;

    @ApiModelProperty(value = "文件名称")
    private String work_name;
}
