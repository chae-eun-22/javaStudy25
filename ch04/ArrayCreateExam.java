package ch04;

public class ArrayCreateExam {

	public static void main(String[] args) {
		int total1 = odd(new int[] {70, 80, 90});
		int total2 = odd(new int[] {60, 70, 80});
		int total3 = odd(new int[] {90, 80, 70});
		System.out.println("1반의 총합: " + total1);
		System.out.println("2반의 총합: " + total2);
		System.out.println("3반의 총합: " + total3);

	}

	private static int odd(int[] scores) {
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += scores[i];
		}
		return sum;
	}

	
}
