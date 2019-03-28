package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.Member;
import model.MemberDAO;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Member vo = MemberDAO.getInstance().findMemberById(id);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("find_ok");//결과페이지의 물리적 위치를 넣을 수 없음!!
		mv.addObject("message", "Hello Spring id :: ");
		
		return mv;
	}
	
}
