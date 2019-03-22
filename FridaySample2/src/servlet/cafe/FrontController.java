package servlet.cafe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MockMemberDAO;


@WebServlet("/main")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MockMemberDAO dao = MockMemberDAO.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		String command = request.getParameter("command");
		
		String path = "error.jsp";
		try {
			if(command.equals("findmember")){ //예전에 FindServlet이 동작했다.
				path=findMember(request,response);
			}else if(command.equals("register")){
				path=register(request,response);
			}else if(command.equals("findaddrmember")){
				path=findAddressMember(request,response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);//
	}//process
	
	public String findMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Member rvo=dao.findByIdMember(request.getParameter("id"));
		
		if(rvo != null){
			request.setAttribute("rvo", rvo);
			return "find_ok.jsp";
		}else{
			return "find_fail.jsp";
		}
	}//findMember
	
	public String register(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id = request.getParameter("id");
		String password =request.getParameter("password");
		String name = request.getParameter("name");
		String address=  request.getParameter("address");
		
		Member vo = new Member(id, password, name, address);
		dao.registerMember(vo);
		return "register_result.jsp";
	}
	//작성하세요...
	public String findAddressMember(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		String address=  request.getParameter("address");
		//
		
		return "";
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password =request.getParameter("password");
		Member rdto = dao.login(id, password);
		if(rdto != null){
			HttpSession session = request.getSession();
			session.setAttribute("rdto", rdto);
			return "login_ok.jsp";
		}else{
			return "login_fail.jsp";
		}
	}
}
