<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#body").load("/admin/memberSummary.gg")
	$("#teamlist").click(function(){
		$("#body").load("/admin/teamList")
	})
})
</script>
</head>
<body>
   <h1>dataMain 들어왔다.</h1>
   <div class="container">
	   <button class="btn" value="">회원 현황</button>
	   <button class=btn" value="">회원 목록</button>
   </div>
   <div class="container" id="body">
   </div>
</body>
</html>