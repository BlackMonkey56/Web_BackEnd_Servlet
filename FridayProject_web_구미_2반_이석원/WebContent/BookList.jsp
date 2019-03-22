<%@page import="java.util.ArrayList"%>
<%@page import="com.ssafy.book.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String searchType = (String)request.getAttribute("searchType");
    	ArrayList<Book> bookList = null;
    	Book searchedBook = null;
    	
    	if(searchType.equals("isbn")){
    		searchedBook = (Book)request.getAttribute("searchedBook");
    	}else{
    		bookList = (ArrayList)request.getAttribute("bookList");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
<style type="text/css">
	.main{
		margin: 0 auto;
		margin-top: 80px;
		width: 600px;
		height: 500px;
		border: 2px solid black;
		padding: 50px;
		padding-top: 20px; 
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: flex-start;
	}
	
	.section{
		width: 100%;
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	
	.input-area{
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: flex-end;
		align-items: center;
	}
	
	.input-area form{
		width: 310px;
		display: flex;
		flex-direction: row;
		justify-content:space-between;
		align-items: center;
	}
	
	.list-view{
		margin-top: 10px;
		width: 100%;
	}
	
	.list-view table{
		width: 100%;
		overflow:scroll;
	}
	
	th{
		background: #c7c7c7;
	}
	
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="main">
		<div class="title"><h1>도서 화면</h1></div>
		<div class="section">
			<div class="input-area">
				<form action="main" method="post">
					<select name="category">
						<option value="isbn">도서번호</option>
						<option value="title">도서명</option>
						<option value="publisher">출판사</option>
						<option value="price">가격</option>
					</select>
					<input type="text" name="word">
					<input type="submit" value="검색">
					<input type="hidden" name="action" value="search">
				</form>
			</div>
			<div class="list-view">
				<table border="1">
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>도서분류</th>
						<th>저자</th	>
					</tr>
					<%if(searchType.equals("isbn")){ %>
						<%if(searchedBook != null) {%>
						<tr>
							<td><%= searchedBook.getIsbn() %></td>
							<td><a href="main?action=view&isbn=<%= searchedBook.getIsbn() %>"><%= searchedBook.getTitle() %></a></td>
							<td><%= searchedBook.getCatalogue() %></td>
							<td><%= searchedBook.getAuthor() %></td>
						</tr>
						<%} %>
					<%}else{ %>
						<% for(Book book : bookList) {%>
						<tr>
							<td><%= book.getIsbn() %></td>
							<td><a href="main?action=view&isbn=<%= book.getIsbn() %>"><%= book.getTitle() %></a></td>
							<td><%= book.getCatalogue() %></td>
							<td><%= book.getAuthor() %></td>
						</tr>
						<%} %>
					<%} %>
				</table>
			</div>
			
			<div class="link">
				<a href="Book.html">도서 등록</a>
			</div>
		</div>
	</div>
</body>
</html>