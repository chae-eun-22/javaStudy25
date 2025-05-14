package ch02;

import java.util.Scanner;

public class Swutcg2DemoExam {

	public static void main(String[] args) {
		// scanner로 입력받은 값을 판단하는 switch문 구현
		Scanner in = new Scanner(System.in);
		System.out.print("동물의 이름을 입력하세요: ");
		String Monster = in.nextLine();

		WhoIsIt(Monster); // 내가 만든 함수(메서드)에 호랑이 값을 넣는다.

	} // main 메서드 종료

	static void WhoIsIt(String bio) {

		String kind = "미지의 생물"; // kind 문자열 변수 초기화

		switch (bio) {
		case "호랑이", "사자", "강아지", "고양이" -> kind = "포유류";
		// break;

		case "독수리", "참새", "까마위", "비둘기" -> kind = "조류";
		// break;

		case "고등어", "연어", "참치", "갈치" -> kind = "어류";
		// break;

		default -> System.out.println("어이쿠!");
		}
		System.out.printf("%s는 %s이다.\n", bio, kind);
	}

}
