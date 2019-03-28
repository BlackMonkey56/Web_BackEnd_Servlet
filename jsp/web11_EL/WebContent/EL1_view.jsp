<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>1, 결과 페이지 정보입니다::jsp의 Expression Element사용</h2>
<b><%= request.getAttribute("RESULT") %></b><br>
<b><%= session.getAttribute("RESULT") %></b><br>
<hr>
<h2>2. 결과 페이지 정보입니다::EL사용</h2>
1) 1~100까지의 합산정보 : ${requestScope.RESULT}<br>
2) 세션의 정보 : ${sessionScope.RESULT}<br>
3) 정보출력 : ${RESULT}<br><!-- requestScope < sessionScope < applicationScope, 존재하지 않으면 NULL포인터를 반환하는 것이 아닌 아무것도 출력안함...-->
4) 정보출력2 : ${NAME}<br>
</body>
</html>