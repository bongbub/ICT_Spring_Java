<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.7.1.min.js"></script>

<script type="text/javascript">

$(function(){
	$('#btn').click(function(){
		let obj = new Object();
		obj.id = "james";
		obj.pwd= "james1234";
		obj.name="jame!";
		
		// 자바스크립트 객체를 String 객체로 변환
		let jsonData = JSON.stringify(obj);
		
		$.ajax({
			url:'${path}/basic6_next.jq',		// 3. 컨트롤러 basic6_next.jq 홏출
			type: 'POST',
			data: jsonData,
			contentType: 'application/json;charset=UTF-8',	// 오타 주의!
			success: function(result){			// 콜백함수 호출 ㅋㅋ
				alert("콜백!");
				$('#display').html(result);
			},
			error: function(){
				alert('오류');
			}
		});
		
	});
})

</script>
</head>
<body>
	<!-- JSON이란?  => 중요
    자바스크립트 객체 표기법을 JSON(JavaScript Object Notation)이라고 한다.
    JSON은 데이터를 전달할 때 사용하는 표준 형식으로, JSON은 속성(key)과 값(value)이 하나의 쌍을  이루고 있다.
      
    기본형 => {"속성1":값1, "속성2":값2, "속성3":값3,...}
    배열{객체} => [{"속성1":값1, "속성2":값2, "속성3":값3,...}, {"속성1":값1, "속성2":값2, "속성3":값3,...}...]
    -->
    
    <h4>JSON인 경우!</h4>
	<i class="fa-solid fa-dice-six"></i>
	<!-- 2. -->
	<button id="btn" > Ajax 요청</button>
	<br><br>
	<hr>
	
	
	<div id="display">
		<!-- 결과 출력 위치 -->
		
	</div>

</body>
</html>