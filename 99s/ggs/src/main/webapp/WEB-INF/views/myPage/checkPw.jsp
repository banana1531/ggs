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
	   <a href="/mypage/mypageMain.gg"><button>My Page</button></a>
	   <a href="/mypage/myTeamDetail.gg"><button>My Team</button></a>
	   <a href="/mypage/checkPw.gg"><button>내 정보 수정</button></a>
   </div>
	<div class='container' align="center" style="margin-top: 200px">
		<h4>비밀번호를 입력하세요</h4>
		<form method="post" class='form-inline'>
			<input type="password" name="newPw">
			<button type="submit">확인</button>
			<button type="reset">취소</button>
		</form>
		${notmatch}
	</div>	
</body>
</html>