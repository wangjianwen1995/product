package com.sxdl.hn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ApiModel(value = "award_info", description = "档案:创造发明、科研成果和技术业务工作授奖登记")
@Entity
@Data
@Table(name="award_info")
public class HnAwardInfo {

    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "time")
    private String time;

    @ApiModelProperty(value = "内容提要")
    private String award_content;

    @ApiModelProperty(value = "奖励形式")
    private String rewardform;

    @ApiModelProperty(value = "批准机关")
    private String approval_authority;

    @ApiModelProperty(value = "url")
    private String award_path;

    @ApiModelProperty(value = "文件名称")
    private String award_name;

}
