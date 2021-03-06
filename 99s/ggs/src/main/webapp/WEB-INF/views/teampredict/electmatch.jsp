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
		<c:forEach items="${TodayMatch}" var="list">
	<form action="/teampredict/prematchDetail.gg?" method="get">
	</form>
	</c:forEach>
		<h1>승부예측페이지 상세입니다</h1>
		<hr>
		<div class="container">
			<button>
				<a href="/teampredict/prematchMain.gg">승부예측</a>
			</button>
			<button>
				<a href="/teampredict/schmatchList.gg">경기일정</a>
			</button>
			<button>
				<a href="/teampredict/rltmatchList.gg">경기결과</a>
			</button>
		</div>
		<hr>
		<!-- 상세보기 내용 출력 -->
		<table border="1" width="100%">
			<tr>
				<td>${TRDTO.ateamname}</td>
				<td>vs</td>
				<td>${TRDTO.bteamname}</td>
			</tr>
<%-- 			<tr>
							<td colspan="3">${preCount.predict} 에 투표하셨습니다!</td>
			</tr>
			<tr>
							<td colspan="3">득표 수 :  ${preCount.precount}</td>
			</tr> --%>
		<br> 
		</form>
		</table>

		<hr>

		<!-- 그래프 출력 -->

		<div id="top_x_div" style="width: 800px; height: 600px;"></div>
		<p>팀 실적</p>

		<form method="get">
		   <table border="1" width="800" class="center">
      <tbody>
         <tr>
            <td>${TRDTO.ateamname}</td>
            <td>vs</td>
            <td>${TRDTO.bteamname}</td>
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
		<hr>
</body>
</html>
