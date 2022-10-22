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

@ApiModel(value = "质控条件-整体")
@Entity
@Table(name = "dc_overall_quality_control")
@Data
public class DcOverallQualityControl implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    @KeySql(genId = UUIdGenId.class)
    private String id;

    @ApiModelProperty(value = "关联表ID")
    private String table_id;

    @ApiModelProperty(value = "序号")
    private Integer xh;

    @ApiModelProperty(value = "指标名称")
    private String mc;

    @ApiModelProperty(value = "指标公式")
    private String target;

    @ApiModelProperty(value = "质控类型 1上限2下限3范围")
    private Integer qc_type;

    @ApiModelProperty(value = "预警值上限")
    private String max_value;

    @ApiModelProperty(value = "预警值下限")
    private String min_value;

    @ApiModelProperty(value = "质控周期 单位 年、月、调度周期")
    private String unit;

    @ApiModelProperty(value = "状态 1启2废")
    private String status;

}