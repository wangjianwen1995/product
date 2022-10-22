package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_index_remind", description = "首页提醒")
@Entity
@Data
@Table(name="drplus_index_remind")
public class DrplusIndexRemind implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "状态: 1 完成 0 未完成  -1过期 ")
    private Integer states;

    @ApiModelProperty(value = "唯一键 规则")
    private String id_rule;

    @ApiModelProperty(value = "平台首页上报提醒cron 规则")
    private String cron;

    @ApiModelProperty(value = "提醒内容")
    private String contentinfo;



    @ApiModelProperty(value = "修改操作时间")
    private String operate_time;


    @ApiModelProperty(value = "创建时间")
    private String create_time;

    /*
    @Transient
    private Integer isqy;
*/

}
