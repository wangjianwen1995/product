package com.sxdl.hpqc.entity;

import com.sxdl.base.util.UUIdGenId;
import com.sxdl.hpqc.dbo.FieldAnchor;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "hp_qm_zh")
@ApiModel(value = "hp_qm_zh", description = "综合质控")
public class HpQcZhEntity {

    @Column(name = "id")
    @ApiModelProperty(value = "id")
    @KeySql(genId = UUIdGenId.class)
    @Id
    private String id;

    @Column(name = "fields")
    @ApiModelProperty(value = "fields")
    private String fields;

    @Column(name = "fields_anchor")
    @ApiModelProperty(value = "fields_anchor")
    private String fields_anchor;

    @Column(name = "sqls")
    @ApiModelProperty(value = "sqls")
    private String sqls;

    @Column(name = "message")
    @ApiModelProperty(value = "message")
    private String message;

    @Column(name = "is_on")
    @ApiModelProperty(value = "is_on")
    private Integer is_on;

    @Column(name = "can_forced")
    @ApiModelProperty(value = "can_forced")
    private Integer can_forced;

    @Column(name = "classify")
    @ApiModelProperty(value = "classify")
    private String classify;

    @Column(name = "classify_id")
    @ApiModelProperty(value = "classify_id")
    private Integer classify_id;

    @Column(name = "ordernum")
    @ApiModelProperty(value = "ordernum")
    private Integer ordernum;
    @Column(name = "connetType")
    @ApiModelProperty(value = "connetType")
    private String connetType;

    @Column(name = "lever")
    @ApiModelProperty(value = "等级 1:vip,2:vip+;3:vip++")
    private String lever;

    @Column(name = "home_fields")
    @ApiModelProperty(value = "sql用到的总表字段 用英文逗号隔开")
    private String home_fields;

    @Column(name = "anchor_mc")
    @ApiModelProperty(value = "锚点名称")
    private String anchor_mc;

    @Column(name = "link_on")
    @ApiModelProperty(value = "环节质控是否启用")
    private Integer link_on;

    @Column(name = "platform_on")
    @ApiModelProperty(value = "规则适用哪些平台")
    private String platform_on;

    @Column(name = "home_type")
    @ApiModelProperty(value = "首页信息类型") // 1：基本2：诊疗3：手术4：费用5：其他
    private Integer home_type;

    @Transient
    private List<FieldAnchor> anchorList;
}
