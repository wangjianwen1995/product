package com.sxdl.cf.entity;

import com.sxdl.cf.config.PrefixConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@ApiModel(value = "系统角色信息")
@Entity
@Data
@Table(name = PrefixConfig.PREFIX +"sys_role")
@Accessors(chain = true) //set链式编程
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "角色名", position = 2)
    private String name;
    @ApiModelProperty(value = "首页url", position = 3)
    private String index_url;
    @ApiModelProperty(value = "首页菜单id", position = 4)
    private Integer index_menu_id;



}
