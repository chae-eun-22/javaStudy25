package ch05.mbcbank.service;

import java.util.Scanner;

import ch05.mbcbank.DTO.AccountDTO;

public class WoriBankService { // 서비스 계층은 CRUD 메서드 위주로 생성한다.
	// 필드

	// 생성자

	// 메서드 (부메뉴, 계좌 생성, 입금, 출금, 삭제, 이제 등...)

	public void menu(Scanner inputInt, Scanner inputStr, AccountDTO[] woriBank, AccountDTO[] nhBank,
			AccountDTO[] hanaBank) {
		boolean subRun = true;
		while (subRun) {
			System.out.println("-----------------");
			System.out.println("우리은행 계좌 관리 메서드입니다.");
			System.out.println("1. 계좌 생성");
			System.out.println("2. 계좌 목록");
			System.out.println("3. 예금");
			System.out.println("4. 출금");
			System.out.println("5. 이체");
			System.out.println("6. 종료");
			System.out.print(">>>");
			String select = inputStr.next();

			switch (select) {
			case "1":
				System.out.println("=== 계좌 생성 메서드로 진입합니다.===");
				createAccount(inputInt, inputStr, woriBank);
				break;

			case "2":
				System.out.println("===계좌 목록 보기 메서드로 진입합니다.===");
				accountLists(inputInt, inputStr, woriBank);
				break;

			case "3":
				System.out.println("===계좌 입금 메서드로 진입합니다.===");
				deposit(inputInt, inputStr, woriBank);
				break;

			case "4":
				System.out.println("===계좌 출금 메서드로 진입합니다.===");
				withdraw(inputInt, inputStr, woriBank);
				break;

			case "5":
				System.out.println("===계좌 이체 메서드로 진입합니다.===");
				transfer(inputInt, inputStr, woriBank, nhBank, hanaBank);
				break;

			case "6":
				System.out.println("우리은행을 종료합니다.");
				System.out.println("메인 메뉴로 복귀합니다.");
				subRun = false;
				break;

			default:
				System.out.println("1~6 값만 입력하세요.");
				break;

			} // switch(select) 종료

		} // while(subRun) 종료

	} // menu(부메뉴) 메서드 종료

	private void transfer(Scanner inputInt, Scanner inputStr, AccountDTO[] woriBank, AccountDTO[] nhBank,
			AccountDTO[] hanaBank) {
		// 내 계좌번호와 이체할 계좌번호를 입력하고 이체 금액을 입력하면 계좌번호를 찾아서 이체를 한다.
		
System.out.println("=======이체=======");
		
		System.out.print("내 계좌번호: ");
		String ano = inputStr.next();
		
		System.out.print("이체할 계좌번호: ");
		String transferAno = inputStr.next();
		
		System.out.print("이체액: ");
		int money = inputInt.nextInt();
		
		AccountDTO inputAccount = findAccount(ano, woriBank);
		// findAccount 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다. (반복 코드 배제용) -> 하나 은행
		AccountDTO inputAccount2 = findAccount2(transferAno, hanaBank , woriBank, nhBank);
		// findAccount2 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다. (반복 코드 배제용) -> 모든 은행
		
		if (inputAccount == null || inputAccount2 == null) {
			System.out.println("찾는 계좌번호가 없습니다.");
			return;
		}
		
		inputAccount2.setBalance(inputAccount2.getBalance() + money);
		System.out.println(inputAccount2.getOwner() + "님의 " + inputAccount2.getAno() + "에 " + money + "원 이체하셨습니다." );
		// toString으로 결과 보기

		inputAccount.setBalance(inputAccount.getBalance() - money);
		System.out.println(inputAccount.getOwner() + "님 이체 성공");
		System.out.println("내 계좌 잔액: " + inputAccount.getBalance() + "원");
		System.out.println("============================");
	}

	private AccountDTO findAccount2(String transferAno, AccountDTO[] hanaBank, AccountDTO[] woriBank,
			AccountDTO[] nhBank) {
		// 이체에서 계좌번호를 이용해 객체를 찾는 반복 코드 메서드
		
				AccountDTO account = null; // 빈 객체

				for (int i = 0; i < hanaBank.length; i++) {

					if (hanaBank[i] != null) {
						// 하나은행 배열이 null이 아님

						String dbAno = hanaBank[i].getAno();
						// 배열에 있는 계좌번호를 가져와 dbAno 변수에 넣음

						if (dbAno.equals(transferAno)) {
							// 키보드로 입력된 계좌번호와 dbAno와 같은 값을 찾는다.

							account = hanaBank[i]; // 빈 객체에 찾은 객체를 넣는다.
							break;

						} // 계좌번호가 같은지 판단 종료

					} // 빈 객체가 아닌지 판단 종료

				} // 배열 반복 종료
				
				for (int i = 0; i < woriBank.length; i++) {

					if (woriBank[i] != null) {
						// 하나은행 배열이 null이 아님

						String dbAno = woriBank[i].getAno();
						// 배열에 있는 계좌번호를 가져와 dbAno 변수에 넣음

						if (dbAno.equals(transferAno)) {
							// 키보드로 입력된 계좌번호와 dbAno와 같은 값을 찾는다.

							account = woriBank[i]; // 빈 객체에 찾은 객체를 넣는다.
							break;

						} // 계좌번호가 같은지 판단 종료

					} // 빈 객체가 아닌지 판단 종료

				} // 배열 반복 종료
				
				/*for (int i = 0; i < nhBank.length; i++) {

					if (nhBank[i] != null) {
						// 하나은행 배열이 null이 아님

						String dbAno = woriBank[i].getAno();
						// 배열에 있는 계좌번호를 가져와 dbAno 변수에 넣음

						if (dbAno.equals(transferAno)) {
							// 키보드로 입력된 계좌번호와 dbAno와 같은 값을 찾는다.

							account = nhBank[i]; // 빈 객체에 찾은 객체를 넣는다.
							break;

						} // 계좌번호가 같은지 판단 종료

					} // 빈 객체가 아닌지 판단 종료

				} // 배열 반복 종료*/

				return account;
			} // 이체용 메서드 종료

