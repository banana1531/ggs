<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script>
$(function(){
	$(".btn").click(function(){
		var pageNo=$(this).teat();
		$(".table").load()
		
		
	})	
})
</script> -->
</head>
<body>
<h4>선수 목록</h4>
${pageInfo }
   <div class="container">
   <nav class="navbar navbar-right">
			<form action="/admin/memberSearch.gg" class="form-inline">
				<select name="option" class="form-control">
					<option value="name">이름</option>
					<option value="teamname">소속 팀</option>
					<option value="position">포지션</option>
				</select> <input type="text" name="search" class="form-control">
				<button class="btn">검색</button>

			</form>
		</nav>
   		<table class="table">
   		<tr>
   			<th>이름</th>
   			<th>소속 팀</th>
   			<th>등번호</th>
   			<th>포지션</th>   			
   		</tr>
			<c:forEach items="${playerlist}" var="player">
				<tr>
					<td>${player.name}</td>
					<td>${player.teamname}</td>
					<td>${player.labelno }</td>
					<td>${player.position }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="9">
				<c:if test="${pageInfo.nowPage<11}">&lt;prev</c:if>
				<c:forEach var="i"
						begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					[<a class="btn">${i}</a>]
				</c:forEach>
				<c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
				</td>
			</tr>
		</table>
   </div>
</body>
</html>