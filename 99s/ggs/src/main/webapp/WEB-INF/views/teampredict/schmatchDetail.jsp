<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<title>Insert title here</title>
<script>
	google.charts.load('current', {'packages':['bar']});
	google.charts.setOnLoadCallback(drawStuff);

	function drawStuff() {
		var data = new google.visualization.arrayToDataTable(${preCount});

		var options = {
			legend : {
				position : 'none'
			},
			chart : {
				title : '경기 예측 현황'
			},
			axes : {
				x : {
					0 : {
						side : 'top',
						label : '경기예측현황'
					}
				// Top x-axis.
				}
			},
		};

		var chart = new google.charts.Bar(document.getElementById('top_x_div'));
		// Convert the Classic options to Material options.
		chart.draw(data, google.charts.Bar.convertOptions(options));
	};
</script>


</head>
<body>
	<div class="container">
		<a href="/teampredict/prematchMain.gg"><button>승부예측</button></a>
		<a href="/teampredict/schmatchList.gg"><button>경기일정</button></a>
		<a href="/teampredict/rltmatchList.gg"><button>경기결과</button></a>
	</div>
	<div class="container">
		<div class="container" align="center">
			<h4>경기일정</h4>

			<table border="1" class="table" style="width: 500px">
				<tr align="center">
					<td width="20%">경기날짜</td>
					<td width="20%">경기시간</td>
					<td>구장</td>
				</tr>

				<tr align="center">
					<td><fmt:formatDate value="${detail.gdate}" /></td>
					<td>${detail.gtime}</td>
					<td>${detail.stadium }</td>
				</tr>
			</table>
		</div>
		<c:if test="${schedule==null}">
			<c:if test="${result==null }">
				<div class="container" style="width: 500px" align="center" id="top_x_div"></div>
			</c:if>
			<div class="container" align="center">${result }</div>
		</c:if>
		<div class="container" align="center">
			<table border="1" class="table" style="width: 500px;">
				<tr align="center">
					<td><img width="50" height="30"
						src="/resources/img/${detail.ateamname}.jpg"></td>
					<td>vs</td>
					<td><img width="50" height="30"
						src="/resources/img/${detail.bteamname}.jpg"></td>
				</tr>
				<tr align="center">
					<td>${atrDTO.win}</td>
					<td>승</td>
					<td>${btrDTO.win}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.lose}</td>
					<td>패</td>
					<td>${btrDTO.lose}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.draw}</td>
					<td>무</td>
					<td>${btrDTO.draw}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.score}</td>
					<td>득점</td>
					<td>${btrDTO.score}</td>
				</tr>
				<tr align="center">
					<td>${atrDTO.loss}</td>
					<td>실점</td>
					<td>${btrDTO.loss}</td>
				</tr>
			</table>
		</div>
		<div class="contaner" align="center">
			<h3 align="left">댓글</h3>
			<table border="1">
				<tr>
					<td>작성자</td>
					<td>내용</td>
					<td>작성일</td>
				</tr>
				<c:forEach items="${rltmatchReply}" var="rltmatchReply">
					<tr>
						<td>${rltmatchReply.id}</td>
						<td width=80%>${rltmatchReply.content}</td>
						<td><fmt:formatDate value="${rltmatchReply.writedate}"/> </td>
					</tr>
				</c:forEach>
				<tr>
				<form>
				<td>
					<input type="text" name="id" value="${UID}">
				</td>
					<td>
						
							<input type="text" name='content' placeholder="무분별한 비방,욕설,상업적 내용 등은 삭제될 수 있음을 사전에 공지합니다." /> 
							<input type="hidden" name="gno" value="${TRDTO.gno}" /> 
							<input type="hidden" name="ateamname" value="${TRDTO.ateamname}" /> 
							<input type="hidden" name="bteamname" value="${TRDTO.bteamname}" /> 
						
						
					</td>
					<td>	<input type="button" value="등록"/></td>
					</form>
				</tr>
			</table>


		</div>
	</div>
</body>
</html>