package ch01;

import java.util.Scanner;

public class StringEqualsExam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// String strval1 = in.nextLine();
		// String strval2 = in.nextLine();
		// String strval3 = new String(in.nextLine());
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = in.nextLine();
		System.out.print("���̸� �Է��ϼ��� : ");
		String age = in.nextLine();
		System.out.print("�̸����� �Է��ϼ��� : ");
		String email = in.nextLine();
		
		System.out.println(name + "�� ��ŷ ���Ͻ� ���� ���ϵ帳�ϴ�.");
		System.out.println("����� ���̰� " + age + "�̱���");
		System.out.println(email + "�ּ� �� ����ϰڽ��ϴ�. ����帳�ϴ�.");

	}

}
