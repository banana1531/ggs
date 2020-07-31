<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀별 역대 관중 비율</title>
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
	        text: '팀별 관중 비중'
	    },
	    xAxis: {
	        categories: ${yearList}
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: '관중수(명)			SK:쌍방울+SK, 키움:삼미+청보+태평양+현대+넥센 관객 총합'
	        }
	    },
	    legend: {
	        reversed: true
	    },
	    plotOptions: {
	        series: {
	            stacking: 'normal'
	        }
	    },
	    series: [{
	        name: 'KT',
	        data: ${kttList}
	    }, {
	        name: 'NC',
	        data: ${nctList}
	    }, {
	        name: '키움',
	        data: ${kiwoomtList}
	    }, {
	        name: 'SK',
	        data: ${sktList}
	    }, {
	        name: '한화',
	        data: ${hanwhatList}
	    }, {
	        name: '두산',
	        data: ${doosantList}
	    }, {
	        name: 'LG',  
	        data: ${lgtList}
	    }, {
	        name: '롯데',
	        data: ${lottetList}
	    }, {
	        name: '기아',
	        data: ${kiatList}
	    }, {
	        name: '삼성',
	        data: ${samsungtList}
	    }]
	});
});
</script>
</head>
<body>
	<a href="../admin/adminMain.gg">메인으로</a>
	<a href="../crowd/crowdHistory.gg">역대 관중 현황</a>
	<a href="../crowd/crowdHistoryGraph.gg">역대 관중 현황 그래프</a>
	<h3>crowdHistory</h3>
	<h3>팀별 역대 관중 비율</h3>
	<br>
	<br>
	<br>
<figure class="highcharts-figure">
    <div id="container"></div>
    <p class="highcharts-description"></p>
</figure>

	
</body>
</html>
