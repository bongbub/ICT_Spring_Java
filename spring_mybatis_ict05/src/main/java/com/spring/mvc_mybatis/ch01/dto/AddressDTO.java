package com.spring.mvc_mybatis.ch01.dto;

public class AddressDTO {

	// 멤버변수
	// private int userId;				// FK => mvc_address_tbl - user_id
	private String userAddress;		// 		     mvc_address_tbl - user_address

	public AddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddressDTO(String userAddress) {
		super();
		this.userAddress = userAddress;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "AddressDTO [userAddress=" + userAddress + "]";
	}
	
}

//CREATE TABLE mvc_address_tbl(
//	user_id 	 NUMBER(2),
//	user_address VARCHAR2(50),
//	CONSTRAINT mvc_address_tbl_user_id_fk FOREIGN KEY(user_id) REFERENCES mvc_user_tbl(user_id)
//);