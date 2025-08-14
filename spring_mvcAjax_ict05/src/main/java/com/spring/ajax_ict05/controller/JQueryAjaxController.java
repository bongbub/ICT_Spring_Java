package com.spring.ajax_ict05.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.ajax_ict05.dto.ProductDTO;
import com.spring.ajax_ict05.service.SearchServiceImpl;


@Controller
public class JQueryAjaxController {
	@Autowired
	private SearchServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(JQueryAjaxController.class);
	
	
	// 첫 페이지
	// 1. dataType : 'text'인 경우
	@RequestMapping("/basic1.jq")
	public String basic1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic1.do ◀◀◀ " );
		return "jquery/basic1";
	}
	@RequestMapping("/basic1_next.jq")
	public String basic1_next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic1_next.do ◀◀◀ " );
		return "jquery/basic1_next";
	}
	
	
	// 2. data : 'param'인 경우 (!!주의 : dataType 아님)--------------------------------
	@RequestMapping("/basic2.jq")
	public String basic2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic2.do ◀◀◀ " );
		return "jquery/basic2";
	}
	@RequestMapping("/basic2_next.jq")
	public String basic2_next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic2_next.do ◀◀◀ " );
		return "jquery/basic2_next";
	}
	
	// 3. dataType : 'XML'인 경우 -------------------------------------------------
	@RequestMapping("/basic3.jq")
	public String basic3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic3.do ◀◀◀ " );
		return "jquery/basic3";
	}
	
	// 4-1. dataType : 'JSON'인 경우 ==> 매우 중요!!!! -------------------------------------
	@RequestMapping("/basic4.jq")
	public String basic4(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic4.do ◀◀◀ " );
		return "jquery/basic4";
	}
	
	
	// 4-2. dataType : 'JSON'인 경우 ==> 매우 중요!!!! -------------------------------------
	@RequestMapping("/basic5.jq")
	public String basic5(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic5.do ◀◀◀ " );
		return "jquery/basic5";
	}
	@RequestMapping("/basic5_next.jq")
	public String basic5_next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic5_next.do ◀◀◀ " );
		
		String jsonInfo = request.getParameter("jsonInfo");
		
		// https://mvnrepository.com/ 접속 => json.simple 검색 => Google 선택 => 1.1.1 선택 => pom.xml에 추가
		// https://mvnrepository.com/ 접속 => jackson-databind 2.14.1 선택 -> pom.xml에 추가
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
		
		return "jquery/basic5_next";
	}
	
	// ---------- 실시간 검색 ~~ 중요!!  -------------------------------
	@RequestMapping("/search.jq")
	public String search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - search.jq ◀◀◀ " );
		
		return "search/search";
	}
	@RequestMapping("/search_next.jq")
	public String search_next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - search_next.jq ◀◀◀ " );
		service.searchList(request, response);
		return "search/search_next";
	}

	// ===========================================================================================
	
	/*
	 * @RequestMapping("/product.jq") public ProductDTO product(HttpServletRequest
	 * request, HttpServletResponse response, Model model) throws ServletException,
	 * IOException{ logger.info(" ▶▶▶ JQueryAjaxController - product.jq ◀◀◀ " );
	 * ProductDTO dto = new ProductDTO("P_001", "LG GRAM", 2000000);
	 * 
	 * return dto; // 출력 결과는 json 타입 }
	 */
	// -> @ResponseBody 생략 시 404에러  파일 [/WEB-INF/views/product.jsp]을(를) 찾을 수 없습니다. (=> jsp 파일로 넘어가지 않으니까) 
	// @ResponseBody – "응답을 JSON 등으로 직접 리턴하겠다"
	// @RequestBody - " 요청의 JSON 데이터를 자바 객체로 변환해줘"
	
	// @ResponseBody 추가시, 출력 결과는 'JSON' 타입이다!
	@RequestMapping("/product.jq")
	public @ResponseBody ProductDTO product(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - product.jq ◀◀◀ " );
		ProductDTO dto = new ProductDTO("P_001", "LG GRAM", 2000000);
		
		return dto;		// 출력 결과는 json 타입
	}
	//{"product_id":"P_001","product_name":"LG GRAM","product_price":2000000} 
	
	
	
	
	@RequestMapping("/basic6.jq")
	public String basic6(HttpServletRequest reqeust, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic6.jq ◀◀◀ " );
		
		return "jquery/basic6";
	}
	
	@RequestMapping("/basic6_next.jq")
	public @ResponseBody String basic6_next(@RequestBody Map<String, Object> map)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic6_next.jq ◀◀◀ " );
		
		String id = map.get("id").toString();			// Obejct -> String
		String pwd = map.get("pwd").toString();			// Obejct -> String
		String name = map.get("name").toString();			// Obejct -> String
		
		return id + ", " + pwd + "," + name;		
	}
	
	// ---------------------------
	@RequestMapping("/basic7.jq")
	public String basic7(HttpServletRequest reqeust, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic7.jq ◀◀◀ " );
		
		return "jquery/basic7";
	}
	
	@RequestMapping("/basic7_next.jq")
	public @ResponseBody String basic7_next(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - basic7_next.jq ◀◀◀ " );
		
		
		String mode = request.getParameter("mode");
		mode += "할로방가";
		
		return mode;	
	}
	
}
