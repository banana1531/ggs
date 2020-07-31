<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<div class="container">
	
		<h4>연도별 팀 관중 </h4><p style="float: right;">*괄호안은 평균(단위 : 명)</p>
			<%-- 역대관중현황 표  --%>
				<table border="1" class="table" width="1000px" >
					<thead>
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
					<td><fmt:formatNumber value="${dto.samsungt}"/><br>(<fmt:formatNumber value="${dto.samsunga}" />)</td>
					<td><fmt:formatNumber value="${dto.kiat}"/> <br>(<fmt:formatNumber value="${dto.kiaa}"/>)</td>
					<td><fmt:formatNumber value="${dto.lottet}"/><br>(<fmt:formatNumber value="${dto.lottea}"/>)</td>
					<td><fmt:formatNumber value="${dto.lgt}"/><br>(<fmt:formatNumber value="${dto.lga}"/>)</td>
					<td><fmt:formatNumber value="${dto.doosant}"/><br>(<fmt:formatNumber value="${dto.doosana}"/>)</td>
					<td><fmt:formatNumber value="${dto.hanwhat}"/><br>(<fmt:formatNumber value="${dto.hanwhaa}"/>)</td>
					<td><fmt:formatNumber value="${dto.skt}"/><br>(<fmt:formatNumber value="${dto.ska}"/>)</td>
					<td><fmt:formatNumber value="${dto.kiwoomt}"/><br>(<fmt:formatNumber value="${dto.kiwooma}"/>)</td>
					<td><fmt:formatNumber value="${dto.nct}"/><br>(<fmt:formatNumber value="${dto.nca}"/>)</td>
					<td><fmt:formatNumber value="${dto.ktt}"/><br>(<fmt:formatNumber value="${dto.kta}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalt}"/><br>(<fmt:formatNumber value="${dto.totala}"/>)</td>
				</tr>
				</c:forEach>
				</tbody>
				<tfoot>
				<c:forEach items="${HISTORYLISTFOOT}" var="dto">
				<tr>
					<td>계</td>
					<td><fmt:formatNumber value="${dto.totalsamsungt}"/> <br>(<fmt:formatNumber value="${dto.avgsamsunga}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalkiat}"/><br>(<fmt:formatNumber value="${dto.avgkiaa}"/>)</td>
					<td><fmt:formatNumber value="${dto.totallottet}"/><br>(<fmt:formatNumber value="${dto.avglottea}"/>)</td>
					<td><fmt:formatNumber value="${dto.totallgt}"/><br>(<fmt:formatNumber value="${dto.avglga}"/>)</td>
					<td><fmt:formatNumber value="${dto.totaldoosant}"/><br>(<fmt:formatNumber value="${dto.avgdoosana}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalhanwhat}"/><br>(<fmt:formatNumber value="${dto.avghanwhaa}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalskt}"/><br>(<fmt:formatNumber value="${dto.avgska}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalkiwoomt}"/><br>(<fmt:formatNumber value="${dto.avgkiwooma}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalnct}"/><br>(<fmt:formatNumber value="${dto.avgnca}"/>)</td>
					<td><fmt:formatNumber value="${dto.totalktt}"/><br>(<fmt:formatNumber value="${dto.avgkta}"/>)</td>
					<td><fmt:formatNumber value="${dto.totaltotalt}"/><br>(<fmt:formatNumber value="${dto.avgtotala}"/>)</td>
				</tr>
				</c:forEach>
				</tfoot>
				</table>
			
	</div>
</body>
</html>


