package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<Member> members;
	private static MemberDAO dao=new MemberDAO();	
	private MemberDAO(){
		members = new ArrayList<Member>();
	}
	public static MemberDAO getInstance(){
		return dao;
	}
	
	public void updateMember(Member vo){
		
	}
	public void registerMember(Member vo) throws SQLException{
		if(vo.getId().equals("ssafy")) {
			throw new SQLException();
		}else {
			members.add(vo);
			System.out.println(vo.getName()+" 님 회원 등록 성공!!");
		}
	}
	public Member findMemberById(String id){
		Member vo = null;
		for(Member mem : members) {
			if(mem.getId().equals(id)) {
				vo = mem;
				break;
			}
		}
		return vo;
	}
	public ArrayList<Member> findByAddress(String address) throws SQLException{
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
	public Member login(String id,String password) throws SQLException{
		Member vo=null;
		if(id.equals("ssafy") && password.equals("1234")) {
			vo = new Member(id, password, "홍길동", "진평동");
		}else {
			System.out.println("Login Fail...");
			throw new SQLException();
		}
		return vo;
	}
	public ArrayList<Member> getAllMember() {
			
		return members;
	}
	
}

















