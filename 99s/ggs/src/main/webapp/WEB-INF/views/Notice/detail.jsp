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
	<c:forEach items="${noticeDetail}" var="dto">
		<button type="button" onclick="location.href='./update?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}' ">수정하기(관리자만)</button>
		<input type="button" onclick=" location.href='./delete?writeno=${dto.writeno}&nowPage=${dto.nowPage}' " value="삭제하기(관리자만)">
		<button type="button" onclick="location.href='./list?nowPage=${dto.nowPage}' ">목록으로</button>
	</c:forEach>
</body>
</html>