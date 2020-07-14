<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>경기 예측 페이지 메인이 됩니다</h1>
	
	<!-- 이동버튼 -->
	
	<!-- 회원 보유 포인트 순위 -->
	<div class="container">
	<p>승부예측</p>
		<table class="table">
		<td>순위</td>
		<td>아이디</td>
		<td>보유 포인트 현황</td>	
	</tr>
	<c:forEach items="${boardlist}" var="list">
		<tr>
		<td>1</td>
		<td>${list.id}</td>
		<td>${list.ppoint}</td>
	</tr>
	</c:forEach>
	</table>
	</div>
	<!-- 금일 경기 리스트 -->
	
</body>
</html>