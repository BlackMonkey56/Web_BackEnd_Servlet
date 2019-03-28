<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "CODE" value="1004"/>
<c:set var = "NAME" value="SSAFY" scope="request"/>
<c:set var = "PRICE" value="12000" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품코드 : ${CODE}
	<%-- <jsp:forward page="cset3_result.jsp"></jsp:forward> --%>
	<%-- <c:redirect url="cset3_result.jsp"></c:redirect> --%>
	
	<!-- including의 2가지 방법 -->
	<!-- 동적인 문서를 인클루딩할 때 -->
	<%-- <jsp:include page="test.html"></jsp:include> --%>
	<!-- 정적인 문서를 인클루딩할 때 -->
	<%@ include file="test.html" %>
	
	<br>
	<b>이 부분도 출력 될까요?</b>
</body>
</html>