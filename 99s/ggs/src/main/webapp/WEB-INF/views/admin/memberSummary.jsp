<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>    
<script>
	google.charts.load('current', {
		packages : ['corechart']});
	google.charts.setOnLoadCallback(drawLineColors);

	function drawLineColors() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'X');
		data.addColumn('number', '접속자수');
		data.addRows(${weekly});
		var options = {
			hAxis : {
				title : 'week'
			},
			vAxis : {
				title : 'Count',
				minValue : 0
			},
			colors : [ '#a52714', '#097138' ]
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	};
</script>
</head>
<body>
      <div class="container">
	   <button><a href="/admin/memberSummary.gg">회원 현황</a></button>
	   <button><a href="/admin/memberList.gg">회원 목록</a></button>
   </div>
   <div class="container">
   회원 현황
   <table class="table">
			<tr>
				<td>금일 접속자수 :</td>
				<td>${todayCnt }</td>
			</tr>
			<tr>
				<td>가입자수 :</td>
				<td>${totalCnt }</td>
			</tr>
		</table>
   		<div id="chart_div"></div>
   
   </div>
</body>
</html>