package ch04;

import java.util.Scanner;

public class Member {
	// 회원용 객체로 main 메서드는 Exam에서 진행
	// 클래스의 기본 속성은 3가지가 필요하다.
	// 필드, 생성자, 메서드
	
	// 필드: 객체가 가지고 있어야할 값(변수)
	// 회원번호, 아이디, 이름, 비밀번호, 이메일 주소, 집주소, 전화번호
	
	public int mno;
	public String id;
	public String pw;
	
	// 생성자: Exam 클래스에서 main() 메서드에서 new로 호출할 때
	public Member() {
		// 기본 생성자: 클래스명과 같은 메서드
		// Member member = new Member();
	} // Member 메서드 종료
	
	// 메서드: Member 클래스에서 행해지는 동작 CRUD
	public Member memberAdd(Scanner input) { // main에서 전달된 스캐너 객체
		Member member = new Member(); // 리턴용 객체
		
		System.out.println("===================");
		System.out.println("회원가입용 메서드입니다.");
		
		System.out.print("회원번호를 입력하세요: ");
		member.mno = input.nextInt();
		
		System.out.print("아이디를 입력하세요: ");
		member.id = input.next();
		
		System.out.print("비밀번호를 입력하세요: ");
		member.pw = input.next();
		
		return member;
	}
	
	public void memberAllList(Member[] members) {
		
		System.out.println("===================");
		System.out.println("모든 회원 보기 리스트");
		
		for(int i = 0; i < members.length; i++) {
			
			System.out.println("회원번호: " + members[i].mno);
			System.out.println("회원 id: " + members[i].id);
			System.out.println("회원 pw: " + members[i].pw);
			System.out.println("===================");
		} // for문 종료
	} // memberAllList 종료
	
	public void memberLogin(Scanner input, Member[] members) {
		
		System.out.println("===================");
		System.out.println("로그인 메서드입니다.");
		
		System.out.print("아이디를 입력하세요: ");
		String id = input.next();
		System.out.print("비밀번호를 입력하세요: ");
		String pw = input.next();
		
		for (int i = 0; i < members.length; i++) {
			if (id.equals(members[i].id) && pw.equals(members[i].pw)) {
				System.out.println("로그인 되었습니다.");
			} else {
				System.out.println("로그인 실패하셨습니다.");
				break;
			}
		}

	} // memberLogin 종료
	
	public void memberUpdate(Scanner input, Member[] members) {
		
		System.out.println("===================");
		System.out.println("회원 수정 메서드입니다.");
		
		System.out.print("회원정보를 수정하려면 비밀번호를 입력하세요: ");
		String pw = input.next();
		
		for (int i = 0; i < members.length;) {
			if (pw.equals(members[i].pw) && pw.equals(members[i].pw)) {
				System.out.println("회원수정이 가능합니다.");
				break;
			} else {
				System.out.println("회원수정이 불가능합니다.");
				break;
			}
		}
		
	} // memberUpdate 종료
	
	public void memberDelete() {
		
		System.out.println("===================");
		System.out.println("회원탈퇴 메서드입니다.");
		
		
		
		
	} // memberDelete 종료
}
