package ch01;

public class Printf {

	public static void main(String[] args) {
		int i = 97;
		String s = "Java";
		double f = 3.14f;
		System.out.printf("%d\n", i); // 10����
		System.out.printf("%o\n", i); // 8����
		System.out.printf("%x\n", i); // 16����
		System.out.printf("%c\n", i); // char
		System.out.printf("%5d\n", i); // 5ĭ �� �����ʿ� ���� �տ��� �����
		System.out.printf("%05d\n", i); // 5ĭ �� �����ʿ� ���� �տ��� 0���� ä��
		System.out.printf("%s\n", s); // ���ڿ� ���
		System.out.printf("%5s\n", s); // 5ĭ �� �����ʿ� ���� �տ� �����
		System.out.printf("%-5s\n", s);	// 5ĭ �� �տ������� ������ �ڿ��� �����
		System.out.printf("%f\n", f);
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f); // 4ĭ �� �����ʿ� ������ �Ҽ��� ù��° �ڸ������� ���� �տ��� �����
		System.out.printf("%04.1f\n", f); // 4ĭ �� �Ҽ��� ù��° �ڸ������� ���� �տ��� 0���� ä��
		System.out.printf("%-4.1f\n", f); // 4ĭ �� �տ������� ������ �Ҽ��� ù��° �ڸ������� ���� �ڿ��� �����

	}

}
