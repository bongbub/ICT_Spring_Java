<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!-- 5. 결과페이지 : 갓다가 콜백함수(=result)로 전달 => display에 뿌림  -->

<!-- 방법1) 전달받은 후 표현식으로 출력 -->
<%
	// 한ㄴ글 안 깨지게
	request.setCharacterEncoding("UTF-8");
	String strName = (String)request.getAttribute("name");
	String strtel = (String)request.getAttribute("tel");
	String stradd = (String)request.getAttribute("address");
	String stremail = (String)request.getAttribute("email");
%>
이름 : <%= strName %> <br>
전화번호 : <%= strtel %><br>
주소 : <%= stradd %><br>
이메일 <%= stremail %><br>

<br><hr><br>
<!-- 방법2) 전달받은 후 EL태그로 출력 -->
이름 : ${name}<br>
전화번호 : ${tel}<br>
주소 :  ${address}<br>
이메일 :  ${email}<br>
