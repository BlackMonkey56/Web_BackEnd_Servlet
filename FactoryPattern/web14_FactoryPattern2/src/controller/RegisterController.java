package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = new Member(id, password, name, address);
		
		MemberDAO.getInstance().registerMember(pvo);
		
		return new ModelAndView("register_result.jsp");
	}

}
