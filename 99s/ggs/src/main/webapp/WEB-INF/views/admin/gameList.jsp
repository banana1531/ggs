<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		location="/admin/gameList.gg?pageNo="+pageNo
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
   		<thead>
			<tr>
				<th>일자</th>
				<th>시간</th>
				<th>A team</th>
				<th>A score</th>
				<th>B score</th>
				<th>B team</th>
				<th>경기장</th>
			</tr>
			</thead>
			<c:forEach items="${list }" var="game">
				<tr >
					<td><fmt:formatDate value="${game.gdate }" pattern="yyyy-MM-dd"/></td>
					<td>${game.gtime }</td>
					<td>${game.ateamname }</td>
					<td>${game.ascore }</td>
					<td>${game.bscore }</td>
					<td>${game.bteamname }</td>
					<td>${game.stadium }</td>
				</tr>
			</c:forEach>
			<tr><td colspan="7">
			<c:if test="${pageInfo.startPage>1}"> &lt;prev</c:if>
				<c:forEach var="i"
						begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<c:choose>
						<c:when test="${pageInfo.nowPage==i}"><b>[<a class="page">${i}</a>]</b></c:when>
						<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
			</td></tr>
		</table>
   </div>
</body>
</html>