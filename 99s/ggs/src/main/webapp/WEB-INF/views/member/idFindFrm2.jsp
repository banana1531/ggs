<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head title="아이디 찾기">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script>
   $(function(){      
      $('#mailAuthChk').click(function(){
         var chkNum= $('#chkNum').val();
         var conNum = $('#conNum').val();
         if(chkNum!=conNum){
            window.alert("인증번호가 일치하지 않습니다.");
         }else{
            var r = confirm("인증번호가 일치합니다");
            $('#idFindProc').click(function(){
            if(r==true){$('#idProcFrm').submit();}
            })
         }         
      })   
   })
   </script>
</head>
<body>
   <h2>아이디 찾기</h2>
   <hr />
   <form id="idProcFrm" action="../member/idFindProc.gg" method="post">
      <table>
         <c:if test="${msg=='fail'}">
            <tr>
               <td colspan="2">이름또는 이메일이 다릅니다.</td>
            </tr>
         </c:if>
         <tr>
            <td><label for="name">이름:</label></td>
            <td><input type="text" name="name" value="${result.name}"/></td>
         </tr>
         <tr>
            <td><label for="email">이메일:</label></td>
            <td><input type="text" name="email" value="${result.email}"/></td>
            <td><button id="mailAuth" type="button">인증번호 받기</button></td>
         </tr>
         <tr>
            <td><label for="memail">인증번호 입력:</label></td>
            <td><input id="chkNum" type="text"></td>
            <td><input id="mailAuthChk" type="button" value="인증번호 확인" /></td>
            <td><input type="hidden" id="conNum" value="${num}" /></td>
         </tr>
         <tr class="center">
            <td></td>
            <td colspan="2">
               <input id="idFindProc" type="button" value="아이디 찾기">
            </td>
         </tr>
      </table>
   </form>
</body>
</html>