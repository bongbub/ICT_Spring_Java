package com.spring.mvc_mybatis.ch06.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch06.dto.UserDTO_6;

@Repository
public class UserDAOImpl_ch06 implements UserDAO_ch06{

	@Autowired
	private SqlSession sqlSession;
	
	// 목록조회
	@Override
	public List<UserDTO_6> selectUserList() {
		System.out.println(" DAO - selectUserList() ");
		
		List<UserDTO_6> list = sqlSession.selectList("com.spring.mvc_mybatis.ch06.dao.UserDAO_ch06.selectUserList");
		return list;
	}
	
	// 1건 조회
	@Override
	public UserDTO_6 selectUser(int userId) {
		System.out.println(" DAO - selectUser() ");
		
		UserDTO_6 dto = sqlSession.selectOne("com.spring.mvc_mybatis.ch06.dao.UserDAO_ch06.selectUser", userId);
		return dto;
	}
	// insert 후 목록조회
	@Override
	public int insertUser(UserDTO_6 insert) {
		System.out.println(" DAO - insertUser() ");
		int insertcnt = sqlSession.insert("com.spring.mvc_mybatis.ch06.dao.UserDAO_ch06.insertUser", insert);
		return insertcnt;
	}
	
	// update 후 목록조회
	@Override
	public int updateUser(UserDTO_6 update) {
		System.out.println(" DAO - updateUser() ");
		int updatecnt = sqlSession.update("com.spring.mvc_mybatis.ch06.dao.UserDAO_ch06.updateUser", update);
		return updatecnt;
	}
	
	
	// delete 후 목록조회
	@Override
	public int deleteUser(int userId) {
		System.out.println(" DAO - deleteUser() ");
		int deletecnt = sqlSession.delete("com.spring.mvc_mybatis.ch06.dao.UserDAO_ch06.deleteUser", userId);
		return deletecnt;
	}


}
