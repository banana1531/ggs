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
	
	$('#getnum').click(function(){
		
		location.href="/mypage/sendNum.gg";
	});
	
});

</script>
</head>
<body>
	<h1> leave 들어왔다~</h1>
	
	<div class="container">
		<form class="form-inline" action="/mypage/leave.gg">
			<table class="table">
				<tr>
					<td><input type="text"> <input type="button"
						value="발송" class="btn" id="getnum"></td>
				</tr>
				<tr>
					<td><input type="submit" value="탈퇴하기"  class="btn"></td>
				</tr>
			</table>
			${num}
		</form>

	</div>
</body>
</html>