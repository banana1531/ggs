<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
				<h3>오늘의 경기 투표하기</h3>
				<hr>
					<div class="container">
						<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
						<button><a href="/teampredict/schmatchList.gg">경기일정</a>	</button>
						<button><a href="/teampredict/rltmatchList.gg">경기결과</a>	</button>
					</div>
				<hr>
			<!-- 상세보기 내용 출력 -->
				<h3>투표하기</h3>
				<table border="1" width="800">
						<tr>
							<td>${TRDTO.ateamname}</td>
							<td>vs</td>
							<td>${TRDTO.bteamname}</td>
						</tr>
						<tr>
						<form action="/teampredict/electmatch.gg?" method="get">
								<td><input type="submit" name="predict" value="${TRDTO.ateamname} 승"/></td>
								<td><input type="submit" name="predict" value="무승부"/></td>
								<td><input type="submit" name="predict" value="${TRDTO.bteamname} 승"/></td>
			
								<input type="hidden" name = "gno" value="${TRDTO.gno}"/>
								<input type="hidden" name = "ateamname" value="${TRDTO.ateamname}"/>
								<input type="hidden" name = "bteamname" value="${TRDTO.bteamname}"/>
						</form>
						</tr>
						<hr> 
						</table>

						<hr>
						<!-- 그래프 출력 -->
						<div id="top_x_div" style="width: 800px; height: 600px;"></div>
						<hr>
						<h3>팀 실적</h3>
						<form method="get">
		   			<table border="1" width="800" class="center">
	    			  <tbody>
	         			<tr>
				            <th>${TRDTO.ateamname}</th>
				            <th>vs</th>
				            <th>${TRDTO.bteamname}</th>
	      			  </tr>
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
      			</form>
</body>
</html>


