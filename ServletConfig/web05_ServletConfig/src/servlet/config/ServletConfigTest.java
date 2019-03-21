package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, addr, email;
       
    public ServletConfigTest() {
    	
    }

	public void init() throws ServletException {
		//ServletConfig 객체를 이용한 서블릿 초기화 로직을 작성
		//필드 초기화... 값을 할당... DD파일에서 값을 끌어당김...서버 차원에서 설정한 정보
		name = getInitParameter("name");
		addr = getInitParameter("addr");
		email = getInitParameter("email");
		
		System.out.println("Container에 설정된 정보를 받아옴 "+name+", "+addr+", "+email);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>ServletConfig' getInitParameter Test</h2><br>");
		out.println("Your name "+name);
		out.println("Your addr "+addr);
		out.println("Your email "+email);
		
		out.close();
	}

}
