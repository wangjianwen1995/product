package com.sxdl.base.entity;

import com.sxdl.base.config.PrefixConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@ApiModel(value = "系统用户对应科室信息")
@Entity
@Data
@Table(name = PrefixConfig.PREFIX+"sys_user_vs_ks")
public class SysUserVsKs implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "用户id", position = 2)
    private Integer user_id;
    @ApiModelProperty(value = "用户名", position = 3)
    private String user_name;
    @ApiModelProperty(value = "这里是科室code", position = 4)
    private String ks_id;
    @ApiModelProperty(value = "科室名", position = 5)
    private String ks_name;

    @Transient
    private String standard_id;
    @Transient
    private String standard_name;
}
