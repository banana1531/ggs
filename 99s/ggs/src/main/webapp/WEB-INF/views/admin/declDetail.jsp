<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
   		<tr><td>작성일 : ${detail.writedate}</td></tr>
   		
   		<tr>
   			<td>제목 : ${detail.title}</td>
   		</tr>
   		<tr>
   			<td>내용<br/>
   			<textarea readonly="readonly">${detail.content}</textarea>
   			</td>
   		</tr>
   </table>
   <table class="table">
   		<tr>
   			<td>신고자 : ${detail.id}</td>
   			<td>신고일 : ${detail.inputdate}</td>
   			<td>신고사유 : ${detail.reason}</td>
   		</tr>
   		<tr>
   			<td>기타 상세 : ${detail.details}</td>
   		</tr>
   </table>
   	
   		<select name="isvisible">
   			<option value="1">노출</option>
   			<option value="0" selected="selected">비노출</option>
   		</select>
   		<button>적용</button>
   		${error}
   	</form>
   </div>
</body>
</html>