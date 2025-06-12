package mbcboard;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.DTO.MemberDTO;
import mbcboard.Service.BoardService;
import mbcboard.Service.MemberService;

public class BoardExam {
	// 필드
	public static Scanner inputStr = new Scanner(System.in);
	static MemberDTO session = null;
	
	// 생성자 -> static 블럭
	
	
	// 메서드
	public static void main(String[] args) throws SQLException {
		// MBC 게시판용 jdbc 테스트
		// DTO: 객체를 담당
		// DAO: 데이터베이스에서 연동을 담당
		// service: 부메뉴와 서비스를 담당
		boolean run = true;
		
		while (run) {
			System.out.println("MBC 자유 게시판입니다.");
			System.out.println("1. 회원");
			System.out.println("2. 게시판");
			System.out.println("3. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			
			switch (select) {
			
			case "1":
				System.out.println("회원용 서비스로 진입합니다.");
				MemberService memberService = new MemberService();
				session = memberService.subMenu(inputStr, session);
				break;
				
			case "2":
				System.out.println("게시판 서비스로 진입합니다.");
				BoardService boardService = new BoardService();
				boardService.subMenu(inputStr, session);
				break;
				
			case "3":
				System.out.println("자유 게시판 프로그램 종료합니다.");
				run = false;
				break;
				
			default:
				System.out.println("1~3번까지만 입력하세요.");
				break;
				
			} // switch문 종료
			
		} // while문 종료

	} // main 메서드 종료

} // class 종료
