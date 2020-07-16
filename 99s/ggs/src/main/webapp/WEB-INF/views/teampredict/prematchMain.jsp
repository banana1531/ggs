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
	<h1>승부 예측 페이지 메인이 됩니다</h1>
	
	<!-- 이동버튼 -->
	<div class="container">
		<button><a href="/teampredict/prematchMain.gg">경기예측</a></button>
		<button><a href="/teampredict/schmatchList.gg">경기일정</a></button>
		<button><a href="/teampredict/rltmatchList.gg">경기결과</a></button>
	</div>
	 </hr>
	<!-- 회원 보유 포인트 순위 -->
	<p>회원 보유 포인트 랭킹</p>
	</hr>
	<div class="container">
			<table class="table">
		<td>순위</td>
		<td>아이디</td>
		<td>보유 포인트</td>
		</tr>
		<c:forEach items="${RankingList}" var="list">
				<tr>
					<td>
						??
					</td>
					<td>${list.id}</td>
					<td>${list.ppoint}</td>
				</tr>
		</c:forEach>
	</table>
	</div>
</hr>
	<!-- 금일 경기 리스트 -->
	</hr>
		<p>금일 경기 리스트</p>
		<form action="post" action="/teampredict/prematchDetail.gg">
	<c:forEach items="${TodayMatch}" var="list3">
		<tr>
		<td><a href="/teampredict/prematchDetail.gg?gno=${list3.gno}">${list3.ateamname}</td>
		<td>vs</td>
		<td><a href="/teampredict/prematchDetail.gg?gno=${list3.gno}">${list3.bteamname}</td>
		
		</tr>
	</c:forEach>
	</form>
	</table>
	</div>
</body>
</html>