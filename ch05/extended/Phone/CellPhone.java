package ch05.extended.Phone;

public class CellPhone { // 부모 클래스 -> 기본적인 필드와 메서드 제공
	
	String model;
	String color; // 부모 필드
	
	// 생성자(디폴트로 활용)
	
	void powerOn() {System.out.println("전원을 켭니다.");}
	void powerOff() {System.out.println("전원을 끕니다.");}
	void bell() {System.out.println("벨이 울립니다.");}
	void sendVoice(String message) {System.out.println("자기: " + message);}
	void receiveVoice(String message) {System.out.println("상대방: " + message);}
	void hangup() {System.out.println("전화를 끊습니다.");}
	
} // 부모에서 만든 객체
