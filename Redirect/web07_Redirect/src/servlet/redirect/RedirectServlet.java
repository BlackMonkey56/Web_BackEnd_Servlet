package servlet.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectServlet() {
    	
    }

    //Choose 체크박스를 선택할 경우...해당 페이지에서 정보를 출력.
    //Choose 체크박스를 선택할 경우...null...에러페이지 이동.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choose = request.getParameter("choose");
		if(choose == null) { //선택하지 않은 경우...에러 페이지로 이동...
			response.sendRedirect("./error/error.html");			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h3>This is RedirectServlet Servlet Page...</h3>");
			out.println("</body></html>");
			
			out.close();
		}
	}

}
