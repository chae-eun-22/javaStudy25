package ch01;

public class CastingExam {

	public static void main(String[] args) {
		// ���� Ÿ�� ��ȯ
		// ū ũ���� Ÿ���� ���� ũ���� Ÿ������ �ڵ���ȯ �� �� ����.
		// int(21��) -> byte Ÿ������ ������ ������ �߻��Ѵ�.
		// �̰��� ������ �߻��ص� ������ �����ϴ� ���� ���� Ÿ�� ��ȯ�̶�� ��.
		
		int intValue = 123456789 ;
		byte byteValue = (byte) intValue ; // ������ byte Ÿ������ ��ȯ
		// Type mismatch: cannot convert from int to byte
		
		System.out.println("int Ÿ�� �� ��� : " + intValue);
		System.out.println("byte Ÿ�� �� ��� : " + byteValue);
		// byte Ÿ���� 8bit�� ����� �տ� ���� ����������.
		// 1110101101111001101000010101
		//				       00010101 -> 21
		
		int kor = 100 ;
		int eng = 99 ;
		int mat = 97 ;

		int total = kor + eng + mat ;
		
		System.out.println("============ ����ǥ ============");
		System.out.println("���� + ���� + ���� = ���� : " + total);
		
		double avg = total / 3 ; // �ڵ�Ÿ�� ��ȯ��
		System.out.println("��� ����(�ڵ�Ÿ�Ժ�ȯ) : " + avg);
		// �����߻� : � ���� ����ص� �Ҽ����� 0���� ����
		// ���� : int Ÿ�� total�� 3���� ��������
		// �����ذ� : double Ÿ������ ����Ÿ�� ��ȯ �Ŀ� 3���� ������� ��
		
		avg = (double) total / 3 ; // ����Ÿ�� ��ȯ��
		System.out.println("��� ����(����Ÿ�Ժ�ȯ) : " + avg);

	}

}
