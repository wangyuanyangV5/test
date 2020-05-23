package com.zhss.boot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest request,Exception e) throws Exception{
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("全局自定义异常处理");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }


}
