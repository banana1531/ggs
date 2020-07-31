<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			vAxis : {
				minValue : 0
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
			}
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
	
	var result=$("#result").val();
	if(result!=''){
		alert(result);
	}
	
});
</script>



<title>Insert title here</title>
</head>


<body>
	<div class="container" >
			<a href="/teampredict/prematchMain.gg"><button>승부예측</button></a>
			<a href="/teampredict/schmatchList.gg"><button>경기일정</button></a>
			<a href="/teampredict/rltmatchList.gg"><button>경기결과</button></a>
	</div>
	<hr/>
		<!-- 상세보기 내용 출력 -->
		<div class="container" align="center">

		<c:choose>
			<c:when test="${TRDTO.ateamname=='경기없음'}">
				<h3>
					<fmt:formatDate value="${TRDTO.gdate }" />
					${TRDTO.gtime }
				</h3>
			</c:when>
			<c:otherwise>
				<table border="1" width="600">
					<tr>
						<td align="center"><h4>
								<img width="100" height="60"
									src="/resources/img/${TRDTO.ateamname}.jpg">${TRDTO.ateamname}
								vs ${TRDTO.bteamname}<img width="100" height="60"
									src="/resources/img/${TRDTO.bteamname}.jpg">
							</h4> 
							<span style="font-size: 16px; font-weight: bold;">
							<fmt:formatDate value="${TRDTO.gdate }"/> ${TRDTO.gtime } ${TRDTO.stadium }</span>
							</td>
					</tr>
				</table>

				<hr />

				<!-- 그래프 출력 -->

				<div class="container" id="top_x_div"
					style="width: 600px; height: 300px;"></div>
				
				<div class="btn-group btn-group-justified"
					style="width: 580px; margin-left: 10px">
					<div class="btn-group">
						<button type="button" class="btn btn-primary">${TRDTO.ateamname}</button>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-primary">무승부</button>
					</div>
					<div class="btn-group">
						<button type="button" class="btn btn-primary">${TRDTO.bteamname}</button>
					</div>
					<input type="hidden" id="id" value="${UID}"> <input
						type="hidden" id="gno" value="${TRDTO.gno}">
				</div>
				<input type="hidden" id="result" value="${result }">

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
					<td>${atrDTO.win}/${atrDTO.lose}</td><td>승/패</td><td>${btrDTO.win}/${btrDTO.lose}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.score}/${atrDTO.loss}</td><td>득점/실점</td><td>${btrDTO.score}/${btrDTO.loss}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.maxScore}/${atrDTO.maxLoss}</td><td>최다득점/최다실점</td><td>${btrDTO.maxScore}/${btrDTO.maxLoss}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.zeroScore}/${atrDTO.zeroLoss}</td><td>무득점/무실점</td><td>${btrDTO.zeroScore}/${btrDTO.zeroLoss}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.rate}</td><td>승률</td><td>${btrDTO.rate}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.avgScore}</td><td>평균득점</td><td>${btrDTO.avgScore}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.avgLoss}</td><td>평균실점</td><td>${btrDTO.avgLoss}</td>
				</tr>
					</table>
				</div>

			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>


