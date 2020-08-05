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
<script>
$(function(){
	$(".team").click(function(){
		var name = $(this).find("#name").text()
		location = "/team/teamDetail.gg?name="+name
	})	
})
</script>
</head>
<body>
	<div class="container" align="center">
		<h4>팀 목록</h4>
		<table class="table table-hover " style="width: 900px">
			<thead>
			<tr class="active">
				<th width="8%" class="text-center">순위</th>
				<th width="15%" style="padding-left: 30px" class="text-center">팀명</th>
				<th class="text-center">승률</th>
				<th class="text-center">승</th>
				<th class="text-center">무</th>
				<th class="text-center">패</th>
				<th class="text-center">경기수</th>
				<th class="text-center">득점</th>
				<th class="text-center">실점</th>
			</tr>
			</thead>
			<% int i =0; %>	
			<c:forEach items="${list }" var="team">
				<tr class="team">
				<td class="text-center"><%=i+=1 %></td>
					<td class="text-center" id="name" value="${team.teamName}"><img width="50" height="30" src="/resources/img/${team.teamName}.jpg">${team.teamName}</td>
					<td class="text-center">${team.rate}</td>					
					<td class="text-center">${team.win}</td>
					<td class="text-center">${team.draw}</td>
					<td class="text-center">${team.lose}</td>
					<td class="text-center">${team.win+team.draw+team.lose}</td>
					<td class="text-center">${team.score}</td>
					<td class="text-center">${team.loss}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
