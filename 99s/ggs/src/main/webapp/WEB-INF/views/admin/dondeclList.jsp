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
   <h1>dondeclList 들어왔다.</h1>
    <div class="container">
	   <button><a href="/admin/deSummary.gg">접수 현황</a></button>
	   <button><a href="/admin/declList.gg">미처리 목록</a></button>
	   <button><a href="/admin/dondeclList.gg">처리완료 목록</a></button>
   </div>
   <div class="container">
		<nav class="navbar navbar-right">
			<form action="/admin/declSearch.gg" class="form-inline">
				<select name="option" class="form-control">
					<option value="id">신고자</option>
					<option value="writer">작성자</option>
					<option value="idAndWriter">신고자+작성자</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select> <input type="text" name="name" class="form-control">
				<button class="btn">검색</button>

			</form>
		</nav>
		<table class="table">
			<tr>
				<td>게시판</td>
				<td>글번호</td>
				<td>글제목</td>
				<td>작성자</td>
				<td>신고자</td>
				<td>신고일</td>
				<td>사유</td>
				<td>처리일자</td>
			</tr>
			<c:forEach items="${declist}" var="list">
				<tr class="dto">
					<td class="bname">${list.boardname }</td>
					<td class="no">${list.fno }</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td>${list.uid }</td>
					<td>${list.inputdate }</td>
					<td>${list.reason }</td>
					<td>처리일자</td>
				</tr>
			</c:forEach>
			<tr>
				<td align="center" colspan="7">페이징 구간</td>
			</tr>
		</table>
   </div>
</body>
</html>