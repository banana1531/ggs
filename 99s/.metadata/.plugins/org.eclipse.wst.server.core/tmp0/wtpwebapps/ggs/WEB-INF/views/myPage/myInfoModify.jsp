<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1> myInfoModify 들어왔다~</h1>
	
	<div class='container'>
		<form class='form-inline' action="/mypage/myInfoModify.gg" method="post">
			<table class='form-group'>
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="id" readonly="readonly" value="${myinfo.id }"></td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td>						
						<a href="/mypage/updatePwForm.gg"><input type="button" id='chPw' value="비밀번호 변경하기"></a>
					</td>
				</tr>
				<tr>
					<td>이름 : </td>
					<td><input type="text" name="name" readonly="readonly" value="${myinfo.name}"></td>					
				</tr>
				<tr>
					<td>생년월일 : </td>
					<td><input type="text" name="birth" readonly="readonly" value="${myinfo.birth }"></td>				
				</tr>
				<tr>
					<td>성별 : </td>
					<td><input type="text" name="gender" readonly="readonly" value="${myinfo.gender }"></td>
				</tr>
				<tr>
					<td>선호팀 : </td>
					<td><select name="fteam">
						<option value="없음">없음</option>
						<option value="두산">두산</option>
						<option value="롯데">롯데</option>
						<option value="삼성">삼성</option>
						<option value="키움">키움</option>
						<option value="한화">한화</option>
						<option value="KIA">KIA</option>
						<option value="KT">KT</option>
						<option value="LG">LG</option>
						<option value="NC">NC</option>
						<option value="SK">SK</option>
					</select></td>
				</tr>
				
				<tr>
					<td colspan="2"><button class="btn">수정하기</button>
					<button type="reset" class="btn">취소</button>
					<a href="/mypage/leaveForm.gg"><button type="button" class="btn">탈퇴하기</button></a>
					</td>
				</tr>
			</table>
			
		</form>
		${result }
	</div>	
</body>
</html>