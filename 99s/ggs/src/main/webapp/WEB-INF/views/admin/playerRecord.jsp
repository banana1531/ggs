<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	var pno=$(this).find("#pno").val();
	$(".page").click(function(){
		var pageNo = $(this).text()
		$("#list").load("/admin/playerRecord?pno="+pno+"&pageNo="+pageNo)
	})
	$(".team").click(function(){
		var pgno = $("#pgno").val();
		location = "/admin/playerRecordDetail.gg?pgno="+pgno
		
	})
})
</script>
</head>
<body>
	<div class="container" style="margin-top: 20px">
		<table class="table table-hover" id="list">
			<tr>
				<th>일자</th>
				<th>상대팀</th>
				<th>결과</th>
				<th>선발</th>
			</tr>
			<c:forEach items="${list }" var="team">
				<tr class="team">
					<td>
					<input id="pgno" type="hidden" value="${team.pgno}">
						${team.gdate}</td>
					  <td>${team.vs}</td>
					  <td>${team.gresult}</td>
					  <td>${team.sunbal}</td>
				</tr>
			</c:forEach>


			<tr align="center">
				<td colspan="4"><c:if test="${pageInfo.startPage>1}">&lt;prev</c:if> <c:forEach
						var="i" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<c:choose>
							<c:when test="${pageInfo.nowPage==i}"><b>[<a class="page">${i}</a>]</b></c:when>
							<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
						</c:choose>
				</c:forEach> <c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>