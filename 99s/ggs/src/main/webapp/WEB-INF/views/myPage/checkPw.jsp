<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class='container' align="center">
		<h4>비밀번호를 입력하세요</h4>
		<form method="post" class='form-inline'>
			<input type="text" name="newPw">
			<button type="submit">확인</button>
			<button type="reset">취소</button>
		</form>
		${notmatch}
	</div>	
</body>
</html>