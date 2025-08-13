package com.spring.mvc_mybatis.ch05.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch05.dto.UserDTO_5;

@Repository
public class UserDAOImpl_ch05 implements UserDAO_ch05{

	@Autowired
	private SqlSession sqlSession;
	
	// 목록조회
	@Override
	public List<UserDTO_5> selectUserList() {
		System.out.println(" DAO - selectUserList() ");
		
		List<UserDTO_5> list = sqlSession.selectList("com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05.selectUserList");
		return list;
	}
	
	// 1건 조회
	@Override
	public UserDTO_5 selectUser(int userId) {
		System.out.println(" DAO - selectUser() ");
		
		UserDTO_5 dto = sqlSession.selectOne("com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05.selectUser", userId);
		return dto;
	}
	// insert 후 목록조회
	@Override
	public int insertUser(UserDTO_5 insert) {
		System.out.println(" DAO - insertUser() ");
		int insertcnt = sqlSession.insert("com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05.insertUser", insert);
		return insertcnt;
	}
	
	// update 후 목록조회
	@Override
	public int updateUser(UserDTO_5 update) {
		System.out.println(" DAO - updateUser() ");
		int updatecnt = sqlSession.update("com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05.updateUser", update);
		return updatecnt;
	}
	
	
	// delete 후 목록조회
	@Override
	public int deleteUser(int userId) {
		System.out.println(" DAO - deleteUser() ");
		int deletecnt = sqlSession.delete("com.spring.mvc_mybatis.ch05.dao.UserDAO_ch05.deleteUser", userId);
		return deletecnt;
	}


}
