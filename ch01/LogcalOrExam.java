package ch01;

import java.util.Scanner;

public class LogcalOrExam {

	public static void main(String[] args) {
		// 논리합 테스트용
		// | 연산은 대부분 조건이 2개 이상일 경우 판단하는 용도로 사용한다.
		// 예를 들어 id와 pw가 둘중 하나라도 맞아야 id 찾기나 pw 찾기로 가는 경우
		// (가지고 있던 id == 키보드로 입력한 id) & (가지고 있던 pw == 키보드로 입력한 pw)
		//				false				false			= false
		//				true				false			= true
		//				false				true			= true
		//				true				true			= true

		// 키보드로 입력받은 숫자가 2의 배수이거나 3의 배수인 것을 처리해보자.
		Scanner input = new Scanner(System.in); // 키보드로 입력받은 객체용
		System.out.println("2의 배수나 3의 배수인 것을 확인해볼까요?");
		System.out.print(">>>");
		int value = input.nextInt(); // 정수를 입력받아 변수에 넣음
		if ( (value%2==0) || (value%3==0) ) {
			// 입력값을 2로 나눈 나머지가 0이면 true
			//				이거나
			//					입력값을 3으로 나눈 나머지가 0이면 true

			System.out.println("2의 배수 또는 3의 배수입니다. : " + value);
		} else {
			System.out.println("2의 배수 또는 3의 배수가 아닙니다. : " + value);
		} // if문 종료

	}

}
