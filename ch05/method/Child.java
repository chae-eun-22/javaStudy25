package ch05.method;

public class Child extends Parent {

	@Override
	public void method2() {
		System.out.println("자식의 메서드2 호출");
		System.out.println("Child-method2()");
	}
	
	public void method3() {
		System.out.println("자식의 메서드3 호출");
		System.out.println("Child-method3()");
	}
	
	
}
