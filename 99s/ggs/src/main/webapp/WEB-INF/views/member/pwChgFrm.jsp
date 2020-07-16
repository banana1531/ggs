<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="비밀번호 변경하기">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(function(){		
		$('#pwChgProc').click(function(){
			var pw= $('#pw').val();
			var pw2 = $('#pw2').val();
			if(pw!=pw2){
				window.alert("비밀번호가 일치하지 않습니다.");
			}else{
				var r = confirm("비밀번호가 일치합니다");
				if(r==true){$('#pwChgProcFrm').submit();}
			}			
		})	
	})
	</script>
</head>
<body>
	<h2>비밀번호 변경하기</h2>
	<hr />
	<form id="pwChgProcFrm" action="../member/pwChgProc.gg" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="id" value="${id}" /></td>
			</tr>
			<tr>
				<td>새 비밀번호 입력:</td>
				<td><input id="pw" type="password" name="pw"/></td>
				<td></td>
			</tr>
			<tr>
				<td>새 비밀번호 확인:</td>
				<td><input id="pw2" type="password" name="pw2" /></td>
				<td></td>
			</tr>
			<tr>
				<td class="center">
					<input id="pwChgProc" type="button" value="비밀번호 변경하기" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>