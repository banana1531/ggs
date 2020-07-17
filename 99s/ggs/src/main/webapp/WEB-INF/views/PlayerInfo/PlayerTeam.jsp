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
<div class="container">
	<button type="button" onclick="location.href='../player/teamList?teamname=KIA' ">KIA</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=KT' ">KT</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=LG' ">LG</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=NC' ">NC</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=SK' ">SK</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=두산' ">두산</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=롯데' ">롯데</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=삼성' ">삼성</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=키움' ">키움</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=한화' ">한화</button>
	<hr/>
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
					<td><a href="../player/info.gg?pno=${dto.pno}&position=${dto.position}">정보보기</a></td>
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
					<a href="../player/teamList.gg?teamname=${PINFO.teamname}&nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../player/teamList.gg?teamname=${PINFO.teamname}&nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../player/teamList.gg?teamname=${PINFO.teamname}&nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	<button type="button" onclick="location.href='./list.gg' ">메인(랭킹)으로 가기</button>
	</div>
</body>
</html>