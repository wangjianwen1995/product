package com.sxdl.drplus.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "drplus_stored_procedure", description = "需要抽取外部数据的存储过程,页面手动执行")
@Entity
@Data
@Table(name="drplus_stored_procedure")
public class DrPlusStoredProcedure implements Serializable {



    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "外键")
    private Integer drplus_platform_detailed_id;

    @ApiModelProperty(value = "存储名称意义")
    private String name;
    @ApiModelProperty(value = "存储名")
    private String namesql;

    @ApiModelProperty(value = "参数类型: 1 时间范围 2 文本输入")
    private Integer type;




}
