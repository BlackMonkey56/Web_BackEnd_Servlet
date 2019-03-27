	<%--
    	jsp에서의 자동으로 제공되는 내장객체들
    	
    	request
    	response
    	session
    	application
    	exception
    	
    --%>
	<!-- 이 부분은 html 주석입니다. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <%
	    request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>session 정보를 출력합니다..</h2>
	<b><%= session.getId() %><br>
    <%= session.getAttribute("person") %></b><br>
    <%
    	if(session.getAttribute("person") != null){
    		session.invalidate();
    		%>
    		<script>
    			alert("로그아웃 하셨습니다...")
    			location.href="session.html";
    		</script><%
    	}else{
    		response.sendRedirect("session.html");
    	}
    %>
</body>
</html>