package ch05.Override.Airplane;

public class Airplane { // 부모 클래스로 비행기의 기본값을 갖는다.
	
	public void land() {
		System.out.println("착륙합니다.");
	}
	
	public void fly() {
		System.out.println("비행합니다.");
	}
	
	public void takeOff() {
		System.out.println("이륙합니다.");
	}
}
