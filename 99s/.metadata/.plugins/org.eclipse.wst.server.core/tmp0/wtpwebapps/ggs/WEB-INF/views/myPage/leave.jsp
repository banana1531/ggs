<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	
	//인증번호 발송하기
	$('#getnum').click(function(){
		location.href="/mypage/sendNum.gg";
	});
	
	//인증번호 동일여부 확인하기
	//탈퇴하기를 눌렀을대 인증번호와 일치여부를 확인하여 일치할 경우 탈퇴, 일치하지 않을 경우 alert을 띄운다.
	$('#leave').click(function(){
		var chkNum = $('#chkNum').val();
		var conNum = $('#conNum').val();
		if(chkNum!=conNum){
			window.alert("인증번호를 잘못 입력하였습니다.");
		}else{
			var r = confirm("정말 탈퇴하시겠습니까?")
			if(r==true){location.href="/mypage/leave.gg";}
		}
	});
	
});



</script>
</head>
<body>
	<h1> leave 들어왔다~</h1>
	
	<div class="container">
		<form class="form-inline">
			<table class="table">
				<tr>
					<td><input type="text" id="chkNum"><input type="button"
						value="발송" class="btn" id="getnum">
						<input type="hidden" id="conNum" value="${num}"></td>
				</tr>
				<tr>
					<td><input type="button" value="탈퇴하기"  class="btn" id="leave"></td>
				</tr>
			</table>
		</form>
		${num }
	</div>
</body>
</html>