package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 최초의 클라이언트가 서버에 요청을 하더라도 Ready-On상태의 일들은 미리 서버내부에서
 * 메모리에 로딩되어져 있어야 한다.
 * 그런 다음에 클라이언트의 서비스를 수행하도록 하는게 맞다.
 * 그렇게 하지 않으면 최초의 클라이언트 서비스 요청자는 대기시간이 길어질 수 밖에 없다.
 * ::
 * <load-on-startup>1</load-on-startup>
 */

@WebServlet(urlPatterns= {"/life"}, loadOnStartup=1)
public class LifeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path = "c:\\filestore\\life\\cycle.txt";
       
    public LifeServlet() {
    	System.out.println("1. 기본 생성자 호출...서블릿 생성...");
    }

	public void init() throws ServletException {
		System.out.println("2. init호출...By Container");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			System.out.println();
			br.close();
			System.out.println("init complete");
		}catch(Exception e) {
			
		}
	}

	//증가된 count값을 최종적으로 파일에 출력하고 종료되도록...
	public void destroy() {
		System.out.println("4. destroy호출...By Container");
		//파일을 생성해서 이곳에다 출력
		File f = new File(path);
		f.getParentFile().mkdirs(); //디렉토리가 생성
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println(count);
			pw.close();
			System.out.println("File store");
		}catch (Exception e){
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성...
		System.out.println("3.service호출...By Container");
		
		//1.한글 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2. PrintWriter 객체 리턴
		PrintWriter out = response.getWriter();
		
		System.out.println("doGet()...call...by Container...");
		out.println("<html><body bgcolor=orange>");
		out.println("<h2>Count :: </h2>"+ ++count);
		out.println("</body></html>");
	}

}
