<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$("#back").click(function(){
		var pno=$('input[name=pno]').val();
		location = "/admin/playerDetail.gg?pno="+pno
	})
})
</script>
<style>

input {
  width:120px;
}


</style>
</head>
<body>
   <div class="container" style="margin-top: 20px">
	   <a href="/admin/teamList.gg"><button>팀 목록</button></a>
	   <a href="/admin/playerList.gg"><button>선수 목록</button></a>
	   <a href="/admin/gameList.gg"><button>경기 목록</button></a>
	   <button id="back">앞으로 가기</button>
   </div>
	<div class="container">
	<form class="form-inline" action="/admin/playerRecordUpdate.gg">
		<table >
			<tr>
				<td colspan="2">data 관리번호:<input type="text" name="pgno" value="${player.pgno}" readonly="readonly" style="border: none;"></td>
				<td colspan="3">선수 관리번호:<input type="text" name="pno" value="${player.pno}" readonly="readonly" style="border: none;"></td>
				<td colspan="4">이름 : <input type="text" name="name" value="${player.name}" readonly="readonly" style="border: none;"></td>
			</tr>
			
			<tr>
				<td>소속팀</td>
				<td>포지션</td>
				<td>경기일자</td>
				<td>상대팀</td>
				<td>경기결과</td>
				<td>선발유무</td>
				<td>이닝</td>		
				<td>실점</td>	
			</tr>
			
			<tr>
				<td><input type="text" name="pno" value="${player.teamname}"></td>
				<td><input type="text" name="pno" value="${player.ptype}"></td>
				<td><input type="text" name="pno" value="${player.gdate}"></td>
				<td><input type="text" name="pno" value="${player.vs}"></td>
				<td><input type="text" name="gresult" value="${player.gresult}"></td>
				<td><input type="text" name="pno" value="${player.sunbal}"></td>
				<td><input type="text" name="pno" value="${player.ining}"></td>
				<td><input type="text" name="pno" value="${player.siljum}"></td>
			</tr>
			<tr><td colspan="8"><hr/></td></tr>
			<tr>
				
				<td>자책점</td>
				<td>상대한 타자수</td>
				<td>상대한 타수</td>
				<td>피 안타</td>
				<td>피 2루타</td>
				<td>피 3루타</td>	
				<td>피 홈런</td>
				<td>볼넷</td>		
			</tr>
			<tr>
			
				<td><input type="text" name="pno" value="${player.jachak}"></td>
				<td><input type="text" name="pno" value="${player.taja}"></td>
				<td><input type="text" name="pno" value="${player.tasu}"></td>
				<td><input type="text" name="pno" value="${player.anta}"></td>
				<td><input type="text" name="pno" value="${player.eta}"></td>
				<td><input type="text" name="pno" value="${player.samta}"></td>
				<td><input type="text" name="pno" value="${player.home_run}"></td>
				<td><input type="text" name="pno" value="${player.ball4}"></td>
			</tr>
			<tr><td colspan="8"><hr/></td></tr>
			<tr>
				
				<td>고의 4구</td>
				<td>사구</td>
				<td>삼진</td>
				<td>투구수</td>
				<td>whip</td>	
				<td>타율</td>
			<td></td>
			<td></td>		
			</tr>
			
			
			
			<tr>
				
				<td><input type="text" name="pno" value="${player.go4}"></td>
				<td><input type="text" name="pno" value="${player.sagu}"></td>
				<td><input type="text" name="pno" value="${player.samjin}"></td>
				<td><input type="text" name="pno" value="${player.tugu}"></td>
				<td><input type="text" name="pno" value="${player.whip}"></td>
				<td><input type="text" name="pno" value="${player.tayul}"></td>
				<td><input type="text" name="pno" value="${player.culu}"></td>
				<td><input type="text" name="pno" value="${player.ops}"></td>
			</tr>
			<tr><td colspan="8"><hr/></td></tr>
			
			<tr>
				<td>era</td>
				<td>avLI</td>
				<td>RE24</td>
				<td>WPA</td>	
				<td>GSC</td>
				<td>DEC</td>
				<td>간격</td>
				<td>타순</td>		
			</tr>
			
			
			<tr>
				
				<td><input type="text" name="pno" value="${player.era}"></td>
				<td><input type="text" name="pno" value="${player.avli}"></td>
				<td><input type="text" name="pno" value="${player.re24}"></td>
				<td><input type="text" name="pno" value="${player.wpa}"></td>
				<td><input type="text" name="pno" value="${player.gsc}"></td>
				<td><input type="text" name="pno" value="${player.gdec}"></td>
				<td><input type="text" name="pno" value="${player.gangyuk}"></td>
				<td><input type="text" name="pno" value="${player.tasun}"></td>
			</tr>
			<tr><td colspan="8"><hr/></td></tr>
			<tr>
				<td>P</td>
				<td>득점</td>
				<td>루타</td>
				<td>타점</td>
				<td>도루</td>
				<td>도실</td>
				<td>병살</td>	
				<td>희타</td>			
			</tr>
			
			
			
			<tr>
				<td><input type="text" name="pno" value="${player.p}"></td>
				<td><input type="text" name="pno" value="${player.djum}"></td>
				<td><input type="text" name="pno" value="${player.ruta}"></td>
				<td><input type="text" name="pno" value="${player.tajum}"></td>
				<td><input type="text" name="pno" value="${player.doru}"></td>
				<td><input type="text" name="pno" value="${player.dosil}"></td>
				<td><input type="text" name="pno" value="${player.byungsal}"></td>
				<td><input type="text" name="pno" value="${player.hita}"></td>
			</tr>
			<tr><td colspan="8"><hr/></td></tr>
			<tr>
				<td>희비</td>
				<td>장타</td>			
			</tr>
			
			
			
			
			<tr>
				<td><input type="text" name="pno" value="${player.hibi}"></td>
				<td><input type="text" name="pno" value="${player.jangta}"></td>
			</tr>
			<tr><td colspan="8"><hr/></td></tr>
			<tr><td colspan="8" align="right"><button type="submit">정보 수정</button></td></tr>
			</table>
			
			</form>
			
			${result }
	</div>
</body>
</html>