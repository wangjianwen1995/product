package com.sxdl.report.util.scheduled;

import com.sxdl.base.util.scheduled.SpringContextUtils;
import com.sxdl.report.entity.DrTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * 被定时任务线程池调用，用来执行指定bean里面的指定方法。
 */

public class SchedulingRunnable implements Runnable {

    protected Logger logger = LogManager.getLogger(SchedulingRunnable.class);

    private String beanName;

    private String methodName;

    private DrTemplate template;

    public SchedulingRunnable(String beanName, String methodName) {
        this.beanName = beanName;
        this.methodName = methodName;
    }

    /**
     * 调度任务运行类的构造方法
     * @param beanName      执行调度的类在spring中的bean名称
     * @param methodName    执行调度的方法名称
     * @param template        调度任务列表
     */
    public SchedulingRunnable(String beanName, String methodName, DrTemplate template) {
        this.beanName = beanName;
        this.methodName = methodName;
        this.template = template;
    }

    @Override
    public void run() {
        logger.info("定时任务开始执行 - bean：{}，方法：{}，参数：{}", beanName, methodName, template);
        long startTime = System.currentTimeMillis();

        try {
            Object target = SpringContextUtils.getBean(beanName);
            Method method = null;
            if(template!=null){
                method=target.getClass().getDeclaredMethod(methodName, DrTemplate.class);
            } else {
                method = target.getClass().getDeclaredMethod(methodName);
            }
            // 将一个方法设置为可调用，主要针对private方法；
            ReflectionUtils.makeAccessible(method);

            if(template!=null){
                method.invoke(target, template);
            } else {
                method.invoke(target);
            }


        } catch (Exception ex) {
            logger.error(String.format("定时任务执行异常 - bean：%s，方法：%s，参数：%s ", beanName, methodName, template), ex);
        }

        long times = System.currentTimeMillis() - startTime;
        logger.info("定时任务执行结束 - bean：{}，方法：{}，参数：{}，耗时：{} 毫秒", beanName, methodName, template, times);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchedulingRunnable that = (SchedulingRunnable) o;
        if (template == null) {
            return beanName.equals(that.beanName) &&
                    methodName.equals(that.methodName) &&
                    that.template == null;
        }

        return beanName.equals(that.beanName) &&
                methodName.equals(that.methodName) &&
                template.equals(that.template);
    }

    @Override
    public int hashCode() {
        if (template == null) {
            return Objects.hash(beanName, methodName);
        }

        return Objects.hash(beanName, methodName, template);
    }
}
