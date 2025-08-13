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

	<h3> arr2 </h3>
	<form action="#" method="post">
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
	</form>
</body>
</html>