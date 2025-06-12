package mbcboard.Service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.DAO.MemberDAO;
import mbcboard.DTO.BoardDTO;
import mbcboard.DTO.MemberDTO;

public class MemberService {
	// DAO와 DTO를 사용하여 부메뉴와 CRUD를 처리

	// 필드
	public MemberDAO memberDAO = new MemberDAO(); // 1단계, 2단계가 수행

	// 생성자

	// 메서드 (부메뉴, 회원가입, 로그인, 모든 회원정보 보기, 개인 회원정보 보기, 회원정보 수정, 회원정보 삭제)
	public MemberDTO subMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		boolean subRun = true;
		
		while (subRun) {
			System.out.println("MBC아카데미 회원 서비스입니다.");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원정보 보기");
			System.out.println("4. 회원정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.println("6. 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();

			switch (subSelect) {
			case "1":
				System.out.println("회원가입 메서드로 진입합니다.");
				sign(memberDAO, inputStr, session);
				break;

			case "2":
				System.out.println("로그인 메서드로 진입합니다.");
				session = login(memberDAO, inputStr, session);
				break;

			case "3":
				System.out.println("회원정보 보기 메서드로 진입합니다.");
				readOne(memberDAO, inputStr, session);
				break;

			case "4":
				System.out.println("회원정보 수정 메서드로 진입합니다.");
				modify(inputStr, session);
				break;

			case "5":
				System.out.println("회원 탈퇴 메서드로 진입합니다.");
				deleteOne(inputStr, session);
				break;

			case "6":
				System.out.println("회원 서비스 종료");
				memberDAO.connection.close(); // 게시판 종료시 connection 종료
				subRun = false;
				break;

			case "99":
				System.out.println("히든 번호를 입력하셨습니다. 모든 회원정보 보기 메서드로 진입합니다.");
				selectAll(memberDAO, session);
				break;

			default:
				System.out.println("1~6번까지만 입력하세요.");
				
			} // switch문(부메뉴) 종료

		} // while문(부메뉴 반복) 종료
		
		return session;

	} // subMenu 메서드 종료

	private MemberDTO selectAll(MemberDAO memberDAO, MemberDTO session) throws SQLException {
		// DAO에게 전체보기 하는 서비스를 제공한다. (선택지에 없는 히든 창)

		System.out.println("==============================");
		System.out.println("=======모든 회원 목록입니다.=======");
		memberDAO.selectAll(session);
		System.out.println("==============================");

		return session;
		
	} // selectAll(모든 회원정보 보기) 메서드 종료

	private MemberDTO deleteOne(Scanner inputStr, MemberDTO session) throws SQLException {
		// 회원 아이디와 비밀번호를 받아 삭제한다.

		System.out.println("현재 로그인 되어있는 아이디는: " + session.getId() + "입니다.");
		
		System.out.println("탈퇴하려는 회원의 아이디를 입력하세요: ");
		String selectid = inputStr.next();

		System.out.println("다시는 되돌릴 수 없습니다. 정말로 회원 탈퇴 하시겠습니까? YES/NO: ");
		String yn = inputStr.next();

		if (yn.equalsIgnoreCase("Yes")) {
			
			session.getPw();
			
			System.out.print("정말로 탈퇴하려면 현재 비밀번호를 입력하세요: ");
			String selectpw = inputStr.next();
			
			memberDAO.deleteOne(selectid, selectpw, session);

		} else {

			System.out.println("회원 서비스 화면으로 돌아갑니다.");

		}
		
		return session;

	} // 회원 탈퇴 메서드 종료

	private MemberDTO modify(Scanner inputStr, MemberDTO session) throws SQLException {
		// 아이디를 찾아서 회원정보를 수정한다
		
		System.out.println("현재 로그인 되어있는 아이디는: " + session.getId() + "입니다.");

		System.out.print("비밀번호를 입력하세요: ");
		String pw = inputStr.next();

		memberDAO.modify(pw, inputStr, session);
		System.out.println("==============끝=============");
		
		return session;
		
	} // 회원정보 수정 메서드 종료

	private MemberDTO readOne(MemberDAO memberDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		// 회원정보 보기 메서드

		System.out.println("현재 로그인 되어있는 아이디는: " + session.getId() + "입니다.");
		
		session.getId();
		
		System.out.print("비밀번호를 입력하세요: ");
		String pw = inputStr.next();
		
		memberDAO.readOne(pw, session);
		System.out.println("=============끝==============");

		return session;
		
	} // 회원정보 보기 메서드 종료

	private MemberDTO login(MemberDAO memberDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		// 회원가입한 아이디와 비밀번호로 로그인한다
		
		session = new MemberDTO();

		System.out.print("아이디를 입력하세요: ");
		String id = inputStr.next();
		session.setId(id);

		System.out.println("비밀번호를 입력하세요: ");
		String pw = inputStr.next();
		session.setPw(pw);

		session = memberDAO.login(session);
		System.out.println("==============끝=============");
		
		return session;

	} // 로그인 메서드 종료

	private MemberDTO sign(MemberDAO memberDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		// 키보드로 입력한 데이터를 DTO를 사용하여 데이터베이스에 insert

		MemberDTO memberDTO = new MemberDTO(); // 빈객체 생성

		System.out.println("회원가입을 진행합니다.");

		System.out.print("이름을 입력하세요: ");
		memberDTO.setName(inputStr.next());

		System.out.print("아이디를 입력하세요: ");
		memberDTO.setId(inputStr.next());

		System.out.print("비밀번호를 입력하세요: ");
		memberDTO.setPw(inputStr.next());

		memberDAO.sign(memberDTO); // 위에서 만든 객체를 DAO에게 전달
		System.out.println("==========회원가입 메서드 종료============");

		return session;
		
	} // 회원가입 메서드 종료

} // class 종료
