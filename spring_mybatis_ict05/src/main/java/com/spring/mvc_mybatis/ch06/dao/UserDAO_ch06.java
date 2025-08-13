
package com.spring.mvc_mybatis.ch06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.mvc_mybatis.ch06.dto.UserDTO_6;

public interface UserDAO_ch06 {
	
	
   // UserDAOImpl_ch6.java, sqlMapper6.xml이 있어야 어노테이션이 작동된다.
   // sqlMapper6.xml에서 실제 sql문을 주석처리한다. @sql이 작동하도록 하기 위함
   // sql은 한줄로 작성
   // 컬럼명과 멤버변수가 일치하지 않을 경우, mapper에서는 resultMap 또는 별칭 두가지를 사용가능하나, 어노테이션에서는 별칭을 사용
	
	
	// 목록조회		// 별칭(멤버변수명)을 옆에 붙여놓는다. (as, "" 말고 직접)
	@Select("SELECT user_id userId, user_name userName, reg_date regDate FROM mvc_user_tbl ORDER BY user_id ASC")
	public List<UserDTO_6> selectUserList();
	
	// 1건 조회
	@Select("SELECT user_id userId, user_name userName, reg_date regDate FROM mvc_user_tbl WHERE user_id = #{userId}")
	public UserDTO_6 selectUser(int userId);
	
	// insert 후 목록조회
	@Insert("INSERT INTO mvc_user_tbl(user_id, user_name, reg_date) VALUES(#{userId, jdbcType=NUMERIC}, #{userName, jdbcType=VARCHAR}, #{regDate, jdbcType=DATE})")
	public int insertUser(UserDTO_6 insert);
	
	// update 후 목록조회
	@Update("UPDATE mvc_user_tbl SET user_id = #{userId}, user_name = #{userName}, reg_date = #{regDate} WHERE user_id = #{userId}")
	public int updateUser(UserDTO_6 update);
	
	// delete 후 목록조회
	@Delete("DELETE FROM mvc_user_tbl WHERE user_id = #{userId}")
	public int deleteUser(int userId);
}
