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
	<a href="../player/teamList?teamname=KIA">KIA</a>
	<a href="../player/teamList?teamname=KT">KT</a>
	<a href="../player/teamList?teamname=LG">LG</a>
	<a href="../player/teamList?teamname=NC">NC</a>
	<a href="../player/teamList?teamname=SK">SK</a>
	<a href="../player/teamList?teamname=두산">두산</a>
	<a href="../player/teamList?teamname=롯데">롯데</a>
	<a href="../player/teamList?teamname=삼성">삼성</a>
	<a href="../player/teamList?teamname=키움">키움</a>
	<a href="../player/teamList?teamname=한화">한화</a>
	<br/>	
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>선수번호</th>
				<th>이름</th>
				<th>등번호</th>
				<th>생년월일</th>
				<th>포지션</th>
				<th>키</th>
				<th>몸무게</th>
				<th>입단년도</th>
				<th>소속팀</th>
			</tr>
			<c:forEach items="${common}" var="dto">
				<tr>
					<th>${dto.pno}</th>
					<th>${dto.name}</th>
					<th>${dto.labelno}</th>
					<th>${dto.birth}</th>
					<th>${dto.position}</th>
					<th>${dto.height}</th>
					<th>${dto.weight}</th>
					<th>${dto.joinday}</th>
					<th>${dto.teamname}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>타율</th>
				<th>경기수</th>
				<th>안타</th>
				<th>홈런</th>
				<th>타점</th>
				<th>득점</th>
				<th>삼진</th>
				<th>사사구</th>
				<th>도루</th>
			</tr>
			<c:forEach items="${batter2}" var="dto">
				<tr>
					<th>${dto.tayul}</th>
					<th>${dto.sunbal}</th>
					<th>${dto.anta}</th>
					<th>${dto.home_run}</th>
					<th>${dto.tajum}</th>
					<th>${dto.djum}</th>
					<th>${dto.samjin}</th>
					<th>${dto.sagu}</th>
					<th>${dto.doru}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>경기일자</th>
				<th>상대팀</th>
				<th>경기결과</th>
				<th>타선</th>
				<th>포지션</th>
				<th>타수</th>
				<th>총안타</th>
				<th>2루타</th>
				<th>3루타</th>
				<th>홈런</th>
				<th>볼넷</th>
				<th>고의사구</th>
				<th>사구</th>
				<th>삼진</th>	
				<th>득점</th>
				<th>루타</th>
				<th>타점</th>
				<th>도루성공</th>
				<th>도루실패</th>
				<th>병살</th>
				<th>희타</th>
				<th>희비</th>
			</tr>
			<c:forEach items="${batter}" var="dto">
				<tr>
					<th>${dto.gdate}</th>
					<th>${dto.vs}</th>
					<th>${dto.gresult}</th>
					<th>${dto.tasun}</th>
					<th>${dto.p}</th>
					<th>${dto.tasu}</th>
					<th>${dto.anta}</th>
					<th>${dto.eta}</th>
					<th>${dto.samta}</th>
					<th>${dto.home_run}</th>
					<th>${dto.ball4}</th>
					<th>${dto.go4}</th>
					<th>${dto.sagu}</th>
					<th>${dto.samjin}</th>
					<th>${dto.djum}</th>
					<th>${dto.ruta}</th>
					<th>${dto.tajum}</th>
					<th>${dto.doru}</th>
					<th>${dto.dosil}</th>
					<th>${dto.byungsal}</th>
					<th>${dto.hita}</th>
					<th>${dto.hibi}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- 페이징 처리 --%>
	<table border="1" width="800" class="center">
		<tbody>
			<tr class="center">
				<td>
					<c:if test="${PINFO.nowPage eq 1}">
					[prev] 
					</c:if>
				
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="../player/info?pno=${pno}&&position=${position}&nowPage=${PINFO.nowPage-1}">[prev]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../player/info?pno=${pno}&&position=${position}&nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[next]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../player/info?pno=${pno}&&position=${position}&nowPage=${PINFO.nowPage+1}">[next]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	<a href="./list">리스트로 가기</a>
</body>
</html>