package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 */
@ApiModel(value = "dc_etl_log", description = "ETL日志")
@Entity
@Data
@Table(name = "dc_etl_log")
public class DcEtlLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "状态", position = 2)
    //状态,1执行中;2结束;3中断;4重新执行中;5重新执行结束
    private Integer status;

    @ApiModelProperty(value = "启动时间", position = 3)
    @Column(name = "start_time")
    private String startTime;

    @ApiModelProperty(value = "结束时间", position = 4)
    @Column(name = "end_time")
    private String endTime;

    @ApiModelProperty(value = "内容", position = 5)
    private String content;

    @ApiModelProperty(value = "耗时", position = 6)
    private String duration;

    @ApiModelProperty(value = "调度id", position = 7)
    @Column(name = "schedule_id")
    private String scheduleId;

    @ApiModelProperty(value = "工单id", position = 8)
    @Column(name = "job_id")
    private String jobId;

    @ApiModelProperty(value = "调度规则id", position = 9)
    @Column(name = "schedule_rule_id")
    private Integer scheduleRuleId;

    @ApiModelProperty(value = "调度规则说明", position = 10)
    @Column(name = "schedule_rule_suffix")
    private String scheduleRuleSffix;

    @ApiModelProperty(value = "错误sql", position = 10)
    @Column(name = "debug_sql")
    private String debugSql;


    @ApiModelProperty(value = "修改时间", position = 7)
    @Column(name = "update_time")
    private String updateTime;

    @ApiModelProperty(value = "修改原因", position = 7)
    @Column(name = "update_cause")
    private String updateCause;

    @ApiModelProperty(value = "存储id/webid", position = 8)
    @Column(name = "exec_id")
    private String execId;

    @ApiModelProperty(value = "产品id", position = 8)
    @Column(name = "product_id")
    private String productId;

    @ApiModelProperty(value = "抽取条数", position = 8)
    @Column(name = "etl_num")
    private Integer etlnum;

    @ApiModelProperty(value = "新增条数", position = 8)
    @Column(name = "ins_num")
    private Integer insnum;

    @ApiModelProperty(value = "更新条数", position = 8)
    @Column(name = "upda_num")
    private Integer updanum;

    @ApiModelProperty(value = "删除条数", position = 8)
    @Column(name = "del_num")
    private Integer delnum;

    @ApiModelProperty(value = "批次", position = 8)
    @Column(name = "batch")
    private Integer batch;




}