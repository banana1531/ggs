<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container" style="margin-bottom: 30px">
	   <a href="/mypage/mypageMain.gg"><button>My Page</button></a>
	   <a href="/mypage/myTeamDetail.gg"><button>My Team</button></a>
	   <a href="/mypage/checkPw.gg"><button>내 정보 수정</button></a>
    </div>
   
	<div class='container' align="center" style="margin-top: 150px">
		<form class='form-inline' action="/mypage/myInfoModify.gg" method="post">
			<table class="table" style="width: 300px">
				<tr>
					<td>아이디 :</td>
					<td><input type="text" name="id" readonly="readonly" value="${myinfo.id }" style="border: none;"></td>
				</tr>
				<tr>
					<td>비밀번호 : </td>
					<td><a href="/mypage/updatePwForm.gg"><input type="button" id='chPw' value="비밀번호 변경하기"></a></td>
				</tr>
				<tr>
					<td>이름 : </td>
					<td><input type="text" readonly="readonly" value="${myinfo.name}" style="border: none;"></td>					
				</tr>
				<tr>
					<td>생년월일 : </td>
					<td><input type="text" readonly="readonly" value="${myinfo.birth }" style="border: none;"></td>				
				</tr>
				<tr>
					<td>성별 : </td>
					<td><input type="text" readonly="readonly" value="${myinfo.gender }" style="border: none;"></td>
				</tr>
				<tr>
					<td>가입일 : </td>
					<td><fmt:formatDate value="${myinfo.joindate }"/></td>
				</tr>
				<tr>
					<td>email : </td>
					<td><input type="text" readonly="readonly" value="${myinfo.email }" style="border: none;"></td>
				</tr>
				<tr>
					<td>선호팀 : </td>
					<td>
						<select name="team"> 
							<c:choose>
								<c:when test="${myinfo.team=='없음' }"><option value="없음" selected="selected">없음</option></c:when>
								<c:otherwise><option value="없음">없음</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='두산' }"><option value="두산" selected="selected">두산</option></c:when>
								<c:otherwise><option value="두산">두산</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='롯데' }"><option value="롯데" selected="selected">롯데</option></c:when>
								<c:otherwise><option value="롯데">롯데</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='삼성' }"><option value="삼성" selected="selected">삼성</option></c:when>
								<c:otherwise><option value="삼성">삼성</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='키움' }"><option value="키움" selected="selected">키움</option></c:when>
								<c:otherwise>	<option value="키움">키움</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='한화' }"><option value="한화" selected="selected">한화</option></c:when>
								<c:otherwise><option value="한화">한화</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='KIA' }"><option value="KIA" selected="selected">KIA</option></c:when>
								<c:otherwise><option value="KIA">KIA</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='KT' }"><option value="KT" selected="selected">KT</option></c:when>
								<c:otherwise><option value="KT">KT</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='LG' }"><option value="LG" selected="selected">LG</option></c:when>
								<c:otherwise><option value="LG">LG</option></c:otherwise>
							</c:choose>
							<c:choose>
							<c:when test="${myinfo.team=='NC' }"><option value="NC" selected="selected">NC</option></c:when>
								<c:otherwise><option value="NC">NC</option></c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${myinfo.team=='SK' }"><option value="SK" selected="selected">SK</option></c:when>
								<c:otherwise><option value="SK">SK</option></c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button class="btn" style="width: 80px">수정하기</button>
						<button type="reset" class="btn" style="width: 80px">취소</button>
						<a href="/mypage/leaveForm.gg"><button type="button" class="btn" style="width: 80px">탈퇴하기</button></a>
					</td>
				</tr>
			</table>
			${result }
		</form>
	</div>	
	
</body>
</html>