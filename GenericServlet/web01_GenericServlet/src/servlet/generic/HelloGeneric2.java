package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloGeneric2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
    
    public HelloGeneric2() {
         System.out.println("1. 서블릿 인스턴스 생성...");
    }

	public void init() throws ServletException {
		System.out.println("2. init()...");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("3. service()...");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h2>Hello Generic2~~~!!</h2>");
		out.println("</body></html>");
		
		out.close();
	}

}
