package ch01;

import java.util.Scanner;

public class StringEqualsExam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// String strval1 = in.nextLine();
		// String strval2 = in.nextLine();
		// String strval3 = new String(in.nextLine());
		
		System.out.print("이름을 입력하세요 : ");
		String name = in.nextLine();
		System.out.print("나이를 입력하세요 : ");
		String age = in.nextLine();
		System.out.print("이메일을 입력하세요 : ");
		String email = in.nextLine();
		
		System.out.println(name + "님 해킹 당하신 것을 축하드립니다.");
		System.out.println("당신의 나이가 " + age + "이군요");
		System.out.println(email + "주소 잘 사용하겠습니다. 감사드립니다.");

	}

}
