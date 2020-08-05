<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
	<form method="post">
		<table class="table">
			<tbody>
					<tr>
						<td>글번호</td>
						<td><input type="hidden" id="writeno" name="writeno" value="${noticeUpdateForm.writeno}">${noticeUpdateForm.writeno}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${noticeUpdateForm.id}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" class="form-control input-lg" name="title" id="title" required="required" value="${noticeUpdateForm.title}"></td>
					</tr>
					<tr>
						<td>작성일</td>
						<td><fmt:formatDate value="${noticeUpdateForm.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${noticeUpdateForm.views}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control input-lg" name="content" id="content" required="required" rows="10">${noticeUpdateForm.content}</textarea></td>
					</tr>
				<tr>
					<td colspan="2">
						<button class="btn btn-primary">수정</button>
						<button type="button" class="btn btn-primary" onclick="location.href='./detail?writeno=${noticeUpdateForm.writeno}&nowPage=${noticeUpdateForm.nowPage}'">취소</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>