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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<form method="post">
		<table border="1" width="800" class="center">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="id" id="id" required="required"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" required="required"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" required="required" cols="50" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>등록</button>
					<button type="reset">새로입력</button>
					<input type="button" value="취소" onclick="history.back();" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>