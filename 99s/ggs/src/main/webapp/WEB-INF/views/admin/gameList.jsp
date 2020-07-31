<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	$(".page").click(function(){
		var pageNo=$(this).text();
		var month = $("#month").val();
		location="/admin/gameList.gg?pageNo="+pageNo+"&month="+month
	})
	$("#prev").click(function(){
		var pageNo = $("#prevv").val();
		var month = $("#month").val();
		location="/admin/gameList.gg?pageNo="+pageNo+"&month="+month
	})
	$("#next").click(function(){
		var pageNo = $("#nextv").val();
		var month = $("#month").val();
		location="/admin/gameList.gg?pageNo="+pageNo+"&month="+month
	})
})
</script>
</head>
<body>
   <div class="container">
	   <a href="/admin/teamList.gg"><button>팀 목록</button></a>
	   <a href="/admin/playerList.gg"><button>선수 목록</button></a>
	   <a href="/admin/gameList.gg"><button>경기 목록</button></a>
	   <a href="/admin/dataUpdate.gg?uri=gamelist"><button>경기 데이터 업데이트</button></a>
	   <a href="/datac/c.gg?uri=playerlist"><button>선수 데이터 업데이트</button></a>
   </div>

   <div class="container">
      <h4>경기 결과</h4>
      <nav class="navbar navbar-right">
      	<form action="/admin/gameList.gg">
		월별 조회<select name="month">
				<option value="0">월</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
		</select>
	<input type="submit" value="조회" />
	</form>
		</nav>
   		<table class="table table-hover">
   		<thead>
			<tr>
				<th>일자</th>
				<th>시간</th>
				<th>A team</th>
				<th>A score</th>
				<th>B score</th>
				<th>B team</th>
				<th>경기장</th>
				<th>정보 수정</th>
			</tr>
			</thead>
			<c:forEach items="${list }" var="game">
				<tr >
					<td><fmt:formatDate value="${game.gdate }" pattern="yyyy-MM-dd"/></td>
					<td>${game.gtime }</td>
					<td>${game.ateamname }</td>
					<c:choose>
						<c:when test="${game.ascore<0 }">
							<td colspan="2" style="padding-left: 60px">
								경기 취소
							</td>
						</c:when>
						<c:otherwise>
							<td>${game.ascore }</td>
							<td>${game.bscore }</td>
						</c:otherwise>
					</c:choose>
					
					
					<td>${game.bteamname }</td>
					<td>${game.stadium }</td>
					<td style="padding: 0"><button type="button" class="btn " data-toggle="modal" data-target="#myModal${game.gno}">수정하기</button></td>
					
					
					<!-- Modal -->
					<div id="myModal${game.gno}" class="modal fade" role="dialog">
					  <div class="modal-dialog">
					
					    <!-- Modal content-->
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">등록번호 : ${game.gno } 정보 수정하기</h4>
					      </div>
					      <form action="/admin/gameUpdate.gg">
					      <div class="modal-body">
					        A team : <input type="text" name="ateamname" value="${game.ateamname }">
					        A score : <input type="text" name="ascore" value="${game.ascore }"><br/>
					        B team : <input type="text" name="bscore" value="${game.bscore}">
					        B score : <input type="text" name="bteamname" value="${game.bteamname }"><br/>
					        경기장 : <input type="text" name="stadium" value="${game.stadium }">
					        시간 : <input type="text" name="gtime" value="${game.gtime }"><br/>
					        <input type="hidden" name="pageNo" value="${pageInfo.nowPage}">
					        <input type="hidden" name="gno" value="${game.gno}">
					      </div>
					      <div class="modal-footer">
					      	<button type="submit" class="btn btn-default">수정하기</button>
					        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					      </div>
					      </form>
					    </div>
					
					  </div>
					</div>
					
					
				</tr>
			</c:forEach>
			<tfoot>
				<tr align="center"><td colspan="8">
				<a id="prev">
				<c:if test="${pageInfo.startPage>1}">
					<input type="hidden" id="prevv" value="${pageInfo.nowPage-1}">&lt;prev
				</c:if>
				</a>
				<c:forEach var="i" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
					<c:choose>
						<c:when test="${pageInfo.nowPage==i}"><b>[<a class="page">${i}</a>]</b></c:when>
						<c:otherwise>[<a class="page">${i}</a>]</c:otherwise>
					</c:choose>
				</c:forEach>
				<a id="next">
					<c:if test="${pageInfo.endPage<pageInfo.totalPage}">
						<input type="hidden" id="nextv" value="${pageInfo.nowPage+1}">next&gt;
					</c:if>
				</a>
				</td></tr>
			</tfoot>
		</table>
			<input type="hidden" id="month" value="${month}">
		${result }
   </div>
</body>
</html>