package ch04;

import java.util.Scanner;

public class MemberExam {

	public static void main(String[] args) {
		// 회원가입용 코드
		
		Scanner input = new Scanner(System.in);
		
		String[] names = null;
		String[] ids = null;
		String[] pws = null;
		MemberGrade[] grades = null;
		
		
		System.out.print("몇명이 회원가입을 진행하나요?: ");
		int count = input.nextInt();
		names = new String[count];
		ids = new String[count];
		pws = new String[count];
		grades = new MemberGrade[count];
		
		for(int i = 0; i < names.length; i++) {
			System.out.println("회원가입을 진행합니다.");
			System.out.print("이름을 입력하세요: ");
			names[i] = input.next();
			System.out.print("아이디를 입력하세요: ");
			ids[i] = input.next();
			System.out.print("비밀번호를 입력하세요: ");
			pws[i] = input.next();
			
			System.out.print("등급을 고르세요: ");
			String grade = input.next();
		
			
			/*switch() {
			case 1:
				
			case 2:
				
			case 3:
				
			case 4:
			}*/
		}
	}

}
