package com.spring.mvc_mybatis.ch01.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface UserService_ch01 {
	
	public void getAddressInfo_1(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
	public void getAddressInfo_2(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
}
