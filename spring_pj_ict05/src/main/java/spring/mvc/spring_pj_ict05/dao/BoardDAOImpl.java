package spring.mvc.spring_pj_ict05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.BoardCommentDTO;
import spring.mvc.spring_pj_ict05.dto.BoardDTO;


@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 게시글 목록
	@Override
	public List<BoardDTO> boardList(Map<String, Object> map) {
		System.out.println("<<< BoardDAOImpl ==> boardList() >>>");
		
			// 1-1. DB연결
			// 1-2. SQL문 생성
			// 2-1. 데이터가 존재하면
			// 4. List에 dto를 추가한다
		List<BoardDTO> list = sqlSession.selectList("spring.mvc.spring_pj_ict05.dao.BoardDAO.boardList" , map);
		
		
		// 5. list를 리턴
		return list;
	}

	
	// 게시글 갯수 구하기
	@Override
	public int boardCnt() {
		System.out.println(" <<< BoardDAOImpl - boardCnt() >>>");
		int total = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.boardCnt");
		return total;
	}
	

	// 조회수 증가
	@Override
	public void plusReadCnt(int num) {
		System.out.println(" <<< BoardDAOImpl - plusReadCnt() >>>");
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.plusReadCnt", num);
	}

	// 게시글 상세 처리
	@Override
	public BoardDTO getBoardDetail(int num) {
		System.out.println(" <<< BoardDAOImpl - getBoardDetail() >>>");
		
		BoardDTO dto = new BoardDTO();
		dto = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.getBoardDetail", num);
		return dto;
	}

	// 게시글 수정삭제 버튼 클릭 시 - > 비밀번호 인증 처리
	@Override
	public int password_chk(Map<String, Object> map) {
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.BoardDAO.password_chk", map);
		return selectCnt;
	}

	// 게시글 수정 처리
	@Override
	public void updateBoard(BoardDTO dto) {
			sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.updateBoard",dto);
	}

//	// 추가 후 작성한 게시글로 이동
//	public int moveRecentBoard(String writer) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int num = 0;
//		try {
//			String sql="SELECT max(b_num) as num FROM mvc_board_tbl WHERE b_writer = ? ";
//			conn = dataSource.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, writer);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				num = rs.getInt("num");
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(conn != null) conn.close();
//				if(pstmt != null) pstmt.close();
//				if(rs != null) rs.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return num;
//	}

	// 게시글 삭제 처리
	@Override
	public void deleteBoard(int num) {
		sqlSession.update("spring.mvc.spring_pj_ict05.dao.BoardDAO.deleteBoard" , num);
	}
	/*	
	// 게시글 작성 처리
	@Override
	public void insertBoard(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			String sql ="INSERT INTO mvc_board_tbl(b_num, B_TITLE, B_WRITER, B_CONTENT, "
					+ "B_PASSWORD)"
					+ "	values((SELECT nvl(MAX(b_num)+1,1) FROM mvc_board_tbl), ?, ?, ?, ?)";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getB_title());
			pstmt.setString(2, dto.getB_writer());
			pstmt.setString(3, dto.getB_content());
			pstmt.setString(4, dto.getB_password());

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 댓글 작성 처리
	@Override
	public int insertComment(BoardCommentDTO dto) {
		// 1. List 생성
		List<BoardCommentDTO> list = new ArrayList<BoardCommentDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int insertCnt = 0;
		
		try {
			String sql = "INSERT INTO mvc_comment_tbl(c_comment_num, c_board_num, c_writer, c_content)"
					+ " Values((SELECT nvl(MAX(c_comment_num)+1, 1) FROM mvc_comment_tbl), ?, ?, ?)";
			
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getC_board_num());
			pstmt.setString(2, dto.getC_writer());
			pstmt.setString(3, dto.getC_content());
			
			insertCnt = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCnt;
	}
	
	@Override
	public void commentCount(int b_num){
		System.out.println("<<< BoardDAOImpl ==> commentCount() >>>");
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		int updateCnt = 0;
		try{
			String sql = "UPDATE mvc_board_tbl SET b_comment_count = b_comment_count + 1 WHERE b_num = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_num);
			updateCnt = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try{
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return updateCnt;
	}
	
	// 댓글 목록 처리
	@Override
	public List<BoardCommentDTO> commentList(int board_num) {
		System.out.println("<<< BoardDAOImpl ==> commentList() >>>");
		
		Connection conn = null;				// 오라클 연결
		PreparedStatement pstmt = null;		// SQL문장
		ResultSet rs = null;				// SELECT 결과를 담기 위함
		
		// 1. List 생성
		List<BoardCommentDTO> list = new ArrayList<BoardCommentDTO>();
		try {
			// 1-1. DB연결
			conn = dataSource.getConnection();
			
			// 1-2. SQL문 생성
			String sql = "SELECT *"
	                  + " FROM"
	                  + "     (SELECT A.*"
	                  + "             , rownum AS rn"
	                  + "          FROM"
	                  + "             (SELECT * "
	                  + "            FROM mvc_comment_tbl c,"
	                  + "                 mvc_board_tbl b "
	                  + "            WHERE b.b_num = c.c_board_num "
	                  + "              AND b_num = ? "
	                  + "           ORDER BY c_comment_num DESC) A"
	                  + "    )"
	                  + " ORDER BY rn desc";
			
			// 2. 데이터가 존재하면 DTO 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();
			
			// 2-1. 데이터가 존재하면
			while(rs.next()) {
				// dto 생성하고 담는다
				BoardCommentDTO dto = new BoardCommentDTO();
				// 3. dto에 1건의 rs 게시글 정보를 담는다.
				dto.setC_comment_num(rs.getInt("rn"));
				dto.setC_board_num(rs.getInt("c_board_num"));
				dto.setC_writer(rs.getString("c_writer"));
				dto.setC_content(rs.getString("c_content"));
				dto.setC_regDate(rs.getDate("c_regDate"));
				
				// 4. List에 dto를 추가한다
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 5. list를 리턴
		return list;
	}
	
	*/
}