	private void withdraw(Scanner inputInt, Scanner inputStr, AccountDTO[] woriBank) {
		// 계좌번호를 입력하고 입금액을 입력하면 계좌번호를 찾아서 계좌잔액을 감소시킨다.

		System.out.println("==========출금==========");

		System.out.print("계좌번호: ");
		String ano = inputStr.next();

		System.out.print("출금액: ");
		int money = inputInt.nextInt();

		AccountDTO inputAccount = findAccount(ano, woriBank);
		// findAccount 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다.(반복 코드 배제용)

		if (inputAccount == null) {
			System.out.println("찾는 계좌번호가 없습니다.");
			return;
		}

		inputAccount.setBalance(inputAccount.getBalance() - money);
		System.out.println("출금 테스트 결과: " + inputAccount);
		// toString으로 결과 보기

		System.out.println(inputAccount.getOwner() + "님 출금 성공");
		System.out.println("잔액: " + inputAccount.getBalance() + "원");
		System.out.println("=========================");

	} // 출금용 메서드

	private void deposit(Scanner inputInt, Scanner inputStr, AccountDTO[] woriBank) {
		// 계좌번호를 입력하고 입금액을 입력하면 계좌번호를 찾아서 계좌잔액을 증가시킨다.

		System.out.println("==========예금==========");

		System.out.print("계좌번호: ");
		String ano = inputStr.next();

		System.out.print("예금액: ");
		int money = inputInt.nextInt();

		AccountDTO inputAccount = findAccount(ano, woriBank);
		// findAccount 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다.(반복 코드 배제용)

		if (inputAccount == null) {
			System.out.println("찾는 계좌번호가 없습니다.");
			return;
		}

		inputAccount.setBalance(inputAccount.getBalance() + money);
		System.out.println("입금 테스트 결과: " + inputAccount);
		// toString으로 결과 보기

		System.out.println(inputAccount.getOwner() + "님 입금 성공");
		System.out.println("잔액: " + inputAccount.getBalance() + "원");
		System.out.println("=========================");

	} // 입금용 메서드

	private AccountDTO findAccount(String ano, AccountDTO[] woriBank) {
		// 입금, 출금, 이체에서 계좌번호를 이용해 객체를 찾는 반복 코드 메서드
		AccountDTO account = null; // 빈 객체

		for (int i = 0; i < woriBank.length; i++) {

			if (woriBank[i] != null) {
				// 우리은행 배열이 null이 아님
				String dbAno = woriBank[i].getAno();
				// 배열에 있는 계좌번호를 가져와 dbAno 변수에 넣음

				if (dbAno.equals(ano)) {
					// 키보드로 입력된 계좌번호와 dbAno와 같은 값을 찾는다.
					account = woriBank[i]; // 빈 객체에 찾은 객체를 넣는다.
					break;
				} // 계좌번호가 같은지 판단 종료

			} // 빈 객체가 아닌지 판단 종료

		} // 배열 반복 종료

		return account;

	} // 계좌 찾기 메서드 종료

	private void accountLists(Scanner inputInt, Scanner inputStr, AccountDTO[] woriBank) {
		// 우리은행에 계정을 모두 본다(은행원용)
		System.out.println("-----우리은행 계좌 리스트-----");

		for (int i = 0; i < woriBank.length; i++) {

			AccountDTO accountlist = woriBank[i]; // woriBank[i] 가져온다
			if (accountlist != null) {
				// 배열에 null이 아니면 출력

				System.out.print(accountlist.getAno());
				System.out.print("\t");

				System.out.print(accountlist.getOwner());
				System.out.print("\t");

				System.out.print(accountlist.getBalance());
				System.out.print("\t\n");
				System.out.println("--------------------");

			}
		}

	}

	private void createAccount(Scanner inputInt, Scanner inputStr, AccountDTO[] woriBank) {
		// 우리은행 배열에 새로운 객체를 넣는다.

		System.out.println("-----계좌 생성-----");
		AccountDTO myAccount = new AccountDTO(); // 빈 객체 생성

		System.out.print("계좌번호: ");
		myAccount.setAno(inputStr.next());

		System.out.print("계좌주: ");
		myAccount.setOwner(inputStr.next());

		System.out.print("초기 입금액: ");
		myAccount.setBalance(inputInt.nextInt()); // 21억까지 입금

		myAccount.setBankname("우리은행"); // 빈 객체에 데이터 입력 완료

		// 우리은행 배열에 객체를 삽입(null인지 확인하고 넣음)
		for (int i = 0; i < woriBank.length; i++) {

			if (woriBank[i] == null) {
				// 우리은행 배열에 null 값이면 처리하는 코드
				woriBank[i] = myAccount; // 배열에 입력한 객체 연결
				System.out.println("계좌 입력 완료 테스트 " + woriBank[i]);
				break; // 1개만 입력하기 위함
				// toString으로 테스트 결과가 보임
			}

		} // 우리은행 배열을 0번에서부터 반복 코드

		System.out.println("계좌 생성이 정상적으로 처리되었습니다.");

	} // createAccount(계좌 생성) 메서드 종료

} // 우리 은행 class 종료
