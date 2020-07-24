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
	<div class="container" >
			<button><a href="/teampredict/prematchMain.gg">승부예측</a>	</button>
			<button><a href="/teampredict/schmatchList.gg">경기일정</a>	</button>
			<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
	</div>
	<hr/>
		<!-- 상세보기 내용 출력 -->
		<div class="container" align="center">
		<table border="1" width="800">
			<tr>
				<td>${TRDTO.ateamname} vs ${TRDTO.bteamname}</td>
			</tr>


		<tr>
			<form action="/teampredict/electmatch.gg?" method="get">
			<td><input type="submit" name="predict" value="${TRDTO.ateamname}"/></td>
			<td><input type="submit" name="predict" value="무승부"/></td>
			<td><input type="submit" name="predict" value="${TRDTO.bteamname}"/></td>
			<input type="hidden" name = "gno" value="${TRDTO.gno}"/>
			<input type="hidden" name = "ateamname" value="${TRDTO.ateamname}"/>
			<input type="hidden" name = "bteamname" value="${TRDTO.bteamname}"/>
			</form>
		</tr>
		</table>
		</div>
		<hr/>

		<!-- 그래프 출력 -->

		<div class="container" id="top_x_div" style="width: 800px; height: 300px;"></div>
		
		<div class="container" align="center">
		<p>팀 실적</p>
	<table border="1" width="800" >
		<tbody>
			<tr align="center">
				<td><b>${TRDTO.ateamname}</b></td>
				<td><b>vs</b></td>
				<td><b>${TRDTO.bteamname}</b></td>
			</tr>

			<tr align="center">
				<td>${atrDTO.win}</td>
				<td>승</td>
				<td>${btrDTO.win}</td>
			</tr>
			<tr align="center">
				<td>${atrDTO.lose}</td>
				<td>패</td>
				<td>${btrDTO.lose}</td>
			</tr>
			<tr align="center">
				<td>${atrDTO.draw}</td>
				<td>무</td>
				<td>${btrDTO.draw}</td>
			</tr>
			<tr align="center">
				<td>${atrDTO.score}</td>
				<td>득점</td>
				<td>${btrDTO.score}</td>
			</tr>
			<tr align="center">
				<td>${atrDTO.loss}</td>
				<td>실점</td>
				<td>${btrDTO.loss}</td>
			</tr>


		</tbody>
	</table>
	</div>
</body>
</html>


