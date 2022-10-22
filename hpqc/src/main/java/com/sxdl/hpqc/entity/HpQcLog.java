package com.sxdl.hpqc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_qm_log", description = "质控日志表")
@Entity
@Data
@Table(name = "hp_qm_log")
public class HpQcLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "出院时间-- 开始时间 ")
    private String start_cysj;

    @ApiModelProperty(value = "出院时间——截止时间")
    private String end_cysj;

    @ApiModelProperty(value = "质控时间")
    private String qc_time;

    @ApiModelProperty(value = "质控状态 1：成功  0 ：失败")
    private Integer status;
    @ApiModelProperty(value = "质控总数据量")
    private Integer total;

    @ApiModelProperty(value = "质控信息")
    private String qc_message;


}
