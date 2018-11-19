package com.imook.study.interceptor;

import com.imook.study.threadLocal.RequesthHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.interceptor
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 10:02 PM
 * @Version: v1.0
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequesthHolder.remove();
        log.info("afterCompletion");
        return;
    }
}
