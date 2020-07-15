<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".dto").click(function(){
		var no = $(this).find('#id').text();
		location="/admin/memberDetail.gg?id="+no
	});
});	
</script>
</head>
<body>
   <div class="container">
	   <button><a href="/admin/memberSummary.gg">회원 현황</a></button>
	   <button><a href="/admin/memberList.gg">회원 목록</a></button>
   </div>
   <div class="container">
   
	<p>회원 목록</p>
	
		<nav class="navbar navbar-right">
			<form action="/admin/memberSearch.gg" class="form-inline">
				<select name="option" class="form-control">
					<option value="id">id</option>
					<option value="name">이름</option>
					<option value="email">email</option>
				</select> <input type="text" name="search" class="form-control">
				<button class="btn">검색</button>

			</form>
		</nav>
		<table class="table">
			<tr align="center">
				<td rowspan="2">id</td>
				<td rowspan="2">이름</td>
				<td rowspan="2">선호팀</td>
				<td rowspan="2">성별</td>
				<td rowspan="2">email</td>
				<td rowspan="2">가입일</td>
				<td colspan="3">권한</td>
			</tr>
			<tr>
				<td>글 조회</td>
				<td>글 조작</td>
				<td>로그인</td>
			</tr>
			<c:forEach items="${memberList}" var="list">
				<tr class="dto">
					<td class="name" id="id">${list.id }</td>
					<td class="no">${list.name }</td>
					<td>${list.team }</td>
					<td>${list.gender }</td>
					<td>${list.email }</td>
					<td><fmt:formatDate value="${list.joindate }"
							pattern="yyyy-MM-dd" /></td>
					<td><c:choose>
							<c:when test="${list.boardV=='1'}">가능</c:when>
							<c:otherwise>불가</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${list.boardM=='1'}">가능</c:when>
							<c:otherwise>불가</c:otherwise>
						</c:choose></td>
					<td><c:choose>
							<c:when test="${list.login ==1}">가능</c:when>
							<c:otherwise>불가</c:otherwise>
						</c:choose> </select></td>
				</tr>
			</c:forEach>
		</table>
   </div>
</body>
</html>