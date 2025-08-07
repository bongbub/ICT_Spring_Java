package com.spring.ajax_ict05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.spring.ajax_ict05.dto.SearchDTO;

@Repository
public class SearchDAOImpl implements SearchDAO{
	

	DataSource dataSource = null;
	static SearchDAOImpl instance = new SearchDAOImpl();
	
	public static SearchDAOImpl getInstance() {
		if(instance == null) {
			instance = new SearchDAOImpl();
		}
		return instance;
	}
	
	private SearchDAOImpl() {
		try {
			InitialContext context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/jsp_pj_ict05");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<SearchDTO> searchList(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SearchDTO> list = new ArrayList<SearchDTO>();
		try {
			String sql = "SELECT * FROM mvc_search_tbl WHERE keyword LIKE upper('%' || ? || '%')";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SearchDTO dto = new SearchDTO();
				dto.setKeyword(rs.getString("keyword"));
				list.add(dto);
				System.out.println(list);
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
		return list;
	}

}
