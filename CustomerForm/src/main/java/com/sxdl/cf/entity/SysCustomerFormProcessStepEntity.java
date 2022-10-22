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

@ApiModel(value = "sys_cf_processstep", description = "流程步骤")
@Entity
@Data
@Table(name="sys_cf_processstep")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class SysCustomerFormProcessStepEntity implements Serializable {

    @ApiModelProperty(value = "id")
    @Id
    @KeySql(genId = GUID.class)
    private String id;

    @ApiModelProperty(value = "表单键[事实表id]")
    private String form_id;

    @ApiModelProperty(value = "流程代码")
    private String process_code;

    @ApiModelProperty(value = "流程说明")
    private String process_explain;

    @ApiModelProperty(value = "步骤代码:前端赋值")
    private Integer step_number;

    @ApiModelProperty(value = "步骤详情")
    private String step_explain;


/*
    @ApiModelProperty(value = "分支代码 其实就是id")
    private String branch_code;
*/

    @ApiModelProperty(value = "分支详情")
    private String branch_explain;

    @ApiModelProperty(value = "可审核用户代码 用逗号隔开")
    private String toexamine_users;

    @ApiModelProperty(value = "可审核用户名称数据 用逗号隔开")
    private String toexamine_names;

    @ApiModelProperty(value = "状态 1启用 0停用")
    private Integer stateon;

    @Transient
    private SysCustomerFormHistoryToexamineEntity historyToexamineEntity;


    public SysCustomerFormProcessStepEntity(String form_id, String process_code) {
        this.form_id = form_id;
        this.process_code = process_code;
    }

    public SysCustomerFormProcessStepEntity(String form_id, String process_code,Integer step_code) {
        this.form_id = form_id;
        this.process_code = process_code;
        this.step_number = step_code;
    }


}
