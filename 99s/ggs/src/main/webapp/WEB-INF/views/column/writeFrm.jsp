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
	function checkForm() {
		if (document.getElementById("title").value == "") {
			alert("제목을 입력해주세요")
			return false;
		}
		if (document.getElementById("content").value == "") {
			alert("내용을 입력해주세요")
			return false;
		}

	}

 $(function(){
		var cnt = 1; //첨부파일수를 저장하는 변수
			
		//추가버튼 클릭시  첨부파일 동적으로 (최대 5개)추가 
		$("#aBtn").click(function(){
			cnt++;
			if( cnt==6 ){
				alert("첨부파일은 최대 5개까지 가능합니다");
				cnt=5;
				return;
			}
			
			//추가할 대상 
			var tr = '<tr>';
			    tr+= 	'<th>첨부파일</th>';
			    tr+= 	'<td><input type="file" name="files" id="files'+cnt+'"/></td>';
			    tr+= '</tr>';
			
			//원하는 위치에 붙인다
			$("#copy").before(tr);
			
		});
		
		//삭제버튼 클릭시   첨부파일 동적으로 삭제  (최소1개남기고)
		$("#dtn").click(function(){
			if( cnt==1 ){
				alert("첨부파일은 최소 1개가 있어야 합니다");
				return;
			}
			
			//제거
			var tr = $("#files"+cnt).parents("tr");
			tr.remove();
			
			cnt--;
		});
		
		//글쓰기버튼 클릭시 id="sBtn"
		$("#sBtn").click(function(){
			//무결성검사하고.. 여러분이 하시고..
			
			$("#wfrm").submit();  //폼객체.submit();
		});
 });
 </script>
</head>
<body>

	<hr/>
	
	<h3>글쓰기 폼(writeFrm.jsp)</h3>

	   
	
	<!-- 파일업로드 폼은 반드시 method="POST" 
			 encType="multipart/form-data"로 지정해야 한다-->
	<form id="wfrm" action="../column/writeProc.gg" 
	      method="post" encType="multipart/form-data"
	      onsubmit="return checkForm();">
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
	 				<td><input type="text" name="title" id="title" required="required"/></td>
	 			</tr>
	 			<tr>
	 				<th>내용</th>
	 				<td><textarea name="content" id="content" required="required" cols="50" rows="10"></textarea></td>
	 			</tr>
	 			<tr>
	 				<th>비밀번호</th>
	 				<td><input type="password" name="pw" id="pw" required="required"/></td>
	 			</tr>
	 			<tr>
	 				<th>첨부파일</th>
	 				<td>
	 					<input type="button" value="추가" id="aBtn"/>
	 					<input type="button" value="삭제" id="dtn"/>
	 				</td>
	 			</tr>
	 			<tr>
	 				<th>첨부파일</th>
	 				<td><input type="file" name="files" id="files"/></td>
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






