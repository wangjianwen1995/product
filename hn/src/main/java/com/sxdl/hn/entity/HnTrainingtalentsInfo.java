package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "trainingtalents_info", description = "培养人才情况登记")
@Entity
@Data
@Table(name = "trainingtalents_info")

public class HnTrainingtalentsInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "startTime")
    private String start_time;

    @ApiModelProperty(value = "endTime")
    private String end_time;

    @ApiModelProperty(value = "指导研究生")
    private String guidance;

    @ApiModelProperty(value = "指导内容成果")
    private String guidance_content;

    @ApiModelProperty(value = "url")
    private String culture_path;

    @ApiModelProperty(value = "文件名")
    private String culture_name;

}
