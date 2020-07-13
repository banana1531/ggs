<!-- sitemesh 사용을 위한 설정 파일 -->
<!-- 작성자 : 이영환 -->
<!-- 작성일 : 2020-06-30 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>99s:<decorator:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-3d.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style type="text/css">
header, footer {
	background: AntiqueWhite;
}

pre {
	background: white;
	border: 0px;
}

/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: black;
	padding: 25px;
	color: #ddd;
}

.carousel-inner img {
	width: 100%; /* Set width to 100% */
	margin: auto;
	min-height: 200px;
}

/* Hide the carousel text when the screen is less than 600 pixels wide */
@media ( max-width : 600px) {
	.carousel-caption {
		display: none;
	}
}

article {
	min-height: 400px;
	margin-top: 80px;
}

#welcome {
	color: grey;
	margin: 0 auto;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>
<decorator:head/>
</head>
<body>
	<header>
<!-- 		<div><img href="#"/></div> -->
		<nav class="navbar navbar-inverse">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">99s</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Home</a></li>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">자유 게시판</a></li>
					<li><a href="#">정보 오류 신고</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown">경기 일정<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">경기 일정</a></li>
							<li><a href="#">경기 결과</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown"> 팀/선수 정보 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">팀 정보</a></li>
							<li><a href="#">선수 정보</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown"> 통계 기록실 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/history/hBoard.gg">역대 관중 현황</a></li>
							<li><a href="/obesity/oBoard.gg">비만도와 실적관계</a></li>
							<li><a href="/column/cBoard.gg">야구 지식 정보</a></li>
						</ul></li>
					<c:choose>
						<c:when test="${UID!='admin'}">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown"> My Page <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="/mypage/mypageMain.gg">My Page</a></li>
									<li><a href="/mypage/myTeamDetail.gg">My Team 정보</a></li>
									<li><a href="/mypage/myTeamSchedule.gg">My Team 경기일정</a></li>
									<li><a href="/mypage/checkPw.gg">내정보 수정</a></li>
								</ul></li>
						</c:when>
						<c:otherwise>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown">관리자 페이지<span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="/admin/adminMain.gg">전체현황</a></li>
									<li><a href="/admin/deSummary.gg">신고처리</a></li>
									<li><a href="/admin/memberSummary.gg">회원관리</a></li>
									<li><a href="/admin/dataMain.gg">data관리</a></li>
								</ul></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<c:choose>
						<c:when test="${UID != null }">
							<li><a href="/member/loginFrm.gg"><span
									class="glyphicon glyphicon-log-in"></span> Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/member/loginFrm.gg"><span
									class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		
		</nav>
	</header>
	<article>
		<decorator:body />
	</article>
	<footer class="container-fluid text-center navbar navbar-inverse navbar-fixed-bottom">
		<p>이 홈페이지는 팀 '구로구기러기'에 의해 제작되었습니다.<br/>
		개발자 구성원 : 강동혁, 김아리, 박종수, 이준, 최현우, 황민동</p>
	</footer>
</body>
</html>