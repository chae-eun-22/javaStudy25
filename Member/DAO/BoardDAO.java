package Member.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Member.DTO.BoardDTO;
import Member.DTO.MemberDTO;

public class BoardDAO {
	// �Խ����� db�� ������ ���
	// 1�ܰ�: Connect ��ü�� ����Ͽ� ojdb6.jar�� ����
	// 2�ܰ�: url, id, pw, sql �������� �ۼ�
	// 3�ܰ�: �������� ����
	// 4�ܰ�: ������ ���� ����� ����
	// 5�ܰ�: ���� ���Ḧ ����

	// �ʵ�
	public BoardDTO boardDTO = new BoardDTO();
	public Connection connection = null; // 1�ܰ迡�� ����ϴ� ��ü
	public Statement statement = null; // 3�ܰ迡�� ����ϴ� ��ü(����), ���� ���� ó�� '" + name "'
	public PreparedStatement preparedStatement = null; // 3�ܰԿ��� ����ϴ� ��ü(����), ?(���Ķ����)
	public ResultSet resultSet = null; // 4�ܰ迡�� ��� �޴� ǥ ��ü executeQuery(select ���)
	public int result = 0; // 4�ܰ迡�� ��� �޴� ���� execouteUpdate(insert, update, delete)
	// 1���� ���� ���� | ���� | �����Ǿ����ϴ�. (����ó�� -> commit)
	// 0���� ���� ���� | ���� | �����Ǿ����ϴ�. (������ó�� -> rollback)
	
