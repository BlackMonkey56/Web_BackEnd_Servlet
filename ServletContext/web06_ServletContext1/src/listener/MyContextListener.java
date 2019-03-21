package listener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//dd에 설정한 데이터를 읽어오는데...
//시점은 서버가 가동되자마자 진행되어야지만 진정한 의미의 Global한 초기화이다.
/*
 * context.getInitParameter()
 */
public class MyContextListener implements ServletContextListener{
	private ServletContext cont;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed()....call.....");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized.....call.....");
		
		
		cont = sce.getServletContext();
		String fileName = cont.getInitParameter("vipmember");
		System.out.println(fileName);
		
		//입력스트림을 이용해서 파일의 내용을 읽어들임...
		InputStream is = null;
		BufferedReader br = null;
		try {
			System.out.println("getResourceAsStream()....call....");
			is = cont.getResourceAsStream(fileName);
			br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			System.out.println("파일의 내용을 읽어들입니다.......");
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
