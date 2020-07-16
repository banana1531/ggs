<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".team").click(function(){
		var name=$(this).find("#name").text()
		$("#body").load("/admin/teamDetail?name="+name)
	})	
})
</script>
</head>
<body>
   <h4>팀 목록</h4>
   <div class="container">
   		<table class="table table-hover">
			<tr>
				<th>팀명</th>
				<th>설립일</th>
				<th>지역</th>
				<th>경기장</th>
				<th>감독</th>
				<th>홈페이지</th>
			</tr>
			<c:forEach items="${list }" var="team">
				<tr class="team">
					<td id="name">${team.teamName }</td>
					<td>${team.birth }</td>
					<td>${team.location }</td>
					<td>${team.stadium }</td>
					<td>${team.director }</td>
					<td>${team.homepage }</td>
				</tr>
			</c:forEach>
		</table>
   </div>
</body>
</html>