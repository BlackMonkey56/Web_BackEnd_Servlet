<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberCafe MODEL2 회원관리 :: JSP 기본 Element 사용</h1><p>
<%--
	로그인하지 않은 사용자는 단순한 회원검색, 로그인, 회원 가입 기능만 할수 있도록 한다
	로그인 한 사용자는 단순한 회원검색, 전체회원보기,회원정보수정, 로그아웃 기능을 할수 있도록 한다
 --%>
 <a href="find.jsp" >회원 검색</a><br>
 <%
 	Member rvo = (Member)session.getAttribute("vo");
 	if(rvo!=null){ //로그인한 상태라면...
 %>
 <a href="update.jsp" >회원 정보 수정</a><br>
 <a href="selectAddress.jsp" >주소별 검색</a><br> 
 <%
 	}else{ //로그인 안한 상태라면
 %>
 <a href="login.jsp" >로그인 </a><br>
 <a href="register.jsp" >회원 가입</a><br>
 <%
 	}
 %>
</body>
</html>




















