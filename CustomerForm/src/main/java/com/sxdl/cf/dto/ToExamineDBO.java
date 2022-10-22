package com.sxdl.cf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true) //set链式编程
public class ToExamineDBO implements Serializable {

    private String  toexamine_process;       //流程代码
    private String  toexamine_process_explain;       //流程说明
    private Integer toexamine_step;          //步骤代码
    private String  toexamine_branchs;       //分支代码组
    private Integer toexamine_result;       // 结果0     审核结果:  1进行中 9完成 0未开始 -1驳回

    private String  toexamine_currentusers; //审核人代码 多个用&隔开
    private String  toexamine_currentnames; //审核人名称 多个用&隔开


    //toexamine_process,toexamine_step,toexamine_branchs,toexamine_currentusers,toexamine_currentnames,toexamine_result
}
