package ch01;

import java.util.Scanner;

public class LogicalExam {

	public static void main(String[] args) {
		// ������ �����ڴ� ũ�� 5���� ������ �ִ�.
		// & : �� �� -> ~�̰� (2���� ������ ��� ���� ��� ��)
		// | : �� �� -> ~�̰ų� (2������ �Ѱ��� ���̸� ��)
		// ! : ������ -> ���� ������ ������.
		// ^ : ��Ÿ�� �� �� -> ������ �������� 1+1=0���� ����̳�
		// 10-1���� ������ ���⼱ ���� ���
		
		String siid = "";
		String sipw = "123";
		String sipw2 = "123";
		
		Scanner input = new Scanner(System.in); // sc ��Ʈ�� �����̽���
		// �ֿܼ� Ű����� ���� �о� ���� ��ü ������
		
		System.out.print("���̵� �Է��ϼ��� : ");
		String id = input.nextLine();
		
		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
		String pw = input.nextLine();
		
		System.out.print("��й�ȣ�� �ѹ� �� �Է��ϼ��� : ");
		String pw2 = input.nextLine();
		
		if((sipw.equals(pw)) & sipw2.equals(pw2)) {
			// ������ �ִ� id�� Ű����� �Է��� id�� ������
			// �̰ų� or
			// ������ �ִ� pw�� Ű����� �Է��� pw�� ������
			System.out.println("��й�ȣ�� ��ġ�մϴ�.");
		} else { // if���� flase ó����
			System.out.println("��й�ȣ�� �ٸ��ϴ�.");
		} // if�� ����

	} // main �޼��� ����

} // class ����
