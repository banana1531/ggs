<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>선수정보 게시판</title>
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
<div class="container">
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=KIA' "><img width="50" height="30" src="/resources/img/KIA.jpg"><br/>KIA</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=KT' "><img width="50" height="30" src="/resources/img/KT.jpg"><br/>KT</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=LG' "><img width="50" height="30" src="/resources/img/LG.jpg"><br/>LG</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=NC' "><img width="50" height="30" src="/resources/img/NC.jpg"><br/>NC</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=SK' "><img width="50" height="30" src="/resources/img/SK.jpg"><br/>SK</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=두산' "><img width="50" height="30" src="/resources/img/두산.jpg"><br/>두산</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=롯데' "><img width="50" height="30" src="/resources/img/롯데.jpg"><br/>롯데</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=삼성' "><img width="50" height="30" src="/resources/img/삼성.jpg"><br/>삼성</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=키움' "><img width="50" height="30" src="/resources/img/키움.jpg"><br/>키움</button>
	<button type="button" class="btn btn-default" onclick="location.href='../player/teamList.gg?teamname=한화' "><img width="50" height="30" src="/resources/img/한화.jpg"><br/>한화</button>
	<button type="button" class="btn btn-default" onclick="location.href='./list.gg' "><img width="50" height="30" src="/resources/img/top5.PNG"><br/>선수 Top5</button>
	<hr/>
	<div class="container">
		<table class="table">
			<thead>
				<tr class="info">
					<th class="text-center">선수번호</th>
					<th class="text-center">이름</th>
					<th class="text-center">등번호</th>
					<th class="text-center">생년월일</th>
					<th class="text-center">포지션</th>
					<th class="text-center">키</th>
					<th class="text-center">몸무게</th>
					<th class="text-center">입단년도</th>
					<th class="text-center">소속팀</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${common}" var="dto">
					<tr>
						<th class="text-center">${dto.pno}</th>
						<th class="text-center">${dto.name}</th>
						<th class="text-center">${dto.labelno}</th>
						<th class="text-center">${dto.birth}</th>
						<th class="text-center">${dto.position}</th>
						<th class="text-center">${dto.height}</th>
						<th class="text-center">${dto.weight}</th>
						<th class="text-center">${dto.joinday}</th>
						<th class="text-center">${dto.teamname}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table">
			<thead>
				<tr class="info">
					<th class="text-center">타율</th>
					<th class="text-center">경기수</th>
					<th class="text-center">안타</th>
					<th class="text-center">홈런</th>
					<th class="text-center">타점</th>
					<th class="text-center">득점</th>
					<th class="text-center">삼진</th>
					<th class="text-center">사사구</th>
					<th class="text-center">도루</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${batter2}" var="dto">
					<tr>
						<th class="text-center">${dto.tayul}</th>
						<th class="text-center">${dto.sunbal}</th>
						<th class="text-center">${dto.anta}</th>
						<th class="text-center">${dto.home_run}</th>
						<th class="text-center">${dto.tajum}</th>
						<th class="text-center">${dto.djum}</th>
						<th class="text-center">${dto.samjin}</th>
						<th class="text-center">${dto.sagu}</th>
						<th class="text-center">${dto.doru}</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table">
			<thead>
				<tr class="info">
					<th class="text-center">경기일자</th>
					<th class="text-center">상대팀</th>
					<th class="text-center">경기결과</th>
					<th class="text-center">타선</th>
					<th class="text-center">포지션</th>
					<th class="text-center">타수</th>
					<th class="text-center">총안타</th>
					<th class="text-center">2루타</th>
					<th class="text-center">3루타</th>
					<th class="text-center">홈런</th>
					<th class="text-center">볼넷</th>
					<th class="text-center">고의4구</th>
					<th class="text-center">사구</th>
					<th class="text-center">삼진</th>	
					<th class="text-center">득점</th>
					<th class="text-center">루타</th>
					<th class="text-center">타점</th>
					<th class="text-center">도루</th>
					<th class="text-center">도실</th>
					<th class="text-center">병살</th>
					<th class="text-center">희타</th>
					<th class="text-center">희비</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${batter}" var="dto">
					<tr>
						<th class="text-center">${dto.gdate}</th>
						<th class="text-center">${dto.vs}</th>
						<th class="text-center">${dto.gresult}</th>
						<th class="text-center">${dto.tasun}</th>
						<th class="text-center">${dto.p}</th>
						<th class="text-center">${dto.tasu}</th>
						<th class="text-center">${dto.anta}</th>
						<th class="text-center">${dto.eta}</th>
						<th class="text-center">${dto.samta}</th>
						<th class="text-center">${dto.home_run}</th>
						<th class="text-center">${dto.ball4}</th>
						<th class="text-center">${dto.go4}</th>
						<th class="text-center">${dto.sagu}</th>
						<th class="text-center">${dto.samjin}</th>
						<th class="text-center">${dto.djum}</th>
						<th class="text-center">${dto.ruta}</th>
						<th class="text-center">${dto.tajum}</th>
						<th class="text-center">${dto.doru}</th>
						<th class="text-center">${dto.dosil}</th>
						<th class="text-center">${dto.byungsal}</th>
						<th class="text-center">${dto.hita}</th>
						<th class="text-center">${dto.hibi}</th>
					</tr>
				</c:forEach>
				
				<tr class="center">
					<td colspan="22">
				
						<c:if test="${PINFO.nowPage ne 1}">
						<a href="../player/info.gg?pno=${pno}&&position=${position}&nowPage=${PINFO.nowPage-1}">[prev]</a> 
						</c:if>
						
						<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
						<a href="../player/info.gg?pno=${pno}&&position=${position}&nowPage=${pg}">[${pg}]</a> 
						</c:forEach>
										
						<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
						<a href="../player/info.gg?pno=${pno}&&position=${position}&nowPage=${PINFO.nowPage+1}">[next]</a>
						</c:if>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>