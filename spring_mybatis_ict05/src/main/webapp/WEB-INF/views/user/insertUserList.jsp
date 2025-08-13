<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertUserList</title>
</head>
<body>

	<h3> insertUserList </h3>
	
	<h5>성공 여부 : ${cnt}</h5>
	<form action="#" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 생성일 </th>
			</tr>
			<!-- 반복문 -->
			<c:forEach var="i" items="${list}">
				<tr>
					<td> ${i.userId}</td>
					<td> ${i.userName}</td>
					<td> ${i.regDate}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>