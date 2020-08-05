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
		var data = new google.visualization.arrayToDataTable( ${preCount});
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
				<td align="center">
					<h4>
							${detail.ateamname} 
							<img width="100"height="60" src="/resources/img/${detail.ateamname}.jpg">
							<c:choose>
								<c:when test="${schedule==null }">
									<span style="font-size: 28px; font-weight: bold;">${detail.ascore } : ${detail.bscore }</span>
								</c:when>
								<c:otherwise>
									<img width="80" height="60"	src="/resources/img/red blue vs.png">
								</c:otherwise>
							</c:choose>
							<img width="100" height="60"src="/resources/img/${detail.bteamname}.jpg">
							${detail.bteamname}
					</h4>
						 <span style="font-size: 16px; font-weight: bold;"><fmt:formatDate value="${detail.gdate }"/> ${detail.gtime } ${detail.stadium }</span>
				
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
					<td>구분</td>
					<td><img width="50" height="30"
						src="/resources/img/${detail.bteamname}.jpg"></td>
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
		<c:if test="${schedule==null}">
			<form name="myForm" action="/teampredict/reply">
				<table class="table" style="width: 600px">
					<tr>
						<td width="15%"><input name="id" value="${UID}"
							style="border: none; width: 80px"></td>
						<td><textarea name="content" rows="1" cols="50" required="required"></textarea></td>
						<td width="15%"><button class="btn">등록</button>
						<input type="hidden" name="gno" value="${detail.gno }">
						<input type="hidden" name="wno" value="${detail.gno }">
						</td>
					</tr>
				</table>
			</form>
		<div class="contaner" id="list" align="center" style="width: 600px"></div></c:if>
			
	</div>
</body>
</html>