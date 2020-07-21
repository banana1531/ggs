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
			소속팀<input type="text" name="pno" value="${player.teamname}">
			포시션<input type="text" name="pno" value="${player.ptype}">
			경기일자<input type="text" name="pno" value="${player.gdate}">
			상대팀<input type="text" name="pno" value="${player.vs}">
			경기결과<input type="text" name="gresult" value="${player.gresult}">
			선발유뮤<input type="text" name="pno" value="${player.sunbal}">
			이닝<input type="text" name="pno" value="${player.ining}">
			실점<input type="text" name="pno" value="${player.siljum}">
			자책점<input type="text" name="pno" value="${player.jachak}">
			상대한 타자수<input type="text" name="pno" value="${player.taja}">
			상대한 타수<input type="text" name="pno" value="${player.tasu}">
			피 안타<input type="text" name="pno" value="${player.anta}">
			피 2루타<input type="text" name="pno" value="${player.eta}">
			피 3루타<input type="text" name="pno" value="${player.samta}">
			피 홈런<input type="text" name="pno" value="${player.home_run}">
			볼넷<input type="text" name="pno" value="${player.ball4}">
			고의 4구<input type="text" name="pno" value="${player.go4}">
			사구<input type="text" name="pno" value="${player.sagu}">
			삼진<input type="text" name="pno" value="${player.samjin}">
			투구수<input type="text" name="pno" value="${player.tugu}">
			<input type="text" name="pno" value="${player.whip}">
			타율<input type="text" name="pno" value="${player.tayul}">
			<input type="text" name="pno" value="${player.culu}">
			<input type="text" name="pno" value="${player.ops}">
			<input type="text" name="pno" value="${player.era}">
			<input type="text" name="pno" value="${player.avli}">
			<input type="text" name="pno" value="${player.re24}">
			<input type="text" name="pno" value="${player.wpa}">
			<input type="text" name="pno" value="${player.gsc}">
			<input type="text" name="pno" value="${player.gdec}">
			<input type="text" name="pno" value="${player.gangyuk}">
			<input type="text" name="pno" value="${player.tasun}">
			<input type="text" name="pno" value="${player.p}">
			<input type="text" name="pno" value="${player.djum}">
			<input type="text" name="pno" value="${player.ruta}">
			<input type="text" name="pno" value="${player.tajum}">
			<input type="text" name="pno" value="${player.doru}">
			<input type="text" name="pno" value="${player.dosil}">
			<input type="text" name="pno" value="${player.byungsal}">
			<input type="text" name="pno" value="${player.hita}">
			<input type="text" name="pno" value="${player.hibi}">
			<input type="text" name="pno" value="${player.jangta}">
			<input type="text" name="pno" value="${player.name}">
			${player}
			<button type="submit">정보 수정</button>
			</form>
			${result }
	</div>
</body>
</html>