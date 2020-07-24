<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% pageContext.setAttribute("replaceChar", "\n"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>야구 지식 게시글 상세보기</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
 <script>
/* $(function(){
		$("#rpBtn").click(function(){
			
			var rpc=$("#content").val();
			if(rpc== "") {
				alert("댓글을 입력해주세요")
				return;
			}else{
				alert(rpc);
				$("#rpFrm").submit();  //폼객체.submit();
				$(location).attr("href","../column/detail.gg?content=${RDTO.content}&wno=${RDTO.wno}&writeno=${BDTO.writeno}");
				
			}

		});
 }); */
 </script>
</head>
<body>
		<a href="../column/list">목록으로</a>
<div class="container">
	<table border="1" width="1000" class="center">
		<tbody>
			<c:forEach items="${cBoardDetail}" var="dto">
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
			<tr><td colspan="4" align="right"><c:forEach items="${cBoardDetail}" var="dto">
			<c:if test="${UID=='admin' }"><button type="button" onclick="location.href='./update?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}' ">수정하기</button>
		<input type="button" value="삭제하기" onclick="button_event();"></c:if>
		<button type="button" onclick="location.href='./list?nowPage=${dto.nowPage}' ">목록으로</button>
	</c:forEach></td></tr>
		</tbody>
	</table>
		
	<hr/>
	<h3>댓글</h3>
		<table border="1" width="1000" class="center">
		<tbody>
			<c:forEach items="${cBoardReply}" var="dto">
				<tr>
					<td width="20%"><h5>${dto.id}</h5></td>
					<td><h4>${dto.content}</h4></td>
					<td width="20%"><h5><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></h5></td>
				</tr>
			</c:forEach>
			<c:forEach items="${cBoardDetail}" var="dto">
			<tr class="center">
				<td colspan="3">
					<c:if test="${PINFO.nowPage eq 1}">
					[이전댓글]
					</c:if>
				
					<c:if test="${CPINFO.nowPage ne 1}">
					<a href="../cBoard/detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${CPINFO.nowPage-1}">[이전댓글]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${CPINFO.startPage}" end="${CPINFO.endPage}">
					<a href="../cBoard/detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${CPINFO.nowPage eq CPINFO.totalPage}">
					[다음댓글]
					</c:if>
					
					<c:if test="${CPINFO.nowPage ne CPINFO.totalPage}">
					<a href="../cBoard/detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage+1}">[다음댓글]</a>
					</c:if>
				</td>
			</tr>
	</c:forEach>

	<form method="post">
	<c:forEach items="${cBoardDetail}" var="dto">
		<input type="hidden" name="id" id="id" value="${dto.id}">
		<input type="hidden" name="wno" id="wno" value="${dto.writeno}">
		<input type="hidden" name=nowPage id="nowPage" value="${dto.nowPage}">
		<input type="hidden" name=views id="views" value="${dto.views}">
	</c:forEach>
	<tr>
	<td name="id" id="id" >작성자 ${sessionScope.UID}</td>
	<td><input type="text" name="content" id="content"></td>
	<td><input type="submit" value="댓글등록"></td>
	</tr>
	</form>

	
		</tbody>
	</table>

	<hr/>
<script>
	function button_event(){
		if (confirm("정말 삭제하시겠습니까?") == true){
		    alert("삭제되었습니다");
		    <c:forEach items="${cBoardDetail}" var="dto">
		    location.href = "./delete?writeno=${dto.writeno}&nowPage=${dto.nowPage}";
		    </c:forEach>
		}else{
		    return;
		}
	}
</script>
	</div>
</body>
</html>