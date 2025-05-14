package ch02;

public class ForFloatConterExam {

	public static void main(String[] args) {
		// for문 작성시 주의할 점
		// 초기화식에서 루프 카운트 변수를 부동 소수점인 실수방식을 사용하면 안된다.
		// 아래 결과를 확인해보면 9번만 루프를 진행하는 오류를 확인할 수 있다.
		
		for (float x = 0.1f; x < 1.0f; x += 0.1f) {
			System.out.println(x);
		}

	}

}
