package servlet.cookie;

/*
 * 1. 쿠키를 생성한다.
 * 2. 생성한 쿠키를 
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetCookie() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Date now = new Date();
		String id = "SSAFY";
		
		//1.쿠키생성
		Cookie c1 = new Cookie("id", id);
		Cookie c2 = new Cookie("time", new SimpleDateFormat("yyyy-MM-dd").format(now));
		
		c1.setMaxAge(24*60*60);//하루동안 쿠키의 유지시간을 지정...
		c2.setMaxAge(0);
		
		//2. 브라우저로 보냄
		response.addCookie(c1);
		response.addCookie(c2);
		
		out.println("<h2>쿠키가 생성된 시각 : " + c2.getValue() + "</h2><br>");
		out.println("ID : "+id + "<br>");
		out.println("<a href='GetCookie'>GetCookie로 이동하기</a>");
	}

}
