package com.sxdl.cf.entity;

import com.sxdl.cf.util.GUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@ApiModel(value = "sys_cf_history_toexamine", description = "历史审核信息")
@Entity
@Data
@Table(name="sys_cf_history_toexamine")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class SysCustomerFormHistoryToexamineEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @ApiModelProperty(value = "表单键[事实表id]")
    private String form_id;


    @ApiModelProperty(value = "表单数据键:前端赋值")
    private String  formdata_id;

    @ApiModelProperty(value = "流程:前端赋值")
    private String  toexamine_process;


    @ApiModelProperty(value = "步骤:前端赋值")
    private Integer  toexamine_step;

    @ApiModelProperty(value = "一个分支代码:后端赋值 其实就是流程表的id")
    private String  toexamine_branch;


    @ApiModelProperty(value = "审核用户代码:前端赋值")
    private String  toexamine_usercode;

    @ApiModelProperty(value = "审核用户名称:前端赋值")
    private String  toexamine_username;



    @ApiModelProperty(value = "审核时间 驳回时间:前端赋值")
    private String  toexamine_time;

    @ApiModelProperty(value = "审核意见 信息:前端赋值")
    private String  toexamine_info;

    @ApiModelProperty(value = "是否通过 1 是 0否:前端赋值")
    private Integer ispass ;

    @Transient
    private String  toexamine_branchs;       //分支代码组 多个用&隔开
    @Transient
    private Integer toexamine_result;       // 结果0     审核结果:  1进行中 9完成 0未开始 -1驳回
    @Transient
    private String  toexamine_currentusers; //审核人代码 多个用&隔开
    @Transient
    private String  toexamine_currentnames; //审核人名称 多个用&隔开


/*
    @ApiModelProperty(value = "前端给1 是否有效[驳回后重新开始审核,之前的数据标识成无效] 1 有效 0无效 ")
    private Integer isvalid ;*/


}
