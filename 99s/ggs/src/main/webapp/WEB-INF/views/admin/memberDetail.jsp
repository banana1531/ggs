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
   <h1>memberDetail 들어왔다.</h1>
   <div class="container">
	   <button><a href="/admin/memberSummary.gg">회원 현황</a></button>
	   <button><a href="/admin/memberList.gg">회원 목록</a></button>
   </div>
   <div class="container">
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
							<option value="1">가능</option>
							<option value="0">불가</option></td>
				</tr>
				<tr>
					<td>입력/수정 권한 : <select name="boardM">
							<option value="1">가능</option>
							<option value="0">불가</option></td>
				</tr>
				<tr>
					<td>로그인 권한 : <select name="login">
							<option value="1">가능</option>
							<option value="0">불가</option></td>
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