<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				groupWidth : "60%"
			},
		};

		var chart = new google.charts.Bar(document.getElementById('top_x_div'));
		// Convert the Classic options to Material options.
		chart.draw(data, google.charts.Bar.convertOptions(options));
	};
</script>
<script>
$(function(){
	
	$(".btn").click(function(){
		var id=$("#id").val();
		var gno=$("#gno").val();
		var predict = $(this).text();
		location="/teampredict/electmatch.gg?id="+id+"&gno="+gno+"&predict="+predict;
	})
})
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
		
<%-- 		<c:choose>
			<c:when test="${TRDTO.ateamname=='경기없음'}">
			<h3><fmt:formatDate value="${TRDTO.gdate }"/> ${TRDTO.gtime }</h3>
			</c:when>
			<c:otherwise> --%>
		<table border="1" width="600">
			<tr>
				<td align="center"><h4><img width="100" height="60" src="/resources/img/${TRDTO.ateamname}.jpg">${TRDTO.ateamname}  vs ${TRDTO.bteamname}<img width="100" height="60" src="/resources/img/${TRDTO.bteamname}.jpg"></h4>
				<fmt:formatDate value="${TRDTO.gdate }"/> ${TRDTO.gtime } ${TRDTO.stadium }</td>
			</tr>
		</table>
		
		<hr/>

		<!-- 그래프 출력 -->

		<div class="container" id="top_x_div" style="width: 600px; height: 300px;"></div>
		
		<div class="btn-group btn-group-justified" style="width: 580px; margin-left: 10px">
			<div class="btn-group">
				<button type="button" class="btn btn-primary">${TRDTO.ateamname}</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary">무승부</button>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-primary">${TRDTO.bteamname}</button>
			</div>
			<input type="hidden" id="id" value="${UID}">
			<input type="hidden" id="gno" value="${TRDTO.gno}">
		</div>



	<div class="container" align="center">
		<p>팀 실적</p>
	<table border="1" class="table" style="width: 500px;">
				<tr align="center">
					<td><img width="50" height="30"
						src="/resources/img/${TRDTO.ateamname}.jpg"></td>
					<td>vs</td>
					<td><img width="50" height="30"
						src="/resources/img/${TRDTO.bteamname}.jpg"></td>
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
			</table>
	</div>
	<%-- 
	</c:otherwise>
		</c:choose> --%>
	</div>
</body>
</html>


