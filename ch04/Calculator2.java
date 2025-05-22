package ch04;

public class Calculator2 { // 계산기 프로그램
	int plus(int x, int y) {
		int result = x + y;
		return result;
	} // x와 y의 매개값을 전달받아 더한 뒤 리턴
	
	double avg(int x, int y) {
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}
	
	void execute() {
		double result = avg(7, 10);
		println("실행결과: " + result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
}
