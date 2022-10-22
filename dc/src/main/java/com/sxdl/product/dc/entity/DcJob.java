package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 请求类型类
 */
@ApiModel(value = "dcApiType", description = "接口请求类型类")
@Entity
@Data
@Table(name = "dc_job")
public class DcJob implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @Column(name = "id", nullable = false)
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "名称", position = 2)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "医院代码", position = 3)
    @Column(name = "hospital_id")
    private String hospital_id;

    @ApiModelProperty(value = "项目代码",position = 4)
    @Column(name = "product_id")
    private String product_id;

    @ApiModelProperty(value = "项目代码",position = 5)
    @Column(name = "creat_time")
    private String  creat_time;


    @ApiModelProperty(value = "修改时间",position = 6)
    @Column(name = "update_time")
    private String update_time;

    @ApiModelProperty(value = "状态",position = 7)
    @Column(name = "status")
    private Integer status;

    @ApiModelProperty(value = "用户代码",position = 8)
    @Column(name = "user_id")
    private Integer user_id;

    @Transient
    private String hospitalName;

    @Transient
    private String productName;

    @Transient
    private String userName;

    @Transient
    private List<DcProcedure> chind;

    @ApiModelProperty(value = "任务规则id")
    private String rule_id;

    @ApiModelProperty("调度规则方法后缀")
    private String rule_suffix;

    @ApiModelProperty("工单类型") //ETLP E：抽外部数据 T：dc内部清洗转换  L：加载到产品表 P：给外部推送数据
    private Integer type;

    @ApiModelProperty("参数")
    private Integer param;

    @ApiModelProperty("参数单位")
    private String param_unit;
}