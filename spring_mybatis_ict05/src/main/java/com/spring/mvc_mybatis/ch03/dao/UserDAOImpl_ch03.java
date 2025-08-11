package com.spring.mvc_mybatis.ch03.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc_mybatis.ch03.dto.SearchDTO_3;
import com.spring.mvc_mybatis.ch03.dto.UserDTO_3;

@Repository
public class UserDAOImpl_ch03 implements UserDAO_ch03{

	// sqlSession
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserDTO_3> getSearchInfo_1(SearchDTO_3 search) {
		System.out.println(" ▶▶▶ UserDAOImpl_ch03 - getSearchInfo_1 ◀◀◀");
		// 매개변수 SearchDTO_3 에는 userName과 BoardDTO_3(boardContent)가 담겨있음
		List<UserDTO_3> list = sqlSession.selectList("com.spring.mvc_mybatis.ch03.dao.UserDAO_ch03.getSearchInfo_1", search);
		return list;
	}

	@Override
	public List<UserDTO_3> getSearchInfo_2(SearchDTO_3 search) {
		System.out.println(" ▶▶▶ UserDAOImpl_ch03 - getBoardInfo_2 ◀◀◀");
		List<UserDTO_3> list = sqlSession.selectList("com.spring.mvc_mybatis.ch03.dao.UserDAO_ch03.getSearchInfo_2", search);
		return list;
	}

	@Override
	public List<UserDTO_3> getSearchInfo_3(SearchDTO_3 search) {
		System.out.println(" ▶▶▶ UserDAOImpl_ch03 - getBoardInfo_3 ◀◀◀");
		List<UserDTO_3> list = sqlSession.selectList("com.spring.mvc_mybatis.ch03.dao.UserDAO_ch03.getSearchInfo_3", search);
		return list;
	}

	@Override
	public int updateUser(UserDTO_3 user) {
		System.out.println(" ▶▶▶ UserDAOImpl_ch03 - updateUser ◀◀◀");
		int updateCnt = sqlSession.update("com.spring.mvc_mybatis.ch03.dao.UserDAO_ch03.updateUser", user);
		return updateCnt;
	}

	@Override
	public UserDTO_3 getUserSearchInfo(String userName) {
		System.out.println(" ▶▶▶ UserDAOImpl_ch03 - getUserSearchInfo ◀◀◀");
		
		UserDTO_3 user = sqlSession.selectOne("com.spring.mvc_mybatis.ch03.dao.UserDAO_ch03.getUserSearchInfo", userName);
		return user;
	}
	


}
