<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(".page").click(function(){
	var pageNo = $(this).text();
	var name   = $("#names").text();
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo);
})
$(".dto").click(function(){
	var gno =$(this).find("#gno").val();
	location = "/teampredict/rltmatchDetail.gg?gno="+gno
	
})
$("#next").click(function(){
	var pageNo = $("#nextv").val();
	var name   = $("#names").text();
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo);
})
$("#prev").click(function(){
	var pageNo = $("#prevv").val();
	var name   = $("#names").text();
	$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo);
})


</script>
</head>
<body>
		<table class="table table-hover" id="list">
		<caption>경기 결과 목록</caption>
			<thead>
			<tr>
				<th>일자</th>
				<th>팀이름</th>
				<th>점수</th>
				<th>팀이름</th>
				<th>점수</th>
				<th>경기장</th>
				<th>결과</th>
			</tr>
			</thead>
			<c:forEach items="${list}" var="record">
				<tr class="dto">
					<td><fmt:formatDate value="${record.gdate }"
							pattern="yyyy-MM-dd" /></td>
					<td id="names">${record.ateamname }</td>
					<td>${record.ascore }</td>
					<td>${record.bteamname }</td>
					<td>${record.bscore }
					</td>
					<td>${record.stadium }
					<input type="hidden" id="gno" value="${record.gno }"></td>
					<td><c:choose>
							<c:when test="${record.ascore>record.bscore}"><b style="color: blue; font-weight: bolder;">승</b></c:when>
							<c:when test="${record.ascore==record.bscore}">무</c:when>
							<c:otherwise><b style="color: red; font-weight: bolder;">패</b></c:otherwise>
						</c:choose></td>					
				</tr>
			</c:forEach>

			<tr align="center">
				<td colspan="7">
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
		</table>
</body>
</html>