<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".dec").click(function(){
		var fno = $(this).find("#writeno").val();
		var boardname = $(this).find("#boardname").val();
		var wNo = $(this).find("#wNo").val();
		location="/admin/declDetail.gg?boardname=" + boardname + "&fno=" + fno+"&wno="+wNo;
		
	});
	
	$(".dto").click(function(){
		var writeno = $(this).find("#writeno").val();
		var boardname = $(this).find("#boardname").val();  
		var views = $(this).find("#views").val();
		location="/"+boardname+"/detail?writeno=" + writeno+"&views="+views+"&nowPage=1";
	})
})

</script>
</head>
<body>
	<div class="container">
		<h4>최근 게시물 목록</h4>
		<p>최근등록 게시물</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>게시판</td>
					<td>글번호</td>
					<td>작성자</td>
					<td width="30%">제목</td>
					<td>작성일</td>
					<td>조회수</td>
				</tr>
			</thead>
			<c:forEach items="${boardlist}" var="list">
				<tr class="dto">
					<td><c:choose>
							<c:when test="${list.boardname=='freeboard' }">자유게시판</c:when>
							<c:otherwise>정보 오류 신고</c:otherwise>
						</c:choose></td>
					<td>${list.writeno }</td>
					<td>${list.id }</td>
					<td>${list.title }</td>
					<td><fmt:formatDate value="${list.writedate}"/></td>
					<td>${list.views }
					<input type="hidden" id="boardname" value="${list.boardname}">
					<input type="hidden" id="writeno" value="${list.writeno}">
					<input type="hidden" id="views" value="${list.views}">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<p>최근신고 접수 글</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<td>등록번호</td>
					<td>게시판</td>
					<td>글번호</td>
					<td width="25%">글제목</td>
					<td>작성자</td>
					<td>작성일</td>
					<td>신고자</td>
					<td>신고일</td>
					<td>사유</td>
				</tr>
			</thead>
			<c:forEach items="${declist}" var="list">
				<tr class="dec">
					<td>${list.wNo }
					</td>
					<td><c:choose>
							<c:when test="${list.boardname=='freeboard' }">자유게시판</c:when>
							<c:otherwise>정보 오류 신고</c:otherwise>
						</c:choose></td>
					<td>${list.fno }</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td><fmt:formatDate value="${list.writedate}" /></td>
					<td>${list.uid }</td>
					<td><fmt:formatDate value="${list.inputdate}" /></td>
					<td>${list.reason }
					<input type="hidden" id="boardname" value="${list.boardname}">
					<input type="hidden" id="writeno" value="${list.fno }">
					<input type="hidden" id="wNo" value="${list.wNo }">
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>