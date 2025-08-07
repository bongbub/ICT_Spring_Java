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
	
	// dataType : 'json'인 경우
	$(function(){
		$('#btn').click(function(){
			
			$.ajax({		// jQuery + Ajax
				// url 처리
				url: '${path}/resources/data/basic4_json.js' ,			// 3. new > file > 파일명 (주의:파일내 주석달면 오류)
				type: 'GET',
				dataType : 'json',
				success: function(obj){			// 6. 콜백함수 - 전송성공시 결과 obj에 전달
					result = obj[0].name + "<br>" 
							+ obj[0].tel + "<br>"
							+ obj[0].email + "<br>"
							+ obj[0].address + "<br><br>"
							
							+obj[1].name + "<br>" 
							+ obj[1].tel + "<br>"
							+ obj[1].email + "<br>"
							+ obj[1].address + "<br><br>"
							
							+obj[2].name + "<br>" 
							+ obj[2].tel + "<br>"
							+ obj[2].email + "<br>"
							+ obj[2].address + "<br><br>";
					
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

	<!-- 2. -->
	<button id="btn" > Ajax 요청</button>
	<br><br>
	<hr>
	
	
	<div id="display">
		<!-- 결과 출력 위치 -->
		
	</div>

</body>
</html>