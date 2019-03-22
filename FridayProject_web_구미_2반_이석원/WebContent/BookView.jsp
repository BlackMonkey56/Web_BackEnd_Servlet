<%@page import="com.ssafy.book.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Book book = (Book)request.getAttribute("book");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.view-main{
		margin: 0 auto;
		margin-top: 80px;
		width: 600px;
		height: 700px;
		border: 2px solid black;
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	.view-table{
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	.view-table table{
		width: 80%;
		text-align: center;
	}
	
	.view-table th{
		font-size: 20px;
		background: #c7c7c7;
	}
	
	.view-table table tr{
		height: 40px;
	}
	
	.view-table table tr td:first-child{
		width: 100px;
		font-weight: bold;
		background: #c7c7c7;
	}
	
	.view-table table tr td:last-child{
		text-align: left;
		padding-left: 5px;
	}
	
	.link{
		margin-top: 50px;
	}
	
	.link a{
		padding: 5px;
	}
</style>
</head>
<body>
	<div class="view-main">
		<div><h1>입력된 도서 정보</h1></div>
		<div class="view-table">
			<table border="1">
				<tr>
					<th colspan="2">도서 정보</th>
				</tr>
				<tr>
					<td>도서명</td><td><%= book.getTitle() %></td>
				</tr>
				<tr>
					<td>도서번호</td><td><%= book.getIsbn() %></td>
				</tr>
				<tr>
					<td>도서분류</td><td><%= book.getCatalogue() %></td>
				</tr>
				<tr>
					<td>도서국가</td><td><%= book.getNation() %></td>
				</tr>
				<tr>
					<td>출판일</td><td><%= book.getPublishDate() %></td>
				</tr>
				<tr>
					<td>출판사</td><td><%= book.getPublisher() %></td>
				</tr>
				<tr>
					<td>저자</td><td><%= book.getAuthor() %></td>
				</tr>
				<tr>
					<td>도서가격</td><td><%= book.getPrice() %></td>
				</tr>
				<tr>
					<td>도서설명</td><td><%= book.getDescription() %></td>
				</tr>
			</table>
		</div>
		
		<div class="link">
			<a href="main?action=list">도서목록으로 돌아가기</a>
			<a href="main?action=delete&isbn=<%=book.getIsbn()%>">도서삭제</a>
		</div>
	</div>
</body>
</html>