<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="아이디 찾기 결과">
</head>
<body>
	<h2>아이디 찾기 결과</h2>
	<hr />
	<table>	
			<tr>
				<td><h3>회원님의 아이디는 ${result.id} 입니다</h3></td>
			</tr>
		<tr>
			<td class="center">
				<button id="idFind" type="button" onclick="location.href='${pageContext.request.contextPath}/member/loginFrm.gg'">로그인 하기</button>&nbsp;
				<button id="idFind" type="button" onclick="location.href='${pageContext.request.contextPath}/member/pwFindFrm.gg'">비밀번호 찾기</button>
			</td>
		</tr>
	</table>
</body>
</html>