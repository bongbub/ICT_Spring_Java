package com.spring.mvc_mybatis.ch01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch01.dto.UserDTO;

@Repository
public class UserDAOImpl_ch01 implements UserDAO_ch01{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<UserDTO> getAddressInfo_1() {
		System.out.println(" === [[[ UserDAOImpl_ch01 - getAddressInfo_1() ]]] === ");
		
		List<UserDTO> list = sqlSession.selectList("com.spring.mvc_mybatis.ch01.dao.UserDAO_ch01.getAddressInfo_1");
		return list;
	}

	@Override
	public List<UserDTO> getAddressInfo_2() {
		List<UserDTO> list = sqlSession.selectList("com.spring.mvc_mybatis.ch01.dao.UserDAO_ch01.getAddressInfo_2");
		return list;
	}
	

}
