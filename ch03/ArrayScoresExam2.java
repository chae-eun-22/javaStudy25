package ch03;

import java.util.Scanner;

public class ArrayScoresExam2 {

	public static void main(String[] args) {
		// 주메뉴 구현용
		Scanner mainSC = new Scanner(System.in);
		int select = 0;
		System.out.print("초기작업 = 학생 수를 입력하세요: ");
		int count = mainSC.nextInt(); // 학생수 등록
		String[] name = new String[count]; // 학생수로 학생 이름 테이블 작성
		byte[] engScores = new byte[count]; // 학생수로 영어 성적 테이블 작성
		byte[] korScores = new byte[count]; // 학생수로 국어 성적 테이블 작성
		int[] totalScores = new int[count]; // 학생수로 총점 성적 테이블 작성
		double[] avgScores = new double[count]; // 학생수로 평균 테이블 작성
		boolean run = true;
		while (run) {
			System.out.println("=====MBC 교육센터 성적 관리 프로그램=====");
			System.out.println("1. 학생관리 | 2. 성적관리 | 3. 통계 | 4. 종료");
			System.out.println("========================================");
			System.out.print(">>>");
			select = mainSC.nextInt(); // 1~4까지 정수 입력 후에 분기
			switch (select) {
			case 1 -> student(name);
			case 2 -> scores(engScores, korScores, name);
			case 3 -> totalScores(totalScores, engScores, korScores, name);
			case 4 -> {
				System.out.println("성적처리 고생하셨습니다.");
				run = false;
			} // 케이스 4 종료
			} // 주메뉴 switch문 종료
		} // 와일문 종료
	} // 메인 메서드 종료

	private static String[] student(String[] name) {
		// 학생관리용 CRUD
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("==========학생 관리 메뉴==========");
			System.out.println("1. 등록 | 2. 보기 | 3. 수정 | 4. 삭제 | 5. 성적관리");
			System.out.println("=============================================");
			System.out.print(">>>");
			int select = studentSC.nextInt();
			switch (select) {
			case 1:
				System.out.println("학생 등록을 시작합니다.");
				System.out.println("총 학생 수는 " + name.length);
				for (int i = 0; i < name.length; i++) {
					System.out.print((i + 1) + "번째 학생의 이름을 입력하세요: ");
					name[i] = studentSC.next();
				} // 키보드 문자로 받은 값을 배열[i]에 넣는다.
				System.out.println("학생 등록 완료");
				break;

			case 2:
				System.out.println("학생 명부를 불러옵니다.");
				System.out.println("총 학생 수는 " + name.length);
				for (int i = 0; i < name.length; i++) {
					System.out.println((i + 1) + "번: " + name[i]);
				}
				break;

			case 3:
				System.out.println("학생 이름을 수정합니다.");
				System.out.print("수정할 학생 번호를 입력하세요: ");
				int nameNum = studentSC.nextInt();
				System.out.print("학생 이름을 입력하세요: ");
				String nameMOD = studentSC.next();
				name[nameNum - 1] = nameMOD;
				System.out.println("수정완료");
				break;

			case 4:
				System.out.print("삭제할 학생 번호를 입력하세요: ");
				int deleteNum = studentSC.nextInt();
				name[deleteNum - 1] = null;
				break;

			case 5:
				System.out.println("성적 관리 메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("입력값 오류: 1~4번만 입력하세요.");
			} // 스위치문 종료
		} // 와일 문 종료
		return name;
	} // String[]student 종료

	private static void scores(byte[] engScores, byte[] korScores, String[] name) {
		// 성적관리용 부 메뉴
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("=====성적 관리 메뉴=====");
			System.out.println("1. 영어 성적 | 2. 국어 성적 | 3. 메인 메뉴");
			System.out.println("====================================");
			System.out.print(">>>");
			int select = studentSC.nextInt();
			switch (select) {
			case 1:
				scores(engScores, name);
				break;

			case 2:
				scores2(korScores, name);
				break;

			case 3:
				System.out.println("메인 메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("입력값 오류: 1~3번만 입력하세요.");
			} // switch문 종료
		} // while문 종료
	} // scores 메서드 종료

