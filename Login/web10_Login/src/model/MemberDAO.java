package model;

import java.sql.SQLException;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {
		System.out.println("Creating DAO...");
	}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	//비즈니스 로직...
	 public Member loginMember(String id, String password) throws SQLException{
		 Member member = null;
		 
		 try {
			 if(id.equals("ssafy") && password.equals("1234")) {
				 member = new Member(id, password, "이석원", "진평동");
			 }
		 }catch(Exception e) {
			 new SQLException();
		 }
		 
		 return member;
	 }
}
