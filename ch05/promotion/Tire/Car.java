package ch05.promotion.Tire;

public class Car {
	// 필드
	Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);

	// 자동차의 부품인 타이어 4개의 객체를 생성한다. (위치, 마일리지)

	Tire[] tires = {
			new Tire("앞왼쪽", 6), // tires[0]
			new Tire("앞오른쪽", 2), // tires[1]
			new Tire("뒤왼쪽", 3), // tires[2]
			new Tire("뒤오른쪽", 4) // tires[3]
	}; // 배열을 활용하여 객체 관리
	
	
	// 생성자
	// 메서드 roll 소환하여 주행여부를 판단
	int run() { // 자동차 달리는 여부
		System.out.println("자동차가 달립니다.");
		for(int i = 0; i < tires.length; i++) {
			if(tires[i].roll()==false) {
				stop();
				return (i+1); // 타이어 순번
				// 배열은 0~3, 타이어 장착 순서 1~4
			} // 타이어 객체의 마일리지가 소모되어 false가 호출 여부
		} // 배열의 길이까지 반복하는 for문 종료
//		if (frontLeftTire.roll() == false) {
//			stop();
//			return 1;
//		}
//		;
//		if (frontRightTire.roll() == false) {
//			stop();
//			return 2;
//		}
//		;
//		if (backLeftTire.roll() == false) {
//			stop();
//			return 3;
//		}
//		;
//		if (backRightTire.roll() == false) {
//			stop();
//			return 4;
//		}
//		;
		return 0; // 문제 없을 때 0을 리턴
	} // 정상 주행이면 0을 리턴 / 펑크시 1~4까지 위치 정보를 리턴한다.

	void stop() {
		System.out.println("자동차가 멈춥니다."); // 펑크 났을 때
	}
}
