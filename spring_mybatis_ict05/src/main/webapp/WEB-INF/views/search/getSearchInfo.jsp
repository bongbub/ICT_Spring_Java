<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getSearchInfo</title>
</head>
<body>

	<h3> getUserSearchInfo </h3>
	<form action="#" method="post">
		<table border="1" cellspacing="0" cellpadding="5">
			<tr>
				<th> 아이디 </th>
				<th> 이름 </th>
				<th> 생성일 </th>
				<th> 게시글 제목 </th>
				<th> 내용 </th>
			</tr>
			<!-- 반복문 -->
			<c:forEach var="user" items="${list}">
				<c:forEach var="board" items="${user.boardDTO}">
					<tr>
						<td>${user.userId}	</td>
						<td>${user.userName}	</td>
						<td>${user.regDate}	</td>
						<td>${board.boardTitle}	</td>
						<td>${board.boardContent}	</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
	</form>
</body>
</html>