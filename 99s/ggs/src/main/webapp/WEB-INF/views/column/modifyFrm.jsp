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

 <script>
 $(function(){
  
		//수정버튼 클릭시 id="sBtn"
		$("#mBtn").click(function(){
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
			
			$("#mfrm").submit();  //폼객체.submit();
		});
	 
 });
 </script>
</head>
<body>
		<a href="../column/cBoard.gg">목록으로</a>
	<hr/>

	<h3>modiFyFrm.jsp</h3>

	<hr/>	

	

		<form method="POST" action="../column/modifyProc.gg" id="mfrm" >
			<input type="hidden" name="writeno" value="${BDTO.writeno}"/>
			<input type="hidden" name="nowPage" value="${nowPage}"/>
		<table width="600" border="1">
			<tr>
				<td>글쓴이</td>
				<td>${sessionScope.UID}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title" id="title" 
								 value="${BDTO.title}" required="required"/>
				</td>
			</tr>
			<tr>
				<td>본문</td>
				<td>
					<textarea name="content" id="content"  required="required">${BDTO.content}</textarea>
				</td>
			</tr>


			<tr id="copy">
				<td colspan="2" align="center">
					<input type="button" id="mBtn" value="수정하기"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>