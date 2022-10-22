package com.sxdl.product.dc.entity;

import com.sxdl.base.util.UUIdGenId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "质控条件-数据")
@Entity
@Table(name = "dc_data_quality_control")
@Data
public class DcDataQualityControl implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "关联表ID")
    private String table_id;

    @ApiModelProperty(value = "关联字段ID")
    private String column_id;

    @ApiModelProperty(value = "关联字段名称")
    private String column_name;

    @ApiModelProperty(value = "质控类型")
    private String type;

    @ApiModelProperty(value = "质控sql")
    private String qc_sql;

    @ApiModelProperty(value = "质控周期 单位 年、月、调度周期")
    private String result_message;

    @ApiModelProperty(value = "状态 1启2废")
    private String status;

}