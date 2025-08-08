package com.spring.mvc_mybatis.ch01.dao;

import java.util.List;

import com.spring.mvc_mybatis.ch01.dto.UserDTO;

public interface UserDAO_ch01 {
	
	public List<UserDTO> getAddressInfo_1();
	
	public List<UserDTO> getAddressInfo_2();
}
