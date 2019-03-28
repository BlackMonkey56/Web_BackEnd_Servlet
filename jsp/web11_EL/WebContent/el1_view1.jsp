<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 상품정보를 EL로 출력합니다.</h2>
	상품명 : ${product.name }<br> <!-- product.getName() -->
	상품가격 : ${product.price }<br><!-- product.getPrice() -->
	상품정보 : ${product}<br>
</body>
</html>