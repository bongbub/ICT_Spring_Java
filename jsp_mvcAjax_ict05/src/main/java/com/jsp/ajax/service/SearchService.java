package com.jsp.ajax.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SearchService {
	
	public void searchList(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException;
}
