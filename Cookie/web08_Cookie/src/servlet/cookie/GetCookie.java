package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCookie() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2>SetCookie에서 설정한 쿠키 정보를 받아옵니다...</h2><p>");
		
		/*
		 * 쿠키정보를 다 받아와서 키와 값을 브라우저로 출력한다.
		 * now....?
		 */
		Cookie[] cs = request.getCookies(); 
		
		for(Cookie c : cs) {
			out.println(c.getName()+" : "+c.getValue()+"<p>");
		}
	}

}
