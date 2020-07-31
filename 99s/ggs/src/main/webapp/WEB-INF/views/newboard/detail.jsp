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
				<td><h4>${NBDETAIL.id}</h4></td>
				<td><h4><fmt:formatDate value="${NBDETAIL.writedate}"
						pattern="yyyy-MM-dd HH:mm:ss"/></h4></td>
				<td><h4>${NBDETAIL.views} Hits</h4></td>
			</tr>
		</thead>
		<tbody align="center">
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
	<button type="button" class="btn btn-primary" onclick="location.href='./update?writeno=${NBDETAIL.writeno}&nowPage=${nowPage}'">수정하기</button>
	<button type="button" class="btn btn-primary" onclick="button_event();">삭제하기</button>
	</c:if>
	<button type="button" class="btn btn-primary" onclick="location.href='./list?nowPage=${nowPage}'">목록으로</button>
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