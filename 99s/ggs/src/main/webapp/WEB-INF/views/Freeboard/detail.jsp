<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	pageContext.setAttribute("replaceChar", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자유 게시판</title>
<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		//listReply(); //댓글 목록 불러오기
		listReply2(); //json 리턴방식
		
		//댓글 쓰기 버튼 클릭 이벤트(ajax로 처리)
		$("#btnReply").click(function(){
			var content = $("#content").val();
			var wno = "${NBDETAIL.writeno}"
			var param = "content="+content+"&wno="+wno;
			if(!$("#content").val()) { 
				alert("댓글을 입력하세요");
				$("#content").focus();
				return false;
			}
			$.ajax({
				type : "post",
				url : "../reply/insert",
				data : param,
				success : function(){
					alert("댓글이 등록되었습니다.");
					listReply2();
					$("#content").val("");
				}
			});
		});
		
		//수정/삭제 권한 체크
		var boardM = '${UBOARDM}';		
		$('#update').click(function(){
			if(boardM!='1'){
				alert("해당 권한이 없습니다.")
			}else{
				location = '/freeboard/update?writeno=${NBDETAIL.writeno}&nowPage=${nowPage}'
			}
			
		})
		$('#delete').click(function(){
			if(boardM!='1'){
				alert("해당 권한이 없습니다.")
			}else{
				button_event();
			}
			
		})
		
		
	});
	
	//Controller방식
	//댓글 목록1
	function listReply(){
		$.ajax({
			type : "get",
			url : "../reply/list?wno=${NBDETAIL.writeno}",
			success : function(result){
			//responseText가 result에 저장됨
				$("#listReply").html(result);
			}
		});
	}
	
	//RestController방식 (json)
	//댓글 목록2(json)
	function listReply2(){
		$.ajax({
			type : "get",
			//contentType : "application/json" ==> 생략가능(RestController이기 때문에 가능)
			url : "../reply/listJson?wno=${NBDETAIL.writeno}",
			success : function(result){
				console.log(result);
				var output = "<table class='table'>";
				for (var i in result){
					output += "<tr>";
					output += "<td><h5>"+result[i].id;
					output += " ("+changeDate(result[i].writedate)+")</h5>";
					output += result[i].content+"</td>";
					output += "<tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
	
	//날짜 변환 함수 작성
	function changeDate(date){
		date = new Date(parseInt(date));
		year = date.getFullYear();
		month = date.getMonth()+1;
		day = date.getDate();
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
		strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
		return strDate;
	}
	
	function button_event(){
		if (confirm("정말 삭제하시겠습니까?") == true){
		    alert("삭제되었습니다");
		    location.href = "./delete?writeno=${NBDETAIL.writeno}&nowPage=${nowPage}";
		}else{
		    return;
		}
	}
	
</script>
<style>
.center {
	text-align: center;
}
</style>
</head>
<body>
<div class="container">
	<table class="table">
		<thead align="center">
			<tr>
				<td><h4>No.${NBDETAIL.writeno}</h4></td>
				<td><h4>작성자 :${NBDETAIL.id}</h4></td>
				<td><h4>작성일 :<fmt:formatDate value="${NBDETAIL.writedate}"
						pattern="yyyy-MM-dd HH:mm:ss"/></h4></td>
				<td><h4>조회수 : ${NBDETAIL.views} Hits</h4></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4"><h1>${NBDETAIL.title}</h1></td>
			</tr>
			<tr>
				<td colspan="4"><h2>${fn:replace(NBDETAIL.content, replaceChar, "<br/>")}</h2></td>
			</tr>
		</tbody>
	</table>
</div>
<div class="container" align="right">
	<c:if test="${UID == NBDETAIL.id}">
	<button type="button" id="update" class="btn btn-primary" >수정하기</button>
	<button type="button" id="delete" class="btn btn-primary" >삭제하기</button>
	</c:if>
	<button type="button" class="btn btn-primary" onclick="location.href='./list?nowPage=${nowPage}'">목록으로</button>
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">글
				신고하기</button>
	<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title" align="left">글 신고하기</h4>
						</div>
						<form class="form-inline" action="/decInsert.gg">
							<div class="modal-body" align="left">
								글번호 : <input name="writeno" value="${NBDETAIL.writeno}"readonly="readonly" style="border: none;"><br /> 
								게시판 :<input name="boardname" value="${NBDETAIL.boardname}"readonly="readonly" style="border: none;"><br /> 
								사유 :	<input type="radio" name="reason" value="홍보성">홍보성 
								<input type="radio" name="reason" value="불법정보">불법정보
								<input type="radio" name="reason" value="선정성">선정성
								<input type="radio" name="reason" value="욕설">욕설
								<input type="radio" name="reason" value="개인정보 노출">개인정보 노출
								<input type="radio" name="reason" value="기타">기타
								 <br /> 
								상세 내용(필요시기재):<br />
								<textarea name="details" style="width: 550px; height: 200px"></textarea>
								<br />
								<input type="hidden" name="id" value="${UID}">
								<input type="hidden" name="nowPage" value="${nowPage}">								
								<input type="hidden" name="views" value="${NBDETAIL.views}">
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-default" id="dec">신고 등록</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">닫기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			
</div>
	<div class="container">
	<table class="table">
		<tr>
			<td width="90%"><textarea class="form-control col-sm-5" rows="5"  id="content" placeholder="댓글을 입력해 주세요"></textarea></td>
			<td width="10%"><button type="button" class="btn btn-primary btn-lg" style="width:80pt;height:80pt;"  id="btnReply">댓글 작성</button></td>
		</tr>
	</table>
	</div>
	<div class="container" id="listReply"></div>
</body>
</html>