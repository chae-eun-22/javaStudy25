package ch01;

public class CheckValueCastingExam {

	public static void main(String[] args) {
		int i = 128 ;
		
		if( (i<Byte.MIN_VALUE)||(i>Byte.MAX_VALUE)) {
			// i�� ���� Byte�� �ּҰ����� �۰ų� �ִ밪���� ũ��
			System.out.println("byteŸ������ ��ȯ�� �� �����ϴ�.");
			System.out.println(Byte.MIN_VALUE + "������ �۰ų�");
			System.out.println(Byte.MAX_VALUE + "������ Ů�ϴ�.");
		} else {
			byte b = (byte) i ; // int�� byte�� ����Ÿ�Ժ�ȯ
			System.out.println(b);
		}

	}

}
