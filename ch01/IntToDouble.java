package ch01;

public class IntToDouble {

	public static void main(String[] args) {
		// intŸ�԰� floatŸ���� ���� 32bit�� ���������
		// float�� �Ҽ����� ����ϱ� ������ ���� ������ �Ͼ

		// float���� ū double�� ����Ͽ� �ذ��غ���.

		int num1 = 123456780 ;
		int num2 = 123456780 ;

		double num3 = num2 ; // intŸ�� ���� float�� ����
		num2 = (int) num3 ; // ������ ������ ������ ���� �ٽ� ����
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2); // num2 : 123456784
		System.out.println("num3 : " + num3);
		// num3 : 1.23456784E8 -> ������������ E���� ���ڸ� �ε� �Ҽ��� ó��
		//		  12.3456784E7
		//		  1234567.84E2
		
		int result = num1 - num2 ;
		System.out.println("double���� �ٳ�� �Ŀ� num2 �� ����ȵ�");
		System.out.println("num1 - num2 : " + result);

	}

}
