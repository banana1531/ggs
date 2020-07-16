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

	$(".btn").click(function(){
		var pageNo = $(this).text();
		location="/admin/memberList.gg?pageNo="+pageNo
	})
});	
</script>
</head>
<body>
   <div class="container">
	   <button><a href="/admin/memberSummary.gg">회원 현황</a></button>
	   <button><a href="/admin/memberList.gg">회원 목록</a></button>
   </div>
   <div class="container" id="body">
   
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
		<table class="table table-hover">
			<thead>
			<tr align="center">
				<th rowspan="2">id</th>
				<th rowspan="2">이름</th>
				<th rowspan="2">선호팀</th>
				<th rowspan="2">성별</th>
				<th rowspan="2">email</th>
				<th rowspan="2">가입일</th>
				<th colspan="3">권한</th>
			</tr>
			<tr>
				<th>글 조회</th>
				<th>글 조작</th>
				<th>로그인</th>
			</tr>
			</thead>
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
				<tr>
				<td colspan="9"><c:forEach var="i" begin="${pageInfo.startPage}"
						end="${pageInfo.endPage}">
					[<a class="btn">${i}</a>]
				</c:forEach></td>
			</tr>
		</table>
		
   </div>
</body>
</html>