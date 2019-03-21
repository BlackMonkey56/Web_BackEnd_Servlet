<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 
    	Attribute에 바인딩된 데이터 가져와서 : getAttribute()
    	그 데이터를 출력한다.
     -->
<%
	//HashMap userList = (HashMap)application.getAttribute("userList");
	HashMap userList = (HashMap)request.getAttribute("userList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		ID : <%= userList.get("id") %> <br>
		Pass : <%= userList.get("pass") %> <br>
		Name : <%= userList.get("name") %> <br>
</body>
</html>