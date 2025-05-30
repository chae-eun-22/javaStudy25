package ch05.extended.car;

public class Car { // 부모 클래스
	// 필드
	public int speed;
	
	
	// 메서드
	public void speedUp() {
		speed += 1;
	} // speedUp 메서드를 호출하면 속도가 1씩 증가
	
	public final void stop() {
		System.out.println("자동차를 멈춥니다.");
		speed = 0;
	}
}
