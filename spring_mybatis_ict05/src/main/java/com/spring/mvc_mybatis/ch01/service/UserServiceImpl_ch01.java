package com.spring.mvc_mybatis.ch01.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mvc_mybatis.ch01.dao.UserDAO_ch01;
import com.spring.mvc_mybatis.ch01.dto.UserDTO;

@Service
public class UserServiceImpl_ch01 implements UserService_ch01{

	@Autowired
	private UserDAO_ch01 dao;
	
	@Override
	public void getAddressInfo_1(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ===   [[ UserServiceImpl_ch01  - getAddressInfo_1() ]]  === ");
		
		List<UserDTO> list = dao.getAddressInfo_1();
		model.addAttribute("list", list);
	}

	@Override
	public void getAddressInfo_2(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ===   [[ UserServiceImpl_ch01  - getAddressInfo_2() ]]  === ");
		
		List<UserDTO> list = dao.getAddressInfo_2();
		model.addAttribute("list", list);
	}
	

}
