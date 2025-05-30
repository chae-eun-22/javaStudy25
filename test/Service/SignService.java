package test.Service;

import java.util.Scanner;

import test.DTO.LoginDTO;
import test.DTO.SignDTO;

public class SignService { // 서비스 계층은 CRUD 메서드 위주로 생성 > 회원가입만 하게 만들 것

	public void menu(Scanner inputStr, Scanner inputInt, LoginDTO[] login, SignDTO[] sign) {
		// 회원가입

		boolean runS = true;

		while (runS) {
			System.out.println("회원가입 메뉴로 이동되었습니다.");
			System.out.println("1. 학생");
			System.out.println("2. 교사");
			System.out.println("3. 관리자");
			System.out.println("4. 메인 메뉴로 이동하기");
			System.out.print("실행할 메뉴를 입력하세요 >>> ");
			String select = inputStr.next();

			switch (select) {
			case "1":
				System.out.println("학생으로 회원가입을 진행합니다.");
				Student(inputStr, inputInt, login, sign);
				break;

			case "2":
				System.out.println("교사로 회원가입을 진행합니다.");
				Teacher(inputStr, inputInt, login);
				break;

			case "3":
				System.out.println("관리자로 회원가입을 진행합니다.");
				break;

			case "4":
				System.out.println("메인 메뉴로 이동합니다.");
				runS = false;
				break;

			default:
				System.out.println("1~4번만 입력하세요.");
				break;

			} // switch문 종료

		} // while문 종료

	} // menu() 메서드 종료

	private void Teacher(Scanner inputStr, Scanner inputInt, LoginDTO[] login) {
		// 교사 회원가입

	} // 교사 회원가입 메서드 종료

	private void Student(Scanner inputStr, Scanner inputInt, LoginDTO[] login, SignDTO[] sign) {
		// 학생 회원가입
		
		boolean pass = true; // 무한반복용 코드

		System.out.print("이름을 입력하세요: ");
		String name = inputStr.next();

		System.out.print("사용할 아이디를 입력하세요: ");
		String id = inputStr.next();

		System.out.println(id + "는 사용 가능한 아이디입니다.");
		System.out.print("이 아이디를 사용하시겠습니까? YES/NO: ");
		String idyn = inputStr.next();

		if (idyn.equalsIgnoreCase("yes")) {
		
			while (pass) {
				System.out.print("사용할 비밀번호를 입력하세요: ");
				String pw = inputStr.next();

				System.out.print("비밀번호를 한번 더 입력하세요: ");
				String pwre = inputStr.next();
				
				if (pw.equals(pwre) && pwre.equals(pw)) { // 비밀번호가 동일하면 실행하는 if문
					System.out.println("비밀번호가 동일합니다.");
					pass = false;
				} else {
					System.out.println("비밀번호가 다릅니다. 비밀번호만 처음부터 다시 입력하세요.");
				} // if문 종료

			} // while문 종료

			System.out.print("사용할 이메일을 입력하세요: ");
			String email = inputStr.next();

			System.out.print("전화번호를 입력하세요: ");
			int Phone = inputInt.nextInt();

			System.out.print("주민번호를 입력하세요(-제외): ");
			String ssn = inputStr.next();
			char num = ssn.charAt(6); // 7번째 글자를 추출

			switch (num) {
			case '1':
			case '3':
			case '5':
			case '7':
				System.out.println("성별은 남자입니다.");
				break;

			case '2':
			case '4':
			case '6':
			case '8':
				System.out.println("성별은 여자입니다.");
				break;

			default:
				System.out.println("당신은 외계인입니다.");
				System.out.println("프로그램을 종료합니다.");
			} // 주민번호 7번째 글자를 추출해 성별을 알아내는 switch문 종료
			
			System.out.print("개인정보 활용에 동의하시겠습니까? YES/NO: "); // 개인정보 활용
			String infyn = inputStr.next();
			
			if(infyn.equalsIgnoreCase("yes")) {
				System.out.println(name + "님 회원가입에 성공하셨습니다.");
			} else {
				System.out.println("회원가입에 실패하셨습니다.");
				pass = false;
			} // 개인정보 활용 동의 if문 종료
			
		} else {
			System.out.println("회원가입을 처음부터 다시 진행하세요.");
		} // if문 종료

	} // 학생 회원가입 메서드 종료

} // class 종료
