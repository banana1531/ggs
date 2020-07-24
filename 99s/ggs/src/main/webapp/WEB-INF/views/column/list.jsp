<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>야구 지식 게시판</title>

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<a href="../admin/adminMain.gg">메인으로</a>
	<div class="container" style="margin-top: 20px">
		<h1>야구 지식 게시판</h1>
		<h3>- 댓글 수정, 삭제</h3>
		<h3>- 제목 옆에 댓글 수 표시</h3>
		<h3>- 검색 결함 (삭제된글,제목+내용 검색시 비정상적 결과)</h3>
		<div class="container" align="right">
			<form action="./search">
				<select name="searchType" id="searchType">
					<option value="title" selected="selected">제목</option>
					<option value="content">내용</option>
					<option value="title,content">제목+내용</option>
				</select> 
				<input type="text" name="keyword" id="keyword"> 
				<input type="submit" id="search" value="검색">
			</form>

		</div>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cBoardList}" var="dto">
					<tr>
						<td>${dto.writeno}</td>
						<td><a
							href="./detail?writeno=${dto.writeno}&nowPage=${CPINFO.nowPage}&views=${dto.views}">${dto.title}</a></td>
						<td><fmt:formatDate value="${dto.writedate}"
								pattern="yyyy-MM-dd" /></td>
						<td>${dto.views}</td>
					</tr>
				</c:forEach>
				<tr class="center">
					<td colspan="5"><c:if test="${CPINFO.nowPage eq 1}">
					[이전]
					</c:if> <c:if test="${CPINFO.nowPage ne 1}">
							<a href="../column/list?nowPage=${CPINFO.nowPage-1}">[이전]</a>
						</c:if> <c:forEach var="pg" begin="${CPINFO.startPage}"
							end="${CPINFO.endPage}">
							<a href="../column/list?nowPage=${pg}">[${pg}]</a>
						</c:forEach> <c:if test="${CPINFO.nowPage eq CPINFO.totalPage}">
					[다음]
					</c:if> <c:if test="${CPINFO.nowPage ne CPINFO.totalPage}">
							<a href="../column/list?nowPage=${CPINFO.nowPage+1}">[다음]</a>
						</c:if></td>
				</tr>
			</tbody>
		</table>
				<div class="container" align="right">
			<c:if test="${UID=='admin'}">
				<button type="button" onclick="location.href='./write' ">글쓰기</button>
			</c:if>
		</div>

	</div>
	</body>
</html>
