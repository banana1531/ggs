<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(function(){
	$(".dto").click(function(){
		var no = $(this).find(".no").text();
		var boardname = $(this).find(".bname").text();
		location="/admin/declDetail.gg?boardname=" + boardname + "&writeno=" + no;
	});
	$(".page").click(function(){
		var pageNo=$(this).text();
		location="/admin/declList.gg?pageNo="+pageNo
	})
});

</script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
	   <button><a href="/admin/deSummary.gg">접수 현황</a></button>
	   <button><a href="/admin/declList.gg">미처리 목록</a></button>
	   <button><a href="/admin/dondeclList.gg">처리완료 목록</a></button>
   </div>
   <div class="container">
	신고 접수 목록
		<table class="table table-hover">
			<tr>
				<td>게시판</td>
				<td>글번호</td>
				<td>글제목</td>
				<td>작성자</td>
				<td>신고자</td>
				<td>신고일</td>
				<td>사유</td>
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
				</tr>
			</c:forEach>
			<tr>
				<td align="center" colspan="7">
				<c:if test="${pageInfo.startPage>1}">&lt;prev</c:if>
				<c:forEach var="i"
						begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					[<a class="page">${i}</a>]
				</c:forEach>
				<c:if test="${pageInfo.endPage<pageInfo.totalPage}"><a>next&gt;</a></c:if>
				</td>
			</tr>
		</table>
   </div>
</body>
</html>