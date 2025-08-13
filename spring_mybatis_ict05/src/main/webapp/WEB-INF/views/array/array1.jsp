<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버변수일 때</title>
</head>
<body>

	<h3> 멤버변수일 때(1,2) </h3>
	<form action="#" method="post">
	
		방법1. WHERE user_id IN (1,2) 일때
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 생성일 </th>
			</tr>
			<c:forEach var="i" items="${list}">
				<tr>
					<td> ${i.userId}</td>
					<td> ${i.userName}</td>
					<td> ${i.regDate}</td>
				</tr>
			</c:forEach>
		</table>
		
		방법2. WHERE user_name IN (john, smith)로 검색
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 생성일 </th>
			</tr>
			<c:forEach var="i2" items="${list2}">
				<tr>
					<td> ${i2.userId}</td>
					<td> ${i2.userName}</td>
					<td> ${i2.regDate}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>