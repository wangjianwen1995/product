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

@ApiModel(value = "hp_error_log", description = "质控错误日志表")
@Entity
@Data
@Table(name = "hp_error_log")
public class HpErrorLog implements Serializable {
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

    @ApiModelProperty(value = "质控规则id")
    private String qm_id;
    @ApiModelProperty(value = "单个质控的主键id--bah")
    private String bz;

    @ApiModelProperty(value = "质控信息")
    private String qc_message;


}
