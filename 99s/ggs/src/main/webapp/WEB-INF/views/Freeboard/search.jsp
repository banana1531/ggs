<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자유 게시판</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${freeboardSearch}" var="dto">
				<tr>
					<td>${dto.writeno}</td>
					<td>${dto.id}</td>
					<td><a href="./detail?writeno=${dto.writeno}&nowPage=${PINFO.nowPage}&views=${dto.views}">${dto.title}</a></td>
					<td><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${dto.views}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- 페이징 처리 --%>
	<table border="1" width="800" class="center">
		<tbody>
			<tr class="center">
				<td>
					<c:if test="${PINFO.nowPage eq 1}">
					[prev]
					</c:if>
				
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="./search?searchType=${PINFO.searchType}&keyword=${PINFO.keyword}&nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="./search?searchType=${PINFO.searchType}&keyword=${PINFO.keyword}&nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="./search?searchType=${PINFO.searchType}&keyword=${PINFO.keyword}&nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	<form action="./search">
	<button type="button" onclick="location.href='./write' ">글쓰기(관리자만)</button>
		<select name="searchType" id="searchType">
			<option value="title" selected="selected">제목</option>
			<option value="content">내용</option>
			<option value="id">작성자</option>
		</select>
		<input type="text" name="keyword" id="keyword">
		<input type="submit" id="search" value="검색">
	</form>
</body>
</html>