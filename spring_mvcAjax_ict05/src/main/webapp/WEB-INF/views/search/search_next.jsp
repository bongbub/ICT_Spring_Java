<%@page import="com.jsp.ajax.dto.SearchDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>

<form name="listForm" method="post">
검색결과 :<br>
	<c:forEach var="i" items="${list}">
		 ${i.keyword}<br>
	</c:forEach> 
	
	
</form>
</body>
</html>