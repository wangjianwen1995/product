package com.sxdl.product.dc.entity;


import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.util.List;

@ApiModel(value = "dcTable", description = "自定义表的信息")
@Entity
@Data
@Table(name = "dc_table")
public class DcTable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "自定义表名称", position = 2)
    @NotBlank(message = "自定义表名称不能为空")
    private String name;

    @ApiModelProperty(value = "自定义表中文名", position = 3)
    @NotBlank(message = "自定义表中文名称不能为空")
    private String name_zh;


    @ApiModelProperty(value = "自定义表类型", position = 4)
    @NotBlank(message = "自定义表类型不能为空")
    private Integer type_id;

    @ApiModelProperty(value = "自定义表类型", position = 5)
    @NotBlank(message = "自定义表类型不能为空")
    private Integer is_public;

    @ApiModelProperty(value = "产品id", position = 6)
    @NotBlank(message = "产品id不能为空")
    private String product_id;

    @ApiModelProperty(value = "是否存在", position = 6)
    @NotBlank(message = "是否存在 1需要建表 2 数据库不需要建表")
    private String isexist;

    @ApiModelProperty(value = "行列转换用_更新column表", position = 6)

    private String update_sql;

    @ApiModelProperty(value = "行列转换用_转换sql", position = 6)

    private String conversion_sql;

    @ApiModelProperty(value = "是否质控 1是2否", position = 6)
    private Integer is_qc;




    @Transient
    private String productName;

    @Transient
    private String typeName;

    @Transient
    private List<DcColumn> dcColumnList;



}