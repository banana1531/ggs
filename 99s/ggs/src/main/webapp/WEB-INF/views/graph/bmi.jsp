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
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</head>
<body>
	<div class="container" align="center">
		<table>
			<tr>

				<td>
					<div class="container" style="width: 600px">
						<%-- 팀별 bmi분포 그래프 출력 --%>
						<figure class="highcharts-figure">
							<div id="container"></div>
							<p class="highcharts-description"></p>
						</figure>

					</div>
				</td>
				<td>
					<%-- bmi 표 목록 출력 --%>
					<div class="container" style="width: 650px;">
						<table border="1" width="600px" class="center">
							<tr align="center">
								<td colspan="3"><h2>야구선수의 BMI지수와 성적 상관관계 분석</h2></td>
							</tr>
							<tr>
								<td colspan="3" align="left">BMI지수= 몸무게(kg) ÷ (신장(m) ×	신장(m))<br />
								 - 18.5 미만 - <b style="color: #0099FF">저체중</b> <br />
								  - 18.5 이상 25미만 - <b style="color: #0000FF">정상</b> <br />
								  - 25 이상 30 미만- <b style="color: #FF9900">비만</b> <br />
								   - 30 이상 - <b style="color: #ff0000">고도비만</b> <br />
									*출처:대한비만학회
								</td>
							</tr>
						</table>
					</div>
					<hr />
					<div class="container"
						style="position: left; overflow-y: scroll; width: 650px; height: 300px;">
						<input class="form-control" id="myInput" type="text"
							placeholder="검색하세요.">
						<table class="table table-bordered table-striped" width="600px">
							<thead>
								<tr>
									<th>선수 이름</th>
									<th>소속팀</th>
									<th>체중</th>
									<th>키</th>
									<th>BMI 지수</th>
									<th>결과</th>
								</tr>
							</thead>
							<tbody id="myTable">
								<%-- 선수 bmi List  --%>
								<c:forEach items="${LIST}" var="dto">
									<tr>
										<td>${dto.name }</td>
										<td>${dto.teamname}</td>
										<td>${dto.weight}</td>
										<td>${dto.height}</td>
										<td>${dto.bmi }</td>
										<td><c:choose>
												<c:when test="${dto.bmi<18.5 }"><b style="color: #0099FF">저체중</b></c:when>
												<c:when test="${dto.bmi<25 }"><b style="color: #0000FF">정상</b></c:when>
												<c:when test="${dto.bmi<30 }"><b style="color: #FF9900">비만</b></c:when>
												<c:otherwise><b style="color: #ff0000">고도비만</b></c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</td>
			</tr>
		</table>
		<hr/>
		<table>
			<tr>
				<td colspan="3"><h2 align="center">[BMI와 야구성적 상관관계 표]</h2></td>
			</tr>
			<tr>

				<td width="400"><img alt="BMI와 야구성적 지수 상관관계 표"
					src="${pageContext.request.contextPath}/resources/img/cor1.jpg"
					width="400"></td>
				<td width="400"><img alt="BMI와 야구성적 지수 상관관계 표"
					src="${pageContext.request.contextPath}/resources/img/cor3.jpg"
					width="400"></td>
				<td width="400"><img alt="BMI와 야구성적 지수 상관관계 표"
					src="${pageContext.request.contextPath}/resources/img/cor4.jpg"
					width="400"></td>
			</tr>
			<tr>
				<td colspan="3">
				<div class="container" align="center">
				<h4><b>상관분석 판정 기준</b></h4>
				<table border="1" style="width: 800px">
				<tr align="center">
					<td>-1.0 ~ -0.7</td>
					<td>-0.7 ~ -0.3</td>
					<td>-0.3 ~ -0.1</td>
					<td><b style="color: red">-0.1 ~ +0.1</b></td>
					<td>+0.1 ~ +0.3</td>
					<td>+0.3 ~ +0.7</td>
					<td>+0.7 ~ +0.1</td>
				</tr>
				<tr align="center">
					<td>강한 음적 관계</td>
					<td>뚜렷한 음적 관계</td>
					<td>약한 음적 관계</td>
					<td><b style="color: red">거의 관계 없음</b></td>
					<td>약한 양적 관계</td>
					<td>뚜렷한 양적 관계</td>
					<td>강한 양적 관계</td>
				</tr>
				</table>
				</div>
				<h2 align="center">결론:BMI와 야구성적은 <b style="color: red">상관관계가 없다고 할 수 있다.</b></h2></td>
			</tr>
		</table>
		
	</div>
</body>
</html>