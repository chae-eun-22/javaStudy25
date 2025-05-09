package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		// 논리적인 연산자는 크게 5가지 유형이 있다.
		// & : 논리 곱 -> ~이고 (2가지 변수가 모두 참일 경우 참)
		// | : 논리 합 -> ~이거나 (2가지중 한개라도 참이면 참)
		// ! : 논리부정 -> 참과 거짓을 반전함.
		// ^ : 배타적 논리 합 -> 논리합의 마지막인 1+1=0으로 결론이남
		// 10-1에서 했으니 여기선 갖고 놀기
		
		String siid = "";
		String sipw = "123";
		String sipw2 = "123";
		
		Scanner input = new Scanner(System.in); // sc 컨트롤 스페이스바
		// 콘솔에 키보드로 값을 밀어 넣을 객체 생성함
		
		System.out.print("아이디를 입력하세요 : ");
		String id = input.nextLine();
		
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = input.nextLine();
		
		System.out.print("비밀번호를 한번 더 입력하세요 : ");
		String pw2 = input.nextLine();
		
		if((sipw.equals(pw)) & sipw2.equals(pw2)) {
			// 가지고 있던 id와 키보드로 입력한 id가 같은지
			// 이거나 or
			// 가지고 있던 pw와 키보드로 입력한 pw가 같은지
			System.out.println("비밀번호가 일치합니다.");
		} else { // if문에 flase 처리용
			System.out.println("비밀번호가 다릅니다.");
		} // if문 종료

	} // main 메서드 종료

} // class 종료
