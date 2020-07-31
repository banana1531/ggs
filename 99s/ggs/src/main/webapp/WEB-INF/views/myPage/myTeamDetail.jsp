<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
$(function(){
	var name=$("#name").text()
	//경기 결과 목록 불러오기(default)
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+1)
	//경기 결과  목록 불러오기(선택)
	$("#result").click(function(){
		$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+1)
	})
	//경기 일정 목록 불러오기(선택)
	$("#schedule").click(function(){
		$("#list").load("/teampredict/schmatchList?name="+name+"&pageNo="+1)
	})
	//경기 일정 페이징 처리
	$(".btn1").click(function(){
		var pageNo = $(this).text()
		$("#list").load("/teampredict/schmatchList?name="+name+"&pageNo="+pageNo)
	})
})
</script>
</head>
<body> 
  <div class="container" style="margin-bottom: 30px">
	   <a href="/mypage/mypageMain.gg"><button>My Page</button></a>
	   <a href="/mypage/myTeamDetail.gg"><button>My Team</button></a>
	   <a href="/mypage/checkPw.gg"><button>내 정보 수정</button></a>
   </div>
	<div class="container">
	<h4>내팀 정보</h4><hr/>
	<c:choose>
		<c:when test="${team.teamName=='없음'}">선호팀을 선택하지 않았습니다.</c:when>
		<c:otherwise><span><img width="100" height="50" src="/resources/img/${team.teamName}.jpg"></span></c:otherwise>
	</c:choose> 
		<table class="table">
			<tr>
				<th>팀명</th>
				<th>설립일</th>
				<th>지역</th>
				<th>경기장</th>
				<th>감독</th>
				<th>홈페이지</th>
			</tr>
			<tr>
				<td id="name">${team.teamName }</td>
				<td>${team.birth }</td>
				<td>${team.location }</td>
				<td>${team.stadium }</td>
				<td>${team.director }</td>
				<td><a href="http://${team.homepage }" target="_blank">${team.homepage }</a></td>
			</tr>
			<tr>
				<td colspan="6"><b>이번 시즌 성적</b></td>
			</tr>
			<tr>
				<th>승수</th>
				<th>득점</th>
				<th>무승부</th>
				<th>패수</th>
				<th>실점</th>
				<th>경기 횟수</th>
			</tr>
			<tr>
				<td>${team.win }</td>
				<td>${team.score }</td>
				<td>${team.draw }</td>
				<td>${team.lose }</td>
				<td>${team.loss }</td>
				<td>${team.win+team.draw+team.lose}</td>
			</tr>
		</table>
		<button id="result">경기 결과</button><button id="schedule">경기 일정</button>
		<table class="table" id="list">
		</table>

	</div>
</body>
</html>