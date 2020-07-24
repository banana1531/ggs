<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container" style="margin-bottom: 30px">
	   <button><a href="/mypage/mypageMain.gg">My Page</a></button>
	   <button><a href="/mypage/myTeamDetail.gg">My Team</a></button>
	   <button><a href="/mypage/checkPw.gg">내 정보 수정</a></button>
   </div>
	<!-- 내가 쓴글 -->
	<div class="container">
		<p>내가 쓴글 목록</p>
		<table class="table">
			<tr>
				<td>게시판</td>
				<td>글번호</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			<c:forEach items="${mylist}" var="list">
				<tr>
					<td><c:choose>
						<c:when test="${list.boardname=='freeboard'}">자유게시판</c:when>
						<c:when test="${list.boardname=='inforerrorboard'}">정보오류신고 게시판</c:when>
					</c:choose> </td>
					<td>${list.wno }</td>
					<td>${list.title }</td>
					<td><fmt:formatDate value="${list.writedate }"/> </td>
				</tr>
			</c:forEach>

		</table>
	</div>


	<!-- 내가 참여한 승부 예측 -->
	<div class="container">
		<p>내가 참여한 승부예측 목록</p>
		<table class="table">
			<tr>
				<td>일자</td>
				<td>경기</td>
				<td>결과</td>
				<td>내가 예측한 결과</td>
				<td>포인트 증감</td>
			</tr>
			<c:if test="${result != null }">
			<tr><td>${result }</td></tr></c:if>
			<c:forEach items="${myprelist}" var="plist">
				<tr>
					<td>${plist.gdate }</td>
					<td>${plist.ateamname}vs ${plist.bteamname}</td>
					<td>${plist.ascore }: ${plist.bscore }</td>
					<td>${plist.predict }</td>
					<td>${plist.ppoint }</td>
				</tr>
			</c:forEach>
			<tfoot>
			<tr><td colspan="5"><p align="right">참여 경기 수 : ${totalcnt }, 총 포인트 : ${totalpp }</p></td></tr>
			
			</tfoot>
		</table>
		
	</div>

	<!-- myteam 다음 경기 일정 -->
	<div class="container">
		<p>My Team 예정 경기</p>
		<div class="btn-group btn-group-justified">
			<c:forEach items="${teamSchedule}" var="schedule">
				<a href="#" class="btn btn-primary"><fmt:formatDate
						value="${schedule.gdate}" pattern="yyyy-MM-dd" /> <br />${schedule.gtime}
					<br />${schedule.ateamname} vs ${schedule.bteamname} <br />
						${schedule.ascore} vs ${schedule.bscore} <br />	
					
					${schedule.stadium}</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>