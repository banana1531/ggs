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
	<div class="container">
		<table border="1" width="800" class="table">
			<tbody>
				<c:forEach items="${freeboardDetail}" var="dto">
					<tr>
						<td>${dto.writeno}번글</td>
						<td>${dto.id}</td>
						<td><fmt:formatDate value="${dto.writedate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${dto.views}hits</td>
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
	</div>
	<div class="container" align="right">
		<c:forEach items="${freeboardDetail}" var="dto">
			<c:if test="${UID == dto.id}">
				<button type="button"
					onclick="location.href='./update?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}' ">수정하기</button>
				<input type="button" value="삭제하기" onclick="button_event();">
			</c:if>
			<button type="button"
				onclick="location.href='./list?nowPage=${dto.nowPage}' ">목록으로</button>
			<button type="button" data-toggle="modal" data-target="#myModal">글
				신고하기</button>

			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title" align="left">글 신고하기</h4>
						</div>
						<form class="form-inline" action="/admin/decInsert.gg">
							<div class="modal-body" align="left">
								글번호 : <input name="writeno" value="${dto.writeno}"readonly="readonly" style="border: none;"><br /> 
								게시판 :<input name="boardname" value="${dto.boardname}"readonly="readonly" style="border: none;"><br /> 
								사유 :	<input type="radio" name="reason" value="홍보성">홍보성 
								<input type="radio" name="reason" value="불법정보">불법정보
								<input type="radio" name="reason" value="선정성">선정성
								<input type="radio" name="reason" value="욕설">욕설
								<input type="radio" name="reason" value="개인정보 노출">개인정보 노출
								<input type="radio" name="reason" value="기타">기타
								 <br /> 
								상세 내용(필요시기재):<br />
								<textarea name="detail" style="width: 550px; height: 200px"></textarea>
								<br />
								<input type="hidden" name="id" value="${UID}">
								<input type="hidden" name="nowPage" value="${PINFO.nowPage }">								
								<input type="hidden" name="views" value="${dto.views}">
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default" id="dec">신고 등록</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">닫기</button>
							</div>
						</form>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
	<hr />
	<div class="container">
		<h3>댓글</h3>
		<table border="1" width="800" class="table">
			<tbody>
				<c:forEach items="${freeboardReply}" var="dto">
					<tr>
						<td width="20%"><h5>${dto.id}</h5></td>
						<td><h4>${dto.content}</h4></td>
						<td width="20%"><h5>
								<fmt:formatDate value="${dto.writedate}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</h5></td>
					</tr>
				</c:forEach>
				<%-- 페이징 처리 --%>
				<c:forEach items="${freeboardDetail}" var="dto">
					<tr class="center">
						<td colspan="3"><c:if test="${PINFO.nowPage eq 1}">
					[prev]
					</c:if> <c:if test="${PINFO.nowPage ne 1}">
								<a
									href="./detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage-1}">[prev]</a>
							</c:if> <c:forEach var="pg" begin="${PINFO.startPage}"
								end="${PINFO.endPage}">
								<a
									href="./detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${pg}">[${pg}]</a>
							</c:forEach> <c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if> <c:if test="${PINFO.nowPage ne PINFO.totalPage}">
								<a
									href="./detail?writeno=${dto.writeno}&nowPage=${dto.nowPage}&views=${dto.views}&nowPage2=${PINFO.nowPage+1}">[next]</a>
							</c:if></td>
					</tr>
				</c:forEach>
				<form method="post">
				<table border="1" class="table">
				<tr>
					<td>
						<c:forEach items="${freeboardDetail}" var="dto">
							<input type="hidden" name="wno" id="wno" value="${dto.writeno}">
							<input type="hidden" name=nowPage id="nowPage" value="${dto.nowPage}">
							<input type="hidden" name=views id="views" value="${dto.views}">
						</c:forEach> <input type="text" name="id" id="id" value="${UID}" readonly="readonly" style="border: none;"></td>
					<td width="80%"><input type="text" name="content" id="content" style="width: 800px">
					<input type="submit" value="등록"></td>
				</tr>
				</table>
				</form>
			</tbody>
		</table>


	</div>
	
	<hr />

	<script>
		function button_event() {
			if (confirm("정말 삭제하시겠습니까?") == true) {
				alert("삭제되었습니다");
				<c:forEach items="${freeboardDetail}" var="dto">
				location.href = "./delete?writeno=${dto.writeno}&nowPage=${dto.nowPage}";
				</c:forEach>
			} else {
				return;
			}
		}
	</script>
</body>
</html>