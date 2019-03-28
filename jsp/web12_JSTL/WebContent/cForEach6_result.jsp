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
1. EL로 출력하기<br>
${menus[0]},
${menus[1]},
${menus[2]},
${menus[3]}

<hr>

2.JSTL로 출력하기
<ul>
	<%-- <c:forEach var="menu" items="${menus}">
		<li>${menu}</li>
	</c:forEach> --%>
	
	<c:forEach var="menu" items="${menus}" varStatus="i">
		${i.count}.${menu}
	</c:forEach>
</ul>

</body>
</html>