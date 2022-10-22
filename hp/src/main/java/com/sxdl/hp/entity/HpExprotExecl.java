package com.sxdl.hp.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "hp_exportexecl", description = "导出execl")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "hp_exportexecl")
public class HpExprotExecl implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    private Integer id;

    @ApiModelProperty(value = "模板id")
    @Column(name = "export_id")
    private Integer export_id;

    @ApiModelProperty(value = "字段名")
    @Column(name = "col_name")
    private String col_name;

    @ApiModelProperty(value = "字段中文名称")
    @Column(name = "col_name_zh")
    private String col_name_zh;

    @ApiModelProperty(value = "表名")
    @Column(name = "table_name")
    private String table_name;

    @ApiModelProperty(value = "字段名替换case")
    @Column(name = "col_name_case")
    private String col_name_case;


}
