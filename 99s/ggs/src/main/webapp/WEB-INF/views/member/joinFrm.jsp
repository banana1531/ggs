<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head title="회원가입">
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		//아이디중복 체크
		$('#idChk').click(function(){
			var id= $('#id').val();
			if(id.length >0 && id.length <12){
				location.href="${pageContext.request.contextPath}/member/mailAuth1.gg?id="+id;
				console.log('id 중복 체크');
			}else {
			 	window.alert("아이디를 11자 이하로 입력해주세요");
			 	$('#span1').text("사용할 수 없는 아이디입니다.");
			 	return false;
			}  
			return;
		})

		//email 중복체크 및 인증번호 발송 
		$('#emailBtn').click(function(){
			var id= $('#id').val();
			var email = $('#email').val();
			
			if(email.length >0){
				var g = "@";
				if(email.indexOf(g)!= -1){ 
			        $.ajax({
			            type : "POST",
			            url : "../member/mailAuth2",
			            dataType: "json",
			            async: false,
			            data : {id, email},
			            success : function(data) {
			               if(data.result==null){
			            	   alert("인증번호를 발송하였습니다.");
			                   confirmNum = data.confirmNum;
			                   alert(confirmNum);

			               }else {
			                  alert("기존에 등록된 이메일 입니다.");
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

		//인증번호 일치 여부 확인 + null 값 확인 후 제출
		$('#confirmChk').click(function(){
			var emailNum = $("#emailNum").val();

			if(emailNum.length >0){
					if(emailNum != confirmNum){
						window.alert("인증번호가 일치하지 않습니다.");
						return false;
					}else{
						var r = confirm("인증번호가 일치합니다");
						$('#joinProc').click(function(){
							var id =$('#id').val();
							var name =$('#name').val();
							var pw = $('#pw').val();
							var birth = $('#birth').val();
							if(id.length == 0 || id.length > 11){
							//ID null 값 여부 
								window.alert("아이디 입력과 중복확인을 해주세요.");
								return false;	
							}else if (name.length == 0){
							//이름 null 값 여부 	
								window.alert("이름을 입력해주세요.");
								return false;
							}else if(pw.length == 0){
							//pw null 값 여부 
								window.alert("비밀번호를 입력해주세요.");
								return false;
							}else if(birth.length == 0){
							//생년월일 null 값 여부 
								window.alert("생년월일을 입력해주세요.");
								return false;
							}else{
								if(r==true){$('#joinFrm').submit();
								}else{window.alert("인증번호를 확인해주세요.");}
							}
						})
					}		
			}else{
				window.alert("인증번호를 입력해주세요.");
			}
			
		})
		
		//비밀번호 일치 여부 	
		$("#pw2").on("propertychange change keyup paste input", function() {
		    var currentVal = $(this).val();
		    var oldVal = $('#pw').val();
		    if(oldVal.length >0){
			    if(currentVal == oldVal) {
			    	$("#pwChk").html("비밀번호가 일치합니다.");
			        return;
			    } else {
			    	$("#pwChk").html("비밀번호가 일치하지 않습니다.");
			    	return false;
			    }
		    }else {
		    	window.alert("비밀번호를 입력해주세요");
		    	return false;
		    }
		});	

	})

	</script>

</head>
<body>
	<div class="container" align="center">
		<%
			request.setCharacterEncoding("UTF-8");
		%>
		<h2 style="margin-top: 150px">회원가입</h2>
		<div class="container" style="width: 900px" align="left">

			<hr />
			<table style="margin-left: 200px">
				<form action="../member/joinProc.gg" id="joinFrm" method="post">
					<tr>
						<td>아이디</td>
						<td><input type="text" id="id" name="id" value="${id}" /> <input
							id="idChk" type="button" value="중복확인" /></td>
						<td><c:if test="${msg=='fail'}">
								<span>중복되는 아이디 입니다.</span>
							</c:if> 
							<c:if test="${msg=='notmember'}">
								<span id="span1">사용할 수 있는 아이디 입니다.</span>
							</c:if></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" id="email" name="email" value="${email}" /> 
							<input id="emailBtn" type="button"value="인증번호 받기" /></td>
						<td></td>
					</tr>
					<tr>
						<td>인증번호</td>
						<td><input id="emailNum" type="text" /> 
							<input id="confirmChk" type="button" value="인증번호 확인" /></td>
						<td></td>
					</tr>
	
					<tr>
						<td>비밀번호</td>
						<td><input type="password" id="pw" name="pw" /></td>
	
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" id="pw2" name="pw2" /> 
						<span id="pwChk"></span></td>
						<td></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" id="name" name="name" /></td>
						<td></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="date" id="birth" name="birth" /></td>
						<td></td>
					</tr>
					<tr>
						<td>성별</td>
						<td><input type="radio" id="m" name="gender" value="남자">&nbsp;남자</input>
							<input type="radio" id="f" name="gender" value="여자">&nbsp;여자</input>
							<input type="radio" id="n" name="gender" value="" checked="checked">&nbsp;선택 안함</input></td>
						<td></td>
					</tr>
					<tr>
						<td>선호팀</td>
						<td><select id="team" name="team">
								<option value="없음" selected>없음</option>
								<option value="두산">두산</option>
								<option value="KT">KT</option>
								<option value="NC">NC</option>
								<option value="LG">LG</option>
								<option value="KIA">KIA</option>
								<option value="키움">키움</option>
								<option value="롯데">롯데</option>
								<option value="삼성">삼성</option>
								<option value="SK">SK</option>
								<option value="한화">한화</option>
						</select></td>
						<td></td>
					</tr>
					<tr align="center">
						<td colspan="2" class="center">
						<input type="reset" value="취소" onclick="location.href='../'" />&nbsp; 
						<input id="joinProc" type="button" value="가입" />
						</td>
					</tr>
				</form>
			</table>		
		</div>
	</div>
</body>
</html>