package ch04;

import java.util.Scanner;

public class MemberObjExam {

	public static void main(String[] args) {
		// Member 클래스를 호출하여 처리

		Scanner input = new Scanner(System.in);
		Member[] members = null;

		System.out.print("가입할 회원 수를 입력하세요: ");
		int count = input.nextInt();
		members = new Member[count]; // 키보드로 입력한 숫자만큼 배열 생성

		System.out.println("회원가입 프로그램을 실행합니다.");
		boolean run = true;

		while (run) {

			System.out.println("1. 회원가입");
			System.out.println("2. 회원 전체보기");
			System.out.println("3. 로그인");
			System.out.println("4. 회원수정");
			System.out.println("5. 회원탈퇴");
			System.out.print("1~5까지의 숫자만 입력하세요(그 외의 입력은 프로그램이 종료됩니다):");
			int select = input.nextInt();

			switch (select) {
			case 1:
				Member member1 = new Member(); // 객체 생성
				for (int i = 0; i < members.length; i++) {
					member1 = member1.memberAdd(input); // 생성된 객체 메서드
					members[i] = member1;
				}
				break;

			case 2:
				Member member2 = new Member(); // 객체 생성
				member2.memberAllList(members); // 전체보기 메서드 실행
				break;

			case 3:
				Member member3 = new Member(); // 객체 생성
				member3.memberLogin(input, members); // 로그인 메서드 실행
				break;

			case 4:
				Member member4 = new Member(); // 객체 생성
				member4.memberUpdate(input, members); // 회원수정 메서드 실행
				break;

			case 5:
				Member member5 = new Member(); // 객체 생성
				member5.memberDelete(); // 회원탈퇴 메서드 실행
				break;

			default:
				System.out.println("회원가입 프로그램 종료");
				run = false;

			} // switch문 종료

		} // while(run) 종료

	} // main 메서드 종료

} // class 종료
