<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>	

<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".btn").click(function(){
		var pageNo = $(this).text();
		var month = $("#month").val();
		location = "/teampredict/rltmatchList.gg?pageNo="+pageNo+"&month="+month
	})
	
})
</script>
</head>
<body>
	<div class="container">
		<button><a href="/teampredict/prematchMain.gg">승부예측</a>	</button>
		<button><a href="/teampredict/schmatchList.gg">경기일정</a>	</button>
		<button><a href="/teampredict/rltmatchList.gg">경기결과</a>	</button>
	</div>
	<div class="container" align="right">

	<form action="/teampredict/rltmatchList.gg">
		월별 조회<select name="month">
				<option value="0">월</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
		</select>
	<input type="submit" value="조회" />
	</form>
	</div>
	<div class="container">
		<table class="table">
			<tr>
				<td>경기날짜</td>
				<td>경기시간</td>
				<td>경기일정</td>
				<td>구장</td>
			</tr>
			<c:if test="${error!=null}">
			<tr><td>${error }</td></tr></c:if>
			<c:forEach items="${SchMatchList}" var="list">
				<tr>
					<td><fmt:formatDate value="${list.gdate}" pattern="yyyy-MM-dd" /></td>
					<td>${list.gtime}</td>
					<td>${list.ateamname}${list.ascore} vs ${list.bscore}
						${list.bteamname}</td>
					<td>${list.stadium}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4"><c:if test="${pageInfo.startPage>1}">&lt;prev</c:if>
					<c:forEach var="i" begin="${pageInfo.startPage}"
						end="${pageInfo.endPage}">
					[<a class="btn">${i}</a>]
				</c:forEach> <c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
				</td>
			</tr>
		</table>
		<input type="hidden" id="month" value="${month}">
	</div>

</body>
</html>