<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	var name=$("#name").text()
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+1)
	$(".btn").click(function(){
		var pageNo = $(this).text()
		$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo)
	})
	
	$("#homepage").click(function(){
		var hompage = "https://"+'${team.homepage }'
		window.open(hompage)
	})
})
</script>
</head>
<body>
	<div class="container" style="margin-top: 20px">
	<h4>팀 상세 정보</h4>
		<table class="table">
			<tr class="active">
				<th class="text-center">팀명</th>
				<th class="text-center">설립일</th>
				<th class="text-center">지역</th>
				<th class="text-center">경기장</th>
				<th class="text-center">감독</th>
				<th class="text-center">홈페이지</th>
			</tr>
			<tr>
				<td class="text-center" id="name">${team.teamName }</td>
				<td class="text-center">${team.birth }</td>
				<td class="text-center">${team.location }</td>
				<td class="text-center">${team.stadium }</td>
				<td class="text-center">${team.director }</td>
				<td class="text-center"><a id="homepage">${team.homepage }</a></td>
			</tr>
			<tr class="active">
				<th class="text-center">승수</th>
				<th class="text-center">득점</th>
				<th class="text-center">무승부</th>
				<th class="text-center">패수</th>
				<th class="text-center">실점</th>
				<th class="text-center">경기 횟수</th>
			</tr>
			<tr>
				<td class="text-center">${team.win }</td>
				<td class="text-center">${team.score }</td>
				<td class="text-center">${team.draw }</td>
				<td class="text-center">${team.lose }</td>
				<td class="text-center">${team.loss }</td>
				<td class="text-center">${team.win+team.draw+team.lose}</td>
			</tr>
			<tr class="active">
				<th class="text-center">승률</th>
				<th class="text-center">최다득점</th>
				<th class="text-center">최다실점</th>
				<th class="text-center">평균득점</th>
				<th class="text-center">평균실점</th>
				<th class="text-center">무득점/무실점 경기수</th>
			</tr>
			<tr>
				<td class="text-center">${team.rate }</td>
				<td class="text-center">${team.maxScore }</td>
				<td class="text-center">${team.maxLoss }</td>
				<td class="text-center">${team.avgScore }</td>
				<td class="text-center">${team.avgLoss }</td>
				<td class="text-center">${team.zeroScore}/${team.zeroLoss}</td>
			</tr>
			
		</table>
		<table class="table" id="list">
		</table>

	</div>
</body>
</html>