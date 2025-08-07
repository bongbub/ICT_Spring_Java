package com.jsp.ajax.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jsp.ajax.service.SearchServiceImpl;

/**
 * Servlet implementation class JQueryAjaxController
 */
@WebServlet("*.jq")
public class JQueryAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JQueryAjaxController() {
        super();
    }

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
		// 1. dataType : 'text'인 경우
		if(url.equals("/basic1.jq") || url.equals("/*.jq")) {
			System.out.println(" <<< AjaxController - basic1.jq >>>");
			
			viewPage = "jquery/basic1.jsp";
		}
		
		
		// 4. 
		else if(url.equals("/basic1_next.jq")) {
			System.out.println(" <<< AjaxController - basic1_next.jq >>>");
			
			// 5.
			viewPage = "jquery/basic1_next.jsp";		// 결과를 callback 함수에 result로 전달
		}
		
		
		// 2. data : 'param'인 경우 (!!주의 : dataType 아님)--------------------------------
		else if(url.equals("/basic2.jq")) {
			System.out.println(" <<< AjaxController - basic2.jq >>>");
			
			viewPage = "jquery/basic2.jsp";		// 결과를 callback 함수에 result로 전달
		}
		else if(url.equals("/basic2_next.jq")) {
			System.out.println(" <<< AjaxController - basic2_next.jq >>>");
			
			// 5.
			viewPage = "jquery/basic2_next.jsp";		// 결과를 callback 함수에 result로 전달
		}
		
		// 3. dataType : 'XML'인 경우 -------------------------------------------------
		else if(url.equals("/basic3.jq")) {
			System.out.println(" <<< AjaxController - basic3.jq >>>");
			
			viewPage = "jquery/basic3.jsp";		// 결과를 callback 함수에 result로 전달
		}
		
		// 4-1. dataType : 'JSON'인 경우 ==> 매우 중요!!!! -------------------------------------
		else if(url.equals("/basic4.jq")) {
			System.out.println(" <<< AjaxController - basic4.jq >>>");
			
			viewPage = "jquery/basic4.jsp";		// 결과를 callback 함수에 result로 전달
		}
		
		// 4-2. dataType : 'JSON'인 경우 ==> 매우 중요!!!! -------------------------------------
		else if(url.equals("/basic5.jq")) {
			System.out.println(" <<< AjaxController - basic5.jq >>>");
			
			viewPage = "jquery/basic5.jsp";		// 결과를 callback 함수에 result로 전달
		}
		else if(url.equals("/basic5_next.jq")) {
			System.out.println(" <<< AjaxController - basic5_next.jq >>>");
			
			// basic5.jsp에서 넘긴 값을 getParameter로 받아오기
			String jsonInfo = request.getParameter("jsonInfo");
			
			// https://mvnrepository.com/ 접속 => json.simple 검색 => Google 선택 => 
			// 1.1.1 선택 => Files - view all >  json.simple-1.1.1.jar => WEB/lib 폴더에 붙여넣기 => import
			JSONParser jsonParser = new JSONParser();		// json simple.parser로 임포트
			
			try {
				// org.json.simple JSONObject 임포트
				JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonInfo);		// jsonInfo 데이터를 jsonParser를 통해 파싱하겠다
				System.out.println("--- 회원정보 ---");
				
				// 콘솔에 출력
				System.out.println("이름 : " + jsonObject.get("name"));
				System.out.println("주소 : " + jsonObject.get("address"));
				System.out.println("전화번호 : " + jsonObject.get("tel"));
				System.out.println("이메일 : " + jsonObject.get("email"));
				
				request.setAttribute("name", jsonObject.get("name"));
				request.setAttribute("tel", jsonObject.get("tel"));
				request.setAttribute("address", jsonObject.get("address"));
				request.setAttribute("email", jsonObject.get("email"));
			// import org.json.simple.parser.ParseException;	
			}catch(ParseException e) {
				e.printStackTrace();
			}
			
			viewPage = "jquery/basic5_next.jsp";		
		}
		
		// ---------- 실시간 검색 ~~ 중요!!  -------------------------------
		
		// 4-1. dataType : 'JSON'인 경우 ==> 매우 중요!!!! -------------------------------------
		else if(url.equals("/search.jq")) {
			System.out.println(" <<< AjaxController - search.jq >>>");
			
			
			viewPage = "search/search.jsp";		// 결과를 callback 함수에 result로 전달
		}
		else if(url.equals("/search_next.jq")) {
			System.out.println(" <<< AjaxController - search_next.jq >>>");
			
			SearchServiceImpl service = new SearchServiceImpl();
			service.searchList(request, response);
			
			viewPage = "search/search_next.jsp";		// 결과를 callback 함수에 result로 전달
		}
				
		
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
	}
}
