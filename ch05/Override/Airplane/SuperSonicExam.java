package ch05.Override.Airplane;

public class SuperSonicExam {

	public static void main(String[] args) {
		
		SuperSonicAirplane sa = new SuperSonicAirplane();
		sa.takeOff(); // 이륙합니다.
		sa.fly(); // 일반 비행합니다.
		sa.flyMode = SuperSonicAirplane.SUPERSONIC;
		// SUPERSONIC 모드로 변경
		sa.fly(); // 초음속 비행합니다.
		sa.flyMode = SuperSonicAirplane.NORMAL;
		sa.fly(); // 일반 비행합니다.
		sa.land(); // 착륙합니다.
		
	}

}
