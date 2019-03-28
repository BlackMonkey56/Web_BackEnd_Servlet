package action;
/*
 * component
 * ::
 * 인터페이스 기반의 재사용성 강한 자바 클래스
 * ::
 * CBD기반 프로젝트로 연결됨...
 * 
 */
public class InsertAction implements Action{

	@Override
	public void execute() {
		/*
		 * 폼값 받아서
		 * dao 리턴받고
		 * 비즈니스 로직 호출...객체가 리턴되면
		 * 바인딩
		 * 네비게이션
		 */
		insert();
	}
	
	private void insert() {
		//비즈니스 로직이 실행된다....치고
		System.out.println("INSERT ACTION....");
	}
}
