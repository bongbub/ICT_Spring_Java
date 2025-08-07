<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="${path}/resources/js/request.js"></script>
<script type="text/javascript">

	/* 3 */
	function load(url){
		//alert("load() :");
		
		/* 4 */
		sendRequest(loadNews_callback, url, "post", "");
		
	}
	
	/* 6 -> 콜백함수 - 결과처리 */
	function loadNews_callback(){
		let result = document.getElementById("news_result");
		if(httpRequest.readyState == 4){ 	// 4: ccompleted => 전체 데이터 취득 완료
			if(httpRequest.status == 200){		// 200 : 정상종료		
				// 6-1 -> 응답결과가 html이면
				result.innerHTML = httpRequest.responseText;		//responseText로 받고 XML이면 responseXML로 받아라
			}
			else{
				result.innerHTML = "states : " + httpRequest.status;
			}
		}else{
			result.innerHTML = "readyState 상태 : " + httpRequest.readyState;
		}
	}
	

</script>
</head>
<body>
	<h3> 오늘의 뉴스 </h3>
	<!-- 2. -->
	<a onclick="load('${path}/news1.do')">1만보까지 안걸어도 된다…하루 7천보면 질병예방 충분</a> <br>
	<a onclick="load('${path}/news2.do')">"배가 부글부글" 기내에서 먹으면 후회하는 음식 6</a> <br>
	<a onclick="load('${path}/news3.do')">올해 최강 LoL 팀은…월드 챔피언십 결승전, 11월 중국 청두에서</a> <br>
	<hr><br>
	
	<div id="news_result">
		<!-- 결과 출력 위치 -->
		
	</div>

</body>
</html>