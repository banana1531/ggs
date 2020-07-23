<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {
		'packages' : [ 'bar' ]
	});
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
				// Top x-axis.
				}
			},
			bar : {
				groupWidth : "20%"
			}
		};

		var chart = new google.charts.Bar(document.getElementById('top_x_div'));
		// Convert the Classic options to Material options.
		chart.draw(data, google.charts.Bar.convertOptions(options));
	};
</script>

<title>Insert title here</title>
</head>

<body>
	<h1>경기결과페이지 상세입니다</h1>
	<div class="container">
		<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
		<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
		<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
	</div>
<p>경기결과</p>
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
		<p>팀 실적</p>
		
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
<%-- 					<h3>댓글</h3>
						<table border="1" width="800" class="center">
							<tbody>
								<c:forEach items="${InfoErrorBoardReply}" var="dto">
						<tr>
							<td width="20%"><h5>${dto.id}</h5></td>
							<td><h4>${dto.content}</h4></td>
							<td width="20%"><h5><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></h5></td>
				</tr> 
			</c:forEach>--%>
		</tbody>
	</table>
		</table>
</body>
</html>