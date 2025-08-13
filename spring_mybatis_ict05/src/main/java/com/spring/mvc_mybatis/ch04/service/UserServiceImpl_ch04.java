package com.spring.mvc_mybatis.ch04.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mvc_mybatis.ch04.dao.UserDAO_ch04;
import com.spring.mvc_mybatis.ch04.dto.SearchDTO_4;
import com.spring.mvc_mybatis.ch04.dto.UserDTO_4;


@Service
public class UserServiceImpl_ch04 implements UserService_ch04{

	
	@Autowired
	private UserDAO_ch04 dao;
	
	// 1. collection ="멤버변수"인 경우
	@Override
	public void getUserInfo1(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - getUserInfo1 ");
		
		SearchDTO_4 search = new SearchDTO_4();
		
		// id (1,2)를 배열로 생성해서 setter로 전달
		int[] userIds = new int[] {1,2};
		search.setUserIds(userIds);
		
		// 방법1. WHERE user_id IN (1,2) 로 검색
		List<UserDTO_4> list = dao.getUserInfo1(search);
		
		model.addAttribute("list",list);

		
		
		// 방법2. WHERE user_name IN (john, smith)로 검색
		search.setUserIds(null);
		search.setUserNames(Arrays.asList("john", "smith"));
		
		List<UserDTO_4> list2 = dao.getUserInfo1(search);
		model.addAttribute("list2", list2);
	}

	// 2. collection ="배열(array)"인 경우
	@Override
	public void getUserInfo2(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - getUserInfo2 ");
		
		// id 1,2를 배열로 생성하여 setter로 전달
		int[] userIds = new int[] {1,2};
		
		// 방법1. WHERE user_id IN (1,2) 로 검색
		List<UserDTO_4> list = dao.getUserInfo2(userIds);
		model.addAttribute("list", list);
	}

	
	// 3. collection ="리스트(List)"인 경우
	@Override
	public void getUserInfo3(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - getUserInfo3 ");
		
		// 방법2. WHERE user_name IN (john, smith)로 검색
		
		List<UserDTO_4> list3 = dao.getUserInfo3(Arrays.asList("john", "smith"));
		model.addAttribute("list3", list3);
	}

}
