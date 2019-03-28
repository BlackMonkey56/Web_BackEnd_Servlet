<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set :: 변수를 지정하는 기능</title>
</head>
<body>
	<c:set var="num1" value="7"/>
	<c:set var="num2" value="9"/>
	
	<%--jsp 주석입니다. --%>
	<!--html 주석입니다. -->
	
	<%--multiple이라는 변수를 선언하고 num1과 num2를 곱한 값으로 할당 --%>
	<%--Attribute에 값을 바인딩하는 원리 --%>
	<c:set var="multiple" value="${num1*num2}" scope="request"/>
	
	<b>${num1 }과 ${num2 }의 곱은 ${multiple }</b>
	
	<jsp:forward page="cset2_result.jsp"/>
</body>
</html>