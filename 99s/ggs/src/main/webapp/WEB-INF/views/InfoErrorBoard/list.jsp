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
<script>
$(function(){
	var result= '${result}';
	var boardM = '${UBOARDM}';
	if(result!=''){
		alert(result)
	}
	$('#write').click(function(){
		if(boardM!='1'){
			alert("해당 권한이 없습니다.")
		}else{
			location = "/freeboard/write?nowPage=${PINFO.nowPage}"
		}
	})
	
})
</script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<h4>정보 오류 신고 게시판</h4>
		<div class="container" align="right">
			<form action="./search">
				<select name="searchType" id="searchType" style="width:60pt;height:20pt;">
					<option value="title" selected="selected">제목</option>
					<option value="content">내용</option>
					<option value="id">작성자</option>
				</select>
				<input type="text" name="keyword" id="keyword" style="width:120pt;height:20pt;">
				<input type="submit" id="search" value="검색" class="btn btn-primary">
			</form>
		</div>

		<table class="table table-hover">
			<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${InfoErrorBoardList}" var="dto">
					<tr>
						<td>${dto.writeno}</td>
						<td><a href="./hits?writeno=${dto.writeno}&nowPage=${PINFO.nowPage}">${dto.title}</a></td>
						<td>${dto.id}</td>
						<td><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd"/></td>
						<td>${dto.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table">
			<tr class="center">
				<td>
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="./list?nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="./list?nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="./list?nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</table>
		<div class="container" align="right">
			<button type="button" class="btn btn-primary" onclick="location.href='./write?nowPage=${PINFO.nowPage}' ">글쓰기</button>
		</div>

	</div>
</body>
</html>