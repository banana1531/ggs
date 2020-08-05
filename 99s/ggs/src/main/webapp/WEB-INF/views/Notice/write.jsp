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
			<tr>
				<th>작성자</th>
				<td><input type="hidden" name="id" id="id" value="${ID}"/>${ID}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" class="form-control input-lg" name="title" id="title" placeholder="제목을 입력하세요" required="required"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea class="form-control input-lg" name="content" id="content" required="required" placeholder="내용을 입력하세요" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<button class="btn btn-primary">등록</button>
					<input type="button" class="btn btn-primary" value="취소" onclick="history.back();" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>