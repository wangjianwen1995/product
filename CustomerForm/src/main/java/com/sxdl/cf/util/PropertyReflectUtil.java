package com.sxdl.cf.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.persistence.Id;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class PropertyReflectUtil {
    public static final String LineBreak = "\r\n";
    public static final String GET = "get";

    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    /**
     * 获取主键值
     * @param bean 对象
     * @return String
     */
    public static Boolean getId(Object bean) throws Exception{
        Class<? extends Object> tClass = bean.getClass();
        //得到所有属性
        Field[] field = tClass.getDeclaredFields();
        // 整合出 getId() 属性这个方法
        Method m = tClass.getMethod(GET + replaceFirst(getFirstName(field)));
        // 用这个整合出来的get方法，强转成自己需要的类型
        // 成功通过 T 泛型对象取到具体对象的 id ！
        return  StringUtils.isEmpty(m.invoke(bean));
    }

    /**
     * 将属性名字的首字母大写
     */
    private static String replaceFirst(String name) {
        return name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
    }

    /**
     * 获取主键名
     * 默认主键是 field[0]
     */
    private static String getFirstName(Field[] field) {
        //设置可以访问私有变量
        String str = null;
        for (Field field1 : field) {
            if(field1.isAnnotationPresent(Id.class)){
                field1.setAccessible(true);
                str= field1.getName();
                break;
            }
        }
        return str;
    }
}
