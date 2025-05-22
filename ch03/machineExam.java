package ch03;

import java.util.Scanner;

public class machineExam {

	public static void main(String[] args) {
		// 자판기 프로그램 만들기

		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		Scanner inputMenu = new Scanner(System.in);
		Scanner inputPrice = new Scanner(System.in);
		Scanner inputSta = new Scanner(System.in);
		Scanner inputPay = new Scanner(System.in);

		boolean run = true;
		boolean session = true;

		boolean manager = true;
		int Sta = 0;

		boolean user = true;
		String call;
		int payr = 0;

		String[] Menus = { "파워에이드", "2프로", "코카콜라", "펩시콜라", "피크닉", "하늘보리", "캔커피", "맑은샘물", };
		int[] prices = { 2000, 1800, 2000, 2000, 1200, 1600, 1000, 700 };

		System.out.print("자판기를 사용하시겠습니까? YES/NO: ");
		String yn = inputStr.next();

		if (yn.equalsIgnoreCase("yes")) {

			System.out.println("자판기 ON");

			while (run) {
				System.out.println("1. 관리자모드");
				System.out.println("2. 사용자모드");
				System.out.println("9. 자판기 OFF");
				System.out.print("실행할 번호를 입력하세요: ");
				int mod = inputStr.nextInt();
				System.out.println("======================");

				switch (mod) {

				case 1:
					System.out.println("관리자 모드에 진입하셨습니다.");
					session = Manager(manager, session, Menus, prices, Sta);
					break;

				case 2:
					System.out.println("사용자 모드에 진입하셨습니다.");
					session = User(user, session, Menus, prices/* , call */);
					break;

				case 9:
					System.out.println("자판기 OFF");
					run = false;
					break;

				default:
					System.out.println("다시 입력하세요: ");

				} // switch 종료

			} // while(run) 종료
		} else {
			System.out.println("자판기 OFF");
		} //

	} // main 메서드 종료

	private static boolean User(boolean user, boolean session, String[] Menus, int[] prices/* , String call */) {
		// 사용자모드

		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		Scanner inputMenu = new Scanner(System.in);
		Scanner inputPrice = new Scanner(System.in);
		Scanner inputSta = new Scanner(System.in);
		Scanner inputPay = new Scanner(System.in);

		while (user) {
			System.out.println("1. 메뉴보기");
			System.out.println("2. 결제하기");
			System.out.println("3. 결재내역");
			System.out.println("4. 메인으로 돌아가기");
			System.out.print("실행하려는 메뉴를 입력하세요: ");
			int enroll = inputInt.nextInt();
			System.out.println("======================");

			switch (enroll) {

			case 1:
				System.out.println("메뉴를 불러옵니다.");
				System.out.println("메뉴는 총 " + Menus.length + "개입니다.");
				for (int i = 0; i < Menus.length; i++) {
					System.out.println((i + 1) + "번 메뉴: " + Menus[i] + " " + prices[i]);
				} // 메뉴 보기 for문 종료
				break;

			case 2:
				System.out.println("결제를 진행합니다.");

				System.out.println("미리 지불할 금액을 입력합니다.");
				System.out.print("금액: ");
				int payr = inputPay.nextInt();
				System.out.println("지불한 금액은 " + payr + "원입니다.");

				System.out.print("결제할 메뉴를 입력하세요: ");
				String pay = inputMenu.next();

				for (int i = 0; i < Menus.length; i++) {
					if (Menus[i].equals(pay)) { // 키보드로 입력한 값이 메뉴 배열에 같은 값이 있는지 파악

						System.out.println(Menus[i] + "의 금액: " + prices[i]);
						System.out.println("=================");

						System.out.println(payr + "원에서 " + prices[i] + "원을 결제합니다.");
						System.out.println("거스름돈 " + (payr - prices[i]) + "원입니다.");
						System.out.println("=================");

					} // 키보드에 입력한 값이 메뉴 배열에 있을 때 실행되는 if문 종료
					
				} // 메뉴 수정 for문 종료

				break;
				
			case 3:
				System.out.print("결재 내역을 확인하시겠습니까? YES/NO: ");
				String yn2 = inputStr.next();
				/*if (yn2.equalsIgnoreCase("yes")) {
					System.out.println("구매한 물품은 " + payr + "과 사용한 총 금액은 " + prices[i] + "입니다.");
				} else {
					System.out.println("메인 메뉴로 돌아갑니다.");
				}*/
				
				
			case 4:
				System.out.println("메인으로 돌아갑니다."); // 메인으로 돌아가기
				user = false;
				break;


			default:
				System.out.println("1~4번을 입력해주세요.");

			} // 메뉴 switch문 종료

		} // while(user) 종료

		return session;

	} // 사용자모드 종료