	private static void scores2(byte[] korScores, String[] name) {
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("==========국어 성적 메뉴=========");
			System.out.println("1. 등록 | 2. 보기 | 3. 수정 | 4. 삭제 | 5. 성적관리");
			System.out.println("=============================================");
			System.out.print(">>>");
			int select = studentSC.nextInt();
			switch (select) {
			case 1:
				System.out.println("국어 성적 등록을 시작합니다.");
				for (int i = 0; i < korScores.length; i++) {
					System.out.print(name[i] + "학생의 성적을 입력하세요: ");
					korScores[i] = studentSC.nextByte();
				} // 키보드 문자로 받은 값을 배열[i]에 넣는다.
				System.out.println("국어 성적 등록 완료");
				break;

			case 2:
				System.out.println("국어 성적을 불러옵니다.");
				for (int i = 0; i < korScores.length; i++) {
					int rank = 1;
					for (int a = 0; a < korScores.length; a++) {
						if (korScores[i] < korScores[a]) {
							rank++;
						} // rank if문 종료
					} // rank 계산 for문 종료
					System.out.println(name[i] + "학생은 " + korScores[i] + "점 이고, 등수는 " + rank + "위입니다.");
				}
				int max = korScores[0], min = korScores[0];
				for (int i = 1; i < korScores.length; i++) {
					if (korScores[i] > max) {
						max = korScores[i];
					} else if (korScores[i] < min) {
						min = korScores[i];
					}
				}
				System.out.println("최고 점은 " + max + "점입니다.");
				System.out.println("최하 점은 " + min + "점입니다.");
				break;

			case 3:
				System.out.println("국어 성적을 수정합니다.");
				System.out.print("수정할 학생 번호를 입력하세요: ");
				int nameNume = studentSC.nextInt();
				System.out.println("수정할 " + name[nameNume - 1] + "의 국어 성적은 " + korScores[nameNume - 1] + "점입니다.");
				System.out.print("국어 성적을 입력하세요: ");
				byte engGRADE = studentSC.nextByte();
				korScores[nameNume - 1] = engGRADE;
				System.out.println("수정완료");
				break;

			case 4:
				System.out.print("삭제할 학생 번호를 입력하세요: ");
				int deleteNum = studentSC.nextInt();
				korScores[deleteNum - 1] = 0;
				break;

			case 5:
				System.out.println("성적 관리 메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("입력값 오류: 1~4번만 입력하세요.");
			} // 스위치문 종료
		} // 와일문 종료
		return;
	} // 국어 성적 종료

	private static void scores(byte[] engScores, String[] name) {
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("==========영어 성적 메뉴==========");
			System.out.println("1. 등록 | 2. 보기 | 3. 수정 | 4. 삭제 | 5. 성적관리");
			System.out.println("=============================================");
			System.out.print(">>>");
			int select = studentSC.nextInt();
			switch (select) {
			case 1:
				System.out.println("영어 성적 등록을 시작합니다.");
				for (int i = 0; i < engScores.length; i++) {
					System.out.print(name[i] + "학생의 성적을 입력하세요: ");
					engScores[i] = studentSC.nextByte();
				} // 키보드 문자로 받은 값을 배열[i]에 넣는다.
				System.out.println("영어 성적 등록 완료");
				break;

			case 2:
				System.out.println("영어 성적을 불러옵니다.");
				for (int i = 0; i < engScores.length; i++) {
					int rank = 1;
					for (int a = 0; a < engScores.length; a++) {
						if (engScores[i] < engScores[a]) {
							rank++;
						} // rank if문 종료
					} // rank 계산 for문 종료
					System.out.println(name[i] + "학생은" + engScores[i] + "점 이고, 등수는 " + rank + "위입니다.");
				}
				int max = engScores[0], min = engScores[0];
				for (int i = 1; i < engScores.length; i++) {
					if (engScores[i] > max) {
						max = engScores[i];
					} else if (engScores[i] < min) {
						min = engScores[i];
					}
				}
				System.out.println("최고점은 " + max + "점입니다.");
				System.out.println("최하점은 " + min + "점입니다.");
				break;

			case 3:
				System.out.println("영어 성적 수정");
				System.out.print("수정할 학생 번호를 입력하세요: ");
				int nameNum = studentSC.nextInt();
				System.out.println("수정할 " + name[nameNum - 1] + "의 영어 성적은 " + engScores[nameNum - 1] + "점입니다.");
				System.out.print("영어 성적을 입력하세요: ");
				byte engGRADE = studentSC.nextByte();
				engScores[nameNum - 1] = engGRADE;
				System.out.println("수정완료");
				break;

			case 4:
				System.out.print("삭제할 학생 번호를 입력하세요: ");
				int deleteNum = studentSC.nextInt();
				engScores[deleteNum - 1] = 0;
				break;

			case 5:
				System.out.println("메인 메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("입력값 오류: 1~5번만 입력하세요.");
			} // 스위치문 종료
		} // 와일문 종료
	} // 영어 성적 종료

