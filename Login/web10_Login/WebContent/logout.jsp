<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	Member member = (Member)session.getAttribute("member");
    	if(member != null){
    		session.invalidate(); 
    	}else{
    		//다시 홈으로
    		response.sendRedirect("loginForm.html");
    	}
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logoutpopup(){
		alert("로그 아웃!!!");
	}
</script>
</head>
<body onload="return logoutpopup()">
	<b>로그아웃 되셨습니다.</b>
	<a href="loginForm.html">다시 홈으로</a>
</body>
</html>