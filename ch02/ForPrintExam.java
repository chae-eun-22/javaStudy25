package ch02;

public class ForPrintExam {

	public static void main(String[] args) {

		/*
		 * for (int i = 1; i <= 10; i++) { System.out.println("1~10까지 출력" + i); }
		 */

		/*
		 * for (int i = 2; i <= 10; i = i + 2) { System.out.println("1~10까지 짝수만 출력: " +
		 * i); }
		 */
		
		for(int i=0, j=100; i<=10 && j >=90; i++, j--) {
			System.out.println("i값의 증가: " + i + "// j값의 감소: " + j);
		}

	}

}
