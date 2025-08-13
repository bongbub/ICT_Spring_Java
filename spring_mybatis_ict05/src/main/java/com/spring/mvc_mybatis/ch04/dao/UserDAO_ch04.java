package com.spring.mvc_mybatis.ch04.dao;

import java.util.List;

import com.spring.mvc_mybatis.ch04.dto.SearchDTO_4;
import com.spring.mvc_mybatis.ch04.dto.UserDTO_4;

public interface UserDAO_ch04 {
	
	public List<UserDTO_4> getUserInfo1(SearchDTO_4 search); 
	
	public List<UserDTO_4> getUserInfo2(int[] userIds); 
	
	public List<UserDTO_4> getUserInfo3(List<String> userNames); 
}
