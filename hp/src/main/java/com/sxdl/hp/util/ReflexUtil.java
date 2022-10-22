package com.sxdl.hp.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReflexUtil {


    /**
     * 根据私有属性获取 私有属性对映的值
     *
     * @param obj
     * @param obj
     * @param columnName
     * @param istime     0 不是 1 日期  2日期时间
     * @return
     * @throws Exception
     */
    public static Object getValByPropertiesName(Class entityClass, Object obj, String columnName, int istime) throws Exception {
        Field field = entityClass.getDeclaredField(columnName);
        field.setAccessible(true);
        Object o = field.get(obj);
        if (istime == 1) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) o);
        } else if (2 == istime)
            return new SimpleDateFormat("yyyy-MM-dd").format((Date) o);
        return o;
    }
}
