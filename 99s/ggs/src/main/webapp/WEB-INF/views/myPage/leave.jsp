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
	$('#emailBtn').click(function(){
		var email = $('#email').val();
		$.ajax({
            type : "POST",
            url : "../mypage/sendNum",
            dataType: "json",
            async: false,
            data : {email,},
            success : function(data) {
            	   alert("인증번호를 발송하였습니다.");
                   confirmNum = data.confirmNum;
                   alert(confirmNum);
               },error : function(data, jqXHR) {
	            	//alert("에러가 발생했습니다. 잠시 후 다시 시도해주세요.\n발생 에러: "+jqXHR.statusText+"\njqXHR.responseText: "+jqXHR.responseText);
					alert("에러가 발생했습니다. 잠시 후 다시 시도해주세요.");
	               return false;
	            }  
		  });
		
	});
	
	//인증번호 동일여부 확인하기
	//탈퇴하기를 눌렀을대 인증번호와 일치여부를 확인하여 일치할 경우 탈퇴, 일치하지 않을 경우 alert을 띄운다.
	$('#confirmChk').click(function(){
		var emailNum = $("#emailNum").val();
		if(emailNum.length >0){
			if(emailNum != confirmNum){
				window.alert("인증번호가 일치하지 않습니다.");
				return false;
			}else{
			var r = confirm("정말 탈퇴하시겠습니까?")
			if(r==true){location.href="/mypage/leave.gg";}
			}
		}
	});
	
});



</script>
</head>
<body>
	<div class="container" align="center">
		<h4 style="margin-top: 200px">탈퇴하기</h4>
		<form class="form-inline">
			<table class="table" style="width: 300px">
				<tr>
					<td>
						<input type="text" id="email" name="email" value="${email }"/>
						<input id="emailBtn" type="button"value="인증번호 받기" />
						<input id="emailNum" type="text"/>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="button" value="인증번호 확인/탈퇴하기"  class="btn" id="confirmChk"></td>
				</tr>
			</table>
		</form>
		${result }
	</div>
</body>
</html>