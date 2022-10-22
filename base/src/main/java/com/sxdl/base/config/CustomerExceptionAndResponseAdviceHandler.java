package com.sxdl.base.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sxdl.base.util.Log.Log;
import com.sxdl.base.util.Log.LogAspect;
import com.sxdl.base.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局统一处理接口异常,并且统一处理返回值类型
 */
@RestControllerAdvice(basePackages = {"com.sxdl.**"}, annotations = {RestController.class})
public class CustomerExceptionAndResponseAdviceHandler implements ResponseBodyAdvice<Object> {

    static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Log(desc = "接口返回值")
    @ExceptionHandler(Exception.class)
    public ResultUtil Execption(Exception e) {
        e.printStackTrace();
        StackTraceElement st = e.getStackTrace()[0];
        String info = "报错发生在 :" + st.getFileName() + " 类中的 " + st.getMethodName() + " 方法中的第 " + st.getLineNumber() + " 行!原因是 :\n" + e.getMessage();
        logger.error(info);
        return ResultUtil.error(info);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 其他类型返回值,原样返回
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }
}

