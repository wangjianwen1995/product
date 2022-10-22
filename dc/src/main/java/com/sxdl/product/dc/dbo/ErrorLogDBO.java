package com.sxdl.product.dc.dbo;

import com.sxdl.product.dc.entity.DcScheduleConfig;
import lombok.Data;

@Data
public class ErrorLogDBO {

    //存储名称
    private String pname;

    //错误类型 ： 报错、先决存储未执行、中断
    private String type;

    private DcScheduleConfig e;
}
