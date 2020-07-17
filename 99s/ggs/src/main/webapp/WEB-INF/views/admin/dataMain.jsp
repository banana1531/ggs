<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	/* $("#body").load("/admin/teamList") */
	$("#teamlist").click(function(){
		$("#body").load("/admin/teamList")
	})
	$("#playlist").click(function(){
		$("#body").load("/admin/playerList")
	})
	$("#gamelist").click(function(){
		$("#body").load("/admin/gameList")
	})	
})
</script>
</head>
<body>
   <div class="container">
	   <button id="teamlist">팀 목록</a></button>
	   <button id="playlist">선수 목록</a></button>
	   <button id="gamelist">경기 목록</a></button>
   </div>
   <div class="container" id="body">
   </div>
</body>
</html>