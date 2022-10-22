package com.sxdl.product.dc.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(value = "用户类")
@Entity
@Data
@Table(name = "dc_user")
public class DcUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "用户名", position = 2)
    @NotBlank(message = "用户名不能为空")
    private String name;
    @ApiModelProperty(value = "密码", position = 3)
    private String pwd;
    @ApiModelProperty(value = "中文名", position = 4)
    private String name_zh;

}
