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
	var pno=$(this).find("#pno").val();
	$(".btn").click(function(){
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
	<div class="container">
		<table class="table table-hover" id="list">
			<tr>
				<th>이름</th>
			</tr>
			<c:forEach items="${list }" var="team">
				<tr class="team">
					<td>
					<input id="pgno" type="hidden" value="${team.pgno}">
					  ${team.gdate}</td>
				</tr>
			</c:forEach>


			<tr>
				<td><c:if test="${pageInfo.startPage>1}">&lt;prev</c:if> <c:forEach
						var="i" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					[<a class="btn">${i}</a>]
				</c:forEach> <c:if test="${pageInfo.endPage<pageInfo.totalPage}">next&gt;</c:if>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>