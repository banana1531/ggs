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
	$("#back").click(function(){
		var pno=$('input[name=pno]').val();
		location = "/admin/playerDetail.gg?pno="+pno
	})
})
</script>
</head>
<body>
   <div class="container">
	   <button><a href="/admin/teamList.gg">팀 목록</a></button>
	   <button><a href="/admin/playerList.gg">선수 목록</a></button>
	   <button><a href="/admin/gameList.gg">경기 목록</a></button>
	   <button id="back">앞으로 가기</button>
   </div>
	<div class="container">
	<form action="/admin/playerRecordUpdate.gg">
			<input type="text" name="pgno" value="${player.pgno}" readonly="readonly">
			<input type="text" name="pno" value="${player.pno}" readonly="readonly">
			${player.teamname}
			${player.ptype}
			${player.gdate}
			${player.vs}
			<input type="text" name="gresult" value="${player.gresult}">
			${player.sunbal}
			${player.ining}
			${player.siljum}
			${player.jachak}
			${player.taja}
			${player.tasu}
			${player.anta}
			${player.eta}
			${player}
			<button type="submit">정보 수정</button>
			</form>
			${result }
	</div>
</body>
</html>