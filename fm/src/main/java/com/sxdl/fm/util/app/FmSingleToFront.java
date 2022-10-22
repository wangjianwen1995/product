package com.sxdl.fm.util.app;

import lombok.Data;

@Data
public class FmSingleToFront {//单独的数据list给前端
    String ks;//科室
    String ys;//医生
    //    String zw;//职位
    String kh;//考核单元
    String val;//值
    String totle;//总数
    String avg;//平均数
    String max;//最大
    String min;//最小
    String pm;//全部排名
    String kspm;//科室排名
    String khdypm;//考核单元排名
}
