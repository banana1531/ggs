<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>야구선수의 비만과 성적 상관관계 분석</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style type="text/css">

#container1 {
  height: 400px; 
}
#container {
  height: 400px; 
}

.highcharts-figure, .highcharts-data-table table {
  min-width: 310px; 
  max-width: 600px;
  margin: 1em auto;
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
		    type: 'column'
		  },
		  title: {
		    text: '팀별 BMI지수 분포 그래프'
		  },
		  xAxis: {
		    categories: ['KIA', 'kT', 'LG', 'NC', 'SK','두산','롯데','삼성','키움','한화']
		  },
		  yAxis: {
		    min: 0,
		    title: {
		      text: '각 BMI지수 총 계 '
		    },
		    stackLabels: {
		      enabled: true,
		      style: {
		        fontWeight: 'bold',
		        color: ( // theme
		          Highcharts.defaultOptions.title.style &&
		          Highcharts.defaultOptions.title.style.color
		        ) || 'gray'
		      }
		    }
		  },
		  legend: {
		    align: 'right',
		    x: -30,
		    verticalAlign: 'top',
		    y: 25,
		    floating: true,
		    backgroundColor:
		      Highcharts.defaultOptions.legend.backgroundColor || 'white',
		    borderColor: '#CCC',
		    borderWidth: 1,
		    shadow: false
		  },
		  tooltip: {
		    headerFormat: '<b>{point.x}</b><br/>',
		    pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
		  },
		  plotOptions: {
		    column: {
		      stacking: 'normal',
		      dataLabels: {
		        enabled: true
		      }
		    }
		  },
		  series: [{
		    name: '정상',
		    data: ${list3}
		  }, {
		    name: '비만',
		    data: ${list5}
		  }, {
		    name: '고도비만',
		    data: ${list7}
		  }]
		});	
});
</script>
</head>
<body>
	<div class="container" style="margin-left: 200px">
		<table>
			<tr>

				<td>
					<div class="container" style="width: 600px">
						<%-- 팀별 bmi분포 그래프 출력 --%>
						<figure class="highcharts-figure">
							<div id="container"></div>
							<p class="highcharts-description"></p>
						</figure>
						<h2 align="center">[BMI와 야구성적 상관관계 표]</h2>
						<img alt="BMI와 야구성적 지수 상관관계 표"
							src="${pageContext.request.contextPath}/resources/img/${img}"
							width="600">

					</div>
				</td>
				<td>
					<%-- bmi 표 목록 출력 --%>
					<div class="container"
							style="position: left; overflow-y: scroll; width: 650px; height: 1800px;">
						<table border="1" width="600px" class="center">
							<tr>
								<td colspan="3"><h2>야구선수의 BMI지수와 성적 상관관계 분석</h2></td>
							</tr>
							<tr>
								<td colspan="3" align="center">BMI지수= 몸무게(kg) ÷ (신장(m) ×
									신장(m))<br /> 18.5 미만 - 저체중 (해당 선수 없음*)<br /> 18.5 이상 25 미만 -
									정상 <br /> 25 이상 30 미만- 비만 <br /> 30 이상 - 고도 비만 <br />
									출처:대한비만학회
								</td>
							</tr>
							<tr>
								<th colspan="3">선수 이름 / BMI지수</th>
							</tr>
							<tr>
								<th width="200">정상</th>
								<th width="200">비만</th>
								<th width="200">고도비만</th>
							</tr>
						</table>
						<table border="1" width="600px" class="center">
								<%-- 선수 bmi List  --%>
								<c:forEach items="${LIST}" var="dto">
									<tr>
										<td width="200">
											<ul>
												<c:if test="${dto.bmi lt 25}">
													<li>${dto.name}/${dto.bmi}</li>
												</c:if>
											</ul>
										</td>
										<td width="200">
											<ul>
												<c:if test="${(dto.bmi lt 30)&&(dto.bmi ge 25)}">
													<li>${dto.name}/${dto.bmi}</li>
												</c:if>
											</ul>
										</td>
										<td width="200">
											<ul>
												<c:if test="${dto.bmi ge 30}">
													<li>${dto.name}/${dto.bmi}</li>
												</c:if>
											</ul>
										</td>
									</tr>
								</c:forEach>
							</table>
						</div>
				</td>
			</tr>
			<tr>
				<td colspan="2"><h2 align="center">결론:BMI와 야구성적은 상관관계가 없다</h2></td>
			</tr>
		</table>
	</div>
</body>
</html>