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
			$.ajax({		// jQuery + Ajax
				// url 처리
				url: '${path}/basic1_next.jq' ,			// 3. 컨트롤러에게 `(요청)
				type: 'GET',
				dataType: 'text',
				success: function(result){			// 6. 콜백함수 - 전송성공시 결과 result에 전달
					$('#display').html(result);
				},
				error:function(){
					alert('오류');
				}
				// callback
			})
			
		});
	});
	

</script>
</head>
<body>

	<!-- 2. -->
	<button id="btn" > Ajax 요청</button>
	<br><br>
	<hr>
	
	
	<div id="display">
		<!-- 결과 출력 위치 -->
		
	</div>

</body>
</html>