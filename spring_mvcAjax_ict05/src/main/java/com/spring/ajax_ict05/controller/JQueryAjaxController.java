package com.spring.ajax_ict05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.ajax_ict05.service.SearchServiceImpl;


@Controller
public class JQueryAjaxController {
	@Autowired
	private SearchServiceImpl service;
	
	
	
}
