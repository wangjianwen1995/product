package com.sxdl.hp.entity;

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

@ApiModel(value = "hp_data_cancel", description = "启用/弃用记录表")
@Entity
@Data
@Table(name="hp_data_cancel")
public class HpDataCancel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @Column(name="id")
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "操作用户名")
    private String user_name;


    @ApiModelProperty(value = "操作用户id")
    private Integer user_id;

    @ApiModelProperty(value = "操作时间")
    private String time;


    @ApiModelProperty(value = "患者的aid")
    private String hp_aid;

    @ApiModelProperty(value = "患者的病案号")
    private String hp_bah;

    @ApiModelProperty(value = "患者的姓名")
    private String hp_name;

    @ApiModelProperty(value = "患者的出院时间")
    private String hp_cysj;


    @ApiModelProperty(value = "操作原因")
    private String reason;


    @ApiModelProperty(value = "操作类型")
    private String type;

}
