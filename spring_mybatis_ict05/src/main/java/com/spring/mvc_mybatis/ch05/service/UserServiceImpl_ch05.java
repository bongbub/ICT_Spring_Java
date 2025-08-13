package com.spring.mvc_mybatis.ch05.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05;
import com.spring.mvc_mybatis.ch05.dto.UserDTO_5;

@Service
public class UserServiceImpl_ch05 implements UserService_ch05{

	@Autowired
	private UserDAO_ch05 dao;
	
	// 목록조회
	@Override
	public void getUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" 서비스 - getUserList() ");
		List<UserDTO_5> list = dao.selectUserList();
		model.addAttribute("list",list);
	}

	// 1건 조회
	@Override
	public void getUser(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" 서비스 - getUser() ");
		
		UserDTO_5 dto = dao.selectUser(1);
		model.addAttribute("dto", dto);
	}
	
	// insert 후, 목록조회
	@Override
	public void insertUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" 서비스 - insertUserList() ");
		
		// DTO에 insert할 정보를 setter를 통해 넘겨준다
		UserDTO_5 user = new UserDTO_5(4,"미니츄2", Date.valueOf("2025-08-14"));
		
		// insert
		int cnt = dao.insertUser(user);
		
		// 목록 조회
		List<UserDTO_5> list = dao.selectUserList();
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
	}

	// update 후, 목록조회
	@Override
	public void updateUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" 서비스 - updateUserList() ");
		
		UserDTO_5 user = new UserDTO_5(4,"미니츄업뎃",Date.valueOf("2022-09-09"));
		// update
		int cnt = dao.updateUser(user);
		// 목록 조회
		List<UserDTO_5> list = dao.selectUserList();
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
	}

	// delete 후, 목록조회
	@Override
	public void deleteUserList(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" 서비스 - deleteUserList() ");
		
		int cnt = dao.deleteUser(3);
		// 목록 조회
		List<UserDTO_5> list = dao.selectUserList();
		model.addAttribute("list", list);
		model.addAttribute("cnt", cnt);
	}

}
