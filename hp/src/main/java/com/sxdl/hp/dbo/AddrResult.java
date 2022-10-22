package com.sxdl.hp.dbo;

import com.sxdl.hp.entity.HpAreaZip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AddrResult {
    String hassheng=null;
    String hasshi=null;
    String hasxian=null;
    String sheng=null;
    String shi=null;
    String xian=null;
    HpAreaZip area=null;
    String detail=null;
}
