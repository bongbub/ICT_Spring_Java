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
	
	// dataType : 'xml'인 경우
	$(function(){
		$('#btn').click(function(){
			
			$.ajax({		// jQuery + Ajax
				// url 처리
				url: '${path}/resources/data/basic3_data.xml' ,			// 3. new > other > xml > XML File > 파일명
				type: 'GET',
				dataType : 'xml',
				success: function(result){			// 6. 콜백함수 - 전송성공시 결과 result에 전달
					let strText = "";
					$(result).find('holiday').each(function(){		// result 내에서 holiday란걸 검색해서 반복
						let item_text = $(this).text();			// 각각의 정보를 가져와 실제 텍스트 값을 추출하라
						strText += item_text;			// strText에 현재 가져온 값들을 누적해라
						$('#display').html(strText);
				});
					
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