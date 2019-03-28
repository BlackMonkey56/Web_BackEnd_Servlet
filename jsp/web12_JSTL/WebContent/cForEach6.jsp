<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] menus = {"삼계탕", "탕수육", "육개장", "장터국수","수제비"};
		request.setAttribute("menus", menus);
	%>
	
	<jsp:forward page="cForEach6_result.jsp"></jsp:forward>
</body>
</html>