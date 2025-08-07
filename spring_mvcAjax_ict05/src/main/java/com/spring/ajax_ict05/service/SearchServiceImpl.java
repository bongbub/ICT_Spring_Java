package com.spring.ajax_ict05.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ajax_ict05.dao.SearchDAO;
import com.spring.ajax_ict05.dao.SearchDAOImpl;
import com.spring.ajax_ict05.dto.SearchDTO;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDAO dao;
	
	
	@Override
	public void searchList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 3단계 . 화면에서 입력받은 값을 가져온다
		request.setCharacterEncoding("UTF-8");
		String strText = request.getParameter("keyword");
		
		// 4단계.  싱글톤, 다형성 적용
		SearchDAO dao = SearchDAOImpl.getInstance();
		
		// 5단계. 검색처리
		List<SearchDTO> list = dao.searchList(strText);
		System.out.println(list);
		
		// 6단계. jsp에 값 전달
		request.setAttribute("list", list);
	}

}
