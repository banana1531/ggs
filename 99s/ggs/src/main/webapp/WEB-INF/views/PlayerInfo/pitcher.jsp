<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>선수정보 게시판</title>
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
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>소속팀</th>
				<th>경기일자</th>
				<th>상대팀</th>
				<th>경기결과</th>
				<th>이닝수</th>
				<th>실점</th>
				<th>자책</th>
				<th>타자수</th>
				<th>타수수</th>
				<th>피안타</th>
				<th>피2루타</th>
				<th>피3루타</th>
				<th>피홈런</th>
				<th>볼넷</th>
				<th>고의4구</th>
				<th>사구</th>
				<th>삼진</th>
				<th>투구수</th>
			</tr>
			<c:forEach items="${pitcher}" var="dto">
				<tr>
					<th>${dto.teamname}</th>
					<th>${dto.gdate}</th>
					<th>${dto.vs}</th>
					<th>${dto.gresult}</th>
					<th>${dto.ining}</th>
					<th>${dto.siljum}</th>
					<th>${dto.jachak}</th>
					<th>${dto.taja}</th>
					<th>${dto.tasu}</th>
					<th>${dto.anta}</th>
					<th>${dto.eta}</th>
					<th>${dto.samta}</th>
					<th>${dto.home_run}</th>
					<th>${dto.ball4}</th>
					<th>${dto.go4}</th>
					<th>${dto.sagu}</th>
					<th>${dto.samjin}</th>
					<th>${dto.tugu}</th>
				</tr>
			</c:forEach>
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
					<a href="../player/KT?nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../player/KT?nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../player/KT?nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>