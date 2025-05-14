package ch02;

import java.util.Scanner;

public class SsnExam {

	public static void main(String[] args) {
		
		System.out.print("당신의 주민번호를 입력하시오(010101-1234567)>");
		Scanner in = new Scanner(System.in);
		String regNo = in.nextLine();
		char gender = regNo.charAt(7); // 8번째 글자를 추출
		
		// System.out.println(gender);
		
		switch(gender) {
		case '1':	case '3':	case '5':	case '7':
			System.out.println("당신은 남자입니다.");
			break;
			
		case '2':	case '4':	case '6':	case'8':
			System.out.println("당신은 여자입니다.");
			break;
			
		default:
			System.out.println("당신은 외계인입니다.");
			System.out.println("당신의 별로 돌아가세요.");
		}
	}

}
