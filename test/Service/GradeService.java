package test.Service;

import java.util.Scanner;

import test.DTO.GradeDTO;
import test.DTO.LoginDTO;

public class GradeService {

	public boolean menu(Scanner inputStr, Scanner inputInt, boolean all, boolean session, GradeDTO[] grade, LoginDTO[] login) {
		// 성적 계산 메뉴
		
		System.out.println("성적 계산 메뉴로 이동되었습니다.");
		System.out.println("=========================");
		System.out.println("성적 계산을 시작합니다.");
		
		while(all) {
			
			System.out.println("국어 점수를 입력하세요: ");
			int kor = inputInt.nextInt();
			
			if(kor >= 0 && kor <= 100) { // 0이상 100이하 true
				System.out.println( "입력하신 국어 점수는 " + kor + "점입니다.");
			} else {
				System.out.println("입력하신 국어 점수는 " + kor + "점입니다. 다시 입력해주세요.");
			} // 국어점수 if문
			
			System.out.println("영어 점수를 입력하세요: ");
			int eng = inputInt.nextInt();
			
			if(eng >= 0 && eng <= 100) { // 0이상 100이하 true
				System.out.println("입력하신 영어 점수는 " + eng + "점입니다.");
			} else {
				System.out.println("입력하신 영어 점수는 " + eng + "점입니다. 다시 입력해주세요.");
			} // 영어 점수 if문
			
			System.out.println("수학 점수를 입력하세요: ");
			int math = inputInt.nextInt();
			
			if(math >= 0 && math <= 100) { // 0이상 100이하 true
				System.out.println( "입력하신 수학 점수는 " + math + "점입니다.");
			} else {
				System.out.println("입력하신 수학 점수는 " + math + "점입니다. 다시 입력해주세요.");
			} // 수학 점수 if문
			
			int score = kor + eng + math;
			double avg = (double)score / 3;
			
			if (avg > 0 && avg <= 100) { // 0보다 크거나 100이하이면 true
				if (avg >= 90) {
					System.out.println("총점은" + score + "점, 평균은" + avg + "점이므로 (A등급)입니다.");
					break;
				} else if (avg >= 80) {
					System.out.println("총점은" + score + "점, 평균은" + avg + "점이므로 (B등급)입니다.");
					break;
				} else if (avg >= 70) {
					System.out.println("총점은" + score + "점, 평균은" + avg + "점이므로 (C등급)입니다.");
					break;
				} else if (avg >= 60) {
					System.out.println("총점은" + score + "점, 평균은" + avg + "점이므로 (D등급)입니다.");
					break;
				} else {
					System.out.println("총점은" + score + "점, 평균은" + avg + "점이므로 (F등급)입니다.");
					
					break;
				}
			} else {
				System.out.println("0~100까지만 입력 가능합니다. 국어 점수부터 다시 입력해주세요.");
			} // 평균 등급 if문 종료
			
		} // while문 종료
		
		return session;
		
	} // 성적 계산 메뉴 종료

} // class 종료
