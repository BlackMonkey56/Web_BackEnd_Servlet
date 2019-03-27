package servlet.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.MemberDAO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		/*
		 * 1. 폼 값 받아서...id, password
		 * 2. DAO리턴받고.. 비즈니스 로직 호출...결과값 리턴받고
		 * ** if(member != null){ 
		 * 3. 세션 받아오고, 세션에 바인딩
		 * 4. 네비게이션...forward()...login_result.jsp(로그인한 사람의 정보 출력)
		 * **}else{
		 * 5. login_form.html되돌린다..redirect
		 * 	}
		 */
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		Member member = dao.loginMember(id, password);
		
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			System.out.println("1: " + session.getId());
			
			request.getRequestDispatcher("login_result.jsp").forward(request, response);
		}else {
			response.sendRedirect("loginForm.html");
		}
	}

}
