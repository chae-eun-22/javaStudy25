package ch05.lineage;

import java.util.Scanner;

import ch05.lineage.DTO.Account;
import ch05.lineage.DTO.ElfDTO;
import ch05.lineage.DTO.KnightDTO;
import ch05.lineage.service.CharacterService;
import ch05.lineage.service.LoginService;

public class LinegeExam {

	public static Scanner scanner = new Scanner(System.in);

	public static Account[] accounts = new Account[10]; // 로그인용 배열
	public static Account LoginAccount; // 로그인 성공시 객체(세션 역할)
	public static KnightDTO knightDTO = new KnightDTO();
	public static ElfDTO elfDTO = new ElfDTO();

	static {
		knightDTO.setSword("양손검");
		knightDTO.setArmor("징박힌갑옷");
		knightDTO.setShield("징박힌방패");
		knightDTO.setName("양기사");
		knightDTO.setSex("남");
		knightDTO.setLevel("1");
		knightDTO.setHp(5000);
		knightDTO.setMp(50);
		knightDTO.setMoney(500000);
		
		
		elfDTO.setBow("양손활");
		elfDTO.setDress("천사드레스");
		elfDTO.setArrow("크리티컬화살");
		elfDTO.setName("저요정");
		elfDTO.setSex("여");
		elfDTO.setLevel("1");
		elfDTO.setHp(3000);
		elfDTO.setMp(2000);
		elfDTO.setMoney(10000000);
		
		
		Account account = new Account(); // 테스트용 계정 생성
		account.setId("pce");
		account.setPw("1234");
		account.setNickName("ce");
		accounts[0] = account; // 배열 0번에 계정 객체를 연결
		
	} // db 대신 초기값 지정 (생성자 대신)
	
	
	public static void main(String[] args) {
		// 객체 간의 상속을 알아본다.
		// 부모 객체 자식 객체에게 모든 정보를 상속한다.
		// 자식 객체는 부모 객체의 정보를 받아 사용하며 추가적인 정보를 생성하여 활용함
		
		System.out.println("=====리니지 게임을 시작합니다.=====");
		boolean run = true;
		
		while(run) {
			System.out.println("1. 로그인 | 2. 캐릭터 선택 | 3. 게임 실행 | 4. 종료");
			System.out.print(">>>");
			int select = scanner.nextInt();
			switch (select) {
			case 1:
				System.out.println("로그인을 시작합니다.");
				LoginAccount = LoginService.menu(scanner, accounts, LoginAccount);
				break;
				
			case 2:
				System.out.println("캐릭터를 선택합니다.");
				CharacterService.menu(scanner, LoginAccount, knightDTO, elfDTO);
				break;
				
			case 3:
				System.out.println("게임을 시작합니다.");
				break;
				
			case 4:
				System.out.println("종료합니다.");
				run = false;
				break;
				
			default:
				System.out.println("1~4까지만 입력하세요.");
				
			} // switch문 종료
			
		} // while문 종료
		
	} // main 메서드 종료

} // class 종료
