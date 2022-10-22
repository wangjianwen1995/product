package com.sxdl.product.dc.dbo;

import lombok.Data;

//用于存储排错
@Data
public class FindProblemDBO {
    //存储ID
    private String id;
    //错误类型
    private String type;
    //错误信息
    private String msg;
    //转化错误字段类型
    private String errType;
    //抽取开始时间
    private String startDate;
    //抽取结束时间
    private String endDate;

}
