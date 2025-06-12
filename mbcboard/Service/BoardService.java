package mbcboard.Service;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.DAO.BoardDAO;
import mbcboard.DAO.MemberDAO;
import mbcboard.DTO.BoardDTO;
import mbcboard.DTO.MemberDTO;

public class BoardService {
	// DAO와 DTO를 사용하여 부메뉴와 CRUD를 처리
	
	// 필드
	public BoardDAO boardDAO = new BoardDAO(); // 1단계, 2단계가 수행 된다

	// 생성자

	// 메서드 (부메뉴, 생성, 모두보기, 1개보기, 수정하기, 삭제하기)
	public MemberDTO subMenu(Scanner inputStr, MemberDTO session) throws SQLException {
		boolean subRun = true;
		while (subRun) {
			System.out.println("MBC아카데미 게시판 서비스입니다.");
			System.out.println("1. 모두보기");
			System.out.println("2. 게시글 작성");
			System.out.println("3. 게시글 자세히보기");
			System.out.println("4. 게시글 수정");
			System.out.println("5. 게시글 삭제");
			System.out.println("6. 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();

			switch (subSelect) {
			case "1":
				System.out.println("모든 게시글 보기");
				selectAll(boardDAO);
				break;

			case "2":
				System.out.println("게시글 작성 메서드로 진입합니다.");
				insertBoard(boardDAO, inputStr, session);
				break;

			case "3":
				System.out.println("게시글 자세히보기");
				readOne(inputStr, session);
				break;

			case "4":
				System.out.println("게시글 수정 메서드로 진입합니다.");
				modify(inputStr, session);
				break;

			case "5":
				System.out.println("게시글 삭제 메서드로 진입합니다.");
				deleteOne(session);
				break;

			case "6":
				System.out.println("게시글 보기 종료");
				boardDAO.connection.close(); // 게시판 종료시 connection 종료
				subRun = false;
				break;

			default:
				System.out.println("1~6번까지만 입력하세요.");

			} // switch문(부메뉴) 종료

		} // while문(부메뉴 반복) 종료
		
		return session;

	} // subMenu 메서드 종료

	private MemberDTO deleteOne(MemberDTO session) throws SQLException {
		// 게시물의 번호를 받아 삭제한다.
		Scanner inputInt = new Scanner(System.in);

		System.out.println("삭제하려는 게시글의 번호를 입력하세요.");
		System.out.print(">>>");
		int selectBno = inputInt.nextInt();
		boardDAO.deleteOne(selectBno, session);
		
		return session;

	} // deleteOne 메서드 종료

	private MemberDTO modify(Scanner inputStr, MemberDTO session) throws SQLException {
		// 제목을 찾아서 내용을 수정한다

		System.out.print("수정하려는 게시글의 제목을 입력하세요: ");
		String title = inputStr.next();
		
		System.out.print("본인의 게시글만 수정 가능합니다. 비밀번호를 입력하세요: ");
		String pw = inputStr.next();

		boardDAO.modify(title, pw, inputStr, session);
		System.out.println("==============끝=============");

		return session;
	}

	private MemberDTO readOne(Scanner inputStr, MemberDTO session) throws SQLException {
		// 제목을 입력하면 내용이 보이도록 select 처리
		
		System.out.println("현재 로그인 되어 있는 아이디: " + session.getId() + "입니다.");

		System.out.println("보고싶은 게시글의 제목을 입력하세요.");
		System.out.print(">>>");
		String title = inputStr.next();

		boardDAO.readOne(title, session);
		System.out.println("==========끝=========");
		
		return session;

	} // readOne 메서드 종료

	private MemberDTO insertBoard(BoardDAO boardDAO, Scanner inputStr, MemberDTO session) throws SQLException {
		// 키보드로 입력한 데이터를 DTO를 사용하여 데이터베이스에 insert

		Scanner inputLine = new Scanner(System.in);

		BoardDTO boardDTO = new BoardDTO(); // 빈객체 생성

		System.out.println("작성자: " + session.getName());

		System.out.print("제목: ");
		boardDTO.setBtitle(inputStr.next());

		System.out.print("내용: ");
		boardDTO.setBcontent(inputLine.nextLine()); // 띄어쓰기가 있는 문장은 nextLine()

		boardDAO.insertBoard(boardDTO, session); // 위에서 만든 객체를 DAO에게 전달
		System.out.println("==========insertBoard 메서드 종료============");

		return session;
		
	} // insertBoard 메서드 종료

	private void selectAll(BoardDAO boardDAO) throws SQLException {
		// DAO에게 전체보기 하는 서비스를 제공한다.

		System.out.println("==============================");
		System.out.println("======MBC 게시판 목록입니다.======");
		boardDAO.selectAll();
		System.out.println("==============================");

	} // selectAll(전체 보기) 메서드 종료

} // class 종료
