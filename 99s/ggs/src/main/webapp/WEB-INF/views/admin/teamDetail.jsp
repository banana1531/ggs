<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	var name=$("#name").find("input").val()
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+1)
/* 	$(".btn").click(function(){
		var pageNo = $(this).text()
		$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo)
	}) */
})
</script>
</head>
<body>
   <div class="container" style="margin-top: 20px">
	   <button><a href="/admin/teamList.gg">팀 목록</a></button>
	   <button><a href="/admin/playerList.gg">선수 목록</a></button>
	   <button><a href="/admin/gameList.gg">경기 목록</a></button>
   </div>
	<div class="container">
		<form class="form form-inline" action="/admin/teamInfoUpdate.gg">
		<table class="table">
		<caption>팀 정보</caption>
			<tr>
				<th >팀명</th>
				<th>전화번호</th>
				<th>설립일</th>
				<th>지역</th>
				<th>경기장</th>
				<th>감독</th>
				
			</tr>
			<tr>
				<td id="name"><input name="teamName" type="text" readonly="readonly" value="${team.teamName }"></td>
				<td><input name="tel" type="text" value="${team.tel }"></td>
				<td><input name="birth" type="text" value="${team.birth }"></td>
				<td><input name="location" type="text" value="${team.location }"></td>
				<td><input name="stadium" type="text" value="${team.stadium }"></td>
				<td><input name="director" type="text" value="${team.director }"></td>
			</tr>
			<tr>
				<th>구단주</th>
				<th>대표이사</th>
				<th>단장</th>
				<th>우승기록</th>
				<th>홈페이지</th>
			</tr>
				<tr>
				<td><input name="towner" type="text" value="${team.towner }"></td>
				<td><input name="ceo" type="text" value="${team.ceo }"></td>
				<td><input name="head" type="text" value="${team.head }"></td>
				<td><input name="history" type="text" value="${team.history }"></td>
				<td><input name="homepage" type="text" value="${team.homepage }"></td>
			</tr>
			<tr>
				<th>승수</th>
				<th>득점</th>
				<th>무승부</th>
				<th>패수</th>
				<th>실점</th>
				<th>경기 횟수</th>
			</tr>
			<tr>
				<td>${team.win }</td>
				<td>${team.score }</td>
				<td>${team.draw }</td>
				<td>${team.lose }</td>
				<td>${team.loss }</td>
				<td>${team.win+team.draw+team.lose}</td>
			</tr>
		</table>
		${result}<p align="right"><button>정보 수정</button> </p>
		</form>
		<table class="table" id="list">
		</table>

	</div>
</body>
</html>