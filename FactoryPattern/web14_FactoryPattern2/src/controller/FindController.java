package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

public class FindController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = "find_fail.jsp";
		
		String id = request.getParameter("id");
		
		Member rvo = MemberDAO.getInstance().findMemberById(id);
		
		if(rvo != null) {
			request.setAttribute("vo", rvo);
			path = "find_ok.jsp";
		}
		
		return new ModelAndView(path);
	}

}
