package com.jsp.ajax.dao;

import java.util.List;

import com.jsp.ajax.dto.SearchDTO;

public interface SearchDAO {

	
	public List<SearchDTO> searchList(String keyword);
}
