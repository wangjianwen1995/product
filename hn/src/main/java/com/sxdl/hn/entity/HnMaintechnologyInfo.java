package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "maintechnology_info", description = "担任过得主要技术工作")
@Entity
@Data
@Table(name = "maintechnology_info")
public class HnMaintechnologyInfo {
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "结束时间")
    private String end_time;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "担任工作内容及职务")
    private String work_content;

    @ApiModelProperty(value = "结果效率情况")
    private String result_content;

    @ApiModelProperty(value = "url")
    private String main_path;

    @ApiModelProperty(value = "文件名称")
    private String main_name;

}
