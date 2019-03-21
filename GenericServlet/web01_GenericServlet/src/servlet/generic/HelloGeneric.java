package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloGeneric extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//1)PrintWriter | 2)println() 
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor='cyan'>");
		out.println("<h2>Hello Generic~~~!!</h2>");
		out.println("</body></html>");
		
		out.close();
	}
	
}
