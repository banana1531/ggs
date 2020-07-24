<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>


<script type="text/javascript"	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
			google.charts.load('current', {	'packages' : [ 'bar' ]	});
			google.charts.setOnLoadCallback(drawStuff);
			function drawStuff() {
				var data = new google.visualization.arrayToDataTable(${preCount});
				var options = {
						width : 800,
						legend : {
							position : 'none'
						},
						chart : {
							title : '경기 예측 현황'
						},
						axes : {
							x : {
								0 : {
									side : 'top',
									label : '경기예측현황'
								}
							}
						},
						bar : {
							groupWidth : "20%"
						}
					};
						var chart = new google.charts.Bar(document.getElementById('top_x_div'));
						chart.draw(data, google.charts.Bar.convertOptions(options));
			};
</script>
<title>Insert title here</title>
</head>
<body>
		<h1>경기 결과</h1>
			<div class="container">
				<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
				<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
				<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
			</div>
		<h3>경기결과</h3>
<table border="1" width="800">
<tr>
	<td>경기날짜</td>
	<td>경기시간</td>
	<td>경기</td>
	<td>구장</td>
</tr>
<c:forEach items="${SchMatchDetail}" var="list">
<tr>

			<td colspan>${list.gdate}</td>
			<td colspan>${list.gtime}</td>
			<td colspan>${list.ateamname} ${list.ascore} vs ${list.bscore} ${list.bteamname}</td>
			<td>${list.stadium}</td>
			</c:forEach>
						
	   <table border="1" width="800" class="center">
      <tbody>
         <tr>
            <th>${TRDTO.ateamname}</th>
            <th>vs</th>
            <th>${TRDTO.bteamname}</th>
         </tr>
               
					
		<!-- 그래프 출력 -->

		<div id="top_x_div" style="width: 800px; height: 600px;"></div>
						<h3>팀 실적</h3>
            <tr>
									<td>${atrDTO.win}</td>
									<td>승</td>
									<td>${btrDTO.win}</td>
							</tr>
							<tr>
									<td>${atrDTO.lose}</td>
									<td>패</td>
									<td>${btrDTO.lose}</td>
							</tr>
							<tr>
									<td>${atrDTO.draw}</td>
									<td>무</td>
									<td>${btrDTO.draw}</td>
							</tr>
         			<tr>
									<td>${atrDTO.score}</td>
									<td>득점</td>
									<td>${btrDTO.score}</td>
							</tr>
							<tr>
									<td>${atrDTO.loss}</td>
									<td>실점</td>
									<td>${btrDTO.loss}</td>
							</tr>
							</tbody>
						</table>
						
							<h3>댓글</h3>
							<table border="1" width="800">
							<c:forEach items="${rltmatchReply}" var="rltmatchReply">
							<tr>
							<td>${rltmatchReply.id}</td>
							<td width=80%>${rltmatchReply.content}</td>
							</tr>
							</c:forEach>

							<form  id = "reply" name= "butt" action="/teampredict/rltmatchDetail.gg" method="post">
								<input type="text" name='content'  id="butt" cols="80"  width="800" placeholder="무분별한 비방,욕설,상업적 내용 등은 삭제될 수 있음을 사전에 공지합니다."/>
							<input type="hidden" name = "gno" value="${TRDTO.gno}"/>
							<input type="hidden" name = "ateamname" value="${TRDTO.ateamname}"/>
							<input type="hidden" name = "bteamname" value="${TRDTO.bteamname}"/>
						 </form>
							<input type="button" id= "write" value = "write" onclick="write()"/>
							</table>
							
		</body>
</html>