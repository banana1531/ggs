<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이동버튼 -->
	<div class="container">
		<a href="/teampredict/prematchMain.gg"><button>승부예측</button></a>
		<a href="/teampredict/schmatchList.gg"><button>경기일정</button></a>
		<a href="/teampredict/rltmatchList.gg"><button>경기결과</button></a>
	</div>
	
	<hr/>
	<!-- 회원 보유 포인트 순위 -->
	<div class="container" align="center">
	<h5>회원 보유 포인트 랭킹</h5>
	<table border="1" class="table" style="width: 500px">
		<thead>
		<tr align="center">
			<td>순위</td>
			<td>아이디</td>
			<td>보유 포인트</td>
		</tr>
		</thead>
		<%int a=0; %>
		<tbody>
		<c:forEach items="${RankingList}" var="list">
					<tr align="center">
					<td><%=a+=1 %></td>
					<td>${list.id}</td>
					<td>${list.ppoint}</td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<!-- 금일 경기 리스트 -->
	<hr/>
	
	<div class="container" style="width: 800px">
	<h4>금일 경기 리스트</h4>
	<div class="btn-group btn-group-justified">
			<c:forEach items="${TodayMatch}" var="list3">
			<c:choose>
				<c:when test="${list3.gtime=='프로야구 경기가 없습니다.'}"><a href="#" class="btn btn-primary">
					<fmt:formatDate	value="${list3.gdate}" pattern="yyyy-MM-dd" /> <br />
					${list3.gtime}<br />
					${list3.ateamname} vs ${list3.bteamname} <br />					
					${list3.stadium}<br/> </a>
				</c:when>
				<c:otherwise>
					<a href="/teampredict/prematchDetail.gg?gno=${list3.gno}" class="btn btn-primary">
					<fmt:formatDate	value="${list3.gdate}" pattern="yyyy-MM-dd" /> <br />
					${list3.gtime}<br />
					${list3.ateamname} vs ${list3.bteamname} <br />					
					${list3.stadium}<br/> </a>
				</c:otherwise>
			</c:choose>
			</c:forEach>
		</div>
	</div>
</body>
</html>