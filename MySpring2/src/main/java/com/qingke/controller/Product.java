package com.qingke.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class Product {

	@RequestMapping("/list")
	public String list() {
		return "list";
		///web-inf/jsp/list.jsp
	}

	@RequestMapping("/list4")
	public String list4() {
		return "list";
		///web-inf/jsp/list.jsp
	}
	
	@RequestMapping("/lists")
	@ResponseBody
	public String list2() {
		return "Hello Spring";
	}
	
	@RequestMapping("/list3")
	public void list3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("/product/list5?a=99&b=88").forward(request, response);
		//response.getWriter().println("Hello 12355555 from void");
	}
	
	@RequestMapping("/list5")
	public ModelAndView list5(int a, int b) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list5");
		mv.addObject("sum", a+b);
	    return mv;
	}
}
