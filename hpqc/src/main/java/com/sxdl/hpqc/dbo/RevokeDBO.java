package com.sxdl.hpqc.dbo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RevokeDBO implements Serializable {

    private static final long serialVersionUID = 1L;



    @ApiModelProperty(value = "患者key")
    private String revoke_key;

    @ApiModelProperty(value = "患者撤销代码")
    private String revoke_code;




}
