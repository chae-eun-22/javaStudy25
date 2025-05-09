package ch01;

public class AccuracyExam {

	public static void main(String[] args) {
		// 사과 1개를 10조각으로 쪼개면 1조각이 0.1로 1개가 됨
		
		int apple = 1 ; // 사과 1개
		double pieceUnit = 0.1 ; // 조각 단위
		int number = 7 ; // 사과 1조각
		
		double result = apple - number * pieceUnit ;
		System.out.println("사과 7조각을 뺌 : " + result);
		// 0.29999999999999993
		
		System.out.println("7조각의 값 : " + number * pieceUnit);
		// 0.7000000000000001
		
		// 정확한 계산을 위해서는 실수 타입을 사용하지 않는 것이 좋다

	}

}
