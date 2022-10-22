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

/**
 * @author Hui
 * @version 1.0
 */
@ApiModel(value = "系统用户信息")
@Entity
@Data
@Table(name = PrefixConfig.PREFIX +"sys_user")
@Accessors(chain = true) //set链式编程
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "id", position = 1)
    @Id
    @NotBlank()
    private Integer id;
    @ApiModelProperty(value = "用户名", position = 2)
    private String name;
    @ApiModelProperty(value = "代码", position = 3)
    private String code;
    @ApiModelProperty(value = "登录名", position = 4)
    private String login_name;
    @ApiModelProperty(value = "密码", position = 4)
    private String pwd;
    @ApiModelProperty(value = "职称", position = 4)
    private String title;
    @ApiModelProperty(value = "职位", position = 4)
    private String position;
    @ApiModelProperty(value = "院区id", position = 4)
    private String yq_id;
    @ApiModelProperty(value = "院区名称", position = 4)
    private String yq_name;
    @ApiModelProperty(value = "这里是科室code", position = 4)
    private String ks_id;
    @ApiModelProperty(value = "科室名称", position = 4)
    private String ks_name;
    @ApiModelProperty(value = "人员类型，1医生，2护士，3行政人员", position = 4)
    private Integer staff_type;
    @ApiModelProperty(value = "更新时间", position = 4)
    private String update_time;
    @ApiModelProperty(value = "医院人员信息id", position = 4)
    private Integer staff_id;

    @ApiModelProperty(value = "头像", position = 4)
    private String img;

    @ApiModelProperty(value = "关联所看科室SQL", position = 4)
    private String kk_ks;

    @ApiModelProperty(value = "关联所看科室SQL", position = 4)
    private String kk_standard;

    @ApiModelProperty(value = "领导id", position = 4)
    private Integer parent_id;

    @ApiModelProperty(value = "状态", position = 4)
    private Integer status;



}
