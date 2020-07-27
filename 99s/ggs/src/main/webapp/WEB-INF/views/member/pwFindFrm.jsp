<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="비밀번호 찾기">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(function(){		
		$('#mailAuthChk').click(function(){
			var chkNum= $('#chkNum').val();
			var conNum = $('#conNum').val();
			if(chkNum!=conNum){
				window.alert("인증번호가 일치하지 않습니다.");
			}else{
				var r = confirm("인증번호가 일치합니다");
				$('#pwChg').click(function(){
				if(r==true){location.href="../member/pwChgFrm.gg?id=${result.id}";}
				})
			}			
		})	
	})
	</script>
</head>
<body>
	<h2>비밀번호 찾기 </h2>
	<hr />
	<form action="../member/mailAuth.gg" method="post">
		<table>
			<c:if test="${msg=='fail'}">
				<tr>
					<td colspan="2">아이디 또는 이메일이 다릅니다.</td>
				</tr>
			</c:if>
			<tr>
				<td>아이디:</td>
				<td><input type="text" id="id" name="id" value="${result.id}"></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input type="text" id="email" name="email" value="${result.email}"></td>
				<td><input type="submit" value="인증번호 받기"/></td>
			</tr>
			<tr>
				<td>인증번호 입력:</td>
				<td><input id="chkNum" type="text"></td>
				<td><input id="mailAuthChk" type="button" value="인증번호 확인" /></td>
				<td><input type="hidden" id="conNum" value="${num}" /></td>
			</tr>
			<tr>
				<td></td>
				<td class="center">
					<input id="pwChg" type="button" value="비밀번호 찾기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>