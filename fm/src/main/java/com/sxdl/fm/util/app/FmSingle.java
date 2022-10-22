package com.sxdl.fm.util.app;

import com.sxdl.base.util.StringUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

/**
 * 包含4列原始数据，以及医生，科室，考核单元维度和相应的排名
 */
@Getter
@Setter
@ToString
public class FmSingle implements Comparable<FmSingle> {//单独的数据list
    String ks;//科室
    String ys;//医生
    //    String zw;//职位
    String kh;
    String val;//值
    Integer type;//类型，共17种
    String pm;//全部排名
    String kspm;//科室排名
    String khdypm;//考核单元排名

    Set<String> myks;//我的ks列表
    Set<String> mykh;//我的kh列表

    public Double getDoubleVal() {
        return StringUtil.isEmpty(this.val)?0.0D:Double.valueOf(this.val);
    }

    public FmSingle() {
    }

    public FmSingle(String val) {
        this.val = val;
    }

    public FmSingle(String ks, String ys, String kh, String val) {
        this.ks = ks;
        this.ys = ys;
//        this.zw = zw;
        this.kh = kh;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FmSingle)) return false;
        FmSingle fmSingle = (FmSingle) o;
        if (null == fmSingle.getYs() && null == this.ys) {
            if (null == fmSingle.getKs() && null == this.ks) {
                return kh.equals(fmSingle.getKh());
            } else {
                return ks.equals(fmSingle.getKs());
            }
        }
        return ys.equals(fmSingle.ys);
    }

    //降序比较
    @Override
    public int compareTo(FmSingle o) {
        return (int) (Double.valueOf(o.getVal()) - Double.valueOf(this.val));
    }
}
