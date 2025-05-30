package ch05.Override;

public class Computer extends Calculator { // 자식 클래스
	
	@Override
	double areaCircle(double r) {
		return super.areaCircle(r); // 이 값을 수정하여 제공
		// 자식 클래스
	}

}
