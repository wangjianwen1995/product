package com.sxdl.drplus.dto;


import com.sxdl.drplus.entity.DrplusJbicd;
import com.sxdl.drplus.entity.DrplusSsicd;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true) //set链式编程
public class ICDDBO  implements Serializable {
    private DrplusJbicd jbicd;
    private DrplusSsicd ssicd;

}
