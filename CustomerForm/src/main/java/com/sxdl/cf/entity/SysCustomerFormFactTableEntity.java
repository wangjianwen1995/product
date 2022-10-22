package com.sxdl.cf.entity;

import com.sxdl.cf.util.GUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@ApiModel(value = "sys_cf_facttable", description = "事实表管理")
@Entity
@Data
@Table(name="sys_cf_facttable")
@Accessors(chain = true) //set链式编程
public class SysCustomerFormFactTableEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @ApiModelProperty(value = "表名称")
    private String name;

    @ApiModelProperty(value = "表备注")
    private String label;

    @ApiModelProperty(value = "是否审核:1审核 0不审")
    private Integer is_reviewed;


    @ApiModelProperty(value = "是否子表: 0 否  1(一对一弹框式) 2(一对多列表式) ")
    private Integer is_childtable;

    @ApiModelProperty(value = "所属主实体:子表需要配置所属的父表id")
    private String maintable_id;

    @ApiModelProperty(value = "所属主实体:子表需要配置所属的父表name")
    private String maintable_name;

    @ApiModelProperty(value = "分类id sys_cf_classify.id")
    private String classify_id;


    @ApiModelProperty(value = "开启数据权限 0 否 ,1 可看科室, 2 只看本人 ")
    private Integer onable_role;

    @ApiModelProperty(value = "序号")
    private Integer order_number;





}
