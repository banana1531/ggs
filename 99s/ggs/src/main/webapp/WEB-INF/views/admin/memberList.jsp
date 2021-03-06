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

	$(".page").click(function(){
		var pageNo = $(this).text();
		location="/admin/memberList.gg?pageNo="+pageNo
	})
});	
</script>
</head>
<body>
   <div class="container">
	   <a href="/admin/memberSummary.gg"> <button>회원 현황</button></a>
	   <a href="/admin/memberList.gg"><button>회원 목록</button></a>
   </div>
   <div class="container" id="body">
   
	<h4>회원 목록</h4>
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
				<th></th>
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
				<tr align="center">
				<td colspan="9">
				<c:if test="${pageInfo.startPage>1}">&lt;prev</c:if>
				<c:forEach var="i" begin="${pageInfo.startPage}"
						end="${pageInfo.endPage}">
						<c:choose>
							<c:when test="${pageInfo.nowPage==i}">
								<b>[<a class="page">${i}</a>]
								</b>
							</c:when>
							<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
						</c:choose>
					</c:forEach>
				<c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
				</td>
			</tr>
		</table>
		
   </div>
</body>
</html>