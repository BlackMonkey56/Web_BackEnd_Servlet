package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MFS")
public class MultiFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MultiFormServlet() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 양방향 한글처리
		 * 폼값을 받아서
		 * 웹브라우저로 출력
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String[] hobbies = request.getParameterValues("hobby");
		String[] tel = request.getParameterValues("tel");
		String gender = request.getParameter("gender");
		
		
		out.println("<html><body bgcolor=skyblue>");
		out.println("<b>ID: </b>"+id+"<br><br>");
		out.println("<b>Pass: </b>"+password+"<br><br>");
		out.println("<b>hobby: </b>"+Arrays.toString(hobbies)+"<br><br>");
		out.println("<b>tel: </b>"+Arrays.toString(tel)+"<br><br>");
		out.println("<b>gender: </b>"+gender+"<br><br>");
		out.println("</body></html>");
		
		out.println("<a href='result.jsp'>jsp결과 페이지 보러가기</a>");
		out.close();
	}
}
