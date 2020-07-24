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
		<h3>경기 일정</h3>
		<hr>
			<div class="container">
				<button><a href="/teampredict/prematchMain.gg">승부예측</a></button>
				<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
				<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
			</div>
			<hr>
		<h3>경기일정</h3>
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
							<td colspan>${list.gdate}</td>
							<td colspan>${list.gtime}</td>
							<td colspan>${list.ateamname} ${list.bteamname}</td>
							<td>${list.stadium}</td>
							<td>-</td>
					</tr>
				</table>
				<h3>${list.ateamname} 시즌성적 vs ${list.bteamname} 시즌성적</h3>
				</c:forEach>							
				<table border="1" 	class="table" width="800">
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
</body>
</html>