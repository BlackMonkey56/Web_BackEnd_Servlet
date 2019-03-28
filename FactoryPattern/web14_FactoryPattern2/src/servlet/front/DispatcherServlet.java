package servlet.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.HandlerMapping;
import controller.ModelAndView;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public DispatcherServlet() {
    	
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		System.out.println(command);
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		try {
			ModelAndView mv = controller.handle(request, response);
			
			if(!mv.isRedirect()) {
				request.getRequestDispatcher(mv.getPath()).forward(request, response);
			}else {
				response.sendRedirect(mv.getPath());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
