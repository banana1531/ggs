<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {
        var data = new google.visualization.arrayToDataTable([
          ['Move', 'Percentage'],
          ["홈팀 승리", 44],
          ["무승부", 31],
          ["어웨이팀 승리", 31],
        ]);

        var options = {
          width: 800,
          legend: { position: 'none' },
          chart: {
            title: '경기 예측 현황' },
          axes: {
            x: {
              0: { side: 'top', label: '경기예측현황'} // Top x-axis.
            }
          },
          bar: { groupWidth: "20%" }
        };

        var chart = new google.charts.Bar(document.getElementById('top_x_div'));
        // Convert the Classic options to Material options.
        chart.draw(data, google.charts.Bar.convertOptions(options));
      };
    </script>
    
<title>Insert title here</title>
</head>


<body>
<h1>승부예측페이지 상세입니다</h1>
	<div class="container">
		<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
		<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
		<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
	</div>
</br>

    <div id="top_x_div" style="width: 800px; height: 600px;"></div>
    
</br>
</body>
</html>


	