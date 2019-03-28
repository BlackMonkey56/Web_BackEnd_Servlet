<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. form에 입력된 값을 받아왔습니다...</h2>
	ID : <%= request.getParameter("id") %><br>
	Pets : <br>
		<% 
			String[] pets = request.getParameterValues("pet"); 
			for(String pet : pets){
				out.println("<li>"+pet+"</li>");
			}
		%>
	<hr>
	<h2>2. form에 입력된 값::EL사용</h2>
	ID : ${param.id} <br>
	Pets : <br>
	${paramValues.pet[0]},
	${paramValues.pet[1]},
	${paramValues.pet[2]},
	${paramValues.pet[3]},
	${paramValues.pet[4]}
</body>
</html>