package test;

import java.util.Scanner;

import test.Service.GradeService;
import test.Service.LoginService;
import test.DTO.SignDTO;
import test.Service.SignService;
import test.DTO.GradeDTO;
import test.DTO.LoginDTO;

public class TestExam {

	public static void main(String[] args) {
		// 05-29 평가 / 성적 프로그램 만들기

		Scanner inputStr = new Scanner(System.in); // 문자용
		Scanner inputInt = new Scanner(System.in); // 정수용
		boolean run = true; // 메인 메뉴 반복용
		boolean all = true; // 성적 계산 메뉴 반복용
		boolean session = true;
		
		LoginDTO[] login = new LoginDTO[10]; // 로그인
		GradeDTO[] grade = new GradeDTO[10]; // 점수
		SignDTO[] sign = new SignDTO[10]; // 회원가입
		

		System.out.print("성적 프로그램을 시작하시겠습니까? YES/NO: ");
		String yn = inputStr.next();

		if (yn.equalsIgnoreCase("yes")) {
			System.out.println("성적 프로그램을 시작합니다.");

			while (run) {
				System.out.println("1. 회원가입");
				System.out.println("2. 로그인");
				System.out.println("3. 성적 계산");
				System.out.println("4. 회원정보 수정");
				System.out.println("5. 회원탈퇴");
				System.out.println("9. 프로그램 종료");
				System.out.print("실행할 메뉴를 입력하세요 >>>");
				String select = inputStr.next();

				switch (select) {
				case "1":
					System.out.println("회원가입 메뉴로 이동합니다.");
					SignService signService = new SignService();
					signService.menu(inputStr, inputInt, login, sign);
					break;

				case "2":
					System.out.println("로그인 메뉴로 이동합니다.");
					LoginService loginService = new LoginService();
					loginService.menu(inputStr, inputInt, login);
					break;

				case "3":
					System.out.println("성적 계산 메뉴로 이동합니다.");
					GradeService gradeService = new GradeService();
					session = gradeService.menu(inputStr, inputInt, all, session, grade, login);
					
					if (all == true) {
						System.out.println("성적 계산 완료. 메뉴로 이동합니다.");
					} else {
						System.out.println("성적 계산 실패. 메뉴로 이동합니다.");
					}
					
					break;

				case "4":
					System.out.println("회원정보 수정 메뉴로 이동합니다.");
					break;

				case "5":
					System.out.println("회원정보 삭제 메뉴로 이동합니다.");
					break;

				case "9":
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;

				default:
					System.out.println("1~5번 또는 9번을 입력해주세요.");

				} // switch문 종료

			} // while문 종료

		} else {
			System.out.println("프로그램을 종료합니다.");
		} // 프로그램 시작 YES/NO if문

	} // main 메서드

} // class 종료