	static boolean Manager(boolean manager, boolean session, String[] Menus, int[] prices, int Sta) {
		// 관리자모드

		Scanner inputStr = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		Scanner inputMenu = new Scanner(System.in);
		Scanner inputPrice = new Scanner(System.in);
		Scanner inputSta = new Scanner(System.in);

		while (manager) {

			System.out.println("1. 메뉴 등록");
			System.out.println("2. 메뉴 보기");
			System.out.println("3. 메뉴 수정");
			System.out.println("4. 메뉴 삭제");
			System.out.println("5. 매출 확인");
			System.out.println("6. 메인으로 돌아가기");
			System.out.print("실행하려는 메뉴를 입력하세요: ");
			int enroll = inputInt.nextInt();
			System.out.println("======================");

			switch (enroll) {

			case 1:
				System.out.println("메뉴를 등록합니다."); // 메뉴를 등록하고

				System.out.print("등록할 메뉴 개수를 입력하세요: ");
				int num = inputInt.nextInt();
				String[] num1 = new String[num];

				for (int i = 0; i < Menus.length; i++) { // 반복 메뉴 입력
					System.out.print("메뉴명을 입력하세요: ");
					Menus[i] = inputMenu.next();
					System.out.print("금액을 입력하세요: ");
					prices[i] = inputPrice.nextInt();
					break;
				} // 메뉴 등록 for문 종료

				System.out.println("메뉴 등록이 완료되었습니다.");
				break;

			case 2:
				System.out.println("메뉴를 불러옵니다."); // 등록한 메뉴를 불러오고
				System.out.println("메뉴는 총 " + Menus.length + "개입니다.");
				for (int i = 0; i < Menus.length; i++) {
					System.out.println(Menus[i] + " " + prices[i]);
				} // 메뉴 보기 for문 종료
				break;

			case 3:
				System.out.println("메뉴를 수정합니다."); // 등록한 메뉴를 변경하고
				System.out.print("수정하려는 메뉴명을 입력하세요: "); // 변경 2가지 이름, 또는 가격 price를 가격 수정으로
				String name = inputMenu.next();

				for (int i = 0; i < Menus.length; i++) {
					if (Menus[i].equals(name)) { // 키보드로 입력한 값이 메뉴 배열에 같은 값이 있는지 파악

						System.out.println(Menus[i] + "의 금액: " + prices[i]);
						System.out.println("=================");
						System.out.println("수정할 메뉴의 메뉴명과 금액을 입력하세요.");
						System.out.print("메뉴명을 입력하세요: ");
						Menus[i] = inputMenu.next();
						System.out.print("금액을 입력하세요: ");
						prices[i] = inputPrice.nextInt();
					} // 키보드에 입력한 값이 메뉴 배열에 있을 때 실행되는 if문 종료
				} // 메뉴 수정 for문 종료
				break;

			case 4:
				System.out.println("메뉴를 삭제합니다."); // 등록한 메뉴를 삭제하고
				System.out.println("메뉴는 총 " + Menus.length + "개입니다.");
				for (int i = 0; i < Menus.length; i++) {
					System.out.println((i + 1) + "번 " + Menus[i] + " " + prices[i]);
				} // 메뉴 보기 for문 종료
				System.out.print("삭제할 메뉴명의 번호를 입력하세요: "); // 현재 메뉴명만 삭제됨
				int deleteMenu = inputMenu.nextInt();
				Menus[deleteMenu - 1] = null;
				System.out.println("메뉴가 삭제되었습니다.");
				break;

			case 5:
				System.out.println("매출을 확인합니다."); // 매출을 확인
				break;

			case 6:
				System.out.println("메인으로 돌아갑니다."); // 메인으로 돌아가기
				manager = false;
				break;

			default:
				System.out.println("1~6번을 입력해주세요.");

			} // 메뉴 switch문 종료

		} // while(manager) 관리자모드 종료

		return session;

	} // 관리자 모드 종료

} // class 종료
