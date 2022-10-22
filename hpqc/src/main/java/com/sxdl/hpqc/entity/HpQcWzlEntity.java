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
@Table(name = "hp_qm_wzl")
@ApiModel(value = "hp_qm_wzl", description = "完整性指控条件组")
public class HpQcWzlEntity {

    @Column(name="id")
    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = UUIdGenId.class)
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

    @Column(name="orderum")
    @ApiModelProperty(value = "orderum")
    private Integer orderum;

    @Column(name="fields_anchor")
    @ApiModelProperty(value = "fields_anchor")
    private String fields_anchor; //fields_anchor

    @Column(name = "link_on")
    @ApiModelProperty(value = "环节质控是否启用")
    private Integer link_on;

    @Column(name = "platform_on")
    @ApiModelProperty(value = "规则适用哪些平台")
    private String platform_on;

    @Column(name = "home_type")
    @ApiModelProperty(value = "首页信息类型") // 1：基本2：诊疗3：手术4：费用5：其他
    private Integer home_type;

}
