package com.mastspring.lesson09;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class Test007Ctlr {
	@RequestMapping (value="/interceptcheck")
	@ResponseBody
	public String getObj() {
		return "Good news! Rquest has been processed during (Non) Tuesday...";
	}
}

class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("Request Has been Completed..");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("Handler is executed...");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		String day = simpleDateformat.format(new java.util.Date());
		System.out.println(day);
		
		/*
		 * I am writing this code on March 25th 2014 - Tuesday.
		 */
		if ("Tuesday".equalsIgnoreCase(day)) {
			arg1.sendRedirect("http://en.wikipedia.org/wiki/Tuesday");
			return false;
		} else {
			return true;
		}
	}
}