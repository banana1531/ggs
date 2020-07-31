<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="비밀번호 찾기">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	$(function(){	
		
		//email 중복체크 및 인증번호 발송 
		$('#emailBtn').click(function(){
			var id= $('#id').val();
			var email = $('#email').val();
			
			if(email.length >0){
				var g = "@";
				if(email.indexOf(g)!= -1){ 
			        $.ajax({
			            type : "POST",
			            url : "../member/mailAuth",
			            dataType: "json",
			            async: false,
			            data : {id, email},
			            success : function(data) {
			               if(data.result!=null){
			            	   alert("인증번호를 발송하였습니다.");
			                   confirmNum = data.confirmNum;
			                   alert(confirmNum);

			               }else {
			                  alert("아이디 또는 이메일이 다릅니다.");
			                  return false;
			               }
			            },
			            error : function(data, jqXHR) {
			            	//alert("에러가 발생했습니다. 잠시 후 다시 시도해주세요.\n발생 에러: "+jqXHR.statusText+"\njqXHR.responseText: "+jqXHR.responseText);
			                
			               alert("에러가 발생했습니다. 잠시 후 다시 시도해주세요.");
			               return false;
			            }
			        });
			
				}else{
					window.alert("'@'를 포함한 이메일 형식으로 써주세요. 예: myemail-adress@naver.com ");
					return false;
				}
			}else{
				window.alert("이메일을 입력해주세요");
				return false;
			}
		})
		
		
		$('#confirmChk').click(function(){
			var emailNum = $("#emailNum").val();
			  if(emailNum.length >0){
					if(emailNum != confirmNum){
						window.alert("인증번호가 일치하지 않습니다.");
						return false;
					}else{
						var r = confirm("인증번호가 일치합니다");
						$('#pwChg').click(function(){
						if(r==true){$('#pwChgFrm').submit();}
						})
					}
			  }
		})	
	})
	</script>
</head>
<body>
	<h2>비밀번호 찾기 </h2>
	<hr />
	<form id="pwChgFrm" action="../member/pwChgFrm.gg" method="post">
		<table>
			<tr>
				<td>아이디:</td>
				<td><input type="text" id="id" name="id"/></td>
			</tr>
			<tr>
				<td>이메일:</td>
				<td><input id="email" type="email" name="email"/></td>
				<td><input id="emailBtn" type="button"value="인증번호 받기" /></td>
			</tr>
			<tr>
				<td>인증번호 입력:</td>
				<td><input id="emailNum" type="text"/></td>
				<td><input id="confirmChk" type="button" value="인증번호 확인" /></td>
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