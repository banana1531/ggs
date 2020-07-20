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

 <style>
 	.center {text-align:center;}
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

	<hr/>
	
	<h3>글쓰기 폼(writeFrm.jsp)</h3>


	<form id="wfrm" action="/column/writeProc.gg" method="post" >      
	 	<table border="1" width="500">
	 		<tbody>
	 			<tr>
	 				<th>글쓴이</th>
	 				<td>${sessionScope.UID} <%-- sessionScope이용하면 세션 --%></td>
	 				<%--
	 					우리는 로그인성공시 유저에 대한 정보를 아래와 같이 넣었다
	 					session.setAttribute("UID", result.get("ID"));
						session.setAttribute("UNAME",result.get("NAME") );
						session.setAttribute("UNICK",result.get("NICK") );
	 				 --%>
	 			</tr>
	 			<tr>
	 				<th>제목</th>
	 				<td>
	 				<!-- <input type="text" name="t" id="t" required="required"/> -->
	 				<input type="text" name="title" id="title" required="required"/></td>
	 			</tr>
	 			<tr>
	 				<th>내용</th>
	 				<td><textarea name="content" id="content" required="required" cols="50" rows="10"></textarea></td>
	 			</tr>
	 			
	 			<tr id="copy">
	 				<td colspan="2" class="center">
	 					<input type="button" id="sBtn" value="글쓰기"/>
	 				</td>
	 			</tr>
	 		</tbody>
	 	</table>     
	</form>
	 
</body>
</html>