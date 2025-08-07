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
	
	// data : 'json'인 경우
	$(function(){
		$('#btn').click(function(){
			
			let _jsonInfo = '{"name":"신짱구", "tel": "010-1212-3434","email" : "jjang@gmail.com","address":"떡잎마을"}';
			
			$.ajax({		// jQuery + Ajax
				// url 처리
				url: '${path}/basic5_next.jq' ,			// 3. (아래 데이터를 갖고, )controller 호출
				type: 'POST',
				data : {jsonInfo : _jsonInfo},			// jsp의 setAttribute와 동일 = > {key : value}
				success: function(result){			// 6. 콜백함수 - 전송성공시 결과 obj에 전달
					$('#display').html(result);
				},
				error:function(){
					alert('오류');
				}
			});
		});
	});

</script>
</head>
<body>
	<!-- JSON이란?  => 중요
    자바스크립트 객체 표기법을 JSON(JavaScript Object Notation)이라고 한다.
    JSON은 데이터를 전달할 때 사용하는 표준 형식으로, JSON은 속성(key)과 값(value)이 하나의 쌍을  이루고 있다.
      
    기본형 => {"속성1":값1, "속성2":값2, "속성3":값3,...}
    배열{객체} => [{"속성1":값1, "속성2":값2, "속성3":값3,...}, {"속성1":값1, "속성2":값2, "속성3":값3,...}...]
    -->
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