<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$(".btn").click(function(){
		var pageNo = $(this).text()
		var name=$("#name").text() 
		$("#list").load("/admin/teamRecordP?name="+name+"&pageNo="+pageNo)
	})
})
</script>
</head>
<body>
	<div class="container">
		<table class="table" id="list">
			<tr>
				<th>일자</th>
				<th>팀이름</th>
				<th>점수</th>
				<th>팀이름</th>
				<th>점수</th>
				<th>경기장</th>
				<th>결과</th>
			</tr>
			<c:forEach items="${list}" var="record">
				<tr>
					<td><fmt:formatDate value="${record.gdate }"
							pattern="yyyy-MM-dd" /></td>
					<td>${record.ateamname }</td>
					<td>${record.ascore }</td>
					<td>${record.bteamname }</td>
					<td>${record.bscore }</td>
					<td>${record.stadium }</td>
					<td><c:choose>
							<c:when test="${record.ascore>record.bscore}">승</c:when>
							<c:when test="${record.ascore==record.bscore}">무</c:when>
							<c:otherwise>패</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="7"><c:forEach var="i" begin="1"
						end="${totalpage}">
					[<a class="btn">${i}</a>]
				</c:forEach></td>
			</tr>
		</table>

	</div>
</body>
</html>