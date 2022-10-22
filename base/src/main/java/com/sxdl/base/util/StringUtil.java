package com.sxdl.base.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用字符串工具类,继承自 hutool-strutil
 *
 * @see cn.hutool.core.util.StrUtil
 */
public class StringUtil extends StrUtil {
    /**
     * 判断数字类型数据是否空
     *
     * @param n 数字
     * @return 是否
     */
    public static Boolean isEmptyNumber(Number n) {
        if (null == n || isEmpty(n.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 返回字符串中最后一个数字出现的下标，截取时候需要+1
     *
     * @param str 字符
     * @return int 下标
     */
    public static int lastNumberOfStr(String str) {
        int i = 0;
        if (isEmpty(str)) {
            return 0;
        }
        int len = str.length();
        List<Boolean> flags = new ArrayList<>(len);
        for (int j = 0; j < len; j++) {
            flags.add(isNumber(str.charAt(j)));
        }
        return flags.lastIndexOf(true);
    }

    /**
     * 判断该字符是否是数字
     *
     * @param c 如题
     * @return boolean 是否
     */
    public static boolean isNumber(Character c) {
        Matcher isNum = Pattern.compile("[0-9]*").matcher(c.toString());
        return isNum.matches();
    }

    /**
     * @param a 需要计算的字符
     * @param b 被匹配的字符
     *          eg: a="全麻",b="全身麻醉",
     */

    public static double simPro(String a, String b) {
        Set<Character> all = new HashSet<>();
        for (Character c : (a + b).toCharArray()) {
            all.add(c);
        }
        StringBuilder sb = new StringBuilder();
        all.forEach(e -> sb.append(e));
        int aa = a.length(), bb = b.length(), cc = sb.length();
        if (aa <= 1 || bb <= 1) {
            return 0.0;
        } else if (aa == bb) {
            return similar(a, b);
        } else {
            return (similar(b, sb.toString()) + similar(a, sb.toString())) * (aa + bb) / (cc * 2);
        }
    }
}
