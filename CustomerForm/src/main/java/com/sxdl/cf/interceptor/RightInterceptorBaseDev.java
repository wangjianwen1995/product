package com.sxdl.cf.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 *
 * 拦截器
 */
@Component
public class RightInterceptorBaseDev implements HandlerInterceptor {

    public static final String LoginUserId = "admin";
    public static final String DEV = "DevRequestParam";

    private static final String SKIP_INTERCEPTOR_PATH = "(.*)dev|(.*)dev/(.*)|(.*)dev/|(.*)devindex";





    /**
     * 请求执行前执行的
     *
     * 1 拦截一切dev/*的请求 ,非法授权登录不予
     * 2 所有请求 都必须在 HttpServletRequest的header 中添加 User-Uid属性
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String origin = httpServletRequest.getHeader("Origin");

        if (StringUtils.isEmpty(origin)) {
            origin = httpServletRequest.getHeader("Referer");
            if (StringUtils.isEmpty(origin)) {
                origin = "*";
            }
        }
        // 允许指定域访问跨域资源
        httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        // 有效时间
        httpServletResponse.setHeader("Access-Control-Max-Age", "36000");
        // 允许的header参数
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,token");
        // 允许的header参数
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        //当成非跨域请求

       // return true;

      /*  HttpSession session = httpServletRequest.getSession();
        String devStr = (String)session.getAttribute(DEV);
        if(StringUtils.isEmpty(devStr)|| !LoginUserId.equals(devStr)){
            JsonHelper.writeResponseJson(httpServletResponse, "权限不足,无法访问");
            return false;
        }
        String servletPath = httpServletRequest.getServletPath();
        if (!servletPath.matches(SKIP_INTERCEPTOR_PATH)) {
            JsonHelper.writeResponseJson(httpServletResponse, "非法路径访问!");
            return false;
        }
        String cookieUid  =getCookieUid(httpServletRequest);
        if(StringUtils.isEmpty(cookieUid) ){
            JsonHelper.writeResponseJson(httpServletResponse, "非法访问!");
            return false;
        }*/


         /*
         String headerUid = httpServletRequest.getHeader("User-Uid") ;
      if( StringUtils.isEmpty(headerUid)    ){
            JsonHelper.writeResponseJson(httpServletResponse, "严重非法访问!!");
            return false;
        }
        if( !cookieUid.equals(headerUid)  ){
            JsonHelper.writeResponseJson(httpServletResponse, "小小程序员别瞎搞!!!");
            return false;
        }*/
        return true;
    }
    private void addCookidUid(HttpServletResponse response){
        Cookie cookie = new Cookie("uid", UUID.randomUUID().toString());
        cookie.setMaxAge(12 * 60 * 60);// 设置为3 hour
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void main(String[] args) {
        String s="/dev/classify/getClassifyList";

        if (!s.matches("(.*)/dev|(.*)/dev/(.*)")) {

            System.out.println(1);
        }
    }

    private String getCookieUid(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "";
        }

        for (Cookie cookie : cookies) {
            if ( "uid".equalsIgnoreCase(cookie.getName()) ) {
                return cookie.getValue();
            }
        }

        return "";
    }

    /**
     * 请求结束执行的，但只有preHandle方法返回true的时候才会执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }





    /**
     * 视图渲染完成后才执行，同样需要preHandle返回true，该方法通常用于清理资源等工作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
