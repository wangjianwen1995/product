package com.sxdl.sd.util;

import com.sxdl.base.util.StringUtil;

import java.util.regex.Pattern;

public class MatchBmAndMc {
    static StringBuilder sb = null;

    /**
     * 结合编码和名称,与keyvals匹配
     *
     * @param bm   疾病编码或者手术编码
     * @param mc   疾病名称或者手术名称
     * @param goal 目标值
     * @return
     */
    public static boolean matchBmAndMc(String bm, String mc, String goal) {
        if (StringUtil.isEmpty(bm) || StringUtil.isEmpty(mc) || StringUtil.isEmpty(goal) || !bm.contains(".")) return false;
        sb = new StringBuilder("^");
        if (bm.contains(".")) bm = bm.split("\\.")[0];
        sb.append(bm)
                .append("+.*")
                .append(mc).append("$");
        boolean flag = Pattern.matches(sb.toString(), goal);
        if (flag) return flag;//首先按正则匹配
        else return goal.contains(mc);//匹配不到用模糊匹配
    }
}