	private static void totalScores(int[] totalScores, byte[] engScores, byte[] korScores, String[] name) {
		Scanner studentSC = new Scanner(System.in);
		boolean run = true;
		while (run) {
			System.out.println("=====성적관리 메뉴=====");
			System.out.println("1. 전체 성적 처리 | 2. 개인 성적 검색 | 3. 메인 메뉴");
			System.out.println("==============================================");
			System.out.print(">>>");
			int select = studentSC.nextInt();
			switch (select) {
			case 1:
				totalScores2(totalScores, engScores, korScores, name);
				break;

			case 2:
				searchScores2(totalScores, engScores, korScores, name);
				break;

			case 3:
				System.out.println("메인 메뉴로 돌아갑니다.");
				run = false;
				break;

			default:
				System.out.println("입력값 오류: 1~3번만 입력하세요.");
			} // switch문 종료
		} // while문 종료
	} // 총합 메서드 종료

	private static void totalScores2(int[] totalScores, byte[] engScores, byte[] korScores, String[] name) {
		System.out.println("=====전체 성적을 처리합니다.=====");
		System.out.println("개개인의 영어 성적과 국어 성적을 합계합니다.");
		for (int i = 0; i < totalScores.length; i++) {
			totalScores[i] = engScores[i] + korScores[i];
			System.out.println(name[i] + "학생의 총 점: " + totalScores[i] + " | 평균" + totalScores[i] / 2);
		} // 합계 및 평균 for문 종료
		int max = totalScores[0], min = totalScores[0];
		for (int i = 0; i < totalScores.length; i++) {
			if (totalScores[i] > max) {
				max = totalScores[i];
			} else if (totalScores[i] < min) {
				min = totalScores[i];
			}
		} // 최고점수 최하점수 출력문 종료
		System.out.println("최고 총점은 " + max + "점 이고, 최하 총점은 " + min + "입니다.");
		System.out.println("최고 평균은 " + (max / 2) + "점 이고, 최하 평균은 " + (min / 2) + "입니다.");
		System.out.println("전체 학생의 총점과 평균이 처리되었습니다.");
	} // 전체 성적 처리 종료

	private static void searchScores2(int[] totalScores, byte[] engScores, byte[] korScores, String[] name) {
		Scanner studentSC = new Scanner(System.in);
		System.out.print("검색하실 학생의 번호를 입력해주세요: ");
		int i = studentSC.nextInt();
		System.out.println(name[i - 1] + "학생의 성적");
		System.out.println("영어 점수: " + engScores[i - 1]);
		System.out.println("수학 점수: " + korScores[i - 1]);
		System.out.println("총 점수: " + totalScores[i - 1] + "점");
		System.out.println("평균: " + (totalScores[i - 1] / 2) + "점");
		int rank = 1;
		for (int a = 0; a < totalScores.length; a++) {
			if (totalScores[i - 1] > totalScores[a]) {
				rank++;
			} // rank if문 종료
		} // rank 계산 for문 종료
		System.out.println("클래스에서의 순위는: " + rank + "위입니다.");
	} // 개인 성적 검색 종료

} // 클래스 종료
