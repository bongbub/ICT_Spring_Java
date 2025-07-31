package spring.mvc.spring_pj_ict05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.InitialContext;		// 주의!
import javax.naming.NamingException;
import javax.sql.DataSource;			// 주의!

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.spring_pj_ict05.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	// 싱글톤 객체 생성  => @Repository -> @Autowired로 시행됨
	
	// 커넥션풀(DBCP : DataBase Connection Pool 방식) - 톰캣파일(Servers)내에있음 context.xml에 설정
	// 커넥션풀이랑 마이바티스 처리할 XML 생성(src/main/resources/-> New Spring Bean Configuration file > dataSource-config.xml 
	// 커넥션풀(context.xml)에 설정 + 마이바티스 경로  ==> dataSource-config.xml 에서 구현
	
	// dataSource-config.xml에서 구현 => 커넥션풀(context.xml에 설정) + 마이바티스 경로
	// Mybatis jar 파일들이 pom.xml에 등록되어 있어야 SqlSession(=인터페이스) 이 import 가능
	// dataSource-config.xml에 bean id="sqlSession" 으로 설정되어있어야함
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// ID 중복 확인 처리
	@Override
	public int useridCheck(String strId) {
		int selectCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.useridCheck", strId);
		return selectCnt;
	}

	
	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		System.out.println("CustomerDAOImpl - insertCustomer() ");
		int insertCnt = sqlSession.insert("spring.mvc.spring_pj_ict05.dao.CustomerDAO.insertCustomer", dto);
			
		return insertCnt ;
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idPasswordChk(Map<String, Object> map) {
		
		int loginCnt = sqlSession.selectOne("spring.mvc.spring_pj_ict05.dao.CustomerDAO.idPasswordChk", map);
			
		return loginCnt;
	}

	/*
	// 회원정보 인증처리 및 탈퇴처리 
	@Override
	public int deleteCustomer(String strId) {
		int deleteCnt = 0;
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			String query = "DELETE FROM mvc_customer_tbl WHERE user_id=?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, strId);
			deleteCnt = pstmt.executeUpdate();
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
		return deleteCnt;
	}

	// 상세페이지 조회
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		CustomerDTO dto = new CustomerDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM mvc_customer_tbl WHERE user_id = ?";
		try {
			conn = dataSource.getConnection();
			pstmt =  conn.prepareStatement(query);
			pstmt.setString(1, strId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_password(rs.getString("user_password"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_birthday(rs.getDate("user_birthday"));
				dto.setUser_address(rs.getString("user_address"));
				dto.setUser_hp(rs.getString("user_hp"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_regdate(rs.getTimestamp("user_regdate"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// 회원정보 수정처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		String query = "UPDATE mvc_customer_tbl SET user_password=? ,"
				+ " user_name=?, user_birthday=? , user_address=? , user_hp=? , user_email=?, user_regdate=? WHERE user_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updateCnt = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getUser_password());
			pstmt.setString(2, dto.getUser_name());
			pstmt.setDate(3, dto.getUser_birthday());
			pstmt.setString(4, dto.getUser_address());
			pstmt.setString(5, dto.getUser_hp());
			pstmt.setString(6, dto.getUser_email());
			pstmt.setTimestamp(7, dto.getUser_regdate());
			pstmt.setString(8, dto.getUser_id());
			
			updateCnt = pstmt.executeUpdate();
			
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
		return updateCnt;
	}
	 */	

}
