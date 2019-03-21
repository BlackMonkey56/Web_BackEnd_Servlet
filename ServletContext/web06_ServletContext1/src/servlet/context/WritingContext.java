package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/writing", loadOnStartup=1)
public class WritingContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String driverName;
	private ServletContext cont;
	private HashMap userList;
       
    public WritingContext() throws Exception{
    	//Class.forName(driverName);
    	System.out.println("Driver Loading....");
    }

	public void init() throws ServletException {
		//ServletContext의 getInitParameter()를 사용
		cont = getServletContext();
		driverName = cont.getInitParameter("ODriver");
		System.out.println(driverName);
		
		userList = new HashMap();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리는 filter를 통해서 완료함
		//폼에 입력된 값을 받아서
		System.out.println("doPost()....");
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		String name = request.getParameter("userName");
		
		//userList에 객체의 정보를 담는다.
		userList.put("id", id);
		userList.put("pass", pass);
		userList.put("name", name);
		
		//바인딩
		//cont.setAttribute("userList", userList);
		request.setAttribute("userList", userList);
		
		//추가...네비게이션(forward방식으로 페이지 이동)
		/*
		 * 1. RequestDispatcher 받아오고
		 * 2. forward() 사용 		
		 */
		request.getRequestDispatcher("resultView.jsp").forward(request, response);
		
		
//		PrintWriter out = response.getWriter();
//		out.println("<b>=====사용자의 정보를 Attribute에 바인딩했습니다.=====</b><br>");
//		out.println("<a href='resultView.jsp'><h3>접속자 명단보기</h3></a>");
//		
//		out.close();
	}

}
