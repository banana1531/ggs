<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <div class="container" style="margin-bottom: 30px">
	   <button><a href="/mypage/mypageMain.gg">My Page</a></button>
	   <button><a href="/mypage/myTeamDetail.gg">My Team</a></button>
	   <button><a href="/mypage/checkPw.gg">내 정보 수정</a></button>
   </div>
	<div class='container' align="center" style="margin-top: 200px">
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