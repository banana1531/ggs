<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<br/>
	<hr/>
	<h3>타자 순위 TOP5</h3>
	<div style="width:33%; float:left;">
	<table border="1" width="300" class="center">
		<tbody>
			<tr>
				<th colspan="3">타율왕 TOP5</th>
			</tr>
			<tr>
				<th>소속팀</th>
				<th>이름</th>
				<th>타율</th>
			</tr>
			<c:forEach items="${Ranking}" var="dto">
				<tr>
					<td>${dto.teamname}</td>
					<td>${dto.name}</td>
					<td>${dto.tayul}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="width:34%; float:left;">
	<table border="1" width="300" class="center">
		<tbody>
			<tr>
				<th colspan="3">홈런왕 TOP5</th>
			</tr>
			<tr>
				<th>소속팀</th>
				<th>이름</th>
				<th>홈런</th>
			</tr>
			<c:forEach items="${Ranking2}" var="dto">
				<tr>
					<td>${dto.teamname}</td>
					<td>${dto.name}</td>
					<td>${dto.home_run}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="width:33%; float:left;">
 	<table border="1" width="300" class="center">
		<tbody>
			<tr>
				<th colspan="3">타점왕 TOP5</th>
			</tr>
			<tr>
				<th>소속팀</th>
				<th>이름</th>
				<th>타점</th>
			</tr>
			<c:forEach items="${Ranking3}" var="dto">
				<tr>
					<td>${dto.teamname}</td>
					<td>${dto.name}</td>
					<td>${dto.tajum}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	</div>
	<hr/>
 	<h3>투수 순위 TOP5</h3>
 	<div style="width:33%; float:left;">
 	<table border="1" width="300" class="center">
		<tbody>
			<tr>
				<th colspan="3">출장왕 TOP5</th>
			</tr>
			<tr>
				<th>소속팀</th>
				<th>이름</th>
				<th>경기수</th>
			</tr>
			<c:forEach items="${Ranking4}" var="dto">
				<tr>
					<td>${dto.teamname}</td>
					<td>${dto.name}</td>
					<td>${dto.sunbal}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
 	</div>
 	<div style="width:34%; float:left;">
 	<table border="1" width="300" class="center">
		<tbody>
			<tr>
				<th colspan="3">삼진왕 TOP5</th>
			</tr>
			<tr>
				<th>소속팀</th>
				<th>이름</th>
				<th>탈삼진</th>
			</tr>
			<c:forEach items="${Ranking5}" var="dto">
				<tr>
					<td>${dto.teamname}</td>
					<td>${dto.name}</td>
					<td>${dto.samjin}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="width:33%; float:left;">
		<table border="1" width="300" class="center">
		<tbody>
			<tr>
				<th colspan="3">피안타율왕 TOP5</th>
			</tr>
			<tr>
				<th>소속팀</th>
				<th>이름</th>
				<th>피안타율</th>
			</tr>
			<c:forEach items="${Ranking6}" var="dto">
				<tr>
					<td>${dto.teamname}</td>
					<td>${dto.name}</td>
					<td>${dto.sunbal}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>