package com.jsp.ajax.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxController() {
        super();
    }

    // 1단계. 웹브라우저가 전송한 HTTP 전송을 받음
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		action(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void action(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		
		// 2단계) 클라이언트 요청 분석
		
		// 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = uri.substring(contextPath.length());
		String viewPage = "";
		
		
		// 첫 페이지
		if(url.equals("/simple.do") || url.equals("/*.do")) {
			System.out.println(" <<< AjaxController - simple.do >>>");
			
			viewPage = "basic/simple.jsp";
		}
		
		
		// --------------- News --------------------------------
		// 1. 
		else if(url.equals("/responseNews.do")) {			// 요청페이지
			System.out.println(" <<< AjaxController - responseNews.do >>>");
			
			viewPage = "news/responseNews.jsp";
		}
		else if(url.equals("/news1.do")) {					// 첫 번째 뉴스페이지의 정보를 읽어서 요청페이지 하단에 출력
			System.out.println(" <<< AjaxController - news1.do >>>");
			
			viewPage = "news/news1.jsp";
		}
		else if(url.equals("/news2.do")) {					// 두 번째 뉴스페이지의 정보를 읽어서 요청페이지 하단에 출력
			System.out.println(" <<< AjaxController - news2.do >>>");
			
			viewPage = "news/news2.jsp";
		}
		else if(url.equals("/news3.do")) {					// 세 번째 뉴스페이지의 정보를 읽어서 요청페이지 하단에 출력
			System.out.println(" <<< AjaxController - news3.do >>>");
			
			viewPage = "news/news3.jsp";
		}
		
		
		// ----------------book------------------------------------------
		// 1
		else if(url.equals("/responseBook.do")) {			// 요청페이지
			System.out.println(" <<< AjaxController - responseBook.do >>>");
			
			viewPage = "book/responseBook.jsp";
		}
		// 5.
		else if(url.equals("/bookInfo.do")) {					 
			System.out.println(" <<< AjaxController - bookInfo.do >>>");
			
			viewPage = "book/bookInfo.jsp";		// 결과페이지 -> 요청페이지 하단에 출력
		}
		
		
		
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
		
	}

}
