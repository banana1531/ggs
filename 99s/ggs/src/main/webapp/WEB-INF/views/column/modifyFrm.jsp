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
	 var cnt = 1; //첨부파일수를 저장하는 변수
	 
	 //추가버튼 클릭시
	 $("#aBtn").click(function(){
		  cnt++;
			if( cnt==6 ){
				alert("첨부파일은 최대 5개까지 가능합니다");
				cnt=5;
				return;
			}
			
			//추가할 대상 
			var tr = '<tr>';
			    tr+= 	'<td>첨부파일</td>';
			    tr+= 	'<td><input type="file" name="files" id="files'+cnt+'"/></td>';
			    tr+= '</tr>';
			
			//원하는 위치에 붙인다
			$("#copy").before(tr);
	 });
	 
	 //삭제버튼 클릭시
	 $("#dBtn").click(function(){
			if( cnt==1 ){
				alert("첨부파일은 최소 1개가 있어야 합니다");
				return;
			}
			
			//제거
			var tr = $("#files"+cnt).parents("tr");
			tr.remove();
			
			cnt--;
		});
	 
	 
	 //수정버튼 클릭시
	 $("#mBtn").click(function(){
		 alert('~');
			//	무결성 검사하고
			$("#mfrm").submit();
		});
	 
 });
 </script>
</head>
<body>
		<a href="../index.jsp">HOME</a>
	<hr/>

	<h3>modiFyFrm.jsp</h3>

	<hr/>	

	

		<form method="POST" action="../column/modifyProc.gg" id="mfrm" encType="multipart/form-data">
			<input type="hidden" name="no" value="${BDTO.writeno}"/>
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
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" name="pw" id="pw"  required="required"/>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="button" value="추가" id="aBtn"/>
					<input type="button" value="삭제" id="dBtn"/>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="files" id="files"/>
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






