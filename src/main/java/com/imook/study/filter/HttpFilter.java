package com.imook.study.filter;

import com.imook.study.threadLocal.RequesthHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ProjectName: concurent
 * @Package: com.imook.study.filter
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/17 9:45 PM
 * @Version: v1.0
 */
@Slf4j
public class HttpFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        log.info("do filter,{},{}",Thread.currentThread().getId(),((HttpServletRequest) request).getServletPath());
        RequesthHolder.add(Thread.currentThread().getId());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}