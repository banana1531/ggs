<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	var name=$("#name").text()
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+1)
	$(".btn").click(function(){
		var pageNo = $(this).text()
		$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo)
	})
	
})
</script>
</head>
<body>
   <h1>teamList 들어왔다.</h1>
	<div class="container">
		<table class="table">
			<tr>
				<th>팀명</th>
				<th>설립일</th>
				<th>지역</th>
				<th>경기장</th>
				<th>감독</th>
				<th>홈페이지</th>
			</tr>
			<tr>
				<td id="name">${team.teamName }</td>
				<td>${team.birth }</td>
				<td>${team.location }</td>
				<td>${team.stadium }</td>
				<td>${team.director }</td>
				<td>${team.homepage }</td>
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
		<table class="table" id="list">
		</table>

	</div>
</body>
</html>