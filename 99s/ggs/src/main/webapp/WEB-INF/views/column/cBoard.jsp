<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title></title>
 <!-- jQuery CDN -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <style>
 	.center {text-align:center;}
 </style>	

 <script>
 $(function(){
	 //글쓰기 버튼 클릭시   id="wBtn" value="글쓰기"
	 $("#wBtn").click(function(){
		 //js를 이용해서 현재문서의 주소를 가져오기 및 변경
		 //alert('글쓰기버튼클릭:'+location.href);
		 //location.href="http://www.naver.com";
		 
		 //jQuery의 메소드를 이용
		 // 선택자의   속성값 가져오기 : 선택자.attr("속성명")
		 //alert(  $(location).attr("href") );
		 // 선택자의   속성값 변경하기 : 선택자.attr("속성명",값)
		 //$(location).attr("href","http://www.daum.net");
		 
		 //글쓰기 요청
		 $(location).attr("href","../column/writeFrm.gg");
		 
	 });
	 
	 //검색    버튼 클릭시   id="sBtn" value="검 색"/>	
	 $("#sBtn").click(function(){
		 //무결성 검사후
		 //name="word" id="word"
		 
		 //검색요청
		 $("#sFrm").submit();
	 });
		
 });
 </script>
</head>
<body>
	<a href="../admin/adminMain.gg">메인으로</a>
	<hr/>
		
	<h3>야구지식게시판 cBoard.jsp</h3>
	
	<hr/>
	
	<%-- mv.addObject("LIST", list);//실제조회목록
  		 mv.addObject("PINFO",pInfo);//페이징관련 정보
  --%>
	

	
	<%-- 검색부분 --%>
	<form id="sFrm" method="get" action="../column/boardSearch.gg">
		<table border="1" width="800" class="center">
			<tbody>
				<tr class="center">
					<td>
						<%-- 검색대상 --%>
						<select name="target" id="target">
							<option value="title" selected="selected">제목</option>
							<option value="content">내용</option>
							<option value="writer">글쓴이</option>
							<option value="all">제목+내용</option>
						</select>
						<%-- 검색키워드 --%>
						<input type="text" name="word" id="word" required="required"/>
						<input type="button" id="sBtn" value="검 색"/>						
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	
	<%-- 목록 출력 --%>
	<table border="1" width="800" class="center">
		<tbody>
			<tr>
				<th>번호</th>
				<th width="220">제목</th>
				<th width="160">작성일</th>
				<th>조회수</th>
				<th width="150">작성자</th>
				
			</tr>
			<%-- 반복문을 이용하여 줄출력 예정 --%>
			<c:forEach  items="${LIST}" var="dto">
				<tr>
					<td>${dto.writeno}</td>
					<td width="220"><a href="../column/viewsUpdate.gg?writeno=${dto.writeno}&nowPage=${PINFO.nowPage}">${dto.title}</a></td>
					<td width="160">
					<fmt:formatDate  value="${dto.writedate}" pattern="yyyy년 MM월 dd일"/>
					</td>
					<td>${dto.views}</td>
					<td width="150">${dto.id}</td>
					
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
					[이전] 
					</c:if>
				
					<c:if test="${PINFO.nowPage ne 1}">
					<a href="../column/cBoard.gg?nowPage=${PINFO.nowPage-1}">[이전]</a> 
					</c:if>
					
					<c:forEach var="pg"	 begin="${PINFO.startPage}" end="${PINFO.endPage}">
					<a href="../column/cBoard.gg?nowPage=${pg}">[${pg}]</a> 
					</c:forEach>
					
					<c:if test="${PINFO.nowPage eq PINFO.totalPage}">
					[다음]
					</c:if>
					
					<c:if test="${PINFO.nowPage ne PINFO.totalPage}">
					<a href="../column/cBoard.gg?nowPage=${PINFO.nowPage+1}">[다음]</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	
	
	<%-- 기타 기능 : 글쓰기 --%>
	<table border="1" width="800" class="center">
		<tbody>
			<tr class="center">
				<td><input type="button" id="wBtn" value="글쓰기"/></td>
			</tr>
		</tbody>
	</table>
	
	
</body>
</html>