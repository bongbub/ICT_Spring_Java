package com.spring.ajax_ict05.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ajax_ict05.dto.ProductDTO;

@RestController  			// Ajax 처리 전용 컨트롤러(Spring 4.0 이상부터 작동) => URL이 아닌 데이터를 리턴함
public class JsonRestController {

	private static final Logger logger = LoggerFactory.getLogger(JsonRestController.class);
	
	@RequestMapping("/product2.jq")
	public ProductDTO product(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException{
		logger.info(" ▶▶▶ JQueryAjaxController - product.jq ◀◀◀ " );
		
		// @ResponseBody 추가 결과와 동일.-> json타입  
		// 결과 : {"product_id":"P_001","product_name":"LG GRAM","product_price":2000000}
		ProductDTO dto = new ProductDTO("P_001", "LG GRAM", 2000000);
		return dto;		// 출력 결과는 json 타입
	}
}
