package com.sxdl.base.util.verify;

import lombok.Getter;
import lombok.Setter;

/**
 * 注册校验返回信息
 */
@Getter
@Setter
public class VerifyReturn {
    private Boolean flag;
    private String meg;
    public VerifyReturn(Boolean flag, String meg) {
        this.flag = flag;
        this.meg = meg;
    }
}
