<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head title="비밀번호 변경 성공">
</head>
<body>
	<table>
		<tr>
			<td>비밀번호 변경이 성공하였습니다</td>
		</tr>
		<tr class="center">
			<td>
				<button id="login" type="button" onclick="location.href='${pageContext.request.contextPath}/member/loginFrm.gg'">로그인</button>&nbsp;
				<button id="home" type="button" onclick="location.href='${pageContext.request.contextPath}/member/idFindFrm.gg'">아이디 찾기</button>
			</td>
		</tr>
	</table>
</body>
</html>