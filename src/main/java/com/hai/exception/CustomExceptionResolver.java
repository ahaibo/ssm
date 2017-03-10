package com.hai.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 只要实现了 HandlerExceptionResolver 就是一个全局处理器
 * 当有多个实现时第一个匹配的生效
 * Created by as on 2017/3/9.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println(this.getClass().getName() + ex);
        String message = "未知错误";
        if (ex instanceof CustomException) {
            message = ex.getMessage();
        }
        return new ModelAndView("common/errors/error", "message", message);
    }
}
