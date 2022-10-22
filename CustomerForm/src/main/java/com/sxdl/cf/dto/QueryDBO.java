package com.sxdl.cf.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) //set链式编程
public class QueryDBO {
    private String type;

    private String column;

    private String val;
}
