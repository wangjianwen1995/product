package com.sxdl.base.util.Log;

import cn.hutool.core.thread.threadlocal.NamedThreadLocal;
import cn.hutool.json.JSONObject;
import com.sxdl.base.dao.dao1.SysLogDao;
import com.sxdl.base.entity.SysLog;
import com.sxdl.base.entity.SysUser;
import com.sxdl.base.util.DateUtil;
import com.sxdl.base.util.StringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;


/**
 * 日志切面类
 */
@Aspect
@Component
public class LogAspect {
    private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");
    private static final ThreadLocal<SysUser> currentUser = new NamedThreadLocal<>("ThreadLocal user");
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Autowired(required = false)
    HttpServletRequest request;
    private SysUser user;
    @Autowired
    private SysLogDao sysLogDao;

    /**
     * 配置的切点
     */
    @Pointcut("execution(* com.sxdl..controller.*.update*(..)) || "
            + "execution(* com.sxdl..controller.*.delete*(..)) || "
            + "execution(* com.sxdl..controller.*.insert*(..)) || "
            + "execution(* com.sxdl..controller.*.login*(..)) ")
    public void pointcut() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        //logger.info("进入日志切面前置通知!!");
        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
        //读取session中的用户
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if(null==o){
            return;
        }
        this.user = (SysUser) o;
        currentUser.set(this.user);
    }

    /**
     * 后置通知
     *
     * @param joinPoint 切点
     */
    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        //logger.info("进入日志切面后置通知！！");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if(null==o){
            return;
        }
    }

    /**
     * 后置通知之后返回信息
     *
     * @param joinPoint 如题
     * @param res 如题
     */
    @AfterReturning(returning = "res", pointcut = "pointcut()")
    public void doAfterReturning(JoinPoint joinPoint, Object res) {
        //处理完请求，返回内容
        //logger.info("进入日志切面返回参数日志通知!!");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if(null==o){
            return;
        }
        JSONObject json = new JSONObject(res);
        user = currentUser.get();
        String msg = (String) json.get("msg");
        //String t =  json.get("t").toString();
        String requestUri = request.getRequestURI();//请求的Uri
        if (user != null) {
            boolean bool = StringUtil.isNotEmpty(requestUri) && requestUri.contains("/api");
            if ("error".equals(json.get("state"))) {
                String type = "ERROR";    //日志级别
                if (bool) {
                    type = "ETL";
                }
                saveLog(joinPoint, user, type, ";异常信息：" + msg);
            } else {
                String type = "INFO";    //日志级别
                if (bool) {
                    type = "ETL";
                }
                saveLog(joinPoint, user, type, ";返回信息：" + msg);
            }
        }
    }

    /**
     * 异常通知 记录操作报错日志
     *
     * @param joinPoint 如题
     * @param e 如题
     */
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        //logger.info("进入日志切面异常通知!!");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("user");
        if(null==o){
            return;
        }
        user = currentUser.get();
        String requestUri = request.getRequestURI();//请求的Uri
        if (user != null) {
            boolean bool = requestUri != null && !"".equals(requestUri) && requestUri.contains("/api");
            String type = "ERROR";    //日志级别
            if (bool) {
                type = "ETL";
            }
            saveLog(joinPoint, user, type, ";异常信息：" + e.getCause());
        }
    }

    /**
     * 保存日志
     */
    public void saveLog(JoinPoint joinPoint, SysUser user, String type, String msg) {
        try {
            String operate = ""; //注解中desc的描述，表示什么操作
            operate = getControllerMethodDescription2(joinPoint);
            long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）
            long endTime = System.currentTimeMillis();  //2、结束时间也是日志创建时间
            //访问目标方法的参数 可动态改变参数值
            Object[] args = joinPoint.getArgs();
            String remoteAddr = request.getRemoteAddr();//请求的IP
            String requestUri = request.getRequestURI();//请求的Uri
            String method = request.getMethod();        //请求的方法类型(post/get)
            //Map<String,String[]> params=request.getParameterMap(); //请求提交的参数logger.info("设置日志信息存储到表中!!");
            SysLog log = new SysLog();
            log.setLevel(type);
            log.setUser_id(user.getId());
            log.setName(user.getName());
            log.setOperator(operate);
            log.setContent("请求IP:" + remoteAddr + ";请求URL:" + requestUri + ";请求方式:" + method + ";请求参数:" + Arrays.toString(args) + msg);
            log.setTime(endTime + "");
            log.setUse_time("耗时:" + DateUtil.formatTime(endTime - beginTime));
            sysLogDao.insert(log);
        } catch (Exception e) {
            logger.error("记录系统日志异常", e.getMessage());
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return discription
     */
    public static String getControllerMethodDescription2(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String method = signature.getMethod().getName();
        //ApiOperation log = method.getAnnotation(ApiOperation.class);
        //String desc = log.notes();
        return method;
    }
}
