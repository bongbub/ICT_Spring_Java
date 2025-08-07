package com.spring.ajax_ict05.dao;

import java.util.List;

import com.spring.ajax_ict05.dto.SearchDTO;


public interface SearchDAO {

	
	public List<SearchDTO> searchList(String keyword);
}
