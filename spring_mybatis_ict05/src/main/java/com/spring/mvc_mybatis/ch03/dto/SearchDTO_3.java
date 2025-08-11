package com.spring.mvc_mybatis.ch03.dto;

// 검색 키워드 - 작성자명 | 게시글 타이틀, 게시글 내용
public class SearchDTO_3 {
	
	
	private String userName;			// 작성자명
	private BoardDTO_3 boardDTO;		// 게시글 정보(게시글 타이틀, 게시글 내용)
	
	
	public SearchDTO_3() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SearchDTO_3(String userName, BoardDTO_3 boardDTO) {
		super();
		this.userName = userName;
		this.boardDTO = boardDTO;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public BoardDTO_3 getBoardDTO() {
		return boardDTO;
	}


	public void setBoardDTO(BoardDTO_3 boardDTO) {
		this.boardDTO = boardDTO;
	}


	@Override
	public String toString() {
		return "SearchDTO_3 [userName=" + userName + ", boardDTO=" + boardDTO + "]";
	}
	
}
