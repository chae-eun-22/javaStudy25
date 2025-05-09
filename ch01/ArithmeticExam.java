package ch01;

public class ArithmeticExam {

	public static void main(String[] args) {
		int v1 = 5 ;
		int v2 = 2 ;
		int result1 = v1 + v2 ;
		System.out.println("result1 = " + result1); // int 타입의 7
		
		int result2 = v1 - v2 ;
		System.out.println("result2 = " + result2); // int 타입의 3
		
		int result3 = v1 * v2 ;
		System.out.println("result3 = " + result3); // int 타입의 10
		
		int result4 = v1 / v2 ;
		System.out.println("result4 = " + result4); // int 타입의 2
		
		int result5 = v1 % v2 ;
		System.out.println("result5 = " + result5); // int 타입의 1
		
		double result6 = (double) v1 / v2 ;
		System.out.println("result6 = " + result6); // int 타입의 2.5

	}

}
