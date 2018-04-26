package com.cpp.core.interceptor;

import com.cpp.core.annotation.RequestLimit;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LimitHandlerInterceptorAdapter extends HandlerInterceptorAdapter {
    static Logger logger = Logger.getLogger(HandlerInterceptorAdapter.class);

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequestLimit requestLimit = handlerMethod.getMethodAnnotation(RequestLimit.class);
            if (requestLimit != null) {
                logger.warn("HandlerMethod..." + requestLimit.value());
            }
        }
        return super.preHandle(request, response, handler);
    }
}
