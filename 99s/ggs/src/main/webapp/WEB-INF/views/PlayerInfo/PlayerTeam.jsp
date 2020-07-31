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
<div class="container" style="margin-top: 20px">
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=KIA' "><img width="50" height="30" src="/resources/img/KIA.jpg"><br/>KIA</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=KT' "><img width="50" height="30" src="/resources/img/KT.jpg"><br/>KT</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=LG' "><img width="50" height="30" src="/resources/img/LG.jpg"><br/>LG</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=NC' "><img width="50" height="30" src="/resources/img/NC.jpg"><br/>NC</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=SK' "><img width="50" height="30" src="/resources/img/SK.jpg"><br/>SK</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=두산' "><img width="50" height="30" src="/resources/img/두산.jpg"><br/>두산</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=롯데' "><img width="50" height="30" src="/resources/img/롯데.jpg"><br/>롯데</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=삼성' "><img width="50" height="30" src="/resources/img/삼성.jpg"><br/>삼성</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=키움' "><img width="50" height="30" src="/resources/img/키움.jpg"><br/>키움</button>
	<button type="button" onclick="location.href='../player/teamList.gg?teamname=한화' "><img width="50" height="30" src="/resources/img/한화.jpg"><br/>한화</button>
	<button type="button" onclick="location.href='./list.gg' "><img width="50" height="30" src="/resources/img/top5.PNG"><br/>선수 Top5</button>
	<hr/>
	<h4><img width="100" height="40" src="/resources/img/${PINFO.teamname}.jpg">선수 목록</h4>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>상세정보</th>
				<th>이름</th>
				<th>등번호</th>
				<th>생년월일</th>
				<th>포지션</th>
				<th>키</th>
				<th>몸무게</th>
				<th>입단일</th>
				<th>소속팀</th>
			</tr>
			</thead>
			<tbody>
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
		<tfoot>
		<tr class="center">
				<td colspan="9">
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
			</tr></tfoot>
	</table>
	<%-- 페이징 처리 --%>
	<table class="center">
		<tbody>
			
		</tbody>
	</table>
	
	</div>
</body>
</html>