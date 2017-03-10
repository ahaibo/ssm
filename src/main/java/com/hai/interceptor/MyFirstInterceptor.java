package com.hai.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by as on 2017/3/9.
 */
public class MyFirstInterceptor implements HandlerInterceptor {

    /**
     * 执行方法之前
     * 可考虑做权限，日志等
     *
     * @param request
     * @param response
     * @param handler
     * @return true：继续调用后续的拦截器和方法 false：不会执行后续操作，返回
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(this.getClass().getName() + ".preHandle");
        return true;
    }

    /**
     * 执行方法之后，渲染视图之前
     * 可调整视图输出
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(this.getClass().getName() + ".postHandle");
    }

    /**
     * 渲染视图之后
     * 可释放资源
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(this.getClass().getName() + ".afterCompletion");
    }
}
