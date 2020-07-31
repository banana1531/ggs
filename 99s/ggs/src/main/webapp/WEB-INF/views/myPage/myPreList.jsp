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
	$(".page").click(function(){
		var pageNo = $(this).text();
		var id = $("#id").val();
		location = "/mypage/myPreList.gg?id="+id+"&pageNo="+pageNo	
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
		<table class="table table-bordered" style="width: 800px">
			<thead>
				<tr>
					<td>아이디:</td>
					<td>${UID }</td>
					<td>승부예측 참여횟수:</td>
					<td>${totalcnt }</td>
					<td>적중률:</td>
					<td>${rate}%</td>
					<td>현재 포인트:</td>
					<td>${UPOINT}p</td>
					<td>등급:</td>
					<td>
					<c:choose>
						<c:when test="${UPOINT<=200}">1</c:when>
						<c:when test="${200<UPOINT||UPOINT<=500 }">2</c:when>
						<c:when test="${500<UPOINT||UPOINT<=950 }">3</c:when>
						<c:when test="${950<UPOINT||UPOINT<=1630 }">4</c:when>
						<c:when test="${1630<UPOINT||UPOINT<=2650 }">5</c:when>
						<c:when test="${2650<UPOINT||UPOINT<=4200 }">6</c:when>
						<c:otherwise>7</c:otherwise>
					</c:choose>
					
					
					
					</td>
				</tr>
			</thead>
		</table>
		
		<table class="table">
		<thead>
			<tr>
				<th>일자</th>
				<th>A team</th>
				<th>score</th>
				<th>B team</th>
				<th>score</th>
				<th>결과</th>
				<th>내 선택</th>
				<th>지급 포인트</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${result}${dto.gdate}</td>
				<td>${dto.ateamname }</td>
				<c:choose>
					<c:when test="${dto.ascore<0 }">
						<td colspan="2" style="padding-left: 50px">경기 취소</td>
					</c:when>
					<c:otherwise>
						<td>${dto.ascore }</td>
						<td>${dto.bscore }</td>	
					</c:otherwise>			
				</c:choose>
				<td>${dto.bteamname }</td>
				<td>
					<c:choose>
						<c:when test="${dto.ascore>dto.bscore}">${dto.ateamname } 승</c:when>
						<c:when test="${dto.bscore>dto.ascore}">${dto.bteamname } 승</c:when>
						<c:otherwise>무승부</c:otherwise>
					</c:choose>
				</td>
				<td>${dto.predict }</td>
				<td>${dto.ppoint }
					<input type="hidden" id="id" value="${UID }">
				</td>
			</tr>
			</c:forEach>
				<tr align="center">
				<td colspan="8"><c:if test="${pageInfo.startPage>1}">&lt;prev</c:if>
				<c:forEach var="i" begin="${pageInfo.startPage}"
					end="${pageInfo.endPage}">
					<c:choose>
						<c:when test="${pageInfo.nowPage==i}">
							<b>[<a class="page">${i}</a>]
							</b>
						</c:when>
						<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
					</c:choose>
				</c:forEach> <c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if></td>
			</tr>		
		</table>
	</div>
</body>
</html>