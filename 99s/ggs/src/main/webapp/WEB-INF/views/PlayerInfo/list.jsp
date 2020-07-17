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
	<a href="../player/teamList.gg?teamname=KIA">KIA</a>
	<a href="../player/teamList.gg?teamname=KT">KT</a>
	<a href="../player/teamList.gg?teamname=LG">LG</a>
	<a href="../player/teamList.gg?teamname=NC">NC</a>
	<a href="../player/teamList.gg?teamname=SK">SK</a>
	<a href="../player/teamList.gg?teamname=두산">두산</a>
	<a href="../player/teamList.gg?teamname=롯데">롯데</a>
	<a href="../player/teamList.gg?teamname=삼성">삼성</a>
	<a href="../player/teamList.gg?teamname=키움">키움</a>
	<a href="../player/teamList.gg?teamname=한화">한화</a>
	<table border="1" width="800" class="center">
		<tbody>
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
	
	<table border="1" width="800" class="center">
		<tbody>
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
 
 	<table border="1" width="800" class="center">
		<tbody>
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
 
 	<table border="1" width="800" class="center">
		<tbody>
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
 
 	<table border="1" width="800" class="center">
		<tbody>
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
	
		<table border="1" width="800" class="center">
		<tbody>
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
</body>
</html>