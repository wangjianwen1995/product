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
@ApiModel(value = "系统角色对应菜单信息")
@Entity
@Data
@Table(name = PrefixConfig.PREFIX+"sys_role_vs_menu")
public class SysRoleVsMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "角色id", position = 2)
    private Integer role_id;
    @ApiModelProperty(value = "菜单id", position = 3)
    private Integer menu_id;
    @ApiModelProperty(value = "菜单名", position = 4)
    private String menu_name;


}
