package ch01;

import java.util.Scanner;

public class Exam2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ��� : ");
		int num = in.nextInt();
		System.out.println(num % 2 == 0 ? "¦��" : "Ȧ��");

	}

}
