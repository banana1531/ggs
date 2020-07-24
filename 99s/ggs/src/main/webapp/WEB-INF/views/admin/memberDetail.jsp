<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		
</script>
</head>
<body>
   <div class="container">
	  <a href="/admin/memberSummary.gg"> <button>회원 현황</button></a>
	   <a href="/admin/memberList.gg"><button>회원 목록</button></a>
   </div>
   <div class="container" >
   <h4>회원 권한 수정</h4>
		<form action="/admin/memberUpdate.gg">
			<table class="table">
				<tr>
					<td>아이디 :</td>
					<td><input name="id" value="${member.id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><input name="name" value="${member.name}" readonly="readonly"></td>
				</tr>
				<tr>
					<td>생년월일 :</td>
					<td><input name="birth" value="${member.birth }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>성별 :</td>
					<td><input name="gender" value="${member.gender }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>선호팀 :</td>
					<td><input name="team" value="${member.team }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>가입일 :</td>
					<td><fmt:formatDate value="${member.joindate }"
							pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td>포인트 :</td>
					<td><input name="ppoint" value="${member.ppoint }" readonly="readonly"></td>
				</tr>
				<tr>
					<td rowspan="3">권한 :</td>
					<td>조회권한 : <select name="boardV">
						<c:choose>
							<c:when test="${member.boardV==1}">
								<option value="1" selected="selected">가능</option>
								<option value="0">불가</option></c:when>
							<c:otherwise>
								<option value="1">가능</option>
								<option value="0" selected="selected">불가</option></c:otherwise>
						</c:choose></select>
				</tr>
				<tr>
					<td>입력/수정 권한 : <select name="boardM">
									<c:choose>
							<c:when test="${member.boardM==1}">
								<option value="1" selected="selected">가능</option>
								<option value="0">불가</option></c:when>
							<c:otherwise>
								<option value="1">가능</option>
								<option value="0" selected="selected">불가</option></c:otherwise>
						</c:choose></select></td>
				</tr>
				<tr>
					<td>로그인 권한 : <select name="login">
									<c:choose>
							<c:when test="${member.login==1}">
								<option value="1" selected="selected">가능</option>
								<option value="0">불가</option></c:when>
							<c:otherwise>
								<option value="1">가능</option>
								<option value="0" selected="selected">불가</option></c:otherwise>
						</c:choose></select></td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="btn">수정하기</button>
					</td>
				</tr>
				
			</table>
		</form>
	</div>
</body>
</html>