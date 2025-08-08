package com.spring.mvc_mybatis.ch01.dto;

import java.sql.Date;

// 1:1 => UserDTO(부모테이블) : AddressDAO("자식테이블") => user 1명이 주소 1개를 갖고 있다. (1:1 관계)
public class UserDTO {

	// 멤버변수
	private int userId;				// PK -> mvc_user_tbl - user_id
	private String userName;		// mvc_user_tbl - user_id
	private Date regDate;			// mvc_user_tbl - user_id
	
	private AddressDTO addressDTO;			// => mvc_address_tbl 내포, - user_id 가 FK

	public UserDTO() {
		super();
	}
	public UserDTO(int userId, String userName, Date regDate, AddressDTO addressDTO) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.regDate = regDate;
		this.addressDTO = addressDTO;
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

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", regDate=" + regDate + ", addressDTO="
				+ addressDTO + "]";
	}

}

//CREATE TABLE mvc_user_tbl(
//		user_id 	NUMBER(2) PRIMARY KEY,
//		user_name   VARCHAR2(30),
//		reg_date    DATE
//	);

//CREATE TABLE mvc_address_tbl(
//		user_id 	 NUMBER(2),
//		user_address VARCHAR2(50),
//		CONSTRAINT mvc_address_tbl_user_id_fk FOREIGN KEY(user_id) REFERENCES mvc_user_tbl(user_id)
//	);