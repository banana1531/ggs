<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>팀정보 게시판</title>
<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<%-- 목록 출력 --%>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>팀이름</th>
				<th>전화/팩스</th>
				<th>홈페이지</th>
				<th>창단년도</th>
				<th>연고지역</th>
				<th>구장</th>
				<th>구단주</th>
				<th>대표이사</th>
				<th>단장</th>
				<th>감독</th>
				<th>우승횟수(연도)</th>				
			</tr>
			<%-- 반복문을 이용하여 줄출력 예정 --%>
			<c:forEach items="${InfoKIA}" var="dto">
				<tr>
					<td>${dto.teamName}</td>
					<td>${dto.tel}</td>
					<td>${dto.homepage}</td>
					<td>${dto.birth}</td>
					<td>${dto.location}</td>
					<td>${dto.stadium}</td>
					<td>${dto.owner}</td>
					<td>${dto.ceo}</td>
					<td>${dto.head}</td>
					<td>${dto.director}</td>
					<td>${dto.history}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
