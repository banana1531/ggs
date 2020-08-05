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
				legend:{position: 'top', textStyle: {fontSize: 12}},
			hAxis : {
				title : 'week'
			},
			vAxis : {
				title : '명',
				minValue : 0
			},
			colors : [ '#a52714', '#097138' ]
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	};
</script>
<script>
	google.charts.load('current', {
		packages : ['corechart']});
	google.charts.setOnLoadCallback(drawLineColors);

	function drawLineColors() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'X');
		data.addColumn('number', '가입자수');
		data.addRows(${weeklyjoin });
		var options = {
				legend:{position: 'top', textStyle: {fontSize: 12}},
			hAxis : {
				title : 'week'
			},
			vAxis : {
				title : '명',
				minValue : 0
			},
			colors : [ '#a52714', '#097138' ]
		};

		var chart = new google.visualization.LineChart(document
				.getElementById('chart_div2'));
		chart.draw(data, options);
	};
</script>
</head>
<body>
      <div class="container">
	    <a href="/admin/memberSummary.gg"> <button>회원 현황</button></a>
	   <a href="/admin/memberList.gg"><button>회원 목록</button></a>
   </div>
   <div class="container">
   	<h4>회원 현황</h4>
   <table class="table">
			<tr>
				<td>금일 접속자수 : ${dto.today }</td>
			</tr>
			<tr>
				<td>금주 접속자수 : ${dto.weeklylogin }</td>
			</tr>
			<tr>
				<td>금주 가입자수 : ${dto.weeklyjoin }</td>
			</tr>
			<tr>
				<td>전체 가입자수 : ${dto.totalmembers }</td>
			</tr>
		</table>
   		<div id="chart_div"></div>
   		<div id="chart_div2"></div>
   		
   </div>
</body>
</html>