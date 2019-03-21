package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloGeneric3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HelloGeneric3() {
    	
    }

	//get방식일 때 이곳으로 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	//post방식일 때 이곳으로 요청
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	//로직은 여기서 작성한다.
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1. form값을 받는다.
		String id = request.getParameter("userId");
		//2. 한글처리
		response.setContentType("text/html;charset=utf-8");
		
		//한글처리는 양방향 / PrintWriter 리턴받는 부분 위에 해야한다.
		PrintWriter out = response.getWriter();
		out.println("당신의 아이디는  " + id + "<br>");
	}

}
