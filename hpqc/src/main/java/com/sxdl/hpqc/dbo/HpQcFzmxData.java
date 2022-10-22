package com.sxdl.hpqc.dbo;

import lombok.Data;

@Data
public class HpQcFzmxData {


    private String bah;// 病案号
    private String CYSJ;// 出院时间
    private String GROUP_CODE;//分组代码
    private String GROUP_NAME;//分组名称
    private String GROUP_TYPE;//分组类型
    private String DIAG_CODE;//诊断编码
    private String OPER_CODE;//操作代码
    private String ZYZD_JBBM;//出院主要诊断编码(西医)
    private String ZYZD;// 出院主要诊断名称(西医)
    private String SSJCZBM1;// 主要手术操作编码
    private String SSJCZMC1;// 主要手术操作名称
    private String SSJCZBMALLC;// 所有手术代码
    private String STANDARD_FEE;// 标准费用
    private String BENCHMARK_SCORE;// 基准分值/权重
    private String zfy;// 总费用
    private String zhcfy;// 总耗材费用
    private String hzb;// 耗占比
    private String zyfy;// 总药费用
    private String yzb;// 药占比
    private String fee_type;// 费用类型  0:高倍率 1 低倍率 2 正常
    private String is_profitable ;// 是否盈利  0：亏损 1：盈利

}
