package com.sxdl.fm.util.app;

import lombok.Data;

/**
 * 工作总量报数信息，包含20列数据
 */
@Data
public class FmAllTwenty {
    String ys;//医生
    String ks;//科室
    String kh;//考核单元
    String mjzrs;//门急诊人数
    String szrs;//收治人数
    String sscs;//手术次数
    String zdssls;//主刀手术例数
    String yzssls;//一助手术例数
    String zqssls;//择期手术例数
    String jzssls;//急诊手术例数
    String xy1h;//小于1小时手术
    String z1d3h;//在1到3小时手术
    String dy3h;//大于3小时手术
    String zlczls;//治疗性操作例数
    String sjssls;//四级手术例数
    String wcssls;//微创手术例数
    String jrssls;//介入手术例数
    String ylqkshls;//一类切口手术例数
    String ylqkgrls;//一类切口感染人数
    String ssbfzls;//手术并发症例数

}
