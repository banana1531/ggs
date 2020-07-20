<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>경기결과페이지 메인입니다</h1>
	
		<div class="container">
		<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
		<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
		<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
	</div>
	
	<p>
	<h3>경기결과</h3>
	
	<select name="month">
	<form action="get" action="../teampredict/rltmatchList.gg">
	<option value="">월</option>
	<option value="4">4</option>
	<option value="5">5</option>
	<option value="6">6</option>
	<option value="7">7</option>
	<option value="8">8</option>
	<option value="9">9</option>
	<option value="10">10</option>
	</select>
	<input type="submit" value="조회"/>
	</form>
	</p>
	<div class="container">
			<table class="table">
		<td>경기 날짜</td>
		<td>경기 시간</td>
		<td>경기 결과</td>
		<td>구장</td>
		</tr>
	<c:forEach items="${matchlist}" var="list">
		<tr>
		<td>${list.gdate}</td>
		<td>${list.gtime}</td>
		<td><a href="/teampredict/rltmatchDetail.gg">${list.ateamname} ${list.ascore} vs ${list.bscore} ${list.bteamname}</a></td>
		<td>${list.stadium}</td>
		</tr>
	</c:forEach>
	</table>
	</div>

</body>
</html>