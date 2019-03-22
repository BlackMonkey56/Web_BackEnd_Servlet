package com.ssafy.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookMgr bookMgr = BookMgr.getInstance();
	private String path = "";
       
    public MainServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//액션받기
		String action = request.getParameter("action");
		
		path = "Error.jsp";
		try {
			if(action.equals("save")) {
				path = save(request, response);
			}else if(action.equals("delete")) {
				path = delete(request, response);
			}else if(action.equals("list")) {
				path = list(request, response);
			}else if(action.equals("search")) {
				path = search(request, response);
			}else if(action.equals("view")) {
				path = view(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected String search(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String searchType = request.getParameter("category");
		String searchWord = request.getParameter("word");
		
		ArrayList<Book> searchList = null;
		Book searchedBook = null;
		
		request.setAttribute("searchType", searchType);
		
		if(searchType.equals("isbn")) {
			searchedBook = bookMgr.searchByIsbn(searchWord);
		}else if(searchType.equals("title")) {
			searchList = (ArrayList<Book>)bookMgr.searchByTitle(searchWord);
		}else if(searchType.equals("publisher")) {
			searchList = (ArrayList<Book>)bookMgr.searchByPublisher(searchWord);
		}else if(searchType.equals("price")) {
			searchList = (ArrayList<Book>)bookMgr.searchByPrice(Integer.parseInt(searchWord.equals("") ? "0" : searchWord));
		}
		request.setAttribute("searchedBook", searchedBook);
		request.setAttribute("bookList", searchList);
		
		return "BookList.jsp";
	}

	protected String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("searchType", "default");
		request.setAttribute("bookList", bookMgr.search());
		return "BookList.jsp";
	}
	
	protected String view(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("isbn");
		
		Book book = bookMgr.searchByIsbn(isbn);
		
		request.setAttribute("book", book);
		
		return "BookView.jsp";
	}
	
	protected String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String isbn = request.getParameter("isbn");
		
		bookMgr.delete(isbn);
		
		request.setAttribute("result", "delete");
		return "Result.jsp";
	}
	
	protected String save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] isbnElement = request.getParameterValues("isbn");
		String isbn = isbnElement[0]+"-"+isbnElement[1]+"-"+isbnElement[2];
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publishDate = request.getParameter("publishdate");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price").equals("") ? "0" : request.getParameter("price"));
		String currency = request.getParameter("currency");
		String description = request.getParameter("description");
		
		Book book = new Book(isbn, title, catalogue, nation, 
				publishDate, publisher, author, price, currency, description);
		
		bookMgr.add(book);
		
		request.setAttribute("result", "save");
		return "Result.jsp";
	}
}
