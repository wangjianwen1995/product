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
import java.util.List;

@ApiModel(value = "dc_virtual_table", description = "组合表")
@Entity
@Data
@Table(name = "dc_virtual_table")
public class DcVirtualTable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id", position = 1)
    @Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    @ApiModelProperty(value = "关系表id（从表on后面的关系）")
    private String relation_talbe_id;

    @ApiModelProperty(value = "关系表名称")
    private String relation_talbe_name;

    @ApiModelProperty(value = "关系表字段id")
    private String relation_column_id;

    @ApiModelProperty(value = "关系表字段名称")
    private String relation_column_name;

    @ApiModelProperty(value = "从表id")
    private String  son_table_id;

    @ApiModelProperty(value = "从表名称")
    private String  son_table_name;

    @ApiModelProperty(value = "从表别名")
    private String  son_table_oname;

    @ApiModelProperty(value = "从表字段id")
    private String  son_column_id;

    @ApiModelProperty(value = "从表字段名称")
    private String  son_column_name;

    @ApiModelProperty(value = "补充的sql")
    private String  supplement_sql;

    @ApiModelProperty(value = "存储过程id")
    private String  procedure_id;


    @Transient
    private List<DcTableVsTable> relations;

    @Transient
    private List<DcTableVsTable> sons;


}
