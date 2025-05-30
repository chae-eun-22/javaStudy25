package ch02;

import java.util.Scanner;

public class methodExam {

	public static void main(String[] args) {
		// 응용하기

		Scanner input = new Scanner(System.in);
		boolean run = true;
		String id = "ce"; // 아이디
		String pw = "123"; // 비밀번호
		boolean session = false;
		boolean Log = true;
		String Login = "0"; // 사용자가 입력하는 비밀번호 보관용
		int hits = 0; // 비밀번호 카운트용
		int score = 0;
		double avg = 0;
		boolean korr = true;
		

		while (run) { // while(run) 시작
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 성적 계산");
			System.out.println("9. 로그아웃");
			System.out.print("보고 싶은 메뉴를 입력하세요: ");
			String menu = input.next();

			switch (menu) {
			case "1", "회원가입", "회원", "가입":
				System.out.println("회원가입을 진행합니다.");
				break;

			case "2", "로그인":
				System.out.println("로그인을 진행합니다.");
				session = LoginOk(id, pw, session, Log, Login, hits);

				if (session == true && Log == true) { // session, log if문 시작
					System.out.println(id + "님 환영합니다.");
					System.out.println("3번과 9번 메뉴를 사용하실 수 있습니다.");
				} else {
					System.out.println("로그인에 실패하셨습니다. 메뉴로 이동합니다.");
				} // session, log if문 종료

				break;

			case "3", "성적 계산", "성적", "계산":
				System.out.println("성적 계산 메뉴로 이동합니다.");
				session = Grade(korr, id, score, avg, session);
				
				
				if (korr == true) { // korr if문 시작
					System.out.println("성적 계산 완료. 메뉴로 이동합니다.");
				} else {
					System.out.println("성적 계산 실패. 메뉴로 이동합니다.");
				}  // korr if문 종료
				
				break;

			case "9", "로그아웃", "아웃":
				System.out.println("로그아웃되었습니다.");
				run = false;
				break;

			default:
				System.out.println("메뉴에 없습니다. 다시 입력하세요.");
				break;
			} // switch문 종료
		} // while(run) 종료

	} // main 메서드 종료

	static boolean LoginOk(String id, String pw, boolean session, boolean Log, String Login, int hits) { // LoginOk 시작
		// 로그인

		Scanner inputLogin = new Scanner(System.in);
		Scanner inputpwn = new Scanner(System.in);

		while (Log) { // while(Log) 시작
			
			System.out.print("아이디를 입력하세요: ");
			String inputId = inputLogin.next();
			System.out.print("비밀번호를 입력하세요: ");
			Login = inputpwn.next(); // 비밀번호 입력
			hits++; // 비밀번호 카운트용
			
			if (id.equals(inputId) && pw.equals(Login)) { // 처음 아이디 비밀번호 입력했을 때 동일한지의 if문 시작
				System.out.println("아이디 비밀번호가 동일합니다.");
				System.out.println("로그인되었습니다.");
				Log = true;
				break;
			} else { // 처음 아이디 비밀번호 입력했을 때 동일한지의 if문의 else
				if (hits <= 4) { // if(hits(비밀번호 틀릴 때 1회씩 증가, 총 5회 틀릴 시 멈춤)) 시작
					System.out.println("아이디 또는 비밀번호를 " + hits + "회 틀렸습니다.");
					System.out.print("아이디를 입력하세요: ");
					String inputIdr = inputLogin.next();
					System.out.print("비밀번호를 입력하세요: ");
					Login = inputpwn.next(); // 비밀번호 입력
					hits++; // 비밀번호 2번째부터의 카운트용
					if (id.equals(inputIdr) && pw.equals(Login)) { // 비밀번호 재입력한 후 비밀번호가 동일한지 틀렸는지를 실행하는 if문 시작
						System.out.println("아이디 비밀번호가 동일합니다.");
						System.out.println("로그인되었습니다.");
						session = true;
						break;
					} else { // 비밀번호 재입력한 후 비밀번호가 틀릴 때마다 횟수 증가하는 else(5회까지만)
						System.out.println("아이디 또는 비밀번호를 " + hits + "회 틀렸습니다.");
					} // 비밀번호 재입력한 후 비밀번호가 동일한지 틀렸는지를 실행하는 if문 종료
				} else {
					System.out.println("아이디 또는 비밀번호를 " + hits + "회 틀렸습니다.");
					Log = false;
					break;
				} // if(hits(비밀번호 틀릴 때 1회씩 증가, 총 5회 틀릴 시 멈춤)) 종료

			} // 처음 아이디 비밀번호 입력했을 때 동일한지의 if문 종료

		} // while(Log) 종료
		return session; // 로그인 성공과 실패를 리턴함

	} // LoginOk 종료

	static boolean Grade(boolean korr, String id, int score, double avg, boolean session) {
		
		Scanner inputGrade = new Scanner(System.in);
		
		while (korr) {
			System.out.print("국어 점수를 입력하세요: ");
			int kor = inputGrade.nextInt();

			if (kor > 0 && kor <= 100) { // 0보다 크거나 100이하이면 true
				System.out.println(id + "님이 입력하신 국어 점수는 " + kor + "점 입니다.");
			} else {
				System.out.println(id + "님이 입력하신 국어 점수는 " + kor + "점 입니다. 다시 입력해주세요.");
			} // 국어 점수 if문
			
			System.out.print("영어 점수를 입력하세요: ");
			int eng = inputGrade.nextInt();
			
			if (eng > 0 && eng <= 100) { // 0보다 크거나 100이하이면 true
				System.out.println(id + "님이 입력하신 영어 점수는 " + eng + "점 입니다.");
			} else {
				System.out.println(id + "님이 입력하신 영어 점수는 " + eng + "점 입니다. 다시 입력해주세요.");
			} // 영어 점수 if문
			
			System.out.print("수학 점수를 입력하세요: ");
			int math = inputGrade.nextInt();
			
			if (math > 0 && math <= 100) { // 0보다 크거나 100이하이면 true
				System.out.println(id + "님이 입력하신 수학 점수는 " + math + "점 입니다.");
			} else {
				System.out.println(id + "님이 입력하신 수학 점수는 " + math + "점 입니다. 다시 입력해주세요.");
			} // 수학 점수 if문
			
			
			if (avg > 0 && avg <= 100) { // 0보다 크거나 100이하이면 true
				if (avg >= 90) {
					System.out.println(id + "님의 총점은" + score + "점, 평균은" + avg + "점이므로 (A등급)입니다.");
					break;
				} else if (avg >= 80) {
					System.out.println(id + "님의 총점은" + score + "점, 평균은" + avg + "점이므로 (B등급)입니다.");
					break;
				} else if (avg >= 70) {
					System.out.println(id + "님의 총점은" + score + "점, 평균은" + avg + "점이므로 (C등급)입니다.");
					break;
				} else if (avg >= 60) {
					System.out.println(id + "님의 총점은" + score + "점, 평균은" + avg + "점이므로 (D등급)입니다.");
					break;
				} else {
					System.out.println(id + "님의 총점은" + score + "점, 평균은" + avg + "점이므로 (F등급)입니다.");
					korr = true;
					break;
				}
			} else {
				System.out.println(id + "님 0~100까지만 입력 가능합니다. 국어 점수부터 다시 입력해주세요.");
			} // 평균 등급 if문 종료
			
		} // while문 종료

		return session; // 리턴

	} // Grade 메서드 종료

} // class 종료