	// �⺻ ������
	public BoardDAO() {
		
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
	public MemberDTO insertBoard(BoardDTO boardDTO, MemberDTO session) throws SQLException {
		// jdbc�� �̿��Ͽ� insert ������ ó��
		// PreparedStatement���� ����غ���
		// ���� �������̶�� �ϰ� ?�� ����ؼ� ���ͷ� �Է�
		
		try {
			
			String sql = "insert into board(bno, btitle, bcontent, bwriter, bdate) "
					+ " values(board_seq.nextval, ?, ?, ?, sysdate)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle()); // ù��° ?�� DTO ��ü�� �ִ� ������ ����
			preparedStatement.setString(2, boardDTO.getBcontent()); // �ι�° ?�� DTO ��ü ���� ����
			preparedStatement.setString(3, boardDTO.getBwriter()); // ����° ?�� DTO ��ü ���̵� ����
			
			
			result = preparedStatement.executeUpdate(); // ������ �����ؼ� ����� ������ ����
			// result = preparedStatement.executeUpdate(sql); ���� �߻�
			
			if (result > 0) {
				
				System.out.println(result + "���� �Խù��� ��ϵǾ����ϴ�.");
				connection.commit(); // ���� ����
				
			} else {
				
				System.out.println("���� ���� ���: " + result);
				System.out.println("�Խù� ��Ͽ� �����ϼ̽��ϴ�.");
				connection.rollback(); // �ѹ�(���� ���)
				
			} // if�� ����
			
		} catch (SQLException e) {
			
			System.out.println("���� �߻�: insertBoard() �޼��忡 �������� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����
			
		} finally { // ���� �߻� �� ���� ���� �� ������ ó���Ǵ� ���๮
			
			preparedStatement.close();
			
		}
		
		return session;
		
	} // insertBoard(�Խñ� �ۼ�) �޼��� ����

	public MemberDTO readOne(String title, MemberDTO session) throws SQLException {
		// ���� ���ڿ��� �Ѿ�� ���� select ó���Ͽ� ���
		
		try {
			
			String sql = "select bno, btitle, bcontent, bwriter, bdate from board where btitle=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, title); // service���� �Ѿ�� ã�� ���� ������ ?�� �Ѿ��
			resultSet = preparedStatement.executeQuery(); // ������ ���� �� ����� ǥ�� �޴´�
			
			if (resultSet.next()) { // �˻� ����� ������
				
				BoardDTO boardDTO = new BoardDTO(); // �� ��ü ����
				
				boardDTO.setBno(resultSet.getInt("bno"));
				boardDTO.setBtitle(resultSet.getString("btitle"));
				boardDTO.setBcontent(resultSet.getString("bcontent"));
				boardDTO.setBwriter(resultSet.getString("bwriter"));
				boardDTO.setBdate(resultSet.getDate("bdate"));
				// ������ ���̽��� �ִ� ���� ��ü�� �ֱ� �Ϸ�
				
				System.out.println("================================");
				System.out.println("��ȣ: " + boardDTO.getBno());
				System.out.println("����: " + boardDTO.getBtitle());
				System.out.println("����: " + boardDTO.getBcontent());
				System.out.println("�ۼ���: " + boardDTO.getBwriter());
				System.out.println("�ۼ���: " + boardDTO.getBdate());
				
			} else { // �˻� ����� ������
				
				System.out.println("�ش��ϴ� �Խù��� �������� �ʽ��ϴ�.");
				
			} // if�� ����
			
		} catch (SQLException e) {
			
			System.out.println("���� �߻�: readOne() �޼��带 Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����
			
		} finally {
			
			resultSet.close();
			preparedStatement.close();
			
		}
		
		return session;
		
	} // readOne(�Խñ� �ڼ�������) �޼��� ����

	public void selectAll() throws SQLException { // throws SQLException ������ ���� ó����
		// SQL�� ����Ͽ� ��ü ��� ���� ��� ���
		
		try {
			
			String sql = "select bno, btitle, bwriter, bdate from board order by bdate desc";
			// �����ͺ��̽��� board ���̺� ������ �������� ������
			
			statement = connection.createStatement(); // �������� ���� ��ü ����
			resultSet = statement.executeQuery(sql); // �������� �����Ͽ� ����� ǥ�� �޴´�.
			
			System.out.println("��ȣ\t ����\t\t ���̵�\t\t �ۼ���");
			
			while (resultSet.next()) { // ��� ǥ�� ���������� �Ʒ����� �������鼭 ���
				
				System.out.print(resultSet.getInt("bno") + "\t");
				System.out.print(resultSet.getString("btitle") + "\t\t");
				System.out.print(resultSet.getString("bwriter") + "\t");
				System.out.println(resultSet.getDate("bdate") + "\t");
				
			}
			
			System.out.println("=============��==============");
			
		} catch (SQLException e) {
			
			System.out.println("selectAll() �޼��忡 �������� �߸��Ǿ����ϴ�.");
			e.printStackTrace(); // ������ ����
			
		} finally {
			
			resultSet.close();
			statement.close();
			// ���� ��ü�� �ݾƾ� �ٸ� �޼��嵵 ���� �۵���
			
		}
		
	} // selectAll(�Խñ� ��ü����) �޼��� ����

	public MemberDTO modify(String title, String pw, Scanner input, MemberDTO session) throws SQLException {
		// ������ ã�Ƽ� ���� �α����� ���̵� �ۼ����� ���̵�� �����ؾ� �ϰ� �Է��� ��й�ȣ�� ������ ���� �Խñ��� ������ �� �ִ�.
		
		BoardDTO boardDTO = new BoardDTO();
		
		System.out.println("[������ ������ �Է��ϼ���]");
		System.out.print("����: ");
		boardDTO.setBtitle(input.next());
		
		input.nextLine(); // ���� ����
		
		System.out.print("����: ");
		boardDTO.setBcontent(input.nextLine());
		
		try {
			
			String sql = "UPDATE board SET btitle=?, bcontent=?, bdate=sysdate " + "WHERE btitle=? AND EXISTS ("
					+ "SELECT 1 FROM member WHERE id = bwriter and pw=? and id=?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, boardDTO.getBtitle());
			preparedStatement.setString(2, boardDTO.getBcontent());
			preparedStatement.setString(3, title);
			preparedStatement.setString(4, pw);
			preparedStatement.setString(5, session.getId());
			
			result = preparedStatement.executeUpdate(); // ������ ���� �� ����� ������ ����
			
			if (result > 0) {
				
				System.out.println(session.getName() + "�� " + result + "���� �Խñ��� �����Ǿ����ϴ�.");
				connection.commit(); // ���� ����
				
			} else {
				
				System.out.println(session.getName() + "�� ������ �Խñ��� �ƴϰų� ��й�ȣ�� Ʋ�����Ƿ� �Խñ� ������ ���� �ʾҽ��ϴ�.");
				connection.rollback();
				
			} // if�� ����
			
		} catch (SQLException e) {
			
			System.out.println("���� �߻�: modify() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����
			
		} finally {
			
			preparedStatement.close();
			
		}
		
		return session;
		
	} // modify(�Խñ� ����) �޼��� ����

	public MemberDTO deleteOne(String selecttitle, String pw, MemberDTO session) throws SQLException {
		// ���񽺿��� ���� �Խù��� ������ �̿��Ͽ� ���� �α����� ���̵� �ۼ����� ���̵�� �����ؾ� �ϰ� �Է��� ��й�ȣ�� ������ ���� �Խñ��� ������ �� �ִ�.
		
		try {
			
			String sql = "delete from board where btitle=? AND EXISTS ("
					+ "SELECT 1 FROM member WHERE id = bwriter and pw=? and id=?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, selecttitle);
			preparedStatement.setString(2, pw);
			preparedStatement.setString(3, session.getId());
			
			result = preparedStatement.executeUpdate(); // ������ ���� �� ����� ������ ����
			
			if (result > 0) {
				
				System.out.println(session.getName() + "�� " + result + "���� �Խñ��� �����Ǿ����ϴ�.");
				connection.rollback();
				
			} else {
				
				System.out.println(session.getName() + "�� ������ �Խñ��� �ƴϰų� ��й�ȣ�� Ʋ�����Ƿ� �Խñ��� �������� �ʾҽ��ϴ�.");
				connection.rollback();
				
			} // if�� ����
			
		} catch (SQLException e) {
			
			System.out.println("���� �߻�: deleteOne() �޼���� sql���� Ȯ���ϼ���.");
			e.printStackTrace(); // ������ ����
			
		} finally {
			
			preparedStatement.close();
			
		}
		
		return session;
		
	} // deleteOne(�Խñ� ����) �޼��� ����

} // class ����
