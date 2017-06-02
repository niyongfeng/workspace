package com.xiaohoo.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xiaohoo.api.controller.base.BaseController;

public class InitServletInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if(handler instanceof HandlerMethod){
			HandlerMethod handerMethod=(HandlerMethod)handler;

			if(handerMethod.getBean() instanceof BaseController){
				BaseController bc = (BaseController)handerMethod.getBean();
				bc.setRequest(request);
				bc.setResponse(response);
				bc.setSession(request.getSession());
			}
		}else if(handler instanceof BaseController){
			BaseController bc = (BaseController)handler;
			bc.setRequest(request);
			bc.setResponse(response);
			bc.setSession(request.getSession());
		}
		return super.preHandle(request, response, handler);
	}

}
