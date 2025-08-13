<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getUser</title>
</head>
<body>

	<h3> getUser </h3>
	
	<form action="#" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 생성일 </th>
			</tr>
			<!-- 반복문 -->
				<tr>
					<td> ${dto.userId}</td>
					<td> ${dto.userName}</td>
					<td> ${dto.regDate}</td>
				</tr>
		</table>
	</form>
</body>
</html>