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
	$("#body").load("/admin/teamList")
	$("#teamlist").click(function(){
		$("#body").load("/admin/teamList")
	})
})
</script>
</head>
<body>
   <h1>dataMain 들어왔다.</h1>
   <div class="container">
	   <button id="teamlist">팀 목록</a></button>
	   <button><a href="#">선수 목록</a></button>
	   <button><a href="#">경기일정 목록</a></button>
   </div>
   <div class="container" id="body">
   </div>
</body>
</html>