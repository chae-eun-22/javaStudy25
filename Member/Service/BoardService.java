package Member.Service;

import java.sql.SQLException;
import java.util.Scanner;

import Member.DAO.BoardDAO;
import Member.DTO.BoardDTO;
import Member.DTO.MemberDTO;

public class BoardService {
	// DAO�� DTO�� ����Ͽ� �θ޴��� CRUD�� ó��
	
	// �ʵ�
	public BoardDAO boardDAO = new BoardDAO(); // 1�ܰ�, 2�ܰ谡 ����ȴ�
	
	// ������
	
	// �޼���(�θ޴�, ����, ��κ���, 1������, �����ϱ�, �����ϱ�)
	public MemberDTO subMenu(Scanner input, MemberDTO session) throws SQLException {
		boolean subRun = true;
		
		while (subRun) {
			System.out.println("�Խ��� �����Դϴ�.");
			System.out.println("1. �Խñ� �ۼ�");
			System.out.println("2. �Խñ� �ڼ�������");
			System.out.println("3. �Խñ� ��ü����");
			System.out.println("4. �Խñ� ����");
			System.out.println("5. �Խñ� ����");
			System.out.println("6. ���� �Խ��� �޴��� ���ư���");
			System.out.print(">>>");
			String subSelect = input.next();
			
			switch (subSelect) {
			case "1":
				System.out.println("�Խñ� �ۼ� �޼���� �����մϴ�.");
				insertBoard(boardDAO, input, session);
				break;
				
			case "2":
				System.out.println("�Խñ� �ڼ��� ���� �޼���� �����մϴ�.");
				readOne(input, session);
				break;
				
			case "3":
				System.out.println("�Խñ� ��ü ���� �޼���� �����մϴ�.");
				selectAll(boardDAO, session);
				break;
				
			case "4":
				System.out.println("�Խñ� ���� �޼���� �����մϴ�.");
				modify(input, session);
				break;
				
			case "5":
				System.out.println("�Խñ� ���� �޼���� �����մϴ�.");
				deleteOne(input, session);
				break;
				
			case "6":
				System.out.println("�Խ��� ���� ����. ���� �Խ��� �޴��� ���ư��ϴ�.");
				boardDAO.connection.close(); // �Խ��� ����� connection ����
				subRun = false;
				break;
				
			default:
				System.out.println("1~6�������� �Է��ϼ���.");
				break;
				
			} // switch��(�θ޴�) ����
			
		} // while��(�θ޴� �ݺ�) ����
		
		return session;
		
	} // subMenu �޼��� ����

	private MemberDTO deleteOne(Scanner input, MemberDTO session) throws SQLException {
		// ������ ã�Ƽ� ���� �α����� ���̵� �ۼ����� ���̵�� �����ؾ� �ϰ� �Է��� ��й�ȣ�� ������ ���� �Խñ��� ������ �� �ִ�.
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId());
		
		System.out.print("�����Ϸ��� �Խñ��� ������ �Է��ϼ���: ");
		String selecttitle = input.next();
		
		System.out.print("������ �Խñ۸� ���� �����մϴ�. ��й�ȣ�� �Է��ϼ���: ");
		String pw = input.next();
		
		boardDAO.deleteOne(selecttitle, pw, session);
		
		return session;
		
	} // deleteOne(�Խñ� ����) �޼��� ����

	private MemberDTO modify(Scanner input, MemberDTO session) throws SQLException {
		// ������ ã�Ƽ� ���� �α����� ���̵� �ۼ����� ���̵�� �����ؾ� �ϰ� �Է��� ��й�ȣ�� ������ ���� �Խñ��� ������ �� �ִ�.
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId());
		

		System.out.print("�����Ϸ��� �Խñ��� ������ �Է��ϼ���: ");
		input.nextLine(); // ���� ����
		String title = input.nextLine();
		
		System.out.print("������ �Խñ۸� ���� �����մϴ�. ��й�ȣ�� �Է��ϼ���: ");
		String pw = input.next();
		
		boardDAO.modify(title, pw, input, session);
		System.out.println("=========modify �޼��� ����========");
		
		return session;
	
	} // modify(�Խñ� ����) �޼��� ����

	private MemberDTO selectAll(BoardDAO boardDAO, MemberDTO session) throws SQLException {
		// DAO���� ��ü���� �ϴ� ���񽺸� �����Ѵ�.
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId() + "�Դϴ�.");
		
		System.out.println("==========================");
		System.out.println("======�Խ��� ����Դϴ�.======");
		boardDAO.selectAll();
		System.out.println("==========================");
		
		return session;
		
	} // selectAll(�Խñ� ��ü����) �޼��� ����

	private MemberDTO readOne(Scanner input, MemberDTO session) throws SQLException {
		// ������ �Է��ϸ� ������ ���̵��� select ó��
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId() + "�Դϴ�.");
		
		System.out.print("���� ���� �Խñ��� ������ �Է��ϼ���: ");
		String title = input.next();
		
		boardDAO.readOne(title, session);
		System.out.println("=======readOne �޼��� ����========");
		
		return session;
		
	} // readOne(�Խñ� �ڼ�������) �޼��� ����

	private MemberDTO insertBoard(BoardDAO boardDAO, Scanner input, MemberDTO session) throws SQLException {
		// Ű����� �Է��� �����͸� DTO�� ����Ͽ� �����ͺ��̽��� insert
		
		BoardDTO boardDTO = new BoardDTO(); // ��ü ����
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId());
		
		System.out.println("�ۼ���: " + session.getId());
		boardDTO.setBwriter(session.getId());		
		
		System.out.print("����: ");
		boardDTO.setBtitle(input.next());
		
		input.nextLine(); // ���� ���� Line �� ���� ����� ������ ���� ����!!
		
		System.out.print("����: ");
		boardDTO.setBcontent(input.nextLine()); // ���Ⱑ �ִ� ������ nextLine()
		
		boardDAO.insertBoard(boardDTO, session); // ������ ���� ��ü�� DAO���� ����
		System.out.println("============insertBoard �޼��� ����=============");
		
		return session;
		
	} // insertBoard(�Խñ� �ۼ�) �޼��� ����

} // class ����
