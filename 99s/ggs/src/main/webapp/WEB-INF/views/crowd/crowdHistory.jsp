<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>역대 관중 현황</title>

<!-- jQuery CDN -->
</head>
<style>

</style>
<body>
	<a href="../admin/adminMain.gg">메인으로</a>
	<h3>crowdHistory</h3>
	
	<h3>연도별 관중 현황</h3>



		<h3>연도별 팀 관중 </h3>
	<h4>※숫자 세자리마다 쉼표를 찍어야 함</h4>
			<%-- 역대관중현황 표  --%>
			<!--  <div class="container" style="position: left;  width: 650px; height: 1800px;"> -->
				<table border="1" class="table" width="1000px" >
					<thead>
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
				</thead>
			<!-- 	mv.addObject("HISTORYLIST",historyList);
		mv.addObject("HISTORYLISTFOOT",historyListFoot); -->
				
				<tbody>
				<c:forEach items="${HISTORYLIST}" var="dto">
				<tr>
					<td>${dto.years}</td>
					<td>${dto.samsungt}<br>(${dto.samsunga})</td>
					<td>${dto.kiat}<br>(${dto.kiaa})</td>
					<td>${dto.lottet}<br>(${dto.lottea})</td>
					<td>${dto.lgt}<br>(${dto.lga})</td>
					<td>${dto.doosant}<br>(${dto.doosana})</td>
					<td>${dto.hanwhat}<br>(${dto.hanwhaa})</td>
					<td>${dto.skt}<br>(${dto.ska})</td>
					<td>${dto.kiwoomt}<br>(${dto.kiwooma})</td>
					<td>${dto.nct}<br>(${dto.nca})</td>
					<td>${dto.ktt}<br>(${dto.kta})</td>
					<td>${dto.totalt}<br>(${dto.totala})</td>
				</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				<c:forEach items="${HISTORYLISTFOOT}" var="dto">
				<tr>
					<td>계</td>
					<td>${dto.totalsamsungt}<br>(${dto.avgsamsunga})</td>
					<td>${dto.totalkiat}<br>(${dto.avgkiaa})</td>
					<td>${dto.totallottet}<br>(${dto.avglottea})</td>
					<td>${dto.totallgt}<br>(${dto.avglga})</td>
					<td>${dto.totaldoosant}<br>(${dto.avgdoosana})</td>
					<td>${dto.totalhanwhat}<br>(${dto.avghanwhaa})</td>
					<td>${dto.totalskt}<br>(${dto.avgska})</td>
					<td>${dto.totalkiwoomt}<br>(${dto.avgkiwooma})</td>
					<td>${dto.totalnct}<br>(${dto.avgnca})</td>
					<td>${dto.totalktt}<br>(${dto.avgkta})</td>
					<td>${dto.totaltotalt}<br>(${dto.avgtotala})</td>
				</tr>
				</c:forEach>
				</tfoot>
				</table>
			<!--  </div> -->
	
</body>
</html>


<%-- 				<c:forEach items="${historyList}" var="dto">
					<td width="200">${dto.cno}</td>
				</c:forEach> --%>
				
				



