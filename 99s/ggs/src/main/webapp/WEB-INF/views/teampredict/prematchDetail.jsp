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
		var data = new google.visualization.arrayToDataTable([
				[ 'Move', 'Percentage' ], [ "홈팀 승리", 44 ], [ "무승부", 31 ],
				[ "어웨이팀 승리", 31 ], ]);

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
	<form action="/teampredict/electedMatch.gg" method="post">
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
		<table border="0" width="100%">
			<tr>
				<td>${TRDTO.ateamname}</td>
				<td>vs</td>
				<td>${TRDTO.bteamname}</td>
			</tr>
		</table>

		<tr>
			<td><input type="checkbox" name="match" value=1>${TRDTO.ateamname}
				승</td>
			<td><input type="checkbox" name="match" value=2>무승부</td>
			<td><input type="checkbox" name="match" value=3>${TRDTO.bteamname}
				승</td>
		</tr>
		<br> <input type="submit" value="투표하기" />
		<hr>

		<!-- 그래프 출력 -->

		<div id="top_x_div" style="width: 800px; height: 600px;"></div>
		<p>팀 실적</p>

		<form method="get">
		   <table border="1" width="800" class="center">
      <tbody>
         <tr>
            <th>KT</th>
            <th>vs</th>
            <th>삼성</th>
         </tr>
         <c:forEach items="${atrDTO}" var="dto">
            <tr>
							<td>${dto.win}승 ${dto.draw}무 ${dto.score}패</td>
							<td>누적승패</td>
							<td></td>
						</tr>
         </c:forEach>
      </tbody>
         </table>
      </form>
		<hr>
</body>
</html>


