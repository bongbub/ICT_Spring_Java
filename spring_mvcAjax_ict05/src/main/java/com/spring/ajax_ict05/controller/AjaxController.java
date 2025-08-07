package com.spring.ajax_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AjaxController {
	
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	// 첫 페이지
	@RequestMapping("/simple.do")
	public String simple(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		logger.info(" ▶▶▶ AjaxController - simple.do ◀◀◀ " );
		return "basic/simple";
	}
}
