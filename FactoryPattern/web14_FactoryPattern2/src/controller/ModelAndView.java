package controller;
/*
 * 결과페이지 이름과
 * 페이지 이동방식을 저장하는 객체
 */
public class ModelAndView {
	private String path;
	private boolean isRedirect;
	
	public ModelAndView() {
		
	}

	public ModelAndView(String path) {
		this.path = path;
	}

	public ModelAndView(String path, boolean isRedirect) {
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}
}
