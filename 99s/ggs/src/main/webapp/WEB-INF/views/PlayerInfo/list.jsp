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
<div class="container" style="margin-top: 20px">
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=KIA' "><img width="50" height="30" src="/resources/img/KIA.jpg"><br/>KIA</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=KT' "><img width="50" height="30" src="/resources/img/KT.jpg"><br/>KT</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=LG' "><img width="50" height="30" src="/resources/img/LG.jpg"><br/>LG</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=NC' "><img width="50" height="30" src="/resources/img/NC.jpg"><br/>NC</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=SK' "><img width="50" height="30" src="/resources/img/SK.jpg"><br/>SK</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=두산' "><img width="50" height="30" src="/resources/img/두산.jpg"><br/>두산</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=롯데' "><img width="50" height="30" src="/resources/img/롯데.jpg"><br/>롯데</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=삼성' "><img width="50" height="30" src="/resources/img/삼성.jpg"><br/>삼성</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=키움' "><img width="50" height="30" src="/resources/img/키움.jpg"><br/>키움</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=한화' "><img width="50" height="30" src="/resources/img/한화.jpg"><br/>한화</button>
	<button type="button" class="btn btn-default" onclick="location.href='./list.gg' "><img width="50" height="30" src="/resources/img/top5.PNG"><br/>선수 Top5</button>
	<br/>
	<hr/>
	<h3>타자 순위 TOP5</h3>
	<div style="width:33%; float:left;">
		<h4><b>타율왕 TOP5</b></h4>
	<table class="table">
		<thead>
			<tr align="center" class="info">
				<td><b>소속팀</b></td>
				<td><b>이름</b></td>
				<td><b>타율</b></td>
			</tr>
			</thead>
			<tbody align="center">
			<c:forEach items="${Ranking}" var="dto">
				<tr>
					<td><img width="50" height="30" src="/resources/img/${dto.teamname}.jpg"></td>
					<td>${dto.name}</td>
					<td>${dto.tayul}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="width:34%; float:left;">
		<h4><b>홈런왕 TOP5</b></h4>
	<table class="table">
	<thead>
		<tr align="center" class="info">
				<td><b>소속팀</b></td>
				<td><b>이름</b></td>
				<td><b>홈런</b></td>
			</tr>
			</thead>
		<tbody align="center">
			<c:forEach items="${Ranking2}" var="dto">
				<tr>
					<td><img width="50" height="30" src="/resources/img/${dto.teamname}.jpg"></td>
					<td>${dto.name}</td>
					<td>${dto.home_run}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="width:33%; float:left;">
		<h4><b>타점왕 TOP5</b></h4>
 	<table class="table">
		<thead>
		<tr align="center" class="info">
				<td><b>소속팀</b></td>
				<td><b>이름</b></td>
				<td><b>타점</b></td>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${Ranking3}" var="dto">
				<tr>
					<td><img width="50" height="30" src="/resources/img/${dto.teamname}.jpg"></td>
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
 		<h4><b>승리왕 TOP5</b></h4>
 	<table class="table">
 	<thead>
			<tr align="center" class="danger">
				<td><b>소속팀</b></td>
				<td><b>이름</b></td>
				<td><b>승리</b></td>
			</tr>
			</thead>
		<tbody align="center">
			<c:forEach items="${Ranking4}" var="dto">
				<tr>
					<td><img width="50" height="30" src="/resources/img/${dto.teamname}.jpg"></td>
					<td>${dto.name}</td>
					<td>${dto.sunbal}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
 	</div>
 	<div style="width:34%; float:left;">
 	<h4><b>삼진왕 TOP5</b></h4>
 	<table class="table">
 	<thead>
			<tr align="center" class="danger">
				<td><b>소속팀</b></td>
				<td><b>이름</b></td>
				<td><b>탈삼진</b></td>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${Ranking5}" var="dto">
				<tr>
					<td><img width="50" height="30" src="/resources/img/${dto.teamname}.jpg"></td>
					<td>${dto.name}</td>
					<td>${dto.samjin}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="width:33%; float:left;">
		<h4><b>세이브왕 TOP5</b></h4>
		<table class="table">
		<thead>
				<tr align="center" class="danger">
				<td><b>소속팀</b></td>
				<td><b>이름</b></td>
				<td><b>세이브</b></td>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach items="${Ranking6}" var="dto">
				<tr>
					<td><img width="50" height="30" src="/resources/img/${dto.teamname}.jpg"></td>
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