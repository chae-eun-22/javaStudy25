package ch05.extended.People;

public class Students extends People {
	public int studentNo;

	public Students(String name, String ssn, int studentNo) {
		super(name, ssn); // 부모 생성자 호출
		// this.name = name; 부모에 생성자가 존재함
		// this.ssn = ssn; 기본 생성자가 아니면 super로 호출
		this.studentNo = studentNo;
	}
	
}
