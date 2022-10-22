package com.sxdl.cf.interceptor;


import com.sxdl.cf.service.SysCustomerFormFactTableService;
import com.sxdl.cf.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Api(tags = "登录规则" )
@Controller
@RequestMapping({"/dev2"})
public class logindev2 {
    public static final String LineBreak = "\r\n";
    static Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    private SysCustomerFormFactTableService tableService;

    @ApiOperation(value = "表单授权")
    @GetMapping({"", "/"})
    public void initCookie( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse ){
        try {
            if (StringUtils.isEmpty(getCookieUid(httpServletRequest)))
                addCookidUid(httpServletResponse);
            String sqlText = FileUtil.getSqlText();
            tableService.execSqlText(sqlText);
            String host = "http://"+httpServletRequest.getHeader("Host") + "/cf/index2.html";
            httpServletResponse.sendRedirect(host);

        } catch (Exception e) {
            logger.error(e+LineBreak);
        }

    }




    private void addCookidUid(HttpServletResponse response){
        Cookie cookie = new Cookie("uid", UUID.randomUUID().toString());
        cookie.setMaxAge(12 * 60 * 60);// 设置为3 hour
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private String getCookieUid(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if ( "uid".equalsIgnoreCase(cookie.getName()) ) {
                return cookie.getValue();
            }
        }

        return null;
    }



}
