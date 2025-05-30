package ch05.extended.People;

public class StudentsExam {

	public static void main(String[] args) {
		// Student 클래스의 생성자는 name, ssn, studentNo를 매개값으로 받아서 name과 ssn은 다시 부모 생성자를 호출하기 위해 매개값으로 넘겨준다.
		// super(name, ssn)은 People 생성자인 People(name, ssn)을 호출한다.
		// 이것을 생략하면 컴파일 오류가 발생한다.
		// 부모의 기본 생성자가 없으니 다른 생성자를 명시적으로 호출하라는 의미
		Students st = new Students("박채은", "123456-1234567", 1);
		
		System.out.println("name: " + st.name); // 부모 클래스 상속
		System.out.println("ssn: " + st.ssn); // 부모 클래스 상속
		System.out.println("학번: " + st.studentNo); // 자식 클래스

	}

}
