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
	<a href="../player/teamList?teamname=KIA">KIA</a>
	<a href="../player/teamList?teamname=KT">KT</a>
	<a href="../player/teamList?teamname=LG">LG</a>
	<a href="../player/teamList?teamname=NC">NC</a>
	<a href="../player/teamList?teamname=SK">SK</a>
	<a href="../player/teamList?teamname=두산">두산</a>
	<a href="../player/teamList?teamname=롯데">롯데</a>
	<a href="../player/teamList?teamname=삼성">삼성</a>
	<a href="../player/teamList?teamname=키움">키움</a>
	<a href="../player/teamList?teamname=한화">한화</a>
	<br/>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>선수번호</th>
				<th>이름</th>
				<th>등번호</th>
				<th>생년월일</th>
				<th>포지션</th>
				<th>키</th>
				<th>몸무게</th>
				<th>입단일</th>
				<th>소속팀</th>
			</tr>
			<c:forEach items="${getTeamList}" var="dto">
				<tr>
					<td><a href="../player/info?pno=${dto.pno}&position=${dto.position}">정보보기</a></td>
					<td>${dto.name}</td>
					<td>${dto.labelno}</td>
					<td>${dto.birth}</td>
					<td>${dto.position}</td>
					<td>${dto.height}</td>
					<td>${dto.weight}</td>
					<td>${dto.joinday}</td>
					<td>${dto.teamname}</td>
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
					<a href="../player/teamList?teamname=${PINFO.teamname}&nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../player/teamList?teamname=${PINFO.teamname}&nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../player/teamList?teamname=${PINFO.teamname}&nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="./list">리스트로 가기</a>
</body>
</html>