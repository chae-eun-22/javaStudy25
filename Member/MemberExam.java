package Member;

import java.sql.SQLException;
import java.util.Scanner;

import Member.Service.BoardService;
import Member.Service.MemberService;
import Member.DTO.MemberDTO;

public class MemberExam {
	// �ʵ�
	public static Scanner input = new Scanner(System.in);
	static MemberDTO session = null;
	
	// ������ -> static ��
	
	
	// �޼���
	public static void main(String[] args) throws SQLException {
		// DTO: ��ü�� ���
		// DAO: �����ͺ��̽����� ������ ���
		// service: �θ޴��� ���񽺸� ���
		boolean run = true;
		
		while (run) {
			System.out.println("���� �Խ����Դϴ�.");
			System.out.println("1. ȸ��");
			System.out.println("2. �Խ���");
			System.out.println("3. ����");
			System.out.print(">>>");
			String select = input.next();
			
			switch (select) {
			case "1":
				System.out.println("ȸ�� ���񽺷� �����մϴ�.");
				MemberService memberService = new MemberService();
				session = memberService.subMenu(input, session);
				break;
				
			case "2":
				System.out.println("�Խ��� ���񽺷� �����մϴ�.");
				BoardService boardService = new BoardService();
				boardService.subMenu(input, session);
				break;
				
			case "3":
				System.out.println("���� �Խ��� ���α׷��� �����մϴ�.");
				run = false;
				break;
				
			default:
				System.out.println("1~3�������� �Է��ϼ���.");
				break;
				
			} // switch�� ����
			
		} // while�� ����

	} // main �޼��� ����

} // class ����
