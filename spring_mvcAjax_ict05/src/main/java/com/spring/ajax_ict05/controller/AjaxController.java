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
	
	
	// --------------- News --------------------------------
	// 1. 
	@RequestMapping("/responseNews.do")
	public String responseNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ AjaxController - responseNews.do ◀◀◀ " );
		return "news/responseNews";
	}
	// 2.
	@RequestMapping("/news1.do")
	public String news1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ AjaxController - news1.do ◀◀◀ " );
		return "news/news1";
	}
	@RequestMapping("/news2.do")
	public String news2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ AjaxController - news2.do ◀◀◀ " );
		return "news/news2";
	}
	@RequestMapping("/news3.do")
	public String news3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ AjaxController - news3.do ◀◀◀ " );
		return "news/news3";
	}
	
	// ----------------book------------------------------------------
	// 1
	@RequestMapping("/responseBook.do")
	public String responseBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ AjaxController - responseBook.do ◀◀◀ " );
		return "book/responseBook";
	}
	
	@RequestMapping("/bookInfo.do")
	public String bookInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ AjaxController - bookInfo.do ◀◀◀ " );
		return "book/bookInfo";
	}
}
