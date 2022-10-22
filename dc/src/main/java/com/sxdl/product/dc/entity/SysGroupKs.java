package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@ApiModel(value = "医院科室组信息")
@Entity
@Data
@Table(name = "sys_group_ks")
public class SysGroupKs implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "名称", position = 2)
    private String name;
    @ApiModelProperty(value = "代码", position = 3)
    private String code;
    @ApiModelProperty(value = "父节点代码", position = 4)
    private String parent_code;
    @ApiModelProperty(value = "父节点名称", position = 4)
    private String parent_name;
    @ApiModelProperty(value = "开始时间", position = 4)
    private Integer start_time;
    @ApiModelProperty(value = "结束时间", position = 4)
    private Integer end_time;
    @ApiModelProperty(value = "是否开启，0未开启，1开启", position = 4)
    private Integer is_on;



}
