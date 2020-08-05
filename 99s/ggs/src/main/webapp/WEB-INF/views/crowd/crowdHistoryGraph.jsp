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
	    text: 'Source: <a href="https://en.wikipedia.org/wiki/World_population">Wikipedia.org</a>'
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
	      text: '단위 :명',
	      align: 'high'
	    },
	    labels: {
	      overflow: 'justify'
	    }
	  },
	  tooltip: {
	    valueSuffix: ' millions'
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
	<div class="container">
		<a href="/crowd/crowdHistory.gg"><button>역대 관중현황 표</button> </a>
		<a href="/crowd/crowdHistoryGraph.gg"><button>역대 관중현황 그래프</button> </a>
		<a href="/crowd/crowdHistoryGraph2.gg"><button>팀별 역대 관중 비율</button> </a>
	</div>
	<div class="container">
	<figure class="highcharts-figure">
 	<div id="container"></div>
<!-- 	  <p class="highcharts-description">
	    Bar chart showing horizontal columns. This chart type is often
	    beneficial for smaller screens, as the user can scroll through the data
	    vertically, and axis labels are easy to read.
	  </p> -->
	</figure>

	
	</div>
</body>
</html>
