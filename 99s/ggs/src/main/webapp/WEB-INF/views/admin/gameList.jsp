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
   <div class="container">
	   <button><a href="/admin/teamList.gg">팀 목록</a></button>
	   <button><a href="/admin/playerList.gg">선수 목록</a></button>
	   <button><a href="/admin/gameList.gg">경기 목록</a></button>
   </div>
   <h4>경기 일정/결과</h4>
   <div class="container">
   		<table class="table table-hover">
			<tr>
				<th>경기 번호</th>
			</tr>
			<c:forEach items="${list }" var="game">
				<tr >
					<td>${game.gno }</td>
				</tr>
			</c:forEach>
		</table>
   </div>
</body>
</html>