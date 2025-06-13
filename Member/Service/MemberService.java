package Member.Service;

import java.sql.SQLException;
import java.util.Scanner;

import Member.DAO.MemberDAO;
import Member.DTO.MemberDTO;

public class MemberService {
	// DAO�� DTO�� ����Ͽ� �θ޴��� CRUD�� ó��

	// �ʵ�
	public MemberDAO memberDAO = new MemberDAO(); // 1�ܰ�, 2�ܰ谡 ����

	// ������

	// �޼��� (�θ޴�, ȸ������, �α���, ��� ȸ������ ����, ���� ȸ������ ����, ȸ������ ����, ȸ������ ����
	public MemberDTO subMenu(Scanner input, MemberDTO session) throws SQLException {
		boolean subRun = true;

		while (subRun) {
			System.out.println("ȸ�� ���� �޴��Դϴ�.");
			System.out.println("1. ȸ������");
			System.out.println("2. �α���");
			System.out.println("3. ȸ������ ����");
			System.out.println("4. ȸ������ ����");
			System.out.println("5. ȸ�� Ż��");
			System.out.println("6. ���� �Խ��� �޴��� ���ư���");
			System.out.print(">>>");
			String subSelect = input.next();
			
			switch (subSelect) {
			case "1":
				System.out.println("ȸ������ �޼���� �����մϴ�.");
				sign(memberDAO, input, session);
				break;
				
			case "2":
				System.out.println("�α��� �޼���� �����մϴ�.");
				session = login(memberDAO, input, session);
				break;
				
			case "3":
				System.out.println("ȸ������ ���� �޼���� �����մϴ�.");
				readOne(memberDAO, input, session);
				break;
				
			case "4":
				System.out.println("ȸ������ ���� �޼���� �����մϴ�.");
				modify(input, session);
				break;
				
			case "5":
				System.out.println("ȸ�� Ż�� �޼���� �����մϴ�.");
				deleteOne(input, session);
				break;
				
			case "6":
				System.out.println("ȸ�� ���� ����. ���� �Խ��� �޴��� ���ư��ϴ�.");
				memberDAO.connection.close(); // ȸ�� ���� ����� connection ����
				subRun = false;
				break;
				
			case "99":
				System.out.println("���� ��ȣ�� �Է��ϼ̽��ϴ�. ��� ȸ������ ���� �޼���� �����մϴ�.");
				selectAll(memberDAO, session);
				break;
				
			default:
				System.out.println("1~6�������� �Է��ϼ���.");
				break;
				
			} // switch��(�θ޴�) ����
			
		} // while��(�θ޴�) ����

		return session;
		
	} // subMenu �޼��� ����

	private MemberDTO selectAll(MemberDAO memberDAO, MemberDTO session) throws SQLException {
		// DAO���� ��ü���� �ϴ� ���񽺸� �����Ѵ�. (�������� ���� ���� â)
		
		System.out.println("===================================");
		System.out.println("==========��� ȸ�� ����Դϴ�.=========");
		memberDAO.selectAll(session);
		System.out.println("===================================");
		
		return session;
	}

	private MemberDTO deleteOne(Scanner input, MemberDTO session) throws SQLException {
		// ���� �α����� ���̵�� �Է��� ��й�ȣ�� ������ ��� ȸ�� Ż�� �����Ѵ�
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId());
		
		System.out.print("Ż���Ϸ��� ȸ���� ���̵� �Է��ϼ���: ");
		String selectid = input.next();
		
		System.out.print("�ٽô� �ǵ��� �� �����ϴ�. ������ Ż���Ͻðڽ��ϱ�? Yes/No: ");
		String yn = input.next();
		
		if (yn.equalsIgnoreCase("yes")) {
			
			session.getPw();
			
			System.out.print("������ Ż���Ϸ��� ���� ��й�ȣ�� �Է��ϼ���: ");
			String selectpw = input.next();
			
			memberDAO.deleteOne(selectid, selectpw, session);
			System.out.println("==========ȸ������ ���� �޼��� ����=========");
			
		} else {
			
			System.out.println("ȸ�� ���� �޴��� ���ư��ϴ�.");
			System.out.println("========================");
			
		}
		
		return session;
		
	}

	private MemberDTO modify(Scanner input, MemberDTO session) throws SQLException {
		// ���� �α����� ���̵�� �Է��� ��й�ȣ�� ������ ��� ȸ�������� �����Ѵ�
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId());
		
		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		String pw = input.next();
		
		memberDAO.modify(pw, input, session);
		System.out.println("==========ȸ������ ���� �޼��� ����=========");
		
		return session;
		
	} // modify(�� ȸ������ ����) �޼��� ����

	private MemberDTO readOne(MemberDAO memberDAO, Scanner input, MemberDTO session) throws SQLException {
		// ���� �α����� ���̵�� �Է��� ��й�ȣ�� ������ ��� �� ȸ�������� ����
		
		System.out.println("���� �α��� �Ǿ� �ִ� ���̵�: " + session.getId());
		
		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		String pw = input.next();
		
		memberDAO.readOne(pw, session);
		System.out.println("=======ȸ������ ���� �޼��� ����======");
		
		return session;
		
	} // readOne(ȸ������ ����) �޼��� ����

	private MemberDTO login(MemberDAO memberDAO, Scanner input, MemberDTO session) throws SQLException {
		// ȸ�������� ���̵�� ��й�ȣ�� �α����Ѵ�.
		
		session = new MemberDTO();
		
		System.out.print("���̵� �Է��ϼ���: ");
		String id = input.next();
		session.setId(id);
		
		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		String pw = input.next();
		session.setPw(pw);
		
		session = memberDAO.login(session);
		System.out.println("==========�α��� �޼��� ����==========");
		
		return session;
		
	} // login(�α���) �޼��� ����

	private MemberDTO sign(MemberDAO memberDAO, Scanner input, MemberDTO session) throws SQLException {
		// Ű����� �Է��� �����͸� DTO�� ����Ͽ� �����ͺ��̽��� insert
		
		MemberDTO memberDTO = new MemberDTO(); // ��ü ����
		
		System.out.println("ȸ�������� �����մϴ�.");
		
		System.out.print("�̸��� �Է��ϼ���: ");
		memberDTO.setName(input.next());
		
		System.out.print("���̵� �Է��ϼ���: ");
		memberDTO.setId(input.next());
		
		System.out.print("��й�ȣ�� �Է��ϼ���: ");
		memberDTO.setPw(input.next());
		
		memberDAO.sign(memberDTO); // ������ ���� ��ü�� DAO���� ����
		System.out.println("=======ȸ�� ���� �޼��� ����========");
		
		return session;
		
	} // sign(ȸ������) �޼��� ����

} // class ����
