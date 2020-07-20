<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="회원가입">
<meta http-equiv="Content=Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		//아이디중복 체크
		$('#idChk').click(function(){
			var id= $('#id').val();
			if(id.length >0){
				location.href="${pageContext.request.contextPath}/member/mailAuth1.gg?id="+id;
				console.log('id 중복 체크');
			}else {
			 	window.alert("아이디를 입력해주세요");
			 	return false;
			}  
			return;
		})

		//email 중복체크 및 인증번호 발송 
		$('#mailAuth').click(function(){
			var email = $('#email').val();
			if(email.length >0){
				$('#mailAuthFrm').submit();
			}else{
				window.alert("이메일을 입력해주세요");
				return false;
			}
		})

		//인증번호 일치 여부 확인 + null 값 확인 후 제출
		$('#mailAuthChk').click(function(){
			var chkNum= $('#chkNum').val();
			var conNum = $('#conNum').val();
			if(chkNum.length >0){
					if(chkNum!=conNum){
						window.alert("인증번호가 일치하지 않습니다.");
						return false;
					}else{
						var r = confirm("인증번호가 일치합니다");
						$('#joinProc').click(function(){
							var name =$('#name').val();
							var pw = $('#pw').val();
							var birth = $('#birth').val();
							if (name.length == 0){
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
<% request.setCharacterEncoding("UTF-8"); %>
	<h2>회원가입</h2>
	<hr />
	<form action="../member/mailAuth1.gg" id="mailAuthFrm" method="post">	
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="id" value="${id}"/>
					<input id="idChk" type="button" value="중복확인" />
				<c:if test="${msg=='fail'}">
					<span>중복되는 아이디 입니다.</span>
				</c:if>
				<c:if test="${msg=='notmember'}">
					<span>사용할 수 있는 아이디 입니다.</span>
				</c:if>
				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" id="email" name="email" value="${email}"/>
				<input id="mailAuth" type="button" value="인증번호 받기" />
				</td>
			</tr>
	</form>
			<tr>
				<td>인증번호</td>
				<td><input id="chkNum" type="text">
					<input id="mailAuthChk" type="button" value="인증번호 확인"/>
					<input type="hidden" id="conNum" value="${num}" />
				</td>
			</tr>
			
	<form action="../member/joinProc.gg" id="joinFrm" method="post" >
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pw" name="pw"/></td>
				<td><input type="hidden" name="id" value="${id}" />
					<input type="hidden" name="email" value="${email}" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" id="pw2" name="pw2"/>
				<span id="pwChk"></span>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" id="birth" name="birth" /></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" id="m" name="gender" value="남자">&nbsp;남자</input>
					<input type="radio" id="f" name="gender" value="여자">&nbsp;여자</input>
					<input type="radio" id="n" name="gender" value=""  checked="checked">&nbsp;선택 안함</input>
				</td>
			</tr>
			<tr>
				<td>선호팀</td>
				<td><select id="team" name="team" >
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
				</select>
			</tr>	
			<tr>
				<td></td>
				<td colspan="2" class="center">
					<input type="reset" value="취소" onclick="location.href='../'" />&nbsp;
					<input id="joinProc" type="button" value="가입" /></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>