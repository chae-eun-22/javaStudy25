package ch02;

import java.util.Scanner;

public class DoWhileTest01 {

	public static void main(String[] args) {
		// UP and Down 게임 만들기
		// 컴퓨터가 랜덤으로 만든 1~31 숫자를 사용자가 맞추는 게임
		
		int input = 0, answer = 0;

		answer = (int) (Math.random() * 31) + 1; // 1~31까지의 랜덤 정수를 넣는다.
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("1과 31사이의 정수를 입력하세요: ");
			input = scanner.nextInt();

			if (input > answer) {
				System.out.println("down");
			} else if (input < answer) {
				System.out.println("up");
			}
		} while (input != answer);
		System.out.println("정답입니다. " + answer);
	}

}
