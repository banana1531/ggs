<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1> updatePw 들어왔다~</h1>
	<div class='container'>
		<form class='form-inline' action="/mypage/updatePw.gg">
			<table class='form-group'>
				<tr>
					<td>새로운 비밀번호 :</td>
					<td><input type="text" id='chPw'></td>
				</tr>
				<tr>
					<td>비밀번호 확인 : </td>
					<td>						
						<input type="text" id='chPw' name="newPw">
					</td>
				</tr>
				
				<tr>
					<td><input type="submit" value="수정하기"></td>
					<td><a href="/mypage/myInfoModifyForm.gg"><input type="button" id='chPw' value="돌아가기"></a></td>
				</tr>
			</table>
		</form>
		
	</div>
	
</body>
</html>