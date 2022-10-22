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
import java.util.List;
import java.util.Map;

/**
 * @author Hui
 * @version 1.0
 */
@ApiModel(value = "系统菜单信息")
@Entity
@Data
@Table(name = PrefixConfig.PREFIX+"sys_menu")
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "菜单标题", position = 2)
    private String title;
    @ApiModelProperty(value = "菜单英文名", position = 3)
    private String name;
    @ApiModelProperty(value = "路由", position = 4)
    private String path;
    @ApiModelProperty(value = "页面url", position = 4)
    private String component;
    @ApiModelProperty(value = "父代码", position = 5)
    private Integer parent_code;

    @ApiModelProperty(value = "图标", position = 11)
    private String icon;
    @ApiModelProperty(value = "角标", position = 12)
    private String badge;
    @ApiModelProperty(value = "是否选中,首页常用菜单", position = 13)
    private String ischeck; //改成了是否首页常用菜单选项

    @ApiModelProperty(value = "菜单等级", position = 14)
    private Integer level;
    @ApiModelProperty(value = "菜单序号", position = 14)
    private Integer xh;
    @ApiModelProperty(value = "是否有子项", position = 14)
    private Boolean haschildren;
    @ApiModelProperty(value = "重定向", position = 14)
    private String redirect;
    @ApiModelProperty(value = "固定", position = 14)
    private Boolean affix;
    @ApiModelProperty(value = "菜单类型", position = 5)
    private Integer menu_type;
    @ApiModelProperty(value = "报表参数", position = 5)
    private String cs;


    @Transient
    private List<SysMenu> children;

    @Transient
    private Map<String,Object> meta;

    @Transient
    private String index;




}
