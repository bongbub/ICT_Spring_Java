package com.spring.mvc_mybatis.ch03.dto;


public class BoardDTO_3 {

	private int boardNum;				// mvc_board_tbl - board_num : pk
	private String boardTitle;			// mvc_board_tbl - board_title
	private String boardContent;		// mvc_board_tbl - board_content
	
	// 여기까지 하고 디폴트 생성자 + 매개변수 생성자 + getter, setter + toString() 생성
	
	
	public BoardDTO_3() {
		super();
	}
	public BoardDTO_3(int boardNum, String boardTitle, String boardContent) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	@Override
	public String toString() {
		return "BoardDTO_2 [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ "]";
	}
	
}
//	DROP TABLE mvc_board_tbl CASCADE CONSTRAINTS;
//	CREATE TABLE mvc_board_tbl(
//		board_num    NUMBER(3) PRIMARY KEY,
//		board_title  VARCHAR2(50),
//		board_content VARCHAR2(100),
//		user_id 	 NUMBER(2),
//		CONSTRAINT mvc_board_tbl_user_id_fk FOREIGN KEY(user_id) REFERENCES mvc_user_tbl(user_id)
//	);
