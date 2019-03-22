<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String result = (String)request.getAttribute("result");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
<style>
	.main{
		width: 600px;
		margin: 0 auto;
		margin-top: 80px;
		border: 2px solid black;
		padding: 50px;
	}
	
	.link{
		margin-top: 20px;
	}
</style>
</head>
<body>
 	<div class= "main">
 		<div><h1>결과 페이지</h1></div>
 		<div>
 			<% if(result.equals("save")){%>
			<div>정상적으로 저장되었습니다.</div>
			<%}else if(result.equals("delete")){ %>
			<div>정상적으로 삭제되었습니다.</div>
			<%} %>
 		</div>
 		<div class="link">
 			<a href="Book.html">추가 등록</a>
 			<a href="main?action=list">도서 목록</a>
 		</div>
 	</div>
	
</body>
</html>