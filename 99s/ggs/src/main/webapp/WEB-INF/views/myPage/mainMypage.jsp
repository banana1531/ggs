<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".dto").click(function(){
		var boardname=$(this).find("#boardname").val();
		var writeno=$(this).find("#writeno").val();
		var views=$(this).find("#views").val();
		if(boardname=='freeboard'){
			location="/freeboard/detail?writeno="+writeno+"&views="+views
		}else{
			location="/inforerrorboard/detail?writeno="+writeno+"&views="+views
		}
	})
	var point = '${point}';
	if(point!=''){
		alert(point)
	}	
})
</script>
</head>
<body>

    <div class="container" style="margin-bottom: 30px">
	   <a href="/mypage/mypageMain.gg"><button>My Page</button></a>
	   <a href="/mypage/myTeamDetail.gg"><button>My Team</button></a>
	   <a href="/mypage/checkPw.gg"><button>내 정보 수정</button></a>
    </div>
   
	<!-- 내가 쓴글 -->
	<div class="container">
		<p>내가 쓴글 목록</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>게시판</td>
					<td>글번호</td>
					<td>제목</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			
			<c:forEach items="${mylist}" var="list">
				<tr class="dto">
					<td><c:choose>
						<c:when test="${list.boardname=='freeboard'}">자유게시판</c:when>
						<c:when test="${list.boardname=='inforerrorboard'}">정보오류신고 게시판</c:when>
					</c:choose> </td>
					<td>${list.wno }</td>
					<td>${list.title }</td>
					<td><fmt:formatDate value="${list.writedate }"/>
						<input id="boardname" value="${list.boardname}" type="hidden">
						<input id="writeno" value="${list.wno}" type="hidden"></td>
					 <td><input id="views" value="${list.views}" type="hidden">${list.views }</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>

	<!-- 내가 참여한 승부 예측 -->
	<div class="container">
		<p style="float: left;">내가 참여한 승부예측 목록</p>
		<p style="float: right;"><a href="/mypage/myPreList.gg?id=${UID}"><button>전체 목록 보기</button></a></p>
		
		<table class="table">
			<tr>
				<td>일자</td>
				<td>경기</td>
				<td>결과</td>
				<td>내가 예측한 결과</td>
				<td>지급 포인트</td>
			</tr>
			
			<c:if test="${result != null }"><tr><td>${result }</td></tr></c:if>
			
			<c:forEach items="${myprelist}" var="plist">
				<tr>
					<td>${plist.gdate}</td>
					<td>${plist.ateamname} vs ${plist.bteamname}</td>
					<c:choose>
						<c:when test="${plist.ascore<0}">
							<td>경기 취소</td>
						</c:when>
						<c:otherwise>
							<td>${plist.ascore }: ${plist.bscore }</td>
						</c:otherwise>
					</c:choose>
					<td>${plist.predict }</td>
					<td>${plist.ppoint }</td>
				</tr>
			</c:forEach>
			
			<tfoot>
			<tr><td colspan="5"><p align="right"> 
				<c:choose>
					<c:when test="${totalcnt!=null }">참여 경기 수 : ${totalcnt }, 총 보유 포인트 : ${UPOINT }, 적중률 : ${rate }%</c:when>
					<c:otherwise>참여 경기 수 : 0, 총 보유 포인트 : ${UPOINT }, 적중률 : - </c:otherwise>			
				</c:choose>
			</p></td></tr>
			</tfoot>
			
		</table>
	</div>
	
	<!-- myteam 다음 경기 일정 -->
	<div class="container">
		<p>My Team 예정 경기</p>
		<div class="btn-group btn-group-justified">
		<%int r=0; %>
			<c:forEach items="${teamSchedule}" var="schedule">
			<% r+=1; %>
				<a href="/teampredict/rltmatchDetail.gg?gno=${schedule.gno}" class="btn btn-primary"><fmt:formatDate
						value="${schedule.gdate}" pattern="yyyy-MM-dd" /> <br />${schedule.gtime}
					<br />${schedule.ateamname} vs ${schedule.bteamname} <br />
					${schedule.stadium}<br />
					<%if(r<4){ %>
					<b>${schedule.ascore} vs ${schedule.bscore}</b> 
					<%} %>
					</a>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>