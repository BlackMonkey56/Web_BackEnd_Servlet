<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<script>
	window.onload = function(){
		var logout = document.getElementById('logout');
		
		logout.onclick = logOut;
	}
	
	function logOut(){
		alert("로그아웃 되었습니다...");
		
	}
</script>
<body>
	<% 
		Member member = (Member)session.getAttribute("member"); 
    	if(member == null){%>
    		<script>
    			alert("로그인부터 하세요..");
    			location.href = "loginForm.html";
    		</script>
    	<%}
		System.out.println("2: " + session.getId());
	%>
	
	ID: <%= member.getId() %> <br><br>
	PASSWORD: <%= member.getPassword() %> <br><br>
	NAME: <%= member.getName() %> <br><br>
	ADDRESS: <%= member.getAddress() %> <br><br>
	<% System.out.println(session.getId()); %>
	<a href="logout.jsp">LogOut</a>
	<a href="loginForm.html">Home</a>
</body>
</html>