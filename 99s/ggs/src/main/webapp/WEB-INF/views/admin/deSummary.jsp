<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>   
<script>
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable(${reason});

        var options = {
          title: 'My Daily Activities',
          legend:{position: 'top', textStyle: {fontSize: 12}},
          is3D:true
          
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      } 
</script>
<script>
	google.charts.load('current', {
		packages : ['corechart']});
	google.charts.setOnLoadCallback(drawLineColors);

	function drawLineColors() {
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'X');
		data.addColumn('number', '접수건');
				
		data.addRows(${weekly});

		var options = {
			title:'주간별 누적 접수건',
			legend:{position: 'top', textStyle: {fontSize: 12}},
			hAxis : {
				title : 'week'
			},
			vAxis : {
				title : '건',
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
		data.addColumn('number', '평균처리시간');		
		data.addRows(${avgTime});

		var options = {
			title:'주간단위 평균 신고 처리 시간',
			legend:{position: 'top', textStyle: {fontSize: 12}},
			hAxis : {
				title : 'week'
			},
			vAxis : {
				title : '시간',
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
  <a href="/admin/deSummary.gg"><button>접수 현황</button></a>
	  <a href="/admin/declList.gg"><button>미처리 목록</button></a>
	  <a href="/admin/dondeclList.gg"><button>처리완료 목록</button></a>
   </div>
   
   <div class="container" id="container">
   신고 처리 현황
		<table class="table">
			<tr>
				<td>금일 접수건 : ${todayCnt }<br /> 미처리건 : ${toDoCnt }<br /> 금주 누적
					접수건 : ${weekCnt }<br />
				</td>
			</tr>
			<tr>

				<td><div id="chart_div" style="width: 800px; height: 250px;"></div></td>
				<td rowspan="2">
				<div id="piechart" style="width: 400px; height: 500px;"></div></td>
			</tr>
			<tr>
				<td><div id="chart_div2" style="width: 800px; height: 250px;"></div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>