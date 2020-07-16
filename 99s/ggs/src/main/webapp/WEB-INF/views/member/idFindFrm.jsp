<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="아이디 찾기">
</head>
<body>
	<h2>아이디 찾기</h2>
	<hr />
	<form action="../member/mailAuth.gg" method="post">
		<table>
			<c:if test="${msg=='fail'}">
				<tr>
					<td colspan="2">이름 또는 이메일이 다릅니다.</td>
				</tr>
			</c:if>
			<tr>
				<td><label for="name">이름:</label></td>
				<td><input id="name" type="text" name="name"></td>
			</tr>
			<tr>
				<td><label for="email">이메일:</label></td>
				<td><input id="email" type="email" name="email"></td>
				<td><input type="submit" value="인증번호 받기"/></td>
			</tr>
			<tr>
				<td><label for="memail">인증번호 입력:</label></td>
				<td><input id="chkNum" type="text"></td>
				<td><input id="mailAuthChk" type="button" value="인증번호 확인" /></td>
			</tr>
			<tr class="center">
				<td></td>
				<td colspan="2">
					<input id="idFindProc" type="button" value="아이디 찾기">
				</td>
		</table>
	</form>
</body>
</html>