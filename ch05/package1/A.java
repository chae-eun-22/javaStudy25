package ch05.package1;

public class A { // 접근 제한자를 생략하면 default 접근제한자
	// public 기본 접근 제한자를 삭제하면 디폴트로 적용
	B b; // B클래스의 접근 제한자는 public으로 가능
	
	A a1 = new A(true); // public용
	A a2 = new A(1);	// default용
	A a3 = new A("문자열"); // private용
	
	// 생성자
	public A(boolean b) { // public 공용 생성자
		// new A(true)
	}
	
	A (int b) {			// 접근 제한자 생략 -> 디폴드 접근 제한
		// new A(int)
	}
	
	private A (String s) { // private -> 개인적인 생성자
		// new A(String)
	}
	
}
