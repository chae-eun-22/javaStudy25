package ch02;

import java.util.Scanner;

public class IfSsnExam33 {

	public static void main(String[] args) {
		// 주민등록번호 활용하기
		// 회원가입으로 만들어보기
		// if와 switch문 응용

		Scanner input = new Scanner(System.in); // 정수용

		System.out.print("회원가입을 진행하시겠습니까? YES/NO : ");
		String yn = input.next();
		System.out.println("===================================");

		if (yn.equalsIgnoreCase("yes")) { // 회원가입 yes if문 시작

			boolean sign = true; // 무한반복용 변수

			while (sign) { // 회원가입 while문 시작

				System.out.print("이름을 입력하세요: ");
				String name = input.next();
				System.out.print(
						"입력하신 이름은 " + name + "입니다. 정확하게 입력하셨으면 1번, 아니면 2번을 입력해주세요. 그 외의 입력은 회원가입을 처음부터 다시 진행하셔야 합니다: ");
				int namee = input.nextInt();

				switch (namee) { // 이름 switch문 시작

				case 1:
					System.out.println("아이디 입력으로 넘어갑니다.");
					System.out.println("===================================");
					break;

				case 2:
					boolean namer = true;
					while (namer) { // while(namer)문 시작
						System.out.print("이름을 다시 입력하세요: ");
						String namere = input.next();
						System.out.println("입력하신 이름은 " + namere + "입니다.");
						System.out.println("===================================");
						System.out.print("이름을 정확하게 입력하셨으면 1번을 입력해주세요. 그 외의 입력은 이름 다시 입력하기로 넘어갑니다: ");
						int namera = input.nextInt();

						switch (namera) { // switch(namera)문 시작
						case 1:
							System.out.println();
							break;

						default:
							boolean nameree = true;
							while (nameree) { // default의 while문 시작
								System.out.print("이름을 다시 입력하세요: ");
								String namerere = input.next();
								System.out.println("입력하신 이름은 " + namerere + "입니다.");
								System.out.println("===================================");
								System.out.print("이름을 정확하게 입력하셨으면 1번을 입력해주세요. 그 외의 입력은 이름 다시 입력하기로 넘어갑니다: ");
								int namerae = input.nextInt();
								namer = false;
								if (namerae == 1) { // while문에서 1번을 선택했을 경우 실행되는 if문 시작
									System.out.println("아이디 입력으로 넘어갑니다.");
									System.out.println("===================================");
									break;
								} // while문에서 1번을 선택했을 경우 실행되는 if문 종료

							} // default의 while문 종료

						} // switch(namera)문 종료

					} // while(namer)문 종료
					
					
				default:
					System.out.println("프로그램을 재실행해 회원가입을 처음부터 다시 진행하세요.");
					System.out.println("===================================");
					break;
				} // 이름 switch문 종료

				if (namee == 1 || namee == 2) { // 이름 switch문에서 1번 또는 2번을 입력했을 때 실행되는 if문 시작
					System.out.print("사용하실 아이디를 입력하세요: ");
					String id = input.next();
					System.out.println(id + "는 사용 가능한 아이디입니다.");
					System.out.println("==================================="); // 아이디
					System.out.print("이 아이디를 사용하시겠습니까? YES/NO: ");
					String idyn = input.next();

					if (idyn.equalsIgnoreCase("yes")) {
						System.out.print("비밀번호를 입력하세요: ");
						String pw = input.next();
						System.out.print("비밀번호를 한번 더 입력하세요: ");
						String pwre = input.next();
						System.out.println("==================================="); // 비밀번호

						boolean pass = true; // 무한반복용 코드

						while (pass) { // 비밀번호 입력이 동일한지의 while문 시작
							if (pw.equals(pw) && pwre.equals(pw)) { // 비밀번호가 동일한지에 대해 실행되는 if문 시작
								System.out.println("비밀번호가 동일합니다.");
								System.out.println("===================================");
								pass = false;
							} else {
								System.out.println("비밀번호가 다릅니다.");
								System.out.print("비밀번호를 다시 입력하세요: ");
								String pwree = input.next();
								System.out.println("===================================");
							} // 비밀번호가 동일한지에 대해 실행되는 if문 종료

						} // 비밀번호 입력이 동일한지의 while문 종료

						System.out.println("전화번호 입력창으로 넘어가는 중입니다.");
						System.out.print("전화번호를 입력하세요(-제외): "); // 전화번호 입력
						long phone = input.nextLong();
						System.out.println("입력하신 전화번호는" + phone + "입니다.");
						System.out.println("===================================");

						System.out.print("주민번호를 입력하세요(-제외): "); // 주민번호 입력
						String num = input.next();
						char number = num.charAt(6); // 7번째 글자를 추출

						switch (number) { // 주민번호 7번째 글자를 추출해 성별을 알아내는 switch문 시작
						case '1':
						case '3':
						case '5':
						case '7':
							System.out.println("성별은 남자입니다.");
							System.out.println("===================================");
							break;

						case '2':
						case '4':
						case '6':
						case '8':
							System.out.println("성별은 여자입니다.");
							System.out.println("===================================");
							break;

						default:
							System.out.println("당신은 외계인입니다.");
							System.out.println("당신의 별로 돌아가세요.");
							System.out.println("===================================");
							System.out.println("프로그램을 종료합니다.");
						} // 주민번호 7번째 글자를 추출해 성별을 알아내는 switch문 종료

						System.out.print("개인정보 활용에 동의하시겠습니까? YES/NO: "); // 개인정보 활용
						String infyn = input.next();
						if (infyn.equalsIgnoreCase("yes")) { // 개인정보 활용 동의 if문 시작
							System.out.println("회원가입에 성공하셨습니다.");
						} else {
							System.out.println("회원가입에 실패하셨습니다.");
						} // 개인정보 활용 동의 if문 종료
						pass = false;
					} else {
						System.out.print("사용하실 아이디를 입력하세요: ");
						String idr = input.next();
						System.out.println(id + "는 사용 가능한 아이디입니다.");
						System.out.println("==================================="); // 아이디
						System.out.print("이 아이디를 사용하시겠습니까? YES/NO");
						String idynn = input.next();
					}

				} // 이름 switch문에서 1번 또는 2번을 입력했을 때 실행되는 if문 시작

				sign = false;

			} // 회원가입 while문 종료
		} else { // yes를 입력하지 않았을 때 실행하는 if문
			System.out.println("회원가입에 실패하셨습니다.");
			System.out.println("회원가입을 진행하고 싶으면 프로그램을 재실행하세요.");
		} // 회원가입 yes if문 종료

	} // main 메서드 종료

}
// class 종료
