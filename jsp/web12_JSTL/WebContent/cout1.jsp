<!--
jstl(jsp태그 라이브러리)
jstl기술을 하기 위해서는
1. jar파일 두 개가 있어야 한다.(standard.jar | jstl.jar) 
2. directive element(지시어)에 taglib 속성을 추가
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out :: jstl에서 출력을 담당하는 기능</title>
</head>
<body>
	<c:out value="오늘 점심메뉴는 무엇일까요?"></c:out><br>
	<c:out value="<h1>오늘 점심메뉴는 무엇일까요?</h1>"></c:out><br>
	<c:out value="<h1><font color=red>오늘 점심메뉴는 무엇일까요?</font></h1>" escapeXml="false"></c:out><br>
</body>
</html>