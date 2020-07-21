<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항 게시판</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<table border="1" width="800" class="center">
		<tbody>
			<c:forEach items="${noticeDetail}" var="dto">
				<tr>
					<td>글번호</td>
					<td>${dto.writeno}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${dto.id}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${dto.title}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${dto.views}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${dto.content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr/>
	<h3>댓글</h3>
		<table border="1" width="800" class="center">
		<tbody>
			<c:forEach items="${noticeReply}" var="dto">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.content}</td>
					<td><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- 페이징 처리 --%>
	<table border="1" width="800" class="center">
		<tbody>
	<c:forEach items="${noticeDetail}" var="dto">
			<tr class="center">
				<td>
					<c:if test="${PINFO.nowPage eq 1}">
					[prev]
					</c:if>
				
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="../notice/detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../notice/detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../notice/detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
	</c:forEach>
		</tbody>
	</table>
	<form method="post">
	<c:forEach items="${noticeDetail}" var="dto">
		<input type="hidden" name="wno" id="wno" value="${dto.writeno}">
		<input type="hidden" name=nowPage id="nowPage" value="${dto.nowPage}">
		<input type="hidden" name=views id="views" value="${dto.views}">
	</c:forEach>
	<input type="text" name="id" id="id">
	<input type="text" name="content" id="content">
	<input type="submit" value="등록">
	</form>
	<hr/>
	<c:forEach items="${noticeDetail}" var="dto">
		<button type="button" onclick="location.href='./update?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}' ">수정하기(관리자만)</button>
		<input type="button" onclick=" location.href='./delete?writeno=${dto.writeno}&nowPage=${dto.nowPage}' " value="삭제하기(관리자만)">
		<button type="button" onclick="location.href='./list?nowPage=${dto.nowPage}' ">목록으로</button>
	</c:forEach>
</body>
</html>