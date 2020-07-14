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
	페이징관련 정보<br/>
	nowPage=${PINFO.nowPage} / startPage=${PINFO.startPage} /
	endPage=${PINFO.endPage}<br/>
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
			<c:forEach items="${InfoDS}" var="dto">
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
	<hr />
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>승</th>
				<th>무</th>
				<th>패</th>
				<th>득점</th>
				<th>실점</th>
			</tr>
			<tr>
				<c:forEach items="${DSWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${DSDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${DSLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${DSScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${DSLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<hr />
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>경기일자</th>
				<th>경기시간</th>
				<th>팀명</th>
				<th>점수</th>
				<th>팀명</th>
				<th>점수</th>
				<th>구장</th>
			</tr>
			<tr>
				<c:forEach items="${ScheduleDS}" var="dto">
					<tr>
						<td>${dto.gdate}</td>
						<td>${dto.gtime}</td>
						<td>${dto.ateamname}</td>
						<td>${dto.ascore}</td>
						<td>${dto.bteamname}</td>
						<td>${dto.bscore}</td>
						<td>${dto.stadium}</td>
					</tr>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<%-- 페이징 처리 --%>
	<table border="1" width="800" class="center">
		<tbody>
			<tr class="center">
				<td>
					<c:if test="${PINFO.nowPage eq 1}">
					[prev] 
					</c:if>
				
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="../team/DS?nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../team/DS?nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../team/DS?nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="./list">리스트로가기</a>
</body>
</html>
