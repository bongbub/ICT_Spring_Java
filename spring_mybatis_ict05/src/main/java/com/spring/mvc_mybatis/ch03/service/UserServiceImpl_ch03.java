package com.spring.mvc_mybatis.ch03.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.mvc_mybatis.ch03.dao.UserDAO_ch03;
import com.spring.mvc_mybatis.ch03.dto.BoardDTO_3;
import com.spring.mvc_mybatis.ch03.dto.SearchDTO_3;
import com.spring.mvc_mybatis.ch03.dto.UserDTO_3;

@Service
public class UserServiceImpl_ch03 implements UserService_ch03{

	// DAO 다형성 연결
	@Autowired
	private UserDAO_ch03 dao;

	@Override
	public void getSearchInfo_1(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ▣▣▣ UserServiceImpl_ch03 - getSearchInfo_1 ▣▣▣");
		
		SearchDTO_3 search = new SearchDTO_3();
		search.setUserName("john");  			// 대소문자 고분
		
		BoardDTO_3 board = new BoardDTO_3();
		board.setBoardTitle("");			// isEmpty() : true
		board.setBoardContent("반복문");
		
		search.setBoardDTO(board);
		
		List<UserDTO_3> list = dao.getSearchInfo_1(search);		// john과 "반복문"이 들어있는 search 넘김
		model.addAttribute("list", list);
//		아이디	이름	생성일	게시글 제목	내용
//		1	john	2025-08-08	자바	반복문
	}

	@Override
	public void getSearchInfo_2(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ▣▣▣ UserServiceImpl_ch03 - getSearchInfo_2 ▣▣▣");
		
		SearchDTO_3 search = new SearchDTO_3();
		search.setUserName("john");		// 대소문자 구분
		
		BoardDTO_3 board = new BoardDTO_3();
		board.setBoardTitle(null);
		board.setBoardContent("반복문");
		search.setBoardDTO(board);
		
		List<UserDTO_3> list = dao.getSearchInfo_2(search);
		model.addAttribute("list", list);
		

//		아이디	이름	생성일	게시글 제목	내용
//		1	john	2025-08-08	자바	반복문
	}
	
	@Override
	public void getSearchInfo_3(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ▣▣▣ UserServiceImpl_ch03 - getSearchInfo_3 ▣▣▣");
		
		SearchDTO_3 search = new SearchDTO_3();
		search.setUserName(null);		// 대소문자 구분
		
		BoardDTO_3 board = new BoardDTO_3();
		board.setBoardTitle(null);
		board.setBoardContent("활용");
		search.setBoardDTO(board);
		
		List<UserDTO_3> list = dao.getSearchInfo_3(search);
		model.addAttribute("list", list);		
		

//		아이디	이름	생성일	게시글 제목	내용
//		2	terry	2025-08-08	스프링	mybatis 활용
//		2	terry	2025-08-08	JSP 응용	mvc 활용
		
	}

	@Override
	public void updateUser(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ▣▣▣ UserServiceImpl_ch03 - updateUser ▣▣▣");
		
		UserDTO_3 user = new UserDTO_3();
		user.setUserId(2);
		user.setUserName("곰돌이");
		user.setRegDate(null);		// 이름만 바꾸고 나머지는 그대롱
		
		int updateCnt = dao.updateUser(user);		// update했음
		
		if(updateCnt != 0) {		// update 성공이면 
			// tutle이 '스프링'인 것을 찾겠다
			SearchDTO_3 search = new SearchDTO_3();
			search.setUserName(user.getUserName());			// "곰돌이" 로 시작된 정보
			
			
			BoardDTO_3 board = new BoardDTO_3();
			board.setBoardTitle("스프링");
			board.setBoardContent(null);
			
			search.setBoardDTO(board);		// 보드정보 담기  --> 제목에 '스프링'이 들어가는 정보
			
			List<UserDTO_3> list = dao.getSearchInfo_3(search); 		// getSearchInfo_3로 검색!		
			
			model.addAttribute("list", list);
			model.addAttribute("updateCnt", updateCnt);
			
//			아이디	이름	생성일	게시글 제목	내용
//			2	곰돌이	2025-08-08	스프링	mybatis 활용
		}
		
	}

	@Override
	public void getUserSearchInfo(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
		System.out.println(" ▣▣▣ UserServiceImpl_ch03 - getUserSearchInfo ▣▣▣");
		
		UserDTO_3 user = dao.getUserSearchInfo("john");
		model.addAttribute("user",user);
		
	}


}
