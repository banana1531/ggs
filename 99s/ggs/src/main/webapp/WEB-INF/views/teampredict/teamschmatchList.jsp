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
	$(".page").click(function(){
		var pageNo = $(this).text();
		var month = $("#month").val();
		location = "/teampredict/schmatchList.gg?pageNo="+pageNo+"&month="+month
	})
	
	$(".dto").click(function(){
		var ateamname = $(this).find("#ateamname").val();
		var bteamname = $(this).find("#bteamname").val();
		var gno = $(this).find("#gno").val();
		location = "/teampredict/rltmatchDetail.gg?ateamname="+ateamname+
				"&bteamname="+bteamname+
				"&gno="+gno
	})
	
	$("#next").click(function(){
		var pageNo = $("#nextv").val();
		var month   = $("#names").text();
		location = "/teampredict/schmatchList.gg?pageNo="+pageNo+"&month="+month
	})
	$("#prev").click(function(){
		var pageNo = $("#prevv").val();
		var month   = $("#names").text();
		location = "/teampredict/schmatchList.gg?pageNo="+pageNo+"&month="+month
	})
		
	
	
})
</script>
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<a href="/teampredict/prematchMain.gg"><button>승부예측</button></a>	
		<a href="/teampredict/schmatchList.gg"><button>경기일정</button></a>	
		<a href="/teampredict/rltmatchList.gg"><button>경기결과	</button></a>
	</div>

	<div class="container" align="right">
		<form action="/teampredict/schmatchList.gg">
			월별 조회<select name="month">
				<option value="0">월</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select> <input type="submit" value="조회" />
		</form>
	</div>

	<div class="container">
		<table class="table table-hover">
		<thead>
			<tr align="center">
				<td>경기날짜</td>
				<td>경기시간</td>
				<td colspan="5" width="60%">경기일정</td>
				<td>구장</td>
			</tr>
			</thead>
			<c:if test="${error!=null}">
			<tr><td>${error }</td></tr></c:if>
			<c:forEach items="${SchMatchList}" var="list">
				<tr class="dto" align="center">
					<td width="15%"><fmt:formatDate value="${list.gdate}" pattern="yyyy-MM-dd" /></td>
					<td width="15%">${list.gtime}</td>
					<td  align="right" width="18%">${list.ateamname}</td>
					<td align="right" width="50">
						<img width="50" height="30" src="/resources/img/${list.ateamname}.jpg"> 
					</td>
					<td width="5">vs</td>
					<td align="left" width="50">
						<img width="50" height="30" src="/resources/img/${list.bteamname}.jpg">
					</td>
					<td align="left" width="18%">${list.bteamname}</td>
					<td>${list.stadium}
					<input type="hidden" id="ateamname" value="${list.ateamname}">
					<input type="hidden" id="bteamname" value="${list.bteamname}">
					<input type="hidden" id="gno" value="${list.gno}">
					</td>
				</tr>
			</c:forEach>
			<tfoot>
			<tr align="center">
				<td colspan="8">
					<a id="prev">
						<c:if test="${pageInfo.startPage>1}">
							<input type="hidden" id="prevv" value="${pageInfo.nowPage-1}">&lt;prev
						</c:if>
					</a>
					<c:forEach var="i" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
						<c:choose>
							<c:when test="${pageInfo.nowPage==i}"><b>[<a class="page">${i}</a>]</b></c:when>
							<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
						</c:choose>
					</c:forEach>
					<a id="next">
						<c:if test="${pageInfo.endPage<pageInfo.totalPage}">
							<input type="hidden" id="nextv" value="${pageInfo.nowPage+1}">next&gt;
						</c:if>
					</a>
				</td>
			</tr>
			</tfoot>
		</table>
		<input type="hidden" id="month" value="${month }">
	</div>

</body>
</html>