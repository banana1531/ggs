<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="로그인">
</head>
<body>
	<div class="container" align="center">
	<h2>로그인</h2>
	<hr />
	<form id=loginFrm method="post" action="../member/loginProc.gg">
		<table>
			<c:if test="${msg=='fail'}">
				<tr>
					<td colspan="2">아이디 또는 비밀번호가 일치하지 않습니다.</td>
				</tr>
			</c:if>
			<c:if test="${msg=='log'}">
				<tr>
					<td colspan="2">로그인이 정지된 사용자 입니다.</td>
				</tr>
			</c:if>
			<tr>
				<td>아이디</td>
				<td><input type="text" class="form-control" name="id" maxlength="20" required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" class="form-control" name="pw" maxlength="20" required></td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<input class="btn btn-block btn-primary" id="login" type="submit" value="로그인" />
				</td>
			</tr>
			<tr class="center">
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/member/idFindFrm.gg">아이디 찾기</a>&nbsp;
					<a href="${pageContext.request.contextPath}/member/pwFindFrm.gg">비밀번호 찾기</a>&nbsp;
					<a href="${pageContext.request.contextPath}/member/joinFrm.gg">회원가입</a>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html> 