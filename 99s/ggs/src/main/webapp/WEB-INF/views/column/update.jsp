<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>야구 지식 게시글 수정</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
		<a href="../column/list">목록으로</a>
	<form method="post">
		<table border="1" width="800" class="center">
			<tbody>
				<c:forEach items="${cBoardUpdateFrm}" var="dto">
					<tr>
						<td>글번호</td>
						<td><input type="hidden" id="writeno" name="writeno" value="${dto.writeno}">${dto.writeno}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${dto.id}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="title" id="title"
							required="required" value="${dto.title}"></td>
					</tr>
					<tr>
						<td>작성일</td>
						<td><fmt:formatDate value="${dto.writedate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${dto.views}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="content" id="content" required="required"
								cols="50" rows="10">${dto.content}</textarea></td>
					</tr>
					<input type="hidden" value="${dto.nowPage}"/>
					<input type="hidden" value="${dto.views}"/>
				</c:forEach>
				<tr>
					<td colspan="2">
						<button>수정하기</button>
						<button type="reset">글 원래대로</button>
						<input type="button" value="취소" onclick="history.back();" />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>