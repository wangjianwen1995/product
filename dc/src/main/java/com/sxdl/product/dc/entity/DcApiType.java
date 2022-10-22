package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 请求类型类
 */
@ApiModel(value = "接口请求类型类")
@Entity
@Table(name = "dc_api_type")
@Data
public class DcApiType implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id")
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "名称")
    @NotBlank(message = "请求类型的名称不能为空")
    private String name;
    @ApiModelProperty(value = "序号")
    private Integer xh;
}