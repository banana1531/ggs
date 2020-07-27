<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>역대 관중 현황</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<!-- jQuery CDN -->
<script>
$(function(){
	
});
</script>
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
</head>
<body>
	<a href="../admin/adminMain.gg">메인으로</a>
	<h3>crowdHistory</h3>
<div class="container" >
<table>
	<tr>
		<td>
			<%-- 역대관중현황 표  --%>
			<div class="container"
					style="position: left;  width: 650px; height: 1800px;">
				<table border="1" width="1000px" >
					<tr>
						<td colspan=2>*괄호안은 평균 </td>
					</tr>
					<tr>
					<!-- 삼성	KIA	롯데	LG	두산	한화	SK	키움	NC	KT	계  (현대와 쌍방울은 키움-sk쪽으로입력) -->
						<th width="200">연도</th>
						<th width="200">삼성</th>
						<th width="200">KIA</th>
						<th width="200">롯데</th>
						<th width="200">LG</th>
						<th width="200">두산</th>
						<th width="200">한화</th>
						<th width="200">SK</th>
						<th width="200">키움</th>
						<th width="200">NC</th>
						<th width="200">KT</th>
						<th width="200">계</th>
					</tr>
				
 				<tr>
				<c:forEach items="${historyList}" var="dto">
					<td width="200">${dto.years }</td>
				</c:forEach>
				<c:forEach items="${historyList}" var="dto">
					<td width="200">${dto.cno}</td>
				</c:forEach>
				
				<tr>
				</table>
			</div>
		</td>
	</tr>
</table>
</div>
</body>
</html>






