package com.spring.mvc_mybatis.ch04.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface UserService_ch04 {
	
	public void getUserInfo1(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;

	public void getUserInfo2(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;
	
	public void getUserInfo3(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException;

}
