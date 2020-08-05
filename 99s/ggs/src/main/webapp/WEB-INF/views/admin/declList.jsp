<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
$(function(){
	$(".dto").click(function(){
		var wNo = $(this).find("#wno").val();
		var fno = $(this).find(".no").text();
		var boardname = $(this).find("#bname").val();
		location="/admin/declDetail.gg?wno=" + wNo+"&fno="+fno+"&boardname="+boardname;
	});
	$(".page").click(function(){
		var pageNo=$(this).text();
		location="/admin/declList.gg?pageNo="+pageNo
	})
	$("#next").click(function(){
		var pageNo = $("#nextv").val();
		var name   = $("#names").text();
		location="/admin/teamRecordP?name="+name+"&pageNo="+pageNo;
	})
	$("#prev").click(function(){
		var pageNo = $("#prevv").val();
		var name   = $("#names").text();
		location="/admin/teamRecordP?name="+name+"&pageNo="+pageNo;	
	})

})

</script>
<title>Insert title here</title>
</head>
<body>
    <div class="container">
  <a href="/admin/deSummary.gg"><button>접수 현황</button></a>
	  <a href="/admin/declList.gg"><button>미처리 목록</button></a>
	  <a href="/admin/dondeclList.gg"><button>처리완료 목록</button></a>
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
			<c:choose>
				<c:when test="${result!=null }">
					<tr>
						<td colspan="7" align="center">${result }</td>
					</tr>
				</c:when>
				<c:otherwise>
			<c:forEach items="${declist}" var="list">
				<tr class="dto">
					<td>
					<input type="hidden" id="bname" value="${list.boardname}">
					<input type="hidden" id="wno" value="${list.wNo}">
					<c:choose>
						<c:when test="${list.boardname=='freeboard'}">자유게시판</c:when>
						<c:otherwise>정보오류 신고</c:otherwise>
					</c:choose>
					</td>
					<td class="no">${list.fno }</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td>${list.uid }</td>
					<td><fmt:formatDate value="${list.inputdate }"/> </td>
					<td>${list.reason }</td>
				</tr>
			</c:forEach>
			
			
			
				</c:otherwise>
			</c:choose>
			
			
			<tr>
				<td align="center" colspan="7">
				<a id="prev">
				<c:if test="${pageInfo.startPage>1}">
					<input type="hidden" id="prevv" value="${pageInfo.nowPage-1}">&lt;prev
				</c:if>
				</a>
				<c:forEach var="i"	begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<c:choose>
						<c:when test="${pageInfo.nowPage==i}"><b>[<a class="page">${i}</a>]</b></c:when>
						<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
					</c:choose>
				</c:forEach>
				<a id="next">
					<c:if test="${pageInfo.endPage<pageInfo.totalPage}">
						<input type="hidden" id="nextv" value="${pageInfo.nowPage+1}">next&gt;
					</c:if>
				</a>
				</td>
			</tr>
		</table>
   </div>
</body>
</html>