<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>야구 지식 게시판</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
 <script>
$(function(){

		//글쓰기버튼 클릭시 id="sBtn"
		$("#sBtn").click(function(){
			//무결성검사하고.. 여러분이 하시고..
			var t=$("#title").val();
			if(t== "") {
				alert("제목을 입력해주세요")
				return;
			}
			
			var ct=$("#content").val();
			if(ct== "") {
				alert("내용을 입력해주세요")
				return;
			}
			alert(t +"/"+ct);
			
			$("#wfrm").submit();  //폼객체.submit();
		});
 });
 </script>
</head>
<body>
<h3>야구 지식 게시판 글쓰기</h3>
	<form id="wfrm" action="/column/write.gg" method="post">
		<table border="1" width="800" class="center">
			<tr>
				<th>작성자</th>
				<%-- <td><input type="text" name="id" id="id" required="required"/>${sessionScope.UID}</td> --%>
				<td>${sessionScope.UID}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" required="required"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" required="required" cols="50" rows="10"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="sBtn" value="글쓰기"/>
					<button type="reset">새로입력</button>
					<input type="button" value="취소" onclick="history.back();" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
	
	
	
	
	