package ch05.Override;

public class ComputerExam {

	public static void main(String[] args) {
		int r = 10; // 10 값을 실수로 전달
		
		Calculator cal = new Calculator(); // 3.14159 값으로 계산
		System.out.println("원 면적: " + cal.areaCircle(r));
		System.out.println(); // 부모 객체에 대한 원 면적 계산 값
		
		Computer com = new Computer(); // Math.PI 값으로 메서드 재정의
		System.out.println("원 면적: " + com.areaCircle(r));
		System.out.println(); // 자식 객체에 대한 원 면적 계산 값

	}

}
