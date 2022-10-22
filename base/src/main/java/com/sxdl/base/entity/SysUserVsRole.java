package com.sxdl.base.entity;

import com.sxdl.base.config.PrefixConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Hui
 * @version 1.0
 */
@ApiModel(value = "系统用户对应角色信息")
@Entity
@Data
@Table(name = PrefixConfig.PREFIX+"sys_user_vs_role")
public class SysUserVsRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "用户id", position = 2)
    private Integer user_id;
    @ApiModelProperty(value = "用户名", position = 3)
    private String user_name;
    @ApiModelProperty(value = "角色id", position = 4)
    private Integer role_id;
    @ApiModelProperty(value = "角色名", position = 5)
    private String role_name;

}
