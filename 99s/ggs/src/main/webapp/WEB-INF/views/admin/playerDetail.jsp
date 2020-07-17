<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	var pno=$(this).find("#pno").val();
	$("#list").load("/admin/playerRecord?pno="+pno)
	$(".btn").click(function(){
		var pageNo = $(this).text();
		$("#list").load("/admin/playerRecord?pno="+pno+"&pageNo="+pageNo);
	})
})
</script>
</head>
<body>
   <div class="container">
	   <button><a href="/admin/teamList.gg">팀 목록</a></button>
	   <button><a href="/admin/playerList.gg">선수 목록</a></button>
	   <button><a href="/admin/gameList.gg">경기 목록</a></button>
   </div>
<h4>선수 상세</h4>
   <div class="container" id="body">
   <form action="/admin/playerUpdate.gg">
		<table class="table table-hover">
			<tr>
				<th>이름</th>
				<th>소속 팀</th>
				<th>등번호</th>
				<th>포지션</th>
			</tr>
			<tr>
				<td><input type="hidden" id="pno" value="${player.pno }">
				 <input type="text" name="teamname" value="${player.name }" readonly="readonly"></td>
				<td><input type="text" name="teamname" value="${player.teamname }"></td>
				<td><input type="text" name="labelno" value="${player.labelno }"></td>
				<td><input type="text" name="position" value="${player.position }"></td>
			</tr>
			<tr>
				<th>입단년도</th>
				<th>생년월일</th>
				<th>키</th>
				<th>몸무게</th>
			</tr>
			<tr>
				<td><input type="text" name="joinday" value="${player.joinday }"></td>
				<td><input type="text" name="birth" value="${player.birth }"></td>
				<td><input type="text" name="height" value="${player.height }"></td>
				<td><input type="text" name="weight" value="${player.weight }"></td>
			</tr>
		</table>
		${result}<p align="right"><button>정보 수정</button> </p>
		</form>
		<table class="table" id="list">
		</table>
	</div>
</body>
</html>