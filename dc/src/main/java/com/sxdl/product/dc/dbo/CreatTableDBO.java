package com.sxdl.product.dc.dbo;

import lombok.Data;

//用于导入表结构
@Data
public class CreatTableDBO {

    private String transfer_id;
    private String name;
    private String name_zh;
    private Integer iscreateatdc;
    private Integer product_type;  //1:源产品  2:目标产品
    private Integer isview;  //是否视图  1:是  2:否
}
