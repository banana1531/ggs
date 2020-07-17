<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title></title>
 <!-- jQuery CDN -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

	<hr/>
	
	<h3>글쓰기 폼(writeFrm.jsp)</h3>

	   
	
	<!-- 파일업로드 폼은 반드시 method="POST" 
			 encType="multipart/form-data"로 지정해야 한다-->
	<form action="/column/writeProc.gg">
	 	<table border="1" width="500">
	 		<tbody>
	 			<tr>
	 				<th>글쓴이</th>
	 				<td>${sessionScope.UID} <%-- sessionScope이용하면 세션 --%></td>
	 			</tr>
	 			<tr>
	 				<th>제목</th>
	 				<td><input type="text" name="title" id="title"/></td>
	 			</tr>
	 			<tr>
	 				<th>내용</th>
	 				<td><textarea name="content" id="content"  cols="50" rows="10"></textarea></td>
	 			</tr>
	 			<tr id="copy">
	 				<td colspan="2" class="center">
	 					<input type="submit"  value="글쓰기"/>
	 				</td>
	 			</tr>
	 		</tbody>
	 	</table>     
	</form>
	 
</body>
</html>