package ch05.Getter_Setter;

public class CarExam {

	public static void main(String[] args) {
		Car myCar = new Car();

		// 잘못된 속도를 제공
		myCar.setSpeed(-50);
		System.out.println("현재 속도: " + myCar.getSpeed());
		// 값을 제공할 대는 setter
		// 값을 받을 때는 getter

		myCar.setSpeed(60); // 정상속도 확인
		System.out.println("현재 속도: " + myCar.getSpeed());

		// 멈춤 테스트
		if (!myCar.isStop()) {
			myCar.setStop(true);
		}
		System.out.println("현재 중지 상태: " + myCar.getSpeed());
	}

}
