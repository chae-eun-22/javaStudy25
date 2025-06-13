package Member.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

import Member.DTO.MemberDTO;

public class MemberDAO {
	// ȸ���� db�� ������ ���
	// 1�ܰ�: Connect ��ü�� ����Ͽ� ojdbc6.jar�� ����
	// 2�ܰ�: url, id, pw, sql �������� �ۼ�
	// 3�ܰ�: �������� ����
	// 4�ܰ�: ������ ���� ����� ����
	// 5�ܰ�: ���� ���Ḧ ����

	// �ʵ�
	public MemberDTO memberDTO = new MemberDTO();
	public Connection connection = null; // 1�ܰ迡�� ����ϴ� ��ü
	public Statement statement = null; // 3�ܰ迡�� ����ϴ� ��ü(����), ���� ���� ó�� '" + name + "'
	public PreparedStatement preparedStatement = null; // 3�ܰ迡�� ����ϴ� ��ü(����), ?(���Ķ����)
	public ResultSet resultSet = null; // 4�ܰ迡�� ��� �޴� ǥ ��ü executeQuery(selet ���)
	public int result = 0; // 4�ܰ迡�� ��� �޴� ���� executeUpdate(insert, update, delete)
	// 1���� ���� ���� | ���� | �����Ǿ����ϴ�. (����ó�� -> commit)
	// 0���� ���� ���� | ���� | �����Ǿ����ϴ�. (������ó�� -> rollback)

