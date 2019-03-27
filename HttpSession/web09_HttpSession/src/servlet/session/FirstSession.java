package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Person;


@WebServlet("/FirstSession")
public class FirstSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstSession() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		/*
		 * 1.Session 하나 받아와서
		 * 2.정보를 바인딩하고
		 * 3.네비게이션
		 */
		HttpSession session = request.getSession(true);
		System.out.println("FirstSession JSESSIONID : "+ session.getId());
		
		//폼으로부터 데이터를 받아왔다치고
		Person person = new Person("강호동", 43);
		
		//바인딩
		session.setAttribute("person", person);
		
		//페이지이동
		request.getRequestDispatcher("SecondSession").forward(request, response);
	}

}
