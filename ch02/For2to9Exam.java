package ch02;

public class For2to9Exam {

	public static void main(String[] args) {
		// 구구단 프로그램 작성
		// 2단~9단까지 구구단을 구하는 프로그램을 작성해보자.

		for (int m = 2; m <= 9; m++) { // 변수 m은 2~9까지 증가하여 단을 생성한다.
			System.out.println("******" + m + "단******");
			for (int n = 1; n <= 9; n++) { // 변수 n은 1~9까지 증가하여 곱셈을 완성한다.
				System.out.println(m + "x" + n + "=" + (m * n));
			}
		}

	}

}
