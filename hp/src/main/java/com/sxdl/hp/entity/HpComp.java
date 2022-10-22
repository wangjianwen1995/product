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

@ApiModel(value = "sys_dict_comp", description = "并发症名称字典表")
@Entity
@Data
@Table(name="sys_dict_comp")
public class HpComp implements Serializable {
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
    private String update_time;


    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "并发症名称字典表")
    private String name;

    @ApiModelProperty(value = "科室代码")
    private String ks_code;

    @ApiModelProperty(value = "科室名称")
    private String ks_name;



}
