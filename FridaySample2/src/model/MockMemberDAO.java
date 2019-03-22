package model;
/* 원래 dao 클래스는....
 * 디비접속하는 비지니스 로직을 담고 있는 DAO 클래스 ::
 * MVC 에서 M(Model)에 해당된다.
 * Model은 크게 두 가지로 나뉜다(DAO / VO)
 * ==========================================================
 * DAO ::
 * 서버 사이드에서 단 한개만 생성하고
 * 즉 다른 곳에서는 해당 클래스 타입으로 객체를 생성하지 못하게 막아놓는다.
 * 비지니스 로직이 필요한 서블릿들이 하나 생성된 DAO의 메소드를 각각 호출해서 사용하도록 한다.
 * -------------> 싱글톤
 * 1)일단 해당 클래스에서 하나만 생성 : private static으로 생성
 * 2)생성자 앞에 private 붙여서 다른 곳에서 객체가 생성되는 것을 막아둔다.
 * 3)하나 만들어놓은 객체를 다른 서블릿들이 가져다 쓸수 있도록 public static Object getInstance()
 * 
 * ==============================================================
 * 지금은 디비 연결할수 없으니...이전의 Manager 클래스처럼 생각하고 사용하자
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MockMemberDAO {	
	private List<Member> members;
	//싱글톤 패턴으로 작성
	private static MockMemberDAO dao = new MockMemberDAO();
	private MockMemberDAO(){	
		members = new ArrayList<Member>();
	}
	public static MockMemberDAO getInstance(){
		return dao;		
	}
	

	//////////////////////////비지니스 로직 ...돌아간다 치고.. /////////////////////////
	public void registerMember(Member vo) throws SQLException{
		if(vo.getId().equals("ssafy")) {
			throw new SQLException();
		}else {
			members.add(vo);
			System.out.println(vo.getName()+" 님 회원 등록 성공!!");
		}
		
	}
	//작성하세요...
	public Member findByIdMember(String id){		
		Member vo = null;
		
		return vo;
	}
	//작성하세요...
	public ArrayList<Member> findByAddressMember(String address){
		int count = 0;		
		ArrayList<Member> temp = new ArrayList<Member>();	
		
		for(Member mem : members) {
			if(mem.getAddress().equals(address)) {
				temp.add(mem);
				count++;
			}
		}
		
		return temp;
	}	
	
	//작성하세요...
	public Member login(String id, String password) {	
		
		Member vo = null;
		
		return vo;
		
	}
}//class














