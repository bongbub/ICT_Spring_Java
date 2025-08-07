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
		$('#keyword').keyup(function(){		// 키워드 입력이 끝났을 때
			let keyword = $('#keyword').val();			// keyword input에 입력한 단어를 읽어옴
			
			if(keyword.length == 0) {				// 검색 글자수가 0인 경우
				$('#display').css('visibility', 'hidden');		// display에게 hidden( 안 보임) css 속성 부여
			}
			else{
				$('#display').css('visibility', 'visible');		// 존재하면 표시(visible)
				
				$.ajax({		// jQuery + Ajax
					// url 처리
					url: '${path}/search_next.jq' ,			// 3. (아래 데이터를 갖고, )controller 호출
					type: 'POST',
					data : 'keyword=' + keyword,			// 인풋명('keyword') = 입력한 단어값(keyword)
					success: function(result){			// 6. 콜백함수 - 전송성공시 결과 obj에 전달
						$('#display').html(result);
					},
					error:function(){
						$('#display').html('오류');
					}
				});
			}
		});
	});

</script>
</head>
<body>
	<!-- 2. -->
	<h3> Ajax 검색</h3>
	<form name="searchForm" method="post" action="#">
		검색할 단어를 입력하세요. <br>
		
		<input type="text" id="keyword" name="keyword">
		
		<br><br>
	</form>
	
	<div id="display">
		<!-- 결과 출력 위치 -->
		
	</div>

</body>
</html>