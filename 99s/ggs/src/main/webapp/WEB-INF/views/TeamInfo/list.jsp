<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>팀정보 게시판</title>
<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>팀명</th>
				<th>승</th>
				<th>무</th>
				<th>패</th>
				<th>득점</th>
				<th>실점</th>
			</tr>

			<tr>
				<th>KIA</th>
				<c:forEach items="${KIAWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${KIADraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${KIALose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${KIAScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${KIALoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>KT</th>
				<c:forEach items="${KTWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${KTDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${KTLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${KTScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${KTLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>LG</th>
				<c:forEach items="${LGWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${LGDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${LGLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${LGScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${LGLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>NC</th>
				<c:forEach items="${NCWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${NCDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${NCLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${NCScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${NCLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>SK</th>
				<c:forEach items="${SKWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${SKDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${SKLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${SKScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${SKLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>두산</th>
				<c:forEach items="${DSWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${DSDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${DSLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${DSScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${DSLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>롯데</th>
				<c:forEach items="${LTWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${LTDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${LTLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${LTScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${LTLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>삼성</th>
				<c:forEach items="${SSWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${SSDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${SSLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${SSScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${SSLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>키움</th>
				<c:forEach items="${KUWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${KUDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${KULose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${KUScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${KULoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>

			<tr>
				<th>한화</th>
				<c:forEach items="${HHWin}" var="dto">
					<th>${dto.win}</th>
				</c:forEach>
				<c:forEach items="${HHDraw}" var="dto">
					<th>${dto.draw}</th>
				</c:forEach>
				<c:forEach items="${HHLose}" var="dto">
					<th>${dto.lose}</th>
				</c:forEach>
				<c:forEach items="${HHScore}" var="dto">
					<th>${dto.score}</th>
				</c:forEach>
				<c:forEach items="${HHLoss}" var="dto">
					<th>${dto.loss}</th>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</body>
</html>
