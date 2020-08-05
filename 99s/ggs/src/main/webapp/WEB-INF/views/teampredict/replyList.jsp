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
	var wno = $("#writeno").val();
	$(".btn").click(function(){
		var id = $("#id").val();
		var content = $("#contents").val();
		$("#list").load("/teampredict/reply?id="+id+"&content="+content+"&wno="+wno)
	})
	
})

</script>
</head>
<body>
	<h3 align="left">댓글</h3>
	<table class="table">
		<tr>
			<td width="15%">작성자</td>
			<td>내용</td>
			<td width="15%">작성일</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id}</td>
				<td>${dto.content }</td>
				<td><fmt:formatDate value="${dto.writedate }" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>