	// �⺻ ������
	public MemberDAO() {

		try { // ���ܰ� �߻��� �� �ִ� ���๮
				// ���α׷� ���� ���� ó����

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 1�ܰ� ojdbc6.jar ȣ��
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.153:1521:xe", "test", "test"); // 2�ܰ�

		} catch (ClassNotFoundException e) {

			System.out.println("����̹� �̸��̳�, ojdbc6.jar ������ �߸��Ǿ����ϴ�.");
			e.printStackTrace(); // ������ ����
			System.exit(0); // ���� ����

		} catch (SQLException e) {

			System.out.println("url, id, pw�� �߸��Ǿ����ϴ�. BoardDAO�� �⺻ �����ڸ� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����
			System.exit(0); // ���� ����

		}

	} // �⺻ ������ ����

	// �޼���
	public void sign(MemberDTO memberDTO) throws SQLException {
		// ȸ������

		try {

			String sql = "insert into member(mno, name, id, pw, regidate)"
					+ "values(board_seq.nextval, ?, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberDTO.getName());
			preparedStatement.setString(2, memberDTO.getId());
			preparedStatement.setString(3, memberDTO.getPw());

			result = preparedStatement.executeUpdate(); // ������ ���� �� ����� ������ ����

			if (result > 0) {

				System.out.println(memberDTO.getName() + "�� ȸ�����Կ� �����ϼ̽��ϴ�.");
				connection.commit(); // ���� ����

			} else {

				System.out.println(memberDTO.getName() + "�� ȸ�����Կ� �����ϼ̽��ϴ�.");
				connection.rollback();

			} // if�� ����

		} catch (SQLIntegrityConstraintViolationException e) {

			System.out.println("������ ���̵� �־� ȸ�����Կ� �����߽��ϴ�. ȸ�� ���� �޴��� �̵��մϴ�.");

		} catch (SQLException e) {

			System.out.println("���� �߻�: sign() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����

		} finally {

			preparedStatement.close();

		}

	} // sign(ȸ������) �޼��� ����

	public MemberDTO login(MemberDTO session) throws SQLException {
		// ȸ�������� ���̵�� ��й�ȣ�� �α����Ѵ�(���̵� ��й�ȣ ���Ͻ� �α���)

		try {

			String sql = "select * from member where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			preparedStatement.setString(2, session.getPw());

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				session.setMno(resultSet.getInt("mno"));
				session.setName(resultSet.getString("name"));
				session.setId(resultSet.getString("id"));
				session.setPw(resultSet.getString("pw"));
				session.setRegidate(resultSet.getDate("regidate"));

				System.out.println(session.getName() + "�� �α��ο� �����ϼ̽��ϴ�.");
				connection.commit(); // ���� ����

				return session;

			} else {

				System.out.println("�α��ο� �����ϼ̽��ϴ�.");
				connection.rollback();
			}

		} catch (SQLException e) {

			System.out.println("���� �߻�: login() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����

		} finally {

			preparedStatement.close();
			resultSet.close();

		}

		return session;

	} // login(�α���) �޼��� ����

	public MemberDTO readOne(String pw, MemberDTO session) throws SQLException {
		// ���� �α����� ���̵�� �Է��� ��й�ȣ�� ������ ��� �� ȸ������ Ȯ��

		try {

			String sql = "select mno, name, id, pw, regidate from member where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getId());
			preparedStatement.setString(2, pw);
			
			resultSet = preparedStatement.executeQuery(); // ������ ���� �� ����� ǥ�� �޴´�

			if (resultSet.next()) { // �˻� ����� ������

				MemberDTO memberDTO = new MemberDTO(); // �� ��ü ����

				memberDTO.setMno(resultSet.getInt("mno"));
				memberDTO.setName(resultSet.getString("name"));
				memberDTO.setId(resultSet.getString("id"));
				memberDTO.setPw(resultSet.getString("pw"));
				memberDTO.setRegidate(resultSet.getDate("regidate"));
				// ������ ���̽��� �ִ� ���� ��ü�� �ֱ� �Ϸ�

				System.out.println("===============================");
				System.out.println("��ȣ: " + memberDTO.getMno());
				System.out.println("�̸�: " + memberDTO.getName());
				System.out.println("���̵�: " + memberDTO.getId());
				System.out.println("��й�ȣ: " + memberDTO.getPw());
				System.out.println("���� ��¥:" + memberDTO.getRegidate());

			} else { // �˻� ����� ������

				System.out.println(session.getName() + "�� ȸ�������� �� �� �����ϴ�.");

			} // if�� ����

		} catch (SQLException e) {

			System.out.println("���� �߻�: login() �޼��带 Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����

		} finally {

			resultSet.close();
			preparedStatement.close();

		}

		return session;

	} // readOne(�� ȸ������ Ȯ��) �޼��� ����

	public MemberDTO modify(String pw, Scanner input, MemberDTO session) throws SQLException {
		// ���� �α����� ���̵�� �Է��� ��й�ȣ�� ������ ��� ȸ�������� �����Ѵ�

		System.out.println("[������ �� �ִ� �� ��й�ȣ���Դϴ�.]");

		System.out.print("������ ��й�ȣ: ");
		session.setPw(input.next());

		try {

			String sql = "update member set pw=? where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, session.getPw());
			preparedStatement.setString(2, session.getId());
			preparedStatement.setString(3, pw);

			result = preparedStatement.executeUpdate(); // ������ ���� �� ����� ������ ������

			if (result > 0) {

				System.out.println(session.getName() + "�� ��й�ȣ�� ����Ǿ����ϴ�.");
				connection.commit(); // ���� ����

			} else {

				System.out.println(session.getName() + "�� ��й�ȣ ���濡 �����ϼ̽��ϴ�.");
				connection.rollback();

			} // if�� ����

		} catch (SQLException e) {

			System.out.println("���� �߻�: modify() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����

		} finally {

			preparedStatement.close();

		}

		return session;

	} // modify(�� ȸ������ ����) �޼��� ����

	public MemberDTO deleteOne(String selectid, String selectpw, MemberDTO session) throws SQLException {
		// ���� �α����� ���̵�� �Է��� ��й�ȣ�� ������ ��� ȸ�� Ż�� �����Ѵ�

		try {

			String sql = "delete from member where id=? and pw=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, selectid);
			preparedStatement.setString(2, selectpw);

			result = preparedStatement.executeUpdate(); // ������ ���� �� ����� ������ ����

			if (result > 0) {

				System.out.println(session.getName() + "�� ȸ�� Ż��Ǿ����ϴ�. �ȳ���������.");
				connection.commit(); // ���� ����

			} else {

				System.out.println(session.getName() + "�� ȸ�� Ż�� �����ϼ̽��ϴ�.");
				connection.rollback();

			}

			System.out.println("============================");
			selectAll(session); // ���� �� ��ü ����Ʈ ����(Ȯ�ο�)

		} catch (SQLException e) {

			System.out.println("���� �߻�: deleteOne() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����

		} finally {

			preparedStatement.close();

		}

		return session;

	} // deleteOne(ȸ�� Ż��) �޼��� ����

	public MemberDTO selectAll(MemberDTO session) throws SQLException {
		// SQL�� ����Ͽ� ��ü ��� ���� ��� ���

		try {

			String sql = "select mno, name, id, pw, regidate from member order by regidate desc";
			// �����ͺ��̽��� member ���̺� ������ �������� ������

			statement = connection.createStatement(); // �������� ���� ��ü ����
			resultSet = statement.executeQuery(sql); // �������� �����Ͽ� ����� ǥ�� �޴´�.

			System.out.println("��ȣ\t �̸�\t ��й�ȣ\t ���Գ�¥\t");

			while (resultSet.next()) { // ��� ǥ�� ���������� �Ʒ����� �������鼭 ���

				System.out.print(resultSet.getInt("mno") + "\t");
				System.out.print(resultSet.getString("name") + "\t");
				System.out.print(resultSet.getString("id") + "\t");
				System.out.print(resultSet.getString("pw") + "\t");
				System.out.println(resultSet.getDate("regidate") + "\t");

			}

			System.out.println("==========��� ȸ�� ��� ���� �޼��� ����=========");

		} catch (SQLException e) { // ���� �߻��� ���� ó����

			System.out.println("selectAll() �޼��忡 �������� �߸��Ǿ����ϴ�.");
			e.printStackTrace(); // ������ ����

		} finally { // �׻� ���๮

			resultSet.close();
			statement.close();
			// ���� ��ü�� �ݾƾ� �ٸ� �޼��嵵 ���� �۵���

		}

		return session;

	} // selectAll(��� ȸ������ ����) �޼��� ����

}
