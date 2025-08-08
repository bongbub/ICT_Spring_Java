package com.spring.mvc_mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc_mybatis.ch01.service.UserServiceImpl_ch01;

@Controller
public class MybatisController {
	
	@Autowired
	private UserServiceImpl_ch01 service1;
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);
	
	// ch01 ===========================================================
	// ch01. user:address => 1:1  => assocation
	@RequestMapping("/getAddressInfo_1")
	public String getAddressInfo_1(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException{
		logger.info(" ======= [ url => /getAddressInfo_1 ] ====== ");
		
		service1.getAddressInfo_1(request, response, model);
		
		return "address/getAddressInfo";
	}
	
	// ch02 ===========================================================
	// ch02. user:board => 1:N  => collection
	@RequestMapping("/getAddressInfo_2")
	public String getAddressInfo_2(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException{
		logger.info(" ======= [ url => /getAddressInfo_2 ] ====== ");
		
		service1.getAddressInfo_2(request, response, model);
		
		return "address/getAddressInfo";
	}
}
