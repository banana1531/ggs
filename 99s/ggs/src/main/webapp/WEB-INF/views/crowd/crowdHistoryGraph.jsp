<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>역대 관중 현황 그래프</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style type="text/css">

.highcharts-figure, .highcharts-data-table table {
  min-width: 310px; 
  max-width: 800px;
  margin: 1em auto;
}

#container {
  height: 700px;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
  padding: 1em 0;
  font-size: 1.2em;
  color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
  padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
  padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
  background: #f8f8f8;
}
.highcharts-data-table tr:hover {
  background: #f1f7ff;
}
</style>
<script type="text/javascript">
$(function(){
Highcharts.chart('container', {
	  chart: {
	    type: 'bar'
	  },
	  title: {
	    text: '연도별 관중 현황'
	  },
	  subtitle: {
	    text: 'Source: <a href="https://www.koreabaseball.com">kbo</a>'
	  },
	  xAxis: {
	    categories: ${yearList},
	    title: {
	      text: null
	    }
	  },
	  yAxis: {
	    min: 0,
	    title: {
	      text: '관중수(명)	SK:쌍방울+SK, 키움:삼미+청보+태평양+현대+넥센+키움 관객 총합',
	      align: 'high'
	    },
	    labels: {
	      overflow: 'justify'
	    }
	  },
	  tooltip: {
	    valueSuffix: ' 명'
	  },
	  plotOptions: {
	    bar: {
	      dataLabels: {
	        enabled: true
	      }
	    }
	  },
	  legend: {
	    layout: 'vertical',
	    align: 'right',
	    verticalAlign: 'top',
	    x: -40,
	    y: 80,
	    floating: true,
	    borderWidth: 1,
	    backgroundColor:
	      Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
	    shadow: true
	  },
	  credits: {
	    enabled: false
	  },
	  series: [  {
	    name: '관중현황 ',
	    data: ${totaltList} /* totaltChar 필요 */
	  }]
	});
});
</script>
</head>
<body>
	<a href="../admin/adminMain.gg">메인으로</a>
	<a href="../crowd/crowdHistory.gg">역대 관중 현황</a>
	<a href="../crowd/crowdHistoryGraph2.gg">팀별 역대 관중 비율</a>
	
	
	<h3>crowdHistory</h3>
	<h3>역대 관중 현황 그래프</h3>
	<br>
	<h3>세자리 쉼표</h3>
	<br>
	<br>

<figure class="highcharts-figure">
  <div id="container"></div>
  <p class="highcharts-description"></p>
</figure>

	<br>
	<br>	
	<br>
	<br>	
	<br>
	<br>
	
	
</body>
</html>
