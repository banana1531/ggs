<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".page").click(function(){
		var pageNo=$(this).text();
		var option=$("#option").val();
		var search=$("#dsearch").val();
		location="/admin/playerList.gg?pageNo="+pageNo+"&option="+option+"&search="+search
	})
	$(".dto").click(function(){
		var pno=$(this).find("#pno").val();
		location = "/admin/playerDetail.gg?pno="+pno
	})
	$("#next").click(function(){
		var pageNo = $("#nextv").val();
		var option=$("#option").val();
		var search=$("#dsearch").val();
		location="/admin/playerList.gg?pageNo="+pageNo+"&option="+option+"&search="+search
	})
	$("#prev").click(function(){
		var pageNo = $("#prevv").val();
		var option=$("#option").val();
		var search=$("#dsearch").val();
		location="/admin/playerList.gg?pageNo="+pageNo+"&option="+option+"&search="+search	
	})
})

</script>

</head>
<body>
   <div class="container" style="margin-top: 20px">
<a href="/admin/teamList.gg"><button>팀 목록</button></a>
	   <a href="/admin/playerList.gg"><button>선수 목록</button></a>
	   <a href="/admin/gameList.gg"><button>경기 목록</button></a>
	   <a href="/admin/dataUpdate.gg?uri=playerlist"><button>경기 데이터 업데이트</button></a>
	   <a href="/datac/c.gg?uri=playerlist"><button>선수 데이터 업데이트</button></a>
   </div>

   <div class="container" id="body">
   <h4>선수 목록</h4>
   <nav class="navbar navbar-right">
			<form class="form-inline" action="/admin/playerList.gg">
			<input type="hidden" id="option" value="${option}">
				<select id="option" name="option" class="form-control">
					<c:choose>
						<c:when test="${option=='name'}"><option value="name" selected="selected">이름</option></c:when>
						<c:otherwise><option value="name">이름</option></c:otherwise>
					</c:choose>
						<c:choose>
						<c:when test="${option=='teamname'}"><option value="teamname" selected="selected">소속 팀</option></c:when>
						<c:otherwise><option value="teamname">소속 팀</option></c:otherwise>
					</c:choose>
						<c:choose>
						<c:when test="${option=='position'}"><option value="position" selected="selected">포지션</option></c:when>
						<c:otherwise><option value="position">포지션</option></c:otherwise>
					</c:choose>
					<!-- <option value="teamname">소속 팀</option>
					<option value="position">포지션</option> -->
					
				</select><input id="dsearch" type="text" name="search" class="form-control" value=" ${search }">
				<button id="sOption" class="btn btn-default">검색</button>
			</form>
		</nav>
   		<table class="table table-hover">
   		<tr>
   			<th>이름</th>
   			<th>소속 팀</th>
   			<th>등번호</th>
   			<th>포지션</th>   			
   		</tr>
   		<c:choose>
   		<c:when test="${result ==null }">
					<c:forEach items="${playerlist}" var="player">
						<tr class="dto">
							<td><input id="pno" type="hidden" value="${player.pno}">
								${player.name}</td>
							<td>${player.teamname}</td>
							<td>${player.labelno }</td>
							<td>${player.position }</td>
						</tr>
					</c:forEach>
					<tr align="center">
						<td colspan="4">
						<a id="prev">
				<c:if test="${pageInfo.startPage>1}">
					<input type="hidden" id="prevv" value="${pageInfo.nowPage-1}">&lt;prev
				</c:if>
				</a>
				<c:forEach var="i"
						begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
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
				</c:when>
			<c:otherwise><tr><td colspan="4">${result }</td></tr></c:otherwise>
			</c:choose>
		</table>
   </div>
</body>
</html>