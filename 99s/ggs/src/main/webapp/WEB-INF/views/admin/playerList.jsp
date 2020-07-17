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
	$(".page").click(function(){
		var pageNo=$(this).text();
		location="/admin/playerList.gg?pageNo="+pageNo
	})
	$(".dto").click(function(){
		var pno=$(this).find("#pno").val();
		location = "/admin/playerDetail.gg?pno="+pno
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
<h4>선수 목록</h4>
   <div class="container" id="body">
   <nav class="navbar navbar-right">
			<form class="form-inline" action="/admin/playerList.gg">
				<select id="option" name="option" class="form-control">
					<option value="name">이름</option>
					<option value="teamname">소속 팀</option>
					<option value="position">포지션</option>
				</select><input type="text" name="search" class="form-control">
				<button id="sOption" class="btn btn-default">검색</button>
			</form>
		</nav>
   		<table class="table table-hover">
   		<tr>
   			<th>이름</th>
   			<th>소속 팀</th>
   			<th>등번호</th>
   			<th>포지션</th>   			
   		</tr>
			<c:forEach items="${playerlist}" var="player">
				<tr class="dto">
					<td><input id="pno" type="hidden" value="${player.pno}"> ${player.name}</td>
					<td>${player.teamname}</td>
					<td>${player.labelno }</td>
					<td>${player.position }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">
				<c:if test="${pageInfo.startPage>1}">&lt;prev</c:if>
				<c:forEach var="i"
						begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					[<a class="page">${i}</a>]
				</c:forEach>
				<c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
				</td>
			</tr>
		</table>
   </div>
</body>
</html>