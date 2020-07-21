<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자유 게시판</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<table border="1" width="800" class="center">
		<tbody>
			<c:forEach items="${freeboardDetail}" var="dto">
				<tr>
					<td>${dto.writeno}번 글</td>
					<td>${dto.id}</td>
					<td><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${dto.views} hits</td>
				</tr>
				<tr>
					<td colspan="4"><h1>${dto.title}</h1></td>
				</tr>
				<tr>
					<td colspan="4"><h2>${fn:replace(dto.content, replaceChar, "<br/>")}</h2></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr/>
	<h3>댓글</h3>
		<table border="1" width="800" class="center">
		<tbody>
			<c:forEach items="${freeboardReply}" var="dto">
				<tr>
					<td width="20%"><h5>${dto.id}</h5></td>
					<td><h4>${dto.content}</h4></td>
					<td width="20%"><h5><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></h5></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- 페이징 처리 --%>
	<table border="1" width="800" class="center">
		<tbody>
	<c:forEach items="${freeboardDetail}" var="dto">
			<tr class="center">
				<td>
					<c:if test="${PINFO.nowPage eq 1}">
					[prev]
					</c:if>
				
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="./detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="./detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="./detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
	</c:forEach>
		</tbody>
	</table>
	<form method="post">
	<c:forEach items="${freeboardDetail}" var="dto">
		<input type="hidden" name="wno" id="wno" value="${dto.writeno}">
		<input type="hidden" name=nowPage id="nowPage" value="${dto.nowPage}">
		<input type="hidden" name=views id="views" value="${dto.views}">
	</c:forEach>
	<input type="text" name="id" id="id">
	<input type="text" name="content" id="content">
	<input type="submit" value="등록">
	</form>
	<hr/>
	<c:forEach items="${freeboardDetail}" var="dto">
		<button type="button" onclick="location.href='./update?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}' ">수정하기(자기가 작성한것만)</button>
		<input type="button" value="삭제하기(자기가 작성한것만)" onclick="button_event();">
		<button type="button" onclick="location.href='./list?nowPage=${dto.nowPage}' ">목록으로</button>
	</c:forEach>
	<script>
	function button_event(){
		if (confirm("정말 삭제하시겠습니까?") == true){
		    alert("삭제되었습니다");
		    <c:forEach items="${freeboardDetail}" var="dto">
		    location.href = "./delete?writeno=${dto.writeno}&nowPage=${dto.nowPage}";
		    </c:forEach>
		}else{
		    return;
		}
	}
	</script>
</body>
</html>