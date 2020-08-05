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
		<h3 style="margin-top: 200px">비밀번호 변경</h3>
		<form class='form-inline' action="/mypage/updatePw.gg" >
			<table class='form-group'>
				<tr>
					<td>새로운 비밀번호 :</td>
					<td><input type="password" id='chPw'></td>
				</tr>
				<tr>
					<td>비밀번호 확인 : </td>
					<td><input type="password" id='chPw' name="newPw"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정하기">
						<a href="/mypage/myInfoModifyForm.gg"><input type="button" id='chPw' value="돌아가기"></a>
					</td>
				</tr>
			</table>
			${result }
		</form>
	</div>
	
</body>
</html>