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

@WebServlet("/SecondSession")
public class SecondSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondSession() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/*
	 * 1. 기존의 세션을 받아온다.
	 * 2. 세션에 바인딩 되어진 값이 있다면 찾아와야 한다. /없으면...
	 * 3. 2번에서 받아온 값을 결과페이지로 출력... /없으면...다시 원점으로 되돌린다.
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		System.out.println("SecondSession JSESSIONID : "+session.getId());
		
		if(session.getAttribute("person") != null) { //바인딩된 값이 있다면(로그인 성공)
			String name = ((Person)session.getAttribute("person")).getName();
			int age = ((Person)session.getAttribute("person")).getAge();
			
			System.out.println(name);
			request.getRequestDispatcher("third.jsp").forward(request, response);
		}else {
			response.sendRedirect("session.html");
		}
	}
}
