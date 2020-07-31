<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
<script>
$(function(){
	$(".btn").click(function(){
		var gno=(this).find("#gno").val();
		location = "/teampredict/prematchDetail.gg?gno="+gno		
	})
})
</script>
</head>
<body>
<div class="container" align="center">
<h2>99s에 오신걸 환영합니다.</h2>
	 <div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 800px">
	  <!-- Indicators -->
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    <li data-target="#myCarousel" data-slide-to="1"></li>
	    <li data-target="#myCarousel" data-slide-to="2"></li>
	    <li data-target="#myCarousel" data-slide-to="3"></li>
	    <li data-target="#myCarousel" data-slide-to="4"></li>
	    <li data-target="#myCarousel" data-slide-to="5"></li>
	    <li data-target="#myCarousel" data-slide-to="6"></li>
	  </ol>
	
	  <!-- Wrapper for slides -->
	  <div class="carousel-inner">
	    <div class="item active">
	      <img src="/resources/img/선수.jpg" alt="선수" style=" width: 590px; height: 300px;">
	    </div>
	    
	    <div class="item">
	      <img src="/resources/img/선수3.jpg" alt="선수3" style="width:480px; height: 300px">
	    </div>
	    
	    <div class="item">
	      <img src="/resources/img/선수4.jpg" alt="선수4" style="width:450px; height: 300px">
	    </div>
	    
	    <div class="item">
	      <img src="/resources/img/야구공.jpg" alt="야구공" style="width:400px; height: 300px">
	    </div>
	    
	    <div class="item">
	      <img src="/resources/img/야구공2.jpg" alt="야구공2" style="width:450px; height: 300px">
	    </div>
	    
	    <div class="item">
	      <img src="/resources/img/야구장.jpg" alt="야구장" style="width: 800px ;height: 300px">
	    </div>
	    
	    
	  </div>
	
	  <!-- Left and right controls -->
	  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control" href="#myCarousel" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
		<div class="container" style="width: 800px">
		<h4><b>금일 경기 일정</b></h4>
		<c:forEach items="${TodayMatch}" var="dto">
			<a href="/teampredict/prematchDetail.gg?gno=${dto.gno }">
				<button class="btn btn-default"> 
					<img src="/resources/img/${dto.ateamname}.jpg" style="width: 80px; height: 60px">
					<img src="/resources/img/red blue vs.png" style="width: 80px; height: 60px">
					<img src="/resources/img/${dto.bteamname}.jpg" style="width: 80px; height: 60px">
					<br/><b>시간 : ${dto.gtime }, 경기장 : ${dto.stadium }</b>
				</button>
			</a>
		</c:forEach>
	</div>
	
</div>
</body>
</html>
