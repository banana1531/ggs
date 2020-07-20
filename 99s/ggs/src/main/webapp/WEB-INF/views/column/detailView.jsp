<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title></title>
 <!-- jQuery CDN -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

 <script>
 $(function(){
	 	//목록보기 버튼 클릭시 id="lBtn" value=""
	  $("#lBtn").click(function(){
		  $(location).attr("href","../column/cBoard.gg?nowPage=${nowPage}");
	  });
	 
		//수정하기 버튼 클릭시
		$("#mBtn").click(function(){
			//수정하기 폼 보여줘 요청
			$(location).attr("href","../column/modifyFrm.gg?writeno=${BDTO.writeno}&nowPage=${nowPage}");
		});
		
		//삭제버튼클릭시
		 $("#dBtn").click(function(){
			  const del = confirm('게시글을 삭제하시겠습니까?');
			 
				if( del==true ){
					alert("삭제되었습니다.");
					$(location).attr("href","../column/delBoard?writeno=${BDTO.writeno}&nowPage=${nowPage}");
				}else{
					alert("삭제를 취소하였습니다.")
				}
				
		 });

 });
 </script>
</head>
<body>
		<a href="../column/cBoard.gg">목록으로</a>
	<hr/>

	<h3>detailView.jsp</h3>

	<hr/>	
	

	<!-- 	상세보기 내용 출력	-->
	<table border="1" width="600">
		<tr>
			<th width="100">글번호</th>
			<td>${BDTO.writeno}</td>
		</tr>
		<tr>
			<th width="100">작성자</th>
			<td>${BDTO.id}</td>
		</tr>
		<tr>
			<th width="100">작성일</th>
			<td>${BDTO.writedate}</td>
		</tr>
		<tr>
			<th width="100">조회수</th>
			<td>${BDTO.views}</td>
		</tr>
		<tr>
			<th width="100">제  목</th>
			<td>${BDTO.title}</td>
		</tr>
		<tr>
			<th width="100">내  용</th>
			<td>${BDTO.content}</td>
		</tr>
	</table>



	<!-- 	기타 기능 만들고	-->
	<table width="600" border="1" >
		<tr>
			<td align="center">
				<input type="button" id="lBtn" value="목록보기">
				
				<%--해당글을 쓴사람이라는 의미는
				          해당글쓴이의 정보와     로그인한 유저의정보가 같다 --%>
				<c:if test="${BDTO.id eq sessionScope.UID}">
					<input type="button" id="mBtn" value="수정하기">
					<input type="button" id="dBtn" value="삭제하기">
				</c:if>
			</td>
		</tr>
	</table>
	

</body>
</html>