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
public class CodeNameDBO implements Serializable {

    private String code;
    private String explain;
    private Integer stateon;
    // /toexamine/getStep 才使用
    private String stepId;
}
