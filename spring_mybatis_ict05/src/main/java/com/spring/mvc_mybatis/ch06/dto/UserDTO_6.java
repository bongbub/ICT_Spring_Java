package com.spring.mvc_mybatis.ch06.dto;

import java.sql.Date;

// 1:N => UserDTO_2(부모테이블) : BoardDTO("자식테이블") => user 1명이 게시글 N개를 갖고 있다. (1:N 관계)
public class UserDTO_6 {

	// 멤버변수
	private int userId;				// PK -> mvc_user_tbl - user_id
	private String userName;		// mvc_user_tbl - user_id
	private Date regDate;			// mvc_user_tbl - user_id

	public UserDTO_6(int userId, String userName, Date regDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
	}
	public UserDTO_6() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}

//CREATE TABLE mvc_user_tbl(
//		user_id 	NUMBER(2) PRIMARY KEY,
//		user_name   VARCHAR2(30),
//		reg_date    DATE
//	);
