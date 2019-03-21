package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements javax.servlet.Filter {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//사전 작업...한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//사전작업들이 서버상의 다음 컴포넌트들에게 계속 적용되기 위해서 반드시 작성해야 한다.
		chain.doFilter(request, response);
		
		//사후 작업
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}
	
}
