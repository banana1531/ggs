<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
	  <a href="/admin/deSummary.gg"><button>접수 현황</button></a>
	  <a href="/admin/declList.gg"><button>미처리 목록</button></a>
	  <a href="/admin/dondeclList.gg"><button>처리완료 목록</button></a>
   </div>
   <div class="container">
   <form class="form" action="/admin/declUpdate.gg">
   <table class="table">
   		<tr>
   			<td>게시판 : <input type="text" name="boardname" value="${detail.boardname}" readonly="readonly"></td>
   		
   		</tr>
   		<tr>
   			<td>글번호 : <input type="text" name="writeno" value="${detail.fno}" readonly="readonly"></td>
   		</tr>
   		<tr><td>작성자 : ${detail.writer}</td></tr>
   		<tr><td>작성일 : <fmt:formatDate value="${detail.writedate}"/> </td></tr>
   		
   		<tr>
   			<td>제목 : ${detail.title}</td>
   		</tr>
   		<tr>
   			<td>내용<br/>
   			<textarea readonly="readonly" style="width: 1100px; height: 250px;">${detail.content}</textarea>
   			</td>
   		</tr>
   </table>
   <table class="table">
   		<tr>
   			<td>신고자 : ${detail.id}</td>
   			<td>신고일 :  <fmt:formatDate value="${detail.inputdate}"/></td>
   			<td>신고사유 : ${detail.reason}</td>
   		</tr>
   		<tr>
   			<td>기타 상세 : ${detail.details}</td>
   		</tr>
   </table>
   <c:if test="${detail.outputdate<detail.inputdate || detail.outputdate==null}">
   <select name="isvisible">
   			<option value="1">노출</option>
   			<option value="0" selected="selected">비노출</option>
   		</select>
   		<button>적용</button>
   </c:if>
   		${error}
   	</form>
   </div>
</body>
</html>