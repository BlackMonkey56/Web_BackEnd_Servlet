<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">1. 우승자 명단보기</h1>
	1등. ${winner[0]}<br>
	2등. ${winner[1]}<br>
	3등. ${winner[2]}<br>
	<hr>
	<h1 align="center">2. 이번달에 가장 많이 팔린 과일입니다.(포도, 오렌지 순이 되도록)</h1>
	1위 과일. ${items.get(0)}<br>
	2위 과일. ${items.get(1)}<br>
	<hr>
	<!-- 'Edgar는 Boston에 삽니다.'가 출력되오록 하세요 -->
	${param.name}는 ${map[param.name]}에 삽니다.
</body>
</html>