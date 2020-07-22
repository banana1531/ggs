<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container">
   <a href="/admin/location.gg">경로 확인</a>
   <h4>최근 게시물 목록</h4>
	<p>최근등록 게시물</p>
		<table class="table">
			<tr>
				<td>게시판</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach items="${boardlist}" var="list">
				<tr>
					<td>게시판이름</td>
					<td>${list.id }</td>
					<td>${list.title }</td>
					<td>${list.writedate }</td>
					<td>${list.views }</td>
				</tr>
			</c:forEach>
		</table>
   </div>
   <div class="container">
	<p>최근신고 접수 글</p>
	<table class="table">
			<tr>
				<td>게시판</td>
				<td>글제목</td>
				<td>작성자</td>
				<td>신고자</td>
				<td>신고일</td>
				<td>사유</td>
			</tr>
			<c:forEach items="${declist}" var="list">
				<tr>
					<td>${list.boardname }</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td>${list.uid }</td>
					<td>${list.inputdate }</td>
					<td>${list.reason }</td>
				</tr>
			</c:forEach>
		</table>
   </div>
   <div class="container">
	<p>회원 현황</p>
   </div>
   ${path }
</body>
</html>