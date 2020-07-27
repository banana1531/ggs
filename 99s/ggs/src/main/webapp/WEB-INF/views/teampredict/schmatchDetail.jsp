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
<title>Insert title here</title>
<script>
	google.charts.load('current', {'packages':['bar']});
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
		};

		var chart = new google.charts.Bar(document.getElementById('top_x_div'));
		// Convert the Classic options to Material options.
		chart.draw(data, google.charts.Bar.convertOptions(options));
	};
</script>
<script>
$(function(){
	var writeno = $("#writeno").val();
	$("#list").load("/teampredict/replyList?&writeno="+writeno);
})
</script>

</head>
<body>
	<div class="container">
		<a href="/teampredict/prematchMain.gg"><button>승부예측</button></a>
		<a href="/teampredict/schmatchList.gg"><button>경기일정</button></a>
		<a href="/teampredict/rltmatchList.gg"><button>경기결과</button></a>
	</div>
	<div class="container" align="center">
		<div class="container" align="center">
		<c:choose>
			<c:when test="${schedule==null}">	<h4>경기결과</h4>	</c:when>
			<c:otherwise><h4>경기일정</h4></c:otherwise>
		</c:choose>
			
<table border="1" width="600;">
			<tr>
				<td align="center"><h4><img width="100" height="60" src="/resources/img/${detail.ateamname}.jpg">${detail.ateamname}  vs ${detail.bteamname}<img width="100" height="60" src="/resources/img/${detail.bteamname}.jpg"></h4>
				<fmt:formatDate value="${detail.gdate }"/> ${detail.gtime } ${detail.stadium }
				<input type="hidden" id="writeno" value="${detail.gno }"> 
				</td>
			</tr>
		</table>
		</div>
		<c:if test="${schedule==null}">
			<c:if test="${result==null }">
				<div class="container" style="width: 600px; height: 300px;" align="center" id="top_x_div"></div>
			</c:if>
			<div class="container" align="center">${result }</div>
		</c:if>
		<div class="container" align="center">
			<table border="1" class="table" style="width: 500px;">
				<tr align="center">
					<td><img width="50" height="30"
						src="/resources/img/${detail.ateamname}.jpg"></td>
					<td>vs</td>
					<td><img width="50" height="30"
						src="/resources/img/${detail.bteamname}.jpg"></td>
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
		<c:if test="${schedule==null}">
		<div class="contaner" id="list" align="center" style="width: 600px"></div></c:if>
		
	</div>
</body>
</html>