package ch01;

public class AccuracyExam {

	public static void main(String[] args) {
		// ��� 1���� 10�������� �ɰ��� 1������ 0.1�� 1���� ��
		
		int apple = 1 ; // ��� 1��
		double pieceUnit = 0.1 ; // ���� ����
		int number = 7 ; // ��� 1����
		
		double result = apple - number * pieceUnit ;
		System.out.println("��� 7������ �� : " + result);
		// 0.29999999999999993
		
		System.out.println("7������ �� : " + number * pieceUnit);
		// 0.7000000000000001
		
		// ��Ȯ�� ����� ���ؼ��� �Ǽ� Ÿ���� ������� �ʴ� ���� ����

	}

}
