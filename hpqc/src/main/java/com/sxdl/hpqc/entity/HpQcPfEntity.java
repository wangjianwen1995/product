package com.sxdl.hpqc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "hp_qm_pf")
@ApiModel(value = "hp_qm_pf", description = "病案评分条件组")
public class HpQcPfEntity {

    @Column(name="id")
    @ApiModelProperty(value = "id")
    @KeySql(genId = UUIdGenId.class)
    @Id
    private String id;

    @Column(name="fields")
    @ApiModelProperty(value = "fields")
    private String fields;

    @Column(name="sqls")
    @ApiModelProperty(value = "sqls")
    private String sqls;

    @Column(name="message")
    @ApiModelProperty(value = "message")
    private String message;

    @Column(name="is_on")
    @ApiModelProperty(value = "is_on")
    private Integer is_on;

    @Column(name="can_forced")
    @ApiModelProperty(value = "can_forced")
    private Integer can_forced;

    @Column(name="classify")
    @ApiModelProperty(value = "classify")
    private String classify;

    @Column(name="classify_id")
    @ApiModelProperty(value = "classify_id")
    private Integer classify_id;

    @Column(name="ordernum")
    @ApiModelProperty(value = "ordernum")
    private Integer ordernum;

    @Column(name="fields_anchor")
    @ApiModelProperty(value = "fields_anchor")
    private String fields_anchor;

    @Column(name="group_name")
    @ApiModelProperty(value = "group_name")
    private String group_name;

    @Column(name="group_score")
    @ApiModelProperty(value = "group_score")
    private Double group_score;

    @Column(name="kind_name")
    @ApiModelProperty(value = "kind_name")
    private String kind_name;

    @Column(name="kind_score")
    @ApiModelProperty(value = "kind_score")
    private Double kind_score;

    @Column(name="is_west")
    @ApiModelProperty(value = "is_west")
    private Integer is_west;

    @Column(name="packages")
    @ApiModelProperty(value = "packages")
    private String packages;

    @Column(name="packages_score")
    @ApiModelProperty(value = "packages_score")
    private String packages_score;

    @Column(name="lever")
    @ApiModelProperty(value = "等级 1:vip,2:vip+;3:vip++")
    private String lever;
    @Column(name="home_fields")
    @ApiModelProperty(value = "sql用到的总表字段 用英文逗号隔开")
    private String home_fields;

    @Column(name="temp_sql")
    @ApiModelProperty(value = "临时sql")
    private String temp_sql;
    @Column(name = "link_on")
    @ApiModelProperty(value = "环节质控是否启用")
    private Integer link_on;
    @Column(name = "home_type")
    @ApiModelProperty(value = "首页信息类型") // 1：基本2：诊疗3：手术4：费用5：其他
    private Integer home_type;

}
