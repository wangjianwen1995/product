package com.sxdl.hn.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "academic_info", description = "档案:学术团体")
@Entity
@Data
@Table(name="academic_info")
public class HnAcademicInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "开始时间")
    private String start_time;

    @ApiModelProperty(value = "结束时间")
    private String ent_time;

    @ApiModelProperty(value = "学术团体名称")
    private String name;

    @ApiModelProperty(value = "担任职务")
    private String post;

    @ApiModelProperty(value = "学术团体url")
    private String academic_path;

    @ApiModelProperty(value = "学术团体文件名称")
    private String academic_name;

}
