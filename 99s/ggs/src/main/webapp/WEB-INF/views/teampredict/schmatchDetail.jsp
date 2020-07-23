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
<h1>경기일정페이지 상세입니다</h1>
	<div class="container">
		<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
		<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
		<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
	</div>
<p>경기일정</p>
<table border="1" 	class="table" width="800">
<tr>
	<td>경기날짜</td>
	<td>경기시간</td>
	<td>경기</td>
	<td>구장</td>
	<td>비고</td>
</tr>

		<c:forEach items="${SchMatchDetail}" var="list">
					<tr>
							<td colspan=2>${list.gdate}</td>
							<td colspan=1>${list.gtime}</td>
							<td colspan=2>${list.ateamname} ${list.bteamname}</td>
					</tr>
</c:forEach>
</table>							
<table border="1" 	class="table" width="800">
</tr>
            <tr>
							<td>${atrDTO.win}</td>
							<td>승</td>
							<td>${btrDTO.win}</td>
							</tr>
							<tr>
							<td>${atrDTO.lose}</td>
							<td>패</td>
							<td>${btrDTO.lose}</td>
							</tr>
							<tr>
							<td>${atrDTO.draw}</td>
							<td>무</td>
							<td>${btrDTO.draw}</td>
							</tr>
         			<tr>
							<td>${atrDTO.score}</td>
							<td>득점</td>
							<td>${btrDTO.score}</td>
							</tr>
							<tr>
							<td>${atrDTO.loss}</td>
							<td>실점</td>
							<td>${btrDTO.loss}</td>
							</tr>
</table>
</table>

</body>
</html>